/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.basic.presentation.controlshow.api;

import vn.com.hkt.em.basic.data.entities.Enterprise;
import vn.com.hkt.em.common.gui.controlshow.api.IControlShowInformation;

/**
 *
 * @author duong
 */
public interface IControlShowEnterprise extends IControlShowInformation {
     /**
     * Hiển thị thông tin doanh nghiệp được truyền vào
     * @param enterprise :IEnterprise doanh nghiệp truyền vào
     */
    public void loadEnterprise(Enterprise enterprise);
}
