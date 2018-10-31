package ClasesBase;
/**
 *
 * @author jasiel
 */
public class Pago {

    private String Metodo;
    private double importe;

    public Pago(String Metodo, double importe) {
        this.Metodo = Metodo;
        this.importe = importe;
    }

    public String getMetodo() {
        return Metodo;
    }

    public void SetMetodo(String Metodo) {
        this.Metodo = Metodo;
    }

    public double getimporte() {
        return importe;
    }

    public void SetImporte(int importe) {
        this.importe = importe;
    }

    @Override
    public String toString() {
        return "\nMetodo: " + Metodo + "\nImporte: $" + importe;
    }
}
