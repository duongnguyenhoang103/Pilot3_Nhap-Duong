/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.core.api;

/**
 * 
 * @author BinLe
 */
public interface IEntity {

    /**
     * Tên trường Id
     */
    public static final String FIELD_ID = "id";

    /**
     * Lấy mã cơ sở dữ liệu của entity
     */
    public long getId();
}
