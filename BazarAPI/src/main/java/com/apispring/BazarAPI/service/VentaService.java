package com.apispring.BazarAPI.service;

import com.apispring.BazarAPI.dto.VentaDTO;
import com.apispring.BazarAPI.model.DetalleVenta;
import com.apispring.BazarAPI.model.Venta;
import com.apispring.BazarAPI.repository.IDetalleVentaRepository;
import com.apispring.BazarAPI.repository.IVentaRepository;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VentaService implements IVentaService{

    @Autowired
    private IVentaRepository venRepo;
    
    @Autowired
    private IDetalleVentaRepository dvRepo;
    
    
    @Override
    public List<Venta> getVentas() {
        return venRepo.findAll();
    }

    @Override
    public Venta findVenta(Long id) {
        return venRepo.findById(id).orElse(null);
    }

    @Override
    public void addVenta(Venta ven) {
        //Cuando creamos una venta, debemos setear el total en 0, ya que aún no tiene ningún detalle de venta asignado
        ven.setTotal(0.0);
        venRepo.save(ven);
    }

    @Override
    public void deleteVenta(Long id) {
        venRepo.deleteById(id);
    }

    @Override
    public void editVenta(Venta ven) {
        venRepo.save(ven);
    }

    @Override
    public List<Integer> getTotalYCantidadVentas(String fecha) {
        
        List<Venta> listaVentas = venRepo.findAll();
        int cantidadVentas = 0;
        int total = 0;
        
        for(Venta v : listaVentas){
            if(v.getFecha_venta().equals(fecha)){
                cantidadVentas++;
                total+=v.getTotal();
            }
        }
        
        return (List<Integer>) Arrays.asList(cantidadVentas, total);
        
    }

    @Override
    public VentaDTO getMayorVenta() {
        Venta ven = getVentaMayorMonto();
        VentaDTO vDto = new VentaDTO();
        vDto.setCodigo_venta(ven.getCodigo_venta());
        vDto.setNombre_cliente(ven.getCliente().getNombre());
        vDto.setApellido_cliente(ven.getCliente().getApellido());
        vDto.setCantidad_productos(getCantidadProductos(ven.getCodigo_venta()));
        vDto.setTotal(ven.getTotal());
        
        return vDto;
    }
    
    public Venta getVentaMayorMonto(){
        List<Venta> listaVentas = venRepo.findAll();
        Venta maxVenta = listaVentas.get(0);
        for(Venta v : listaVentas){
            if (v.getTotal() > maxVenta.getTotal()){
                maxVenta = v;
            }
        }
        return maxVenta;
    }
    
    public int getCantidadProductos(Long id){
        int cantProd = 0;
        
        List<DetalleVenta> dvLista = dvRepo.findAll();
        
        for(DetalleVenta dv : dvLista){
            if(Objects.equals(dv.getCodigo_detalle_venta().getCodigo_venta(), id)){
                cantProd+=dv.getCantidad();
            }
        }
        
        return cantProd;
        
    }
    
}
