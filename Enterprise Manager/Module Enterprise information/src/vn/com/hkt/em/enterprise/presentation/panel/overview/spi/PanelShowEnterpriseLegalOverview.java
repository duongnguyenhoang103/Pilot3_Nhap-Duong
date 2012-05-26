/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * PanelShowEnterpriseLegalOverview.java
 *
 * Created on May 12, 2012, 9:32:44 AM
 */
package vn.com.hkt.em.enterprise.presentation.panel.overview.spi;

import javax.swing.JPanel;
import org.openide.util.lookup.ServiceProvider;
import sun.security.pkcs11.P11TlsKeyMaterialGenerator;
import vn.com.hkt.em.basic.data.entities.Enterprise;
import vn.com.hkt.em.basic.presentation.panel.show.api.IPanelShowEnterpriseBaisc;
import vn.com.hkt.em.common.gui.controlshow.api.IControlShowInformation;
import vn.com.hkt.em.enterprise.presentation.panel.api.IPanelShowEnterpriseLegal;
import vn.com.hkt.em.enterprise.presentation.panel.overview.api.IPanelShowEnterpriseLegalOverview;
import vn.com.hkt.em.enterprise.presentation.panel.spi.PanelShowEnterpriseLegalDetails;

/**
 *
 * @author duong
 */
@ServiceProvider(service = IPanelShowEnterpriseBaisc.class)
public class PanelShowEnterpriseLegalOverview extends javax.swing.JPanel implements IPanelShowEnterpriseBaisc, IPanelShowEnterpriseLegalOverview {

    private IPanelShowEnterpriseLegal panelShowEnterpriseLegal;// hien thi len chinh no
     // private IControlShowEnterpriseLegal controlShowEnterpriseLegal; // hien thi khi co gd cha
    private final long LEVEL_ENTERPRISE_BAISC = 2;
    private PanelShowEnterpriseLegalDetails panelShowEnterpriseLegalDetails =new PanelShowEnterpriseLegalDetails();

    /** Creates new form PanelShowEnterpriseLegalOverview */
    public PanelShowEnterpriseLegalOverview() {
        initComponents();
        loadExtention();
       
    }
 private void loadExtention() {
        panelShowEnterpriseLegal = new PanelShowEnterpriseLegalDetails();
        scrollPane.setViewportView((JPanel)panelShowEnterpriseLegal); // hien thi len chinh no
//        controlShowEnterpriseLegal.loadPanelShow();
//        controlShowEnterpriseLegal.setParent(panelShowEnterpriseLegalDetails);
//        if (controlShowEnterpriseLegal.getListPanelShow().size() <= 1) {
//            btnInformationOpen.setEnabled(false);
//        } else {
//            btnInformationOpen.setEnabled(true);
//        }
//        reloadPanelShowInformation();
        btnInformationOpen.setEnabled(true);
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
        scrollPane = new javax.swing.JScrollPane();
        btnInformationOpen = new javax.swing.JButton();

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED), org.openide.util.NbBundle.getMessage(PanelShowEnterpriseLegalOverview.class, "PanelShowEnterpriseLegalOverview.jPanel2.border.title"), javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 12))); // NOI18N

        scrollPane.setBorder(null);

        btnInformationOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vn/com/hkt/em/enterprise/presentation/icon/open1.png"))); // NOI18N
        btnInformationOpen.setText(org.openide.util.NbBundle.getMessage(PanelShowEnterpriseLegalOverview.class, "PanelShowEnterpriseLegalOverview.btnInformationOpen.text")); // NOI18N
        btnInformationOpen.setToolTipText(org.openide.util.NbBundle.getMessage(PanelShowEnterpriseLegalOverview.class, "PanelShowEnterpriseLegalOverview.btnInformationOpen.toolTipText")); // NOI18N
        btnInformationOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInformationOpenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnInformationOpen, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                    .addComponent(btnInformationOpen))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.getAccessibleContext().setAccessibleName(org.openide.util.NbBundle.getMessage(PanelShowEnterpriseLegalOverview.class, "PanelShowEnterpriseLegalOverview.jPanel2.AccessibleContext.accessibleName")); // NOI18N
    }// </editor-fold>//GEN-END:initComponents

    private void btnInformationOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInformationOpenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnInformationOpenActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnInformationOpen;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane scrollPane;
    // End of variables declaration//GEN-END:variables

    @Override
    public long getLevelPanelShowEnterpriseBasic() {
      return LEVEL_ENTERPRISE_BAISC;
    }

    // thuc hien khi co form con load laj cha chinh no
    @Override
    public void setEnterprise(Enterprise enterprise) {
//          panelShowEnterpriseLegalDetails.setEnterprise(enterprise);
//        for (int i = 1; i < controlShowEnterpriseLegal.getListPanelShow().size(); i++) {
//            ((IPanelShowEnterpriseLegal) controlShowEnterpriseLegal.getListPanelShow().get(i)).setEnterpriseLegal(panelShowEnterpriseLegalDetails.getEnterpriseLegal());
//        }
    }

    @Override
    public String getDescriptionPanel() {
       return "thông tin pháp lý";
    // return panelShowEnterpriseLegalDetails.getDescriptionPanel();
    }

    @Override
    public void resetData() {
    
    }

    @Override
    public long addData(long idParent) {
      return idParent;
    }

    @Override
    public void refreshData() {
       
    }

    @Override
    public void canEditData() {
      
    }

    @Override
    public long editData() {
     return panelShowEnterpriseLegalDetails.editData();
       // return 0;
    }

    @Override
    public long removeData() {
     return 0;
    }

    @Override
    public int getFunction() {
       return panelShowEnterpriseLegalDetails.getFunction();
    }

    @Override
    public boolean checkData() {
        return true;
    }

    @Override
    public void loadDefault() {
//        for (int i = 0; i < controlShowEnterpriseLegal.getListPanelShow().size(); i++) {
//            ((IPanelShowInformation) controlShowEnterpriseLegal.getListPanelShow().get(i)).loadDefault();
//        }
    }

    @Override
    public void reloadPanelShowInformation() {
//         panelShowEnterpriseLegalDetails =
//                (PanelShowEnterpriseLegalDetails) controlShowEnterpriseLegal.getPanelControlShowInformation().getListPanelShow().get(0);
//        scrollPane.setViewportView(panelShowEnterpriseLegalDetails);
    }

    @Override
    public void setControlShowInformationOverview(IControlShowInformation controlShowInformation) {
//       if (controlShowInformation instanceof IControlShowEnterpriseLegal) {
//            controlShowEnterpriseLegal = (IControlShowEnterpriseLegal) controlShowInformation;
//        }
    }
}
