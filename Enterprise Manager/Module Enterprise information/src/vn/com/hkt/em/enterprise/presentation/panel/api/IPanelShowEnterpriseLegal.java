/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.enterprise.presentation.panel.api;

import vn.com.hkt.em.basic.presentation.panel.show.api.extention.IPanelShowEnterpriseExtention;
import vn.com.hkt.em.enterprise.data.entities.EnterpriseLegal;

/**
 *
 * @author duong
 */
public interface IPanelShowEnterpriseLegal extends IPanelShowEnterpriseExtention {
      /**
     * Lấy level của giao diện đối với thông tin pháp lys
     * @return long:Level của giao diện
     */
    public long getLevelPanelShowEnterpriseLegal();

    /**
     * Truyền thông tin pháp lý doanh nghiệp muốn hiển thị
     * @param enterpriseLegal :EnterpriseLegal  thông ti pháp lý
     */
    public void setEnterpriseLegal(EnterpriseLegal enterpriseLegal);

    public EnterpriseLegal getEnterpriseLegal();
    
}
