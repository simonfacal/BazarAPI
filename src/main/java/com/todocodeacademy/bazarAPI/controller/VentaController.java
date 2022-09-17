
package com.todocodeacademy.bazarAPI.controller;

import com.todocodeacademy.bazarAPI.dto.ProductoDTO;
import com.todocodeacademy.bazarAPI.dto.VentaDTO;
import com.todocodeacademy.bazarAPI.dto.VentaMayorDTO;
import com.todocodeacademy.bazarAPI.dto.VentaFechaDTO;
import com.todocodeacademy.bazarAPI.model.Venta;
import com.todocodeacademy.bazarAPI.service.IVentaService;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
public class VentaController {
    
    @Autowired
    private IVentaService ventaServ;
    
    //crear
    @PostMapping("/ventas/crear")
    public void saveVenta(@RequestBody Venta venta)
    {
        ventaServ.saveVenta(venta);
    }
    
    //eliminar
    @DeleteMapping("/ventas/eliminar/{codigo_venta}")
    public void deleteVenta(@PathVariable Long codigo_venta)
    {
        ventaServ.deleteVenta(codigo_venta);
    }
    
    //modificar
    @PutMapping("/ventas/editar/{codigo_venta}")
    public void updateVenta(@PathVariable Long codigo_venta)
    {
        
    }
    
    //traer lista
    @GetMapping("/ventas")
    @ResponseBody
    public List<VentaDTO> getVentas()
    {
        return ventaServ.getVentas();
    }
   
    //traer elemento
    @GetMapping("/ventas/{codigo_venta}")
    @ResponseBody
    public VentaDTO getVenta(@PathVariable Long codigo_venta)
    {
        return ventaServ.getVenta(codigo_venta);
    }
    
    //traer productos de venta
    @GetMapping("/ventas/productos/{codigo_venta}")
    @ResponseBody
    public List<ProductoDTO> getProductosVenta(@PathVariable Long codigo_venta)
    {
        return ventaServ.getProductosVenta(codigo_venta);
    }
    
    //traer mayor venta con varios datos
    @GetMapping("/ventas/mayor_venta")
    @ResponseBody
    public VentaMayorDTO getMayorVenta()
    {
        return ventaServ.getMayorVenta();
    }
    
    //traer monto y cant ventas de un mismo dia
    @GetMapping("/ventas/busqueda/{fecha_venta}")
    @ResponseBody
    public VentaFechaDTO getMontoYCantVentas(@PathVariable String fecha_venta)
    {
       DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse(fecha_venta, formatter);
        return ventaServ.getMontoYCantVentas(date);
    }
    
    
    
}
