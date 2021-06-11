/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package principal;

import beans.Cita;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.help.HelpBroker;
import javax.help.HelpSet;
import javax.help.HelpSetException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author Alex
 */
public class FrPrincipal extends javax.swing.JFrame {

   //declaro las variables necesarias, como input, socket, IP, dimensiones, etc
    boolean vieneDeAlta = true;

    public static DataOutputStream out;
    public static DataInputStream in;
    public static ObjectOutputStream outObj;
    public static ObjectInputStream inObj;

    public static Socket sc;

    public static final String IP = "127.0.0.1";
    public static final int PUERTO = 9999;

    public static final int ANCHO = 700;
    public static final int ALTO = 500;

    //También declaro e incializo los paneles, los pongo estáticos porque los tendré que utilizar en las otras clases 
    //que extienden de Jpanel
    public PanelAcceso panelAcceso = new PanelAcceso();
    public static PanelBienvenida panelBienvenida = new PanelBienvenida();
    public static PanelAltaCliente panelAltaCliente = new PanelAltaCliente();
    public static PanelAltaMascota panelAltaMascota = new PanelAltaMascota();
    public static PanelConsultaCliente panelConsultaCliente = new PanelConsultaCliente();
    public static PanelConsultaMascota panelConsultaMascota = new PanelConsultaMascota();
    public static PanelConsultaCita panelConsultaCita = new PanelConsultaCita();
    public static PanelDetalleCita panelDetalleCita = new PanelDetalleCita();
    public static PanelConsultaHistorial panelConsultaHistorial = new PanelConsultaHistorial();
    public static PanelAltaHistorial panelAltaHistorial = new PanelAltaHistorial();
    public static PanelFactura panelFactura = new PanelFactura();

    //variables necesarias para javaHelp
    private HelpSet hs;
    private HelpBroker hb;

    public FrPrincipal() {
        //pongo titulo e imagen al Jframe
        setTitle("Clínica veterinaria");
        try {
            setIconImage(ImageIO.read(getClass().getResource("/recursos/logotipo.png")));
        } catch (IOException ex) {
            Logger.getLogger(FrPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Añadir paneles al JFrame
        this.add(panelAcceso);
        this.add(panelBienvenida);
        this.add(panelAltaCliente);
        this.add(panelAltaMascota);
        this.add(panelConsultaMascota);
        this.add(panelConsultaCliente);
        this.add(panelConsultaCita);
        this.add(panelDetalleCita);
        this.add(panelConsultaHistorial);
        this.add(panelAltaHistorial);
        this.add(panelFactura);

        initComponents();

        ///////////////////////////////////////////////////////////////////////////
        try {
            //Iniciar java help para la ayuda
            URL hsURL = HelpSet.findHelpSet(null, "help/helpset.hs"); // localiza el fichero helpset
            hs = new HelpSet(null, hsURL);  // crea un objeto Helpset
            hb = hs.createHelpBroker();
            // Ayuda al hacer click en el JMenuItem itemAyuda.
            hb.enableHelpOnButton(ayuda, "pag_portada", hs);

            // Ayuda al pulsar F1 sobre la ventana principal
            hb.enableHelpKey(ayuda, "pag_portada", hs);

            // Ayuda al pulsar F1 sobre la ventana secundaria
            //hb.enableHelpKey(secundaria.getContentPane(), "ventana_secundaria", helpset);
        } catch (HelpSetException ex) {
            JOptionPane.showMessageDialog(this, "Fichero HelpSet no encontrado");
        }
        //////////////////////////////////////////////////////////////////////////////

        //Pongo todos los paneles y el menú invisibles
        menu.setVisible(false);

        panelBienvenida.setVisible(false);
        panelAltaCliente.setVisible(false);
        panelAltaMascota.setVisible(false);
        panelConsultaMascota.setVisible(false);
        panelConsultaCliente.setVisible(false);
        panelConsultaCita.setVisible(false);
        panelDetalleCita.setVisible(false);
        panelConsultaHistorial.setVisible(false);
        panelAltaHistorial.setVisible(false);
        panelFactura.setVisible(false);

        //////////////////////ADAPTAR paneles al JFrame//////////////////////////////////////////////////////////////////
        getContentPane()
                .setLayout(new FlowLayout());
        panelAcceso.setPreferredSize(
                new Dimension(500, 500));
        //el primero lo hago visible al iniciar
        panelAcceso.setVisible(
                true);
        getContentPane()
                .add(panelAcceso);
        pack();

        repaint();
        //--------------------------------------------------
        getContentPane()
                .setLayout(new FlowLayout());
        panelBienvenida.setPreferredSize(
                new Dimension(500, 500));
        getContentPane()
                .add(panelBienvenida);
        pack();

        repaint();
        //--------------------------------------------------
        getContentPane()
                .setLayout(new FlowLayout());
        panelAltaCliente.setPreferredSize(
                new Dimension(ANCHO, ALTO));
        pack();

        repaint();
        //--------------------------------------------------
        getContentPane()
                .setLayout(new FlowLayout());
        panelAltaMascota.setPreferredSize(
                new Dimension(ANCHO, ALTO));
        pack();

        repaint();
        //--------------------------------------------------
        getContentPane()
                .setLayout(new FlowLayout());
        panelConsultaCliente.setPreferredSize(
                new Dimension(ANCHO, ALTO));
        pack();

        repaint();
        //--------------------------------------------------
        getContentPane()
                .setLayout(new FlowLayout());
        panelConsultaMascota.setPreferredSize(
                new Dimension(ANCHO, ALTO));
        pack();

        repaint();
        //--------------------------------------------------
        getContentPane()
                .setLayout(new FlowLayout());
        panelConsultaCita.setPreferredSize(
                new Dimension(ANCHO, ALTO));
        pack();

        repaint();
        //--------------------------------------------------
        getContentPane()
                .setLayout(new FlowLayout());
        panelDetalleCita.setPreferredSize(
                new Dimension(ANCHO, ALTO));
        pack();

        repaint();

        getContentPane()
                .setLayout(new FlowLayout());
        panelAltaHistorial.setPreferredSize(
                new Dimension(ANCHO, ALTO));
        pack();

        repaint();
        //--------------------------------------------------
        getContentPane()
                .setLayout(new FlowLayout());
        panelConsultaHistorial.setPreferredSize(
                new Dimension(ANCHO, ALTO));
        pack();

        repaint();
        //--------------------------------------------------
        getContentPane()
                .setLayout(new FlowLayout());
        panelFactura.setPreferredSize(
                new Dimension(ANCHO, ALTO));
        pack();

        repaint();

        ///////////////////////////////////////////////////////////////////////////
        //centra la ventana
        centrarVentana();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        menu = new javax.swing.JMenuBar();
        jMenu2 = new javax.swing.JMenu();
        itemAltaCliente = new javax.swing.JMenuItem();
        ItemConsultaCliente = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        itemAltaMascota = new javax.swing.JMenuItem();
        itemConsultaMascota = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        itemConsultaCita = new javax.swing.JMenuItem();
        itemCerrarSesion = new javax.swing.JMenu();
        itemCerrar = new javax.swing.JMenuItem();
        itemSalir = new javax.swing.JMenuItem();
        JMenu4 = new javax.swing.JMenu();
        ayuda = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jMenu2.setText("Gestión de clientes");

        itemAltaCliente.setText("Alta");
        itemAltaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAltaClienteActionPerformed(evt);
            }
        });
        jMenu2.add(itemAltaCliente);

