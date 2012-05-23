/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.enterprise.data.access.spi;

import org.openide.util.lookup.ServiceProvider;
import vn.com.hkt.em.core.access.spi.AccessData;
import vn.com.hkt.em.enterprise.data.access.api.IBusinessAreaDAO;
import vn.com.hkt.em.enterprise.data.entities.BusinessArea;
import vn.com.hkt.em.enterprise.data.jpa.PersistenceUtilityEnterpriseInformation;

/**
 * Đối tượng truy xuất cơ sở dữ liệu lĩnh vực kinhd doanh
 * @author BinLe
 */
@ServiceProvider(service = IBusinessAreaDAO.class)
public class BusinessAreaDAO extends AccessData<BusinessArea> implements IBusinessAreaDAO {

    public BusinessAreaDAO() {
        setAccessData(PersistenceUtilityEnterpriseInformation.getEntityManagerFactory(), BusinessArea.class);
    }
}
