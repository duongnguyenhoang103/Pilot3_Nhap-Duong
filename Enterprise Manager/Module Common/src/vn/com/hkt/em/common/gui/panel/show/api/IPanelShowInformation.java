/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.common.gui.panel.show.api;

/**
 *
 * @author BinLe
 */
public interface IPanelShowInformation extends IPanelShowTotal {

    public static final int FUNCTION_CREATE = 1;
    public static final int FUNCTION_EDIT = 2;
    public static final int ID_FAILD = -1;

    /**
     * Lấy miêu tả của giao diện thiển thị thông tin
     * @return : String; Miêu tả ngắn ngọn
     */
    public String getDescriptionPanel();

    /**
     * Thực hiện chức năng reset,xóa toàn bộ thông tin hiển thị
     */
    public void resetData();

    /**
     * Thực hiện chức năng thêm mới đối với các thông tin hiển thị trên giao diện
     * Trả về id đối tượng được thêm
     */
    public long addData(long idParent);

    /**
     * Thực hiện chức năng load lại dữ liệu đối với trường hợp hiển thị thông tin
     */
    public void refreshData();

    /**
     * Thực hiện chức năng cho phép chỉnh sửa dữ liệu đối với trường hợp hiển thị thông tin     
     */
    public void canEditData();

    /**
     * Thực hiện chức năng sửa dữ liệu đối với trường hợp hiển thị thông tin
     * Trả về id đối tượng được ủa
     */
    public long editData();

    /**
     * Thực hiện chức năng xóa dữ liệu đối với trường hợp hiển thị thông tin
     * Trả về id đối tượng bị xóa
     */
    public long removeData();

    /**
     * Lấy trường hợp đang thực thi của giao diện:
     * FUNCTION_CREATE = 1: tạo mới dữ liệu
     * FUNCTION_EDIT = 2: xem sửa xóa dữ liệu
     */
    public int getFunction();

    /**
     * Kiểm tra tính đúng đắn của dữ liệu
     * @return 
     */
    public boolean checkData();
    /**
     * hàm thực hiện load lại các thuộc tính có thể thay đổi
     * sử dụng với sự kiện component show
     */
    public void loadDefault();

}
