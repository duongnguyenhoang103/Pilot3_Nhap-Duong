/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.core.api;

/**
 *
 * @author BinLe
 */
public interface IPresentation {

    /**
     * Lấy tên giao diện
     */
    public String getPresentationName();

    /**
     * Lấy mã giao diện do công ty quản lý
     */
    public String getPresentationCode();
    /**
     * Lấy level của giao diện do công ty quy định
     */
    public String getPresentationLevel();
}
