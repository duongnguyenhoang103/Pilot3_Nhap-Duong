/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.basic.presentation.dialog.api;

import vn.com.hkt.em.basic.data.entities.Country;



/**
 * Mặt nạ giao diện thêm, sửa xóa thông tin thành phố
 * @author BinLe
 */
public interface ICityDialog extends IInformationDialog {

    /**
     * Truyền vào quốc gia đầu tiên được chọn để khi tặt giao diện
     * trả về danh sách thành phố của quốc gia đó
     * @param countryFirst :Country : quốc gia
     */
    public void setCountryFirst(Country countryFirst);
}
