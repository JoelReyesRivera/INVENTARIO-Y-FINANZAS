package ClasesBase;
/**
 *
 * @author jasiel
 */
public class Venta {
    private String ClaveVta;
    private String SKUArt;
    private int Cantidad;
    private double PrecioUni;
    private int dia;
    private int mes;
    private int año;

    public Venta(String ClaveVta, String SKUArt, int Cantidad, double PrecioUni,int dia, int mes, int año) {
        this.ClaveVta = ClaveVta;
        this.SKUArt = SKUArt;
        this.Cantidad = Cantidad;
        this.PrecioUni = PrecioUni;
        this.dia = dia;
        this.mes = mes;
        this.año = año;
    }   
    
    public void setDia(int d) {
        dia = d;
    }

    public void setMes(int m) {
        mes  = m;
    }

    public void setAño(int a) {
        año = a;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAño() {
        return año;
    }

    public String getClaveVta() {
        return ClaveVta;
    }

    public String getCSKUArt() {
        return SKUArt;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public double getPrecioUni() {
        return PrecioUni;
    }

    public void setClaveVta(String ClaveVta) {
        this.ClaveVta = ClaveVta;
    }

    public void setSKUArt(String SKUArt) {
        this.SKUArt = SKUArt;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public void setPrecioUni(int precio) {
        PrecioUni = precio;
    }

    public String toString() {
        return ("Clave de la vent :" + ClaveVta + ("\n") + "SKU Articulo :" + SKUArt + ("\n") + "Cantidad de vendidos:" + Cantidad + ("\n") + "Precio :$" + PrecioUni+ String.format("\n Dia %s Mes %s Año %s ", getDia(),getMes(),getAño()) );
    }
}
