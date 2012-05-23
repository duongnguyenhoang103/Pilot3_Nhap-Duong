/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.enterprise.business.provider.panel.spi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.openide.util.Lookup;
import vn.com.hkt.em.basic.data.access.api.IEnterpriseDAO;
import vn.com.hkt.em.basic.data.access.api.IPersonDAO;
import vn.com.hkt.em.basic.data.entities.Enterprise;
import vn.com.hkt.em.basic.data.entities.Person;
import vn.com.hkt.em.enterprise.business.provider.panel.api.IProviderPanelShowListEnterpriseLegal;
import vn.com.hkt.em.enterprise.data.access.api.IEnterpriseLegalDAO;
import vn.com.hkt.em.enterprise.data.access.spi.EnterpriseLegalDAO;
import vn.com.hkt.em.enterprise.data.access.spi.EnterpriseTypeDAO;
import vn.com.hkt.em.enterprise.data.entities.EnterpriseLegal;
import vn.com.hkt.em.enterprise.data.entities.EnterpriseType;

/**
 *
 * @author BinLe
 */
public class ProviderPanelShowListenterpriseLegal implements IProviderPanelShowListEnterpriseLegal {

    private HashMap<String, String> hashtable2Search = new HashMap<String, String>();
    private List<EnterpriseLegal> enterpriseLegals;
    private IEnterpriseLegalDAO enterpriseLegalDAO = new EnterpriseLegalDAO();

    public ProviderPanelShowListenterpriseLegal() {
        hashtable2Search.put("Lần đăng ký KD", EnterpriseLegal.FIELD_BUSINESS_REGISTRATION_NUMBER);
        hashtable2Search.put("Ngày thành lập", EnterpriseLegal.FIELD_DATE_ESTABLISHMENT);
        hashtable2Search.put("Ngày đăng ký ", EnterpriseLegal.FIELD_DATE_REGISTRATION);
        hashtable2Search.put("Tên tiếng Anh", EnterpriseLegal.FIELD_ENTERPRISE_NAME_ENGLISH);
        hashtable2Search.put("Tên tiếng Việt", EnterpriseLegal.FIELD_ENTERPRISE_NAME_VIETNAM);
        hashtable2Search.put("Tên thường gọi", EnterpriseLegal.FIELD_ID_ENTERPRISE);
        hashtable2Search.put("Người chịu trách nhiệm", EnterpriseLegal.FIELD_ID_PERSON_RESPONSIABLE_LEGAL);
        hashtable2Search.put("Mã số thuế", EnterpriseLegal.FIELD_TAX_CODE_NUMBER);
        hashtable2Search.put("Loại hình doanh nghiệp", EnterpriseLegal.FIELD_ID_ENTERPRISE_TYPE);
    }

    @Override
    public void loadAllInformation() {
        enterpriseLegals = enterpriseLegalDAO.selectAll(IEnterpriseLegalDAO.SORT_ASC, EnterpriseLegal.FIELD_ENTERPRISE_NAME_ENGLISH);
    }

    @Override
    public List<EnterpriseLegal> getListInformation() {
        return enterpriseLegals;
    }

    @Override
    public void filterListInformation(String typeSearch, String wordSearch) {
        String typeReadly = hashtable2Search.get(typeSearch);
        if (typeReadly == null || typeReadly.isEmpty() || wordSearch.isEmpty()) {
            loadAllInformation();
            return;
        }
        enterpriseLegals = new ArrayList<EnterpriseLegal>();
        if (typeReadly.equals(EnterpriseLegal.FIELD_ID_ENTERPRISE)) {
            IEnterpriseDAO enterpriseDAO = Lookup.getDefault().lookup(IEnterpriseDAO.class);
            List<Enterprise> enterprises = enterpriseDAO.filter(Enterprise.FIELD_ENTERPRISE_NAME, wordSearch);
            if (enterprises.isEmpty()) {
                return;
            }
            Set<Long> setIdEnterprise = new HashSet<Long>();
            for (int i = 0; i < enterprises.size(); i++) {
                setIdEnterprise.add(enterprises.get(i).getId());
            }
            List<EnterpriseLegal> els = enterpriseLegalDAO.selectAll(IEnterpriseLegalDAO.SORT_ASC, EnterpriseLegal.FIELD_ENTERPRISE_NAME_ENGLISH);
            for (EnterpriseLegal p : els) {
                if (setIdEnterprise.contains(p.getIdEnterprise())) {
                    enterpriseLegals.add(p);
                }
            }
            return;
        }
        if (typeReadly.equals(EnterpriseLegal.FIELD_ID_PERSON_RESPONSIABLE_LEGAL)) {
            IPersonDAO personDAO = Lookup.getDefault().lookup(IPersonDAO.class);
            List<Person> persons = personDAO.filter(Person.FIELD_FIRST_NAME, wordSearch);
            if (persons.isEmpty()) {
                return;
            }
            Set<Long> setIdPerson = new HashSet<Long>();
            for (int i = 0; i < persons.size(); i++) {
                setIdPerson.add(persons.get(i).getId());
            }
            List<EnterpriseLegal> els = enterpriseLegalDAO.selectAll(IEnterpriseLegalDAO.SORT_ASC, EnterpriseLegal.FIELD_ENTERPRISE_NAME_ENGLISH);
            for (EnterpriseLegal p : els) {
                if (setIdPerson.contains(p.getIdEnterprise())) {
                    enterpriseLegals.add(p);
                }
            }
            return;
        }
        if (typeReadly.equals(EnterpriseLegal.FIELD_ID_PERSON_RESPONSIABLE_LEGAL)) {
            List<EnterpriseType> enterpriseTypes = new EnterpriseTypeDAO().filter(EnterpriseType.FIELD_ENTERPRISE_TYPE_NAME, wordSearch);
            if (enterpriseTypes.isEmpty()) {
                return;
            }
            Set<Long> setIdEnterpriseTypes = new HashSet<Long>();
            for (int i = 0; i < enterpriseTypes.size(); i++) {
                setIdEnterpriseTypes.add(enterpriseTypes.get(i).getId());
            }
            List<EnterpriseLegal> els = enterpriseLegalDAO.selectAll(IEnterpriseLegalDAO.SORT_ASC, EnterpriseLegal.FIELD_ENTERPRISE_NAME_ENGLISH);
            for (EnterpriseLegal p : els) {
                if (setIdEnterpriseTypes.contains(p.getIdEnterprise())) {
                    enterpriseLegals.add(p);
                }
            }
            return;
        }
        enterpriseLegals = enterpriseLegalDAO.filter(typeReadly, wordSearch, IEnterpriseLegalDAO.SORT_ASC, EnterpriseLegal.FIELD_ENTERPRISE_NAME_ENGLISH);
    }

    @Override
    public Object[] getListTypeSearch() {
        return hashtable2Search.keySet().toArray();
    }

    @Override
    public void loaddListInformation(List<Long> listId) {
        enterpriseLegals = enterpriseLegalDAO.selectAll(IEnterpriseLegalDAO.SORT_ASC, EnterpriseLegal.FIELD_ENTERPRISE_NAME_ENGLISH);
        for (int i = 0; i < enterpriseLegals.size();) {
            if (!listId.contains(enterpriseLegals.get(i).getIdEnterprise())) {
                enterpriseLegals.remove(i);
            } else {
                i++;
            }
        }
    }
}
