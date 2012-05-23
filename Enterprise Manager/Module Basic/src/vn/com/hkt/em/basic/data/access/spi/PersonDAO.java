/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.basic.data.access.spi;

import org.openide.util.lookup.ServiceProvider;
import vn.com.hkt.em.basic.data.access.api.IPersonDAO;
import vn.com.hkt.em.basic.data.entities.Person;
import vn.com.hkt.em.basic.data.jpa.PersistenceUtilityBasic;
import vn.com.hkt.em.core.access.manager.AccessManager;

/**
 * Đối tượng truy xuất cơ sở dữ liệu cá nhân
 * @author BinLe
 */
@ServiceProvider(service = IPersonDAO.class)
public class PersonDAO extends AccessManager<Person> implements IPersonDAO {

    public PersonDAO() {
        setAccessData(PersistenceUtilityBasic.getEntityManagerFactory(), Person.class);
    }
}
