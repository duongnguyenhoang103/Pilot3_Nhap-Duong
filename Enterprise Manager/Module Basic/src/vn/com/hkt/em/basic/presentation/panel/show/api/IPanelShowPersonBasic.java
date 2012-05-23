/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.basic.presentation.panel.show.api;

import vn.com.hkt.em.basic.data.entities.Person;

import vn.com.hkt.em.common.gui.panel.show.api.IPanelShowInformation;

/**
 *Mặt nạ giao diện hiển thị thông tin cơ bản của cá nhân
 * @author BinLe
 */
public interface IPanelShowPersonBasic extends IPanelShowInformation {

    /**
     * Lấy level của giao diện
     * Chú ý:
     * -với giao diện cơ bản có level =1
     * -các giao diện thông tin bổ xung(giao diện con) có level>1
     * @return :long ->level giaod diện
     */
    public long getLevelPanelShowPersonBasic();

    /**
     * Truyền vào đối tượng cá nhân muốn hiển thị
     * @param person :IPersonS : cá nhân được chọn hiển thị
     */
    public void setPersonShow(Person person);
}
