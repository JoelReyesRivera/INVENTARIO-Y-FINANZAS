package ClasesBase;
/**
 *
 * @author jasiel
 */
public class Venta {
    private String ClaveVta;
    private int ClaveArt;
    private int Cantidad;
    private double PrecioUni;

    public Venta(String ClaveVta, int ClaveArt, int Cantidad, double PrecioUni) {
        this.ClaveVta = ClaveVta;
        this.ClaveArt = ClaveArt;
        this.Cantidad = Cantidad;
        this.PrecioUni = PrecioUni;
    }

    public String getClaveVta() {
        return ClaveVta;
    }

    public int getClaveAt() {
        return ClaveArt;
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

    public void setClaveArt(int ClaveArt) {
        this.ClaveArt = ClaveArt;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public void setPrecioUni(int precio) {
        PrecioUni = precio;
    }

    public String toString() {
        return ("Clave de la vent :" + ClaveVta + ("\n") + "Clave Articulo :" + ClaveArt + ("\n") + "Cantidad de vendidos:" + Cantidad + ("\n") + "Precio :$" + PrecioUni);
    }
}
