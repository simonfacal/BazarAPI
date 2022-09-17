
package com.todocodeacademy.bazarAPI.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Cliente {
    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id_cliente;
    private String nombre;
    private String apellido;
    private Long dni;

    public Cliente() {
    }

    public Cliente(Long id_cliente, String nombre, String apellido, Long dni) {
        this.id_cliente = id_cliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
    }
    
    
    
    
}
