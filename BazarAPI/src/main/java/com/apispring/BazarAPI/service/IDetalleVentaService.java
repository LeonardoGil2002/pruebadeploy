package com.apispring.BazarAPI.service;

import com.apispring.BazarAPI.model.DetalleVenta;
import com.apispring.BazarAPI.model.DetalleVentaPK;
import com.apispring.BazarAPI.model.Producto;
import java.util.List;


public interface IDetalleVentaService {
    public List<DetalleVenta> getDetallesVenta();
    public void addDetalleVenta(DetalleVenta dv);
    public void deleteDetalleVenta(DetalleVentaPK id);
    public void editDetalleVenta(DetalleVenta dv);
    public DetalleVenta findDetalleVenta(DetalleVentaPK id);

    public List<Producto> getVentasProducto(Long cod_venta);
}
