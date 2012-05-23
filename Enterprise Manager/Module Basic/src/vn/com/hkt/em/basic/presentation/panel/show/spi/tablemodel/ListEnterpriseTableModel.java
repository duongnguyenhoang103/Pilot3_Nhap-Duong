/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.basic.presentation.panel.show.spi.tablemodel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import vn.com.hkt.em.basic.data.access.spi.CityDAO;
import vn.com.hkt.em.basic.data.access.spi.CountryDAO;
import vn.com.hkt.em.basic.data.access.spi.EnterpriseDAO;
import vn.com.hkt.em.basic.data.entities.City;
import vn.com.hkt.em.basic.data.entities.Country;
import vn.com.hkt.em.basic.data.entities.Enterprise;

/**
 * Đối tượng model thể hiện dữ liệu danh sách thông tin doanh nghiệp 
 * trong giao diện thể thiện danh sách thông tin doanh nghiệp
 * @author BinLe
 */
public class ListEnterpriseTableModel extends AbstractTableModel {
    // header của table

    private String[] header = new String[]{"Tên doanh nghiệp", "Mã doanh nghiệp",
        "Tiêu chí hoạt động", "Địa chỉ", "Điện thoại", "Fax", "Email", "Website",
        "Miêu tả", "Doanh nghiệp cha", "Quốc gia", "Thành phố"};
    //danh sách doanh nghiệp
    private List<Enterprise> enterprises;

    /**
     * Contructor truyền vào danh sách doanh nghiệp
     * @param enterprises 
     */
    public ListEnterpriseTableModel(List<Enterprise> enterprises) {
        this.enterprises = enterprises;
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }

    @Override
    public int getRowCount() {
        return enterprises.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return enterprises.get(rowIndex).getEnterpriseName();
            case 1:
                return enterprises.get(rowIndex).getEnterpriseCode();
            case 2:
                return enterprises.get(rowIndex).getSlogan();
            case 3:
                return enterprises.get(rowIndex).getAddress();
            case 4:
                return enterprises.get(rowIndex).getTelephone();
            case 5:
                return enterprises.get(rowIndex).getFax();
            case 6:
                return enterprises.get(rowIndex).getEmail();
            case 7:
                return enterprises.get(rowIndex).getWebsite();
            case 8:
                return enterprises.get(rowIndex).getDescription();
            case 9: {
                Enterprise e = new EnterpriseDAO().getById(enterprises.get(rowIndex).getIdEnterpriseParent());
                if (e != null) {
                    return e;
                } else {
                    return "";
                }
            }
            case 10: {
                Country et = new CountryDAO().getById(enterprises.get(rowIndex).getIdCountry());
                if (et != null) {
                    return et;
                } else {
                    return "";
                }
            }
            case 11: {
                City et = new CityDAO().getById(enterprises.get(rowIndex).getIdCity());
                if (et != null) {
                    return et;
                } else {
                    return "";
                }
            }
            default:
                return "";

        }
    }
}
