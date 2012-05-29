/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.basic.business.provide.dialog.api;

import java.util.List;
import vn.com.hkt.em.basic.business.provide.api.IProviderShowInformation;
import vn.com.hkt.em.basic.data.entities.City;
import vn.com.hkt.em.basic.data.entities.Country;

/**
 * Mặt nạ đối tượng giao diện hiển thị,xem,sửa thông tin thành phố
 * Cung cấp dữ liệu,nhận dữ liệu, nhận lệnh.
 * @author BinLe
 */
public interface ICityDialogProvider extends IProviderShowInformation<City> {

    /**
     * Load danh sách thành phố tương ứng với mã id country trong thành phố hiện tại
     * được truyền vào từ giao diện (có thể chưa tồn tại nhưng được truyền mã id quốc gia)
     * được gọi sau khi thêm sửa,xóa thông tin thành phố
     */
    public void loadListCity();

    /**
     * Lấy danh sách thành phố đã thực hiện lấy từ hàm loadListCity()
     * @return  List<City> danh sách thành phô
     */
    public List<City> getListCity();

    /**
     * Thực hiện trả về danh sách thành phố của 1 quốc gia
     * Được gọi khi lần đầu mở dialog và khi tắt dialog để hiển thị và trả về
     * danh sách thành phố của quốc gia được chọn ban đâu
     * @param country
     * @return 
     */
    public List<City> getListCity(Country country);

    /**
     * Trả về danh sách quốc gia để đưa vào combobox
     * @return :List<Country> danh sách thành phố
     */
    public List<Country> getListCountry();
    
       /**
     * Load danh sách tất cả các cities
     */
    public void loadAllCities();

}
