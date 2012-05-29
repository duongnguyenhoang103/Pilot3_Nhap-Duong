/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.basic.presentation.dialog.spi.tablemodel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import vn.com.hkt.em.basic.data.entities.Country;

/**
 *
 * @author BinLe
 */
public class CountryTableModel extends AbstractTableModel {

    private String[] header = new String[]{"Country Name", "Country Code", "Nationality", "Language", "Description"};
    private List<Country> countrys;

    public CountryTableModel(List<Country> countrys) {
        this.countrys = countrys;
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }

    @Override
    public int getRowCount() {
        return countrys.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return countrys.get(rowIndex).getCountryName();
            case 1:
                return countrys.get(rowIndex).getCountryCode();
            case 2:
                return countrys.get(rowIndex).getNationality();
            case 3:
                return countrys.get(rowIndex).getLanguage();
            case 4:
                return countrys.get(rowIndex).getDescription();
            default:
                return "";
        }
    }
}
