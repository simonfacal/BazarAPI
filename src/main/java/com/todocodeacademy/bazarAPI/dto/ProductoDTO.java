
package com.todocodeacademy.bazarAPI.dto;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ProductoDTO {
    
    private Long codigo_producto;
    private String nombre;
    private String marca;
    private double costo;
    private int cantidad_disponible;

    public ProductoDTO() {
    }

    public ProductoDTO(Long codigo_producto, String nombre, String marca, double costo, int cantidad_disponible) {
        this.codigo_producto = codigo_producto;
        this.nombre = nombre;
        this.marca = marca;
        this.costo = costo;
        this.cantidad_disponible = cantidad_disponible;
    }
 
    
    
    
    
    
}
