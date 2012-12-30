/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apmanager.ui.main;

import com.apmanager.service.Config;
import com.apmanager.service.Provider;
import com.apmanager.ui.menu.Application;
import com.sun.java.swing.plaf.gtk.GTKLookAndFeel;
import java.awt.Frame;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;

/**
 *
 * @author ADMIN
 */
public class Main {

    public static void main(String args[]) {

        final Map<String, Object> map = getOptions(args);
        configureOptions(map);
        if (map.get("-help") != null) {
            String help = "Usage apmanager [options] \n"
                    + "Options with * are required\n\n"
                    + "-d -database *\t: set target database\n"
                    + "-u -user *\t: set database user\n"
                    + "-p -password *\t: set database user password\n"
                    + "-h -databasehost *\t: set database host\n"
                    + "-l -listenerport \t: especify port of aplication listener [ default is 1121 ]\n\n\n";
            System.out.print(help);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
            }
            System.exit(0);
        }
        try {
            // Check if have one other instance running
            Socket socket = new Socket("127.0.0.1", Config.apmanagerListenerPort);
            Logger.getLogger(Main.class.getName()).log(Level.INFO, "Application already running exiting");
            System.exit(0);
        } catch (UnknownHostException ex) {
            configureSocket();
        } catch (IOException ex) {
            configureSocket();
        }

        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            String defaultLAF = UIManager.getSystemLookAndFeelClassName();
            if (defaultLAF.equals(MetalLookAndFeel.class.getName())) {
                defaultLAF = GTKLookAndFeel.class.getName();
            }
            UIManager.setLookAndFeel(defaultLAF);
        } catch (ClassNotFoundException | InstantiationException |
                IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Application.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>


        Thread r = new Thread(new Runnable() {
            @Override
            public void run() {

                try {

                    JDialogSplash splash;
                    Boolean forceBg = (Boolean) map.get("force-background");
                    if (forceBg != null && forceBg) {
                        splash = new JDialogSplash(null, true);
                    } else {
                        splash = new JDialogSplash(null, false);
                    }
                    splash.setVisible(true);
                    splash.setMessage("Iniciando Banco de Dados...", 15);

                    EntityManager em = Provider.getEntityManager();

                    splash.setMessage("Aplicando alterações...", 60);
                    Application app = Application.getInstance();
                    splash.setMessage("Concluindo...", 95);

                    Thread.sleep(2000);
                    splash.setMessage("...Pronto", 100);
                    splash.setVisible(false);
                    app.setVisible(true);
                } catch (Throwable e) {
                    Logger.getLogger("Main").log(Level.SEVERE, e.getMessage(), e);
                    JOptionPane.showMessageDialog(null,
                            "Error while loading application, see logs for more informations.");
                    System.exit(0);
                }
            }
        });
        r.start();

    }

    private static Map<String, Object> getOptions(String[] args) {
        Map<String, Object> map = new HashMap<>();

        for (int i = 0; i < args.length; i++) {
            String key = args[i];
            if (key.startsWith("-")) {
                if (args.length > i + 1 && !args[i + 1].startsWith("-")) {
                    Object value;
                    if (args[i + 1].equals("true")) {
                        value = true;
                    } else if (args[i + 1].equals("false")) {
                        value = false;
                    } else {
                        value = args[i + 1];
                    }
                    map.put(key.substring(1), value);
                } else {
                    map.put(key.substring(1), true);
                }
            }
        }

        return map;
    }

    private static void configureOptions(Map<String, Object> map) {
        if (map.get("database") != null || map.get("d") != null) {
            if (map.get("database") != null) {
                Config.databaseName = (String) map.get("database");
            } else {
                Config.databaseName = (String) map.get("d");
            }
        }

        if (map.get("user") != null || map.get("u") != null) {
            if (map.get("user") != null) {
                Config.databaseUser = (String) map.get("user");
            } else {
                Config.databaseUser = (String) map.get("u");
            }
        }

        if (map.get("password") != null || map.get("p") != null) {
            if (map.get("password") != null) {
                Config.databasePassword = (String) map.get("password");
            } else {
                Config.databasePassword = (String) map.get("p");
            }
        }

        if (map.get("databasehost") != null || map.get("h") != null) {
            if (map.get("databasehost") != null) {
                Config.databaseHost = (String) map.get("databasehost");
            } else {
                Config.databaseHost = (String) map.get("h");
            }
        }

        if (map.get("listenerport") != null || map.get("l") != null) {
            if (map.get("listenerport") != null) {
                Config.apmanagerListenerPort = Integer.valueOf((String) map.get("listenerport"));
            } else {
                Config.apmanagerListenerPort = Integer.valueOf((String) map.get("l"));
            }
        } else {
            Config.apmanagerListenerPort = 1121;
        }

    }

    private static void configureSocket() {
        try {
            final ServerSocket server = new ServerSocket(Config.apmanagerListenerPort);
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        Logger.getLogger(Main.class.getName()).log(Level.INFO, "Listening on port {0}", Config.apmanagerListenerPort);
                        try {
                            Socket accept = server.accept();
                            Logger.getLogger(Main.class.getName()).log(Level.INFO, "Restoring view");
                            Application application = Application.getInstance();
                            application.setState ( Frame.NORMAL );
                            application.setExtendedState(JFrame.MAXIMIZED_BOTH);
                            application.setVisible(true);
                            application.requestFocus();
                        } catch (IOException ex) {
                            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }
                }
            });
            t.start();
        } catch (IOException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
