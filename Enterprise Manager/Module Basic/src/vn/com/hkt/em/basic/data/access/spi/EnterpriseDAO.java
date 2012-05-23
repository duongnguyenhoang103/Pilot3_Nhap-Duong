/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.basic.data.access.spi;

import org.openide.util.lookup.ServiceProvider;
import vn.com.hkt.em.basic.data.access.api.IEnterpriseDAO;
import vn.com.hkt.em.basic.data.entities.Enterprise;
import vn.com.hkt.em.basic.data.jpa.PersistenceUtilityBasic;
import vn.com.hkt.em.core.access.manager.AccessManager;

/**
 * Đối tượng truy xuất cơ sở dữ liệu doanh nghiệp
 * @author BinLe
 */
@ServiceProvider(service=IEnterpriseDAO.class)
public class EnterpriseDAO extends AccessManager<Enterprise> implements IEnterpriseDAO {

    public EnterpriseDAO() {
        setAccessData(PersistenceUtilityBasic.getEntityManagerFactory(), Enterprise.class);
    }
}
