package ClasesBase;

public class Taza extends Producto {

    private String material;
    private int tamano;
    private String color;

    public Taza( double PrecioUni, int Existencia, String material, int tamano, String color) {
        super(PrecioUni, Existencia);
        this.material = material;
        this.tamano = tamano;
        this.color = color;
    }

    public String getMaterial() {
        return material;
    }

    public void SetMaterial(String material) {
        this.material = material;
    }

    public String getColor() {
        return color;
    }

    public void SetColor(String color) {
        this.color = color;
    }

    public int getTamano() {
        return tamano;
    }

    public void SetTamano(int tamano) {
        this.tamano = tamano;
    }

    @Override
    public String toString() {
        return ("\nTAZA"+super.toString() + "\nMATERIAL: " + material + "\nCOLOR: " + color + "\nTAMAÑO: " + tamano).toUpperCase();
    }
}