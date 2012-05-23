/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.enterprise.presentation.panel.api;

import java.util.List;
import vn.com.hkt.em.basic.presentation.panel.show.api.extention.IPanelShowEnterpriseExtention;
import vn.com.hkt.em.enterprise.data.entities.EnterpriseBusinessArea;

/**
 *
 * @author duong
 */
public interface IPanelShowEnterpriseBusinessArea extends IPanelShowEnterpriseExtention {

    /**
     * Lấy level đối với giao diện hiển thị lĩnh vự kinh doanh
     * @return long level giao diện
     */
    public long getLevelPanelShowEnterpriseBusinessArea();

    /**
     * Truyền vào danh sách lĩnh vự kinh doanh của doanh nghiệp
     */
    public void setEnterpriseBusinessAreas(List<EnterpriseBusinessArea> enterpriseBusinessAreas);

    /**
     * Lấy danh sách lĩnh vực kinh doanh của doanh nghiệp
     */
    public List<EnterpriseBusinessArea> getEnterpriseBusinessAreas();
}
