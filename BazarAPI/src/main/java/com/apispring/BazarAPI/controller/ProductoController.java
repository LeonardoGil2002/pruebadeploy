package com.apispring.BazarAPI.controller;

import com.apispring.BazarAPI.model.Producto;
import com.apispring.BazarAPI.service.IProductoService;
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
public class ProductoController {
    
    @Autowired
    private IProductoService prodServ;
    
    @GetMapping("/productos")
    public List<Producto> traerProductos(){
        return prodServ.getProductos();
    }
    
    @PostMapping("/productos/crear")
    public String crearProducto(@RequestBody Producto prod){
        prodServ.addProducto(prod);
        return "Se ha agregado el producto correctamente";
    }
    
    @DeleteMapping("/productos/eliminar/{id}")
    public String eliminarProducto(@PathVariable Long id){
        prodServ.deleteProducto(id);
        return "Se ha eliminado el producto correctamente";
    }
    
    @PutMapping("productos/editar")
    public String editarProducto(@RequestBody Producto prod){
        prodServ.editProducto(prod);
        return "Se ha editado el producto";
    }
    
    @GetMapping("/productos/menor_stock_que/{cantidad}")
    public List<Producto> traerProductosMenorStock(@PathVariable int cantidad){
        return prodServ.getProductosMenorStockQue(cantidad);
    }
    
}
