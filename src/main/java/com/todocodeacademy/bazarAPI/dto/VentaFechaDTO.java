
package com.todocodeacademy.bazarAPI.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class VentaFechaDTO {
    
    private double sumatoriaMonto;
    private int cantidadVentas;

    public VentaFechaDTO() {
    }

    public VentaFechaDTO(double sumatoriaMonto, int cantidadVentas) {
        this.sumatoriaMonto = sumatoriaMonto;
        this.cantidadVentas = cantidadVentas;
    }
    
    
    
    
}
