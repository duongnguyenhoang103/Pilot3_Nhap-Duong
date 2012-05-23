/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.enterprise.presentation.controlshow.api;

import vn.com.hkt.em.common.gui.controlshow.api.IControlShowInformation;
import vn.com.hkt.em.enterprise.data.entities.EnterpriseLegal;

/**
 *
 * @author duong
 */
public interface IControlShowEnterpriseLegal extends IControlShowInformation {
    
    public void loadEnterpriseLegal(EnterpriseLegal enterpriseLegal);
}
