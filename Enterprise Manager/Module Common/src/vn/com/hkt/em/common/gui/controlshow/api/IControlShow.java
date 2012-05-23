/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.common.gui.controlshow.api;

import java.util.List;
import vn.com.hkt.em.common.gui.panel.show.api.IPanelShowTotal;

/**
 * Mặt nạ điều khiển các giao diện hiển thị
 * @author BinLe
 */
public interface IControlShow {

    /**
     * Load các giao diện hiển thị lên
     */
    public void loadPanelShow();

    /**
     * Lấy danh sách các giao diện hiển thị
     * @return  
     */
    public List<IPanelShowTotal> getListPanelShow();
}
