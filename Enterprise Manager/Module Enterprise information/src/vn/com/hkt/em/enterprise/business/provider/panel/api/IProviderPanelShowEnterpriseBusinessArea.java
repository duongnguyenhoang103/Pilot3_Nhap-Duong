/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.enterprise.business.provider.panel.api;

import java.util.List;

import vn.com.hkt.em.basic.business.provide.api.IProviderShowInformation;
import vn.com.hkt.em.basic.data.entities.Enterprise;
import vn.com.hkt.em.enterprise.data.entities.EnterpriseBusinessArea;

/**
 * Mặt  nạ đối tượng cung cấp dữ liệu, nhận dữ liệu cho giao diên lĩnh vực kinh doanh
 * @author BinLe
 */
public interface IProviderPanelShowEnterpriseBusinessArea extends IProviderShowInformation<Enterprise> {
    /**
     * Truyền vào 1 danh sách các lĩnh vực kinh doanh của doanh nghiệp
     * @param businessAreas 
     */
    public void setEnterpriseBusinessAreas(List<EnterpriseBusinessArea> enterpriseBusinessAreas);
    /**
     * Lấy ra 1 danh sách các lĩnh vực kinh doanh của doanh nghiệp
     */
    public List<EnterpriseBusinessArea> getEnterpriseBusinessAreas();
}
