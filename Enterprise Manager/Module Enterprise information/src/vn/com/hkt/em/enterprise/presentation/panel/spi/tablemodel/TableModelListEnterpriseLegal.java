/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.enterprise.presentation.panel.spi.tablemodel;

import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import org.openide.util.Lookup;
import vn.com.hkt.em.basic.data.access.api.IEnterpriseDAO;
import vn.com.hkt.em.basic.data.access.api.IPersonDAO;
import vn.com.hkt.em.basic.data.entities.Enterprise;
import vn.com.hkt.em.basic.data.entities.Person;
import vn.com.hkt.em.enterprise.data.access.spi.EnterpriseTypeDAO;
import vn.com.hkt.em.enterprise.data.entities.EnterpriseLegal;
import vn.com.hkt.em.enterprise.data.entities.EnterpriseType;

/**
 *
 * @author BinLe
 */
public class TableModelListEnterpriseLegal extends AbstractTableModel {

    private List<EnterpriseLegal> list;
    private String[] header = new String[]{"Doanh nghiệp", "Tên tiếng Anh",
        "Tên tiếng Việt", "Loại hình doanh nghiếp", "Chịu trách nhiệm",
        "Ngày đăng kí", "Ngày thành lập", "Vốn điều lệ", "Vốn pháp định",
        "Số đăng kí kinh doanh", "Lần đăng kí kinh doanh", "Mã số thuế"};

    public TableModelListEnterpriseLegal(List<EnterpriseLegal> listInformation) {
        this.list = listInformation;
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
                IEnterpriseDAO edao = Lookup.getDefault().lookup(IEnterpriseDAO.class);
                Enterprise e = edao.getById(list.get(rowIndex).getIdEnterprise());
                if (e != null) {
                    return e.getEnterpriseName();
                }
                return "";
            }
            case 1:
                return list.get(rowIndex).getEnterpriseNameEnglish();
            case 2:
                return list.get(rowIndex).getEnterpriseNameVietNam();
            case 3:
                EnterpriseTypeDAO etdao = new EnterpriseTypeDAO();
                EnterpriseType et = etdao.getById(list.get(rowIndex).getIdEnterpriseType());
                if (et != null) {
                    return et.getEnterpriseTypeName();
                }
                return "";
            case 4:
                IPersonDAO personDAO = Lookup.getDefault().lookup(IPersonDAO.class);
                Person p = personDAO.getById(list.get(rowIndex).getIdPersonResponsibleLegal());
                if (p != null) {
                    return p.getFirstName() + " " + p.getLastName();
                }
                return "";
            case 5:
                if (list.get(rowIndex).getDateRegistration() == null) {
                    return "";
                }
                return new SimpleDateFormat("dd/MM/yyyy").format(list.get(rowIndex).getDateRegistration());
            case 6:
                if (list.get(rowIndex).getDateEstablishment() == null) {
                    return "";
                }
                return new SimpleDateFormat("dd/MM/yyyy").format(list.get(rowIndex).getDateEstablishment());
            case 7:
                return list.get(rowIndex).getCharteredCapital();
            case 8:
                return list.get(rowIndex).getLegalCapital();
            case 9:
                return list.get(rowIndex).getBusinessResgitrationNumber();
            case 10:
                return list.get(rowIndex).getBusinessRegistrationTime();
            case 11:
                return list.get(rowIndex).getTaxCodeNumber();
            default:
                return "";
        }
    }
}
