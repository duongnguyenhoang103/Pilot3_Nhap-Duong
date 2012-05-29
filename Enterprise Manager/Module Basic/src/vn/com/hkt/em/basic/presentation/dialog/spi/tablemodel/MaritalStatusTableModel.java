/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.basic.presentation.dialog.spi.tablemodel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import vn.com.hkt.em.basic.data.entities.MaritalStatus;

/**
 *
 * @author BinLe
 */
public class MaritalStatusTableModel extends AbstractTableModel {

    private String[] header = new String[]{"Tình trạng hôn nhân", "Miêu tả"};
    private List<MaritalStatus> maritalStatuses;

    public MaritalStatusTableModel(List<MaritalStatus> maritalStatuses) {
        this.maritalStatuses = maritalStatuses;
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }

    @Override
    public int getRowCount() {
        return maritalStatuses.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return maritalStatuses.get(rowIndex).getMaritalStatusName();
            case 1:
                return maritalStatuses.get(rowIndex).getDescription();
            default:
                return "";
        }
    }
}
