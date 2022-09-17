
package com.todocodeacademy.bazarAPI.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.todocodeacademy.bazarAPI.model.Cliente;
import java.time.LocalDate;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VentaDTO {
    
    private Long codigo_venta;
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern="dd-MM-yyyy")
    private LocalDate fecha_venta;
    private double total;
    private List<ProductoDTO> listaProductos;
    private Cliente unCliente;

    public VentaDTO() {
    }

    public VentaDTO(Long codigo_venta, LocalDate fecha_venta, double total, List<ProductoDTO> listaProductos, Cliente unCliente) {
        this.codigo_venta = codigo_venta;
        this.fecha_venta = fecha_venta;
        this.total = total;
        this.listaProductos = listaProductos;
        this.unCliente = unCliente;
    }
   
    
    
    
}
