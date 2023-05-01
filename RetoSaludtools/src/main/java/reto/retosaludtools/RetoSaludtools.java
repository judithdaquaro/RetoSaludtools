package reto.retosaludtools;

import java.util.Scanner;

public class RetoSaludtools {

    public static void main(String[] args) {

        Factura factura = new Factura();
        Scanner leer = new Scanner(System.in);
        
        System.out.println(" BIENVENIDO! ");
        System.out.println("------------------------------------------------------------------------");
        factura.AgregarProducto();
        int opc;
        System.out.println(" ");
        System.out.println("------------------------------------------------------------------------");
        System.out.println(" ELIMINAR UN PRODUCTO");
        System.out.println("------------------------------------------------------------------------");
        System.out.println("Elimina un producto 1 para eliminar 2 para no ");
        System.out.println("------------------------------------------------------------------------");
        System.out.print(" ->Opcion: ");
        opc = leer.nextInt();
        while (opc == 1) {
        factura.EliminarProducto();
            System.out.println("");
            System.out.println("------------------------------------------------------------------------");
            System.out.println(" ELIMINAR UN PRODUCTO");
            System.out.println("------------------------------------------------------------------------");
            System.out.println("Elimina un producto 1 para eliminar 2 para no ");
            System.out.println("------------------------------------------------------------------------");
            System.out.print(" ->Opcion: ");
            opc = leer.nextInt();
        }
        factura.CalcularTotal();

    }
}
