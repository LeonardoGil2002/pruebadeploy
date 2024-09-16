package com.apispring.BazarAPI.service;

import com.apispring.BazarAPI.model.Cliente;
import com.apispring.BazarAPI.repository.IClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService implements IClienteService{
    
    @Autowired
    private IClienteRepository cliRepo;

    @Override
    public void addCliente(Cliente cl) {
        cliRepo.save(cl);
    }

    @Override
    public List<Cliente> getClientes() {
        return cliRepo.findAll();
    }

    @Override
    public Cliente findCliente(Long id) {
        return cliRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteCliente(Long id) {
        cliRepo.deleteById(id);
    }

    @Override
    public void editCliente(Cliente cl) {
        cliRepo.save(cl);
    }
    
    
    
}
