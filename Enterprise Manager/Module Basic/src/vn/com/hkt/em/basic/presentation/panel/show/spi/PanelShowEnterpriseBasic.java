/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PanelShowEnterpriseBasic.java
 *
 * Created on May 2, 2012, 10:11:20 AM
 */
package vn.com.hkt.em.basic.presentation.panel.show.spi;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import org.openide.util.lookup.ServiceProvider;
import vn.com.hkt.em.basic.business.provide.panel.api.IProviderPanelShowEnterprise;
import vn.com.hkt.em.basic.business.providei.panel.spi.ProviderPanelShowEnterprise;
import vn.com.hkt.em.basic.data.entities.City;
import vn.com.hkt.em.basic.data.entities.Country;
import vn.com.hkt.em.basic.data.entities.Enterprise;
import vn.com.hkt.em.basic.presentation.dialog.spi.CityDialog;
import vn.com.hkt.em.basic.presentation.dialog.spi.CountryDialog;
import vn.com.hkt.em.basic.presentation.panel.show.api.IPanelShowEnterpriseBaisc;
import vn.com.hkt.em.common.data.CheckData;
import vn.com.hkt.em.common.event.KeyControlPress;
import vn.com.hkt.em.common.image.ImageTool;

/**
 *
 * @author BinLe
 */
@ServiceProvider(service = IPanelShowEnterpriseBaisc.class)
public class PanelShowEnterpriseBasic extends javax.swing.JPanel implements IPanelShowEnterpriseBaisc {

    private final long LEVEL = 1;// Lever=1
    // bắt sư kiện nhấn Controll
    private KeyControlPress keyControlPress = new KeyControlPress();
    //Tool xử lý ảnh
    private ImageTool imageTool = new ImageTool();
    //Provier cung cấp dữ liệu
    private IProviderPanelShowEnterprise provider = new ProviderPanelShowEnterprise();
    //chức năng hiện tại của giao diện là tạo mới hay xem,sửa,xóa (Mặc định là tạo mới)
    private int function = FUNCTION_CREATE;
    private CheckData checkData = new CheckData();

    /** Creates new form PanelShowEnterpriseBasic */
    public PanelShowEnterpriseBasic() {
        initComponents();
        function = FUNCTION_CREATE;
        resetData();
        setDefaultListener(); // thuc hien su kien  mo dialog
        // loadDefault();
    }

    private void loadCombobxEnterpriseParent() {//load dn cha
        List<Enterprise> le = provider.getEnterprisesAbilityIsParent();
     //   le.add(0,null);
        cbEnerpriseParent.setModel(new DefaultComboBoxModel(le.toArray()));
    }

    private void loadComboboxCountry() {
        List<Country> listCountrys = provider.getCountries();
       // listCountrys.add(0,null);// them 1 thang rong vao cb
        cbCountry.setModel(new DefaultComboBoxModel(listCountrys.toArray()));
        //  cbCountry.setModel(new DefaultComboBoxModel(provider.getCountries().toArray()));
    }

    private void loadComboboxCity() {
        if (cbCountry.getSelectedItem() != null) {
            Country country = (Country) cbCountry.getSelectedItem();
            List<City> listCitys = provider.getCities(country);
          //  listCitys.add(0, null);
            cbCity.setModel(new DefaultComboBoxModel(listCitys.toArray()));
        } else {
            cbCity.setModel(new DefaultComboBoxModel());
        }
//        Country c = (Country) cbCountry.getSelectedItem();
//        cbCity.setModel(new DefaultComboBoxModel(provider.getCities(c).toArray()));
    }

    private class CTR_CLICK extends MouseAdapter {

        private JComboBox comboBox;

