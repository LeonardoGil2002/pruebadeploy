package com.apispring.BazarAPI.service;

import com.apispring.BazarAPI.model.DetalleVenta;
import com.apispring.BazarAPI.model.DetalleVentaPK;
import com.apispring.BazarAPI.model.Producto;
import com.apispring.BazarAPI.repository.IDetalleVentaRepository;
import com.apispring.BazarAPI.repository.IProductoRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DetalleVentaService implements IDetalleVentaService{

    @Autowired
    private IDetalleVentaRepository dvRep;
    
    @Autowired
    private IProductoRepository prodRep;
    
    
    @Override
    public List<DetalleVenta> getDetallesVenta() {
        return dvRep.findAll();
    }

    @Override
    public void addDetalleVenta(DetalleVenta dv) {
        dvRep.save(dv);
    }

    @Override
    public void deleteDetalleVenta(DetalleVentaPK id) {
        dvRep.deleteById(id);
    }

    @Override
    public void editDetalleVenta(DetalleVenta dv) {
        dvRep.save(dv);
    }

    @Override
    public DetalleVenta findDetalleVenta(DetalleVentaPK id) {
        return dvRep.findById(id).orElse(null);
    }

    @Override
    public List<Producto> getVentasProducto(Long cod_venta) {
        
        List<Producto> listaProductos = new ArrayList<>();
        List<DetalleVenta> listaDv = dvRep.findAll();
        
        for(DetalleVenta dv : listaDv){
            if(Objects.equals(dv.getCodigo_detalle_venta().getCodigo_venta(), cod_venta)){
                listaProductos.add(prodRep.findById(dv.getCodigo_detalle_venta().getCodigo_producto()).orElse(null));
            }
        }
        return listaProductos;
    }
    
    
    
}
