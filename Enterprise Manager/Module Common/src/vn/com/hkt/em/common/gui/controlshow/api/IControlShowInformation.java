/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.common.gui.controlshow.api;

import vn.com.hkt.em.common.gui.panel.controlshow.spi.PanelControlShowInformation;
import vn.com.hkt.em.common.gui.panel.show.api.IPanelShowInformation;

/**
 *
 * @author BinLe
 */
public interface IControlShowInformation extends IControlShow {

    /**
     * Lấy gia diện hiển hị thông tin
     * @return 
     */
    public PanelControlShowInformation getPanelControlShowInformation();

    /**
     * Truyền mặt nạ giao diện cha khi mở dialog để hiểm thị thông tin bổ xung
     * @param panelShowInformationParent :IPanelShowInformation
     * Mặt nạ giao diện có thông tin bổ xung
     */
    public void setParent(IPanelShowInformation panelShowInformationParent);

//    public List<IPanelShowInformation> getPanelShowInformations();
}
