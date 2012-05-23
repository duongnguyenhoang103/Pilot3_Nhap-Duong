/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.basic.data.access.spi;

import org.openide.util.lookup.ServiceProvider;
import vn.com.hkt.em.basic.data.access.api.IMAritalStatusDAO;
import vn.com.hkt.em.basic.data.entities.MaritalStatus;
import vn.com.hkt.em.basic.data.jpa.PersistenceUtilityBasic;
import vn.com.hkt.em.core.access.spi.AccessData;

/**
 * Đối tượng truy xuất cơ sở dữ liệu tình trạng hôn nhân
 * @author BinLe
 */
@ServiceProvider(service=IMAritalStatusDAO.class)
public class MaritalStatusDAO extends AccessData<MaritalStatus> implements IMAritalStatusDAO {

    public MaritalStatusDAO() {
        setAccessData(PersistenceUtilityBasic.getEntityManagerFactory(), MaritalStatus.class);
    }
}