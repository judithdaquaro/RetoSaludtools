
package reto.retosaludtools;

public class Producto {
    int IdProducto;
    String DescripProducto;
    double Valor;
    
    //Constructor inicializar variables
    public Producto(){
        IdProducto = 0;
        DescripProducto = "";
        Valor = 0;
    }
    
    //Constructor Sobrecarga metodos
    public Producto(int n, String d, double v)
    {
        IdProducto = n;
        DescripProducto = d;
        Valor = v;
    }

    public int getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(int IdProducto) {
        this.IdProducto = IdProducto;
    }

    public String getDescripProducto() {
        return DescripProducto;
    }

    public void setDescripProducto(String DescripProducto) {
        this.DescripProducto = DescripProducto;
    }

    public double getValor() {
        return Valor;
    }

    public void setValor(double Valor) {
        this.Valor = Valor;
    }
    
    
}
