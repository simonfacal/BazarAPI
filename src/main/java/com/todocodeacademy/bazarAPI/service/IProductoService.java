
package com.todocodeacademy.bazarAPI.service;

import com.todocodeacademy.bazarAPI.dto.ProductoDTO;
import com.todocodeacademy.bazarAPI.model.Producto;
import java.util.List;


public interface IProductoService {
    
    //crear
    public void saveProducto(Producto producto);
    //eliminar
    public void deleteProducto(Long codigo_producto);
    //modificacion
    
    public void updateProducto(Producto producto);
    //traer lista completa
    public List<ProductoDTO> getProductos();
    //traer elemento particular
    public ProductoDTO getProducto(Long codigo_producto);
    //traer producto con disponibilidad menor a 5
    public List<ProductoDTO>getProductosFaltaStock();
    
    
}
