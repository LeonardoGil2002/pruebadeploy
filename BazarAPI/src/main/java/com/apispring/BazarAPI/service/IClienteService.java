package com.apispring.BazarAPI.service;

import com.apispring.BazarAPI.model.Cliente;
import java.util.List;


public interface IClienteService {
    public void addCliente(Cliente cl);
    public List<Cliente> getClientes();
    public Cliente findCliente(Long id);
    public void deleteCliente(Long id);
    public void editCliente(Cliente cl);
}
