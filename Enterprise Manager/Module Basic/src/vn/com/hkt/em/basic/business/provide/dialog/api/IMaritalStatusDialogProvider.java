/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.basic.business.provide.dialog.api;

import java.util.List;
import vn.com.hkt.em.basic.business.provide.api.IProviderShowInformation;
import vn.com.hkt.em.basic.data.entities.MaritalStatus;

/**
 * Mặt nạ đối tượng giao diện hiển thị,xem,sửa thông tin tình trạng hôn nhân
 * Cung cấp dữ liệu,nhận dữ liệu, nhận lệnh.
 * @author BinLe
 */
public interface IMaritalStatusDialogProvider extends IProviderShowInformation<MaritalStatus> {

    /**
     * Load danh sách tất cả các tình trạng hôn nhân
     */
    public void loadAllMaritalStatus();

    /**
     * Trả về danh sách tình trạng hôn nhân được load ở trên
     * @return List<Country> :danh sách tình trạng hôn nhân
     */
    public List<MaritalStatus> getListMaritalStatus();
}
