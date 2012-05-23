/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.basic.presentation.manager;

import vn.com.hkt.em.basic.data.entities.Person;
import vn.com.hkt.em.basic.presentation.controlshow.api.IControlShowPerson;
import vn.com.hkt.em.basic.presentation.controlshow.spi.ControlShowPerson;
import vn.com.hkt.em.common.gui.panel.control.function.spi.PanelControlFunctionInformation;
import vn.com.hkt.em.common.gui.panel.controlshow.spi.PanelControlShowInformation;
import vn.com.hkt.em.common.gui.topcomponent.spi.EnterpriseManagerTopComponent;

/**
 *
 * @author BinLe
 */
public class ManagerPresentationPerson {

    private static ManagerPresentationPerson managerPresentationPerson;
    private EnterpriseManagerTopComponent topPerson;
    private PanelControlShowInformation panelControlShowInformation;
    private PanelControlFunctionInformation panelControlFunction;
    private IControlShowPerson controlShowPerson;

    public static ManagerPresentationPerson getInstance() {
        if (managerPresentationPerson == null) {
            managerPresentationPerson = new ManagerPresentationPerson();
        }
        return managerPresentationPerson;
    }

    private ManagerPresentationPerson() {
        if (topPerson == null) {
            controlShowPerson = new ControlShowPerson();
            panelControlShowInformation = new PanelControlShowInformation(controlShowPerson);
            panelControlFunction = new PanelControlFunctionInformation(panelControlShowInformation);
            topPerson = new EnterpriseManagerTopComponent(panelControlFunction);
        }
    }

    public void showDefault() {
        topPerson.open();
        topPerson.setName("Cá nhân");
        topPerson.requestActive();
        panelControlShowInformation.resetData();
        panelControlFunction.showButton();
    }

    public void show(Person person) {        
        topPerson.open();
        topPerson.setName("Cá nhân");
        topPerson.requestActive();
        controlShowPerson.loadPerson(person);
        panelControlFunction.showButton();
    }

    public EnterpriseManagerTopComponent getTopComponent() {
        return topPerson;
    }
}
