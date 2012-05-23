/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.basic.presentation.manager;


import vn.com.hkt.em.basic.data.entities.Enterprise;
import vn.com.hkt.em.basic.presentation.controlshow.api.IControlShowEnterprise;
import vn.com.hkt.em.basic.presentation.controlshow.spi.ControlShowEnterprise;
import vn.com.hkt.em.common.gui.panel.control.function.spi.PanelControlFunctionInformation;
import vn.com.hkt.em.common.gui.panel.controlshow.spi.PanelControlShowInformation;
import vn.com.hkt.em.common.gui.topcomponent.spi.EnterpriseManagerTopComponent;

/**
 *
 * @author BinLe
 */
public class ManagerPresentationEnterprise {

    private static ManagerPresentationEnterprise managerPresentationEnterprise;
    private EnterpriseManagerTopComponent topEnterprise;
    private IControlShowEnterprise controlShowEnterprise;
    private PanelControlShowInformation panelControlShowInformation;
    private PanelControlFunctionInformation panelControlFunction;

    public static ManagerPresentationEnterprise getInstance() {
        if (managerPresentationEnterprise == null) {
            managerPresentationEnterprise = new ManagerPresentationEnterprise();
        }
        return managerPresentationEnterprise;
    }

    private ManagerPresentationEnterprise() {
        if (topEnterprise == null) {
            controlShowEnterprise = new ControlShowEnterprise();
            panelControlShowInformation = new PanelControlShowInformation(controlShowEnterprise);
            panelControlFunction = new PanelControlFunctionInformation(panelControlShowInformation);
            topEnterprise = new EnterpriseManagerTopComponent(panelControlFunction);
        }
    }

    public void showDefault() {
        topEnterprise.open();
        topEnterprise.setName("Doanh nghiệp");
        topEnterprise.requestActive();
        panelControlShowInformation.resetData();    
        panelControlFunction.showButton();
    }

    public void show(Enterprise enterprise) {        
        topEnterprise.open();
        topEnterprise.setName("Doanh nghiệp");
        topEnterprise.requestActive();
        controlShowEnterprise.loadEnterprise(enterprise);//do du lieu tu table len form
        panelControlFunction.showButton();
    }

    public EnterpriseManagerTopComponent getTopComponent() {
        return topEnterprise;
    }
}
