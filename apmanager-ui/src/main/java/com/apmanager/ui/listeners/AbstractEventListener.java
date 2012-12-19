/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apmanager.ui.listeners;

import com.apmanager.service.exceptions.ValidationError;
import com.apmanager.service.exceptions.ValidationException;
import java.awt.Component;
import javax.swing.JOptionPane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author luis
 */
public abstract class AbstractEventListener {

    protected Component parent;

    private static final Logger log =
            LoggerFactory.getLogger(AbstractEventListener.class);

    public AbstractEventListener(Component parent) {
        this.parent = parent;
    }

    public void onError(java.awt.AWTEvent evt, Throwable e) {
        if (e instanceof ValidationException) {
            log.error(e.getMessage());
            StringBuilder builder = new StringBuilder();
            builder.append("Encontramos alguns problemas ao executar a sua ação:");
            ValidationException v = (ValidationException) e;
            for (ValidationError err : v.getErrors()) {
                builder.append("\n    -").append(err.getError());
            }
            builder.append("\nVerifique, e tente novamente.");
            JOptionPane.showMessageDialog(parent,builder.toString(), "Atenção", JOptionPane.WARNING_MESSAGE);
            return;
        }
        log.error(e.getMessage(), e);
        JOptionPane.showMessageDialog(parent,
                "Ops, encontramos um erro, por favor, contate o suporte!");

    }
}
