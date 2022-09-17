
package com.todocodeacademy.bazarAPI.repository;

import com.todocodeacademy.bazarAPI.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IVentaRepository extends JpaRepository<Venta,Long> {
    
}
