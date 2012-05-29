/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.enterprise.presentation.dialog.spi.tablemodel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import vn.com.hkt.em.enterprise.data.entities.BusinessArea;

/**
 *
 * @author BinLe
 */
public class BusinessAreaTableModel extends AbstractTableModel {

    private String[] header = new String[]{"Lĩnh vực kinh doanh", "Mã lĩnh vực kinh doanh", "Miêu tảs"};
    private List<BusinessArea> BusinessAreas;

    public BusinessAreaTableModel(List<BusinessArea> BusinessAreas) {
        this.BusinessAreas = BusinessAreas;
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }

    @Override
    public int getRowCount() {
        return BusinessAreas.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return BusinessAreas.get(rowIndex).getBusinessAreaName();
            case 1:
                return BusinessAreas.get(rowIndex).getBusinessAreaCode();
            case 2:
                return BusinessAreas.get(rowIndex).getDescription();
            default:
                return "";
        }
    }
}
