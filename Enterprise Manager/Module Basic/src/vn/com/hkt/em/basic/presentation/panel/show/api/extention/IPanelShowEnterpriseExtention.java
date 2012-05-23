/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.basic.presentation.panel.show.api.extention;


import vn.com.hkt.em.basic.data.entities.Enterprise;
import vn.com.hkt.em.common.gui.panel.show.api.IPanelShowInformation;

/**
 *
 * @author BinLe
 */
public interface IPanelShowEnterpriseExtention extends IPanelShowInformation {

    public void setEnterprise(Enterprise enterprise);

    public Enterprise getEnterprise();
}
