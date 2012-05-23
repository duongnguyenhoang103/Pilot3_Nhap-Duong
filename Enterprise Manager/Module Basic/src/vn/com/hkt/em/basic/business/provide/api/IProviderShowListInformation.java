/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.basic.business.provide.api;

import java.util.List;

/**
 *  Mặt nạ đối tượng cung cấp dữ liệu, nhận dữ liệu, nhận lênh đối với giao diện
 * hiển thị danh sách thông tin của đối tượng E
 * @author BinLe
 */
public interface IProviderShowListInformation<E> {

    /**
     * load danh sách tất cả thông tin
     */
    public void loadAllInformation();

    /**
     * Lấy danh sách thông tin load được
     * @return List<E> danh sách thông tin
     */
    public List<E> getListInformation();
    /**
     * Tìm kiếm gần đúng danh sách thông tin theo 1 kiểu tìm kiếm và 1 từ khóa tìm kiếm
     * @param typeSearch: kiểu tìm kiếm
     * @param wordSearch: từ tìm kiếm
     * Chú ý: sau câu lệnh này danh sách thông tin là danh sách đã tìm kiếm
     */     
    public void filterListInformation(String typeSearch, String wordSearch);
    /**
     * Lấy danh sách các kiểu tìm kiếm có thể để cho người dùng chọn
     * @return Object[] danh sách kiểm tìm kiếm
     */
    public Object[] getListTypeSearch();
    /**
     * Load danh sách thông tin theo danh sách id lấy từ danh sách thông tin của giao diện cha
     * @param listId List<Long>: danh sách id của các đối tượng hiển thị tại giao diện cha
     */
    public void loaddListInformation(List<Long> listId);
}
