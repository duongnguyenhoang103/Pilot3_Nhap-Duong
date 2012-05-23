/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.toolbar;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLayeredPane;
import javax.swing.SwingUtilities;
import org.openide.modules.ModuleInstall;
import org.openide.windows.WindowManager;
import vn.com.hkt.em.toolbar.layout.MyRootPaneLayout;
import vn.com.hkt.em.toolbar.presentation.EnterpiseManagementToolbar;

/**
 * Quản lý module Toolbar controller
 * @author Binle
 */
public class Installer extends ModuleInstall {

    /**
     * Khi module tồn tại thì thực hiện việc tạo toolbar trên giao diện sử dụng
     */
    @Override
    public void restored() {
        // TODO
        createToolbar();
    }
    /**
     * Tạo toolbar trên giao diện
     */
    private void createToolbar() {
        System.setProperty("netbeans.winsys.no_toolbars", "true");
        SwingUtilities.invokeLater(new Runnable() {

            @Override
            public void run() {
                JFrame frame = (JFrame) WindowManager.getDefault().getMainWindow();
                JComponent toolbar = EnterpiseManagementToolbar.getCorporateManagementToolbar();
                frame.getRootPane().setLayout(new MyRootPaneLayout(toolbar));
                toolbar.putClientProperty(JLayeredPane.LAYER_PROPERTY, 0);
                frame.getRootPane().getLayeredPane().add(toolbar, 0);
            }
        });

    }
    
}
