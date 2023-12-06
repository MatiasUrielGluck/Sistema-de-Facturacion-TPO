package model;

import java.util.Date;

abstract class Cheque extends Documento {
    public Cheque(int id, int cuit, Boolean estaPago, double monto, Date fechaEmision, Date fechaVencimiento, String firmante, double importe) {
        super(id, cuit, estaPago, monto);
        this.fechaEmision = fechaEmision;
        this.fechaVencimiento = fechaVencimiento;
        this.firmante = firmante;
        this.importe = importe;
    }

    private Date fechaEmision;
    private Date fechaVencimiento;
    private String firmante;
    private double importe;
}
