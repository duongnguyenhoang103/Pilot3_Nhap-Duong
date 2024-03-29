/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * BusinessAreaDialog.java
 *
 * Created on May 24, 2012, 2:53:22 PM
 */
package vn.com.hkt.em.enterprise.presentation.dialog.spi;

import java.awt.Color;
import javax.swing.JComboBox;
import vn.com.hkt.em.enterprise.business.provider.dialog.api.IBusinessAreaDialogProvider;
import vn.com.hkt.em.enterprise.business.provider.dialog.spi.BusinessAreaDialogProvider;
import vn.com.hkt.em.enterprise.data.entities.BusinessArea;
import vn.com.hkt.em.enterprise.presentation.dialog.api.IBusinessAreaDialog;

/**
 *
 * @author duong
 */
public class DialogBusinessArea extends javax.swing.JDialog implements IBusinessAreaDialog {

    private JComboBox comboBox;
    IBusinessAreaDialogProvider provider = new BusinessAreaDialogProvider();

    /** Creates new form BusinessAreaDialog */
    public DialogBusinessArea(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    public DialogBusinessArea() {
        initComponents();
        this.setModal(true);
        this.setLocationRelativeTo(null);

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lbBusinessAreaCode = new javax.swing.JLabel();
        txtBusinessAreaName = new javax.swing.JTextField();
        txtBusinessAreaCode = new javax.swing.JTextField();
        lbDescription = new javax.swing.JLabel();
        lbBusinessAreaName = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDescription = new javax.swing.JTextArea();
        btnRefresh = new javax.swing.JButton();
        btnEdit = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        btnAdd = new javax.swing.JButton();
        btnRemove = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        lbMessenger = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lbBusinessAreaCode.setText(org.openide.util.NbBundle.getMessage(DialogBusinessArea.class, "DialogBusinessArea.lbBusinessAreaCode.text")); // NOI18N

        txtBusinessAreaName.setText(org.openide.util.NbBundle.getMessage(DialogBusinessArea.class, "DialogBusinessArea.txtBusinessAreaName.text")); // NOI18N
        txtBusinessAreaName.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtBusinessAreaNameCaretUpdate(evt);
            }
        });

        txtBusinessAreaCode.setText(org.openide.util.NbBundle.getMessage(DialogBusinessArea.class, "DialogBusinessArea.txtBusinessAreaCode.text")); // NOI18N
        txtBusinessAreaCode.addCaretListener(new javax.swing.event.CaretListener() {
            public void caretUpdate(javax.swing.event.CaretEvent evt) {
                txtBusinessAreaCodeCaretUpdate(evt);
            }
        });

        lbDescription.setText(org.openide.util.NbBundle.getMessage(DialogBusinessArea.class, "DialogBusinessArea.lbDescription.text")); // NOI18N

        lbBusinessAreaName.setText(org.openide.util.NbBundle.getMessage(DialogBusinessArea.class, "DialogBusinessArea.lbBusinessAreaName.text")); // NOI18N

        txtDescription.setColumns(20);
        txtDescription.setRows(3);
        jScrollPane1.setViewportView(txtDescription);

        btnRefresh.setText(org.openide.util.NbBundle.getMessage(DialogBusinessArea.class, "DialogBusinessArea.btnRefresh.text")); // NOI18N

        btnEdit.setText(org.openide.util.NbBundle.getMessage(DialogBusinessArea.class, "DialogBusinessArea.btnEdit.text")); // NOI18N

        btnReset.setText(org.openide.util.NbBundle.getMessage(DialogBusinessArea.class, "DialogBusinessArea.btnReset.text")); // NOI18N

        btnAdd.setText(org.openide.util.NbBundle.getMessage(DialogBusinessArea.class, "DialogBusinessArea.btnAdd.text")); // NOI18N

        btnRemove.setText(org.openide.util.NbBundle.getMessage(DialogBusinessArea.class, "DialogBusinessArea.btnRemove.text")); // NOI18N

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(jTable1);

        lbMessenger.setForeground(new java.awt.Color(255, 0, 0));
        lbMessenger.setText(org.openide.util.NbBundle.getMessage(DialogBusinessArea.class, "DialogBusinessArea.lbMessenger.text")); // NOI18N

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 473, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lbDescription)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnReset)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnAdd)
                                .addGap(6, 6, 6)
                                .addComponent(btnRefresh)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEdit)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnRemove))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 313, Short.MAX_VALUE)))
                    .addComponent(lbMessenger, javax.swing.GroupLayout.DEFAULT_SIZE, 453, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbBusinessAreaName)
                            .addComponent(lbBusinessAreaCode))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtBusinessAreaCode, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                            .addComponent(txtBusinessAreaName, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 470, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbBusinessAreaName)
                    .addComponent(txtBusinessAreaName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbBusinessAreaCode)
                    .addComponent(txtBusinessAreaCode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbDescription)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnReset)
                    .addComponent(btnAdd)
                    .addComponent(btnEdit)
                    .addComponent(btnRemove)
                    .addComponent(btnRefresh))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lbMessenger)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

