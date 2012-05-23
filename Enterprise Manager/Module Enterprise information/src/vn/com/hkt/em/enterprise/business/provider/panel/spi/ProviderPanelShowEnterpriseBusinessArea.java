/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.enterprise.business.provider.panel.spi;

import java.util.ArrayList;
import java.util.List;

import vn.com.hkt.em.basic.data.entities.Enterprise;
import vn.com.hkt.em.enterprise.business.provider.panel.api.IProviderPanelShowEnterpriseBusinessArea;
import vn.com.hkt.em.enterprise.data.access.api.IBusinessAreaDAO;
import vn.com.hkt.em.enterprise.data.access.api.IEnterpriseBusinessAreaDAO;
import vn.com.hkt.em.enterprise.data.access.spi.BusinessAreaDAO;
import vn.com.hkt.em.enterprise.data.access.spi.EnterpriseBusinessAreaDAO;
import vn.com.hkt.em.enterprise.data.entities.EnterpriseBusinessArea;

/**
 *
 * @author BinLe
 */
public class ProviderPanelShowEnterpriseBusinessArea implements IProviderPanelShowEnterpriseBusinessArea {

    private List<EnterpriseBusinessArea> enterpriseBusinessAreas;
    private IEnterpriseBusinessAreaDAO enterpriseBusinessAreaDAO = new EnterpriseBusinessAreaDAO();
    private Enterprise enterprise;
    private IBusinessAreaDAO businessAreaDAO = new BusinessAreaDAO();

    @Override
    public long addData(long idParent) {
        for (EnterpriseBusinessArea eba : enterpriseBusinessAreas) {
            eba.setIdEnterprise(idParent);
            if (!enterpriseBusinessAreaDAO.insert(eba)) {
                return ID_FAIL;
            }
        }
        return 0;
    }

    @Override
    public void refreshData() {
        enterpriseBusinessAreas = enterpriseBusinessAreaDAO.select(
                EnterpriseBusinessArea.FIELD_ID_ENTERPRISE,
                String.valueOf(enterprise.getId()),
                IEnterpriseBusinessAreaDAO.SORT_ASC,
                EnterpriseBusinessArea.FIELD_RANKING);
        if (enterpriseBusinessAreas == null) {
            enterpriseBusinessAreas = new ArrayList<EnterpriseBusinessArea>();
        }
    }

    @Override
    public long editData() {
        //TODO chua xoa
        for (EnterpriseBusinessArea eba : enterpriseBusinessAreas) {
            if (eba.getId() > 0) {
                if (!enterpriseBusinessAreaDAO.update(eba)) {
                    return ID_FAIL;
                }
            } else {
                eba.setIdEnterprise(enterprise.getId());
                if (!enterpriseBusinessAreaDAO.insert(eba)) {
                    return ID_FAIL;
                }
            }
        }
        return 0;
    }

    @Override
    public long removeData() {
        for (EnterpriseBusinessArea eba : enterpriseBusinessAreas) {
            if (!enterpriseBusinessAreaDAO.deleteById(eba.getId())) {
                return ID_FAIL;
            }
        }
        return 0;
    }

    @Override
    public void setDataView(Enterprise obj) {
        this.enterprise = obj;
        enterpriseBusinessAreas = enterpriseBusinessAreaDAO.select(
                EnterpriseBusinessArea.FIELD_ID_ENTERPRISE,
                String.valueOf(enterprise.getId()),
                IEnterpriseBusinessAreaDAO.SORT_ASC,
                EnterpriseBusinessArea.FIELD_RANKING);
    }

    @Override
    public Enterprise getDataViewCurrent() {
        return enterprise;
    }

    @Override
    public void setEnterpriseBusinessAreas(List<EnterpriseBusinessArea> enterpriseBusinessAreas) {
        this.enterpriseBusinessAreas = enterpriseBusinessAreas;
    }

    @Override
    public List<EnterpriseBusinessArea> getEnterpriseBusinessAreas() {
        return enterpriseBusinessAreas;
    }
}