        ItemConsultaCliente.setText("Consulta");
        ItemConsultaCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ItemConsultaClienteActionPerformed(evt);
            }
        });
        jMenu2.add(ItemConsultaCliente);

        menu.add(jMenu2);

        jMenu3.setText("Gestión de pacientes");

        itemAltaMascota.setText("Alta");
        itemAltaMascota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemAltaMascotaActionPerformed(evt);
            }
        });
        jMenu3.add(itemAltaMascota);

        itemConsultaMascota.setText("Consulta");
        itemConsultaMascota.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemConsultaMascotaActionPerformed(evt);
            }
        });
        jMenu3.add(itemConsultaMascota);

        menu.add(jMenu3);

        jMenu1.setText("Gestión de citas");

        itemConsultaCita.setText("Consulta");
        itemConsultaCita.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemConsultaCitaActionPerformed(evt);
            }
        });
        jMenu1.add(itemConsultaCita);

        menu.add(jMenu1);

        itemCerrarSesion.setText("Cerrar Sesión");

        itemCerrar.setText("Cerrar sesión");
        itemCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemCerrarActionPerformed(evt);
            }
        });
        itemCerrarSesion.add(itemCerrar);

        itemSalir.setText("Cerrar sesión y salir");
        itemSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemSalirActionPerformed(evt);
            }
        });
        itemCerrarSesion.add(itemSalir);

        menu.add(itemCerrarSesion);

        JMenu4.setText("Ayuda");

        ayuda.setText("Ayuda");
        JMenu4.add(ayuda);

        menu.add(JMenu4);

        setJMenuBar(menu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 496, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 278, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemAltaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAltaClienteActionPerformed
        //al pulsar en el menú alta cliente pongo visible el panel de alta de cliente
        panelVisible(panelAltaCliente);
        pack();
        repaint();
    }//GEN-LAST:event_itemAltaClienteActionPerformed

    private void itemAltaMascotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemAltaMascotaActionPerformed
        //al pulsar en el menú alta cliente pongo visible el panel de alta de mascota
        panelVisible(panelAltaMascota);
        pack();
        repaint();
    }//GEN-LAST:event_itemAltaMascotaActionPerformed

    private void ItemConsultaClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ItemConsultaClienteActionPerformed
        //Vaciar la jtable
        DefaultTableModel tb = (DefaultTableModel) panelConsultaCliente.tablaCliente.getModel();
        int numeroFilas = panelConsultaCliente.tablaCliente.getRowCount() - 1;
        for (int i = numeroFilas; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);
        }

        //pongo invisible todos los componentes del panel
        panelConsultaCliente.calendario.setVisible(false);
        panelConsultaCliente.lblFechaBaja.setVisible(false);
        panelConsultaCliente.btnBaja.setVisible(false);
        panelConsultaCliente.btnFactura.setVisible(false);
        panelConsultaCliente.btnFiltrar.setVisible(false);
        panelConsultaCliente.btnImprimir.setVisible(false);
        panelConsultaCliente.btnModificarCliente.setVisible(false);
        panelConsultaCliente.txtFiltro.setVisible(false);
        //al pulsar en el menú alta cliente pongo visible el panel de consulta de cliente
        panelVisible(panelConsultaCliente);
        pack();
        repaint();
    }//GEN-LAST:event_ItemConsultaClienteActionPerformed

    private void itemConsultaMascotaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemConsultaMascotaActionPerformed
        //Vaciar la jtable
        DefaultTableModel tb = (DefaultTableModel) panelConsultaMascota.tablaMascota.getModel();
        int numeroFilas = panelConsultaMascota.tablaMascota.getRowCount() - 1;
        for (int i = numeroFilas; i >= 0; i--) {
            tb.removeRow(tb.getRowCount() - 1);
        }
        
        //pongo invisible todos los componentes del panel
        panelConsultaMascota.btnBaja.setVisible(false);
        panelConsultaMascota.btnConsultaHistorial.setVisible(false);
        panelConsultaMascota.btnCrearHistorial.setVisible(false);
        panelConsultaMascota.btnFiltrar.setVisible(false);
        panelConsultaMascota.txtFiltro.setVisible(false);
        //al pulsar en el menú alta cliente pongo visible el panel de consulta de mascota
        panelVisible(panelConsultaMascota);
        pack();
        repaint();
    }//GEN-LAST:event_itemConsultaMascotaActionPerformed

    private void itemConsultaCitaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemConsultaCitaActionPerformed
        //Pone el calendario y la combobox de la hora invisibles
        panelDetalleCita.calendarioCita.setVisible(false);
        panelDetalleCita.cbHora.setVisible(false);
        
        //listar citas al pulsar en el menú consultar citas
        listarCitas();

        //Ajustamos el ancho de la jtable
        resizeColumnWidth(panelConsultaCita.tablaCita);
        panelConsultaCita.tablaCita.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);

        pack();
        repaint();
    }//GEN-LAST:event_itemConsultaCitaActionPerformed

    private void itemSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemSalirActionPerformed
        //para salir de la aplicación pregunta primero
        if (JOptionPane.showConfirmDialog(null, "¿Desea salir de la aplicación?", "SALIR", JOptionPane.YES_NO_OPTION) != 1) {
            System.exit(0);
        }
    }//GEN-LAST:event_itemSalirActionPerformed

    private void itemCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemCerrarActionPerformed
        //para cerrar sesión pregunta primero y luego va a la pantall inicio de sesion
        if (JOptionPane.showConfirmDialog(null, "¿Desea cerrar sesión?", "CERRAR SESIÓN", JOptionPane.YES_NO_OPTION) != 1) {
            menu.setVisible(false);
            panelAcceso.txtId.setText("");
            panelAcceso.txtClave.setText("");
            panelVisible(panelAcceso);
            pack();
            repaint();
        }
    }//GEN-LAST:event_itemCerrarActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;

                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrPrincipal().setVisible(true);
            }
        });
    }

    //***************************************************************
    //**************** MÉTODOS **************************************
    //***************************************************************
    //--------- Método para comprobar si la cadena es un número ------------
    public static boolean esNumero(String cadena) {

        boolean resultado;

        try {
            Integer.parseInt(cadena);
            resultado = true;
        } catch (NumberFormatException excepcion) {
            resultado = false;
        }

        return resultado;
    }

    //-------------------- Método para hacer visible uno de los paneles ----------------
    public void panelVisible(JPanel p) {
        panelBienvenida.setVisible(false);
        panelAltaCliente.setVisible(false);
        panelAltaMascota.setVisible(false);
        panelConsultaMascota.setVisible(false);
        panelConsultaCliente.setVisible(false);
        panelConsultaCita.setVisible(false);
        panelDetalleCita.setVisible(false);
        panelConsultaHistorial.setVisible(false);
        panelAltaHistorial.setVisible(false);
        panelFactura.setVisible(false);

        p.setVisible(true);
    }

    //------------ Método para mostrar panel consulta cita y listar citas solamente las pendientes --------------------
    public void listarCitas() {
        //pongo invisible la tabla de consulta citas
        panelConsultaCita.scrollTablaCita.setVisible(false);
        
        //pongo el panel consulta cita visible
        panelVisible(panelConsultaCita);

        //muestra lista cita
        panelConsultaCita.scrollTablaCita.setVisible(true);
        Cita c;

        //Guardo el nombre de las columnas
        String[] columnas = {"", "ID", "Motivo", "Fecha", "ID Cliente", "Id Mascota"};
        //instancia un modelo de tabla al que añado las columnas
        DefaultTableModel modelo = new DefaultTableModel(null, columnas);

        try {
            //abro conexión
            sc = new Socket(IP, PUERTO);
            
            //instancio los outpuy e input
            out = new DataOutputStream(sc.getOutputStream());
            in = new DataInputStream(sc.getInputStream());
            //envío el mensaje y recojo el número de citas
            out.writeUTF("listacitas");
            int num = in.readInt();

            inObj = new ObjectInputStream(sc.getInputStream());
            //instancio  lista
            List<Cita> lista = new ArrayList();
            
            //guaro las citas en la lista
            for (int i = 0; i < num; i++) {
                c = (Cita) inObj.readObject();
                if (c.getFecha().compareTo(new Date()) >= 0) {

                    lista.add(c);

                }
            }

            //Ordeno el objeto cita de mayor a menor según la fecha
            Collections.sort(lista, new Comparator<Cita>() {
                @Override
                public int compare(Cita o1, Cita o2) {
                    return new Integer(o2.getFecha().compareTo(o1.getFecha()));
                }
            });

            //Guardo cada elemento en las filas y añado las filas a la tabla
            for (int i = 0; i < lista.size(); i++) {
                String[] filas = {"", String.valueOf(lista.get(i).getIdcita()), lista.get(i).getMotivo(), lista.get(i).getFecha().toString(),
                    String.valueOf(lista.get(i).getIdcliente()), String.valueOf(lista.get(i).getIdmascota())};

                modelo.addRow(filas);
            }

            panelConsultaCita.tablaCita.setModel(modelo);

            inObj.close();
            out.close();
            in.close();

        } catch (IOException | ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrPrincipal.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

    //------------ Método para ajustar el ancho de la jtable -------------
    private void resizeColumnWidth(JTable table) {
        //Se obtiene el modelo de la columna
        TableColumnModel columnModel = table.getColumnModel();
        //Se obtiene el total de las columnas
        for (int column = 0; column < table.getColumnCount(); column++) {
            //Establecemos un valor minimo para el ancho de la columna
            int width = 150; //Min Width
            //Obtenemos el numero de filas de la tabla
            for (int row = 0; row < table.getRowCount(); row++) {
                //Obtenemos el renderizador de la tabla
                TableCellRenderer renderer = table.getCellRenderer(row, column);
                //Creamos un objeto para preparar el renderer
                Component comp = table.prepareRenderer(renderer, row, column);
                //Establecemos el width segun el valor maximo del ancho de la columna
                width = Math.max(comp.getPreferredSize().width + 1, width);

            }
            //Se establece una condicion para no sobrepasar el valor de 300
            //Esto es Opcional
            if (width > 300) {
                width = 300;
            }
            //Se establece el ancho de la columna
            columnModel.getColumn(column).setPreferredWidth(width);
        }
    }

    //----------------- Método para centrar el JFrame (la ventana)
    public void centrarVentana() {
        int ancho = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
        int alto = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
        System.out.println("ancho=" + ancho + " alto=" + alto + " ancho=" + this.getWidth() + " alto=" + this.getHeight());
        setLocation(ancho / 2 - getWidth() / 2, alto / 2 - getHeight() / 2);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuItem ItemConsultaCliente;
    private javax.swing.JMenu JMenu4;
    private javax.swing.JMenuItem ayuda;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JMenuItem itemAltaCliente;
    private javax.swing.JMenuItem itemAltaMascota;
    private javax.swing.JMenuItem itemCerrar;
    private javax.swing.JMenu itemCerrarSesion;
    private javax.swing.JMenuItem itemConsultaCita;
    private javax.swing.JMenuItem itemConsultaMascota;
    private javax.swing.JMenuItem itemSalir;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    public static javax.swing.JMenuBar menu;
    // End of variables declaration//GEN-END:variables
}
