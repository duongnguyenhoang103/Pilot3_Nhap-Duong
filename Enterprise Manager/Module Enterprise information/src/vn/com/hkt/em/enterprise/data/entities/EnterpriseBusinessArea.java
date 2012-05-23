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
 * Đối tượng miêu tả lĩnh vực kinh doanh của doanh nghiệp
 * @author BinLe
 */
@ServiceProvider(service = IEntityManager.class)
@Entity
public class EnterpriseBusinessArea implements IEntityManager {

    public static final String FIELD_ID_ENTERPRISE = "idEnterprise";
    public static final String FIELD_RANKING = "ranking";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long idBusinessArea;//Lĩnh vực kinh doanh
    private long idEnterprise;// doanh nghiệp có lĩnh vực kinh doanh
    private float ranking;// xếp hạng ưu tiên của doanh nghiệp
    private String description;

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

    public long getIdBusinessArea() {
        return idBusinessArea;
    }

    public void setIdBusinessArea(long idBusinessArea) {
        this.idBusinessArea = idBusinessArea;
    }

    public long getIdEnterprise() {
        return idEnterprise;
    }

    public void setIdEnterprise(long idEnterprise) {
        this.idEnterprise = idEnterprise;
    }

    public float getRanking() {
        return ranking;
    }

    public void setRanking(float ranking) {
        this.ranking = ranking;
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
