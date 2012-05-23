/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.enterprise.presentation.panel.api;

import java.util.List;
import vn.com.hkt.em.basic.presentation.panel.show.api.extention.IPanelShowEnterpriseExtention;
import vn.com.hkt.em.enterprise.data.entities.EnterpriseAddress;


/**
 * Mặt nạ giao diện hiển thị danh sách địa chỉ doanh nghiệp
 * @author BinLe
 */
public interface IPanelShowEnterpriseAddress extends IPanelShowEnterpriseExtention {

    /**
     * Lấy level đối với giao diện hiển thị địa chỉ doanh nghiệp
     * @return long level giao diện
     */
    public long getLevelPanelShowEnterpriseAddress();

    /**
     * Truyền vào danh sách địa chỉ của doanh nghiệp
     */
    public void setEnterpriseAddresses(List<EnterpriseAddress> enterpriseAddresses);

    /**
     * Lấy danh sách địa chỉ của doanh nghiệp
     */
    public List<EnterpriseAddress> getEnterpriseAddresses();
}
