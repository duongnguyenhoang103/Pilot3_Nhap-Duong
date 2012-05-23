/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.enterprise.data.access.spi;

import org.openide.util.lookup.ServiceProvider;
import vn.com.hkt.em.enterprise.data.entities.EnterpriseType;
import vn.com.hkt.em.core.access.spi.AccessData;
import vn.com.hkt.em.enterprise.data.access.api.IEnterpriseTypeDAO;
import vn.com.hkt.em.enterprise.data.jpa.PersistenceUtilityEnterpriseInformation;

/**
 * Đối tượng truy xuất cơ sở dữ liệu loại hình doanh nghiệp
 * @author BinLe
 */
@ServiceProvider(service=IEnterpriseTypeDAO.class)
public class EnterpriseTypeDAO extends AccessData<EnterpriseType> implements IEnterpriseTypeDAO {

    public EnterpriseTypeDAO() {
        setAccessData(PersistenceUtilityEnterpriseInformation.getEntityManagerFactory(), EnterpriseType.class);
    }
}
