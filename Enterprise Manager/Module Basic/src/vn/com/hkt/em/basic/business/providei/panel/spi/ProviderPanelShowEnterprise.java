/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.basic.business.providei.panel.spi;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import org.openide.util.lookup.ServiceProvider;
import vn.com.hkt.em.basic.business.provide.panel.api.IProviderPanelShowEnterprise;
import vn.com.hkt.em.basic.data.access.api.ICityDAO;
import vn.com.hkt.em.basic.data.access.api.ICountryDAO;
import vn.com.hkt.em.basic.data.access.api.IEnterpriseDAO;
import vn.com.hkt.em.basic.data.access.spi.CityDAO;
import vn.com.hkt.em.basic.data.access.spi.CountryDAO;
import vn.com.hkt.em.basic.data.access.spi.EnterpriseDAO;
import vn.com.hkt.em.basic.data.entities.City;
import vn.com.hkt.em.basic.data.entities.Country;
import vn.com.hkt.em.basic.data.entities.Enterprise;
import vn.com.hkt.em.common.data.CheckData;

/**
 * Đối tượng cung cấp dữ liệu, nhân dữ liệu, nhận lệnh từ giao diện
 * hiển thị thông tin doanh nghiệp
 * @author BinLe
 */
@ServiceProvider(service = IProviderPanelShowEnterprise.class)
public class ProviderPanelShowEnterprise implements IProviderPanelShowEnterprise {

    private Enterprise enterprise;
    private EnterpriseDAO edao = new EnterpriseDAO();
    private List<Long> listIdEnterpriseChilren = new ArrayList<Long>();

    public ProviderPanelShowEnterprise() {
        enterprise = new Enterprise();
    }

    public ProviderPanelShowEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
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
            lc.add(0, null);
        }
        return lc;
    }

    private void loadEnterprisesChildren(Enterprise enterprise) {
        if (enterprise == null) {
            return;
        }
        listIdEnterpriseChilren.add(enterprise.getId());
        List<Enterprise> lec = edao.select(Enterprise.FIELD_ID_ENTERPRISE_PARENT, String.valueOf(enterprise.getId()));
        for (int i = 0; i < lec.size(); i++) {
            if (!listIdEnterpriseChilren.contains(lec.get(i).getId())) {
                loadEnterprisesChildren(lec.get(i));
            }
        }
    }

    @Override
    public List<Enterprise> getEnterprisesAbilityIsParent() {
        List<Enterprise> le = new EnterpriseDAO().selectAll(IEnterpriseDAO.SORT_ASC, Enterprise.FIELD_ENTERPRISE_NAME);
        if (enterprise != null && enterprise.getId() > 0) {
            listIdEnterpriseChilren = new ArrayList<Long>();
            loadEnterprisesChildren(enterprise);
            for (int i = 0; i < le.size();) {
                if (listIdEnterpriseChilren.contains(le.get(i).getId())) {
                    le.remove(i);
                } else {
                    i++;
                }
            }
        }
        le.add(0, null);
        return le;
    }

    @Override
    public long addData(long idParent) {
        if (!checkData()) {
            return ID_FAIL;
        }
        if (edao.insert(enterprise)) {
            return enterprise.getId();
        } else {
            return ID_FAIL;
        }
    }

    @Override
    public long editData() {
        if (!checkData()) {
            return ID_FAIL;
        }
        if (edao.update(enterprise)) {
            return enterprise.getId();
        } else {
            return ID_FAIL;
        }
    }

    @Override
    public long removeData() {
        long id = enterprise.getId();
        if (edao.deleteById(id)) {
            return id;
        }
        return ID_FAIL;
    }

    @Override
    public void setDataView(Enterprise obj) {
        try {
            enterprise = (Enterprise) obj;
        } catch (Exception e) {
            enterprise = new Enterprise();
        }

    }

    private boolean checkData() {
        CheckData checkData = new CheckData();
        if (enterprise.getEnterpriseName().isEmpty()) {
            return false;
        }
        if (!checkData.isNumberPhone(enterprise.getTelephone())) {
            return false;
        }
        if (!checkData.isNumberPhone(enterprise.getFax())) {
            return false;
        }
        return true;
    }

    @Override
    public void refreshData() {
        enterprise = edao.getById(enterprise.getId());
        if (enterprise == null) {
            enterprise = new Enterprise();
        }
    }

    @Override
    public Enterprise getDataViewCurrent() {
        return enterprise;
    }
}
