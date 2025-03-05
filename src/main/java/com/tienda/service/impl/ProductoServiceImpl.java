package com.tienda.service.impl;

import com.tienda.dao.ProductoDao;
import com.tienda.domain.Producto;
import com.tienda.service.ProductoService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoDao serviceDao;

    @Transactional(readOnly = true)
    public List<Producto> getProductos(boolean activos) {
        var lista = serviceDao.findAll();
        if (activos) {
            lista.removeIf(e -> !e.isActivo());
        }
        return lista;
    }

    @Transactional(readOnly = true)
    public Producto getProducto(Producto categoria) {
        return serviceDao.findById(categoria.getIdProducto()).orElse(null);
    }

    @Transactional
    public void save(Producto categoria) {
        serviceDao.save(categoria);
    }
    @Transactional
    public void delete(Producto categoria) {
        serviceDao.delete(categoria);
    }
}