/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.basic.presentation.panel.show.api;

import vn.com.hkt.em.common.gui.panel.show.api.IPanelShowListInformation;

/**
 * Mặt nạ gia diện hiển thị danh sách thông tin cơ bản của doanh nghiệp
 * @author BinLe
 */
public interface IPanelShowListEnterpriseBasic extends IPanelShowListInformation {
    /**
     * Trả về Level của giaod diện
     * Với giao diện cơ bản(giao diện cha) có level 1 
     * Với các giao diện bổ xung(giao diện con) sẽ có leve>1
     * @return 
     */
    public long getLevelPanelShowListEnterpriseBasic();
}
