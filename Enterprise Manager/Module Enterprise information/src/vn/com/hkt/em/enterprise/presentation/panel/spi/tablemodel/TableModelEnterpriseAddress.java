/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.enterprise.presentation.panel.spi.tablemodel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.openide.util.Lookup;
import vn.com.hkt.em.basic.data.access.api.ICityDAO;
import vn.com.hkt.em.basic.data.access.api.ICountryDAO;
import vn.com.hkt.em.basic.data.entities.City;
import vn.com.hkt.em.basic.data.entities.Country;
import vn.com.hkt.em.enterprise.data.entities.EnterpriseAddress;

/**
 *
 * @author BinLe
 */
public class TableModelEnterpriseAddress extends AbstractTableModel {

    private String[] header = new String[]{"Quốc gia", "Thành phố",
        "Địa chỉ", "Điện thoại", "Fax"};
    private List<EnterpriseAddress> list;

    public TableModelEnterpriseAddress(List<EnterpriseAddress> list) {
        this.list = list;
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }

    @Override
    public int getRowCount() {
        return list.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {           
            case 0: {
                ICountryDAO countryDAO = Lookup.getDefault().lookup(ICountryDAO.class);
                Country country = countryDAO.getById(list.get(rowIndex).getIdCountry());
                if (country != null) {
                    return country.getCountryName();
                } else {
                    return "";
                }
            }
            case 1: {
                ICityDAO cityDAO = Lookup.getDefault().lookup(ICityDAO.class);
                City city = cityDAO.getById(list.get(rowIndex).getIdCity());
                if (city != null) {
                    return city.getCityName();
                } else {
                    return "";
                }
            }
            case 2:
                return list.get(rowIndex).getAddress();
            case 3:
                return list.get(rowIndex).getTelephone();
            case 4:
                return list.get(rowIndex).getFax();
            default:
                return "";
        }
    }
}
