/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.basic.presentation.dialog.api;

import javax.swing.JComboBox;
import vn.com.hkt.em.common.gui.panel.show.api.IPanelShowInformation;

/**
 * Mặt nạ giao diện thêm, sửa, xóa thông các đối tượng như:
 * Quốc gia, thành phố, tình trạng hôn nhân, loại hình doanh nghiệp...
 * @author BinLe
 */
public interface IInformationDialog extends IPanelShowInformation{
    /**
     * Truyền vào combox chọn gọi dialog để khi tắt dialog thì trả lại 
     * danh sách đối tượng vào combobox;
     * @param comboBox :JCombobox :combobox được chọn
     */
    public void setComboBox(JComboBox comboBox);
    
    public void setVisible(boolean visiable);
}
