
package com.todocodeacademy.bazarAPI.controller;

import com.todocodeacademy.bazarAPI.model.Cliente;
import com.todocodeacademy.bazarAPI.service.IClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {
   
    @Autowired
    private IClienteService clienteServ;
    
    //crear
    @PostMapping("/clientes/crear")
    public void saveCliente(@RequestBody Cliente cliente)
    {
        clienteServ.saveCliente(cliente);
    }
    
    //borrar
    @DeleteMapping("/clientes/eliminar/{id_cliente}")
    public void deleteCliente(@PathVariable Long id_cliente)
    {
        clienteServ.deleteCliente(id_cliente);
    }
    
    //modificacion
    @PutMapping("/clientes/editar/{id_cliente}")
    public void updateCliente(@PathVariable Long id_cliente)
    {
        
    }
    
    //traer lista completa
    @GetMapping("/clientes")
    @ResponseBody
    public List<Cliente> getClientes()
    {
        return clienteServ.getClientes();
    }
    
    //traer elemento especifico
    @GetMapping("/clientes/{id_cliente}")
    @ResponseBody
    public Cliente getCliente(@PathVariable Long id_cliente)
    {
        return clienteServ.getCliente(id_cliente);
    }
    
}
