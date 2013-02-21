package com.apmanager.ui.panels;

import com.apmanager.domain.entity.Product;
import com.apmanager.domain.entity.Sale;
import com.apmanager.domain.entity.SaleProduct;
import com.apmanager.service.exceptions.ValidationException;
import com.apmanager.service.impl.SaleService;
import com.apmanager.ui.components.Button;
import com.apmanager.ui.components.ConfirmDialog;
import com.apmanager.ui.components.Table;
import com.apmanager.ui.formaters.Currency;
import com.apmanager.ui.listeners.AWTEventListener;
import com.apmanager.ui.listeners.ActionListener;
import com.apmanager.ui.menu.Application;
import com.apmanager.ui.menu.JDialogSearchProduct;
import com.towel.el.FieldResolver;
import com.towel.swing.table.ObjectTableModel;
import java.awt.AWTEvent;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.util.List;
import javax.swing.JOptionPane;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author ADMIN
 */
public class JPanelSale extends javax.swing.JPanel implements AdminPanel {

    private static final Logger log = LoggerFactory.getLogger(JPanelSale.class);
    private final JDialogSearchProduct dialog = new JDialogSearchProduct(Application.getInstance(), true);
    private final JDialogAlterQuantity dialogQuantity = new JDialogAlterQuantity(Application.getInstance(), true);
    private final JDialogCloseSale dialogCloseSale = new JDialogCloseSale(Application.getInstance(), true);
    private Sale instance;
    private SaleService service = new SaleService();