private void txtBusinessAreaNameCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtBusinessAreaNameCaretUpdate
    if (txtBusinessAreaName.getText().isEmpty()) {
        lbBusinessAreaName.setForeground(Color.red);
    } else {
        lbBusinessAreaName.setForeground(Color.black);
    }
}//GEN-LAST:event_txtBusinessAreaNameCaretUpdate

private void txtBusinessAreaCodeCaretUpdate(javax.swing.event.CaretEvent evt) {//GEN-FIRST:event_txtBusinessAreaCodeCaretUpdate
    if (txtBusinessAreaCode.getText().isEmpty()) {
        lbBusinessAreaCode.setForeground(Color.red);
    } else {
        lbBusinessAreaCode.setForeground(Color.black);
    }
}//GEN-LAST:event_txtBusinessAreaCodeCaretUpdate

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DialogBusinessArea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DialogBusinessArea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DialogBusinessArea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DialogBusinessArea.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {

            public void run() {
                DialogBusinessArea dialog = new DialogBusinessArea(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {

                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnEdit;
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnRemove;
    private javax.swing.JButton btnReset;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel lbBusinessAreaCode;
    private javax.swing.JLabel lbBusinessAreaName;
    private javax.swing.JLabel lbDescription;
    private javax.swing.JLabel lbMessenger;
    private javax.swing.JTextField txtBusinessAreaCode;
    private javax.swing.JTextField txtBusinessAreaName;
    private javax.swing.JTextArea txtDescription;
    // End of variables declaration//GEN-END:variables

    @Override
    public void setComboBox(JComboBox comboBox) {
    }

    @Override
    public String getDescriptionPanel() {
        return "Giao diện hiển thị các lĩnh vực kinh doanh";
    }

    @Override
    public void resetData() {
        txtBusinessAreaCode.setText("");
        txtBusinessAreaName.setText("");
        txtDescription.setText("");
        provider.setDataView(new BusinessArea()); // tao moi 1 khu vuc kinh doanh
        btnAdd.setEnabled(true);
        btnEdit.setEnabled(false);
        btnRefresh.setEnabled(false);
        btnRemove.setEnabled(false);
        lbMessenger.setVisible(false);
    }

    @Override
    public void refreshData() {
    }

    @Override
    public long addData(long idParent) {
        return idParent;
    }

    @Override
    public void canEditData() {
    }

    @Override
    public long editData() {
        return 0;
    }

    @Override
    public long removeData() {
        return 0;
    }

    @Override
    public int getFunction() {
        return 1; // FUNCTION_CREATE = 1: tạo mới dữ liệu
        //  FUNCTION_EDIT = 2: xem sửa xóa dữ liệu 

    }

    @Override
    public boolean checkData() {
        if (lbBusinessAreaCode.getForeground().equals(Color.red)
                || lbBusinessAreaName.getForeground().equals(Color.red)) {
            lbMessenger.setVisible(true);
            lbMessenger.setText("Bạn hãy xem lại những phần đỏ nhé, chúng đang bị sai");
            return false;
        }
        lbMessenger.setVisible(false);
        return true;
    }

    @Override
    public void loadDefault() {
    }
}
