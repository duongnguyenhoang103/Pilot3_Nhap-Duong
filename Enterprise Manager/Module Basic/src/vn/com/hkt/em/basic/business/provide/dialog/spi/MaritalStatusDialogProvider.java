/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.basic.business.provide.dialog.spi;

import java.util.List;
import org.openide.util.lookup.ServiceProvider;
import vn.com.hkt.em.basic.business.provide.dialog.api.IMaritalStatusDialogProvider;
import vn.com.hkt.em.basic.data.access.api.IMAritalStatusDAO;
import vn.com.hkt.em.basic.data.entities.MaritalStatus;
import vn.com.hkt.em.basic.data.access.spi.MaritalStatusDAO;

/**
 *
 * @author BinLe
 */
@ServiceProvider(service = IMaritalStatusDialogProvider.class)
public class MaritalStatusDialogProvider implements IMaritalStatusDialogProvider {

    private MaritalStatus maritalStatusChoise;
    private MaritalStatusDAO msdao = new MaritalStatusDAO();
    private List<MaritalStatus> maritalStatuses;

    public MaritalStatusDialogProvider() {
        maritalStatusChoise = new MaritalStatus();
    }

    @Override
    public long addData(long idParent) {
        if (!checkData()) {
            return ID_FAIL;
        }
        if (msdao.insert(maritalStatusChoise)) {
            return maritalStatusChoise.getId();
        } else {
            return ID_FAIL;
        }
    }

    private boolean checkData() {
        if (maritalStatusChoise.getMaritalStatusName() == null
                || maritalStatusChoise.getMaritalStatusName().isEmpty()) {
            return false;
        }
        return true;
    }

    @Override
    public long editData() {
        if (!checkData()) {
            return ID_FAIL;
        }
        if (msdao.update(maritalStatusChoise)) {
            return maritalStatusChoise.getId();
        } else {
            return ID_FAIL;
        }
    }

    @Override
    public long removeData() {
        long id = maritalStatusChoise.getId();
        if (msdao.deleteById(id)) {
            return id;
        }
        return ID_FAIL;
    }

    @Override
    public void setDataView(MaritalStatus obj) {
        this.maritalStatusChoise = obj;
    }

    @Override
    public void loadAllMaritalStatus() {
        maritalStatuses = msdao.selectAll(IMAritalStatusDAO.SORT_ASC, MaritalStatus.FIELD_MARITAL_STATUS_NAME);
    }

    @Override
    public List<MaritalStatus> getListMaritalStatus() {
        return maritalStatuses;
    }

    @Override
    public MaritalStatus getDataViewCurrent() {
        return maritalStatusChoise;
    }

    @Override
    public void refreshData() {
        maritalStatusChoise = msdao.getById(maritalStatusChoise.getId());
        if (maritalStatusChoise == null) {
            maritalStatusChoise = new MaritalStatus();
        }
    }
}
