/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.enterprise.data.access.spi;

import org.openide.util.lookup.ServiceProvider;
import vn.com.hkt.em.core.access.manager.AccessManager;
import vn.com.hkt.em.enterprise.data.access.api.IEnterpriseLegalDAO;

import vn.com.hkt.em.enterprise.data.entities.EnterpriseLegal;
import vn.com.hkt.em.enterprise.data.jpa.PersistenceUtilityEnterpriseInformation;

/**
 * đối tượng truy xuất cơ sở dữ liệu thông tin pháp lý doanh nghiệp
 * @author duong
 */
@ServiceProvider(service = IEnterpriseLegalDAO.class)
public class EnterpriseLegalDAO extends AccessManager<EnterpriseLegal> implements IEnterpriseLegalDAO {

    public EnterpriseLegalDAO() {
        setAccessData(PersistenceUtilityEnterpriseInformation.getEntityManagerFactory(), EnterpriseLegal.class);
    }
}
