package com.apispring.BazarAPI.repository;

import com.apispring.BazarAPI.model.Venta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVentaRepository extends JpaRepository<Venta,Long>{
    
}
