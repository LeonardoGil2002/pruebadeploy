package com.apispring.BazarAPI.dto;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class VentaDTO {
    
    private Long codigo_venta;
    private Double total;
    private int cantidad_productos;
    private String nombre_cliente;
    private String apellido_cliente;
    
}
