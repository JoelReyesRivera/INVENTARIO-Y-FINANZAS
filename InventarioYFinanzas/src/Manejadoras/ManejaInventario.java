package Manejadoras;

import ClasesBase.Producto;
import ClasesBase.Tarro;
import ClasesBase.Taza;
import ClasesBase.Textil;
import java.util.ArrayList;

public class ManejaInventario {

    public ArrayList<Producto> inventario;

    //CONSTRUCTOR
    public ManejaInventario() {
        inventario = new ArrayList<Producto>();
    }

    //AGREGAR TARRO

    public void agregar(int SKU, double PrecioUni, int Existencia, String tipo, String tamaño) {
        inventario.add(new Tarro(SKU, PrecioUni, Existencia, tipo, tamaño));
    }

    //AGREGAR TAZA

    public void agregar(int SKU, double PrecioUni, int Existencia, String material, String color, String tamaño) {
        inventario.add(new Taza(SKU, PrecioUni, Existencia, material, color, tamaño));
    }

    //AGREGAR TEXTIL

    public void agregar(int SKU, double PrecioUni, int Existencia, String tela, String corte, int talla) {
        inventario.add(new Textil(SKU, PrecioUni, Existencia, tela, corte, talla));
    }

    //IMPRIMIR
    public void imprimir(int caso) {
        switch (caso) {
            case 1:
                for (Producto producto : inventario) {
                    if (producto != null) {
                        System.out.println(producto);
                    }
                }
                break;
            case 2:
                for (Producto producto : inventario) {
                    if (producto != null) {
                        if (producto instanceof Tarro) {
                            System.out.println((Tarro) producto);
                        }
                    }
                }
                break;
            case 3:
                for (Producto producto : inventario) {
                    if (producto != null) {
                        if (producto instanceof Taza) {
                            System.out.println((Taza) producto);
                        }
                    }
                }
                break;
            case 4:
                for (Producto producto : inventario) {
                    if (producto != null) {
                        if (producto instanceof Textil) {
                            System.out.println((Textil) producto);
                        }
                    }
                }
                break;
        }
    }

    //BUSCAR PRODUCTO
    public int buscarProducto(int SKU) {
        int posicion = -1;
        for (Producto producto : inventario) {
            if (producto != null) {
                if (producto.getSKU() == SKU) {
                    posicion = inventario.indexOf(producto);
                    return posicion;
                }

            }
        }
        return posicion;
    }
}
