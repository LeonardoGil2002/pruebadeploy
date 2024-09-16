package com.apispring.BazarAPI.controller;

import com.apispring.BazarAPI.dto.VentaDTO;
import com.apispring.BazarAPI.model.Producto;
import com.apispring.BazarAPI.model.Venta;
import com.apispring.BazarAPI.service.IDetalleVentaService;
import com.apispring.BazarAPI.service.IVentaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VentaController {
    
    @Autowired
    private IVentaService venSer;
    
    @Autowired
    private IDetalleVentaService dvSer;
    
    @GetMapping("/ventas")
    public List<Venta> traerVentas(){
        return venSer.getVentas();
    }
    
    @PostMapping("/ventas/crear")
    public String crearVenta(@RequestBody Venta ven){
        venSer.addVenta(ven);
        return "Se ha creado la venta exitosamente";
    }
    
    @DeleteMapping("/ventas/eliminar/{id}")
    public String eliminarVenta(@PathVariable Long id){
        venSer.deleteVenta(id);
        return "Se ha eliminado la venta exitosamente";
    }
    
    @PutMapping("/ventas/editar")
    public String editarVenta(@RequestBody Venta ven){
        venSer.editVenta(ven);
        return "Se ha editado la venta exitosamente";
    }
    
    @GetMapping("/ventas/productos/{cod_venta}")
    public List<Producto> traerProductosDeVenta(@PathVariable Long cod_venta){
        return dvSer.getVentasProducto(cod_venta);
    }
    
    @GetMapping("/ventas/{fecha_venta}")
    public String traerSumatoriaTotalYCantidadDeVentas(@PathVariable String fecha_venta){
        List<Integer> cantidadYTotal = venSer.getTotalYCantidadVentas(fecha_venta);
        return "Cantidad de ventas: " + String.valueOf(cantidadYTotal.get(0)) + "\nTotal recaudado: $" + String.valueOf(cantidadYTotal.get(1));
    }
    
    @GetMapping("/ventas/mayor_venta")
    public VentaDTO traerMayorVenta(){
        return venSer.getMayorVenta();
    }
    
}
