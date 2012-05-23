/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.common.gui.panel.show.api;

import vn.com.hkt.em.common.gui.controlshow.api.IControlShowInformation;

/**
 * Mặt nạ giao diện thông tin tổng quát chứa giao diện thông tin cụ thể
 * Dùng để phát hiện giao diện thông tin cụ thể có các thông tin bổ xung
 * @author BinLe
 */
public interface IPanelShowInformationOverview extends IPanelShowInformation {

    /**
     * Thực hiện chức năng lấy lại giao diện thông tin cụ thể(giao diện cha)
     * của dialog hiển thị thông tin bổ xung
     */
    public void reloadPanelShowInformation();

    public void setControlShowInformationOverview(IControlShowInformation controlShowInformation);
}
