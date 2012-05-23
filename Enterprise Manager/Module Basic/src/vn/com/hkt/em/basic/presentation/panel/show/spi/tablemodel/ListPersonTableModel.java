/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.basic.presentation.panel.show.spi.tablemodel;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.swing.table.AbstractTableModel;
import vn.com.hkt.em.basic.data.access.spi.CityDAO;
import vn.com.hkt.em.basic.data.access.spi.CountryDAO;
import vn.com.hkt.em.basic.data.access.spi.MaritalStatusDAO;
import vn.com.hkt.em.basic.data.entities.City;
import vn.com.hkt.em.basic.data.entities.Country;
import vn.com.hkt.em.basic.data.entities.MaritalStatus;
import vn.com.hkt.em.basic.data.entities.Person;

/**
 *Đối tượng model thể hiện dữ liệu danh sách thông tin cá nhân
 * trong giao diện thể thiện danh sách thông tin cá nhân
 * @author BinLe
 */
public class ListPersonTableModel extends AbstractTableModel {
    // header của table

    private String[] header = new String[]{"Họ", "Tên", "Ngày sinh",
        "Giới tính", "Chứng minh thư", "Địa chỉ", "Điện thoại cố định",
        "Điện thoại di động", "Email", "Fax", "Website", "Tình trạng hôn nhân",
        "Quốc gia", "Thành phố", "Miêu tả"};
    //danh sách cá nhân
    private List<Person> persons;

    /**
     * Contructor truyền vào danh sách cá nhân
     * @param persons 
     */
    public ListPersonTableModel(List<Person> persons) {
        this.persons = persons;
    }

    @Override
    public String getColumnName(int column) {
        return header[column];
    }

    @Override
    public int getRowCount() {
        return persons.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return persons.get(rowIndex).getFirstName();
            case 1:
                return persons.get(rowIndex).getLastName();
            case 2: {
                if (null == persons.get(rowIndex).getBirthday()) {
                    return "";
                }
                Date date = persons.get(rowIndex).getBirthday();
                return new SimpleDateFormat("dd/MM/yyyy").format(date);
            }
            case 3:
                return persons.get(rowIndex).getGender();
            case 4:
                return persons.get(rowIndex).getIdentityCard();
            case 5:
                return persons.get(rowIndex).getAddress();
            case 6:
                return persons.get(rowIndex).getTelephone();
            case 7:
                return persons.get(rowIndex).getMobile();
            case 8:
                return persons.get(rowIndex).getEmail();
            case 9:
                return persons.get(rowIndex).getFax();
            case 10:
                return persons.get(rowIndex).getWebsite();
            case 11: {
                MaritalStatus ms = new MaritalStatusDAO().getById(persons.get(rowIndex).getIdMaritalStatus());
                if (ms != null) {
                    return ms;
                }
                return "";
            }
            case 12: {
                Country Co = new CountryDAO().getById(persons.get(rowIndex).getIdCountry());
                if (Co != null) {
                    return Co;
                }
                return "";
            }
            case 13: {
                City ci = new CityDAO().getById(persons.get(rowIndex).getIdCity());
                if (ci != null) {
                    return ci;
                }
                return "";
            }
            case 14:
                return persons.get(rowIndex).getDescription();
            default:
                return "";

        }
    }
}
