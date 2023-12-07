/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provemax_2.accesoDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import provemax_2.entidades.Compra;
import provemax_2.entidades.DetalleCompra;
import provemax_2.entidades.Producto;

/**
 *
 * @author Usuario
 */
public class DetalleCompraData {
    
    private CompraData comData = new CompraData();
    private ProveedorData provData = new ProveedorData();
    private ProductoData prodData = new ProductoData();
    
     private Connection con = null;
  
    public DetalleCompraData() {
        con = Conexion.getConexion();
              
    }
      
     public ArrayList<DetalleCompra> buscarDetallePorCompra(Compra compra){
        String sql= " SELECT idDetalle, cantidad, precioCosto , idProducto, idCompra * FROM detalleCompra WHERE idCompra  = 0";
        ArrayList<DetalleCompra> detalles= new ArrayList<>();
       try{
          PreparedStatement ps= con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
          ps.setInt(1,compra.getIdCompra());
          
          ResultSet rs=ps.executeQuery();
          DetalleCompra detaCompra;
          Producto produc;
         while(rs.next()){
           produc = prodData.buscarProductoPorId(rs.getInt("idProducto")); 
           detaCompra = new DetalleCompra(rs.getInt("idDetalleCompra"),
                                         rs.getInt("cantidad"),
                                         rs.getDouble("precioCosto"),
                                        compra,produc);
           detalles.add(detaCompra);
           
           
           }
         
           ps.close();
         
       }  catch (SQLException ex) {
                JOptionPane.showMessageDialog(null,"error al acceder a la tabla" + ex.getMessage());
    }
   
    return detalles;
}
 
    public void guardarDetalleCompra(DetalleCompra detCom){
        String sql = " INSERT INTO detalleCompra (cantidad,precioCosto, idCompra,idProducto)"
                + " VALUES (?,?,?,?) ";
         try {
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
             ps.setInt(1, detCom.getCantidad());
             ps.setDouble(2, detCom.getPrecioCosto());
             ps.setInt(3, detCom.getCompra().getIdCompra());
             ps.setInt(4, detCom.getProducto().getIdProducto());
             ps.executeUpdate();
             ResultSet rs = ps.getGeneratedKeys();
             if (rs.next()) {
                 detCom.setIdDetalle(rs.getInt(1));
                 JOptionPane.showMessageDialog(null, "Detalle de compra Guardado CORRECTAMENTE");
             }
            ps.close();
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Error al conectar con tabla de detalleCompra" + ex.getMessage());
         }
    }
    
      public void modificarPrecioCosto(int idCompra, int idProducto, double precioCosto){ // funciona
        String sql= " UPDATE detalleCompra  SET precioCosto =? "
               + " WHERE idCompra=? AND idProducto=? ";
         try {
             PreparedStatement ps= con.prepareStatement(sql);
             ps.setDouble(1,precioCosto);
             ps.setInt(2, idCompra);
             ps.setInt(3, idProducto);
              int modificado=ps.executeUpdate();
            if (modificado>0) {
                JOptionPane.showMessageDialog(null,"Precio Costo modificado");
            }
            ps.close();
         } catch (SQLException ex) {
             JOptionPane.showMessageDialog(null,"Error al ingresar a la tabla detalleCompra " + ex.getMessage());
         }
      }
    
    public void eliminar(int idDetalle) {
       String sql =  " DELETE FROM detalleCompra WHERE idDetalle = ? ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idDetalle);

            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Detalle de compra eliminado exitosamente");
            } else {
                System.out.println("No se encontró el detalle de compra con ID: " + idDetalle);
            }

            ps.close();
        } catch (SQLException ex) {
            System.out.println("Error al eliminar el detalle de compra: " + ex.getMessage());
            ex.printStackTrace();
        }

    }

    public DetalleCompra buscarDetalleCompraPorId(int idDetalleCompra) {
    String sql = "SELECT * FROM detalleCompra WHERE idDetalle = ?";
    DetalleCompra detalleCompra = null;

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idDetalleCompra);
        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            // Obtener los datos del detalle de compra y crear un objeto DetalleCompra
            int cantidad = rs.getInt("cantidad");
            double precioCosto = rs.getDouble("precioCosto");
            // Obtener la compra y el producto asociados al detalle de compra
            int idCompra = rs.getInt("idCompra");
            Compra compra = comData.buscarCompra(idCompra); // Suponiendo que compData es una instancia de CompraData
            int idProducto = rs.getInt("idProducto");
            Producto producto = prodData.buscarProductoPorId(idProducto); // Suponiendo que productoData es una instancia de ProductoData

            detalleCompra = new DetalleCompra(cantidad, precioCosto, compra, producto);
            detalleCompra.setIdDetalle(idDetalleCompra);
        }
         ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla: " + ex.getMessage());
    }

    return detalleCompra;
}
    
}
      
     
