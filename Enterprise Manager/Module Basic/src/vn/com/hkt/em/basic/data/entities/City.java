/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.basic.data.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import vn.com.hkt.em.core.api.IEntity;

/**
 * Đối tượng thành phố lưu trong cơ sở dữ liệu
 * @author BinLe
 */
@Entity
public class City implements IEntity {

    public static final String FIELD_CITY_NAME = "cityName";
    public static final String FIELD_CITY_CODE = "cityCode";
    public static final String FIELD_DESCRIPTION = "description";
    public static final String FIELD_ID_COUNTRY = "idCountry";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;// mã tự sinh
    private String cityName;// tên thành phô
    private String cityCode;// mã thành phố
    private String description;// miêu tả thành phố
    private long idCountry;// id quốc gia trực thuộc

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdCountry() {
        return idCountry;
    }

    public void setIdCountry(long idCountry) {
        this.idCountry = idCountry;
    }

    @Override
    public String toString() {
        return cityName;
    }
}
