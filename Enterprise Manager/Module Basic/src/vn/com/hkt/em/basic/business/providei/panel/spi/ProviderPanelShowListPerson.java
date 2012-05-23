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
import vn.com.hkt.em.basic.business.provide.panel.api.IProviderPanelShowListPerson;
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
 * hiển thị danh sách thông tin cá nhân
 * @author BinLe
 */
@ServiceProvider(service = IProviderPanelShowListPerson.class)
public class ProviderPanelShowListPerson implements IProviderPanelShowListPerson {

    private List<Person> persons;
    private PersonDAO personDAO = new PersonDAO();
    // Kiểu tìm kiếm - tên trường tìm kiếm
    private HashMap<String, String> hashtable2Search = new HashMap<String, String>();

    public ProviderPanelShowListPerson() {
        hashtable2Search.put("Họ", Person.FIELD_FIRST_NAME);
        hashtable2Search.put("Tên", Person.FIELD_LAST_NAME);
        hashtable2Search.put("Ngày sinh", Person.FIELD_BIRTHDAY);
        hashtable2Search.put("Giới tính", Person.FIELD_GENDER);
        hashtable2Search.put("Chứng minh thư", Person.FIELD_IDENTITY_CARD);
        hashtable2Search.put("Địa chỉ", Person.FIELD_ADDRESS);
        hashtable2Search.put("Điện thoại cố định", Person.FIELD_TELEPHONE);
        hashtable2Search.put("Điện thoại di động", Person.FIELD_MOBILE);
        hashtable2Search.put("Email", Person.FIELD_EMAIL);
        hashtable2Search.put("FAX", Person.FIELD_FAX);
        hashtable2Search.put("Website", Person.FIELD_WEBSITE);
        hashtable2Search.put("Tình trạng hôn nhân", Person.FIELD_ID_MARITALS_STATUS);
        hashtable2Search.put("Quốc gia", Person.FIELD_ID_COUNTRY);
        hashtable2Search.put("Thành phố", Person.FIELD_ID_CITY);
        hashtable2Search.put("Miêu tả", Person.FIELD_DESCRIPTION);
    }

    @Override
    public void loadAllInformation() {
        persons = personDAO.selectAll(IPersonDAO.SORT_ASC, Person.FIELD_FIRST_NAME);
    }

    @Override
    public List<Person> getListInformation() {
        return persons;
    }

    @Override
    public void filterListInformation(String typeSearch, String wordSearch) {
        String typeReadly = hashtable2Search.get(typeSearch);
        if (typeReadly == null || typeReadly.isEmpty() || wordSearch.isEmpty()) {
            loadAllInformation();
            return;
        }
        if (typeReadly.equals(Person.FIELD_ID_CITY)) {
            List<City> cities = new CityDAO().filter(City.FIELD_CITY_NAME, wordSearch);
            persons = new ArrayList<Person>();
            if (cities.isEmpty()) {
                return;
            }
            Set<Long> setIdCity = new HashSet<Long>();
            for (int i = 0; i < cities.size(); i++) {
                setIdCity.add(cities.get(i).getId());
            }
            List<Person> ps = personDAO.selectAll(IPersonDAO.SORT_ASC, Person.FIELD_FIRST_NAME);
            for (Person p : ps) {
                if (setIdCity.contains(p.getIdCity())) {
                    persons.add(p);
                }
            }
            return;
        }
        if (typeReadly.equals(Person.FIELD_ID_COUNTRY)) {
            List<Country> countries = new CountryDAO().filter(Country.FIELD_COUNTRY_NAME, wordSearch);
            persons = new ArrayList<Person>();
            if (countries.isEmpty()) {
                return;
            }
            Set<Long> setIdCountry = new HashSet<Long>();
            for (int i = 0; i < countries.size(); i++) {
                setIdCountry.add(countries.get(i).getId());
            }
            List<Person> ps = personDAO.selectAll(IPersonDAO.SORT_ASC, Person.FIELD_FIRST_NAME);
            for (Person p : ps) {
                if (setIdCountry.contains(p.getIdCountry())) {
                    persons.add(p);
                }
            }
            return;
        }
        if (typeReadly.equals(Person.FIELD_ID_MARITALS_STATUS)) {
            List<MaritalStatus> ms = new MaritalStatusDAO().filter(MaritalStatus.FIELD_MARITAL_STATUS_NAME, wordSearch);
            persons = new ArrayList<Person>();
            if (ms.isEmpty()) {
                return;
            }
            Set<Long> setIdMS = new HashSet<Long>();
            for (int i = 0; i < ms.size(); i++) {
                setIdMS.add(ms.get(i).getId());
            }
            List<Person> ps = personDAO.selectAll(IPersonDAO.SORT_ASC, Person.FIELD_FIRST_NAME);
            for (Person p : ps) {
                if (setIdMS.contains(p.getIdMaritalStatus())) {
                    persons.add(p);
                }
            }
            return;
        }
        persons = personDAO.filter(typeReadly, wordSearch,IPersonDAO.SORT_ASC,Person.FIELD_FIRST_NAME);                   
    }

    @Override
    public Object[] getListTypeSearch() {
        return hashtable2Search.keySet().toArray();
    }

    @Override
    public void loaddListInformation(List<Long> listId) {
        persons = new ArrayList<Person>();
        for (int i = 0; i < listId.size(); i++) {
            Person person = personDAO.getById(listId.get(i));
            persons.add(person);
        }
    }
}
