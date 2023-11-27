/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provemax_2.accesoDatos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import provemax_2.entidades.Compra;
import provemax_2.entidades.Proveedor;


public class CompraData {
    
    private ProductoData prodData = new ProductoData();
    private ProveedorData provData= new ProveedorData();
    
    
     private Connection con = null;

    public CompraData() {
        con = Conexion.getConexion();
    }
    
    
    public void agregarCompra(Compra compra){ // funciona
        
         String sql= " INSERT INTO compra (idProveedor, fecha, estado) " 
               + " VALUES(?, ?, ?)";
        try {

            PreparedStatement ps= con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1,compra.getProveedor().getIdProveedor());
            ps.setDate(2, java.sql.Date.valueOf(compra.getFecha()));
            ps.setBoolean(3, true);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            
            if (rs.next()) {
                int generatedId = rs.getInt(1);
                compra.setIdCompra(generatedId);
                JOptionPane.showMessageDialog(null, "Compra  agregada exitosamente con ID : " + generatedId);
                 }
            ps.close();
            
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla Compra" + ex.getMessage());
        
        }
        
   }
       public Compra buscarCompra(int idCompra) { // funciona
        Compra compra = null;
        String sql = "SELECT * FROM compra WHERE idCompra = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idCompra);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                compra = new Compra();
                compra.setIdCompra(rs.getInt("idCompra"));
                Proveedor prov = provData.buscarProveedorPorId(rs.getInt("idProveedor"));
                compra.setProveedor(prov);
                compra.setFecha(rs.getDate("fecha").toLocalDate());
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al buscar compra: " + ex.getMessage());
        }
        return compra;
    }
    
       public void borrarCompraPorCompra(int idCompra) {
    String sql = "UPDATE compra SET estado = 0 WHERE idCompra = ?";
    try {
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setInt(1, idCompra);
        int borrado = ps.executeUpdate();
        if (borrado != 0) {
            JOptionPane.showMessageDialog(null, "Compra borrada");
        }
        ps.close();
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al ingresar a la tabla compra " + ex.getMessage());
    }
       }
       
    
      public ArrayList<Compra> listarComprasActivas(){ // funciona
         String sql = "SELECT idCompra, idProveedor,fecha, estado FROM compra WHERE estado = 1";
        ArrayList<Compra> compras = new ArrayList<>();
        Compra compra = null;
        try {
            PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                compra = new Compra();
                compra.setIdCompra(rs.getInt("idCompra"));
                 Proveedor prov= provData.buscarProveedorPorId(rs.getInt("idProveedor"));
                compra.setProveedor(prov);
                compra.setFecha(rs.getDate("fecha").toLocalDate());
                compra.setEstado(true);
                compras.add(compra);
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la tabla" + ex.getMessage());
        }
        return compras;
    }
      

      public ArrayList<Compra> listarComprasInactivas() {
    String sql = "SELECT idCompra, idProveedor, fecha FROM compra WHERE estado = 0";
    ArrayList<Compra> compras = new ArrayList<>();
    
    try (PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {
            Compra compra = new Compra();
            compra.setIdCompra(rs.getInt("idCompra"));
            
            // Obtener el proveedor de la compra
            int idProveedor = rs.getInt("idProveedor");
            Proveedor prov = provData.buscarProveedorPorId(idProveedor);
            
            if (prov != null) {
                compra.setProveedor(prov);
            } else {
                // Manejar el caso en que no se encuentre el proveedor
                // Puedes setear un proveedor "predeterminado" o manejarlo de otra manera
            }

            compra.setFecha(rs.getDate("fecha").toLocalDate());
            compra.setEstado(false); // buscando compras inactivas

            compras.add(compra);
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error al acceder a la tabla: " + ex.getMessage());
    }
    return compras;
}

       
        public void borrarCompra(int idProveedor){  // funciona
        String sql = "UPDATE compra SET estado = 0  WHERE idProveedor=?";
         try {
             PreparedStatement ps = con.prepareStatement(sql);
             ps.setInt(1, idProveedor);
             int borrado = ps.executeUpdate();
             if (borrado!=0) {
                 JOptionPane.showMessageDialog(null,"Compra borrada");
             }
             ps.close();
         } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"Error al ingresar a la tabla compra " + ex.getMessage()); 
         }
        }
        
    public ArrayList<Compra> obtenerComprasPorRangoFecha(LocalDate fechaInicio, LocalDate fechaFinal) {
        ArrayList<Compra> comprasEnRango = new ArrayList<>();
        String sql = "SELECT * FROM compra WHERE fecha BETWEEN ? AND ?";

        try (PreparedStatement statement = con.prepareStatement(sql)) {
            statement.setDate(1, java.sql.Date.valueOf(fechaInicio));
            statement.setDate(2, java.sql.Date.valueOf(fechaFinal));

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int idCompra = resultSet.getInt("idCompra");
                int idProveedor = resultSet.getInt("idProveedor");
                LocalDate fecha = resultSet.getDate("fecha").toLocalDate();
                boolean estado = resultSet.getBoolean("estado");

                // obtener el objeto Proveedor 
                Proveedor proveedor = provData.buscarProveedorPorId(idCompra);

                //  creas un objeto Compra con los datos obtenidos
                Compra compra = new Compra(idCompra, proveedor, fecha, estado);
                comprasEnRango.add(compra);
            }
            }catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al conectar con la tabla compra: " + e.getMessage());
       
    }

            return comprasEnRango;
        }
    
    
    public void actualizarFechaCompra(Compra compra) {
        
        String sql= "UPDATE compra SET fecha = ? WHERE idCompra = ?";
        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setDate(1, java.sql.Date.valueOf(compra.getFecha())); 
            statement.setInt(2, compra.getIdCompra());
            statement.executeUpdate();
        } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Error al conectar con la tabla compra: " + e.getMessage());
           
        }
    }
    
}



    
     

