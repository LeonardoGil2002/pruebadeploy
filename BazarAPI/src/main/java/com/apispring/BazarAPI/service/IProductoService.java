package com.apispring.BazarAPI.service;

import com.apispring.BazarAPI.model.Producto;
import java.util.List;

public interface IProductoService {    
    public void addProducto(Producto pr);
    public List<Producto> getProductos();
    public Producto findProducto(Long id);
    public void deleteProducto(Long id);
    public void editProducto(Producto pr);
    public List<Producto> getProductosMenorStockQue(int cantidad);
}