package Manejadoras;

import ClasesBase.Cliente;
import ClasesBase.Empleado;
import ClasesBase.Persona;
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
    
    // TXT PRODUCTOS
    public void guardarInventario(ManejaInventario productos) {
        int tipoProducto, existencia, SKU, talla, tamaño;
        double precio;
        String tela, corte, material, color, tipo;
        try {
            FileWriter fw = new FileWriter("inventario.txt");
            PrintWriter file = new PrintWriter(fw);
            int key;
            Enumeration<Integer> enumeracion = productos.inventario.keys();
            while (enumeracion.hasMoreElements()) {
                key = enumeracion.nextElement();
                precio = productos.inventario.get(key).getPrecioUni();
                existencia = productos.inventario.get(key).getExistencia();
                SKU = key;
                //TEXTIL
                if (productos.inventario.get(key) instanceof Textil) {
                    tipoProducto = 1;
                    Textil textil;
                    textil = (Textil) productos.inventario.get(key);
                    tela = textil.getTela();
                    corte = textil.getCorte();
                    talla = textil.getTalla();
                    file.println(tipoProducto + " " + SKU + " " + precio + " " + existencia + " " + tela + " " + corte + " " + talla);
                }
                //TAZA
                if (productos.inventario.get(key) instanceof Taza) {
                    tipoProducto = 2;
                    Taza taza;
                    taza = (Taza) productos.inventario.get(key);
                    material = taza.getMaterial();
                    tamaño = taza.getTamano();
                    color = taza.getColor();
                    file.println(tipoProducto + " " + SKU + " " + precio + " " + existencia + " " + material + " " + tamaño + " " + color);
                }
                if (productos.inventario.get(key) instanceof Tarro) {
                    tipoProducto = 3;
                    Tarro tarro;
                    tarro = (Tarro) productos.inventario.get(key);
                    tamaño = tarro.getTamano();
                    tipo = tarro.getTipo();
                    file.println(tipoProducto + " " + SKU + " " + precio + " " + existencia + " " + tamaño + " " + tipo);
                }
            }
            file.close();
        } catch (IOException ex) {
            System.out.println("ERROR DE ENTRADA Y SALIDA");
        }
    }

    public void lecturaInventario(ManejaInventario productos) {
        double precio;
        String tipo, material, color, tela, corte, linea;
        int existencia, SKU, tamaño, talla, tipoProducto;
        try {
            FileReader file = new FileReader(inventario);
            StringTokenizer tokenizer = null;
            BufferedReader archivoEntrada = new BufferedReader(file);
            linea = archivoEntrada.readLine();
            while (linea != null) {
                tokenizer = new StringTokenizer(linea);
                try {
                    tipoProducto = Integer.parseInt(tokenizer.nextToken());
                    SKU = Integer.parseInt(tokenizer.nextToken());
                    precio = Double.parseDouble(tokenizer.nextToken());
                    existencia = Integer.parseInt(tokenizer.nextToken());
                    switch (tipoProducto) {
                        //TEXTIL
                        case 1:
                            tela = tokenizer.nextToken();
                            corte = tokenizer.nextToken();
                            talla = Integer.parseInt(tokenizer.nextToken());
                            Textil textil = new Textil(precio, existencia, tela, corte, talla);
                            productos.agregar(SKU, textil);
                            break;
                        //TAZA
                        case 2:
                            material = tokenizer.nextToken();
                            tamaño = Integer.parseInt(tokenizer.nextToken());
                            color = tokenizer.nextToken();
                            Taza taza = new Taza(precio, existencia, material, tamaño, color);
                            productos.agregar(SKU, taza);
                            break;
                        //TARRO
                        case 3:
                            tipo = tokenizer.nextToken();
                            tamaño = Integer.parseInt(tokenizer.nextToken());
                            Tarro tarro = new Tarro(precio, existencia, tipo, tamaño);
                            productos.agregar(SKU, tarro);
                            break;
                    }
                } catch (NumberFormatException formatoNumero) {
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
    
    // BYTES PERSONAS
    
    public void guardarPersonasB (ManejaPersonas manejaPersona){
        
        try{
            ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(inventario, false));
            String nombre, apellido, rfc;
            long telefono;
            int idCliente, totalCompras;
            int idEmpleado, ventas;
            double sueldo, porcentaje, comisiones;
            for (Persona persona : manejaPersona.personas) {
                if (persona != null) {
                    nombre=persona.getNombre();
                    apellido=persona.getApellido();
                    rfc=persona.getRFC();
                    telefono=persona.getTelefono();
                    if (persona instanceof Cliente) {
                        idCliente=((Cliente)persona).getIdCliente();
                        totalCompras=((Cliente)persona).getTotalCompras();
                        file.writeObject(new Cliente(idCliente, totalCompras, nombre, apellido, telefono, rfc));
                    }
                    if (persona instanceof Empleado) {
                        idEmpleado=((Empleado)persona).getIdEmpleado();
                        sueldo=((Empleado)persona).getSueldo();
                        ventas=((Empleado)persona).getVentas();
                        comisiones=((Empleado)persona).getComisiones();
                        porcentaje=((Empleado)persona).getPorcentaje();
                        file.writeObject(new Empleado(idEmpleado, sueldo, ventas, comisiones, porcentaje, nombre, apellido, telefono, rfc));
                    }
                }
            }
            file.close();
        } catch (IOException ex) {
            System.out.println(ex);
        }

        System.out.println("\nARCHIVO " + inventario.getName() + " GUARDADO CORRECTAMENTE.");
        
    }
    
    // TXT PERSONAS
    
    public void guardarPersonas(ManejaPersonas manejaPersona) {
        
        try {
            int tipoPersona;
            String nombre, apellido, rfc;
            long telefono;
            int idCliente, totalCompras;
            int idEmpleado, ventas;
            double sueldo, porcentaje, comisiones;
            FileWriter fw = new FileWriter("personas.txt");
            PrintWriter file = new PrintWriter(fw);
            int key;
            for (Persona persona : manejaPersona.personas) {
                if (persona != null) {
                    nombre=persona.getNombre();
                    apellido=persona.getApellido();
                    rfc=persona.getRFC();
                    telefono=persona.getTelefono();
                    if (persona instanceof Cliente) {
                        tipoPersona=1;
                        idCliente=((Cliente)persona).getIdCliente();
                        totalCompras=((Cliente)persona).getTotalCompras();
                        file.println(tipoPersona+" "+nombre+" "+apellido+" "+telefono+" "+rfc+" "+idCliente+" "+totalCompras);
                    }
                    if (persona instanceof Empleado) {
                        tipoPersona=2;
                        idEmpleado=((Empleado)persona).getIdEmpleado();
                        sueldo=((Empleado)persona).getSueldo();
                        ventas=((Empleado)persona).getVentas();
                        comisiones=((Empleado)persona).getComisiones();
                        porcentaje=((Empleado)persona).getPorcentaje();
                        file.println(tipoPersona+" "+nombre+" "+apellido+" "+telefono+" "+rfc+" "+idEmpleado+" "+sueldo+" "+ventas+" "+comisiones+" "+porcentaje);
                    }
                }
            }
            file.close();
        } catch (IOException ex) {
            System.out.println("ERROR DE ENTRADA Y SALIDA");
        }
    }

    public void lecturaPersonas(ManejaPersonas manejaPersonas) {
        
        String linea;
        try {
            int tipoPersona;
            String nombre, apellido, rfc;
            long telefono;
            int idCliente, totalCompras;
            int idEmpleado, ventas;
            double sueldo, porcentaje, comisiones;
            FileReader file = new FileReader(inventario);
            StringTokenizer tokenizer = null;
            BufferedReader archivoEntrada = new BufferedReader(file);
            linea = archivoEntrada.readLine();
            while (linea != null) {
                tokenizer = new StringTokenizer(linea);
                try {
                    tipoPersona= Integer.parseInt(tokenizer.nextToken());
                    nombre = tokenizer.nextToken();
                    apellido = tokenizer.nextToken();
                    telefono = Long.parseLong(tokenizer.nextToken());
                    rfc = tokenizer.nextToken();
                    switch (tipoPersona) {
                        case 1:
                            idCliente= Integer.parseInt(tokenizer.nextToken());
                            totalCompras = Integer.parseInt(tokenizer.nextToken());
                            if (manejaPersonas.buscarCliente(idCliente)==-1) {
                                manejaPersonas.agregar(idCliente, totalCompras, nombre, apellido, telefono, rfc);
                            } else{
                                System.out.println("CLIENTE "+nombre+" YA EXISTENTE.");
                            }
                            break;
                        case 2:
                            idEmpleado=Integer.parseInt(tokenizer.nextToken());
                            sueldo=Double.parseDouble(tokenizer.nextToken());
                            ventas=Integer.parseInt(tokenizer.nextToken());
                            comisiones=Double.parseDouble(tokenizer.nextToken());
                            porcentaje=Double.parseDouble(tokenizer.nextToken());
                            if (manejaPersonas.buscarEmpleado(idEmpleado)==-1) {
                                manejaPersonas.agregar(idEmpleado, sueldo, ventas, comisiones, porcentaje, nombre, apellido, telefono, rfc);
                            }
                            break;
                        default:
                            throw new AssertionError();
                    }
                } catch (NumberFormatException formatoNumero) {
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
    
    /*
    
    SIRVE PARA TESTEO
    
    public void lecturaPersonasB (){
        
        try{
            ObjectInputStream file = new ObjectInputStream(new FileInputStream(inventario));
            String nombre;
            Object actual = null;
            while ((actual = file.readObject()) != null) {
                nombre=((Persona) actual).getNombre();
                System.out.println("\nNOMBRE: "+nombre);
            }
            file.close();
        } catch (EOFException e) {
            System.out.println("ARCHIVO LEIDO");
        }catch (ClassNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        }
        
    }
    
    */
    
}
