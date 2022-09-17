
package com.todocodeacademy.bazarAPI.mappers;

import com.todocodeacademy.bazarAPI.dto.ProductoDTO;
import com.todocodeacademy.bazarAPI.dto.VentaDTO;
import com.todocodeacademy.bazarAPI.model.Venta;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class VentaMapper {
    
    @Autowired
    private ProductoMapper productoMapper;
    
    
    public VentaDTO ventaEntity2DTO(Venta entity)
    {
       VentaDTO dto=new VentaDTO();
       dto.setCodigo_venta(entity.getCodigo_venta());
       dto.setFecha_venta(entity.getFecha_venta());
       dto.setTotal(entity.getTotal());
       dto.setUnCliente(entity.getUnCliente());
       List<ProductoDTO> productosDTO=productoMapper.productoList2ProductoDTOList(entity.getListaProductos());
       dto.setListaProductos(productosDTO); 
       return dto;
        
    }
    
    public List<VentaDTO> ventaList2VentaDTOList(List<Venta> ventas)
    {
        List<VentaDTO> ventasDTO=new ArrayList<>();
        for (int i=0;i<ventas.size();i++)
        {
            ventasDTO.add(this.ventaEntity2DTO(ventas.get(i)));
        }
        
        return ventasDTO;
    }
    
    
    
}
