
package com.todocodeacademy.bazarAPI.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Producto {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long codigo_producto;
    private String nombre;
    private String marca;
    private double costo;
    private int cantidad_disponible;
    @ManyToOne
    @JoinColumn
    private Venta venta;

    public Producto() {
    }

    public Producto(Long codigo_producto, String nombre, String marca, double costo, int cantidad_disponible, Venta venta) {
        this.codigo_producto = codigo_producto;
        this.nombre = nombre;
        this.marca = marca;
        this.costo = costo;
        this.cantidad_disponible = cantidad_disponible;
        this.venta = venta;
    }

    @Override
    public String toString() {
        return "Producto{" + "codigo_producto=" + codigo_producto + ", nombre=" + nombre + ", marca=" + marca + ", costo=" + costo + ", cantidad_disponible=" + cantidad_disponible + ", venta=" + venta + '}';
    }

   

   
    
    
    
    
    
}
