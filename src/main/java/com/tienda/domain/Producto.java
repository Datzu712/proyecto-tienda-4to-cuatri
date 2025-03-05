package com.tienda.domain;

import lombok.Data;
import jakarta.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table(name = "Producto")
public class Producto implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_producto")
    private long idProducto;

    @Column(name = "id_categoria", nullable = false)
    private long idCategoria;

    @Column(name = "descripcion", nullable = false, length = 30)
    private String descripcion;

    @Column(name = "detalle", nullable = false, length = 1600)
    private String detalle;

    @Column(name = "precio")
    private double precio;

    @Column(name = "existencias")
    private int existencias;

    @Column(name = "ruta_imagen", length = 1024)
    private String rutaImagen;

    @Column(name = "activo")
    private boolean activo;
}
