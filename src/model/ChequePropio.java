package model;

import java.util.Date;

public class ChequePropio extends Cheque {
    public ChequePropio(int id, int cuit, Boolean estaPago, double monto, Date fechaEmision, Date fechaVencimiento, String firmante, double importe) {
        super(id, cuit, estaPago, monto, fechaEmision, fechaVencimiento, firmante, importe);
    }
}