        public CTR_CLICK(JComboBox comboBox) {
            this.comboBox = comboBox;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() >= 1 && keyControlPress.isKeyCTRL()) {
                if (comboBox.equals(cbCity)) {// hien thi city theo country duoc chon
                    try {// truyen BE = lay ra danh sach country dc chon
                        Country country = (Country) cbCountry.getSelectedItem();
                        CityDialog cii = new CityDialog();
                        cii.setComboBox(comboBox);
                        cii.setVisible(true);
                    } catch (Exception ex) {
                        //   loadComboboxCity();
                        JOptionPane.showConfirmDialog(null, ex);
                    }
                } else if (comboBox.equals(cbCountry)) {
                    CountryDialog coi = new CountryDialog();
                    coi.setComboBox(comboBox);
                    coi.setVisible(true);
                }
                keyControlPress.setKeyCTRL(false);
            }
        }
    }

    private void setDefaultListener() {
        cbCity.addKeyListener(keyControlPress);
        cbCity.addMouseListener(new CTR_CLICK(cbCity));

        cbCountry.addKeyListener(keyControlPress);
        cbCountry.addMouseListener(new CTR_CLICK(cbCountry));
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpanel5 = new javax.swing.JPanel();
        panelEnterInformation = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        cbCity = new javax.swing.JComboBox();
        cbCountry = new javax.swing.JComboBox();
        lbCity = new javax.swing.JLabel();
        cbEnerpriseParent = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAddress = new javax.swing.JTextArea();
        lbSlogan = new javax.swing.JLabel();
        lbEnterpriseCode = new javax.swing.JLabel();
        lbAddress = new javax.swing.JLabel();
        lbEnterpriseParent = new javax.swing.JLabel();
        lbCountry = new javax.swing.JLabel();
        lbEnterpriseName = new javax.swing.JLabel();
        txtEnterpriseName = new javax.swing.JTextField();
        txtEnterpriseCode = new javax.swing.JTextField();
        txtSlogan = new javax.swing.JTextField();
        jPanel4 = new javax.swing.JPanel();
        lbFax = new javax.swing.JLabel();
        txtFax = new javax.swing.JTextField();
        lbWebsite = new javax.swing.JLabel();
        txtWebsite = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        lbImage = new javax.swing.JLabel();
        lbTelephone = new javax.swing.JLabel();
        txtTelephone = new javax.swing.JTextField();
        lbEmail = new javax.swing.JLabel();
        txtEmail = new javax.swing.JTextField();
        lbDescription = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        lbMessenger = new javax.swing.JLabel();

        jpanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), org.openide.util.NbBundle.getMessage(PanelShowEnterpriseBasic.class, "PanelShowEnterpriseBasic.jpanel5.border.title"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        cbCountry.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbCountryItemStateChanged(evt);
            }
        });

        lbCity.setText(org.openide.util.NbBundle.getMessage(PanelShowEnterpriseBasic.class, "PanelShowEnterpriseBasic.lbCity.text")); // NOI18N

        jScrollPane1.setViewportView(txtAddress);

        lbSlogan.setText(org.openide.util.NbBundle.getMessage(PanelShowEnterpriseBasic.class, "PanelShowEnterpriseBasic.lbSlogan.text")); // NOI18N

        lbEnterpriseCode.setText(org.openide.util.NbBundle.getMessage(PanelShowEnterpriseBasic.class, "PanelShowEnterpriseBasic.lbEnterpriseCode.text")); // NOI18N

        lbAddress.setText(org.openide.util.NbBundle.getMessage(PanelShowEnterpriseBasic.class, "PanelShowEnterpriseBasic.lbAddress.text")); // NOI18N

        lbEnterpriseParent.setText(org.openide.util.NbBundle.getMessage(PanelShowEnterpriseBasic.class, "PanelShowEnterpriseBasic.lbEnterpriseParent.text")); // NOI18N

        lbCountry.setText(org.openide.util.NbBundle.getMessage(PanelShowEnterpriseBasic.class, "PanelShowEnterpriseBasic.lbCountry.text")); // NOI18N

        lbEnterpriseName.setText(org.openide.util.NbBundle.getMessage(PanelShowEnterpriseBasic.class, "PanelShowEnterpriseBasic.lbEnterpriseName.text")); // NOI18N

        txtEnterpriseName.setText(org.openide.util.NbBundle.getMessage(PanelShowEnterpriseBasic.class, "PanelShowEnterpriseBasic.txtEnterpriseName.text")); // NOI18N
        txtEnterpriseName.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtEnterpriseNameCaretUpdate(evt);
            }
        });

        txtEnterpriseCode.setText(org.openide.util.NbBundle.getMessage(PanelShowEnterpriseBasic.class, "PanelShowEnterpriseBasic.txtEnterpriseCode.text")); // NOI18N
        txtEnterpriseCode.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtEnterpriseCodeCaretUpdate(evt);
            }
        });

        txtSlogan.setText(org.openide.util.NbBundle.getMessage(PanelShowEnterpriseBasic.class, "PanelShowEnterpriseBasic.txtSlogan.text")); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lbEnterpriseName, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbEnterpriseCode, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbSlogan, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtEnterpriseName, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                    .addComponent(txtEnterpriseCode, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                    .addComponent(txtSlogan, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(lbEnterpriseParent, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbEnerpriseParent, 0, 97, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(lbCountry, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbCountry, 0, 97, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(lbCity, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbCity, 0, 97, Short.MAX_VALUE))
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addComponent(lbAddress, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lbEnterpriseName)
                        .addGap(17, 17, 17)
                        .addComponent(lbEnterpriseCode)
                        .addGap(17, 17, 17)
                        .addComponent(lbSlogan))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtEnterpriseName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(txtEnterpriseCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(txtSlogan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(lbEnterpriseParent))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbEnerpriseParent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(lbCountry))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cbCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lbCity))
                    .addComponent(cbCity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbAddress)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        lbFax.setText(org.openide.util.NbBundle.getMessage(PanelShowEnterpriseBasic.class, "PanelShowEnterpriseBasic.lbFax.text")); // NOI18N

        txtFax.setText(org.openide.util.NbBundle.getMessage(PanelShowEnterpriseBasic.class, "PanelShowEnterpriseBasic.txtFax.text")); // NOI18N
        txtFax.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtFaxCaretUpdate(evt);
            }
        });

        lbWebsite.setText(org.openide.util.NbBundle.getMessage(PanelShowEnterpriseBasic.class, "PanelShowEnterpriseBasic.lbWebsite.text")); // NOI18N

        txtWebsite.setText(org.openide.util.NbBundle.getMessage(PanelShowEnterpriseBasic.class, "PanelShowEnterpriseBasic.txtWebsite.text")); // NOI18N

        lbImage.setText(org.openide.util.NbBundle.getMessage(PanelShowEnterpriseBasic.class, "PanelShowEnterpriseBasic.lbImage.text")); // NOI18N
        lbImage.setPreferredSize(new java.awt.Dimension(150, 100));
        lbImage.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbImageMouseClicked(evt);
            }
        });
        jPanel2.add(lbImage);

        lbTelephone.setText(org.openide.util.NbBundle.getMessage(PanelShowEnterpriseBasic.class, "PanelShowEnterpriseBasic.lbTelephone.text")); // NOI18N

        txtTelephone.setText(org.openide.util.NbBundle.getMessage(PanelShowEnterpriseBasic.class, "PanelShowEnterpriseBasic.txtTelephone.text")); // NOI18N
        txtTelephone.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtTelephoneCaretUpdate(evt);
            }
        });

        lbEmail.setText(org.openide.util.NbBundle.getMessage(PanelShowEnterpriseBasic.class, "PanelShowEnterpriseBasic.lbEmail.text")); // NOI18N

        txtEmail.setText(org.openide.util.NbBundle.getMessage(PanelShowEnterpriseBasic.class, "PanelShowEnterpriseBasic.txtEmail.text")); // NOI18N

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbTelephone, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbFax, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbWebsite, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtTelephone, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                    .addComponent(txtEmail, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                    .addComponent(txtFax, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)
                    .addComponent(txtWebsite, javax.swing.GroupLayout.DEFAULT_SIZE, 117, Short.MAX_VALUE)))
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 221, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lbTelephone))
                    .addComponent(txtTelephone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lbFax))
                    .addComponent(txtFax, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(lbWebsite))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(txtWebsite, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lbEmail))
                    .addComponent(txtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, 280, Short.MAX_VALUE)
            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        lbDescription.setText(org.openide.util.NbBundle.getMessage(PanelShowEnterpriseBasic.class, "PanelShowEnterpriseBasic.lbDescription.text")); // NOI18N

        jScrollPane2.setViewportView(txtDescription);

        lbMessenger.setForeground(new java.awt.Color(255, 0, 0));
        lbMessenger.setText(org.openide.util.NbBundle.getMessage(PanelShowEnterpriseBasic.class, "PanelShowEnterpriseBasic.lbMessenger.text")); // NOI18N
        lbMessenger.setMaximumSize(new java.awt.Dimension(100, 14));
        lbMessenger.setMinimumSize(new java.awt.Dimension(0, 0));

        javax.swing.GroupLayout panelEnterInformationLayout = new javax.swing.GroupLayout(panelEnterInformation);
        panelEnterInformation.setLayout(panelEnterInformationLayout);
        panelEnterInformationLayout.setHorizontalGroup(
            panelEnterInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEnterInformationLayout.createSequentialGroup()
                .addComponent(lbDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 336, Short.MAX_VALUE))
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(lbMessenger, javax.swing.GroupLayout.DEFAULT_SIZE, 440, Short.MAX_VALUE)
        );
        panelEnterInformationLayout.setVerticalGroup(
            panelEnterInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelEnterInformationLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(panelEnterInformationLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbDescription)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbMessenger, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout jpanel5Layout = new javax.swing.GroupLayout(jpanel5);
        jpanel5.setLayout(jpanel5Layout);
        jpanel5Layout.setHorizontalGroup(
            jpanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel5Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(panelEnterInformation, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(29, 29, 29))
        );
        jpanel5Layout.setVerticalGroup(
            jpanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelEnterInformation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

private void txtEnterpriseNameCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtEnterpriseNameCaretUpdate
    if ("".equals(txtEnterpriseName.getText().toString().trim()) || txtEnterpriseName.getText().isEmpty()) {
        lbEnterpriseName.setForeground(Color.red);
    } else {
        lbEnterpriseName.setForeground(Color.black);

    }
}//GEN-LAST:event_txtEnterpriseNameCaretUpdate

private void txtEnterpriseCodeCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtEnterpriseCodeCaretUpdate

    if ((txtEnterpriseCode.getText().toString().trim() == null) || txtEnterpriseCode.getText().isEmpty()) {
        lbEnterpriseCode.setForeground(Color.red);

    } else {
        lbEnterpriseCode.setForeground(Color.black);
    }

}//GEN-LAST:event_txtEnterpriseCodeCaretUpdate

