/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.basic.data.entities;

import java.lang.reflect.Field;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.openide.util.lookup.ServiceProvider;
import org.openide.util.lookup.ServiceProviders;
import vn.com.hkt.em.core.api.IEntityManager;

/**
 * Đối tượng doanh nghiệp lưu trong cơ sở dữ liệu
 * @author BinLe
 */
@ServiceProviders({
    @ServiceProvider(service = IEntityManager.class)
})
@Entity
public class Enterprise implements IEntityManager {

    public static final String FIELD_ENTERPRISE_NAME = "enterpriseName";
    public static final String FIELD_ENTERPRISE_CODE = "enterpriseCode";
    public static final String FIELD_SLOGAN = "slogan";
    public static final String FIELD_ADDRESS = "address";
    public static final String FIELD_TELEPHONE = "telephone";
    public static final String FIELD_FAX = "fax";
    public static final String FIELD_EMAIL = "email";
    public static final String FIELD_WEBSITE = "website";
    public static final String FIELD_DESCRIPTION = "description";
    public static final String FIELD_ID_ENTERPRISE_TYPE = "idEnterpriseType";
    public static final String FIELD_ID_ENTERPRISE_PARENT = "idEnterpriseParent";
    public static final String FIELD_ID_COUNTRY = "idCountry";
    public static final String FIELD_ID_CITY = "idCity";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;// mã id tự sinh
    private String enterpriseName;// tên doanh nghiệp
    private String enterpriseCode;// mã doanh nghiệp tự đánh
    private String slogan;// tiêu chí hoạt động
    private byte[] image;// ảnh doanh nghiệp
    private String address;// địa chỉ doanh nghiệp
    private String telephone;// điện thoại
    private String fax;// fax
    private String email;// thư điện tư
    private String website;// website
    private String description;// miêu tả doanh nghiệp
    private long idEnterpriseParent;// id doanh nghiệp cha
    private long idCountry;// id quốc gia
    private long idCity;// id thành phố

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEnterpriseCode() {
        return enterpriseCode;
    }

    public void setEnterpriseCode(String enterpriseCode) {
        this.enterpriseCode = enterpriseCode;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdCity() {
        return idCity;
    }

    public void setIdCity(long idCity) {
        this.idCity = idCity;
    }

    public long getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(long idCountry) {
        this.idCountry = idCountry;
    }

    public long getIdEnterpriseParent() {
        return idEnterpriseParent;
    }

    public void setIdEnterpriseParent(long idEnterpriseParent) {
        this.idEnterpriseParent = idEnterpriseParent;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    @Override
    public String toString() {
        return enterpriseName;
    }

    @Override
    public String getDescription(Field field) {
        //TODO chua vieet
        return field.getName();
    }

    @Override
    public Object getData(Field field) {
        //TODO chua viet
        return "";
    }

    @Override
    public String getModuleCodeHKT() {
        //TODO chua viet
        return "";
    }
}
