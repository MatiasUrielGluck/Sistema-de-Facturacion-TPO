package model;

import java.util.List;

public class OrdenDeCompra {
    private int idOrdenDeCompra;
    private List<LineaOrden> detalles;

    public OrdenDeCompra(int idOrdenDeCompra, List<LineaOrden> detalles) {
        this.idOrdenDeCompra = idOrdenDeCompra;
        this.detalles = detalles;
    }
    public void setIdOrdenDeCompra(int idOrdenDeCompra) {
        this.idOrdenDeCompra = idOrdenDeCompra;
    }
    public int getIdOrdenDeCompra() {
        return idOrdenDeCompra;
    }

    public void setDetalles(List<LineaOrden> detalles) {
        this.detalles = detalles;
    }
    public List<LineaOrden> getDetalles() { return detalles; }
}