/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package provemax_2.vistas;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author marus
 */
public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
          this.setTitle("MENU");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ImageIcon icon = new ImageIcon(getClass().getResource("/img/fondo2.jpg"));
        Image image = icon.getImage();
        jDesktopPane1 = new javax.swing.JDesktopPane(){
            public void paintComponent(Graphics g){
                g.drawImage(image,0,0,getWidth(),getHeight(),this);
            }

        };
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jRadioButtonMenuItem1 = new javax.swing.JRadioButtonMenuItem();
        jRadioButtonMenuItem2 = new javax.swing.JRadioButtonMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jrmProveedor = new javax.swing.JRadioButtonMenuItem();
        jrmListadoProveedor = new javax.swing.JRadioButtonMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jrmCompra = new javax.swing.JRadioButtonMenuItem();
        jrmListadoCompra = new javax.swing.JRadioButtonMenuItem();
        jrmNuevasCompras = new javax.swing.JRadioButtonMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jrmDetalle = new javax.swing.JRadioButtonMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jrmExit = new javax.swing.JRadioButtonMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 809, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 427, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jDesktopPane1)
        );

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/producto.png"))); // NOI18N
        jMenu1.setText("Producto");
        jMenu1.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N

        jRadioButtonMenuItem1.setSelected(true);
        jRadioButtonMenuItem1.setText("Productos");
        jRadioButtonMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jRadioButtonMenuItem1);

        jRadioButtonMenuItem2.setSelected(true);
        jRadioButtonMenuItem2.setText("Listado de Productos");
        jRadioButtonMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButtonMenuItem2ActionPerformed(evt);
            }
        });
        jMenu1.add(jRadioButtonMenuItem2);

        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-agregar-administrador-50.png"))); // NOI18N
        jMenu2.setText("Proveedor");
        jMenu2.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N

        jrmProveedor.setSelected(true);
        jrmProveedor.setText("Proveedores");
        jrmProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrmProveedorActionPerformed(evt);
            }
        });
        jMenu2.add(jrmProveedor);

        jrmListadoProveedor.setSelected(true);
        jrmListadoProveedor.setText("Listado Proveedores");
        jrmListadoProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrmListadoProveedorActionPerformed(evt);
            }
        });
        jMenu2.add(jrmListadoProveedor);

        jMenuBar1.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-carrito-de-la-compra-cargado-48.png"))); // NOI18N
        jMenu3.setText("Compra");
        jMenu3.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N

        jrmCompra.setSelected(true);
        jrmCompra.setText("Compras");
        jrmCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrmCompraActionPerformed(evt);
            }
        });
        jMenu3.add(jrmCompra);

        jrmListadoCompra.setSelected(true);
        jrmListadoCompra.setText("Listado Compras");
        jrmListadoCompra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrmListadoCompraActionPerformed(evt);
            }
        });
        jMenu3.add(jrmListadoCompra);

        jrmNuevasCompras.setSelected(true);
        jrmNuevasCompras.setText("Nuevas Compras");
        jrmNuevasCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrmNuevasComprasActionPerformed(evt);
            }
        });
        jMenu3.add(jrmNuevasCompras);

        jMenuBar1.add(jMenu3);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/ventas.png"))); // NOI18N
        jMenu4.setText("Detalle");
        jMenu4.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N

        jrmDetalle.setSelected(true);
        jrmDetalle.setText("Detalle Compra");
        jrmDetalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrmDetalleActionPerformed(evt);
            }
        });
        jMenu4.add(jrmDetalle);

        jMenuBar1.add(jMenu4);

        jMenu5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/cerrar-sesion.png"))); // NOI18N
        jMenu5.setText("Salir");
        jMenu5.setFont(new java.awt.Font("Arial Rounded MT Bold", 2, 12)); // NOI18N
        jMenu5.setPreferredSize(new java.awt.Dimension(150, 50));

        jrmExit.setSelected(true);
        jrmExit.setText("Exit");
        jrmExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrmExitActionPerformed(evt);
            }
        });
        jMenu5.add(jrmExit);

        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jrmProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrmProveedorActionPerformed
        jDesktopPane1.removeAll();
        jDesktopPane1.repaint();
        Proveedores pro = new Proveedores();
        pro.setVisible(true);
        jDesktopPane1.add(pro);
        jDesktopPane1.moveToFront(pro);
    }//GEN-LAST:event_jrmProveedorActionPerformed

    private void jrmCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrmCompraActionPerformed
        jDesktopPane1.removeAll();
        jDesktopPane1.repaint();
        Compras comp = new Compras();
        comp.setVisible(true);
        jDesktopPane1.add(comp);
        jDesktopPane1.moveToFront(comp);
    }//GEN-LAST:event_jrmCompraActionPerformed

    private void jrmDetalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrmDetalleActionPerformed
        jDesktopPane1.removeAll();
        jDesktopPane1.repaint();
        DetalleCompras deta = new DetalleCompras();
        deta.setVisible(true);
        jDesktopPane1.add(deta);
        jDesktopPane1.moveToFront(deta);
    }//GEN-LAST:event_jrmDetalleActionPerformed

    private void jrmExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrmExitActionPerformed
         JOptionPane.showMessageDialog(this, "SU CARGA HA SIDO EXITOSA");
        Login salida = new Login();
        salida.setVisible(true);
    }//GEN-LAST:event_jrmExitActionPerformed

    private void jrmListadoProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrmListadoProveedorActionPerformed
         jDesktopPane1.removeAll();
        jDesktopPane1.repaint();
        ListadoProveedor listprov = new ListadoProveedor();
        listprov.setVisible(true);
        jDesktopPane1.add(listprov);
        jDesktopPane1.moveToFront(listprov);
    }//GEN-LAST:event_jrmListadoProveedorActionPerformed

    private void jrmListadoCompraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrmListadoCompraActionPerformed
        jDesktopPane1.removeAll();
        jDesktopPane1.repaint();
        ListadoCompra listcomp = new ListadoCompra();
        listcomp.setVisible(true);
        jDesktopPane1.add(listcomp);
        jDesktopPane1.moveToFront(listcomp);
    }//GEN-LAST:event_jrmListadoCompraActionPerformed

    private void jRadioButtonMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem1ActionPerformed
         jDesktopPane1.removeAll();
        jDesktopPane1.repaint();
        Productos productos = new Productos();
        productos.setVisible(true);
        jDesktopPane1.add(productos);
        jDesktopPane1.moveToFront(productos);
    }//GEN-LAST:event_jRadioButtonMenuItem1ActionPerformed

    private void jRadioButtonMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButtonMenuItem2ActionPerformed
         jDesktopPane1.removeAll();
        jDesktopPane1.repaint();
        ListaProductos listprod = new ListaProductos();
        listprod.setVisible(true);
        jDesktopPane1.add(listprod);
        jDesktopPane1.moveToFront(listprod);
    }//GEN-LAST:event_jRadioButtonMenuItem2ActionPerformed

    private void jrmNuevasComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrmNuevasComprasActionPerformed
            jDesktopPane1.removeAll();
        jDesktopPane1.repaint();
        NuevaCompra nuevaCompra = new NuevaCompra();
        nuevaCompra.setVisible(true);
        jDesktopPane1.add(nuevaCompra);
        jDesktopPane1.moveToFront(nuevaCompra);
    }//GEN-LAST:event_jrmNuevasComprasActionPerformed

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
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem1;
    private javax.swing.JRadioButtonMenuItem jRadioButtonMenuItem2;
    private javax.swing.JRadioButtonMenuItem jrmCompra;
    private javax.swing.JRadioButtonMenuItem jrmDetalle;
    private javax.swing.JRadioButtonMenuItem jrmExit;
    private javax.swing.JRadioButtonMenuItem jrmListadoCompra;
    private javax.swing.JRadioButtonMenuItem jrmListadoProveedor;
    private javax.swing.JRadioButtonMenuItem jrmNuevasCompras;
    private javax.swing.JRadioButtonMenuItem jrmProveedor;
    // End of variables declaration//GEN-END:variables
}
