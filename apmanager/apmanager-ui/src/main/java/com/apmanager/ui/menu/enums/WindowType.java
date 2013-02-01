/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apmanager.ui.menu.enums;

import com.apmanager.ui.menu.NewJPanel;
import com.apmanager.ui.panels.JPanelSale;
import com.apmanager.ui.panels.admin.JPanelViewSales;
import com.apmanager.ui.panels.product.JPanelProduct;
import com.apmanager.ui.panels.productbrand.JPanelProductBrand;
import com.apmanager.ui.panels.shelf.JPanelShelf;
import com.apmanager.ui.panels.stock.JPanelStock;
import com.apmanager.ui.panels.vehicle.JPanelVehicle;
import com.apmanager.ui.panels.vehiclebrand.JPanelVehicleBrand;
import javax.swing.JPanel;

/**
 *
 * @author ADMIN
 */
public enum WindowType {

    SALE(JPanelSale.class,"Vendas"),
    SALES_SEARCH(JPanelViewSales.class, "Pesquisa de Vendas"),
    PRODUCT_CRUD(JPanelProduct.class, "Produtos"),
    VEHICLE_BRAND_CRUD(JPanelVehicleBrand.class, "Marcas de Veículos"),
    SHELF_CRUD(JPanelShelf.class, "Prateleiras"),
    VEHICLE_CRUD(JPanelVehicle.class,"Veículos"),
    PRODUCT_BRAND_CRUD(JPanelProductBrand.class, "Marcas de Produtos"),
    STOCK(JPanelStock.class, "Estoque");

    private Class<? extends JPanel> destined;
    private String title;
    

    private WindowType(Class<? extends JPanel> destined, String title) {
        this.destined = destined;
        this.title = title;
    }

    public Class<? extends JPanel> getDestined() {
        return destined;
    }

    public String getTitle() {
        return title;
    }
}