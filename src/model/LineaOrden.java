package model;

public class LineaOrden {
    private int numeroRenglon;
    private int cantidad;
    private ProductoPorProveedor producto;

    public LineaOrden(int numeroRenglon, int cantidad, ProductoPorProveedor producto) {
        this.numeroRenglon = numeroRenglon;
        this.cantidad = cantidad;
        this.producto = producto;
    }

    public int getNumeroRenglon() {
        return numeroRenglon;
    }
    public int getCantidad() {
        return cantidad;
    }
    public ProductoPorProveedor getProducto() {
        return producto;
    }
    public double getUltimoPrecioAcordado(){
        return producto.getUltimoPrecio();
    };
}
