
package com.todocodeacademy.bazarAPI.repository;

import com.todocodeacademy.bazarAPI.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductoRepository extends JpaRepository<Producto,Long> {
    
}
