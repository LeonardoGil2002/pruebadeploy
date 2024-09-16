package com.apispring.BazarAPI.controller;

import com.apispring.BazarAPI.model.DetalleVenta;
import com.apispring.BazarAPI.model.Producto;
import com.apispring.BazarAPI.model.Venta;
import com.apispring.BazarAPI.service.IDetalleVentaService;
import com.apispring.BazarAPI.service.IProductoService;
import com.apispring.BazarAPI.service.IVentaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DetalleVentaController {
    
    @Autowired
    private IDetalleVentaService dvSer;
    
    @Autowired
    private IVentaService venSer;
    
    @Autowired
    private IProductoService prodSer;
    
    @GetMapping("/dv")
    public List<DetalleVenta> traerDv(){
        return dvSer.getDetallesVenta();
    }
    
    @PostMapping("/dv/crear")
    public String crearDetalleVenta(@RequestBody DetalleVenta dv){
        
        
        
        //Traigo el Producto y la Venta relacionadas con el DetalleVenta
        Producto prod = prodSer.findProducto(dv.getCodigo_detalle_venta().getCodigo_producto());
        Venta ven = venSer.findVenta(dv.getCodigo_detalle_venta().getCodigo_venta());
        
        //Chequeo que la cantidad requerida sea menor o igual a la que hay en stock
        if(dv.getCantidad()<=prod.getCantidad_disponible()){
            
            //Seteo la nueva cantidad (cantidad - cantidad comprada)
            prod.setCantidad_disponible(prod.getCantidad_disponible()- dv.getCantidad());

            //Seteo el nuevo total (total + cantidad comprada * precio del producto)
            ven.setTotal(ven.getTotal() + dv.getCantidad()*prod.getCosto());

            //Actualizamos el total de la venta y la cantidad de productos disponibles
            venSer.editVenta(ven);
            prodSer.editProducto(prod);

            //Agrego el detalle de venta
            dvSer.addDetalleVenta(dv);

            return "Se ha creado el detalle de venta exitosamente";
        
        }
        
        return "Error al crear el detalle de venta. Stock insuficiente.";
        
    }
    
}
