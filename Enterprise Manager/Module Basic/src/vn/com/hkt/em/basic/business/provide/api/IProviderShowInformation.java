/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.basic.business.provide.api;

/**
 * Mặt nạ giao diện chung thể hiên thông tin đối tượng hiển thi
 * (E là đối tượng hiện thị- E có thể chính là entity)
 * @author BinLe
 */
public interface IProviderShowInformation<E> {

    public final long ID_FAIL = -1;

    /**
     * Thực hiện chức năng thêm mới dữ liệu
     * idParent: id thông tin cha 
     * @return long: có thực hiện thành công hay không
     */
    public long addData(long idParent);

    /**
     * Load lại dữ liệu được chọn
     */
    public void refreshData();

    /**
     * Thực hiện chức năng sửa mới dữ liệu
     * @return boolean: có thực hiện thành công hay không
     */
    public long editData();

    /**
     * Thực hiện chức năng xóa mới dữ liệu
     * @return boolean: có thực hiện thành công hay không
     */
    public long removeData();

    /**
     *  Thực hiện chức năng hiển thị dữ liệu của đối tượng được truyền vào
     * @param obj :E đối tượng truyền vào để hiển thị
     */
    public void setDataView(E obj);

    /**
     *  trả về đối tượng đang được hiển thị
     * @param obj :E đối tượng tương đối lấy ra
     */
    public E getDataViewCurrent();
}
