/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.enterprise.data.entities;

import java.lang.reflect.Field;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.openide.util.lookup.ServiceProvider;
import vn.com.hkt.em.core.api.IEntityManager;

/**
 * Địa chỉ doanh nghiệp
 * @author BinLe
 */
@ServiceProvider(service = IEntityManager.class)
@Entity
public class EnterpriseAddress implements IEntityManager {

    public static final String FIELD_ID_ENTERPRISE = "idEnterprise";
    public static final String FIELD_INDEX = "index";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long idEnterprise;// doanh nghiệp
    private String Address;// địa chỉ
    private long idCountry;// quốc gia
    private long idCity;// thành phố
    private String telephone;// điện thoại
    private String fax;// fax
    private long index;// thứ tự địa chỉ(chi nhanh số )

    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
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

    public long getIdEnterprise() {
        return idEnterprise;
    }

    public void setIdEnterprise(long idEnterprise) {
        this.idEnterprise = idEnterprise;
    }

    public long getIndex() {
        return index;
    }

    public void setIndex(long index) {
        this.index = index;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        //TODO
        return "";
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
