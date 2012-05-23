/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.enterprise.presentation.panel.spi.table.model;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import vn.com.hkt.em.enterprise.data.access.api.IBusinessAreaDAO;
import vn.com.hkt.em.enterprise.data.access.spi.BusinessAreaDAO;
import vn.com.hkt.em.enterprise.data.entities.BusinessArea;
import vn.com.hkt.em.enterprise.data.entities.EnterpriseAddress;
import vn.com.hkt.em.enterprise.data.entities.EnterpriseBusinessArea;

/**
 *
 * @author duong
 */
public class TableModelEnterpriseBusinessArea extends AbstractTableModel {

    private String[] header = new String[]{
        "Lĩnh vực kinh doanh", "Tầm quan trọng", "Miêu tả"
    };
    private List<EnterpriseBusinessArea> enterpriseBusinessAreas;//lop BE

    public TableModelEnterpriseBusinessArea(List<EnterpriseBusinessArea> enterpriseBusinessAreas) {
        this.enterpriseBusinessAreas = enterpriseBusinessAreas;
    }

  

//    public TableModelEnterpriseBusinessArea() {
//    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }

    @Override
    public int getRowCount() {
        return enterpriseBusinessAreas.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0: {
                IBusinessAreaDAO businessAreaDAO = new BusinessAreaDAO(); // ket noi DAO
                //BE
                BusinessArea businessArea = businessAreaDAO.getById(enterpriseBusinessAreas.get(rowIndex).getIdBusinessArea());
                if (businessArea != null) {
                    return businessArea.getBusinessAreaName();
                } else {
                    return "";
                }
            }
            case 1:
                return String.valueOf(enterpriseBusinessAreas.get(rowIndex).getRanking());
            case 2:
                return enterpriseBusinessAreas.get(rowIndex).getDescription();
            default:
                return "";
        }




    }
}
