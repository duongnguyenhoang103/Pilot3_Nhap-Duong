/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.core.api;

import java.lang.reflect.Field;

/**
 *
 * @author BinLe
 */
public interface IEntityManager extends IEntity{
    /**
     * Lấy ra miêu tả ngắn gọn về trường truyền vào
     */
    public String getDescription(Field field);

    /**
     * Lấy giá trị của trường truyền vào
     */
    public Object getData(Field field);   

    /**
     * Lấy mã module trực thuộc do công ty quy định
     */
    public String getModuleCodeHKT();
}
