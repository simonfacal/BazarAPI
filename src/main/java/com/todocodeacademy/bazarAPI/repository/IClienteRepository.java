
package com.todocodeacademy.bazarAPI.repository;

import com.todocodeacademy.bazarAPI.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente,Long>{
    
}
