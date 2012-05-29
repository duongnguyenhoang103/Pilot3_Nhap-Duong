/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.basic.business.provide.dialog.spi;

import java.util.ArrayList;
import java.util.List;
import org.openide.util.lookup.ServiceProvider;
import vn.com.hkt.em.basic.business.provide.dialog.api.ICountryDialogProvider;
import vn.com.hkt.em.basic.data.access.api.ICountryDAO;
import vn.com.hkt.em.basic.data.entities.Country;
import vn.com.hkt.em.basic.data.access.spi.CountryDAO;

/**
 *
 * @author BinLe
 */
@ServiceProvider(service = ICountryDialogProvider.class)
public class CountryDialogProvider implements ICountryDialogProvider {

    private Country countryBE;
    private ICountryDAO countryDAO = new CountryDAO();
    private List<Country> countries = new ArrayList<Country>();

    public CountryDialogProvider() {
        countryBE = new Country();
        loadAllCountries();
    }

    @Override
    public void setDataView(Country country) {
        this.countryBE = country;
    }

    @Override
    public Country getDataViewCurrent() {
        return countryBE;
    }

    @Override
    public long addData(long idParent) {
        if (checkData()) {
            return ID_FAIL;
        }
        if (countryDAO.insert(countryBE)) {
            return countryBE.getId();
        }
        return ID_FAIL;
    }

    private boolean checkData() {
        if (countryBE.getCountryName().isEmpty()) {
            return true;
        }
        return false;
    }

    @Override
    public long editData() {
        if (checkData()) {
            return ID_FAIL;
        }
        if (countryDAO.update(countryBE)) {
            return countryBE.getId();
        }
        return ID_FAIL;
    }

    @Override
    public long removeData() {
        long id = countryBE.getId();
        if (countryDAO.deleteById(id)) {
            return id;
        }
        return ID_FAIL;
    }

    @Override
    public void loadAllCountries() {
        countries = countryDAO.selectAll(ICountryDAO.SORT_ASC, Country.FIELD_COUNTRY_NAME);
    }

    @Override
    public List<Country> getListCountries() {
        return countries;
    }

    @Override
    public void refreshData() {
        countryBE = countryDAO.getById(countryBE.getId());
        if (countryBE == null) {
            countryBE = new Country();
        }
    }

   
}
