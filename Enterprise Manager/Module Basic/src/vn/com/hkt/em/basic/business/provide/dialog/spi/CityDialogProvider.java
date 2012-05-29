/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.basic.business.provide.dialog.spi;

import java.util.ArrayList;
import java.util.List;
import org.openide.util.lookup.ServiceProvider;
import vn.com.hkt.em.basic.business.provide.dialog.api.ICityDialogProvider;
import vn.com.hkt.em.basic.data.access.api.ICityDAO;
import vn.com.hkt.em.basic.data.access.api.ICountryDAO;
import vn.com.hkt.em.basic.data.entities.City;
import vn.com.hkt.em.basic.data.entities.Country;
import vn.com.hkt.em.basic.data.access.spi.CityDAO;
import vn.com.hkt.em.basic.data.access.spi.CountryDAO;

/**
 *
 * @author BinLe
 */
@ServiceProvider(service = ICityDialogProvider.class)
public class CityDialogProvider implements ICityDialogProvider {

    private City city;
    private CityDAO citydao = new CityDAO();
    private List<City> cities = new ArrayList<City>();

    public CityDialogProvider() {
        city = new City();
    }

    @Override
    public long addData(long idParent) {
        if (!checkData()) {
            return ID_FAIL;
        }
        if (citydao.insert(city)) {
            return city.getId();
        } else {
            return ID_FAIL;
        }
    }

    private boolean checkData() {
        if (city.getCityName() == null || city.getCityName().isEmpty()) {
            return false;
        }
        if (city.getIdCountry() == ID_FAIL) {
            return false;
        }
        return true;
    }

    @Override
    public long editData() {
        if (!checkData()) {
            return ID_FAIL;
        }
        if (citydao.update(city)) {
            return city.getId();
        }
        return ID_FAIL;
    }

    @Override
    public long removeData() {
        long id = city.getId();
        if (citydao.deleteById(id)) {
            return id;
        }
        return ID_FAIL;
    }

    @Override
    public void setDataView(City obj) {
        this.city = obj;
    }

    @Override
    public void loadListCity() {
        cities = citydao.select(City.FIELD_ID_COUNTRY, String.valueOf(city.getIdCountry()), ICountryDAO.SORT_ASC, City.FIELD_CITY_NAME);
    }

    @Override
    public List<City> getListCity() {
        return cities;
    }

    @Override
    public List<City> getListCity(Country country) {
        if (country == null) {
            return new ArrayList<City>();
        }
        return citydao.select(City.FIELD_ID_COUNTRY, String.valueOf(country.getId()), ICountryDAO.SORT_ASC, City.FIELD_CITY_NAME);
    }

    @Override
    public List<Country> getListCountry() {
        return new CountryDAO().selectAll(ICountryDAO.SORT_ASC, Country.FIELD_COUNTRY_NAME);
    }

    @Override
    public City getDataViewCurrent() {
        return city;
    }

    @Override
    public void refreshData() {
        city = citydao.getById(city.getId());
        if (city == null) {
            city = new City();
        }
    }

    @Override
    public void loadAllCities() {

        cities = citydao.selectAll(ICityDAO.SORT_ASC, City.FIELD_CITY_NAME);
    }
}
