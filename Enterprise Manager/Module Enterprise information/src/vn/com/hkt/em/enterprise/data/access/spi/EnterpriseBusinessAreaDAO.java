/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.enterprise.data.access.spi;

import org.openide.util.lookup.ServiceProvider;
import vn.com.hkt.em.core.access.manager.AccessManager;
import vn.com.hkt.em.enterprise.data.access.api.IEnterpriseBusinessAreaDAO;
import vn.com.hkt.em.enterprise.data.entities.EnterpriseBusinessArea;
import vn.com.hkt.em.enterprise.data.jpa.PersistenceUtilityEnterpriseInformation;

/**
 * đối tượng truy xuất cơ sở dữ liệu lĩnh vực kinh doanh của doanh nghiệp
 * @author BinLe
 */
@ServiceProvider(service = IEnterpriseBusinessAreaDAO.class)
public class EnterpriseBusinessAreaDAO extends AccessManager<EnterpriseBusinessArea> implements IEnterpriseBusinessAreaDAO {

    public EnterpriseBusinessAreaDAO() {
        setAccessData(PersistenceUtilityEnterpriseInformation.getEntityManagerFactory(), EnterpriseBusinessArea.class);
    }
}
