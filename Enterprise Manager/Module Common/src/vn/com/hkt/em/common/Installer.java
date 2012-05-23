/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.common;

import java.util.Set;
import org.openide.modules.ModuleInstall;
import org.openide.windows.TopComponent;
import org.openide.windows.WindowManager;

/**
 * Quản lý module Common
 * @author BinLe
 */
public class Installer extends ModuleInstall {

    @Override
    public void restored() {
        // TODO        
    }

    /**
     * khi đóng module thì đóng tất cả các topcomponent hiển thị
     */
    @Override
    public boolean closing() {
        Set<TopComponent> tcs = WindowManager.getDefault().getRegistry().getOpened();
        for (TopComponent top : tcs) {
            top.close();
        }
        return super.closing();
    }
}
