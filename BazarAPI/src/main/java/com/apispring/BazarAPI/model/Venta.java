package com.apispring.BazarAPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Venta {
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long codigo_venta;
    
    private String fecha_venta;
    private Double total;
    
    @OneToMany(mappedBy="venta")
    private List<DetalleVenta> detalle;
    
    @ManyToOne
    @JoinColumn(name="id_cliente")
    private Cliente cliente;

    public Venta() {
    }

    public Venta(Long codigo_venta, String fecha_venta, Double total, List<DetalleVenta> detalle, Cliente cliente) {
        this.codigo_venta = codigo_venta;
        this.fecha_venta = fecha_venta;
        this.total = total;
        this.detalle = detalle;
        this.cliente = cliente;
    }

}
