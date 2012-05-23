/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.basic.data.jpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Đối tượng kết nối JPA
 * @author BinLe
 */
public class PersistenceUtilityBasic {

    private static String persistenceString = "ModuleBasic";
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
