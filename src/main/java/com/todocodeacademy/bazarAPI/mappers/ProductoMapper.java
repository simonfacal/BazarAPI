
package com.todocodeacademy.bazarAPI.mappers;

import com.todocodeacademy.bazarAPI.dto.ProductoDTO;
import com.todocodeacademy.bazarAPI.model.Producto;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class ProductoMapper {
    
    public ProductoDTO productoEntity2DTO(Producto entity)
    {
        ProductoDTO dto=new ProductoDTO();
        dto.setCodigo_producto(entity.getCodigo_producto());
        dto.setCantidad_disponible(entity.getCantidad_disponible());
        dto.setMarca(entity.getMarca());
        dto.setCosto(entity.getCosto());
        dto.setNombre(entity.getNombre());
        
        return dto;     
        
    }
    
    public List<ProductoDTO> productoList2ProductoDTOList(List<Producto> productoList)
    {
       List<ProductoDTO> productoDTOList=new ArrayList<>();
        
       for (int i=0;i<productoList.size();i++)
        {
            productoDTOList.add(this.productoEntity2DTO(productoList.get(i)));
        }
        
        return productoDTOList;
    }
    
}
