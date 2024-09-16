package com.apispring.BazarAPI.service;

import com.apispring.BazarAPI.model.Producto;
import com.apispring.BazarAPI.repository.IProductoRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService implements IProductoService{

    @Autowired
    private IProductoRepository prodRepo;
    
    @Override
    public void addProducto(Producto pr) {
        prodRepo.save(pr);
    }

    @Override
    public List<Producto> getProductos() {
        return prodRepo.findAll();
    }

    @Override
    public Producto findProducto(Long id) {
        return prodRepo.findById(id).orElse(null);
    }

    @Override
    public void deleteProducto(Long id) {
        prodRepo.deleteById(id);
    }

    @Override
    public void editProducto(Producto pr) {
        prodRepo.save(pr);
    }
    
    public List<Producto> getProductosMenorStockQue(int cantidad){
        List<Producto> listaAux = prodRepo.findAll();
        List<Producto> lista = new ArrayList<>();
        for(Producto p : listaAux){
            if(p.getCantidad_disponible()<cantidad){
                lista.add(p);
            }
        }
        return lista;
    }
    
}