private void txtTelephoneCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtTelephoneCaretUpdate
    if (checkData.isNumberPhone(txtTelephone.getText())) {
        lbTelephone.setForeground(Color.black);
    } else {
        lbTelephone.setForeground(Color.red);
    }
}//GEN-LAST:event_txtTelephoneCaretUpdate

private void txtFaxCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtFaxCaretUpdate
    if (checkData.isNumberPhone(txtFax.getText())) {
        lbFax.setForeground(Color.black);
    } else {
        lbFax.setForeground(Color.red);
        //  txtFax.setText("");        
    }
}//GEN-LAST:event_txtFaxCaretUpdate

private void lbImageMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbImageMouseClicked
    if (evt.getClickCount() >= 2 && txtEnterpriseName.isEnabled()) {
        ImageIcon image = imageTool.getImage();
        if (image != null) {
            image = imageTool.resize(image, new Dimension(150, 100));
            lbImage.setIcon(image);
        } else {
            lbImage.setIcon(null);
        }
    }

}//GEN-LAST:event_lbImageMouseClicked
// khi select cbCoutry hien thi cbCity theo CbCOutry
private void cbCountryItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbCountryItemStateChanged
    loadComboboxCity();
}//GEN-LAST:event_cbCountryItemStateChanged
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cbCity;
    private javax.swing.JComboBox cbCountry;
    private javax.swing.JComboBox cbEnerpriseParent;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel jpanel5;
    private javax.swing.JLabel lbAddress;
    private javax.swing.JLabel lbCity;
    private javax.swing.JLabel lbCountry;
    private javax.swing.JLabel lbDescription;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbEnterpriseCode;
    private javax.swing.JLabel lbEnterpriseName;
    private javax.swing.JLabel lbEnterpriseParent;
    private javax.swing.JLabel lbFax;
    private javax.swing.JLabel lbImage;
    private javax.swing.JLabel lbMessenger;
    private javax.swing.JLabel lbSlogan;
    private javax.swing.JLabel lbTelephone;
    private javax.swing.JLabel lbWebsite;
    private javax.swing.JPanel panelEnterInformation;
    private javax.swing.JTextArea txtAddress;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtEnterpriseCode;
    private javax.swing.JTextField txtEnterpriseName;
    private javax.swing.JTextField txtFax;
    private javax.swing.JTextField txtSlogan;
    private javax.swing.JTextField txtTelephone;
    private javax.swing.JTextField txtWebsite;
    // End of variables declaration//GEN-END:variables

    @Override
    public long getLevelPanelShowEnterpriseBasic() {
        return LEVEL;
    }

    @Override // truyen vao 1 Enter 
    public void setEnterprise(Enterprise enterprise) {
        provider.setDataView(enterprise);
        function = FUNCTION_EDIT;
        refreshData();
        showEdit(false);
    }

    @Override
    public String getDescriptionPanel() {
        return "Thông tin cơ bản doanh nghiệp";
    }

    @Override
    public void resetData() { // dien moi
        showEdit(true);
        txtAddress.setText("");
        txtDescription.setText("");
        txtEmail.setText("");
        txtEnterpriseCode.setText("");
        txtEnterpriseName.setText("");
        txtFax.setText("");
        txtSlogan.setText("");
        txtTelephone.setText("");
        txtWebsite.setText("");
        lbImage.setIcon(null);
        provider.setDataView(new Enterprise());
        loadCombobxEnterpriseParent();
        loadComboboxCountry();
        loadComboboxCity();
        lbMessenger.setVisible(false);
        function = FUNCTION_CREATE;

    }

    /** 
     *  hiển thị chức năng xem có cho phép sửa dữ liệu không
     */
    private void showEdit(boolean editable) {
        txtAddress.setEnabled(editable);
        txtDescription.setEnabled(editable);
        txtEmail.setEnabled(editable);
        txtEnterpriseCode.setEnabled(editable);
        txtEnterpriseName.setEnabled(editable);
        txtFax.setEnabled(editable);
        txtSlogan.setEnabled(editable);
        txtTelephone.setEnabled(editable);
        txtWebsite.setEnabled(editable);
        cbCity.setEnabled(editable);
        cbCountry.setEnabled(editable);
        cbEnerpriseParent.setEnabled(editable);


    }

    /**
     * Thực hiện truyền dữ liệu từ trên giao diện xuống tần business
     */
    private boolean getData() {
        if (!checkData()) {
            return false;
        } else {
            provider.getDataViewCurrent().setEnterpriseName(txtEnterpriseName.getText());
            provider.getDataViewCurrent().setEnterpriseCode(txtEnterpriseCode.getText());
            provider.getDataViewCurrent().setSlogan(txtSlogan.getText());
            try {// lay lop BE()
                Enterprise e = (Enterprise) cbEnerpriseParent.getSelectedItem();
                provider.getDataViewCurrent().setIdEnterpriseParent(e.getId());
            } catch (Exception e) {
                provider.getDataViewCurrent().setIdEnterpriseParent(0);
            }
            try {
                Country country = (Country) cbCountry.getSelectedItem();
                provider.getDataViewCurrent().setIdCountry(country.getId());
            } catch (Exception e) {
                provider.getDataViewCurrent().setIdCountry(0);
            }
            try {
                City ci = (City) cbCity.getSelectedItem();
                provider.getDataViewCurrent().setIdCity(ci.getId());
            } catch (Exception e) {
                provider.getDataViewCurrent().setIdCity(0);
            }
            provider.getDataViewCurrent().setAddress(txtAddress.getText());
            provider.getDataViewCurrent().setDescription(txtDescription.getText());
            provider.getDataViewCurrent().setTelephone(txtTelephone.getText());
            provider.getDataViewCurrent().setFax(txtFax.getText());
            provider.getDataViewCurrent().setEmail(txtEmail.getText());
            provider.getDataViewCurrent().setWebsite(txtWebsite.getText());
            try {
                ImageIcon image = (ImageIcon) lbImage.getIcon();
                provider.getDataViewCurrent().setImage(imageTool.convertImage2ByteArray(image.getImage()));
            } catch (Exception e) {
                provider.getDataViewCurrent().setImage(null);
            }
            return true;
        }

    }

    @Override
    public long addData(long idParent) {// luu tam  xuong provider 
        if (!getData()) {

            return ID_FAILD;
        }
        long id = provider.addData(idParent);
        if (id < 0) {
            return ID_FAILD;

        } else {
            lbMessenger.setVisible(false);
            return id;
        }
    }

    @Override
    public void refreshData() {// lay giu lieu hien thi len form (các txt hay cb) refresh lại
        provider.refreshData();
        try {
            txtEnterpriseName.setText(provider.getDataViewCurrent().getEnterpriseName());
            txtEnterpriseCode.setText(provider.getDataViewCurrent().getEnterpriseCode());
            txtSlogan.setText(provider.getDataViewCurrent().getSlogan());
            txtAddress.setText(provider.getDataViewCurrent().getAddress());
            txtDescription.setText(provider.getDataViewCurrent().getDescription());
            txtEmail.setText(provider.getDataViewCurrent().getEmail());
            txtFax.setText(provider.getDataViewCurrent().getFax());
            txtTelephone.setText(provider.getDataViewCurrent().getTelephone());
            txtWebsite.setText(provider.getDataViewCurrent().getWebsite());

         //   loadCombobxEnterpriseParent();
            if (provider.getDataViewCurrent().getIdCountry() > 0) {
                for (int i = 0; i < cbCountry.getItemCount(); i++) {
                    if (cbCountry.getItemAt(i) != null
                            && ((Country) cbCountry.getItemAt(i)).getId() == provider.getDataViewCurrent().getIdCountry()) {
                        cbCountry.setSelectedIndex(i);
                        break;
                    }
                }
              }else {
                cbCountry.setSelectedIndex(-1);
            }
            
            if (provider.getDataViewCurrent().getIdCity() > 0) {
                for (int i = 0; i < cbCity.getItemCount(); i++) {
                    if (cbCity.getItemAt(i) != null
                            && ((City) cbCity.getItemAt(i)).getId() == provider.getDataViewCurrent().getIdCity()) {
                        cbCity.setSelectedIndex(i);
                        break;
                    }
                }
            }else {
                cbCity.setSelectedIndex(-1);
            }
            
            if (provider.getDataViewCurrent().getIdEnterpriseParent() > 0) {
                for (int i = 0; i < cbEnerpriseParent.getItemCount(); i++) {
                    if ((cbEnerpriseParent.getItemAt(i) != null)
                            && ((Enterprise) cbEnerpriseParent.getItemAt(i)).getId() == provider.getDataViewCurrent().getIdEnterpriseParent()) {
                        cbEnerpriseParent.setSelectedIndex(i);
                        break;
                    }
                }
                
            }else{
                cbEnerpriseParent.setSelectedIndex(-1);// load lai ban dau khi select dong khac 
            }

            if (provider.getDataViewCurrent().getImage() != null) {
                lbImage.setIcon(new ImageIcon(provider.getDataViewCurrent().getImage()));
            } else {
                lbImage.setIcon(null);
            }
            showEdit(false);
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null, e);
        }

    }

    @Override
    public void canEditData() {// hiển thị khi action chỉnh sửa
        showEdit(true);
    }

    @Override
    public long editData() { // action edit 
        if (!getData()) { // nếu không phải nhập dl truyền xuống
            return ID_FAILD;
        }
        long id = provider.editData();
        if (id < 0) {
            return ID_FAILD;
        } else {
            lbMessenger.setVisible(false);
            return id;
        }
    }

    @Override
    public long removeData() {
        //lay ra id de xoa 
        long id = provider.getDataViewCurrent().getId();
        if (provider.removeData() < 0) { // goi den provider xoa du lieu o (DAO ) hay la providerPanelShowEnterPrise
            return ID_FAILD;
        } else {
            lbMessenger.setVisible(false);
            return id;
        }

    }

    @Override
    public int getFunction() {
        return function;
    }

    @Override
    public boolean checkData() {
        if (lbEnterpriseName.getForeground() == Color.red
                || lbTelephone.getForeground() == Color.red
                || lbFax.getForeground() == Color.red) {
            lbMessenger.setVisible(true);
            lbMessenger.setText("Hãy chú ý dữ liệu những phần bị đỏ");
            return false;
        } else {
            lbMessenger.setVisible(false);
            return true;
        }

    }

    @Override
    public void loadDefault() {
        //   loadCombobxEnterpriseParent();
//        loadComboboxCountry();
//        loadComboboxCity();
    }
}
