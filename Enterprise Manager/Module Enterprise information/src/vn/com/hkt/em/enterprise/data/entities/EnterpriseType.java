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
 * Đối tượng loại hình doanh nghiệp lưu trong cơ sở dữ liệu
 * @author BinLe
 */
@Entity
public class EnterpriseType implements IEntity {

    public static final String FIELD_ENTERPRISE_TYPE_NAME = "enterpriseTypeName";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;// mã id tự sinh
    private String enterpriseTypeName;// tên loại hình doanh nghiệp
    private String description;// miêu tả loại hình doanh nghiệp

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEnterpriseTypeName() {
        return enterpriseTypeName;
    }

    public void setEnterpriseTypeName(String enterpriseTypeName) {
        this.enterpriseTypeName = enterpriseTypeName;
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
        return enterpriseTypeName;
    }
}
