/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.toolbar.tool;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import vn.com.hkt.em.toolbar.presentation.EnterpiseManagementToolbar;
import vn.com.hkt.em.toolbar.presentation.api.ITabToolbar;

/**
 * Đối tượng quản lý toolbar của chương trình
 * @author BinLe
 */
public class ToolbarlManager {

    private EnterpiseManagementToolbar toolbar = EnterpiseManagementToolbar.getCorporateManagementToolbar();

    /**
     * Thêm tabToolbar vào trong toolbar
     * @param tabToolbar ITabToolbar
     * tabtoolbar cần được thêm
     */
    public void addToolbar(ITabToolbar tabToolbar) {
        if (!(tabToolbar instanceof JPanel)) {
            return;
        }
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView((JPanel) tabToolbar);
        toolbar.getTabPane().add(tabToolbar.getTabToolbarName(), scrollPane);
    }

    /**
     * Thêm tabToolbar vào trong toolbar
     * @param tabToolbar ITabToolbar
     * tabtoolbar cần được thêm
     * @param index : int
     * vị trí của tabtoolbar
     */
    public void addToolbar(ITabToolbar tabToolbar, int index) {
        if (!(tabToolbar instanceof JPanel)) {
            return;
        }
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView((JPanel) tabToolbar);
        toolbar.getTabPane().add(scrollPane, index);
        toolbar.getTabPane().setTitleAt(index, tabToolbar.getTabToolbarName());
    }
}
