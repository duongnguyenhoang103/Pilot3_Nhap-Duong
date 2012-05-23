/*
 * To change person template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.basic.business.providei.panel.spi;

import java.util.ArrayList;
import java.util.List;
import org.openide.util.lookup.ServiceProvider;
import vn.com.hkt.em.basic.business.provide.panel.api.IProviderPanelShowPerson;
import vn.com.hkt.em.basic.data.access.api.ICityDAO;
import vn.com.hkt.em.basic.data.access.api.ICountryDAO;
import vn.com.hkt.em.basic.data.access.api.IMAritalStatusDAO;
import vn.com.hkt.em.basic.data.access.api.IPersonDAO;
import vn.com.hkt.em.basic.data.access.spi.CityDAO;
import vn.com.hkt.em.basic.data.access.spi.CountryDAO;
import vn.com.hkt.em.basic.data.access.spi.MaritalStatusDAO;
import vn.com.hkt.em.basic.data.access.spi.PersonDAO;
import vn.com.hkt.em.basic.data.entities.City;
import vn.com.hkt.em.basic.data.entities.Country;
import vn.com.hkt.em.basic.data.entities.MaritalStatus;
import vn.com.hkt.em.basic.data.entities.Person;


/**
 * Đối tượng cung cấp dữ liệu, nhân dữ liệu, nhận lệnh từ giao diện
 * hiển thị thông tin cá nhân
 * @author BinLe
 */
@ServiceProvider(service = IProviderPanelShowPerson.class)
public class ProviderPanelShowPerson implements IProviderPanelShowPerson {

    private Person person;
    private IPersonDAO personDAO = new PersonDAO();

    public ProviderPanelShowPerson() {
        person = new Person();
    }

    public ProviderPanelShowPerson(Person person) {
        this.person = person;
    }

    @Override
    public List<Country> getCountries() {
        List<Country> lc = new CountryDAO().selectAll(ICountryDAO.SORT_ASC, Country.FIELD_COUNTRY_NAME);
        lc.add(0, null);
        return lc;
    }

    @Override
    public List<City> getCities(Country country) {
        List<City> lc = new ArrayList<City>();
        if (country != null) {
            lc = new CityDAO().select(City.FIELD_ID_COUNTRY, String.valueOf(country.getId()), ICityDAO.SORT_ASC, City.FIELD_CITY_NAME);
        }
        lc.add(0, null);
        return lc;
    }

    @Override
    public List<MaritalStatus> getMaritalStatuses() {
        List<MaritalStatus> lm = new MaritalStatusDAO().selectAll(IMAritalStatusDAO.SORT_ASC, MaritalStatus.FIELD_MARITAL_STATUS_NAME);
        lm.add(0, null);
        return lm;
    }

    @Override
    public long addData(long idParent) {
        if (!checkData()) {
            return ID_FAIL;
        }
        if (personDAO.insert(person)) {
            return person.getId();
        } else {
            return ID_FAIL;
        }
    }

    @Override
    public long editData() {
        if (!checkData()) {
            return ID_FAIL;
        }
        if (personDAO.update(person)) {
            return person.getId();
        } else {
            return ID_FAIL;
        }
    }

    @Override
    public long removeData() {
        long id = person.getId();
        if (personDAO.deleteById(id)) {
            return id;
        }
        return ID_FAIL;
    }

    @Override
    public void setDataView(Person obj) {
        try {
            this.person = (Person) obj;
        } catch (Exception e) {
            person = new Person();
        }
    }

    private boolean checkData() {
        if (person.getFirstName().isEmpty() || person.getLastName().isEmpty()) {
            return false;
        }
        return true;
    }

    @Override
    public void refreshData() {
        person = personDAO.getById(person.getId());
        if (person == null) {
            person = new Person();
        }
    }

    @Override
    public Person getDataViewCurrent() {
        return person;
    }

    @Override
    public boolean genderIsWomen() {
        return person.getGender().equals(Person.GENDER_WOMEN);
    }

    @Override
    public boolean genderIsMen() {
        return person.getGender().equals(Person.GENDER_MEN);
    }

    @Override
    public void setGenderMen() {
        person.setGender(Person.GENDER_MEN);
    }

    @Override
    public void setGenderWomen() {
        person.setGender(Person.GENDER_WOMEN);
    }
}
