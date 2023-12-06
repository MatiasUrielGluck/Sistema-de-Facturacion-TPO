package model;

import enums.FormaPago;
import java.util.Date;
import java.util.List;

public class OrdenDePago {
    private int idOrdenDePago;
    private double totalCancelar;
    private FormaPago formaPago;
    private double totalRetenciones;
    private Date fecha;
    private int cuitProveedor;
    private List<Documento> documentosAsociados;

    public OrdenDePago(int idOrdenDePago, double totalCancelar, FormaPago formaPago, double totalRetenciones, Date fecha, int cuitProveedor, List<Documento> documentosAsociados) {
        this.idOrdenDePago = idOrdenDePago;
        this.totalCancelar = totalCancelar;
        this.formaPago = formaPago;
        this.totalRetenciones = totalRetenciones;
        this.fecha = fecha;
        this.cuitProveedor = cuitProveedor;
        this.documentosAsociados = documentosAsociados;
    }

    public List<Documento> getDocumentosAsociados() {
        return documentosAsociados;
    };

    public int getIdOrdenDePago() {
        return idOrdenDePago;
    }

    public double getTotalCancelar() {
        return totalCancelar;
    }

    public FormaPago getFormaPago() {
        return formaPago;
    }

    public double getTotalRetenciones() {
        return totalRetenciones;
    }
    public Date getFecha() {
        return fecha;
    }

    public int getCuitProveedor() {
        return cuitProveedor;
    }
}
