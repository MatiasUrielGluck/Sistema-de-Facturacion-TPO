package model;

import java.util.Date;
import java.util.List;

import edu.Impuesto;

public class Factura extends Documento {
    private List<Impuesto> impuestos;
    private Date fecha;
    private List<DetalleFactura> detalles;
    private int cuitProveedor;

    public Factura(int id, int cuit, Boolean estaPago, double monto, List<Impuesto> impuestos, Date fecha, List<DetalleFactura> detalles, int cuitProveedor) {
        super(id, cuit, estaPago, monto);
        this.impuestos = impuestos;
        this.fecha = fecha;
        this.detalles = detalles;
        this.cuitProveedor = cuitProveedor;
    }

    @Override
    public int getCuit() {
        return super.getCuit();
    }

    @Override
    public Boolean getEstaPago() {
        return super.getEstaPago();
    }

    @Override
    public double getMonto() {
        return super.getMonto();
    }

    public List<DetalleFactura> getDetalles() {
        return detalles;
    }

    public List<Impuesto> getImpuestos() {
        return impuestos;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getCuitProveedor() {
        return cuitProveedor;
    }

    public void getOrdenDeCompraById(){

    };
}
