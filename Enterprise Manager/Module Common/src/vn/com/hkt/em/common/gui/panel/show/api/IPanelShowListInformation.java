/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.common.gui.panel.show.api;

import java.util.List;
import vn.com.hkt.em.common.gui.controlshow.api.IControlShowListInformation;
import vn.com.hkt.em.common.gui.panel.controlshow.spi.PanelControlShowListInformation;

/**
 * Mặt nạ hiển thị danh sách
 * @author BinLe
 */
public interface IPanelShowListInformation extends IPanelShowTotal {

    public void setControlShowListInformation(IControlShowListInformation controlShowListInformation);

    /**
     * Thực hiện chức năng load toàn bộ dữ liệu lên giao diện
     */
    public void loadDataDefault();

    /**
     * Thực hiện chức năng load dữ liệu lên giao diện theo danh sach id
     */
    public void loadData(List<Long> listId);

    /**
     * Thực hiện chức năng tìm kiếm trên giao diện
     */
    public void searchData(String worldSearch, String typeSearch);
}
