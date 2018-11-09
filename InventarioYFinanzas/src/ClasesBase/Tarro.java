package ClasesBase;

/**
 *
 * @author jasiel
 */
public class Tarro extends Producto{
    private String tipo;
    private String tamaño;

    public Tarro(int SKU, double PrecioUni, int Existencia, String tipo, String tamaño) {
        super(SKU, PrecioUni, Existencia);
        this.tamaño=tamaño;
        this.tipo=tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void SetTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void SetTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    @Override
    public String toString() {
        return (super.toString()+"\nTIPO: " + tipo + "\nTAMAÑO: " + tamaño).toUpperCase();
    }

}
