/*
 * AbstractAdminPanel
*/

package com.apmanager.ui.panels;

import com.apmanager.domain.entity.Entity;
import com.apmanager.service.BasicService;
import com.apmanager.ui.components.ConfirmDialog;
import com.apmanager.ui.menu.Application;
import com.towel.swing.table.ObjectTableModel;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author luis
 */
public abstract class AbstractAdminPanel<T extends Entity> extends JPanel{
    private static final Logger log = LoggerFactory.getLogger(AbstractAdminPanel.class);
    protected ObjectTableModel<T> model; 
    protected List<T> results;
    protected BasicService<T> service;
    
    public void delete(List<T> entities) throws Exception {
        if(entities == null || entities.isEmpty()){
            JOptionPane.showMessageDialog(Application.getInstance(), "Não nenhum item selecionado!");
            return;
        }
        
        ConfirmDialog dialog = new ConfirmDialog(Application.getInstance());
        dialog.setText("Você tem certeza que deseja excluir estes items?<br>"
                + entities.size() + " serão afetados");
        dialog.setVisible(true);
        
        if(dialog.getResponse()){
            this.service.delete(entities);
            log.info("Deleting itens");
        }
        search();
        
    }

    protected abstract void search();
}
