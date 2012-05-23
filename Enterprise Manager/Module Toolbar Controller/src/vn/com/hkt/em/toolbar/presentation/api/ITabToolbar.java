/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.toolbar.presentation.api;

/**
 * Mặt nạ các tabtoolbar 
 * @author BinLe
 */
public interface ITabToolbar {

    /**
     * Lấy tên tabToolbar
     * @return 
     */
    public String getTabToolbarName();

    /**
     * Lấy vị trí hiển thị của tabtoolbar
     * @return 
     */
    public int getTabToolbarIndex();
}
