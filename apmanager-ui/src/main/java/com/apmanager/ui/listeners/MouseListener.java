/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apmanager.ui.listeners;

import java.awt.Component;
import java.awt.event.MouseEvent;

/**
 *
 * @author luis
 */
public class MouseListener extends AbstractEventListener implements java.awt.event.MouseListener{

    public MouseListener(Component parent) {
        super(parent);
    }

    @Override
    public final void mouseClicked(MouseEvent e) {
        try{
            onMouseClick(e);
        } catch (Throwable ex){
            onError(e, ex);
        }
    }
    
    @Override
    public final void mousePressed(MouseEvent e) {
        try{
            onMousePress(e);
        } catch (Throwable ex){
            onError(e, ex);
        }
    }

    @Override
    public final void mouseReleased(MouseEvent e) {
        try{
            onMouseRelease(e);
        } catch (Throwable ex){
            onError(e, ex);
        }
    }

    @Override
    public final void mouseEntered(MouseEvent e) {
        try{
            onMouseEnter(e);
        } catch (Throwable ex){
            onError(e, ex);
        }
    }

    @Override
    public final void mouseExited(MouseEvent e) {
        try{
            onMouseExit(e);
        } catch (Throwable ex){
            onError(e, ex);
        }
    }
    
    public void onMouseClick(MouseEvent e){
        
    }
    public void onMousePress(MouseEvent e){
        
    }
    
    public void onMouseEnter(MouseEvent e){
        
    }
    
    public void onMouseRelease(MouseEvent e){
        
    }
    
    public void onMouseExit(MouseEvent e){
        
    }
}
