package reto.retosaludtools;

import java.util.Scanner;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

public class Factura extends Producto {

    int NumFactura;
    String NomPagador;
    String IdPagador;
    double IVA;
    double ReteIva;
    double ReteFuente;
    double ReteIca;
    double PrecioTotal;
    //Producto ListaProductos[] = new Producto[2];
    List<Producto> ListaProductos = new ArrayList<>();
    Scanner leer = new Scanner(System.in);

    //Constructor inicializar variables
    public Factura() {
        NumFactura = 0;
        NomPagador = "";
        IdPagador = "";
        IVA = 0;
        ReteIva = 0;
        ReteFuente = 0;
        ReteIca = 0;
        PrecioTotal = 0;
    }

    public int getNumFactura() {
        return NumFactura;
    }

    public void setNumFactura(int NumFactura) {
        this.NumFactura = NumFactura;
    }

    public String getNomPagador() {
        return NomPagador;
    }

    public void setNomPagador(String NomPagador) {
        this.NomPagador = NomPagador;
    }

    public String getIdPagador() {
        return IdPagador;
    }

    public void setIdPagador(String IdPagador) {
        this.IdPagador = IdPagador;
    }

    public double getReteIva() {
        return ReteIva;
    }

    public void setReteIva(double ReteIva) {
        this.ReteIva = ReteIva;
    }

    public double getReteFuente() {
        return ReteFuente;
    }

    public void setReteFuente(double ReteFuente) {
        this.ReteFuente = ReteFuente;
    }

    public double getReteIca() {
        return ReteIca;
    }

    public void setReteIca(double ReteIca) {
        this.ReteIca = ReteIca;
    }

    //public Producto[] getListaProductos() {
    //   return ListaProductos;
    //}
    //public void setListaProductos(Producto[] ListaProductos) {
    //    this.ListaProductos = ListaProductos;
    //}
    public double getPrecioTotal() {
        return PrecioTotal;
    }

    public void setPrecioTotal(double PrecioTotal) {
        this.PrecioTotal = PrecioTotal;
    }

    //Metodo Agregar Productos
    public void AgregarProducto() {
        for (int i = 0; i < 3; i++) {
            System.out.println(" INGRESA PRODUCTO [" + (i + 1) + "] ");
            System.out.println("------------------------------------------------------------------------");
            System.out.print(" ->Ingresa id del producto: ");
            IdProducto = leer.nextInt();
            leer.nextLine();
            System.out.print(" ->Ingresa nombre del producto: ");
            DescripProducto = leer.nextLine();
            System.out.print(" ->Ingresa valor del producto: ");
            Valor = leer.nextDouble();
            leer.nextLine(); //Limpiar buffer
            System.out.println("------------------------------------------------------------------------");
            ListaProductos.add(new Producto(IdProducto, DescripProducto, Valor));
        }
        System.out.println(" ");
        System.out.println(" PRODUCTOS ");
        System.out.println("------------------------------------------------------------------------");
        for (Producto producto : ListaProductos) {
            System.out.println("ID " + producto.getIdProducto() + "|Producto " + producto.getDescripProducto() + "|Valor $" + producto.getValor());
            System.out.println("------------------------------------------------------------------------");
            
        }

    }

    //Metodo Eliminar Productos
    public void EliminarProducto() {
        System.out.println("------------------------------------------------------------------------");
        System.out.println(" Eliminar Producto de la factura ");
        System.out.println("------------------------------------------------------------------------");
        System.out.print("Ingrese el ID del producto a eliminar: ");
        int idProducto = leer.nextInt();

        boolean encontrado = false;
        for (int i = 0; i < ListaProductos.size(); i++) {
            if (ListaProductos.get(i).getIdProducto() != idProducto) {
            } else {
                ListaProductos.remove(i);
                System.out.println("Se elimino el producto correctamente.");
                encontrado = true;
                break;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontró ningún producto con el ID ingresado.");
            System.out.println("------------------------------------------------------------------------");

        }

    }

    //Metodo Calcular Total
    public void CalcularTotal() {
        double ValorCompra = 0;
        double TRetencion;
        double TFacturado;
        for (Producto producto : ListaProductos) {
            ValorCompra += producto.getValor();
        }
        IVA = ValorCompra * 0.19;
        TFacturado = IVA + ValorCompra;
        ReteIva = IVA * 0.15;
        ReteFuente = ValorCompra * 0.025;
        ReteIca = ValorCompra * (4.14 / 1000);
        TRetencion = ReteIva + ReteFuente + ReteIca;
        PrecioTotal = TFacturado - TRetencion;
        Random rand = new Random();
        NumFactura = rand.nextInt(1000);
        leer.nextLine(); //Limpiar buffer
        System.out.println(" ");
        System.out.println("------------------------------------------------------------------------");
        System.out.println(" FACTURACION ");
        System.out.println("------------------------------------------------------------------------");
        System.out.print("Ingresa Nombre del Pagador: ");
        NomPagador = leer.nextLine();
        System.out.print("Ingresa ID del Pagador: ");
        IdPagador = leer.nextLine();
        System.out.println("------------------------------------------------------------------------");
        System.out.println(" ");
        System.out.println("------------------------------------------------------------------------");
        System.out.println("   FACTURA NRO." + NumFactura);
        System.out.println("------------------------------------------------------------------------");
        System.out.println("  Pagador:" + NomPagador + "  ID:" + IdPagador);

        for (int i = 0; i < ListaProductos.size(); i++) {
            Producto ListaProducto = ListaProductos.get(i);
            System.out.println("------------------------------------------------------------------------");
            System.out.println("ID " + ListaProducto.getIdProducto() + "|Producto " + ListaProducto.getDescripProducto() + "|Valor $" + ListaProducto.getValor());
        }

        System.out.println("------------------------------------------------------------------------");
        System.out.println(" Valor Compra $" + ValorCompra);
        System.out.println(" IVA $" + IVA);
        System.out.println("------------------------------------------------------------------------");
        System.out.println(" Valor total facturado $" + TFacturado);
        System.out.println("------------------------------------------------------------------------");
        System.out.println(" Retecion por renta $" + ReteFuente);
        System.out.println(" Retecion por ICA $" + ReteIca);
        System.out.println(" Retecion por IVA $" + ReteIva);
        System.out.println("------------------------------------------------------------------------");
        System.out.println(" Total Retenciones $" + TRetencion);
        System.out.println("------------------------------------------------------------------------");
        System.out.println("Total a pagar:" + PrecioTotal);
        
    }
}
