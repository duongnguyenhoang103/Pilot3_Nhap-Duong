/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.basic.business.providei.panel.spi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.openide.util.lookup.ServiceProvider;
import vn.com.hkt.em.basic.business.provide.panel.api.IProviderPanelShowListEnterprise;
import vn.com.hkt.em.basic.data.access.api.IEnterpriseDAO;
import vn.com.hkt.em.basic.data.access.spi.CityDAO;
import vn.com.hkt.em.basic.data.access.spi.CountryDAO;
import vn.com.hkt.em.basic.data.access.spi.EnterpriseDAO;
import vn.com.hkt.em.basic.data.entities.City;
import vn.com.hkt.em.basic.data.entities.Country;
import vn.com.hkt.em.basic.data.entities.Enterprise;

/**
 *Đối tượng cung cấp dữ liệu, nhân dữ liệu, nhận lệnh từ giao diện
 * hiển thị danh sách thông tin doanh nghiệp
 * @author BinLe
 */
@ServiceProvider(service = IProviderPanelShowListEnterprise.class)
public class ProviderPanelShowListEnterprise implements IProviderPanelShowListEnterprise {

    private List<Enterprise> enterprises;
    private EnterpriseDAO enterpriseDAO = new EnterpriseDAO();
    // Kiểu tìm kiếm - tên trường tìm kiếm
    private HashMap<String, String> hashtable2Search = new HashMap<String, String>();

    public ProviderPanelShowListEnterprise() {
        hashtable2Search.put("Mã doanh nghiệp", Enterprise.FIELD_ENTERPRISE_CODE);
        hashtable2Search.put("Tên doanh nghiệp", Enterprise.FIELD_ENTERPRISE_NAME);
        hashtable2Search.put("Địa chỉ", Enterprise.FIELD_ADDRESS);
        hashtable2Search.put("Miêu tả", Enterprise.FIELD_DESCRIPTION);
        hashtable2Search.put("Email", Enterprise.FIELD_EMAIL);
        hashtable2Search.put("Fax", Enterprise.FIELD_FAX);
        hashtable2Search.put("Thành phố", Enterprise.FIELD_ID_CITY);
        hashtable2Search.put("Quốc gia", Enterprise.FIELD_ID_COUNTRY);
        hashtable2Search.put("Doanh nghiệp cha", Enterprise.FIELD_ID_ENTERPRISE_PARENT);
        hashtable2Search.put("Loại hình doanh nghiệp", Enterprise.FIELD_ID_ENTERPRISE_TYPE);
        hashtable2Search.put("Tiêu chí hoạt động", Enterprise.FIELD_SLOGAN);
        hashtable2Search.put("Điện thoại", Enterprise.FIELD_TELEPHONE);
        hashtable2Search.put("Website", Enterprise.FIELD_WEBSITE);

    }

    @Override
    public void loadAllInformation() {
        enterprises = enterpriseDAO.selectAll(IEnterpriseDAO.SORT_ASC, Enterprise.FIELD_ENTERPRISE_NAME);
    }

    @Override
    public List<Enterprise> getListInformation() {
        return enterprises;
    }

    @Override
    public void filterListInformation(String typeSearch, String wordSearch) {
        String typeReadly = hashtable2Search.get(typeSearch);
        if (typeReadly == null || typeReadly.isEmpty() || wordSearch.isEmpty()) {
            loadAllInformation();
            return;
        }
        enterprises = new ArrayList<Enterprise>();
        if (typeReadly.equals(Enterprise.FIELD_ID_CITY)) {
            List<City> cities = new CityDAO().filter(City.FIELD_CITY_NAME, wordSearch);
            if (cities.isEmpty()) {
                return;
            }
            Set<Long> setIdCity = new HashSet<Long>();
            for (int i = 0; i < cities.size(); i++) {
                setIdCity.add(cities.get(i).getId());
            }
            List<Enterprise> es = enterpriseDAO.selectAll(IEnterpriseDAO.SORT_ASC, Enterprise.FIELD_ENTERPRISE_NAME);
            for (Enterprise p : es) {
                if (setIdCity.contains(p.getIdCity())) {
                    enterprises.add(p);
                }
            }
            return;
        }
        if (typeReadly.equals(Enterprise.FIELD_ID_COUNTRY)) {
            List<Country> countries = new CountryDAO().filter(Country.FIELD_COUNTRY_NAME, wordSearch);
            if (countries.isEmpty()) {
                return;
            }
            Set<Long> setIdCountry = new HashSet<Long>();
            for (int i = 0; i < countries.size(); i++) {
                setIdCountry.add(countries.get(i).getId());
            }
            List<Enterprise> es = enterpriseDAO.selectAll(IEnterpriseDAO.SORT_ASC, Enterprise.FIELD_ENTERPRISE_NAME);
            for (Enterprise p : es) {
                if (setIdCountry.contains(p.getIdCountry())) {
                    enterprises.add(p);
                }
            }
            return;
        }
        if (typeReadly.equals(Enterprise.FIELD_ID_ENTERPRISE_PARENT)) {
            List<Enterprise> eps = new EnterpriseDAO().filter(Enterprise.FIELD_ENTERPRISE_NAME, wordSearch);
            if (eps.isEmpty()) {
                return;
            }
            Set<Long> setIdEs = new HashSet<Long>();
            for (int i = 0; i < eps.size(); i++) {
                setIdEs.add(eps.get(i).getId());
            }
            List<Enterprise> es = enterpriseDAO.selectAll(IEnterpriseDAO.SORT_ASC, Enterprise.FIELD_ENTERPRISE_NAME);
            for (Enterprise p : es) {
                if (setIdEs.contains(p.getIdEnterpriseParent())) {
                    enterprises.add(p);
                }
            }
            return;
        }
        enterprises = enterpriseDAO.filter(typeReadly, wordSearch, IEnterpriseDAO.SORT_ASC, Enterprise.FIELD_ENTERPRISE_NAME);
    }

    @Override
    public Object[] getListTypeSearch() {
        return hashtable2Search.keySet().toArray();
    }

    @Override
    public void loaddListInformation(List<Long> listId) {
        enterprises = new ArrayList<Enterprise>();
        for (int i = 0; i < listId.size(); i++) {
            Enterprise enterprise = enterpriseDAO.getById(listId.get(i));
            if (enterprise != null) {
                enterprises.add(enterprise);
            }
        }
    }
}
