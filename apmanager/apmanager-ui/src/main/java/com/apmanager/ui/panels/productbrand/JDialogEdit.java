package com.apmanager.ui.panels.productbrand;

import com.apmanager.domain.entity.Entity;
import com.apmanager.service.BasicService;
import com.apmanager.ui.components.abstractcomps.JDialogEscape;
import com.apmanager.ui.menu.Application;
import java.awt.Frame;
import javax.swing.JDialog;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class JDialogEdit<T extends Entity, S extends BasicService> extends JDialogEscape {

    protected S service;
    private static final Logger log = LoggerFactory.getLogger(JDialogProductBrandEdit.class);
    protected T instance;

    public JDialogEdit(Frame parent, boolean modal) {
        super(parent, modal);
    }

    public JDialogEdit(JDialog parent, boolean modal) {
        super(parent, modal);
    }

    protected abstract void restoreFields(T instance);

    protected abstract T buildObject();

    protected abstract void clear();

    protected void save() throws Exception {
        instance = buildObject();
        if (instance.getId() == null) {
            log.info("Creating new instance {}", instance.toString());
            getService().save(instance);
        } else {
            buildObject();
            log.info("Updating {}", instance.toString());
            getService().update(instance);
        }
        this.setVisible(false);
        Application.showMessage("Registro salvo com sucesso!");
    }

    public S getService() {
        return service;
    }

    public void setService(S service) {
        this.service = service;
    }

    public T getInstance() {
        return instance;
    }

    public void setInstance(T instance) {
        this.instance = instance;
        clear();
        if (instance != null) {
            restoreFields(instance);
        }
    }
    
}
