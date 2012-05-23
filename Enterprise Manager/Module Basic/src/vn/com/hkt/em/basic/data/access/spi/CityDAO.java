/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.basic.data.access.spi;

import org.openide.util.lookup.ServiceProvider;
import vn.com.hkt.em.basic.data.access.api.ICityDAO;

import vn.com.hkt.em.basic.data.entities.City;
import vn.com.hkt.em.basic.data.jpa.PersistenceUtilityBasic;
import vn.com.hkt.em.core.access.spi.AccessData;

/**
 * Đối tượng truy xuất cơ sở dữ liệu thành phố
 * @author BinLe
 */
@ServiceProvider(service=ICityDAO.class)
public class CityDAO extends AccessData<City> implements ICityDAO {

    public CityDAO() {
        setAccessData(PersistenceUtilityBasic.getEntityManagerFactory(), City.class);
    }
}
