/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.basic.presentation.controlshow.spi;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.openide.util.Lookup;
import vn.com.hkt.em.basic.data.entities.Enterprise;
import vn.com.hkt.em.basic.presentation.controlshow.api.IControlShowEnterprise;

import vn.com.hkt.em.basic.presentation.panel.show.api.IPanelShowEnterpriseBaisc;
import vn.com.hkt.em.common.gui.panel.controlshow.spi.PanelControlShowInformation;
import vn.com.hkt.em.common.gui.panel.show.api.IPanelShowInformation;
import vn.com.hkt.em.common.gui.panel.show.api.IPanelShowTotal;

/**
 *
 * @author duong
 */
public class ControlShowEnterprise implements IControlShowEnterprise {

    private List<IPanelShowEnterpriseBaisc> listIPanelShowEnterprisesBasic;// danh sách các giao diện thông tin của doanh nghiệp(cơ bản)
    private PanelControlShowInformation panelControlShowInformation;// Giao diện điều khiển hiển thị thông tin của doanh nghiệp    

    public ControlShowEnterprise() {
        loadPanelShow();
    }

    @Override
    public void loadPanelShow() {
        listIPanelShowEnterprisesBasic = new ArrayList<IPanelShowEnterpriseBaisc>();
        List<IPanelShowEnterpriseBaisc> lpseb = (List<IPanelShowEnterpriseBaisc>) Lookup.getDefault().lookupAll(IPanelShowEnterpriseBaisc.class);
        lpseb = sortPanelShowEnterprise(lpseb);
        for (int i = 0; i < lpseb.size(); i++) {
            try {
                IPanelShowEnterpriseBaisc pse = lpseb.get(i).getClass().newInstance();
                listIPanelShowEnterprisesBasic.add(pse);
            } catch (Exception ex) {
            }
        }
        panelControlShowInformation = new PanelControlShowInformation(this);
    }

    /**
     * sắp xếp các giao diện hiển thị thông tin doanh nghiệp theo thứ tự Level
     * @param panelShowEnterprises: List<IPanelShowEnterpriseBaisc>
     * danh sách giao diện truyền vòa
     * @return List<IPanelShowEnterpriseBaisc>
     * danh sách giao diện đã đực sắp xếp
     */
    private List<IPanelShowEnterpriseBaisc> sortPanelShowEnterprise(List<IPanelShowEnterpriseBaisc> panelShowEnterprises) {
        List<IPanelShowEnterpriseBaisc> lst = new ArrayList<IPanelShowEnterpriseBaisc>();
        int l = panelShowEnterprises.size();
        boolean[] found = new boolean[l];
        for (int i = 0; i < l; i++) {
            found[i] = true;
        }
        for (int i = 0; i < l; i++) {
            long min = Long.MAX_VALUE, index = -1;
            for (int j = 0; j < panelShowEnterprises.size(); j++) {
                if (panelShowEnterprises.get(j).getLevelPanelShowEnterpriseBasic() < min && found[j]) {
                    min = panelShowEnterprises.get(j).getLevelPanelShowEnterpriseBasic();
                    index = j;
                }
            }
            if (index >= 0) {
                lst.add(panelShowEnterprises.get((int) index));
                found[(int) index] = false;
            }
        }
        return lst;
    }

    @Override
    public void loadEnterprise(Enterprise enterprise) {
        for (int i = 0; i < listIPanelShowEnterprisesBasic.size(); i++) {
            listIPanelShowEnterprisesBasic.get(i).setEnterprise(enterprise);
        }
    }

    @Override
    public List<IPanelShowTotal> getListPanelShow() {
        List<IPanelShowTotal> ls = new ArrayList<IPanelShowTotal>();
        for (int i = 0; i < listIPanelShowEnterprisesBasic.size(); i++) {
            ls.add(listIPanelShowEnterprisesBasic.get(i));
        }
        return ls;
    }

    @Override
    public PanelControlShowInformation getPanelControlShowInformation() {
        return panelControlShowInformation;
    }

    @Override
    public void setParent(IPanelShowInformation panelShowInformationParent) {
        if (panelShowInformationParent instanceof IPanelShowEnterpriseBaisc) {
            listIPanelShowEnterprisesBasic.set(0, (IPanelShowEnterpriseBaisc) panelShowInformationParent);
        }
    }
}
