package com.apispring.BazarAPI.repository;

import com.apispring.BazarAPI.model.DetalleVenta;
import com.apispring.BazarAPI.model.DetalleVentaPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDetalleVentaRepository extends JpaRepository<DetalleVenta,DetalleVentaPK>{
    
}