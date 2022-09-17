
package com.todocodeacademy.bazarAPI.service;

import com.todocodeacademy.bazarAPI.model.Cliente;
import java.util.List;


public interface IClienteService {
    
    //crear
    public void saveCliente(Cliente cliente);
    //eliminar
    public void deleteCliente(Long id_cliente);
    //modificacion
    public void updateCliente(Cliente cliente);
    //traer lista completa
    public List<Cliente> getClientes();
    //traer elemento particular
    public Cliente getCliente(Long id_cliente);
    
}
