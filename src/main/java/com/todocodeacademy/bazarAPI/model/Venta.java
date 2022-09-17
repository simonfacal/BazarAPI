
package com.todocodeacademy.bazarAPI.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Venta {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long codigo_venta;
    
    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern="dd-MM-yyyy")
    private LocalDate fecha_venta;
    private double total;
    @OneToMany(mappedBy="venta")
    private List<Producto> listaProductos;
    @OneToOne
    @JoinColumn(name="id_cliente",
            referencedColumnName="id_cliente")
    private Cliente unCliente;

    public Venta() {
    }

    public Venta(Long codigo_venta, LocalDate fecha_venta, Double total, List<Producto> listaProductos, Cliente unCliente) {
        this.codigo_venta = codigo_venta;
        this.fecha_venta = fecha_venta;
        this.total = total;
        this.listaProductos = listaProductos;
        this.unCliente = unCliente;
    }

    @Override
    public String toString() {
        return "Venta{" + "codigo_venta=" + codigo_venta + ", fecha_venta=" + fecha_venta + ", total=" + total + ", listaProductos=" + listaProductos + ", unCliente=" + unCliente + '}';
    }

    
    
    
    
    
}
