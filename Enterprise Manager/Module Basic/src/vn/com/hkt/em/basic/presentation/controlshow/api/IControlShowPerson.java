/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.basic.presentation.controlshow.api;


import vn.com.hkt.em.basic.data.entities.Person;
import vn.com.hkt.em.common.gui.controlshow.api.IControlShowInformation;

/**
 * Mặt nạ điều khiển hiển thị thông tin cá nhân
 * @author BinLe
 */
public interface IControlShowPerson extends IControlShowInformation {
    /**
     * Hiển thị thông tin của cá nhân được chọn
     * @param person :Person cá nhân được chọn để hiển thị
     */
    public void loadPerson(Person person);    
}
