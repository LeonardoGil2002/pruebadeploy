package com.apispring.BazarAPI.repository;

import com.apispring.BazarAPI.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoRepository extends JpaRepository<Producto,Long>{
    
}
