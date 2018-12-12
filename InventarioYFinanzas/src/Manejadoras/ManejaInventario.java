package Manejadoras;

import ClasesBase.Producto;
import ClasesBase.Tarro;
import ClasesBase.Taza;
import ClasesBase.Textil;
import java.util.Enumeration;
import java.util.Hashtable;

public class ManejaInventario {

    public Hashtable <Integer,Producto> inventario;

    //CONSTRUCTOR
    public ManejaInventario() {
        inventario = new Hashtable();
    }

    //AGREGAR TARRO
    public void agregar(int SKU, Tarro tarro) {
        inventario.put(SKU, tarro);
    }

    //AGREGAR TAZA
    public void agregar(int SKU, Taza taza) {
        inventario.put(SKU, taza);
    }

    //AGREGAR TEXTIL
    public void agregar(int SKU, Textil textil){
        inventario.put(SKU, textil);
    }

    //IMPRIMIR
    public void imprimir() {
        int SKU;
        Enumeration <Integer> enumeracion= inventario.keys();
        while(enumeracion.hasMoreElements()){
        SKU = enumeracion.nextElement();
        if (inventario.get(SKU) instanceof Textil) {
                System.out.println("SKU : " + SKU);
                System.out.println((Textil)inventario.get(SKU));
            }
        if (inventario.get(SKU) instanceof Tarro) {
                System.out.println((Tarro)inventario.get(SKU));
            }
        if (inventario.get(SKU) instanceof Taza) {
                System.out.println((Taza)inventario.get(SKU));
            }
    }
    }
}