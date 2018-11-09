package ClasesBase;

/**
 *
 * @author jasiel
 */
public class Tarro extends Producto{
    private String tipo;
    private int tamano;

    public Tarro(int SKU, double PrecioUni, int Existencia, String tipo, int tamano) {
        super(SKU, PrecioUni, Existencia);
        this.tamano=tamano;
        this.tipo=tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void SetTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getTamano() {
        return tamano;
    }

    public void SetTamano(int tamano) {
        this.tamano = tamano;
    }

    @Override
    public String toString() {
        return (super.toString()+"\nTIPO: " + tipo + "\nTAMAÑO: " + tamano).toUpperCase();
    }

}
