/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.common.gui.panel.control.function.api;

import vn.com.hkt.em.common.gui.topcomponent.spi.EnterpriseManagerTopComponent;

/**
 * Mặt nạ giao diện điều khiển chức năng tổng quát
 * @author BinLe
 */
public interface IPanelControlFunctionTotal {    
    /**
     * Thực hiện việc kiểm soát topcomponent sử dụng
     */
    public void setTopComponent(EnterpriseManagerTopComponent topComponent);

    public void loadDefault();
}
