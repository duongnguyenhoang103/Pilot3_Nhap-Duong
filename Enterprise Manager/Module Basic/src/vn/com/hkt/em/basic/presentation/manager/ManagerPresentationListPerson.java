/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.basic.presentation.manager;

import vn.com.hkt.em.basic.presentation.controlshow.spi.ControlShowListPerson;
import vn.com.hkt.em.common.gui.panel.control.function.spi.PanelControlFunctionListInformation;
import vn.com.hkt.em.common.gui.panel.controlshow.spi.PanelControlShowListInformation;
import vn.com.hkt.em.common.gui.topcomponent.spi.EnterpriseManagerTopComponent;

/**
 *
 * @author BinLe
 */
public class ManagerPresentationListPerson {

    private EnterpriseManagerTopComponent topListPerson;
    private static ManagerPresentationListPerson managerPresentationListPerson;

    public static ManagerPresentationListPerson getInstance() {
        if (managerPresentationListPerson == null) {
            managerPresentationListPerson = new ManagerPresentationListPerson();
        }
        return managerPresentationListPerson;
    }

    private ManagerPresentationListPerson() {
        ControlShowListPerson controlShowListPerson = new ControlShowListPerson();
        PanelControlShowListInformation panelControlShowListInformation = new PanelControlShowListInformation(controlShowListPerson);
        panelControlShowListInformation.loadData();
        PanelControlFunctionListInformation panelControlFunctionListInformation = new PanelControlFunctionListInformation(panelControlShowListInformation);
        topListPerson = new EnterpriseManagerTopComponent(panelControlFunctionListInformation);
    }

    public void showDefault() {
        topListPerson.open();
        topListPerson.setName("Danh sách cá nhân");
        topListPerson.requestActive();
    }

    public EnterpriseManagerTopComponent getTopComponent() {
        return topListPerson;
    }
}
