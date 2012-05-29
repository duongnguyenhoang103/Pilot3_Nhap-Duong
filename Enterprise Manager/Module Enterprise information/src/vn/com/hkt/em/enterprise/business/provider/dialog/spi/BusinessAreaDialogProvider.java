/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.enterprise.business.provider.dialog.spi;

import java.util.List;
import vn.com.hkt.em.enterprise.business.provider.dialog.api.IBusinessAreaDialogProvider;
import vn.com.hkt.em.enterprise.data.access.api.IBusinessAreaDAO;
import vn.com.hkt.em.enterprise.data.access.spi.BusinessAreaDAO;
import vn.com.hkt.em.enterprise.data.entities.BusinessArea;

/**
 *
 * @author BinLe
 */
public class BusinessAreaDialogProvider implements IBusinessAreaDialogProvider {

    private IBusinessAreaDAO businessAreaDAO = new BusinessAreaDAO();
    private List<BusinessArea> listBusinessAreas;
    private BusinessArea businessArea;

    public BusinessAreaDialogProvider() {
        businessArea = new BusinessArea();
    }

    @Override
    public void loadAllBusinessArea() {
        this.listBusinessAreas = businessAreaDAO.selectAll(IBusinessAreaDAO.SORT_ASC, BusinessArea.FIELD_BUSINESS_AREA_NAME);
    }

    @Override
    public List<BusinessArea> getListBusinesArea() {
        return listBusinessAreas;
    }

    @Override
    public long addData(long idParent) {
        if (!checkData()) {
            return ID_FAIL;
        }
        if (businessAreaDAO.insert(businessArea)) {
            return businessArea.getId();
        } else {
            return ID_FAIL;
        }
    }

    @Override
    public void refreshData() {
        businessArea = businessAreaDAO.getById(businessArea.getId());
        if (businessArea == null) {
            businessArea = new BusinessArea();
        }
    }

    @Override
    public long editData() {
        if (!checkData()) {
            return ID_FAIL;
        }
        if (businessAreaDAO.update(businessArea)) {
            return businessArea.getId();
        } else {
            return ID_FAIL;
        }
    }

    @Override
    public long removeData() {
        long id = businessArea.getId();
        if (businessAreaDAO.deleteById(id)) {
            return id;
        }
        return ID_FAIL;
    }

    @Override
    public void setDataView(BusinessArea obj) {
        this.businessArea = obj;
    }

    @Override
    public BusinessArea getDataViewCurrent() {
        return businessArea;
    }

    private boolean checkData() {
        if (businessArea.getBusinessAreaCode().isEmpty()
                || businessArea.getBusinessAreaName().isEmpty()) {
            return false;
        }
        return true;
    }
}
