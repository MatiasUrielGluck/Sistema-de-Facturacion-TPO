package model;

import enums.TipoRubro;
import enums.TipoUnidad;

public class Producto {
    private int idProducto;
    private String nombreProducto;
    private TipoRubro rubro;
    private TipoUnidad tipoUnidad;
    private double tipoIva;

    public Producto(int idProducto, String nombreProducto, TipoRubro rubro, TipoUnidad tipoUnidad, double tipoIva) {
        this.idProducto = idProducto;
        this.nombreProducto = nombreProducto;
        this.rubro = rubro;
        this.tipoUnidad = tipoUnidad;
        this.tipoIva = tipoIva;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public TipoRubro getRubro() {
        return rubro;
    }

    public double getTipoIva() {
        return tipoIva;
    }
}
