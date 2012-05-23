/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.enterprise.business.provider.panel.spi;

import java.util.ArrayList;
import java.util.List;

import vn.com.hkt.em.basic.data.entities.Enterprise;
import vn.com.hkt.em.enterprise.business.provider.panel.api.IProviderPanelShowEnterpriseAddress;
import vn.com.hkt.em.enterprise.data.access.api.IEnterpriseAddressDAO;
import vn.com.hkt.em.enterprise.data.entities.EnterpriseAddress;
import vn.com.hkt.em.enterprise.data.entities.EnterpriseAddressDAO;

/**
 *
 * @author BinLe
 */
public class ProviderPanelShowEnterpriseAddress implements IProviderPanelShowEnterpriseAddress {

    private List<EnterpriseAddress> enterpriseAddresses;
    private IEnterpriseAddressDAO enterpriseAddressDAO = new EnterpriseAddressDAO();
    private Enterprise enterprise;

    public ProviderPanelShowEnterpriseAddress() {
        enterprise = new Enterprise();
        enterpriseAddresses = new ArrayList<EnterpriseAddress>();
    }

    @Override
    public long addData(long idParent) {
        for (EnterpriseAddress ea : enterpriseAddresses) {
            ea.setIdEnterprise(idParent);
            if (!enterpriseAddressDAO.insert(ea)) {
                return ID_FAIL;
            }            
        }
        return 0;
    }

    @Override
    public void refreshData() {
        enterpriseAddresses = enterpriseAddressDAO.select(
                EnterpriseAddress.FIELD_ID_ENTERPRISE,
                String.valueOf(enterprise.getId()),
                IEnterpriseAddressDAO.SORT_ASC,
                EnterpriseAddress.FIELD_INDEX);
        if (enterpriseAddresses == null) {
            enterpriseAddresses = new ArrayList<EnterpriseAddress>();
        }
    }

    @Override
    public long editData() {
        //TODO chua xoas
        for (EnterpriseAddress ea : enterpriseAddresses) {
            if (ea.getId() > 0) {
                if (!enterpriseAddressDAO.update(ea)) {
                    return ID_FAIL;
                }
            } else {
                ea.setIdEnterprise(enterprise.getId());
                if (!enterpriseAddressDAO.insert(ea)) {
                    return ID_FAIL;
                }
            }
        }
        return 0;
    }

    @Override
    public long removeData() {
        for (EnterpriseAddress ea : enterpriseAddresses) {
            if (!enterpriseAddressDAO.deleteById(ea.getId())) {
                return ID_FAIL;
            }
        }
        return 0;
    }

    /**
     *  Thực hiện chức năng hiển thị dữ liệu của đối tượng được truyền vào
     * @param obj :E đối tượng truyền vào để hiển thị
     */
    @Override
    public void setDataView(Enterprise obj) {
        this.enterprise = obj;
        enterpriseAddresses = enterpriseAddressDAO.select(
                EnterpriseAddress.FIELD_ID_ENTERPRISE,
                String.valueOf(enterprise.getId()),
                IEnterpriseAddressDAO.SORT_ASC,
                EnterpriseAddress.FIELD_INDEX);
        if (enterpriseAddresses == null) {
            enterpriseAddresses = new ArrayList<EnterpriseAddress>();
        }
    }

    @Override
    public Enterprise getDataViewCurrent() {
        return enterprise;
    }

    @Override
    public List<EnterpriseAddress> getEnterpriseAddresses() {
        return enterpriseAddresses;
    }

    @Override
    public void setEnterpriseAddresses(List<EnterpriseAddress> enterpriseAddresses) {
        this.enterpriseAddresses = enterpriseAddresses;
    }
}
