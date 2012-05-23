/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.enterprise.presentation.controlshow.spi;

import java.util.ArrayList;
import java.util.List;
import org.openide.util.Lookup;
import org.openide.util.lookup.ServiceProvider;
import vn.com.hkt.em.common.gui.panel.controlshow.spi.PanelControlShowInformation;
import vn.com.hkt.em.common.gui.panel.show.api.IPanelShowInformation;
import vn.com.hkt.em.common.gui.panel.show.api.IPanelShowInformationOverview;
import vn.com.hkt.em.common.gui.panel.show.api.IPanelShowTotal;
import vn.com.hkt.em.enterprise.data.entities.EnterpriseLegal;
import vn.com.hkt.em.enterprise.presentation.controlshow.api.IControlShowEnterpriseLegal;
import vn.com.hkt.em.enterprise.presentation.panel.api.IPanelShowEnterpriseLegal;

/**
 *
 * @author duong
 */
@ServiceProvider(service = IControlShowEnterpriseLegal.class)
public class ControlShowEnterpriseLegal implements IControlShowEnterpriseLegal {

    private List<IPanelShowEnterpriseLegal> panelShowEnterpriseLegals;
    private PanelControlShowInformation panelControlShowInformation;

    @Override
    public void loadEnterpriseLegal(EnterpriseLegal enterpriseLegal) {
        for (int i = 0; i < panelShowEnterpriseLegals.size(); i++) {
            panelShowEnterpriseLegals.get(i).setEnterpriseLegal(enterpriseLegal);

        }
    }

    private List<IPanelShowEnterpriseLegal> sortPanelShowEnterpriseLegal(List<IPanelShowEnterpriseLegal> lpsEnterpriseLegals) {
        for (int i = 0; i < lpsEnterpriseLegals.size(); i++) {
            for (int j = i + 1; j < lpsEnterpriseLegals.size(); j++) {
                if (lpsEnterpriseLegals.get(i).getLevelPanelShowEnterpriseLegal()
                        > lpsEnterpriseLegals.get(j).getLevelPanelShowEnterpriseLegal()) {
                    IPanelShowEnterpriseLegal pse = lpsEnterpriseLegals.get(i);
                    lpsEnterpriseLegals.set(i, lpsEnterpriseLegals.get(j));
                    lpsEnterpriseLegals.set(j, pse);
                }
            }
        }
        return lpsEnterpriseLegals;
    }

    @Override
    public void loadPanelShow() {
        panelShowEnterpriseLegals = new ArrayList<IPanelShowEnterpriseLegal>();
        List<IPanelShowEnterpriseLegal> lpsEnterpriseLegals = (List<IPanelShowEnterpriseLegal>) Lookup.getDefault().lookupAll(IPanelShowEnterpriseLegal.class);
        lpsEnterpriseLegals = sortPanelShowEnterpriseLegal(lpsEnterpriseLegals);
        for(int i = 0 ; i < lpsEnterpriseLegals.size();i++){
            try{
                IPanelShowEnterpriseLegal psel = lpsEnterpriseLegals.get(i).getClass().newInstance();
                panelShowEnterpriseLegals.add(psel);
                if(psel instanceof IPanelShowInformationOverview){
                    ((IPanelShowInformationOverview)psel).setControlShowInformationOverview(this);
                }
            }
            catch(Exception ex){                
            }
            panelControlShowInformation = new PanelControlShowInformation(this);
        }
    }

    @Override
    public PanelControlShowInformation getPanelControlShowInformation() {
        return panelControlShowInformation;
    }

    @Override
    public void setParent(IPanelShowInformation panelShowInformationParent) {
//        if (panelShowInformationParent instanceof IPanelShowEnterpriseLegal) {
//            panelControlShowInformation.getListPanelShow().set(0, panelShowInformationParent);                        
//        }
    }

    @Override
    public List<IPanelShowTotal> getListPanelShow() {
        List<IPanelShowTotal> ls = new ArrayList<IPanelShowTotal>();
        for (int i = 0; i < panelShowEnterpriseLegals.size(); i++) {
            ls.add(panelShowEnterpriseLegals.get(i));
        }
        return ls;

    }
}
