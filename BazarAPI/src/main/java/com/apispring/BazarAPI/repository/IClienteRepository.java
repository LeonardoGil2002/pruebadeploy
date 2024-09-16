package com.apispring.BazarAPI.repository;

import com.apispring.BazarAPI.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IClienteRepository extends JpaRepository<Cliente,Long>{
    
}
