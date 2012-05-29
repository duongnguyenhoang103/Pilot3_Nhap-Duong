/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.enterprise.business.provider.dialog.api;

import java.util.List;
import vn.com.hkt.em.basic.business.provide.api.IProviderShowInformation;
import vn.com.hkt.em.enterprise.data.entities.EnterpriseType;

/**
 * Mặt nạ đối tượng giao diện hiển thị,xem,sửa thông tin loại hình doanh nghiệp
 * Cung cấp dữ liệu,nhận dữ liệu, nhận lệnh.
 * @author BinLe
 */
public interface IEnterpriseTypeDialogProvider extends IProviderShowInformation<EnterpriseType> {

    /**
     * Load danh sách tất cả các loại hình doanh nghiệp
     */
    public void loadAllEnterpriseType();

    /**
     * Trả về danh sách loại hình doanh nghiệp được load ở trên
     * @return List<Country> :danh sách loại hình doanh nghiệp
     */
    public List<EnterpriseType> getListEnterpriseType();
}
