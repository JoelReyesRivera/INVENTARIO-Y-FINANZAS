package base;

/**
 * @author oliverrood
 */
public class Producto {

    private int SKU;
    private double PrecioUni;
    private int Existencia;

    public Producto(int SKU, double PrecioUni, int Existencia) {
        this.SKU = SKU;
        this.PrecioUni = PrecioUni;
        this.Existencia = Existencia;
    }

    public int getSKU() {
        return SKU;
    }

    public void SetSKU(int Sku) {
        this.SKU = Sku;
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
        return "\nSku: " + SKU + "\nPrecio por unidad: $" + PrecioUni + "\nExistencia: " + Existencia;
    }
}
