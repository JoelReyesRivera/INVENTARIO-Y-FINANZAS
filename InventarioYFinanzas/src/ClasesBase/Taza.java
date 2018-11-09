package ClasesBase;

/**
 *
 * @author jasiel
 */
public class Taza extends Producto {

    private String material;
    private int tamano;
    private String color;

    public Taza(int SKU, double PrecioUni, int Existencia, String material, int tamano, String color) {
        super(SKU, PrecioUni, Existencia);
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
        return (super.toString() + "\nMATERIAL: " + material + "\nCOLOR: " + color + "\nTAMAÑO: " + tamano).toUpperCase();
    }
}

