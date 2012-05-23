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
 * Đối tượng quốc gia lưu trong cơ sở dữ liệu
 * @author BinLe
 */
@Entity
public class Country implements IEntity {

    public static final String FIELD_COUNTRY_NAME = "countryName";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;// mã id tự sinh
    private String countryName;// tên quốc gia
    private String countryCode;// mã quốc gia
    private String nationality;// quốc tịch tương ứng
    private String language;// ngôn ngữ sử dụng
    private byte[] nationalityFlag;// quốc kỳ
    private String description;// miêu tả quốc gia

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
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

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public byte[] getNationalityFlag() {
        return nationalityFlag;
    }

    public void setNationalityFlag(byte[] nationalityFlag) {
        this.nationalityFlag = nationalityFlag;
    }

    @Override
    public String toString() {
        return countryName;
    }
}
