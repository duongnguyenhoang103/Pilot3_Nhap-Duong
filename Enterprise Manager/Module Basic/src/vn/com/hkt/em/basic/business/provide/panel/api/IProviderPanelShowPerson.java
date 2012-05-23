/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.basic.business.provide.panel.api;

import java.util.List;
import vn.com.hkt.em.basic.business.provide.api.IProviderShowInformation;
import vn.com.hkt.em.basic.data.entities.City;
import vn.com.hkt.em.basic.data.entities.Country;
import vn.com.hkt.em.basic.data.entities.MaritalStatus;
import vn.com.hkt.em.basic.data.entities.Person;


/**
 *Mặt nạ đối tượng cung cấp dữ liệu, nhân dữ liệu, nhận lệnh từ giao diện
 * hiển thị thông tin cá nhân
 * @author BinLe
 */
public interface IProviderPanelShowPerson extends IProviderShowInformation<Person> {

    /**
     * Lấy danh sách quốc gia
     * @return 
     */
    public List<Country> getCountries();

    /**
     * Lấy danh sách thành phố của 1 quốc gia
     * @param Country:Country quốc gia truyền vào
     * @return : List<City> danh sách thành phố
     */
    public List<City> getCities(Country country);

    /**
     * Lấy danh sách tình trạng hôn nhân
     * @return  List<MaritalStatus> danh sách tình trạng hôn nhân
     */
    public List<MaritalStatus> getMaritalStatuses();

    /**
     * Kiểm tra cá nhân có giới tính là phụ nữ
     * @return boolean đúng hoặc sai
     */
    public boolean genderIsWomen();

    /**
     * Kiểm tra cá nhân có giới tính là đàn ông
     * @return boolean đúng hoặc sai
     */
    public boolean genderIsMen();

    /**
     * Khẳng định đây là đàn ông     
     */
    public void setGenderMen();

    /**
     * Khẳng định đây là phụ nư   
     */
    public void setGenderWomen();
}
