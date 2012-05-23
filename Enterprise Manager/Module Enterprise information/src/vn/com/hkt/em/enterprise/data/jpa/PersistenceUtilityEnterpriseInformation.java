/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.enterprise.data.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Đối tượng kết nối JPA
 * @author duong
 */
public class PersistenceUtilityEnterpriseInformation {

    private static String persistenceString = "ModuleEnterpriseInformation";
    private static EntityManagerFactory emf;

    /**
     * hàm lấy ra đối tượng quản lý phiên kết nối cơ sở dữ liệu
     * @return :EntityManagerFactory đối tượng quản lý phiên kết nối
     */
    public static EntityManagerFactory getEntityManagerFactory() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory(persistenceString);
        }
        return emf;
    }
}
