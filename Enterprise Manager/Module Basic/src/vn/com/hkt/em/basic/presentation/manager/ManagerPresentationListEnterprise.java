/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.basic.presentation.manager;

import javax.swing.JOptionPane;
import vn.com.hkt.em.basic.presentation.controlshow.spi.ControlShowListEnterprise;
import vn.com.hkt.em.common.gui.panel.control.function.spi.PanelControlFunctionListInformation;
import vn.com.hkt.em.common.gui.panel.controlshow.spi.PanelControlShowListInformation;
import vn.com.hkt.em.common.gui.topcomponent.spi.EnterpriseManagerTopComponent;

/**
 *
 * @author BinLe
 */
public class ManagerPresentationListEnterprise {

    private EnterpriseManagerTopComponent topListEnterprise;
    private static ManagerPresentationListEnterprise managerPresentationListEnterprise;

    public static ManagerPresentationListEnterprise getInstance() {
        if (managerPresentationListEnterprise == null) {
            managerPresentationListEnterprise = new ManagerPresentationListEnterprise();
        }
     //   JOptionPane.showConfirmDialog(null," sao the ");
        return managerPresentationListEnterprise;
    }

    private ManagerPresentationListEnterprise() {
        ControlShowListEnterprise controlShowListEnterprise = new ControlShowListEnterprise();
        PanelControlShowListInformation panelControlShowListInformation = new PanelControlShowListInformation(controlShowListEnterprise);
        panelControlShowListInformation.loadData();
        PanelControlFunctionListInformation panelControlFunctionListInformation = new PanelControlFunctionListInformation(panelControlShowListInformation);
        topListEnterprise = new EnterpriseManagerTopComponent(panelControlFunctionListInformation);
    }

    public void showDefault() {
        topListEnterprise.open();
        topListEnterprise.setName("Danh sách doanh nghiệp");
        topListEnterprise.requestActive();
    }

    public EnterpriseManagerTopComponent getTopComponent() {
        return topListEnterprise;
    }
}
