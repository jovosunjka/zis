package com.svj.zis.config;

import com.svj.zis.dto.*;
import com.svj.zis.model.Lekari;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MarshallingHttpMessageConverter;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

import java.util.Arrays;


// https://stackoverflow.com/questions/51210722/how-to-validate-xml-rest-request-in-springboot-with-jaxb

@Configuration
public class HttpMessageConverterConfiguration {

    /*@Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) throws Exception {
        RestTemplate rt = builder.requestFactory(() -> new HttpComponentsClientHttpRequestFactory())
                                .build();
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Arrays.asList(MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON));
        rt.getMessageConverters().add(0, converter);
        return rt;
    }*/

    @Bean
    public MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setSupportedMediaTypes(Arrays.asList(MediaType.TEXT_PLAIN, MediaType.TEXT_HTML, MediaType.APPLICATION_JSON));
        return converter;
    }

    @Bean
    public MarshallingHttpMessageConverter marshallingHttpMessageConverter()
    {
        MarshallingHttpMessageConverter marshallingHttpMessageConverter = new MarshallingHttpMessageConverter();

        marshallingHttpMessageConverter.setMarshaller(jaxb2Marshaller());
        marshallingHttpMessageConverter.setUnmarshaller(jaxb2Marshaller());

        return marshallingHttpMessageConverter;
    }

    @Bean
    public Jaxb2Marshaller jaxb2Marshaller()
    {
        Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
        // https://www.baeldung.com/spring-classpath-file-access
        jaxb2Marshaller.setSchemas(new ClassPathResource("xml_schema/dto.xsd"), new ClassPathResource("xml_schema/kolekcije.xsd"));
        jaxb2Marshaller.setClassesToBeBound(Userdto.class, Tokendto.class, BasicInfoDto.class, ReportDto.class,
                                            DoctorReceiptDto.class, ReviewsDto.class, UputZaLaboratorijuDto.class,
                                            UputZaSpecijalistickiPregledDto.class);
        return jaxb2Marshaller;
    }
}
