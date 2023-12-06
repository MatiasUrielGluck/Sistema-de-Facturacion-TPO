package model;

public class DetalleFactura {
    private int numeroRenglon;
    private ProductoPorProveedor producto;
    private int cantidad;
    private double precioFinal;

    public DetalleFactura(int numeroRenglon, ProductoPorProveedor producto, int cantidad) {
        this.numeroRenglon = numeroRenglon;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioFinal = producto.getUltimoPrecio() * cantidad;
    }

    public ProductoPorProveedor getProducto() {
        return producto;
    }

    public double getPrecioFinal() {
        return precioFinal;
    }
}
