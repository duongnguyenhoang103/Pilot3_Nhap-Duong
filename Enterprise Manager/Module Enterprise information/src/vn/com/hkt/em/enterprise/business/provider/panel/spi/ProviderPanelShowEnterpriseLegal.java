/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.enterprise.business.provider.panel.spi;

import java.util.List;
import javax.swing.JOptionPane;
import org.openide.util.Lookup;
import vn.com.hkt.em.basic.data.access.api.IEnterpriseDAO;
import vn.com.hkt.em.basic.data.access.api.IPersonDAO;
import vn.com.hkt.em.basic.data.entities.Enterprise;
import vn.com.hkt.em.basic.data.entities.Person;
import vn.com.hkt.em.enterprise.business.provider.panel.api.IProviderPanelShowEnterpriseLegal;
import vn.com.hkt.em.enterprise.data.access.api.IEnterpriseLegalDAO;
import vn.com.hkt.em.enterprise.data.access.api.IEnterpriseTypeDAO;
import vn.com.hkt.em.enterprise.data.access.spi.EnterpriseLegalDAO;
import vn.com.hkt.em.enterprise.data.access.spi.EnterpriseTypeDAO;
import vn.com.hkt.em.enterprise.data.entities.EnterpriseLegal;
import vn.com.hkt.em.enterprise.data.entities.EnterpriseType;

/**
 * Đối tượng cung cấp dữ liệu, nhận dữ liệu, nhận lệnh với giao diện 
 * hiển thị thông tin pháp lý của doanh nghiệp
 * @author BinLe
 */
public class ProviderPanelShowEnterpriseLegal implements IProviderPanelShowEnterpriseLegal {

    private IEnterpriseLegalDAO enterpriseLegalDAO = new EnterpriseLegalDAO();
    private EnterpriseLegal enterpriseLegal;
    private Enterprise enterprise;
    private IEnterpriseDAO edao = Lookup.getDefault().lookup(IEnterpriseDAO.class);

    public ProviderPanelShowEnterpriseLegal() {
        enterpriseLegal = new EnterpriseLegal();
    }

    @Override
    public long addData(long idParent) {
        if (!checkData()) {
            return ID_FAIL;
        }
        enterpriseLegal.setIdEnterprise(idParent);
        if (enterpriseLegalDAO.insert(enterpriseLegal)) {
            return enterpriseLegal.getId();
        }
        return ID_FAIL;
    }

    @Override
    public void refreshData() {
        enterpriseLegal = enterpriseLegalDAO.getById(enterpriseLegal.getId());
        if (enterpriseLegal == null) {
            enterpriseLegal = new EnterpriseLegal();            
        } else {
            enterprise = edao.getById(enterpriseLegal.getIdEnterprise());
            if (enterprise == null) {
                enterprise = new Enterprise();
            }
        }
    }

    @Override
    public long editData() {
        if (!checkData()) {
            return ID_FAIL;
        }
        if (enterpriseLegal.getId() > 0) {
            if (enterpriseLegalDAO.update(enterpriseLegal)) {
                return enterpriseLegal.getId();
            }
        } else {
            if (enterpriseLegalDAO.insert(enterpriseLegal)) {
                return enterpriseLegal.getId();
            }
        }
        return ID_FAIL;
    }

    @Override
    public long removeData() {
        long id = enterpriseLegal.getId();
        if (enterpriseLegalDAO.deleteById(id)) {
            return id;
        }
        return ID_FAIL;
    }

    @Override
    public void setDataView(EnterpriseLegal obj) {        
        enterprise = edao.getById(obj.getIdEnterprise());
        if (enterprise == null) {
            enterprise = new Enterprise();
        }
        this.enterpriseLegal = obj;
    }

    @Override
    public EnterpriseLegal getDataViewCurrent() {
        return enterpriseLegal;
    }

    private boolean checkData() {
        return true;// Mặc định là cho phép để trống hết các thông tin
    }

    @Override
    public void setEnterprise(Enterprise enterprise) {
        this.enterprise = enterprise;
        List<EnterpriseLegal> ls = enterpriseLegalDAO.select(EnterpriseLegal.FIELD_ID_ENTERPRISE, String.valueOf(enterprise.getId()));
        if (ls.isEmpty()) {
            enterpriseLegal = new EnterpriseLegal();
            enterpriseLegal.setIdEnterprise(enterprise.getId());
        } else {
            enterpriseLegal = ls.get(0);
        }
    }

    @Override
    public String getEnterpriseName() {
      
        if (enterprise == null) {
            enterprise = new Enterprise();
        }
        return enterprise.getEnterpriseName();
    }

    @Override
    public List<EnterpriseType> getEnterpriseTypes() {
        return new EnterpriseTypeDAO().selectAll(IEnterpriseTypeDAO.SORT_ASC, EnterpriseType.FIELD_ENTERPRISE_TYPE_NAME);
    }

    @Override
    public List<Person> getPersons() {
        IPersonDAO personDAO = Lookup.getDefault().lookup(IPersonDAO.class);
        return personDAO.selectAll(IPersonDAO.SORT_ASC, Person.FIELD_FIRST_NAME);
    }
}
