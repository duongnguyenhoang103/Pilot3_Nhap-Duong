/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.enterprise.business.provider.dialog.api;

import java.util.List;
import vn.com.hkt.em.basic.business.provide.api.IProviderShowInformation;
import vn.com.hkt.em.enterprise.data.entities.BusinessArea;

/**
 *
 * @author BinLe
 */
public interface IBusinessAreaDialogProvider extends IProviderShowInformation<BusinessArea> {

    /**
     * Load danh sách tất cả các lĩnh vực kinh doanh
     */
    public void loadAllBusinessArea();

    /**
     * Trả về danh sách lĩnh vực kinh doanh
     * @return List<Country> :danh sách lĩnh vực kinh doanh
     */
    public List<BusinessArea> getListBusinesArea();
}
