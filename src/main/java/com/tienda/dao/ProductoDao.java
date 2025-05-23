package com.tienda.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tienda.domain.Producto;

public interface ProductoDao extends JpaRepository<Producto, Long> {
    public List<Producto> findByPrecioBetweenOrderByDescripcion(double precioInf, double precioSup);

    @Query(value = "SELECT a FROM Producto a where a.precio BETWEEN :precioInf AND :precioSup ORDER BY a.descripcion ASC")
    public List<Producto> metodoJPQL(@Param("precioInf") double precioInf, @Param("precioSup") double precioSup);

    @Query(nativeQuery = true,
            value = "SELECT * FROM producto where producto.precio BETWEEN :precioInf AND :precioSup ORDER BY producto.descripcion ASC")
    public List<Producto> metodoNativo(@Param("precioInf") double precioInf, @Param("precioSup") double precioSup);

    @Query(value = "SELECT a FROM Producto a where a.descripcion LIKE %:nombre% ORDER BY a.descripcion ASC")
    public List<Producto> findByNombreContainingIgnoreCaseOrderByDescripcion(@Param("nombre") String nombre);

    //Buscar productos por descripción que contenga el texto (ignorando mayúsculas/minúsculas)
    public List<Producto> findByDescripcionContainingIgnoreCase(String textoDescripcion);


}