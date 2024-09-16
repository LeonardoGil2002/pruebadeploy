package com.apispring.BazarAPI.model;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Embeddable
public class DetalleVentaPK {
    
    private Long codigo_venta;
    private Long codigo_producto;

    public DetalleVentaPK() {
    }

    public DetalleVentaPK(Long codigoVenta, Long codigoProducto) {
        this.codigo_venta = codigoVenta;
        this.codigo_producto = codigoProducto;
    }
    
}
