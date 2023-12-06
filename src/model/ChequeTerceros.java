package model;

import java.util.Date;

public class ChequeTerceros extends Cheque {
    private String empresaEmisora;

    public ChequeTerceros(int id, int cuit, Boolean estaPago, double monto, Date fechaEmision, Date fechaVencimiento, String firmante, double importe, String empresaEmisora) {
        super(id, cuit, estaPago, monto, fechaEmision, fechaVencimiento, firmante, importe);
        this.empresaEmisora = empresaEmisora;
    }

    public String getEmpresaEmisora() {
        return empresaEmisora;
    }
}
