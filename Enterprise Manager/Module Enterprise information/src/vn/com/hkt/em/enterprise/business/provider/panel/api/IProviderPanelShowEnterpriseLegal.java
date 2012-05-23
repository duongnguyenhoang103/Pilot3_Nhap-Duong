/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.enterprise.business.provider.panel.api;

import java.util.List;
import vn.com.hkt.em.basic.business.provide.api.IProviderShowInformation;


import vn.com.hkt.em.basic.data.entities.Enterprise;
import vn.com.hkt.em.basic.data.entities.Person;
import vn.com.hkt.em.enterprise.data.entities.EnterpriseLegal;
import vn.com.hkt.em.enterprise.data.entities.EnterpriseType;

/**
 * Mặt nạ đối tượng cung cấp dữ liệu, nhận dữ liệu, nhận lệnh với giao diện 
 * hiển thị thông tin pháp lý của doanh nghiệp
 * @author BinLe
 */
public interface IProviderPanelShowEnterpriseLegal extends IProviderShowInformation<EnterpriseLegal> {

    /**
     * Thực hiện việc hiển thị thông tin, thêm, sửa xóa đối với doanh nghiệp xác định
     * @param enterprise :Enterprise doanh nghiệp cần hiển thị, thêm thông tin pháp lý
     */
    public void setEnterprise(Enterprise enterprise);

    /**
     * Lấy tên doanh nghiệp đang được hiển thị,thêm thông tin pháp lý
     * @return 
     */
    public String getEnterpriseName();

    /**
     * Cung cấp danh sách loại hình doanh nghiệp để đưa vào comboBox loại hình doanh nghiệp
     * @return List<EnterpriseTYpe> danh sách loại hình doanh nghiệp
     */
    public List<EnterpriseType> getEnterpriseTypes();
    /**
     * Cung cấp danh sách cá nhân để đưa vào combobox lựa chọn dại diện pháp lý
     * @return List<Person> danh sách cá nhân
     */
    public List<Person> getPersons();

}
