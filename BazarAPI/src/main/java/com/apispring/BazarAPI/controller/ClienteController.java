package com.apispring.BazarAPI.controller;

import com.apispring.BazarAPI.model.Cliente;
import com.apispring.BazarAPI.service.IClienteService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClienteController {
    
    @Autowired
    private IClienteService cliSer;
    
    @GetMapping("/clientes")
    public List<Cliente> traerClientes(){
        return cliSer.getClientes();
    }
    
    @PostMapping("/clientes/crear")
    public String crearCliente(@RequestBody Cliente cl){
        cliSer.addCliente(cl);
        return "Se ha creado el cliente exitosamente";
    }
    
    @DeleteMapping("clientes/eliminar/{id}")
    public String eliminarCliente(@PathVariable Long id){
        cliSer.deleteCliente(id);
        return "Se ha eliminado el cliente exitosamente";
    }
    
    @PutMapping("clientes/editar")
    public String editarCliente(@RequestBody Cliente cl){
        cliSer.editCliente(cl);
        return "Se ha editado el cliente exitosamente";
    }
    
    
}
