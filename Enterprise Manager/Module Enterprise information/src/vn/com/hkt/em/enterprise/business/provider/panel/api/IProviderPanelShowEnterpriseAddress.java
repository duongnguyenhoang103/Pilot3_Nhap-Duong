/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.enterprise.business.provider.panel.api;

import java.util.List;
import vn.com.hkt.em.basic.business.provide.api.IProviderShowInformation;

import vn.com.hkt.em.basic.data.entities.Enterprise;
import vn.com.hkt.em.enterprise.data.entities.EnterpriseAddress;

/**
 * Đối tượng nhận dữ liệu, cung cấp dữ liệu, nhận lệnh tương tác với giao diện 
 * địa chỉ doanh nghiệp
 * @author BinLe
 */
public interface IProviderPanelShowEnterpriseAddress extends IProviderShowInformation<Enterprise> {

    /**
     *  Thực hiện chức năng hiển thị địa chỉ của doanh nghiệp
     * @param obj :E đối tượng truyền vào để hiển thị
     */
    @Override
    public void setDataView(Enterprise obj);

    /**
     * Trả về danh sách địa chỉ của doanh nghiệp
     * @return 
     */
    public List<EnterpriseAddress> getEnterpriseAddresses();

    /**
     * Truyền vào danh sách địa chỉ của doanh nghiệp
     */
    public void setEnterpriseAddresses(List<EnterpriseAddress> enterpriseAddresses);
}
