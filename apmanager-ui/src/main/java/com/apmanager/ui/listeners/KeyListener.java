/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apmanager.ui.listeners;

import java.awt.Component;
import java.awt.event.KeyEvent;

/**
 *
 * @author luis
 */
public class KeyListener extends AbstractEventListener
        implements java.awt.event.KeyListener{

    public KeyListener(Component parent) {
        super(parent);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        try{
            onKeyType(e);
        } catch (Throwable ex){
            onError(e, ex);
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        try{
            onKeyPress(e);
        } catch (Throwable ex){
            onError(e, ex);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        try{
            onKeyRelease(e);
        } catch (Throwable ex){
            onError(e, ex);
        }
    }
    
    public void onKeyType(KeyEvent e){
    }

    public void onKeyRelease(KeyEvent e) {
        
    }

    public void onKeyPress(KeyEvent e) {
        
    }
    
}
