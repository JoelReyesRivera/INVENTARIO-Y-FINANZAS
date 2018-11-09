package ClasesBase;

public class Textil extends Producto {

    private String tela;
    private String corte;
    private int talla;

    public Textil(int SKU, double PrecioUni, int Existencia, String tela, String corte, int talla) {
        super(SKU, PrecioUni, Existencia);
        this.tela = tela;
        this.corte = corte;
        this.talla = talla;
    }

    public String getTela() {
        return tela;
    }

    public void SetTela(String tela) {
        this.tela = tela;
    }

    public String getCorte() {
        return corte;
    }

    public void SetCorte(String corte) {
        this.corte = corte;
    }

    public int getTalla() {
        return talla;
    }

    public void SetTalla(int talla) {
        this.talla = talla;
    }

    @Override
    public String toString() {
        return (super.toString() + "\nTELA: " + tela + "\nCORTE: " + corte + "\nTALLA: " + talla).toUpperCase();
    }
}