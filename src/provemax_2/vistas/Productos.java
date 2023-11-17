/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */

package provemax_2.vistas;

import java.sql.SQLException;
import javax.swing.JOptionPane;
import provemax_2.accesoDatos.ProductoData;
import provemax_2.entidades.Producto;

/**
 *
 * @author marus
 */
public class Productos extends javax.swing.JInternalFrame {

    private ProductoData producData= new ProductoData();
    private Producto productoActual= null; 
    
    
    public Productos() {
        initComponents();
        
    }
    
    
     private void limpiarCampos(){
         
        jtCodigoProducto.setText("");
        jtDescripcionProducto.setText("");
        jtNombreProducto.setText("");
        jtPrecioActual.setText("");
        jtStock.setText("");
        jtStockMinimo.setText("");
        jrbEstado.setSelected(true);
     }
     
     
     
     

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jtCodigoProducto = new javax.swing.JTextField();
        jtNombreProducto = new javax.swing.JTextField();
        jtDescripcionProducto = new javax.swing.JTextField();
        jtPrecioActual = new javax.swing.JTextField();
        jbAgregar = new javax.swing.JButton();
        jbBuscarNombre = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jbExit = new javax.swing.JButton();
        jbBuscar = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtStock = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jtStockMinimo = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jrbEstado = new javax.swing.JRadioButton();
        jbLimpiar = new javax.swing.JButton();

        jPanel1.setBackground(new java.awt.Color(204, 255, 204));

        jLabel1.setFont(new java.awt.Font("Algerian", 3, 36)); // NOI18N
        jLabel1.setText("PROCUCTOS");

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel2.setText("COD. PRODUCTO : ");

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel3.setText("NOMBRE PRODUCTO :");

        jLabel4.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel4.setText("DESCRIPCION : ");

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel5.setText("PRECIO ACTUAL : ");

        jbAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/anadir.png"))); // NOI18N
        jbAgregar.setText("AGREGAR");
        jbAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAgregarActionPerformed(evt);
            }
        });

        jbBuscarNombre.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-carpeta-de-documentos-25.png"))); // NOI18N
        jbBuscarNombre.setText("BUSQUEDA");
        jbBuscarNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarNombreActionPerformed(evt);
            }
        });

        jbEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-comprobado.gif"))); // NOI18N
        jbEliminar.setText("ELIMINAR");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        jbExit.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-cerrar-ventana-20.png"))); // NOI18N
        jbExit.setText("EXIT");
        jbExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExitActionPerformed(evt);
            }
        });

        jbBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-lupa-30.png"))); // NOI18N
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Provemax Lumanor Logo - BigCommerce Store Logo with Transparent Background.png"))); // NOI18N

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel7.setText("STOCK : ");

        jLabel8.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel8.setText("STOCK MIN: ");

        jLabel9.setFont(new java.awt.Font("sansserif", 1, 12)); // NOI18N
        jLabel9.setText("ESTADO : ");

        jbLimpiar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-escoba-16.png"))); // NOI18N
        jbLimpiar.setText("ACTUALIZAR");
        jbLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbLimpiarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jbAgregar)
                                .addGap(42, 42, 42)
                                .addComponent(jbBuscarNombre)
                                .addGap(53, 53, 53)
                                .addComponent(jbLimpiar)
                                .addGap(41, 41, 41)
                                .addComponent(jbEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(49, 49, 49)
                                .addComponent(jbExit, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtDescripcionProducto)
                                    .addComponent(jtCodigoProducto)
                                    .addComponent(jtStock, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                                    .addComponent(jrbEstado))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(52, 52, 52)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel8)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtPrecioActual)
                                    .addComponent(jtNombreProducto)
                                    .addComponent(jtStockMinimo, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE))))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(300, 300, 300)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 199, Short.MAX_VALUE)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(191, 191, 191))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(75, 75, 75)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtCodigoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addComponent(jbBuscar)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(4, 4, 4)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jtNombreProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jtDescripcionProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jtPrecioActual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jtStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel8)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jtStockMinimo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jrbEstado))
                .addGap(55, 55, 55)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAgregar)
                    .addComponent(jbBuscarNombre)
                    .addComponent(jbEliminar)
                    .addComponent(jbExit, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbLimpiar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );

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

    
    private void jbAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAgregarActionPerformed
        // agrego producto
        String nombreProducto=jtNombreProducto.getText();
        String descripcion=jtDescripcionProducto.getText();
        double precioActual = Double.parseDouble(jtPrecioActual.getText());
        Integer stock=Integer.parseInt(jtStock.getText());
        Integer stockMinimo= Integer.parseInt(jtStockMinimo.getText());
        Boolean estado= jrbEstado.isSelected();
        
       if(productoActual==null){
           productoActual=new Producto(nombreProducto,descripcion,precioActual,stock,estado,stockMinimo);
           
           producData.guardarProducto(productoActual);
       }else{
           productoActual.setNombreProducto(nombreProducto);
           productoActual.setDescripcion(descripcion);
           productoActual.setPrecioActual(precioActual);
           productoActual.setStock(stock);
           productoActual.setStockMinimo(stockMinimo);
           
           producData.modificarProducto(productoActual);
       }
          limpiarCampos();
    }//GEN-LAST:event_jbAgregarActionPerformed

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
       // elimino producto
        if(productoActual!=null){
           producData.eliminarProductoId(productoActual.getIdProducto());
           productoActual=null;
           limpiarCampos();
       }else{
           JOptionPane.showMessageDialog(this, "No hay un producto seleccionado");
       }
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void jbBuscarNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarNombreActionPerformed
        // busco por nombre
        String nombreProducto = jtNombreProducto.getText();
        productoActual = producData.buscarProductosPorNombre(nombreProducto);
        if (productoActual != null) {
            jtCodigoProducto.setText(String.valueOf(productoActual.getIdProducto()));
            jtDescripcionProducto.setText(productoActual.getDescripcion());
            jtPrecioActual.setText(String.valueOf(productoActual.getPrecioActual()));
            jtStock.setText(String.valueOf(productoActual.getStock()));
            jtStockMinimo.setText(String.valueOf(productoActual.getStockMinimo()));
            jrbEstado.setSelected(productoActual.isEstado());
        } else {
            JOptionPane.showMessageDialog(null, "Producto no encontrado o no disponible en stock");
          
            limpiarCampos();
        }
    }//GEN-LAST:event_jbBuscarNombreActionPerformed

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        // busco por id
         try{
            Integer idProducto=Integer.parseInt(jtCodigoProducto.getText());
        
        productoActual=producData.buscarProductoPorId(idProducto);
        if(productoActual!=null){
            
            jtNombreProducto.setText(productoActual.getNombreProducto());
            jtDescripcionProducto.setText(productoActual.getDescripcion());
            jtPrecioActual.setText(String.valueOf(productoActual.getPrecioActual()));
            jtStock.setText(String.valueOf(productoActual.getStock()));
            jtStockMinimo.setText(String.valueOf(productoActual.getStockMinimo()));
            jrbEstado.setSelected(productoActual.isEstado());
        }
        }catch(NumberFormatException ex){
                JOptionPane.showMessageDialog(null,"Debe ingresar un numero valido");
            
        }  
           
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jbExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExitActionPerformed
        
        dispose();
        JOptionPane.showMessageDialog(this,"DESEA REGRESAR A LA PAGINA PRINCIPAL");
    }//GEN-LAST:event_jbExitActionPerformed

    private void jbLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbLimpiarActionPerformed
        limpiarCampos();
    }//GEN-LAST:event_jbLimpiarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbAgregar;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbBuscarNombre;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbExit;
    private javax.swing.JButton jbLimpiar;
    private javax.swing.JRadioButton jrbEstado;
    private javax.swing.JTextField jtCodigoProducto;
    private javax.swing.JTextField jtDescripcionProducto;
    private javax.swing.JTextField jtNombreProducto;
    private javax.swing.JTextField jtPrecioActual;
    private javax.swing.JTextField jtStock;
    private javax.swing.JTextField jtStockMinimo;
    // End of variables declaration//GEN-END:variables

}
