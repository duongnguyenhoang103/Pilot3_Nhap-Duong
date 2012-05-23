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
 * Đối tượng tình trạng hôn nhân lưu trong cơ sở dữ liệu
 * @author BinLe
 */
@Entity
public class MaritalStatus implements IEntity {

    public static final String FIELD_MARITAL_STATUS_NAME = "maritalStatusName";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;//mã id tự sinh
    private String maritalStatusName; // tên tình trạng hôn nhân
    private String description;// miêu tả tình trạng hôn nhân

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

    public String getMaritalStatusName() {
        return maritalStatusName;
    }

    public void setMaritalStatusName(String maritalStatusName) {
        this.maritalStatusName = maritalStatusName;
    }

    @Override
    public String toString() {
        return maritalStatusName;
    }
}
