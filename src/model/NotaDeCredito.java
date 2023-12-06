package model;

public class NotaDeCredito extends Documento {
    int cuitProveedor;

    public NotaDeCredito(int id, int cuit, Boolean estaPago, double monto, int cuitProveedor) {
        super(id, cuit, estaPago, monto);
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

    public int getCuitProveedor() {
        return this.cuitProveedor;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setCuit(int cuit) {
        this.cuit = cuit;
    }
    public void setEstaPago(boolean estaPago) {
        this.estaPago = estaPago;
    }
    public void setCuitProveedor(int cuitProveedor) {
        this.cuitProveedor = cuitProveedor;
    }
}
