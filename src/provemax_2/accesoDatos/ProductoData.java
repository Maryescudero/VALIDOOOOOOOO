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
                int generatedId = rs.getInt(1);
                producto.setIdProducto(generatedId);
                if (producto.getStock() < 3) {
                    JOptionPane.showMessageDialog(null, "El producto tiene un stock menor a 3", "Alerta de Stock", JOptionPane.WARNING_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "Producto agregado exitosamente con ID : " + generatedId);
                }

                
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

 String sql = "SELECT idProducto, nombreProducto, descripcion, precioActual, stock, stockMinimo "
                + "FROM producto WHERE nombreProducto LIKE ? AND estado = 1";
        Producto producto = null;

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, "%" + nombre + "%");
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String nombreEncontrado = rs.getString("nombreProducto");
                    producto = new Producto();
                    producto.setNombreProducto(nombreEncontrado);
                    producto.setIdProducto(rs.getInt("idProducto"));
                    producto.setDescripcion(rs.getString("descripcion"));
                    producto.setPrecioActual(rs.getDouble("precioActual"));
                    producto.setStock(rs.getInt("stock"));
                    producto.setStockMinimo(rs.getInt("stockMinimo"));
                    producto.setEstado(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Producto no encontrado, no hay stock");
                }
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla producto: " + ex.getMessage());
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
           ps.setInt(6,producto.getIdProducto());
           int exito= ps.executeUpdate();
            
            if(exito==1){
                JOptionPane.showMessageDialog(null,"producto modificado");
            }
             ps.close();
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
            ps.close();
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
             ps.close();
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
              ps.close();
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla producto" + ex.getMessage());
        }
        return productos; 
    }
        
           public void eliminarProductoId(int id) { // elimino producto sentencia update
        String sql = " UPDATE producto SET estado = 0 where idProducto=? ";
        try {
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, id);
            int modificado = ps.executeUpdate();

            if (modificado == 1) {
                JOptionPane.showMessageDialog(null, "Eliminado");
            }
             ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla producto" + ex.getMessage());
        }
    }
           
           
    public void restarStockDespuesCompra(Producto producto, int cantidadComprada) {
        try {
            int stockActual = producto.getStock();
            int nuevoStock = stockActual + cantidadComprada;
            producto.setStock(nuevoStock);

            // Actualizar el stock en la base de datos
            String sql = "UPDATE producto SET stock = ? WHERE idProducto = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, nuevoStock);
            ps.setInt(2, producto.getIdProducto());

            int filasActualizadas = ps.executeUpdate();
            if (filasActualizadas > 0) {
                System.out.println("Stock actualizado para el producto con ID: " + producto.getIdProducto());
            } else {
                System.out.println("No se pudo actualizar el stock para el producto con ID: " + producto.getIdProducto());
            }

            ps.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error al actualizar el stock después de la compra: " + ex.getMessage());
        }
}     
    public boolean verificarStockSuficiente(Producto producto, int cantidadDeseada) {
        boolean suficienteStock = false;

        try {
            String sql = "SELECT stock FROM producto WHERE idProducto = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, producto.getIdProducto());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                int stockActual = rs.getInt("stock");
                if (stockActual >= cantidadDeseada) {
                    suficienteStock = true;
                }
            }

            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al verificar el stock: " + ex.getMessage());
        }

        return suficienteStock;
    }
    
    public ArrayList<Producto> listarProductosDeCompra(int idCompra) {
    String sql = "SELECT p.idProducto, p.nombreProducto, p.descripcion, p.precioActual, p.stock, p.stockMinimo " +
                 "FROM producto p " +
                 "INNER JOIN detallecompra dc ON p.idProducto = dc.idProducto " +
                 "WHERE dc.idCompra = ?";
    
    ArrayList<Producto> productos = new ArrayList<>();

    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idCompra); // Establecer el ID de la compra en la consulta SQL
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Producto producto = new Producto();
            producto.setIdProducto(rs.getInt("idProducto"));
            producto.setNombreProducto(rs.getString("nombreProducto"));
            producto.setDescripcion(rs.getString("descripcion"));
            producto.setPrecioActual(rs.getDouble("precioActual"));
            producto.setStock(rs.getInt("stock"));
            producto.setStockMinimo(rs.getInt("stockMinimo"));
            producto.setEstado(true); // Podrías establecer el estado del producto si lo necesitas
            productos.add(producto);
        }

        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al obtener productos de la compra: " + ex.getMessage());
    }

    return productos;
}
}



