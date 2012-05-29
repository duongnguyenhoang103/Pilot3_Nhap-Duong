/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.basic.presentation.dialog.spi.tablemodel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import vn.com.hkt.em.basic.data.access.spi.CountryDAO;
import vn.com.hkt.em.basic.data.entities.City;
import vn.com.hkt.em.basic.data.entities.Country;

/**
 *
 * @author BinLe
 */
public class CityTableModel extends AbstractTableModel {

    private String[] header = new String[]{"Tên thành phố", "Mã thành phố", "Quốc gia", "Miêu tả"};
    private List<City> cities;

    public CityTableModel(List<City> cities) {
        this.cities = cities;
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }

    @Override
    public int getRowCount() {
        return cities.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return cities.get(rowIndex).getCityName();
            case 1:
                return cities.get(rowIndex).getCityCode();
            case 2:
                Country country = new CountryDAO().getById(cities.get(rowIndex).getIdCountry());
                if (country != null) {
                    return country;
                } else {
                    return "";
                }
            case 3:
                return cities.get(rowIndex).getDescription();
            default:
                return "";
        }
    }
}
