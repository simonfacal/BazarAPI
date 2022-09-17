
package com.todocodeacademy.bazarAPI.service;

import com.todocodeacademy.bazarAPI.dto.ProductoDTO;
import com.todocodeacademy.bazarAPI.dto.VentaDTO;
import com.todocodeacademy.bazarAPI.dto.VentaMayorDTO;
import com.todocodeacademy.bazarAPI.dto.VentaFechaDTO;
import com.todocodeacademy.bazarAPI.model.Producto;
import com.todocodeacademy.bazarAPI.model.Venta;
import java.time.LocalDate;
import java.util.List;


public interface IVentaService {
    
    //crear
    public void saveVenta(Venta venta);
    //eliminar
    public void deleteVenta(Long codigo_venta);
    //modificacion
    public void updateVenta(Venta venta);
    //traer lista completa
    public List<VentaDTO> getVentas();
    //traer elemento particular
    public VentaDTO getVenta(Long codigo_venta);
    //traer productos de una venta
    public List<ProductoDTO> getProductosVenta(Long codigo_venta);
    
    //traer sumatoria del monto de un determinado dia
    public double getSumatoriaMonto(LocalDate fecha_venta);
    //traer cantidad total de ventas de un determinado dia
    public int getCantidadTotalVentas(LocalDate fecha_venta);
    
    public VentaFechaDTO getMontoYCantVentas(LocalDate fecha_venta);

    //traer varios datos de la venta con el mayor monto
    public VentaMayorDTO getMayorVenta();
    
 
    
}
