package com.tienda.service;

import java.util.List;

import com.tienda.domain.Producto;

public interface ProductoService {


    public List<Producto> getProductos(boolean activos);
    

    public Producto getProducto(Producto producto);
    

    public void save(Producto producto);
    
    public void delete(Producto producto);

    public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);
   
    public List<Producto> metodoJPQL(double precioInf, double precioSup);

    public List<Producto> metodoNativo(double precioInf, double precioSup);
}