/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.enterprise.business.provider.dialog.spi;

import java.util.List;
import org.openide.util.lookup.ServiceProvider;
import vn.com.hkt.em.enterprise.business.provider.dialog.api.IEnterpriseTypeDialogProvider;
import vn.com.hkt.em.enterprise.data.access.api.IEnterpriseTypeDAO;
import vn.com.hkt.em.enterprise.data.entities.EnterpriseType;
import vn.com.hkt.em.enterprise.data.access.spi.EnterpriseTypeDAO;

/**
 *
 * @author BinLe
 */
@ServiceProvider(service = IEnterpriseTypeDialogProvider.class)
public class EnterpriseTypeDialogProvider implements IEnterpriseTypeDialogProvider {

    private EnterpriseType enterpriseType;
    private EnterpriseTypeDAO etdao = new EnterpriseTypeDAO();
    private List<EnterpriseType> listEnterpriseType;

    public EnterpriseTypeDialogProvider() {
        enterpriseType = new EnterpriseType();
    }

    @Override
    public long addData(long idParent) {
        if (!checkData()) {
            return ID_FAIL;
        }
        if (etdao.insert(enterpriseType)) {
            return enterpriseType.getId();
        } else {
            return ID_FAIL;
        }
    }

    private boolean checkData() {
        if (enterpriseType.getEnterpriseTypeName().isEmpty()) {
            return false;
        }
        return true;
    }

    @Override
    public long editData() {
        if (!checkData()) {
            return ID_FAIL;
        }
        if (etdao.update(enterpriseType)) {
            return enterpriseType.getId();
        } else {
            return ID_FAIL;
        }
    }

    @Override
    public long removeData() {
        long id = enterpriseType.getId();
        if (etdao.deleteById(id)) {
            return id;
        }
        return ID_FAIL;
    }

    @Override
    public void setDataView(EnterpriseType obj) {
        this.enterpriseType = obj;
    }

    @Override
    public EnterpriseType getDataViewCurrent() {
        return enterpriseType;
    }

    @Override
    public void loadAllEnterpriseType() {
        listEnterpriseType = etdao.selectAll(IEnterpriseTypeDAO.SORT_ASC, EnterpriseType.FIELD_ENTERPRISE_TYPE_NAME);
    }

    @Override
    public List<EnterpriseType> getListEnterpriseType() {
        return listEnterpriseType;
    }

    @Override
    public void refreshData() {
        enterpriseType = etdao.getById(enterpriseType.getId());
        if (enterpriseType == null) {
            enterpriseType = new EnterpriseType();
        }
    }    
}
