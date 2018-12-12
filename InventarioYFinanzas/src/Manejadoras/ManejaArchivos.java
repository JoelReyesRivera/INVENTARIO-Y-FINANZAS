package Manejadoras;

import ClasesBase.Tarro;
import ClasesBase.Taza;
import ClasesBase.Textil;
import java.io.*;
import java.util.Enumeration;
import java.util.StringTokenizer;
/**
 * @author oliverrood
 */
public class ManejaArchivos {
    
    private File inventario;
    
    public ManejaArchivos (String archivoInventario){
        inventario = new File (archivoInventario); 
    }
    
    public void guardarInventario(ManejaInventario productos){
       int tipoProducto,existencia,SKU,talla,tamaño;
       double precio;
       String tela,corte,material,color,tipo;
        try {
           FileWriter fw = new FileWriter ("inventario.txt");
           PrintWriter file = new PrintWriter (fw);
           int key;
           Enumeration <Integer> enumeracion= productos.inventario.keys();
           while(enumeracion.hasMoreElements()){
           key = enumeracion.nextElement();
           precio = productos.inventario.get(key).getPrecioUni();
           existencia = productos.inventario.get(key).getExistencia();
           SKU = key;
           //TEXTIL
           if (productos.inventario.get(key) instanceof Textil) {
                   tipoProducto = 1;
                   Textil textil;
                   textil = (Textil) productos.inventario.get(key);
                   tela= textil.getTela();
                   corte = textil.getCorte();
                   talla= textil.getTalla();
                   file.println( tipoProducto+ " " +SKU + " " + precio + " "+ existencia + " " + tela + " " + corte + " " + talla);
               }
           //TAZA
           if (productos.inventario.get(key) instanceof Taza) {
                    tipoProducto = 2;
                    Taza taza;
                    taza = (Taza) productos.inventario.get(key);
                    material = taza.getMaterial();
                    tamaño = taza.getTamano();
                    color = taza.getColor();
                    file.println(tipoProducto+ " " + SKU + " " + precio + " "+ existencia + " " + material + " " + tamaño + " " + color);
               }
           if (productos.inventario.get(key) instanceof Tarro) {
                   tipoProducto = 3;
                   Tarro tarro;
                   tarro = (Tarro) productos.inventario.get(key);
                   tamaño= tarro.getTamano();
                   tipo= tarro.getTipo();
                   file.println(tipoProducto+ " " + SKU + " " + precio + " "+ existencia + " " + tamaño + " " + tipo);
               }
        }
           file.close();
       } catch (IOException ex) {
            System.out.println("ERROR DE ENTRADA Y SALIDA");
       }
    }
    public void lecturaInventario (ManejaInventario productos){
        double precio;
        String tipo,material,color,tela,corte,linea;
        int existencia, SKU,tamaño,talla,tipoProducto;
        try {
            FileReader file = new FileReader (inventario);
            StringTokenizer tokenizer = null;
            BufferedReader archivoEntrada = new BufferedReader(file);
            linea = archivoEntrada.readLine();
            while (linea != null){
               tokenizer = new StringTokenizer(linea);
               try{
                  tipoProducto = Integer.parseInt(tokenizer.nextToken());
                  SKU = Integer.parseInt(tokenizer.nextToken());
                  precio = Double.parseDouble(tokenizer.nextToken());
                  existencia = Integer.parseInt(tokenizer.nextToken());
                  switch (tipoProducto){
                      //TEXTIL
                      case 1:
                          tela = tokenizer.nextToken();
                          corte = tokenizer.nextToken();
                          talla = Integer.parseInt(tokenizer.nextToken());
                          Textil textil = new Textil (precio,existencia,tela,corte,talla);
                          productos.agregar(SKU, textil);
                          break;
                      //TAZA
                      case 2:
                          material = tokenizer.nextToken();
                          tamaño = Integer.parseInt(tokenizer.nextToken());
                          color = tokenizer.nextToken();
                          Taza taza = new Taza (precio,existencia,material,tamaño,color);
                          productos.agregar(SKU, taza);
                          break;
                      //TARRO
                      case 3:
                          tipo = tokenizer.nextToken();
                          tamaño = Integer.parseInt(tokenizer.nextToken());
                          Tarro tarro = new Tarro (precio,existencia,tipo,tamaño);
                          productos.agregar(SKU, tarro);
                          break;
                  }
               }catch (NumberFormatException formatoNumero){
                   System.out.println("LINEA ERRONEA " + linea);
               }
                linea = archivoEntrada.readLine();
            }
            
        } catch (FileNotFoundException ex) {
            System.out.println("NO SE ENCONTRO EL ARCHIVO");
        } catch (IOException ex) {
            System.out.println("ERROR DE ENTRADA Y SALIDA");
        }
    }
}
