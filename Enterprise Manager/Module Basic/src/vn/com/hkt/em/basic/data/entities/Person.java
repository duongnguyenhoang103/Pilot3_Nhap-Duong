/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.basic.data.entities;

import java.lang.reflect.Field;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.openide.util.lookup.ServiceProvider;
import org.openide.util.lookup.ServiceProviders;
import vn.com.hkt.em.core.api.IEntityManager;

/**
 * Đối tượng cá nhân lưu trong cơ sở dữ liệu
 * @author BinLe
 */
@ServiceProviders({
    @ServiceProvider(service = IEntityManager.class),})
@Entity
public class Person implements IEntityManager {

    public static final String GENDER_MEN = "MEN";
    public static final String GENDER_WOMEN = "WOMEN";
    public static final String FIELD_FIRST_NAME = "firstName";
    public static final String FIELD_LAST_NAME = "lastName";
    public static final String FIELD_BIRTHDAY = "birthday";
    public static final String FIELD_GENDER = "gender";
    public static final String FIELD_IDENTITY_CARD = "identityCard";
    public static final String FIELD_ADDRESS = "address";
    public static final String FIELD_TELEPHONE = "telephone";
    public static final String FIELD_MOBILE = "mobile";
    public static final String FIELD_CHILDREN = "children";
    public static final String FIELD_HEIGHT = "height";
    public static final String FIELD_WEIGHT = "weight";
    public static final String FIELD_EMAIL = "email";
    public static final String FIELD_FAX = "fax";
    public static final String FIELD_WEBSITE = "website";
    public static final String FIELD_ID_MARITALS_STATUS = "idMaritalStatus";
    public static final String FIELD_ID_COUNTRY = "idCountry";
    public static final String FIELD_ID_CITY = "idCity";
    public static final String FIELD_DESCRIPTION = "description";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String firstName;
    private String lastName;
    @Temporal(TemporalType.DATE)
    private Date birthday;
    private String gender;
    private String identityCard;
    private byte[] image;
    private float height;
    private float weight;
    private long children;
    private String address;
    private String telephone;
    private String mobile;
    private String email;
    private String fax;
    private String website;
    private long idMaritalStatus;
    private long idCountry;
    private long idCity;
    private String description;

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String LastName) {
        this.lastName = LastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public long getChildren() {
        return children;
    }

    public void setChildren(long children) {
        this.children = children;
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

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
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

    public long getIdMaritalStatus() {
        return idMaritalStatus;
    }

    public void setIdMaritalStatus(long idMaritalStatus) {
        this.idMaritalStatus = idMaritalStatus;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }

    @Override
    public String getDescription(Field field) {
        //TODO chua viet
        return field.getName();
    }

    @Override
    public Object getData(Field field) {
        //TODO chưa viết
        return "";
    }

    @Override
    public String getModuleCodeHKT() {
        //TODO chưa viết
        return "";
    }
}
