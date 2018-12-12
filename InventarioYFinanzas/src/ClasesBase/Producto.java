package ClasesBase;

public class Producto {

    private double PrecioUni;
    private int Existencia;

    public Producto( double PrecioUni, int Existencia) {
        this.PrecioUni = PrecioUni;
        this.Existencia = Existencia;
    }


    public double getPrecioUni() {
        return PrecioUni;
    }

    public void setPrecioUni(double PrecioUni) {
        this.PrecioUni = PrecioUni;
    }

    public int getExistencia() {
        return Existencia;
    }

    public void setExistencia(int Existencia) {
        this.Existencia = Existencia;
    }

    @Override
    public String toString() {
        return  "\nPRECIO: $" + PrecioUni + " MXN\nEXISTENCIA: " + Existencia;
    }
}