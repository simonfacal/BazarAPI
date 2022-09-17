
package com.todocodeacademy.bazarAPI.service;

import com.todocodeacademy.bazarAPI.dto.ProductoDTO;
import com.todocodeacademy.bazarAPI.dto.VentaDTO;
import com.todocodeacademy.bazarAPI.dto.VentaMayorDTO;
import com.todocodeacademy.bazarAPI.dto.VentaFechaDTO;
import com.todocodeacademy.bazarAPI.mappers.VentaMapper;
import com.todocodeacademy.bazarAPI.model.Producto;
import com.todocodeacademy.bazarAPI.model.Venta;
import com.todocodeacademy.bazarAPI.repository.IProductoRepository;
import com.todocodeacademy.bazarAPI.repository.IVentaRepository;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService implements IVentaService {

    @Autowired
    private IVentaRepository ventaRepo;
    @Autowired
    private IProductoRepository productoRepo;
    @Autowired
    private VentaMapper ventaMapper;
    
    @Override
    public void saveVenta(Venta venta) {
        
        List<Long>idProductos=new ArrayList<Long>();
        List<Producto>listProductos=new ArrayList<Producto>();
        for (int i=0;i<venta.getListaProductos().size();i++)
        {
            idProductos.add(venta.getListaProductos().get(i).getCodigo_producto());
        }
        listProductos=productoRepo.findAllById(idProductos);
        venta.setTotal(0);
        //calculo el total de la venta y asigno a cada producto la venta correspondiente
        for (int i=0;i<listProductos.size();i++)
        {
            venta.setTotal(venta.getTotal()+listProductos.get(i).getCosto());
            listProductos.get(i).setVenta(venta);
        }
        

        ventaRepo.save(venta);   
    }

    
    @Override
    public void deleteVenta(Long codigo_venta) {
       ventaRepo.deleteById(codigo_venta);
    }

    @Override
    public void updateVenta(Venta venta) {
        this.saveVenta(venta);
    }

    @Override
    public List<VentaDTO> getVentas() {
         return ventaMapper.ventaList2VentaDTOList(ventaRepo.findAll());
    }

    @Override
    public VentaDTO getVenta(Long codigo_venta) {
        return ventaMapper.ventaEntity2DTO(ventaRepo.findById(codigo_venta).orElse(null));
    }

    @Override
    public List<ProductoDTO> getProductosVenta(Long codigo_venta) {
        return this.getVenta(codigo_venta).getListaProductos();
    }

    @Override
    public double getSumatoriaMonto(LocalDate fecha_venta) {
        int i=0;
        double suma=0;
        List<VentaDTO>listaVentas=this.getVentas();
   
        while(i<listaVentas.size())
        {   
            if (listaVentas.get(i).getFecha_venta().equals(fecha_venta))
               
                suma+=listaVentas.get(i).getTotal();  
            i++;
        }
        System.out.println("suma del monto:"+suma);
        return suma;
    }

    @Override
    public int getCantidadTotalVentas(LocalDate fecha_venta) {
         int i=0;
        int cont=0;
        List<VentaDTO>listaVentas=this.getVentas();
        while(i<listaVentas.size())
        {
            if (listaVentas.get(i).getFecha_venta().equals(fecha_venta))
                cont++;
            i++;
        }
        return cont;
    }

    @Override
    public VentaMayorDTO getMayorVenta() {
        VentaDTO ventaMayor=null;
        VentaMayorDTO ventaMayorDTO=null;
        List<VentaDTO>listaVentas=this.getVentas();
         int i=0;
         while(i<listaVentas.size())
         {
             if (ventaMayor==null || ventaMayor.getTotal()<listaVentas.get(i).getTotal())
                 ventaMayor=listaVentas.get(i);
             i++;
         }
         //considero el caso de que no haya ninguna venta
         if (ventaMayor!=null)
         {
             ventaMayorDTO=new VentaMayorDTO();
             ventaMayorDTO.setCodigo_venta(ventaMayor.getCodigo_venta());
             ventaMayorDTO.setTotal(ventaMayor.getTotal());
             ventaMayorDTO.setCantidad_productos(ventaMayor.getListaProductos().size());
             ventaMayorDTO.setNombre_cliente(ventaMayor.getUnCliente().getNombre());
             ventaMayorDTO.setApellido_cliente(ventaMayor.getUnCliente().getApellido());
         }
         
         return ventaMayorDTO;
    }

    @Override
    public VentaFechaDTO getMontoYCantVentas(LocalDate fecha_venta) {
        VentaFechaDTO ventaFechaDTO=new VentaFechaDTO();
        
        ventaFechaDTO.setSumatoriaMonto(this.getSumatoriaMonto(fecha_venta));
        ventaFechaDTO.setCantidadVentas(this.getCantidadTotalVentas(fecha_venta));
        
        
        return ventaFechaDTO;
    }

   
    
}
