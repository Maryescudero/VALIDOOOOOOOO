/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provemax_2;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import provemax_2.accesoDatos.CompraData;
import provemax_2.accesoDatos.DetalleCompraData;
import provemax_2.accesoDatos.ProductoData;
import provemax_2.accesoDatos.ProveedorData;
import provemax_2.entidades.Compra;
import provemax_2.entidades.DetalleCompra;
import provemax_2.entidades.Producto;
import provemax_2.entidades.Proveedor;

/**
 *
 * @author Usuario
 */
public class ProveMax_2 {

   
    public static void main(String[] args) {
        
    
        // Trabajamos con la tabla productos
     
//        Producto Televisor = new Producto("Televisor Sony ", "Ultra HD 50 pulgadas ", 280000.00, 18, true, 3);
       ProductoData product = new ProductoData();
//        product.modificarProducto(Televisor);
//       product.guardarProducto(Televisor);

      Producto productoEnco= product.buscarProductoPorId(4); 
        System.out.println("nombre "+ productoEnco.toString()); 

//        Producto productoEnco = product.buscarProductosPorNombre("lavarropas Whirpool");
//        if (productoEnco != null) {
//            System.out.println("nombre " + productoEnco.toString());
//        }    else{
//            System.out.println("No se encontro proveedor con ese codigo");
//        }

//        product.cambiarEstadoDeProducto(2);
//        System.out.println( " nombre " + productoEnco.toString() + "  Se da de baja al producto por falta de stock ");


//        ProductoData product = new ProductoData();
//        for (Producto producto :product.listarProductos()) {
//            System.out.println(" Id del producto : " + producto.getIdProducto());
//            System.out.println(" Nombre el producto: " + producto.getNombreProducto());
//            System.out.println(" Descripcion del producto: " + producto.getDescripcion());
//            System.out.println(" Precio actual del producto  : " + producto.getPrecioActual());
//            System.out.println(" Stock del producto : " + producto.getStock());
//              System.out.println(" Stock minimo del producto : " + producto.getStockMinimo());
//            System.out.println("-------------------------------------------------------------------");
//        }



//              ProductoData produ = new ProductoData();
//           produ.eliminarProductoId(1);
//           if (produ != null) {
//               System.out.println("El producto ha sido dado de baja correctamente");
//           }





//                 -----trabajamos con PROVEEDOR-----


//      Proveedor prove = new Proveedor("Get-Shop", "San Martin 1500 ","266465478", true,823678f);
//      ProveedorData proData = new ProveedorData();  //agrego proveedor
//      proData.guardarProveedor(prove); ProductoData product = new ProductoData();
//        for (Producto producto :product.listarProductosDeBaja()) {
//            System.out.println(" Id del producto : " + producto.getIdProducto());
//            System.out.println(" Nombre el producto: " + producto.getNombreProducto());
//            System.out.println(" Descripcion del producto: " + producto.getDescripcion());
//            System.out.println(" Precio actual del producto  : " + producto.getPrecioActual());
//            System.out.println(" Stock del producto : " + producto.getStock());
//              System.out.println(" Stock minimo del producto : " + producto.getStockMinimo());
//            System.out.println("-------------------------------------------------------------------");
//        }
//      System.out.println("Se agrego el siguiente proveedor  : " + prove.toString());
//        
//
//        ProveedorData prove = new ProveedorData();  // busco prov por id
//        Proveedor proveEnco= prove.buscarProveedorPorId(7);
//        if (proveEnco != null) {
//        System.out.println("nombre "+ proveEnco.toString());    
//        }else{
//            System.out.println("No se encontro proveedor con ese codigo");
//        }
        
//           ProveedorData prove = new ProveedorData(); // busco prov por nombre
//        Proveedor proveEnco= prove.buscarProveedorPorNombre("Ribeiro");
//        if (proveEnco != null) {
//        System.out.println("nombre "+ proveEnco.toString());    
//        }else{
//            System.out.println("No se encontro proveedor con ese Nombre");
//        }


//        Proveedor prove = new Proveedor(8 , "Niki-Niki", "San Martin 800 ","266548943", true,74556f);
//        ProveedorData proData = new ProveedorData();
//       proData.modificarProveedor(prove); // modifico proveedor
//
//        if (prove!=null) {
//
//            System.out.println("Proveedor modificado correctamente");
//        }
//        }
// 

//           ProveedorData prove = new ProveedorData();
//           prove.eliminarProveedorId(2);
//           if (prove != null) {
//               System.out.println("El provedor ha sido dado de baja correctamente");
//           }
           

//           ProveedorData prove = new ProveedorData();  // ver esta funcion
//           Proveedor prov = new Proveedor(2, "Easy", "España 234" , "2345678", true, 345678);
//           prove.eliminarProveedor(prov);
//           if (prov != null) {
//               System.out.println("Proveedor dado de baja correctamente"); 
//        }

//        ProveedorData proveedor = new ProveedorData();
//        for (Proveedor prove : proveedor.listarProveedores()) {
//            System.out.println(" Id del proveedor : " + prove.getIdProveedor());
//            System.out.println(" Razon Social : " + prove.getRazonSocial());
//            System.out.println(" Domicilio : " + prove.getDomicilio());
//            System.out.println(" Telefono  : " + prove.getTelefono());
//  
//            System.out.println("-------------------------------------------------------------------");
//        }

//        ProveedorData proveedor = new ProveedorData();
//        for (Proveedor prove : proveedor.listarProveedoresInactivos()) {
//            System.out.println(" Id del proveedor : " + prove.getIdProveedor());
//            System.out.println(" Razon Social : " + prove.getRazonSocial());
//            System.out.println(" Domicilio : " + prove.getDomicilio());
//            System.out.println(" Telefono  : " + prove.getTelefono());
//
//            System.out.println("-------------------------------------------------------------------");
//        }

//------------------------ Trabajamos con la tabla compra-------------


//            CompraData com = new CompraData();  // cargo compra
//            ProveedorData proData = new ProveedorData();
//            Proveedor provEnco = proData.buscarProveedorPorId(16);
//            Compra nueva = new Compra(provEnco,LocalDate.now(),true);
////            nueva.setProveedor (prov);
////            nueva.setFecha(LocalDate.now());
////            nueva.isEstado();
//            com.agregarCompra(nueva);



//              CompraData comp = new CompraData(); // lista compras activas
//              Proveedor prov = new Proveedor();
//        for (Compra com : comp.listarComprasActivas()) {
//            System.out.println(" Id de compra : " + com.getIdCompra());
//            System.out.println(" Proveedor : " + com.getProveedor());
//            System.out.println(" Fecha de compra  : " + com.getFecha());
//            System.out.println("-------------------------------------------------------------------");
//        }
        
        
//              CompraData comp = new CompraData(); // lista compra inactivas
//              Proveedor prov = new Proveedor();
//        for (Compra com : comp.listarComprasInactivas()) {
//            System.out.println(" Id de compra : " + com.getIdCompra());
//            System.out.println(" Proveedor : " + com.getProveedor());
//            System.out.println(" Fecha de compra  : " + com.getFecha());
//            System.out.println("-------------------------------------------------------------------");
//        }

//             CompraData comp = new CompraData(); // borro compra
//             comp.borrarCompra(1);
//       


//
//        CompraData comData = new CompraData();  //busco compra por id
//        int idCompraABuscar = 3; 
//        Compra compraEncontrada = comData.buscarCompra(idCompraABuscar);
//        if (compraEncontrada != null) {
//            System.out.println("ID de compra: " + compraEncontrada.getIdCompra());
//            System.out.println("ID de Proveedor: " + compraEncontrada.getProveedor().getIdProveedor());
//            System.out.println("Fecha de Compra : " + compraEncontrada.getFecha());
//            
//        } else {
//            
//            JOptionPane.showMessageDialog(null,"Compra no encontrada");
//        }
//    
    
    
    
//----------------------TRABAJAMOS CON LA CLASE DETALLECOMPRADATA---------------
            
//        DetalleCompra detalle = new DetalleCompra(); // modifico precio costo
//        DetalleCompraData detaData = new DetalleCompraData();
//        detaData.modificarPrecioCosto(2, 5, 250000);
//        if (detalle!=null) {
//            System.out.println("Se modifico correctamente el precio costo ");  
//        }


//        CompraData comData = new CompraData();   // busco detalle
//        ProductoData prodData = new ProductoData();
//        DetalleCompraData detaData = new DetalleCompraData();
//        Producto producto = new Producto();
//        Compra compra = comData.buscarCompra(2); 
//
//        if (compra != null) {
//            // La compra existe, ahora puedes crear el detalle de compra
//            DetalleCompra detalle = new DetalleCompra(15, 100000, compra, producto);
//            detaData.guardarDetalleCompra(detalle);
//            System.out.println("Detalle guardado correctamente");
//        } else {
//            System.out.println("La compra no se encontró, no se puede guardar el detalle de compra.");
//        }

          
          
//          DetalleCompra detalle = new DetalleCompra(15, 100000, compra, producto);
//          DetalleCompraData detaData = new DetalleCompraData();
//          detaData.guardarDetalleCompra(detalle);
//          if (detalle!=null) {
//              System.out.println("Detalle guardado correctamente");
//            
//        } 
//          
//        CompraData comData = new CompraData();  //lista detalle de compra
//        ProveedorData provData = new ProveedorData();
//        DetalleCompraData detaData = new DetalleCompraData();
//        Compra compra = new Compra();
//        for (DetalleCompra deta : detaData.listarDetallePorCompra()) {
//            System.out.println("Id de detalle de compra : " + deta.getIdDetalle());
//            System.out.println("Cantidad  : " + deta.getCantidad());
//            System.out.println("Precio de  Costo: " + deta.getPrecioCosto());
//            System.out.println("Id de compra: " + deta.getCompra().getIdCompra());
//            System.out.println("Id de producto: " + deta.getProducto().getIdProducto());
//            System.out.println("------------------------------------------------------------------------------");
//        }
//          
  

//        DetalleCompraData detaData = new DetalleCompraData();
//        DetalleCompra detalle = new DetalleCompra();
//        ProductoData proData = new ProductoData();
//        CompraData com = new CompraData();
//        Producto provEnco = proData.buscarProductoPorId(1);
//        Compra nueva = com.buscarCompra(1);
//        detaData.guardarDetalleCompra(detalle);
//        if (detalle != null) {
//            System.out.println("Detalle guardado correctamente");
//        }

    }
}




