/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package provemax_2.vistas;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import provemax_2.accesoDatos.CompraData;
import provemax_2.accesoDatos.ProveedorData;
import provemax_2.entidades.Compra;
import provemax_2.entidades.Proveedor;


public class ListadoCompra extends javax.swing.JInternalFrame {

     private ProveedorData provData;
    private CompraData compData;
    private DefaultTableModel modelo;
     private Compra compEncontrada = null;

    public ListadoCompra() {
        initComponents();
        this.setTitle("Listado Compras");
        provData = new ProveedorData();
        modelo = new DefaultTableModel();
        compData = new CompraData();

        armarCabecera();
    }

    private void armarCabecera() { // armo la cabecera de mi tabla
        ArrayList<Object> filaCabecera = new ArrayList<>();
        filaCabecera.add("id");
        filaCabecera.add("Proveedor");
        filaCabecera.add("Fecha");
        for (Object it : filaCabecera) {
            modelo.addColumn(it);
        }
        jtCompras.setModel(modelo);
    }

    private void limpiarTabla() {
        // Limpiar todas las filas de la tabla
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
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
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtCompras = new javax.swing.JTable();
        jbActualizar = new javax.swing.JButton();
        jbSalir = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jdcFechaInicio = new com.toedter.calendar.JDateChooser();
        jdcFechaFinal = new com.toedter.calendar.JDateChooser();
        jbBuscar = new javax.swing.JButton();
        jbEliminar = new javax.swing.JButton();
        jrbComprasActivas = new javax.swing.JRadioButton();
        jrbComprasNoActivas = new javax.swing.JRadioButton();

        jPanel1.setBackground(new java.awt.Color(219, 247, 194));

        jtCompras.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jtCompras.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtComprasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtCompras);

        jbActualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/anadir.png"))); // NOI18N
        jbActualizar.setText("ACTUALIZAR");
        jbActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbActualizarActionPerformed(evt);
            }
        });

        jbSalir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-cerrar-ventana-20.png"))); // NOI18N
        jbSalir.setText("EXIT");
        jbSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbSalirActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Algerian", 3, 24)); // NOI18N
        jLabel1.setText("LISTADO  DE COMPRAS");

        jLabel2.setText("Desde");

        jLabel3.setText("Hasta");

        jbBuscar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-lupa-30.png"))); // NOI18N
        jbBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbBuscarActionPerformed(evt);
            }
        });

        jbEliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/icons8-escoba-16.png"))); // NOI18N
        jbEliminar.setText("ELIMINAR");
        jbEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbEliminarActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrbComprasActivas);
        jrbComprasActivas.setText("COMPRAS ACTIVAS");
        jrbComprasActivas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbComprasActivasActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrbComprasNoActivas);
        jrbComprasNoActivas.setText("COMPRAS NO ACTIVAS");
        jrbComprasNoActivas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbComprasNoActivasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(141, 141, 141)
                .addComponent(jbActualizar)
                .addGap(122, 122, 122)
                .addComponent(jbEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(144, 144, 144))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addGap(55, 55, 55)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jdcFechaInicio, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE)
                            .addComponent(jdcFechaFinal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(31, 31, 31)
                        .addComponent(jbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(163, 163, 163)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jrbComprasNoActivas)
                            .addComponent(jrbComprasActivas)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 722, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(283, 283, 283)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(112, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbBuscar)
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1)
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jrbComprasActivas)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jrbComprasNoActivas))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel2)
                                    .addComponent(jdcFechaInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jdcFechaFinal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(19, 19, 19)))
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 231, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbActualizar)
                    .addComponent(jbEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40))
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

    private void jbBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbBuscarActionPerformed
        limpiarTabla(); // funciona busco fecha

        LocalDate fechaDesde = obtenerFechaDesde(jdcFechaInicio);
        LocalDate fechaHasta = obtenerFechaHasta(jdcFechaFinal);

        if (fechaDesde != null && fechaHasta != null) {
            ArrayList<Compra> comprasEnRango = compData.obtenerComprasPorRangoFecha(fechaDesde, fechaHasta);

            //  recorre el ArrayList y agrega las filas a la tabla
            for (Compra compra : comprasEnRango) {
                Object[] fila = {
                    compra.getIdCompra(),
                    compra.getProveedor(), 
                    compra.getFecha()
                };
                modelo.addRow(fila);
            }
        } else {
            JOptionPane.showMessageDialog(this, "Seleccione fechas válidas.");
        }
    }

    private LocalDate obtenerFechaDesde(com.toedter.calendar.JDateChooser dateChooser) {
        java.util.Date date = dateChooser.getDate();
        if (date != null) {
            return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        }
        return null;
    }

    private LocalDate obtenerFechaHasta(com.toedter.calendar.JDateChooser dateChooser) {
        java.util.Date date = dateChooser.getDate();
        if (date != null) {
            return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        }
        return null;

  
    }//GEN-LAST:event_jbBuscarActionPerformed

    private void jtComprasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtComprasMouseClicked
        int filaSeleccionada = jtCompras.getSelectedRow(); // seleccione un item de la tabla y muestro un JOP

        if (filaSeleccionada != -1) {
            int idCompra = (int) modelo.getValueAt(filaSeleccionada, 0); // Reemplaza 0 con el índice correcto de la columna
            Compra compra = compData.buscarCompra(idCompra);

            if (compra != null) {
                Proveedor proveedor = compra.getProveedor(); // Obtener el proveedor de la compra
                if (proveedor != null) {
                    JOptionPane.showMessageDialog(
                            null,
                            "Detalles del Proveedor:\n\n"
                            + "ID de Compra: " + idCompra + "\n"
                            + "Proveedor: " + proveedor ,
                            "Detalles del Proveedor",
                            JOptionPane.INFORMATION_MESSAGE
                    );
                } else {
                    JOptionPane.showMessageDialog(null, "Proveedor no encontrado", "Error", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Compra no encontrada", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jtComprasMouseClicked

    private void jbEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbEliminarActionPerformed
        int filaSeleccionada = jtCompras.getSelectedRow(); // funciona
        if (filaSeleccionada != -1) {
            int idCompra = (int) modelo.getValueAt(filaSeleccionada, 0); // Suponiendo que la columna 0 contiene el ID de la compra

            modelo.removeRow(filaSeleccionada);

            CompraData compData = new CompraData();
            compData.borrarCompraPorCompra(idCompra);

            JOptionPane.showMessageDialog(this, "Compra eliminada correctamente.", "Eliminación exitosa", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Selecciona una fila para eliminar.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jbEliminarActionPerformed

    private void actualizarTabla(boolean esActivo) {
       
        limpiarTabla();

        // Obtener la lista de proveedores según el estado seleccionado
        ArrayList<Compra> listarCompras = esActivo ? compData.listarComprasActivas() : compData.listarComprasInactivas();

        // Agregar filas a la tabla
        for (Compra compra : listarCompras) {
            modelo.addRow(new Object[]{
                compra.getIdCompra(),
                compra.getProveedor(),
                compra.getFecha(),
                
            });
        }
    }
    
    private void jrbComprasActivasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbComprasActivasActionPerformed
        if (jrbComprasActivas.isSelected()) {
        actualizarTabla(true); // Actualizar tabla con compras activas
    }
    }//GEN-LAST:event_jrbComprasActivasActionPerformed

    private void jrbComprasNoActivasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbComprasNoActivasActionPerformed
        if (jrbComprasNoActivas.isSelected()) {
        actualizarTabla(false); // Actualizar tabla con compras inactivas
    }
    }//GEN-LAST:event_jrbComprasNoActivasActionPerformed

    private void jbActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbActualizarActionPerformed

        if (jrbComprasActivas.isSelected()) {

            actualizarTabla(true);
        } else if (jrbComprasNoActivas.isSelected()) {

            actualizarTabla(false);
        }
        limpiarTabla();
    }//GEN-LAST:event_jbActualizarActionPerformed

    private void jbSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbSalirActionPerformed
        dispose();
         
    }//GEN-LAST:event_jbSalirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbActualizar;
    private javax.swing.JButton jbBuscar;
    private javax.swing.JButton jbEliminar;
    private javax.swing.JButton jbSalir;
    private com.toedter.calendar.JDateChooser jdcFechaFinal;
    private com.toedter.calendar.JDateChooser jdcFechaInicio;
    private javax.swing.JRadioButton jrbComprasActivas;
    private javax.swing.JRadioButton jrbComprasNoActivas;
    private javax.swing.JTable jtCompras;
    // End of variables declaration//GEN-END:variables
}
