/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.enterprise.data.entities;

import org.openide.util.lookup.ServiceProvider;
import vn.com.hkt.em.core.access.manager.AccessManager;
import vn.com.hkt.em.enterprise.data.access.api.IEnterpriseAddressDAO;

import vn.com.hkt.em.enterprise.data.jpa.PersistenceUtilityEnterpriseInformation;

/**
 * đối tượng truy xuất cơ sở dữ liệu địa chỉ doanh nghiệp
 * @author BinLe
 */
@ServiceProvider(service = IEnterpriseAddressDAO.class)
public class EnterpriseAddressDAO extends AccessManager<EnterpriseAddress> implements IEnterpriseAddressDAO {

    public EnterpriseAddressDAO() {
        setAccessData(PersistenceUtilityEnterpriseInformation.getEntityManagerFactory(), EnterpriseAddress.class);
    }
}
