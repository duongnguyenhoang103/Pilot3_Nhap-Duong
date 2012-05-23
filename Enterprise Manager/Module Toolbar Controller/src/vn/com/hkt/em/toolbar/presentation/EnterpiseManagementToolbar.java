/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * EnterpiseManagementToolbar.java
 *
 * Created on Apr 4, 2012, 3:08:32 PM
 */
package vn.com.hkt.em.toolbar.presentation;

import javax.swing.JTabbedPane;

/**
 * Toolbar của chương trình quản lý doanh nghiệp
 * @author BinLe
 */
public class EnterpiseManagementToolbar extends javax.swing.JPanel {

    private static EnterpiseManagementToolbar corporateManagementToolbar;

    public static EnterpiseManagementToolbar getCorporateManagementToolbar() {
        if (corporateManagementToolbar == null) {
            corporateManagementToolbar = new EnterpiseManagementToolbar();
        }
        return corporateManagementToolbar;
    }

    /** Creates new form EnterpiseManagementToolbar */
    private EnterpiseManagementToolbar() {
        initComponents();
    }
    /**
     * Trả về thanh toolbar dạng tabControl
     * @return JTabbedPane
     */
    public JTabbedPane getTabPane() {
        return tabPane;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabPane = new javax.swing.JTabbedPane();

        setBackground(new java.awt.Color(204, 255, 204));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabPane, javax.swing.GroupLayout.DEFAULT_SIZE, 725, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(tabPane, javax.swing.GroupLayout.DEFAULT_SIZE, 150, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane tabPane;
    // End of variables declaration//GEN-END:variables
}