    /**
     * Creates new form JPanelVenda
     */
    public JPanelSale() {
        initComponents();
        configureJTableProducts();
        configureListener();

        addButtonListeners();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTableResults = new Table();
        jPanel1 = new javax.swing.JPanel();
        jButtonCloseSale = new Button(this, KeyEvent.VK_F8);
        jButtonAlterQuantity = new Button(this, KeyEvent.VK_F7);
        jButtonRemove = new Button(this, KeyEvent.VK_DELETE);
        jButtonBudget = new Button(this, KeyEvent.VK_F6);
        jPanel2 = new javax.swing.JPanel();
        jLabelTotal = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();

        jTableResults.setBackground(new java.awt.Color(245, 245, 245));
        jTableResults.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jTableResults.setForeground(new java.awt.Color(0, 51, 51));
        jTableResults.setGridColor(new java.awt.Color(152, 177, 255));
        jTableResults.setSelectionBackground(new java.awt.Color(225, 220, 84));
        jTableResults.setSelectionForeground(new java.awt.Color(0, 51, 51));
        jTableResults.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jTableResults.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(jTableResults);

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButtonCloseSale.setText("Fechar Venda");

        jButtonAlterQuantity.setText("Alterar Quantidade");

        jButtonRemove.setText("Remover");

        jButtonBudget.setText("Orçamento");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonRemove)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonAlterQuantity)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonBudget)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButtonCloseSale)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonCloseSale)
                    .addComponent(jButtonAlterQuantity)
                    .addComponent(jButtonRemove)
                    .addComponent(jButtonBudget))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabelTotal.setText("00,00");

        jLabel2.setText("Total:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelTotal)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTotal)
                    .addComponent(jLabel2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAlterQuantity;
    private javax.swing.JButton jButtonBudget;
    private javax.swing.JButton jButtonCloseSale;
    private javax.swing.JButton jButtonRemove;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTableResults;
    // End of variables declaration//GEN-END:variables

    private void configureJTableProducts() {
    }

    private void configureListener() {
        final JPanelSale jPanel = this;
        Toolkit.getDefaultToolkit().addAWTEventListener(
                new AWTEventListener(jPanel) {
            @Override
            public void onEventDispatched(AWTEvent event) throws ValidationException {
                // Verifica se este painel está sendo exibido
                if (jPanel.isVisible()) {
                    KeyEvent ev = (KeyEvent) event;
                    // Verifica se foi um key Released
                    if (ev.getID() == KeyEvent.KEY_RELEASED) {
                        if (!dialog.isVisible() && jPanel.isEnabled()) {
                            if (ev.getKeyCode() == KeyEvent.VK_F1) {

                                JOptionPane.showMessageDialog(jPanel, "Texto de ajuda");

                            } else {
                                jPanel.setEnabled(false);
                                if (ev.getID() == KeyEvent.KEY_RELEASED && checkKeyAction(ev)) {
                                    dialog.setText(ev.getKeyChar() + "");
                                    dialog.setVisible(true);
                                } else if (ev.getKeyCode() == KeyEvent.VK_F5) {
                                    dialog.setText("");
                                    dialog.setVisible(true);
                                } else {
                                    // Não pode avançar, pois se passar o dialog de quantidade vai ser exibido diversas vezes.
                                    jPanel.setEnabled(true);
                                    return;
                                }

                                Object object = dialog.getSelected();
                                if (object != null) {
                                    if (object instanceof Product) {
                                        dialogQuantity.setText(((Product) object).getName());
                                        dialogQuantity.setQuantity(1);
                                        dialogQuantity.setVisible(true);
                                        Integer quantity = dialogQuantity.getQuantity();

                                        if (quantity != null) {
                                            addItem((Product) object, quantity);
                                        }

                                    } else {
                                        addItem(object);
                                    }
                                }
                                jPanel.setEnabled(true);
                            }
                        }
                    }

                }
            }
        }, AWTEvent.KEY_EVENT_MASK);
    }

    private boolean checkKeyAction(KeyEvent ev) {
        if (ev.getKeyCode() == KeyEvent.VK_F1
                || ev.getKeyCode() == KeyEvent.VK_F2
                || ev.getKeyCode() == KeyEvent.VK_F3
                || ev.getKeyCode() == KeyEvent.VK_F4
                || ev.getKeyCode() == KeyEvent.VK_F5
                || ev.getKeyCode() == KeyEvent.VK_F6
                || ev.getKeyCode() == KeyEvent.VK_F7
                || ev.getKeyCode() == KeyEvent.VK_F8
                || ev.getKeyCode() == KeyEvent.VK_F9
                || ev.getKeyCode() == KeyEvent.VK_F10
                || ev.getKeyCode() == KeyEvent.VK_F11
                || ev.getKeyCode() == KeyEvent.VK_F12
                || ev.getKeyCode() == KeyEvent.VK_TAB
                || ev.getKeyCode() == KeyEvent.VK_UP
                || ev.getKeyCode() == KeyEvent.VK_DOWN
                || ev.getKeyCode() == KeyEvent.VK_LEFT
                || ev.getKeyCode() == KeyEvent.VK_RIGHT
                || ev.getKeyCode() == KeyEvent.VK_ALT_GRAPH
                || ev.getKeyCode() == KeyEvent.VK_ALT
                || ev.getKeyCode() == KeyEvent.VK_CONTROL
                || ev.getKeyCode() == KeyEvent.VK_INSERT
                || ev.getKeyCode() == KeyEvent.VK_HOME
                || ev.getKeyCode() == KeyEvent.VK_NUM_LOCK
                || ev.getKeyCode() == KeyEvent.VK_DELETE
                || ev.getKeyCode() == KeyEvent.VK_PRINTSCREEN
                || ev.getKeyCode() == KeyEvent.VK_SCROLL_LOCK
                || ev.getKeyCode() == KeyEvent.VK_PAUSE
                || ev.getKeyCode() == KeyEvent.VK_PAGE_DOWN
                || ev.getKeyCode() == KeyEvent.VK_PAGE_UP
                || ev.getKeyCode() == KeyEvent.VK_END
                || ev.getKeyCode() == KeyEvent.VK_ENTER
                || ev.getKeyCode() == KeyEvent.VK_CAPS_LOCK
                || ev.getKeyCode() == KeyEvent.VK_SHIFT
                || ev.getKeyCode() == KeyEvent.VK_CONTEXT_MENU
                || ev.getKeyCode() == KeyEvent.VK_WINDOWS
                || ev.getKeyCode() == KeyEvent.VK_ESCAPE) {
            return false;
        }
        return true;
    }

    @Override
    public void setVisible(boolean aFlag) {
        super.setVisible(aFlag);
    }

    private void addButtonListeners() {
        final JPanelSale panel = this;
        jButtonCloseSale.addActionListener(new ActionListener(this) {
            @Override
            public void onActionPerformed(ActionEvent e) throws Exception {
                dialogCloseSale.setSale(instance);
                dialogCloseSale.setVisible(true);
                if (!dialogCloseSale.isCanceled()) {
                    log.info("sale is closed");
                    instance = service.loadSale(Application.computer);
                    reloadUi();
                }
            }
        });
        jButtonRemove.addActionListener(new ActionListener(this) {
            @Override
            public void onActionPerformed(ActionEvent e) throws Exception {
                ConfirmDialog confirm = new ConfirmDialog(Application.getInstance());
                confirm.setText("Você deseja realmente remover estes itens?<br>Esta ação não pode ser desfeita");

                confirm.setVisible(true);
                if (confirm.getResponse()) {
                    List<SaleProduct> products = ((Table<SaleProduct>) jTableResults).getSelecteds();
                    log.info("Removing {} Itens ", products.size());
                    removeItems(products);
                }

            }
        });

        jButtonAlterQuantity.addActionListener(new ActionListener(this) {
            @Override
            public void onActionPerformed(ActionEvent e) throws Exception {
                SaleProduct saleProduct = ((Table<SaleProduct>) jTableResults).getSelected();
                if (saleProduct != null) {
                    dialogQuantity.setText(saleProduct.getProduct().getDisplayName());
                    dialogQuantity.setQuantity(saleProduct.getQuantity());
                    dialogQuantity.setVisible(true);
                    Integer quantity = dialogQuantity.getQuantity();
                    if (quantity != null) {
                        updateItem(saleProduct, quantity);
                    }
                }
            }
        });

        jButtonBudget.addActionListener(new ActionListener(this) {
            @Override
            protected void onActionPerformed(ActionEvent e) throws Exception {
                Application.load(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(4000);
                        } catch (InterruptedException ex) {
                            log.error(ex.getMessage(), ex);
                        }
                    }
                });
            }
        });
    }

    private void addItem(Object object) throws ValidationException {
        if (object instanceof List) {
            addItem((List<Product>) object);
        } else if (object instanceof Product) {
            addItem((Product) object, null);
        } else {
            throw new IllegalArgumentException(
                    "Expected an instance of Product or instance of List<Product> found "
                    + object.getClass());
        }
    }

    private void addItem(List<Product> products) {
        for (Product p : products) {
            SaleProduct saleProduct = new SaleProduct(p, 1, instance);
            if(!instance.getProducts().contains(saleProduct)){
                instance.getProducts().add(saleProduct);
            }
        }
        try {
            this.service.save(instance);
            reloadUi();
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new RuntimeException(ex);
        }
    }

    private void addItem(Product product, Integer quantity) throws ValidationException {
        quantity = quantity == null ? 1 : quantity;
        SaleProduct p = new SaleProduct(product, quantity, instance);
        if (!instance.getProducts().contains(p)) {
            instance.getProducts().add(p);

            try {
                this.service.save(instance);
            } catch (Exception ex) {
                log.error(ex.getMessage(), ex);
                throw new RuntimeException(ex);
            }
            reloadUi();
        } else {
            ValidationException e = new ValidationException();
            e.addError("Este produto já foi adicionado! Altere a quantidade");
            throw e;
        }
    }

    protected void updateItem(Product product, Integer quantity) {
        for (SaleProduct p : instance.getProducts()) {
            if (p.getProduct().equals(product)) {
                p.setQuantity(quantity);
                renderTable();
                try {
                    this.service.save(instance);
                } catch (Exception ex) {
                    log.error(ex.getMessage(), ex);
                    throw new RuntimeException(ex);
                }
                return;
            }
        }
    }

    protected void updateItem(SaleProduct product, Integer quantity) {
        product.setQuantity(quantity);
        product.setTotal(quantity * product.getSellPrice());
        try {
            this.service.save(instance);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new RuntimeException(ex);
        }
        reloadUi();
    }

    protected void removeItem(SaleProduct product) {
        this.instance.getProducts().remove(product);
        try {
            this.service.save(instance);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new RuntimeException(ex);
        }
        reloadUi();
    }

    protected void removeItems(List<SaleProduct> products) {
        this.instance.getProducts().removeAll(products);
        try {
            this.service.save(instance);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new RuntimeException(ex);
        }
        reloadUi();
    }

    protected void reloadUi() {
        renderTable();
        this.jLabelTotal.setText(String.format("%5.2f", instance.getTotal()));
    }

    private void renderTable() {

        FieldResolver nameResolver = new FieldResolver(SaleProduct.class, "product.name", "Nome");
        FieldResolver unitaryValueResolver = new FieldResolver(SaleProduct.class, "sellPrice", "Preço Unitário (R$)");
        unitaryValueResolver.setFormatter(new Currency());
        FieldResolver quantityResolver = new FieldResolver(SaleProduct.class, "quantity", "Quantidade");

        FieldResolver totalResolver = new FieldResolver(SaleProduct.class, "total", "Total");
        totalResolver.setFormatter(new Currency());

        ObjectTableModel<SaleProduct> towel = new ObjectTableModel<>(
                new FieldResolver[]{nameResolver, unitaryValueResolver,
            quantityResolver, totalResolver});

        java.util.List<SaleProduct> produtoCarts = instance.getProducts();

        towel.setData(produtoCarts);

        jTableResults.setModel(towel);
    }

    @Override
    public void unloadContent() {
        try {
            this.service.save(instance);
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void loadContent() {
        try {
            instance = service.loadSale(Application.computer);
            reloadUi();
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
            throw new RuntimeException(ex);

        }
    }
}
