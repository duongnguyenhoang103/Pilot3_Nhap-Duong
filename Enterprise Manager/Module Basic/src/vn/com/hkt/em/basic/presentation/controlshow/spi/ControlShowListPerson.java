/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.basic.presentation.controlshow.spi;

import java.util.ArrayList;
import java.util.List;
import org.openide.util.Lookup;
import vn.com.hkt.em.basic.presentation.controlshow.api.IControlShowListPerson;
import vn.com.hkt.em.basic.presentation.panel.show.api.IPanelShowListPersonBasic;
import vn.com.hkt.em.common.gui.panel.controlshow.spi.PanelControlShowListInformation;
import vn.com.hkt.em.common.gui.panel.show.api.IPanelShowListInformation;
import vn.com.hkt.em.common.gui.panel.show.api.IPanelShowTotal;

/**
 * Đối tượng điều khiển hiển thị danh sách thông tin doanh nghiệp
 * @author BinLe
 */
public class ControlShowListPerson implements IControlShowListPerson {

    private List<IPanelShowListPersonBasic> panelShowListPersonBasics;// danh sách các 
    private PanelControlShowListInformation panelControlShowListInformation;

    public ControlShowListPerson() {
        loadPanelShow();
    }

    @Override
    public PanelControlShowListInformation getPanelControlShowListInformation() {
        return panelControlShowListInformation;
    }
    // sắp xếp danh sách hiển thị theo thứ tự LEVEL

    private List<IPanelShowListPersonBasic> sortPanelShowListPerson(List<IPanelShowListPersonBasic> panelShowPersons) {
        for (int i = 0; i < panelShowPersons.size(); i++) {
            for (int j = i + 1; j < panelShowPersons.size(); j++) {
                if (panelShowPersons.get(i).getLevelPanelShowListPersonBasic()
                        > panelShowPersons.get(j).getLevelPanelShowListPersonBasic()) {
                    IPanelShowListPersonBasic pse = panelShowPersons.get(i);
                    panelShowPersons.set(i, panelShowPersons.get(j));
                    panelShowPersons.set(j, pse);
                }
            }
        }
        return panelShowPersons;
    }

    @Override
    public void loadPanelShow() {
        panelShowListPersonBasics = new ArrayList<IPanelShowListPersonBasic>();
        List<IPanelShowListPersonBasic> list =
                (List<IPanelShowListPersonBasic>) Lookup.getDefault().lookupAll(IPanelShowListPersonBasic.class);
        list = sortPanelShowListPerson(list);
        for (int i = 0; i < list.size(); i++) {
            try {
                IPanelShowListPersonBasic ipsleb = list.get(i).getClass().newInstance();
                panelShowListPersonBasics.add(ipsleb);
            } catch (Exception e) {
            }
        }
        for (int i = 0; i < panelShowListPersonBasics.size(); i++) {
            panelShowListPersonBasics.get(i).setControlShowListInformation(this);
        }
    }

    @Override
    public List<IPanelShowTotal> getListPanelShow() {
        List<IPanelShowTotal> ls = new ArrayList<IPanelShowTotal>();
        for (int i = 0; i < panelShowListPersonBasics.size(); i++) {
            ls.add(panelShowListPersonBasics.get(i));
        }
        return ls;
    }

    @Override
    public void setPanelControlShowListInformation(PanelControlShowListInformation panelControlShowListInformation) {
        this.panelControlShowListInformation = panelControlShowListInformation;
    }

    @Override
    public void setListIdParentShow(List<Long> listIdParentShow) {
      
    }
}
