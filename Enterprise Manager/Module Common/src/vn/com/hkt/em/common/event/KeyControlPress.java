/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.com.hkt.em.common.event;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *
 * @author BinLe
 */
public class KeyControlPress extends KeyAdapter {

    private boolean keyCTRL = false;

    public boolean isKeyCTRL() {
        return keyCTRL;
    }

    public void setKeyCTRL(boolean keyCTRL) {
        this.keyCTRL = keyCTRL;
    }

    public KeyControlPress() {
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
            keyCTRL = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_CONTROL) {
            keyCTRL = true;
        }
    }
}
