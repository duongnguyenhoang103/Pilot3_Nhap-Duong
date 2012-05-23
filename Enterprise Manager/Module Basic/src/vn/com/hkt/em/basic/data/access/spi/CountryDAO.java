/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.basic.data.access.spi;

import org.openide.util.lookup.ServiceProvider;
import vn.com.hkt.em.basic.data.access.api.ICountryDAO;

import vn.com.hkt.em.basic.data.entities.Country;
import vn.com.hkt.em.basic.data.jpa.PersistenceUtilityBasic;
import vn.com.hkt.em.core.access.spi.AccessData;

/**
 * Đối tượng truy xuất cơ sở dữ liệu quốc gia
 * @author BinLe
 */
@ServiceProvider(service=ICountryDAO.class)
public class CountryDAO extends AccessData<Country> implements ICountryDAO {

    public CountryDAO() {
        setAccessData(PersistenceUtilityBasic.getEntityManagerFactory(), Country.class);
    }
}
