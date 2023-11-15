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
import provemax_2.entidades.Proveedor;

/**
 *
 * @author Usuario
 */
public class ProveedorData {
    private Connection con = null;

    public ProveedorData() {
        con = Conexion.getConexion();
    }
   
    
       public void guardarProveedor(Proveedor proveedor){  // agregamos proveedor 
       String sql= " INSERT INTO proveedor(cuit, razonSocial, domicilio, telefono, estado) " 
               + " VALUES(?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps= con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setFloat(1, proveedor.getCuit());
            ps.setString(2, proveedor.getRazonSocial());
            ps.setString(3, proveedor.getDomicilio());
            ps.setString(4, proveedor.getTelefono());
            ps.setBoolean(5,proveedor.isEstado());
            ps.executeUpdate();
            ResultSet rs= ps.getGeneratedKeys();
            if (rs.next()) {
                proveedor.setIdProveedor(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Proveedor agregado exitosamente");
                 }
            ps.close();
        
        }catch (SQLException ex){
            JOptionPane.showMessageDialog(null,"Cuit ya utilizado, ingrese uno nuevo");
        }
   }
      
      
        public Proveedor buscarProveedorPorId(int id){  // Productos por id
        String sql= " SELECT cuit,razonSocial, domicilio, telefono "
                + " FROM proveedor WHERE idProveedor = ? AND estado = 1 ";
        Proveedor proveedor = null;
         try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                proveedor= new Proveedor();
                proveedor.setIdProveedor(id);
                proveedor.setCuit(rs.getFloat("cuit"));
                proveedor.setRazonSocial(rs.getString("razonSocial"));
                proveedor.setDomicilio(rs.getString("domicilio"));
                proveedor.setTelefono(rs.getString("telefono"));
                proveedor.setEstado(true);
            }else{
                JOptionPane.showMessageDialog(null,"Proveedoro No encontrado, o inactivo ");
                ps.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla Proveedor"+ ex);
        }
        
        return proveedor;
    }
        
       
       public Proveedor buscarProveedorPorNombre(String nombre){  // Proveedor por nombre
        String sql= "SELECT idProveedor,cuit,domicilio,telefono "
                + " FROM proveedor WHERE razonSocial= ? AND estado = 1";
        Proveedor proveedor = null;
         try {
            PreparedStatement ps= con.prepareStatement(sql);
            ps.setString(1, nombre);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                proveedor= new Proveedor();
                proveedor.setRazonSocial(nombre);
               proveedor.setIdProveedor(rs.getInt("idProveedor"));
               proveedor.setCuit(rs.getFloat("cuit"));
                proveedor.setDomicilio(rs.getString("domicilio"));
                proveedor.setTelefono(rs.getString("telefono"));
               
                proveedor.setEstado(true);
            }else{
//                JOptionPane.showMessageDialog(null,"Proveedor No encontrado");
                ps.close();
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla Proveedor");
        }
         
        return proveedor;
    }
     
    
    
    public void modificarProveedor(Proveedor proveedor){ //modifico proveedor sentencia update
       String sql= " UPDATE proveedor SET cuit=?,razonSocial =?,domicilio =?, telefono =?,estado =? "
               + " WHERE idProveedor=?";
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setFloat(1, proveedor.getCuit());
            ps.setString(2, proveedor.getRazonSocial());
            ps.setString(3,proveedor.getDomicilio());
            ps.setString(4,proveedor.getTelefono());
            ps.setBoolean(5,true);
            ps.setInt(6,proveedor.getIdProveedor());
            
            int modificado=ps.executeUpdate();
           
            if (modificado == 1) {
                JOptionPane.showMessageDialog(null,"proveedor modificado");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla proveedor" + ex.getMessage());
        }
   }
     public void eliminarProveedor(Proveedor proveedor){ // elimino proveedor sentencia update
       String sql= " UPDATE proveedor SET estado = 0 WHERE idProveedor= ? ";
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setInt(1, proveedor.getIdProveedor());
            int modificado=ps.executeUpdate();
           
            if (modificado >0) {
                JOptionPane.showMessageDialog(null,"proveedor inactivo");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla proveedor" + ex.getMessage());
        }
   }
       public void eliminarProveedorId(int id){ // elimino proveedor sentencia update
       String sql= " UPDATE proveedor SET estado = 0 WHERE idProveedor = ? ";
        try {
            PreparedStatement ps= con.prepareStatement(sql);
            
            ps.setInt(1, id );
            int modificado=ps.executeUpdate();
           
            if (modificado == 1) {
                JOptionPane.showMessageDialog(null,"Proveedor inactivo");
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a tabla proveedor" + ex.getMessage());
        }
      }
       
       
       public ArrayList<Proveedor>listarProveedores(){ // listar productos activos 
        
         String sql= "SELECT idProveedor ,cuit,razonSocial,domicilio,telefono,estado  FROM proveedor WHERE  estado = 1";
        ArrayList<Proveedor> proveedor = new ArrayList<>();
   
        try {
                 
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            Proveedor proveedor1 = new Proveedor();
            proveedor1.setIdProveedor(rs.getInt("idProveedor"));
            proveedor1.setCuit(rs.getFloat("cuit"));
            proveedor1.setRazonSocial(rs.getString("RazonSocial"));
            proveedor1.setDomicilio(rs.getString("domicilio"));
            proveedor1.setTelefono(rs.getString("telefono"));
            proveedor1.setEstado(true);
            proveedor.add(proveedor1);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null ,"Error al conectar con la tabla proveedor");
        }
        return proveedor;
    }
       
       public ArrayList<Proveedor>listarProveedoresInactivos(){ // listar productos activos 
        
         String sql= "SELECT idProveedor ,cuit,razonSocial,domicilio,telefono,estado  FROM proveedor WHERE  estado = 0 ";
        ArrayList<Proveedor> proveedor = new ArrayList<>();
   
        try {
                 
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
            Proveedor proveedor1 = new Proveedor();
            proveedor1.setIdProveedor(rs.getInt("idProveedor"));
            proveedor1.setCuit(rs.getFloat("cuit"));
            proveedor1.setRazonSocial(rs.getString("RazonSocial"));
            proveedor1.setDomicilio(rs.getString("domicilio"));
            proveedor1.setTelefono(rs.getString("telefono"));
            proveedor1.setEstado(true);
            proveedor.add(proveedor1);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null ,"Error al conectar con la tabla proveedor");
        }
        return proveedor;
            
      
        
    }
}
