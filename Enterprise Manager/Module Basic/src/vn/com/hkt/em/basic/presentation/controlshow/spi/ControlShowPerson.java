/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.basic.presentation.controlshow.spi;

import java.util.ArrayList;
import java.util.List;
import org.openide.util.Lookup;

import vn.com.hkt.em.basic.data.entities.Person;
import vn.com.hkt.em.basic.presentation.controlshow.api.IControlShowPerson;
import vn.com.hkt.em.basic.presentation.panel.show.api.IPanelShowPersonBasic;
import vn.com.hkt.em.common.gui.panel.controlshow.spi.PanelControlShowInformation;
import vn.com.hkt.em.common.gui.panel.show.api.IPanelShowInformation;
import vn.com.hkt.em.common.gui.panel.show.api.IPanelShowTotal;

/**
 * Đối tượng điều khiển hiển thị thông tin cá nhân
 * @author BinLe
 */
public class ControlShowPerson implements IControlShowPerson {

    private List<IPanelShowPersonBasic> panelShowPersons;// danh sách mặt nạ giao diện hiển thị thông tin cá nhân
    private PanelControlShowInformation controlShow;// giao diện điều khiển hiển thị thông tin cá nhân

    public ControlShowPerson() {
        loadPanelShow();
    }
    
    @Override
    public void loadPanelShow() {
        panelShowPersons = new ArrayList<IPanelShowPersonBasic>();
        List<IPanelShowPersonBasic> lpspb = (List<IPanelShowPersonBasic>) Lookup.getDefault().lookupAll(IPanelShowPersonBasic.class);
        lpspb = sortPanelShowPerson(lpspb);        
        for (int i = 0; i < lpspb.size(); i++) {
            try {
                IPanelShowPersonBasic pse = lpspb.get(i).getClass().newInstance();                
                panelShowPersons.add(pse);
            } catch (Exception ex) {
            }
        }                
    }

    private List<IPanelShowPersonBasic> sortPanelShowPerson(List<IPanelShowPersonBasic> panelShowPersons) {
        for (int i = 0; i < panelShowPersons.size(); i++) {
            for (int j = i + 1; j < panelShowPersons.size(); j++) {
                if (panelShowPersons.get(i).getLevelPanelShowPersonBasic()
                        > panelShowPersons.get(j).getLevelPanelShowPersonBasic()) {
                    IPanelShowPersonBasic pse = panelShowPersons.get(i);
                    panelShowPersons.set(i, panelShowPersons.get(j));
                    panelShowPersons.set(j, pse);
                }
            }
        }
        return panelShowPersons;
    }

    @Override
    public PanelControlShowInformation getPanelControlShowInformation() {
        return controlShow;
    }

    @Override
    public void loadPerson(Person Person) {
        for (int i = 0; i < panelShowPersons.size(); i++) {
            panelShowPersons.get(i).setPersonShow(Person);
        }
    }

    @Override
    public List<IPanelShowTotal> getListPanelShow() {
        List<IPanelShowTotal> ls = new ArrayList<IPanelShowTotal>();
        for (int i = 0; i < panelShowPersons.size(); i++) {
            ls.add(panelShowPersons.get(i));
        }
        return ls;
    }

    @Override
    public void setParent(IPanelShowInformation panelShowInformationParent) {
        if (panelShowInformationParent instanceof IPanelShowPersonBasic) {
            panelShowPersons.set(0, (IPanelShowPersonBasic) panelShowInformationParent);
        }
    }

//    @Override
//    public List<IPanelShowInformation> getPanelShowInformations() {
//        List<IPanelShowInformation> lsi = new ArrayList<IPanelShowInformation>();
//        for (int i=0;i<panelShowPersons.size();i++){
//            lsi.add(panelShowPersons.get(i));
//        }
//        return lsi;
//    }
}
