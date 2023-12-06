package model;

import java.util.Date;
import edu.Impuesto;

public class Certificado {
    private Date fechaInicio;
    private Date fechaFin;
    private Impuesto impuesto;
    private Proveedor proveedor;

    public Certificado(Date fechaInicio, Date fechaFin, Impuesto impuesto, Proveedor proveedor) {
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.impuesto = impuesto;
        this.proveedor = proveedor;
    }

    public Impuesto getImpuestoById(Impuesto impuesto) {
        return impuesto;
    }

    public Proveedor getProveedorByCuit() {
        return proveedor;
    }
}
