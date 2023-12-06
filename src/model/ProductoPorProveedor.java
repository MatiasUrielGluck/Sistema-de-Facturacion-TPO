package model;

public class ProductoPorProveedor {
    private double ultimoPrecio;
    private Producto producto;

    public ProductoPorProveedor(double ultimoPrecio, Producto producto) {
        this.ultimoPrecio = ultimoPrecio;
        this.producto =producto;
    }

    public double getUltimoPrecio() {
        return ultimoPrecio;
    }

    public Producto getProducto() {
        return producto;
    }
}
