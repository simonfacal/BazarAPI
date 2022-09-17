
package com.todocodeacademy.bazarAPI.controller;

import com.todocodeacademy.bazarAPI.dto.ProductoDTO;
import com.todocodeacademy.bazarAPI.model.Producto;
import com.todocodeacademy.bazarAPI.service.IProductoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProductoController {
    
    @Autowired
    private IProductoService productoServ;
    
    //crear
    @PostMapping("/productos/crear")
    public void saveProducto(@RequestBody Producto producto)
    {
        productoServ.saveProducto(producto);
    }
    
    //eliminar
    @DeleteMapping("/productos/eliminar/{codigo_producto}")
    public void deleteProducto(@PathVariable Long codigo_producto)
    {
        productoServ.deleteProducto(codigo_producto);
    }
    
    //modificar
    @PutMapping("/productos/editar")
    public void updateProducto(@RequestBody Producto producto)
    {
      productoServ.updateProducto(producto); 
        
    }
   
    //traer lista completa
    @GetMapping("/productos")
    @ResponseBody
    public List<ProductoDTO> getProductos()
    {
        return productoServ.getProductos();
    }
    
    //traer elemento particular
    @GetMapping("/productos/{codigo_producto}")
    @ResponseBody
    public ProductoDTO getProducto(@PathVariable Long codigo_producto)
    {
        return productoServ.getProducto(codigo_producto);
    }
    
    //trae productos faltantes de stock
    @GetMapping("/productos/falta_stock")
    @ResponseBody
    public List<ProductoDTO> getProductosFaltaStock()
    {
        return productoServ.getProductosFaltaStock();
    }
    
    
}
