package com.apispring.BazarAPI.service;

import com.apispring.BazarAPI.dto.VentaDTO;
import com.apispring.BazarAPI.model.Venta;
import java.util.List;

public interface IVentaService {
    public List<Venta> getVentas();
    public Venta findVenta(Long id);
    public void addVenta(Venta ven);
    public void deleteVenta(Long id);
    public void editVenta(Venta ven);
    public List<Integer> getTotalYCantidadVentas(String fecha);
    public VentaDTO getMayorVenta();
}
