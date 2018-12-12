package ClasesBase;

public class Tarro extends Producto {

    private String tipo;
    private int tamano;

    public Tarro(double PrecioUni, int Existencia, String tipo, int tamano) {
        super(PrecioUni, Existencia);
        this.tamano = tamano;
        this.tipo = tipo;
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
        return ("\nTARRO"+super.toString() + "\nTIPO: " + tipo + "\nTAMAÑO: " + tamano).toUpperCase();
    }

}