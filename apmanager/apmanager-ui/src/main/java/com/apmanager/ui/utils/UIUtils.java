/*
 * UIUtils
 */
package com.apmanager.ui.utils;

import com.apmanager.domain.entity.Entity;
import com.apmanager.ui.components.ConfirmDialog;
import com.apmanager.ui.menu.Application;
import java.util.List;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author luis
 */
public class UIUtils {
    private static final Logger log = Logger.getLogger(UIUtils.class.getSimpleName());
    
    @Deprecated
    public static void remove(List<? extends Entity> entities) {
        if(entities.isEmpty()){
            JOptionPane.showMessageDialog(Application.getInstance(), "Não nenhum item selecionado!");
            return;
        }
        
        ConfirmDialog dialog = new ConfirmDialog(Application.getInstance());
        dialog.setText("Você tem certeza que deseja excluir estes items?<br>"
                + entities.size() + " serão afetados");
        dialog.setVisible(true);
        
        if(dialog.getResponse()){
            log.info("Deleting itens");
        }
        
    }
}
