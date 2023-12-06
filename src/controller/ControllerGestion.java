package controller;

import enums.TipoResponsabilidad;
import enums.TipoRubro;
import enums.TipoUnidad;
import model.*;
import edu.Impuesto;
import dto.OrdenDePagoDTO;
import dto.CuentaCorrienteDTO;

import java.util.Date;
import java.util.ArrayList;
import java.util.List;

public class ControllerGestion {

    private static List<Producto> productos;
    private static List<ProductoPorProveedor> productosPorProveedor;
    private static List<Proveedor> proveedores;
    private static List<Factura> facturas;
    private static ControllerGestion INSTANCE = null;


    private ControllerGestion() {
        // TODO: Cargar objetos en memoria (init)
        initProductos();
        initProductosPorProveedor();
        initProveedores();
    }

    public static synchronized ControllerGestion getInstances() throws Exception {
        if(INSTANCE == null) {
            INSTANCE = new ControllerGestion();
        }
        return INSTANCE;
    }

    // Inits
    private static void initProductos() {
        productos = new ArrayList<>();
        productos.add(new Producto(0, "Reparación de sillas", TipoRubro.MANTENIMINETO_MUEBLES, TipoUnidad.UNIDAD, 21));
        productos.add(new Producto(1, "Cuaderno", TipoRubro.LIBRERIA, TipoUnidad.UNIDAD, 21));
        productos.add(new Producto(2, "Impresión a escala de grises", TipoRubro.PAPELERIA_IMPRESIONES, TipoUnidad.UNIDAD, 21));
        productos.add(new Producto(3, "Mantenimiento de ascensores", TipoRubro.MANTENIMINETO_MUEBLES, TipoUnidad.HORA, 10.5));
        productos.add(new Producto(4, "Reparación de mesas", TipoRubro.MANTENIMINETO_MUEBLES, TipoUnidad.UNIDAD, 21));
    }

    private static void initProductosPorProveedor() {
        productosPorProveedor = new ArrayList<>();
        productosPorProveedor.add(new ProductoPorProveedor(10000, productos.get(0)));
        productosPorProveedor.add(new ProductoPorProveedor(1000, productos.get(1)));
        productosPorProveedor.add(new ProductoPorProveedor(20, productos.get(2)));
        productosPorProveedor.add(new ProductoPorProveedor(30000, productos.get(3)));
    }

    private static void initProveedores() {
        proveedores = new ArrayList<>();

        List<ProductoPorProveedor> mockProductosPorProveedor_1 = new ArrayList<>();
        mockProductosPorProveedor_1.add(productosPorProveedor.get(0));
        mockProductosPorProveedor_1.add(productosPorProveedor.get(4));

        List<ProductoPorProveedor> mockProductosPorProveedor_2 = new ArrayList<>();
        mockProductosPorProveedor_2.add(productosPorProveedor.get(1));
        mockProductosPorProveedor_2.add(productosPorProveedor.get(2));

        List<ProductoPorProveedor> mockProductosPorProveedor_3 = new ArrayList<>();
        mockProductosPorProveedor_3.add(productosPorProveedor.get(3));

        proveedores.add(new Proveedor(11111111, TipoResponsabilidad.MONOTRIBUTO, "Mueblería Tu Mueble", "Tito Baratito", "Muebler 123", "5491100000000", "titobaratito@gmail.com", 200000, new Date(), mockProductosPorProveedor_1));
        proveedores.add(new Proveedor(22222222, TipoResponsabilidad.MONOTRIBUTO, "Librería Tu Libreta", "Carito Caratito", "Libretad 321", "5491100000001", "tulibreta@gmail.com", 100000, new Date(), mockProductosPorProveedor_2));
        proveedores.add(new Proveedor(33333333, TipoResponsabilidad.RESPONSABLE_INSCRIPTO, "Subite Al Ascensor", "Elena Elevada", "Everest 999999", "5491100000003", "subitealascensor@muyalto.com", 10000000, new Date(), mockProductosPorProveedor_3));
    }

