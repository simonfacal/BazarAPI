
package com.todocodeacademy.bazarAPI.service;

import com.todocodeacademy.bazarAPI.model.Cliente;
import com.todocodeacademy.bazarAPI.repository.IClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteService{

    @Autowired
    private IClienteRepository clienteRepo;
    
    @Override
    public void saveCliente(Cliente cliente) {
        clienteRepo.save(cliente);
    }

    @Override
    public void deleteCliente(Long id_cliente) {
        clienteRepo.deleteById(id_cliente);
    }

    @Override
    public void updateCliente(Cliente cliente) {
        this.saveCliente(cliente);
    }

    @Override
    public List<Cliente> getClientes() {
        return clienteRepo.findAll();
    }

    @Override
    public Cliente getCliente(Long id_cliente) {
         return clienteRepo.findById(id_cliente).orElse(null);
    }
    
}
