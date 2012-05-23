/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.common.gui.controlshow.api;

import java.util.List;
import vn.com.hkt.em.common.gui.panel.controlshow.spi.PanelControlShowListInformation;

/**
 * Mặt nạ quản lý giao diện hiển thị danh sách thông ti
 * @author BinLe
 */
public interface IControlShowListInformation extends IControlShow {

    /**
     * Lấy gia diện hiển hị danh sachs thông tin
     * @return 
     */
    public PanelControlShowListInformation getPanelControlShowListInformation();

    public void setPanelControlShowListInformation(PanelControlShowListInformation panelControlShowListInformation);

//    public List<IPanelShowListInformation> getPanelShowListInformations();
    public void setListIdParentShow(List<Long> listIdParentShow);
}
