/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.basic;

import org.openide.modules.ModuleInstall;
import vn.com.hkt.em.basic.toolbar.BasicToolbar;
import vn.com.hkt.em.toolbar.tool.ToolbarlManager;

public class Installer extends ModuleInstall {

    @Override
    public void restored() {
        // TODO
        ToolbarlManager toolbarlManager= new ToolbarlManager();
        toolbarlManager.addToolbar(new BasicToolbar());
    }
}
