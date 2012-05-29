/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.enterprise.presentation.dialog.spi.tablemodel;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import vn.com.hkt.em.enterprise.data.entities.EnterpriseType;

/**
 *
 * @author BinLe
 */
public class EnterpriseTypeTableModel extends AbstractTableModel {

    private String[] header = new String[]{"Loại hình doanh nghiệp", "Miêu tả"};
    private List<EnterpriseType> enterpriseTypes;

    public EnterpriseTypeTableModel(List<EnterpriseType> enterpriseTypes) {
        this.enterpriseTypes = enterpriseTypes;
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }

    @Override
    public int getRowCount() {
        return enterpriseTypes.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return enterpriseTypes.get(rowIndex).getEnterpriseTypeName();
            case 1:
                return enterpriseTypes.get(rowIndex).getDescription();
            default:
                return "";
        }
    }
}
