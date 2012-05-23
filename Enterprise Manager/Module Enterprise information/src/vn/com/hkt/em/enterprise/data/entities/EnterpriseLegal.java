/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.enterprise.data.entities;

import java.lang.reflect.Field;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.openide.util.Lookup;
import org.openide.util.lookup.ServiceProvider;
import vn.com.hkt.em.basic.data.access.api.IEnterpriseDAO;
import vn.com.hkt.em.core.api.IEntityManager;

/**
 * Thông tin pháp lý của doanh nghiệp
 * @author duong
 */
@ServiceProvider(service = IEntityManager.class)
@Entity
public class EnterpriseLegal implements IEntityManager {

    public static final String FIELD_ID_ENTERPRISE = "idEnterprise";
    public static final String FIELD_ID_PERSON_RESPONSIABLE_LEGAL = "idPersonResponsibleLegal";
    public static final String FIELD_ENTERPRISE_NAME_ENGLISH = "enterpriseNameEnglish";
    public static final String FIELD_ENTERPRISE_NAME_VIETNAM = "enterpriseNameVietNam";
    public static final String FIELD_BUSINESS_REGISTRATION_NUMBER = "businessResgitrationNumber";
    public static final String FIELD_TAX_CODE_NUMBER= "taxCodeNumber";
    public static final String FIELD_DATE_REGISTRATION = "dateRegistration";
    public static final String FIELD_DATE_ESTABLISHMENT = "dateEstablishment";   
    public static final String FIELD_ID_ENTERPRISE_TYPE = "idEnterpriseType";   
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long idEnterprise;// id thông tin cơ bản của doanh nghiệp
    private String enterpriseNameEnglish;// tên tiếng Anh
    private String enterpriseNameVietNam;// tên tiếng Việt
    private String businessRegistrationTime;// lần đăng ký kinh doanh
    private String businessResgitrationNumber;// số đăng ký kinh doanh
    private String taxCodeNumber;// mã số thuế
    @Temporal(TemporalType.DATE)
    private Date dateRegistration;//ngày đăng ký
    @Temporal(TemporalType.DATE)
    private Date dateEstablishment;// ngày thành lập.
    private float charteredCapital;// vốn điều lệ
    private float legalCapital;// vốn pháp định
    private long idPersonResponsibleLegal;// người chịu trách nhiệm pháp lý(Giám đốc)
    private long idEnterpriseType;// id loại hình doanh nghiệp

    public String getBusinessRegistrationTime() {
        return businessRegistrationTime;
    }

    public void setBusinessRegistrationTime(String businessRegistrationTime) {
        this.businessRegistrationTime = businessRegistrationTime;
    }

    public String getBusinessResgitrationNumber() {
        return businessResgitrationNumber;
    }

    public void setBusinessResgitrationNumber(String businessResgitrationNumber) {
        this.businessResgitrationNumber = businessResgitrationNumber;
    }

    public float getCharteredCapital() {
        return charteredCapital;
    }

    public void setCharteredCapital(float charteredCapital) {
        this.charteredCapital = charteredCapital;
    }

    public Date getDateEstablishment() {
        return dateEstablishment;
    }

    public void setDateEstablishment(Date dateEstablishment) {
        this.dateEstablishment = dateEstablishment;
    }

    public Date getDateRegistration() {
        return dateRegistration;
    }

    public void setDateRegistration(Date dateRegistration) {
        this.dateRegistration = dateRegistration;
    }

    public String getEnterpriseNameEnglish() {
        return enterpriseNameEnglish;
    }

    public void setEnterpriseNameEnglish(String enterpriseNameEnglish) {
        this.enterpriseNameEnglish = enterpriseNameEnglish;
    }

    public String getEnterpriseNameVietNam() {
        return enterpriseNameVietNam;
    }

    public void setEnterpriseNameVietNam(String enterpriseNameVietName) {
        this.enterpriseNameVietNam = enterpriseNameVietName;
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdEnterpriseType() {
        return idEnterpriseType;
    }

    public void setIdEnterpriseType(long idEnterpriseType) {
        this.idEnterpriseType = idEnterpriseType;
    }

    public long getIdPersonResponsibleLegal() {
        return idPersonResponsibleLegal;
    }

    public void setIdPersonResponsibleLegal(long idEmployeeResponsibleLegal) {
        this.idPersonResponsibleLegal = idEmployeeResponsibleLegal;
    }

    public long getIdEnterprise() {
        return idEnterprise;
    }

    public void setIdEnterprise(long idEnterprise) {
        this.idEnterprise = idEnterprise;                 
    }

    public float getLegalCapital() {
        return legalCapital;
    }

    public void setLegalCapital(float legalCapital) {
        this.legalCapital = legalCapital;
    }

    public String getTaxCodeNumber() {
        return taxCodeNumber;
    }

    public void setTaxCodeNumber(String taxCodeNumber) {
        this.taxCodeNumber = taxCodeNumber;
    }

    public EnterpriseLegal(long id, long idEnterprise, String enterpriseNameEnglish, String enterpriseNameVietNam, String businessRegistrationTime, String businessResgitrationNumber, String taxCodeNumber, Date dateRegistration, Date dateEstablishment, float charteredCapital, float legalCapital, long idPersonResponsibleLegal, long idEnterpriseType) {
        this.id = id;
        this.idEnterprise = idEnterprise;
        this.enterpriseNameEnglish = enterpriseNameEnglish;
        this.enterpriseNameVietNam = enterpriseNameVietNam;
        this.businessRegistrationTime = businessRegistrationTime;
        this.businessResgitrationNumber = businessResgitrationNumber;
        this.taxCodeNumber = taxCodeNumber;
        this.dateRegistration = dateRegistration;
        this.dateEstablishment = dateEstablishment;
        this.charteredCapital = charteredCapital;
        this.legalCapital = legalCapital;
        this.idPersonResponsibleLegal = idPersonResponsibleLegal;
        this.idEnterpriseType = idEnterpriseType;
    }

    public EnterpriseLegal(){
        
    }
    @Override
    public String toString() {
        IEnterpriseDAO edao = Lookup.getDefault().lookup(IEnterpriseDAO.class);
        return edao.getById(idEnterprise).toString();
    }

    @Override
    public String getDescription(Field field) {
        //TODO
        return "";
    }

    @Override
    public Object getData(Field field) {
        //TODO
        return "";
    }

    @Override
    public String getModuleCodeHKT() {
        //TODO
        return "";
    }
}
