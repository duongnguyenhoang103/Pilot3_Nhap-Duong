/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * CountryInfomation.java
 *
 * Created on Apr 2, 2012, 8:14:32 PM
 */
package vn.com.hkt.em.basic.presentation.dialog.spi;

import java.awt.Color;
import java.awt.Dimension;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import org.openide.util.lookup.ServiceProvider;
import vn.com.hkt.em.basic.data.entities.Country;
import vn.com.hkt.em.basic.presentation.dialog.api.ICountryDialog;

import vn.com.hkt.em.common.image.ImageTool;

/**
 *
 * @author BinLe
 */
@ServiceProvider(service = ICountryDialog.class)
public class CountryDialog extends javax.swing.JDialog implements ICountryDialog {

    private JComboBox comboBox = null;
  //  private ICountryDialogProvider provider = new CountryDialogProvider();
    private ImageTool imageTool = new ImageTool();
    private final long LEVEL = 1;

    /** Creates new form CountryInfomation */
    public CountryDialog() {        
        initComponents();
        this.setModal(true);
        this.setLocationRelativeTo(null);
        resetData();
        loadTable();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        lbCountryName = new javax.swing.JLabel();
        lbCountryCode = new javax.swing.JLabel();
        lbNationality = new javax.swing.JLabel();
        lbLanguage = new javax.swing.JLabel();
        lbDescription = new javax.swing.JLabel();
        txtCountryName = new javax.swing.JTextField();
        txtCountryCode = new javax.swing.JTextField();
        txtNationality = new javax.swing.JTextField();
        txtLanguage = new javax.swing.JTextField();
        jPanel1 = new javax.swing.JPanel();
        lbFlag = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        btnReset = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableCountry = new javax.swing.JTable();
        lbMessenger = new javax.swing.JLabel();
        btnRefresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(org.openide.util.NbBundle.getMessage(CountryDialog.class, "CountryDialog.title")); // NOI18N
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        lbCountryName.setText(org.openide.util.NbBundle.getMessage(CountryDialog.class, "CountryDialog.lbCountryName.text")); // NOI18N

        lbCountryCode.setText(org.openide.util.NbBundle.getMessage(CountryDialog.class, "CountryDialog.lbCountryCode.text")); // NOI18N

        lbNationality.setText(org.openide.util.NbBundle.getMessage(CountryDialog.class, "CountryDialog.lbNationality.text")); // NOI18N

        lbLanguage.setText(org.openide.util.NbBundle.getMessage(CountryDialog.class, "CountryDialog.lbLanguage.text")); // NOI18N

        lbDescription.setText(org.openide.util.NbBundle.getMessage(CountryDialog.class, "CountryDialog.lbDescription.text")); // NOI18N

        txtCountryName.setText(org.openide.util.NbBundle.getMessage(CountryDialog.class, "CountryDialog.txtCountryName.text")); // NOI18N
        txtCountryName.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtCountryNameCaretUpdate(evt);
            }
        });

        txtCountryCode.setText(org.openide.util.NbBundle.getMessage(CountryDialog.class, "CountryDialog.txtCountryCode.text")); // NOI18N

        txtNationality.setText(org.openide.util.NbBundle.getMessage(CountryDialog.class, "CountryDialog.txtNationality.text")); // NOI18N

        txtLanguage.setText(org.openide.util.NbBundle.getMessage(CountryDialog.class, "CountryDialog.txtLanguage.text")); // NOI18N

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, org.openide.util.NbBundle.getMessage(CountryDialog.class, "CountryDialog.jPanel1.border.title"), javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, null, new java.awt.Color(0, 0, 0))); // NOI18N

        lbFlag.setText(org.openide.util.NbBundle.getMessage(CountryDialog.class, "CountryDialog.lbFlag.text")); // NOI18N
        lbFlag.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbFlagMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbFlag, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lbFlag, javax.swing.GroupLayout.DEFAULT_SIZE, 186, Short.MAX_VALUE)
        );

        txtDescription.setColumns(20);
        jScrollPane1.setViewportView(txtDescription);

        btnReset.setText(org.openide.util.NbBundle.getMessage(CountryDialog.class, "CountryDialog.btnReset.text")); // NOI18N
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        btnAdd.setText(org.openide.util.NbBundle.getMessage(CountryDialog.class, "CountryDialog.btnAdd.text")); // NOI18N
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btnEdit.setText(org.openide.util.NbBundle.getMessage(CountryDialog.class, "CountryDialog.btnEdit.text")); // NOI18N
        btnEdit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditActionPerformed(evt);
            }
        });

        btnRemove.setText(org.openide.util.NbBundle.getMessage(CountryDialog.class, "CountryDialog.btnRemove.text")); // NOI18N
        btnRemove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoveActionPerformed(evt);
            }
        });

        tableCountry.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tableCountry.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tableCountryMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tableCountry);

        lbMessenger.setForeground(java.awt.Color.red);
        lbMessenger.setText(org.openide.util.NbBundle.getMessage(CountryDialog.class, "CountryDialog.lbMessenger.text")); // NOI18N

        btnRefresh.setText(org.openide.util.NbBundle.getMessage(CountryDialog.class, "CountryDialog.btnRefresh.text")); // NOI18N
        btnRefresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRefreshActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbCountryName)
                    .addComponent(lbCountryCode, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbNationality, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbDescription, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(btnReset)
                        .addGap(6, 6, 6)
                        .addComponent(btnAdd)
                        .addGap(6, 6, 6)
                        .addComponent(btnRefresh)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEdit)
                        .addGap(6, 6, 6)
                        .addComponent(btnRemove)
                        .addContainerGap())
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                            .addComponent(txtCountryName, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                            .addComponent(txtCountryCode, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                            .addComponent(txtNationality, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                            .addComponent(txtLanguage, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbMessenger, javax.swing.GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 646, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(lbCountryName)
                        .addGap(17, 17, 17)
                        .addComponent(lbCountryCode)
                        .addGap(17, 17, 17)
                        .addComponent(lbNationality)
                        .addGap(17, 17, 17)
                        .addComponent(lbLanguage)
                        .addGap(14, 14, 14)
                        .addComponent(lbDescription))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtCountryName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(txtCountryCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(txtNationality, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(txtLanguage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnReset)
                    .addComponent(btnAdd)
                    .addComponent(btnEdit)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(btnRemove)
                        .addComponent(btnRefresh)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbMessenger)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 232, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (comboBox != null) {
          //  List<Country>lc=provider.getListCountries();
        //    lc.add(0,null);                    
         //   comboBox.setModel(new DefaultComboBoxModel(lc.toArray()));
        }
    }//GEN-LAST:event_formWindowClosing

    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
        resetData();
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        addData(0);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnEditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditActionPerformed
        editData();
    }//GEN-LAST:event_btnEditActionPerformed

    private void btnRemoveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoveActionPerformed
        removeData();
    }//GEN-LAST:event_btnRemoveActionPerformed

    private void tableCountryMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tableCountryMouseClicked
        if (evt.getClickCount() >= 2) {
           // provider.setDataView(provider.getListCountries().get(tableCountry.getSelectedRow()));
            refreshData();
        }
    }//GEN-LAST:event_tableCountryMouseClicked

    private void txtCountryNameCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtCountryNameCaretUpdate
        if (txtCountryName.getText().isEmpty()) {
            lbCountryName.setForeground(Color.red);
        } else {
            lbCountryName.setForeground(Color.black);
        }
    }//GEN-LAST:event_txtCountryNameCaretUpdate

    private void lbFlagMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_lbFlagMouseClicked
        if (evt.getClickCount() < 2) {
            return;
        }
        ImageIcon flag = imageTool.getImage();
        if (flag != null) {
            flag = imageTool.resize(flag, new Dimension(300, 200));
            lbFlag.setIcon(flag);
        }
    }//GEN-LAST:event_lbFlagMouseClicked

    private void btnRefreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRefreshActionPerformed
    //    provider.refreshData();
        refreshData();
    }//GEN-LAST:event_btnRefreshActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnReset;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbCountryCode;
    private javax.swing.JLabel lbCountryName;
    private javax.swing.JLabel lbDescription;
    private javax.swing.JLabel lbFlag;
    private javax.swing.JLabel lbLanguage;
    private javax.swing.JLabel lbMessenger;
    private javax.swing.JLabel lbNationality;
    private javax.swing.JTable tableCountry;
    private javax.swing.JTextField txtCountryCode;
    private javax.swing.JTextField txtCountryName;
    private javax.swing.JTextArea txtDescription;
    private javax.swing.JTextField txtLanguage;
    private javax.swing.JTextField txtNationality;
    // End of variables declaration//GEN-END:variables

    @Override
    public void resetData() {
        txtCountryCode.setText("");
        txtCountryName.setText("");
        txtDescription.setText("");
        txtLanguage.setText("");
        txtNationality.setText("");
        lbFlag.setIcon(null);
        btnAdd.setEnabled(true);
        btnRefresh.setEnabled(false);
        btnEdit.setEnabled(false);
        btnRemove.setEnabled(false);
        lbMessenger.setVisible(false);
     //   provider.setDataView(new Country());
    }

    @Override
    public long addData(long idParent) {
//        getData();
//        if (provider.addData(idParent) <0) {
//            lbMessenger.setVisible(true);
//            lbMessenger.setText("Hãy xem lại các phần bị bôi đỏ");
//            return ID_FAILD;
//        } else {
//            lbMessenger.setVisible(false);
//            resetData();
//            loadTable();
//            return provider.getDataViewCurrent().getId();
//        }
        return idParent;
    }

    @Override
    public long editData() {
       /// getData();
       // if (provider.editData() <0) {
            lbMessenger.setVisible(true);
            lbMessenger.setText("Hãy xem lại các phần bị bôi đỏ");
            return ID_FAILD;
      //  } else {
           // lbMessenger.setVisible(false);
           // resetData();
        //    loadTable();
//            return provider.getDataViewCurrent().getId();
       // }
    }

    @Override
    public long removeData() {
       // long id = provider.getDataViewCurrent().getId();
      //  if (provider.removeData() <0) {
            lbMessenger.setText("Hãy chắc chắn là bạn đã chọn 1 quốc gia để xóa");
            lbMessenger.setVisible(true);
            return ID_FAILD;
      //  } else {
          //  lbMessenger.setVisible(false);
          //  resetData();
          //  loadTable();
           // return id;
       // }
       
    }

    @Override
    public void refreshData() {
//        txtCountryCode.setText(provider.getDataViewCurrent().getCountryCode());
//        txtCountryName.setText(provider.getDataViewCurrent().getCountryName());
//        txtDescription.setText(provider.getDataViewCurrent().getDescription());
//        txtLanguage.setText(provider.getDataViewCurrent().getLanguage());
//        txtNationality.setText(provider.getDataViewCurrent().getNationality());
//        if (provider.getDataViewCurrent().getNationalityFlag() != null) {
//            lbFlag.setIcon(new ImageIcon(provider.getDataViewCurrent().getNationalityFlag()));
//        } else {
//            lbFlag.setIcon(null);
//        }
        canEditData();
    }

    @Override
    public void canEditData() {
        btnAdd.setEnabled(false);
        btnRefresh.setEnabled(true);
        btnEdit.setEnabled(true);
        btnRemove.setEnabled(true);
    }

    private void getData() {
//        provider.getDataViewCurrent().setCountryName(txtCountryName.getText());
//        provider.getDataViewCurrent().setCountryCode(txtCountryCode.getText());
//        provider.getDataViewCurrent().setNationality(txtNationality.getText());
//        provider.getDataViewCurrent().setLanguage(txtLanguage.getText());
//        provider.getDataViewCurrent().setDescription(txtDescription.getText());
        try {
            ImageIcon image = (ImageIcon) lbFlag.getIcon();
           // provider.getDataViewCurrent().setNationalityFlag(imageTool.convertImage2ByteArray(image.getImage()));
        } catch (Exception e) {
           // provider.getDataViewCurrent().setNationalityFlag(null);
        }
    }

    private void loadTable() {
       // provider.loadAllCountries();
       // tableCountry.setModel(new CountryTableModel(provider.getListCountries()));
    }

    @Override
    public int getFunction() {
        return ID_FAILD;
    }

    @Override
    public void setComboBox(JComboBox comboBox) {
        this.comboBox = comboBox;
    }

    @Override
    public String getDescriptionPanel() {
        return "Giao diện chỉnh sủa quốc gia";
    }

    @Override
    public boolean checkData() {
        return true;
    }

    @Override
    public void loadDefault() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
