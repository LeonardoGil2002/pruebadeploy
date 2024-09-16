package com.apispring.BazarAPI.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;


@Getter @Setter
@Entity
public class DetalleVenta {
    
    @EmbeddedId
    private DetalleVentaPK codigo_detalle_venta;
    
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "codigo_venta", insertable = false, updatable = false)
    private Venta venta;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "codigo_producto", insertable = false, updatable = false)
    private Producto producto;

    private int cantidad;

    public DetalleVenta() {
    }

    public DetalleVenta(Venta venta, Producto producto, int cantidad) {
        this.codigo_detalle_venta.setCodigo_producto(producto.getCodigo_producto());
        this.codigo_detalle_venta.setCodigo_venta(venta.getCodigo_venta());
        this.venta = venta;
        this.producto = producto;
        this.cantidad = cantidad;
    }
    
    
    
}
