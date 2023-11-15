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
import provemax_2.entidades.Producto;

/**
 *
 * @author Usuario
 */
public class ProductoData {
    
    private Connection con = null;

    public ProductoData() {
        con = Conexion.getConexion();
    }
    
    
    
   public void guardarProducto(Producto producto){  // GUARDAMOS PRODUCTOS
       String sql= " INSERT INTO producto(nombreProducto,descripcion,precioActual,stock,stockMinimo,estado) " 
               + " VALUES(?,?,?,?,?,?)";
        try {
            PreparedStatement ps= con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, producto.getNombreProducto());
            ps.setString(2, producto.getDescripcion());
            ps.setDouble(3,producto.getPrecioActual());
            ps.setInt(4, producto.getStock());
            ps.setInt(5, producto.getStockMinimo());
            ps.setBoolean(6,producto.isEstado());
            ps.executeUpdate();
            ResultSet rs= ps.getGeneratedKeys();
            if (rs.next()) {
                producto.setIdProducto(rs.getInt(1));
                if (producto.getStock() < 3) {
                JOptionPane.showMessageDialog(null, "El producto tiene un stock menor a 3", "Alerta de Stock", JOptionPane.WARNING_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Producto agregado exitosamente");
            }
                
             JOptionPane.showMessageDialog(null,"Producto agregado exitosamente");
                
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla Producto" + ex.getMessage());
        }
   }
   
   public Producto buscarProductoPorId(int id){  // busqueda Productos por id
        String sql= " SELECT nombreProducto, descripcion, precioActual, stock,stockMinimo "
                + " FROM producto WHERE idProducto = ? AND estado = 1 ";
        Producto producto = null;
         try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                producto= new Producto();
                producto.setIdProducto(id);
                producto.setNombreProducto(rs.getString("nombreProducto"));
                producto.setDescripcion(rs.getString("descripcion"));
                
                producto.setPrecioActual(rs.getDouble("precioActual"));
                producto.setStock(rs.getInt("stock"));
                producto.setEstado(true);
                producto.setStockMinimo(rs.getInt("stockMinimo"));
            }else{
                JOptionPane.showMessageDialog(null,"Producto No encontrado");
                ps.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla Producto"+ ex.getMessage());
        }
        
        return producto;
    }
   public Producto buscarProductosPorNombre(String nombre){  // busqueda Productos por nombre
        String sql= "SELECT idProducto,descripcion, precioActual, precioActual,stock, stockMinimo "
                + " FROM producto WHERE nombreProducto= ? AND estado = 1";
        Producto producto = null;
         try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                producto= new Producto();
                producto.setNombreProducto(nombre);
                producto.setIdProducto(rs.getInt("idProducto"));
                producto.setDescripcion(rs.getString("descripcion"));
                producto.setPrecioActual(rs.getDouble("precioActual"));
                producto.setStock(rs.getInt("stock"));
                producto.setStockMinimo(rs.getInt("stockMinimo"));
                producto.setEstado(true);
            }else{
                JOptionPane.showMessageDialog(null,"Producto No encontrado, No hay stock");
                ps.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla producto" + ex.getMessage());
        }
        
        return producto;
    }
  
   public void modificarProducto(Producto producto){
      
      String sql=" UPDATE producto SET nombreProducto = ?,descripcion = ?, precioActual = ?, stock = ?  , stockMinimo = ? "
              + " WHERE idProducto =? ";
        
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setString(1,producto.getNombreProducto());
            ps.setString(2,producto.getDescripcion());
            ps.setDouble(3, producto.getPrecioActual());
            ps.setInt(4, producto.getStock());
            ps.setInt(5, producto.getStockMinimo());
           ps.setBoolean(6, true);
           ps.setInt(7,producto.getIdProducto());
           int exito= ps.executeUpdate();
            
            if(exito==1){
                JOptionPane.showMessageDialog(null,"producto modificado");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto" + ex.getMessage());
        }
  }
   
  public void cambiarEstadoDeProducto(int id){
      String sql = "UPDATE producto SET estado =0 WHERE idProducto = ? ";
      
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setInt(1, id);
           int exito= ps.executeUpdate();
           
           if(exito==1){
               JOptionPane.showMessageDialog(null,"Producto INACTIVO por falta de Stock ");
           }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al aceder a la tabla PRODUCTO " +ex.getMessage());
        }
  }
  
  public ArrayList<Producto>listarProductos(){ // listar productos activos 
        
         String sql= "SELECT idProducto,nombreProducto, descripcion, precioActual,stock,stockMinimo FROM producto WHERE  estado = 1";
        ArrayList<Producto> productos = new ArrayList<>();
        
       
        try {
            
            PreparedStatement ps  = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
             while (rs.next()) {
                    Producto producto = new Producto();
                    producto.setIdProducto(rs.getInt("idProducto"));
                    producto.setNombreProducto(rs.getString("nombreProducto"));
                    producto.setDescripcion(rs.getString("descripcion"));
                    producto.setPrecioActual(rs.getDouble("precioActual"));
                    producto.setStock(rs.getInt("stock"));
                    producto.setStockMinimo(rs.getInt("stockMinimo"));
                    producto.setEstado(true);
                    productos.add(producto);
                    
                }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla producto" + ex.getMessage());
        }
        return productos;
        
    }
    
   
       
        public ArrayList<Producto>listarProductosDeBaja(){ // productos dado de baja
        
         String sql= "SELECT idProducto,nombreProducto, descripcion, precioActual,stock,stockMinimo FROM producto WHERE  estado = 0";
        ArrayList<Producto> productos = new ArrayList<>();
        
       
        try {
            
            PreparedStatement ps  = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
             while (rs.next()) {
                    Producto producto = new Producto();
                    producto.setIdProducto(rs.getInt("idProducto"));
                    producto.setNombreProducto(rs.getString("nombreProducto"));
                    producto.setDescripcion(rs.getString("descripcion"));
                    producto.setPrecioActual(rs.getDouble("precioActual"));
                    producto.setStock(rs.getInt("stock"));
                    producto.setStockMinimo(rs.getInt("stockMinimo"));
                    producto.setEstado(true);
                    productos.add(producto);
                    
                }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla producto" + ex.getMessage());
        }
        return productos; 
    }
        
        
         public void eliminarProductoId(int id){ // elimino producto sentencia update
       String sql= " UPDATE producto SET estado = 0 where idProducto=? ";
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setInt(1,id);
            int modificado=ps.executeUpdate();
           
            if (modificado == 1) {
                JOptionPane.showMessageDialog(null,"producto Sin Stock");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla producto" + ex.getMessage());
        }
   }
}


