package com.svj.zis.repository;

import com.svj.zis.model.User;
import com.svj.zis.model.Users;
import org.exist.xmldb.EXistResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Repository;
import org.xmldb.api.base.*;
import org.xmldb.api.modules.XMLResource;

import org.xmldb.api.modules.XQueryService;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;


@Repository
public class UserRepository extends ResourceRepository {

    private String collectionId = "/db/zis/users";
    private String documentId = "users.xml";
    private ClassPathResource usersXml = new ClassPathResource("xml/" + documentId);
    private ClassPathResource findUserByUsernameXQuery = new ClassPathResource("xqueries/find_user_by_username.xqy");

    /*User save(User user);

    User findByUsername(String username);
    User findByUsernameAndPassword(String username,String password);*/


    /*public TUser findByUsername(String username) {
        try {
            XMLResource resource = getResource(collectionId, documentId);

            System.out.println("[INFO] Binding XML resouce to an JAXB instance: ");


            Users users = (Users) super.unmarshaller.unmarshal(resource.getContentAsDOM());

            System.out.println("[INFO] Showing the document as JAXB instance: ");
            StringBuilder sb = new StringBuilder("");
            users.getUser().stream()
                    .forEach(us -> {
                            sb.append(", ");
                            sb.append(us.getUsername());
                        }
                    );
            System.out.println(sb.substring(2));

            return users.getUser().stream()
                    .filter(us -> us.getUsername().equals(username))
                    .findFirst().orElse(null);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }*/

    public User findByUsername(String username) throws Exception {
        Collection collection = getCollection(collectionId);
        XQueryService xQueryService = (XQueryService) collection.getService("XQueryService", "1.0");
        xQueryService.setProperty("indent", "yes");

        String path = findUserByUsernameXQuery.getFile().getPath();
        String contentStr = loadFileContent(path);
        String sadrzajUpita = String.format(contentStr, username);
        CompiledExpression compiledExpression = xQueryService.compile(sadrzajUpita);
        ResourceSet resourceSet = xQueryService.execute(compiledExpression);
        ResourceIterator i = resourceSet.getIterator();

        org.xmldb.api.base.Resource resource = null;
        if(i.hasMoreResources()) {

            try {
                resource = i.nextResource();
                XMLResource xmlResource = (XMLResource) resource;
                System.out.println("[INFO] Binding XML resouce to an JAXB instance: ");

                JAXBContext context = JAXBContext.newInstance("com.svj.zis.model");
                Unmarshaller unmarshaller = context.createUnmarshaller();
                //User user = (User) super.unmarshaller.unmarshal(xmlResource.getContentAsDOM());
                User user = (User) unmarshaller.unmarshal(xmlResource.getContentAsDOM());
                return user;
            } finally {

                // don't forget to cleanup resources
                try {
                    ((EXistResource)resource).freeResources();
                } catch (XMLDBException xe) {
                    xe.printStackTrace();
                }
            }
        }

        return null;
    }

    public void saveAll() throws Exception {
        JAXBContext context = JAXBContext.newInstance("com.svj.zis.model");
        Unmarshaller unmarshaller = context.createUnmarshaller();
        //Users users = (Users) super.unmarshaller.unmarshal(usersXml.getFile());
        Users users = (Users) unmarshaller.unmarshal(usersXml.getFile());
        super.saveAll(collectionId, documentId, users);
    }
}
