/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.basic.business.provide.dialog.api;

import java.util.List;
import vn.com.hkt.em.basic.business.provide.api.IProviderShowInformation;
import vn.com.hkt.em.basic.data.entities.Country;

/**
 * Mặt nạ đối tượng giao diện hiển thị,xem,sửa thông tin quốc giá
 * Cung cấp dữ liệu,nhận dữ liệu, nhận lệnh.
 * @author BinLe
 */
public interface ICountryDialogProvider extends IProviderShowInformation<Country> {

    /**
     * Load danh sách tất cả các quốc gia
     */
    public void loadAllCountries();

    /**
     * Trả về danh sách quốc gia được load ở trên
     * @return List<Country> :danh sách quốc gia
     */
    public List<Country> getListCountries();


}
