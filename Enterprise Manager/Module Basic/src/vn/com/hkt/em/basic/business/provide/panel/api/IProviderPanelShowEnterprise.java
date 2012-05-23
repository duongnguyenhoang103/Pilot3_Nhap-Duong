/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.basic.business.provide.panel.api;

import java.util.List;
import vn.com.hkt.em.basic.business.provide.api.IProviderShowInformation;
import vn.com.hkt.em.basic.data.entities.City;
import vn.com.hkt.em.basic.data.entities.Country;
import vn.com.hkt.em.basic.data.entities.Enterprise;


/**
 * Mặt nạ đối tượng cung cấp dữ liệu, nhân dữ liệu, nhận lệnh từ giao diện
 * hiển thị thông tin doanh nghiệp
 * @author BinLe
 */
public interface IProviderPanelShowEnterprise extends IProviderShowInformation<Enterprise> {

    /**
     * Lấy danh sách quốc gia
     * @return 
     */
    public List<Country> getCountries();

    /**
     * Lấy danh sách thành của 1 quốc gia
     * @param Country:Country quốc gia truyền vào
     * @return : List<City> danh sách thành phố
     */
    public List<City> getCities(Country country);
    /** 
     * Lấy danh sách doanh nghiệp để truyền vào combobox để chọn doanh nghiệp cha
     * Chú ý loại chính doanh nghiệp hiện tại và các doanh nghiệp con của nó
     * @return List<Enterprise> danh sách các doanh nghiệp có thể 
     * làm cha của doanh nghiệp hiện tại
     */
    public List<Enterprise> getEnterprisesAbilityIsParent();
}
