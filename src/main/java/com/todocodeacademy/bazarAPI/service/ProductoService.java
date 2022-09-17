
package com.todocodeacademy.bazarAPI.service;

import com.todocodeacademy.bazarAPI.dto.ProductoDTO;
import com.todocodeacademy.bazarAPI.mappers.ProductoMapper;
import com.todocodeacademy.bazarAPI.model.Producto;
import com.todocodeacademy.bazarAPI.repository.IProductoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService {

    @Autowired
    private IProductoRepository productoRepo;
    @Autowired
    private ProductoMapper productoMapper;
    
    @Override
    public void saveProducto(Producto producto) {
        productoRepo.save(producto);
    }

    @Override
    public void deleteProducto(Long codigo_producto) {
        productoRepo.deleteById(codigo_producto);
    }

    @Override
    public void updateProducto(Producto producto) {
         this.saveProducto(producto);
    }

    @Override
    public List<ProductoDTO> getProductos() {
        return productoMapper.productoList2ProductoDTOList(productoRepo.findAll());
    }

    @Override
    public ProductoDTO getProducto(Long codigo_producto) {
         return productoMapper.productoEntity2DTO(productoRepo.findById(codigo_producto).orElse(null));
    }

    @Override
    public List<ProductoDTO> getProductosFaltaStock() {
       List<ProductoDTO>listaProductosFaltaStock=new ArrayList<>();
       List<ProductoDTO>listaProductos=this.getProductos();
       int i=0;
       while (i<listaProductos.size())
       {
           if (listaProductos.get(i).getCantidad_disponible()<5)
               listaProductosFaltaStock.add(listaProductos.get(i));
           i++;
       }
       return listaProductosFaltaStock;
    }

    
    
}
