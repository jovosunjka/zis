
package com.svj.zis.dto;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.svj.zis.dto package. 
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

    private final static QName _ReportDtoAnamnezaLink_QNAME = new QName("http://www.svj.com/zis/dto", "link");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.svj.zis.dto
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link ReviewsDto }
     * 
     */
    public ReviewsDto createReviewsDto() {
        return new ReviewsDto();
    }

    /**
     * Create an instance of {@link ReportDto }
     * 
     */
    public ReportDto createReportDto() {
        return new ReportDto();
    }

    /**
     * Create an instance of {@link DoctorReceiptDto }
     * 
     */
    public DoctorReceiptDto createDoctorReceiptDto() {
        return new DoctorReceiptDto();
    }

    /**
     * Create an instance of {@link UputZaSpecijalistickiPregledDto }
     * 
     */
    public UputZaSpecijalistickiPregledDto createUputZaSpecijalistickiPregledDto() {
        return new UputZaSpecijalistickiPregledDto();
    }

    /**
     * Create an instance of {@link DoctorReceiptDto.Rp }
     * 
     */
    public DoctorReceiptDto.Rp createDoctorReceiptDtoRp() {
        return new DoctorReceiptDto.Rp();
    }

    /**
     * Create an instance of {@link ReportDto.Terapija }
     * 
     */
    public ReportDto.Terapija createReportDtoTerapija() {
        return new ReportDto.Terapija();
    }

    /**
     * Create an instance of {@link ReportDto.Anamneza }
     * 
     */
    public ReportDto.Anamneza createReportDtoAnamneza() {
        return new ReportDto.Anamneza();
    }

    /**
     * Create an instance of {@link ReviewsDto.Reviews }
     * 
     */
    public ReviewsDto.Reviews createReviewsDtoReviews() {
        return new ReviewsDto.Reviews();
    }

    /**
     * Create an instance of {@link Tokendto }
     * 
     */
    public Tokendto createTokendto() {
        return new Tokendto();
    }

    /**
     * Create an instance of {@link ReviewsDto.Doctor }
     * 
     */
    public ReviewsDto.Doctor createReviewsDtoDoctor() {
        return new ReviewsDto.Doctor();
    }

    /**
     * Create an instance of {@link UputZaLaboratorijuDto }
     * 
     */
    public UputZaLaboratorijuDto createUputZaLaboratorijuDto() {
        return new UputZaLaboratorijuDto();
    }

    /**
     * Create an instance of {@link DoctorReceiptDto.Ustanova }
     * 
     */
    public DoctorReceiptDto.Ustanova createDoctorReceiptDtoUstanova() {
        return new DoctorReceiptDto.Ustanova();
    }

    /**
     * Create an instance of {@link DoctorReceiptDto.PropisaniLek }
     * 
     */
    public DoctorReceiptDto.PropisaniLek createDoctorReceiptDtoPropisaniLek() {
        return new DoctorReceiptDto.PropisaniLek();
    }

    /**
     * Create an instance of {@link UputZaSpecijalistickiPregledDto.Specijalista }
     * 
     */
    public UputZaSpecijalistickiPregledDto.Specijalista createUputZaSpecijalistickiPregledDtoSpecijalista() {
        return new UputZaSpecijalistickiPregledDto.Specijalista();
    }

    /**
     * Create an instance of {@link BasicInfoDto }
     * 
     */
    public BasicInfoDto createBasicInfoDto() {
        return new BasicInfoDto();
    }

    /**
     * Create an instance of {@link Userdto }
     * 
     */
    public Userdto createUserdto() {
        return new Userdto();
    }

    /**
     * Create an instance of {@link DoctorReceiptDto.Rp.Link }
     * 
     */
    public DoctorReceiptDto.Rp.Link createDoctorReceiptDtoRpLink() {
        return new DoctorReceiptDto.Rp.Link();
    }

    /**
     * Create an instance of {@link ReportDto.Terapija.Link }
     * 
     */
    public ReportDto.Terapija.Link createReportDtoTerapijaLink() {
        return new ReportDto.Terapija.Link();
    }

    /**
     * Create an instance of {@link ReportDto.Anamneza.Link }
     * 
     */
    public ReportDto.Anamneza.Link createReportDtoAnamnezaLink() {
        return new ReportDto.Anamneza.Link();
    }

    /**
     * Create an instance of {@link ReviewsDto.Reviews.Review }
     * 
     */
    public ReviewsDto.Reviews.Review createReviewsDtoReviewsReview() {
        return new ReviewsDto.Reviews.Review();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReportDto.Anamneza.Link }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.svj.com/zis/dto", name = "link", scope = ReportDto.Anamneza.class)
    public JAXBElement<ReportDto.Anamneza.Link> createReportDtoAnamnezaLink(ReportDto.Anamneza.Link value) {
        return new JAXBElement<ReportDto.Anamneza.Link>(_ReportDtoAnamnezaLink_QNAME, ReportDto.Anamneza.Link.class, ReportDto.Anamneza.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ReportDto.Terapija.Link }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.svj.com/zis/dto", name = "link", scope = ReportDto.Terapija.class)
    public JAXBElement<ReportDto.Terapija.Link> createReportDtoTerapijaLink(ReportDto.Terapija.Link value) {
        return new JAXBElement<ReportDto.Terapija.Link>(_ReportDtoAnamnezaLink_QNAME, ReportDto.Terapija.Link.class, ReportDto.Terapija.class, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DoctorReceiptDto.Rp.Link }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://www.svj.com/zis/dto", name = "link", scope = DoctorReceiptDto.Rp.class)
    public JAXBElement<DoctorReceiptDto.Rp.Link> createDoctorReceiptDtoRpLink(DoctorReceiptDto.Rp.Link value) {
        return new JAXBElement<DoctorReceiptDto.Rp.Link>(_ReportDtoAnamnezaLink_QNAME, DoctorReceiptDto.Rp.Link.class, DoctorReceiptDto.Rp.class, value);
    }

}