    private static void initFacturas() {
        facturas = new ArrayList<>();
        List<Impuesto> impuestoSoloIVA = new ArrayList<>();
        impuestoSoloIVA.add(Impuesto.IVA);

        Factura mockFactura_1 = new Factura(1, 10000000, true, 0, impuestoSoloIVA,  new Date(2010, 11, 21), null, 11111111);
        // TODO: CREAR DETALLES Y AGREGARLOS A LA FACTURA
        List<DetalleFactura> detallesFactura_1 = new ArrayList<>();
        DetalleFactura mockDetalle_1 = new DetalleFactura();
        mockFactura_1.setDetalles(detallesFactura_1);

        facturas.add(mockFactura_1);
    }

    // Methods
    public double facturasPorDiaProveedor(int idProvedor, Date fecha) throws Exception {
        List<Factura> facturas = this.facturaDAO.getAll(Factura.class);
        double montoTotal = 0;
        for (Factura factura: facturas) {
            if (factura.getCuit() == idProvedor || factura.getFecha() == fecha) {
                montoTotal += factura.getMonto();
            }
        }
        return montoTotal;
    };

    public CuentaCorrienteDTO obtenerCuentaCorrienteProveedores(int idProvedor) throws Exception{
        Proveedor proveedor = proveedorDAO.search(idProvedor, Proveedor.class);
        int cuitProveedor= proveedor.getCuit();
        List<NotaDeCredito> notasDeCredito = notaDeCreditoDAO.getAll(NotaDeCredito.class).stream().filter(notaDeCredito -> notaDeCredito.getCuitProveedor() == cuitProveedor).toList();
        List<NotaDeDebito> notasDeDebito = notaDeDebitoDAO.getAll(NotaDeDebito.class).stream().filter(notaDeDebito -> notaDeDebito.getCuitProveedor() == cuitProveedor).toList();
        List<Factura> facturas = facturaDAO.getAll(Factura.class).stream().filter(factura -> factura.getCuitProveedor().equals(cuitProveedor)).toList();
        Double montoCredito = notasDeCredito.stream().mapToDouble(NotaDeCredito::getMonto).sum();
        Double montoDebito = notasDeDebito.stream().mapToDouble(NotaDeDebito::getMonto).sum();

        return  new CuentaCorrienteDTO(proveedor.getNombre(), montoCredito-montoDebito, facturas, notasDeCredito, notasDeDebito);
    };

    public void facturasPorDiaProveedor(int idProvedor){

    };

    public void consultarPrecioPorRubro(){};

    public void totalDeudaPorProveedor(){};

    public double obtenerDeudaPorProveedor(int cuit) throws Exception {
        List<Factura> facturas = this.facturaDAO.getAll(Factura.class);
        List<NotaDeCredito> notasDeCredito = this.notaDeCreditoDAO.getAll(NotaDeCredito.class);
        List<NotaDeDebito> notasDeDebito = this.notaDeDebitoDAO.getAll(NotaDeDebito.class);
        List<ChequePropio> chequesPropio = this.chequePropioDAO.getAll(ChequePropio.class);
        List<ChequeTerceros> chequesTerceros = this.chequeTerceroDAO.getAll(ChequeTerceros.class);

        return proveedorDAO.search(cuit).getDocumentosDeudaProveedor(facturas, notasDeCredito, notasDeDebito, chequesPropio, chequesTerceros);
    };

    public double obtenerImpuestosRetenidos(int cuit) throws Exception {
        List<Factura> facturas = this.facturaDAO.getAll(Factura.class);
        double impuestosRetenidos = 0;
        for (Factura factura: facturas) {
            if (factura.getCuit() != cuit) continue;

            List<Impuesto> impuestos = factura.getImpuestos();
            for (Impuesto impuesto: impuestos) {
                impuestosRetenidos += factura.getMonto() * impuesto.getPercentage();
            }
        }
        return impuestosRetenidos;
    };

    public void consultaLibroIva(){};

    public List<OrdenDePagoDTO> obtenerOrdenesDePago() throws Exception {
        List<OrdenDePagoDTO> resultado = new ArrayList<OrdenDePagoDTO>();
        List<OrdenDePago> ordenesDePago = this.ordenDePagoDAO.getAll(OrdenDePago.class);
        for (OrdenDePago ordenDePago : ordenesDePago){
            OrdenDePagoDTO ordenDePagoDTO = new OrdenDePagoDTO(ordenDePago);
            resultado.add(ordenDePagoDTO);
        }
        return resultado;
    }
}
