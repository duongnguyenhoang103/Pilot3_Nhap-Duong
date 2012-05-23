/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.basic.presentation.controlshow.spi;

import java.util.ArrayList;
import java.util.List;
import org.openide.util.Lookup;
import vn.com.hkt.em.basic.presentation.controlshow.api.IControlShowListEnterprise;
import vn.com.hkt.em.basic.presentation.panel.show.api.IPanelShowListEnterpriseBasic;
import vn.com.hkt.em.common.gui.panel.controlshow.spi.PanelControlShowListInformation;
import vn.com.hkt.em.common.gui.panel.show.api.IPanelShowTotal;

/**
 * Đối tượng điều khiển hiển thị danh sách thông tin doanh nghiệp
 * @author BinLe
 */
public class ControlShowListEnterprise implements IControlShowListEnterprise {

    private List<IPanelShowListEnterpriseBasic> panelShowListEnterpriseBasics;// danh sách mặt nạ giao diện hiển thị danh sách thông tin doanh nghiệp
    private PanelControlShowListInformation panelControlShowListInformation;// giao diện điều khiển hiển thị danh sách thông tin doanh nghiệp

    public ControlShowListEnterprise() {
        loadPanelShow();
    }

    @Override
    public void loadPanelShow() {
        panelShowListEnterpriseBasics = new ArrayList<IPanelShowListEnterpriseBasic>();
        List<IPanelShowListEnterpriseBasic> list =
                (List<IPanelShowListEnterpriseBasic>) Lookup.getDefault().lookupAll(IPanelShowListEnterpriseBasic.class);
        list = sortPanelShowListEnterprise(list);
        for (int i = 0; i < list.size(); i++) {
            try {
                IPanelShowListEnterpriseBasic ipsleb = list.get(i).getClass().newInstance();
                panelShowListEnterpriseBasics.add(ipsleb);
            } catch (Exception e) {
            }
        }
        for (int i = 0; i < panelShowListEnterpriseBasics.size(); i++) {
            panelShowListEnterpriseBasics.get(i).setControlShowListInformation(this);
        }
    }
    // sắp xếp dnah sách giao diện theo thứ tự LEVEL
    private List<IPanelShowListEnterpriseBasic> sortPanelShowListEnterprise(List<IPanelShowListEnterpriseBasic> panelShowEnterprises) {
        for (int i = 0; i < panelShowEnterprises.size(); i++) {
            for (int j = i + 1; j < panelShowEnterprises.size(); j++) {
                if (panelShowEnterprises.get(i).getLevelPanelShowListEnterpriseBasic()
                        > panelShowEnterprises.get(j).getLevelPanelShowListEnterpriseBasic()) {
                    IPanelShowListEnterpriseBasic pse = panelShowEnterprises.get(i);
                    panelShowEnterprises.set(i, panelShowEnterprises.get(j));
                    panelShowEnterprises.set(j, pse);
                }
            }
        }
        return panelShowEnterprises;
    }

    @Override
    public List<IPanelShowTotal> getListPanelShow() {
        List<IPanelShowTotal> ls = new ArrayList<IPanelShowTotal>();
        for (int i = 0; i < panelShowListEnterpriseBasics.size(); i++) {
            ls.add(panelShowListEnterpriseBasics.get(i));
        }
        return ls;
    }

    @Override
    public PanelControlShowListInformation getPanelControlShowListInformation() {
        return panelControlShowListInformation;
    }

    @Override
    public void setPanelControlShowListInformation(PanelControlShowListInformation panelControlShowListInformation) {
        this.panelControlShowListInformation = panelControlShowListInformation;
    }

    @Override
    public void setListIdParentShow(List<Long> listIdParentShow) {
       
    }
}
