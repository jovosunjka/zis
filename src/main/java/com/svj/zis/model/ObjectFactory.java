
package com.svj.zis.model;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.svj.zis.model package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _IzvestajTerapijaLink_QNAME = new QName("http://www.svj.com/zis/dokumenti", "link");
    private final static QName _PacijentoviPodaciOsnovOslobadjanjaOdParticipacije_QNAME = new QName("http://www.svj.com/zis/osobe", "osnov_oslobadjanja_od_participacije");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.svj.zis.model
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Pregled }
     * 
     */
    public Pregled createPregled() {
        return new Pregled();
    }

    /**
     * Create an instance of {@link UputZaSpecijalistickiPregled }
     * 
     */
    public UputZaSpecijalistickiPregled createUputZaSpecijalistickiPregled() {
        return new UputZaSpecijalistickiPregled();
    }

    /**
     * Create an instance of {@link UputZaLaboratoriju }
     * 
     */
    public UputZaLaboratoriju createUputZaLaboratoriju() {
        return new UputZaLaboratoriju();
    }

    /**
     * Create an instance of {@link com.svj.zis.model.Lekar }
     * 
     */
    public com.svj.zis.model.Lekar createLekar() {
        return new com.svj.zis.model.Lekar();
    }

    /**
     * Create an instance of {@link com.svj.zis.model.Izvestaj }
     * 
     */
    public com.svj.zis.model.Izvestaj createIzvestaj() {
        return new com.svj.zis.model.Izvestaj();
    }

    /**
     * Create an instance of {@link com.svj.zis.model.Pacijent }
     * 
     */
    public com.svj.zis.model.Pacijent createPacijent() {
        return new com.svj.zis.model.Pacijent();
    }

    /**
     * Create an instance of {@link Lek }
     * 
     */
    public Lek createLek() {
        return new Lek();
    }

    /**
     * Create an instance of {@link com.svj.zis.model.ZdravstveniKarton }
     * 
     */
    public com.svj.zis.model.ZdravstveniKarton createZdravstveniKarton() {
        return new com.svj.zis.model.ZdravstveniKarton();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    /**
     * Create an instance of {@link LekarskiRecept }
     * 
     */
    public LekarskiRecept createLekarskiRecept() {
        return new LekarskiRecept();
    }

    /**
     * Create an instance of {@link com.svj.zis.model.Pacijent.Obavestenja }
     * 
     */
    public com.svj.zis.model.Pacijent.Obavestenja createPacijentObavestenja() {
        return new com.svj.zis.model.Pacijent.Obavestenja();
    }

    /**
     * Create an instance of {@link com.svj.zis.model.Izvestaj.Terapija }
     * 
     */
    public com.svj.zis.model.Izvestaj.Terapija createIzvestajTerapija() {
        return new com.svj.zis.model.Izvestaj.Terapija();
    }

    /**
     * Create an instance of {@link com.svj.zis.model.Izvestaj.Anamneza }
     * 
     */
    public com.svj.zis.model.Izvestaj.Anamneza createIzvestajAnamneza() {
        return new com.svj.zis.model.Izvestaj.Anamneza();
    }

    /**
     * Create an instance of {@link Pregledi }
     * 
     */
    public Pregledi createPregledi() {
        return new Pregledi();
    }

    /**
     * Create an instance of {@link Pregled.Lekar }
     * 
     */
    public Pregled.Lekar createPregledLekar() {
        return new Pregled.Lekar();
    }

    /**
     * Create an instance of {@link Pregled.Pacijent }
     * 
     */
    public Pregled.Pacijent createPregledPacijent() {
        return new Pregled.Pacijent();
    }

    /**
     * Create an instance of {@link MedicinskeSestre }
     * 
     */
    public MedicinskeSestre createMedicinskeSestre() {
        return new MedicinskeSestre();
    }

    /**
     * Create an instance of {@link MedicinskiaSestra }
     * 
     */
    public MedicinskiaSestra createMedicinskiaSestra() {
        return new MedicinskiaSestra();
    }

    /**
     * Create an instance of {@link TOsoba }
     * 
     */
    public TOsoba createTOsoba() {
        return new TOsoba();
    }

    /**
     * Create an instance of {@link UputiZaSpecijalistickiPregled }
     * 
     */
    public UputiZaSpecijalistickiPregled createUputiZaSpecijalistickiPregled() {
        return new UputiZaSpecijalistickiPregled();
    }

    /**
     * Create an instance of {@link UputZaSpecijalistickiPregled.ZdravstveniKarton }
     * 
     */
    public UputZaSpecijalistickiPregled.ZdravstveniKarton createUputZaSpecijalistickiPregledZdravstveniKarton() {
        return new UputZaSpecijalistickiPregled.ZdravstveniKarton();
    }

    /**
     * Create an instance of {@link UputZaSpecijalistickiPregled.Lekar }
     * 
     */
    public UputZaSpecijalistickiPregled.Lekar createUputZaSpecijalistickiPregledLekar() {
        return new UputZaSpecijalistickiPregled.Lekar();
    }

    /**
     * Create an instance of {@link TPodaciOOsiguranju }
     * 
     */
    public TPodaciOOsiguranju createTPodaciOOsiguranju() {
        return new TPodaciOOsiguranju();
    }

    /**
     * Create an instance of {@link UputZaSpecijalistickiPregled.Specijalista }
     * 
     */
    public UputZaSpecijalistickiPregled.Specijalista createUputZaSpecijalistickiPregledSpecijalista() {
        return new UputZaSpecijalistickiPregled.Specijalista();
    }

    /**
     * Create an instance of {@link UputZaSpecijalistickiPregled.PodaciOPregledu }
     * 
     */
    public UputZaSpecijalistickiPregled.PodaciOPregledu createUputZaSpecijalistickiPregledPodaciOPregledu() {
        return new UputZaSpecijalistickiPregled.PodaciOPregledu();
    }

    /**
     * Create an instance of {@link UputZaSpecijalistickiPregled.Izvestaj }
     * 
     */
    public UputZaSpecijalistickiPregled.Izvestaj createUputZaSpecijalistickiPregledIzvestaj() {
        return new UputZaSpecijalistickiPregled.Izvestaj();
    }

    /**
     * Create an instance of {@link UputiZaLaboratoriju }
     * 
     */
    public UputiZaLaboratoriju createUputiZaLaboratoriju() {
        return new UputiZaLaboratoriju();
    }

    /**
     * Create an instance of {@link UputZaLaboratoriju.ZdravstveniKarton }
     * 
     */
    public UputZaLaboratoriju.ZdravstveniKarton createUputZaLaboratorijuZdravstveniKarton() {
        return new UputZaLaboratoriju.ZdravstveniKarton();
    }

    /**
     * Create an instance of {@link Lekari }
     * 
     */
    public Lekari createLekari() {
        return new Lekari();
    }

    /**
     * Create an instance of {@link com.svj.zis.model.Lekar.Tip }
     * 
     */
    public com.svj.zis.model.Lekar.Tip createLekarTip() {
        return new com.svj.zis.model.Lekar.Tip();
    }

    /**
     * Create an instance of {@link com.svj.zis.model.Lekar.OblastZastite }
     * 
     */
    public com.svj.zis.model.Lekar.OblastZastite createLekarOblastZastite() {
        return new com.svj.zis.model.Lekar.OblastZastite();
    }

    /**
     * Create an instance of {@link Izvestaji }
     * 
     */
    public Izvestaji createIzvestaji() {
        return new Izvestaji();
    }

    /**
     * Create an instance of {@link com.svj.zis.model.Izvestaj.Datum }
     * 
     */
    public com.svj.zis.model.Izvestaj.Datum createIzvestajDatum() {
        return new com.svj.zis.model.Izvestaj.Datum();
    }

    /**
     * Create an instance of {@link com.svj.zis.model.Izvestaj.OsiguranoLice }
     * 
     */
    public com.svj.zis.model.Izvestaj.OsiguranoLice createIzvestajOsiguranoLice() {
        return new com.svj.zis.model.Izvestaj.OsiguranoLice();
    }

    /**
     * Create an instance of {@link com.svj.zis.model.Izvestaj.Lekar }
     * 
     */
    public com.svj.zis.model.Izvestaj.Lekar createIzvestajLekar() {
        return new com.svj.zis.model.Izvestaj.Lekar();
    }

    /**
     * Create an instance of {@link Pacijenti }
     * 
     */
    public Pacijenti createPacijenti() {
        return new Pacijenti();
    }

    /**
     * Create an instance of {@link com.svj.zis.model.Pacijent.ZdravstveniKarton }
     * 
     */
    public com.svj.zis.model.Pacijent.ZdravstveniKarton createPacijentZdravstveniKarton() {
        return new com.svj.zis.model.Pacijent.ZdravstveniKarton();
    }

    /**
     * Create an instance of {@link Lekovi }
     * 
     */
    public Lekovi createLekovi() {
        return new Lekovi();
    }

    /**
     * Create an instance of {@link Lek.Naziv }
     * 
     */
    public Lek.Naziv createLekNaziv() {
        return new Lek.Naziv();
    }

    /**
     * Create an instance of {@link ZdravstveniKartoni }
     * 
     */
    public ZdravstveniKartoni createZdravstveniKartoni() {
        return new ZdravstveniKartoni();
    }

    /**
     * Create an instance of {@link PacijentoviPodaci }
     * 
     */
    public PacijentoviPodaci createPacijentoviPodaci() {
        return new PacijentoviPodaci();
    }

    /**
     * Create an instance of {@link Adresa }
     * 
     */
    public Adresa createAdresa() {
        return new Adresa();
    }

    /**
     * Create an instance of {@link com.svj.zis.model.ZdravstveniKarton.OdabraniLekar }
     * 
     */
    public com.svj.zis.model.ZdravstveniKarton.OdabraniLekar createZdravstveniKartonOdabraniLekar() {
        return new com.svj.zis.model.ZdravstveniKarton.OdabraniLekar();
    }

    /**
     * Create an instance of {@link Users }
     * 
     */
    public Users createUsers() {
        return new Users();
    }

    /**
     * Create an instance of {@link User.Roles }
     * 
     */
    public User.Roles createUserRoles() {
        return new User.Roles();
    }

    /**
     * Create an instance of {@link LekarskiRecepti }
     * 
     */
    public LekarskiRecepti createLekarskiRecepti() {
        return new LekarskiRecepti();
    }

    /**
     * Create an instance of {@link Ustanova }
     * 
     */
    public Ustanova createUstanova() {
        return new Ustanova();
    }

    /**
     * Create an instance of {@link LekarskiRecept.ZdravstveniKarton }
     * 
     */
    public LekarskiRecept.ZdravstveniKarton createLekarskiReceptZdravstveniKarton() {
        return new LekarskiRecept.ZdravstveniKarton();
    }

    /**
     * Create an instance of {@link PodaciOLekaru }
     * 
     */
    public PodaciOLekaru createPodaciOLekaru() {
        return new PodaciOLekaru();
    }

    /**
     * Create an instance of {@link TPodaciOLeku }
     * 
     */
    public TPodaciOLeku createTPodaciOLeku() {
        return new TPodaciOLeku();
    }

    /**
     * Create an instance of {@link com.svj.zis.model.Pacijent.Obavestenja.Obavestenje }
     * 
     */
    public com.svj.zis.model.Pacijent.Obavestenja.Obavestenje createPacijentObavestenjaObavestenje() {
        return new com.svj.zis.model.Pacijent.Obavestenja.Obavestenje();
    }

    /**
     * Create an instance of {@link com.svj.zis.model.Izvestaj.Terapija.Link }
     * 
     */
    public com.svj.zis.model.Izvestaj.Terapija.Link createIzvestajTerapijaLink() {
        return new com.svj.zis.model.Izvestaj.Terapija.Link();
    }

    /**
     * Create an instance of {@link com.svj.zis.model.Izvestaj.Anamneza.Link }
     * 
     */
    public com.svj.zis.model.Izvestaj.Anamneza.Link createIzvestajAnamnezaLink() {
        return new com.svj.zis.model.Izvestaj.Anamneza.Link();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link com.svj.zis.model.Izvestaj.Terapija.Link }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.svj.com/zis/dokumenti", name = "link", scope = com.svj.zis.model.Izvestaj.Terapija.class)
    public JAXBElement<com.svj.zis.model.Izvestaj.Terapija.Link> createIzvestajTerapijaLink(com.svj.zis.model.Izvestaj.Terapija.Link value) {
        return new JAXBElement<com.svj.zis.model.Izvestaj.Terapija.Link>(_IzvestajTerapijaLink_QNAME, com.svj.zis.model.Izvestaj.Terapija.Link.class, com.svj.zis.model.Izvestaj.Terapija.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link String }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.svj.com/zis/osobe", name = "osnov_oslobadjanja_od_participacije", scope = PacijentoviPodaci.class)
    public JAXBElement<String> createPacijentoviPodaciOsnovOslobadjanjaOdParticipacije(String value) {
        return new JAXBElement<String>(_PacijentoviPodaciOsnovOslobadjanjaOdParticipacije_QNAME, String.class, PacijentoviPodaci.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link com.svj.zis.model.Izvestaj.Anamneza.Link }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.svj.com/zis/dokumenti", name = "link", scope = com.svj.zis.model.Izvestaj.Anamneza.class)
    public JAXBElement<com.svj.zis.model.Izvestaj.Anamneza.Link> createIzvestajAnamnezaLink(com.svj.zis.model.Izvestaj.Anamneza.Link value) {
        return new JAXBElement<com.svj.zis.model.Izvestaj.Anamneza.Link>(_IzvestajTerapijaLink_QNAME, com.svj.zis.model.Izvestaj.Anamneza.Link.class, com.svj.zis.model.Izvestaj.Anamneza.class, value);
    }

}
