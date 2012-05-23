/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.enterprise.data.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import vn.com.hkt.em.core.api.IEntity;

/**
 * Đối tượng miêu tả lĩnh vực kinh doanh
 * @author BinLe
 */
@Entity
public class BusinessArea implements IEntity {

    public static final String FIELD_BUSINESS_AREA_NAME = "businessAreaName";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;// id tự sinh
    private String businessAreaName;// tên lĩnh vực kinh doanh
    private String businessAreaCode;// mã  lĩnh vực kinh doanh
    private String description;//miêu tả lĩnh vực kinh doanh

    public String getBusinessAreaCode() {
        return businessAreaCode;
    }

    public void setBusinessAreaCode(String businessAreaCode) {
        this.businessAreaCode = businessAreaCode;
    }

    public String getBusinessAreaName() {
        return businessAreaName;
    }

    public void setBusinessAreaName(String businessAreaName) {
        this.businessAreaName = businessAreaName;
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

    @Override
    public String toString() {
        return businessAreaName;
    }
}
