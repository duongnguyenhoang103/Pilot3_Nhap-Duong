/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * BasicToolbar.java  log
 *
 * Created on Apr 4, 2012, 3:06:14 PM
 */
package vn.com.hkt.em.basic.toolbar;

import vn.com.hkt.em.basic.presentation.manager.ManagerPresentationEnterprise;
import vn.com.hkt.em.basic.presentation.manager.ManagerPresentationListEnterprise;
import vn.com.hkt.em.basic.presentation.manager.ManagerPresentationPerson;
import vn.com.hkt.em.common.gui.topcomponent.spi.EnterpriseManagerTopComponent;
import vn.com.hkt.em.toolbar.presentation.api.ITabToolbar;

/**
 *
 * @author BinLe
 */
public class BasicToolbar extends javax.swing.JPanel implements ITabToolbar {

    private EnterpriseManagerTopComponent topEnterprise;
    private EnterpriseManagerTopComponent topListEnterprise;
    private EnterpriseManagerTopComponent topPerson;
    private final int INDEX = 0;

    /** Creates new form BasicToolbar */
    public BasicToolbar() {
        initComponents();
        loadDefaultTopComponent();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnPersonInformation = new javax.swing.JButton();
        btnInformationEnterprise = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        btnListEnterprise = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(770, 120));

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, org.openide.util.NbBundle.getMessage(BasicToolbar.class, "BasicToolbar.jPanel1.border.title"), javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.BOTTOM, null, java.awt.Color.black)); // NOI18N

        btnPersonInformation.setText(org.openide.util.NbBundle.getMessage(BasicToolbar.class, "BasicToolbar.btnPersonInformation.text")); // NOI18N
        btnPersonInformation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPersonInformationActionPerformed(evt);
            }
        });

        btnInformationEnterprise.setText(org.openide.util.NbBundle.getMessage(BasicToolbar.class, "BasicToolbar.btnInformationEnterprise.text")); // NOI18N
        btnInformationEnterprise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInformationEnterpriseActionPerformed(evt);
            }
        });

        jButton1.setText(org.openide.util.NbBundle.getMessage(BasicToolbar.class, "BasicToolbar.jButton1.text")); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        btnListEnterprise.setText(org.openide.util.NbBundle.getMessage(BasicToolbar.class, "BasicToolbar.btnListEnterprise.text")); // NOI18N
        btnListEnterprise.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListEnterpriseActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btnInformationEnterprise)
                    .addComponent(btnPersonInformation, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnListEnterprise, javax.swing.GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel1Layout.linkSize(javax.swing.SwingConstants.HORIZONTAL, new java.awt.Component[] {btnInformationEnterprise, btnListEnterprise, btnPersonInformation, jButton1});

        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPersonInformation)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnListEnterprise, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnInformationEnterprise, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(406, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnPersonInformationActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPersonInformationActionPerformed
        ManagerPresentationPerson.getInstance().showDefault();
    }//GEN-LAST:event_btnPersonInformationActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        //TODO
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnListEnterpriseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListEnterpriseActionPerformed
        ManagerPresentationListEnterprise.getInstance().showDefault();
    }//GEN-LAST:event_btnListEnterpriseActionPerformed

    private void btnInformationEnterpriseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInformationEnterpriseActionPerformed
        ManagerPresentationEnterprise.getInstance().showDefault();
    }//GEN-LAST:event_btnInformationEnterpriseActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInformationEnterprise;
    private javax.swing.JButton btnListEnterprise;
    private javax.swing.JButton btnPersonInformation;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables

    @Override
    public String getTabToolbarName() {
        return "Cơ bản";
    }

    @Override
    public int getTabToolbarIndex() {
        return INDEX;
    }

    private void loadDefaultTopComponent() {
        topEnterprise = ManagerPresentationEnterprise.getInstance().getTopComponent();
        topListEnterprise = ManagerPresentationListEnterprise.getInstance().getTopComponent();
        topPerson = ManagerPresentationPerson.getInstance().getTopComponent();

    }
}
