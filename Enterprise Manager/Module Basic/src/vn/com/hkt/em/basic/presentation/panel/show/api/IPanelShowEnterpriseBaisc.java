/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.basic.presentation.panel.show.api;

import vn.com.hkt.em.basic.data.entities.Enterprise;
import vn.com.hkt.em.common.gui.panel.show.api.IPanelShowInformation;

/**
 *
 * @author duong
 */
public interface IPanelShowEnterpriseBaisc extends IPanelShowInformation {
      /**
     * Lấy level của giao diện
     * Chú ý:
     * -với giao diện cơ bản có level =1
     * -các giao diện thông tin bổ xung(giao diện con) có level>1
     * @return :long ->level giaod diện
     */
    public long getLevelPanelShowEnterpriseBasic();

    /**
     * Truyền vào đối tượng doanh nghiệp muốn hiển thị
     * @param enterprise :IEnterprise : doanh nghiệp được chọn hiển thị
     */
    public void setEnterprise(Enterprise enterprise);    
    
}
