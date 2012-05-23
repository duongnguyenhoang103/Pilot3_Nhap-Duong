/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrameInformation.java
 *
 * Created on Apr 27, 2012, 8:28:27 AM
 */
package vn.com.hkt.em.common.gui.dialog.spi;

import java.awt.Dialog.ModalExclusionType;
import javax.swing.JPanel;
import vn.com.hkt.em.common.gui.panel.controlshow.spi.PanelControlShowInformation;
import vn.com.hkt.em.common.gui.panel.show.api.IPanelShowInformationOverview;

/**
 *
 * @author BinLe
 */
public class FrameInformation extends javax.swing.JFrame {

    private IPanelShowInformationOverview panelShowInformationOverview;

    /** Creates new form FrameInformation */
    public FrameInformation(IPanelShowInformationOverview panelShowInformationOverview) {
        initComponents();
        setModalExclusionType(ModalExclusionType.NO_EXCLUDE);
        setLocationRelativeTo(null);
         this.panelShowInformationOverview = panelShowInformationOverview;
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        panelShowInformationOverview.reloadPanelShowInformation();
    }//GEN-LAST:event_formWindowClosing
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    /**
     * Truyền vào giao diện điều khiển hiển thị thông tin và hiển thị giao diện đó
     * @param panelControlShowInformation :PanelControlShowInformation/
     * giao diện điều khiển hiển thị thông tin
     */
    public void setPanelControlshowInformation(PanelControlShowInformation panelControlShowInformation) {
        if (panelControlShowInformation instanceof JPanel) {
            JPanel panel = (JPanel) panelControlShowInformation;
            this.pack();
            jScrollPane1.setViewportView(panel);
            setVisible(true);
        }
    }
}
