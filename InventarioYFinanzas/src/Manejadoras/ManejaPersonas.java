package Manejadoras;

import ClasesBase.Cliente;
import ClasesBase.Empleado;
import ClasesBase.Persona;
import java.util.ArrayList;

public class ManejaPersonas {

    public ArrayList<Persona> personas;

    //CONSTRUCTOR
    public ManejaPersonas() {
        personas = new ArrayList<Persona>();
    }

    //AGREGAR EMPLEADO CON TODOS SUS ATRIBUTOS
    public void agregar(String nombre, String apellido, long telefono, String RFC, double sueldo, double porcentaje) {
        personas.add(new Empleado(nombre, apellido, telefono, RFC, sueldo, porcentaje));
    }

    //AGREGAR EMPLEADO SIN RFC
    public void agregar(String nombre, String apellido, long telefono, double sueldo) {
        personas.add(new Empleado(nombre, apellido, telefono, sueldo));
    }

    //AGREGAR CLIENTE CON TODOS SUS ATRIBUTOS
    public void agregar(String nombre, String apellido, long telefono, String RFC) {
        personas.add(new Cliente(nombre, apellido, telefono, RFC));
    }

    //AGREGAR CLIENTE SIN RFC
    public void agregar(String nombre, String apellido, long telefono) {
        personas.add(new Cliente(nombre, apellido, telefono));
    }
    
    // AGREGAR CLIENTE (ARCHIVOS)
    public void agregar(int idCliente, int totalCompras, String nombre, String apellido, long telefono, String RFC){
        personas.add(new Cliente(idCliente, totalCompras, nombre, apellido, telefono, RFC));
    }

    // AGREGAR EMPLEADO (ARCHIVOS)
    public void agregar(int idEmpleado, double sueldo, int ventas, double comisiones, double porcentaje, String nombre, String apellido, long telefono, String RFC){
        personas.add(new Empleado(idEmpleado, sueldo, ventas, comisiones, porcentaje, nombre, apellido, telefono, RFC));
    }
    
    //BUSCAR CLIENTE
    public int buscarCliente(int clave) {
        int posicion = -1;
        for (Persona persona : personas) {
            if (persona != null) {
                if (persona instanceof Cliente) {
                    if (((Cliente) persona).getIdCliente() == clave) {
                        posicion = personas.indexOf(persona);
                    }
                }
            }
        }
        return posicion;
    }

    //BUSCAR EMPLEADO
    public int buscarEmpleado(int clave) {
        int posicion = -1;
        for (Persona persona : personas) {
            if (persona != null) {
                if (persona instanceof Empleado) {
                    if (((Empleado) persona).getIdEmpleado() == clave) {
                        posicion = personas.indexOf(persona);
                    }
                }
            }

        }
        return posicion;
    }

    //IMPRIMIR
    public void imprimir(int caso) {
        switch (caso) {
            case 1:
                for (Persona persona : personas) {
                    if (persona != null) {
                        System.out.println(persona);
                    }
                }
                break;
            case 2:
                for (Persona persona : personas) {
                    if (persona != null) {
                        if (persona instanceof Cliente) {
                            System.out.println((Cliente) persona);
                        }
                    }
                }
                break;
            case 3:
                for (Persona persona : personas) {
                    if (persona != null) {
                        if (persona instanceof Empleado) {
                            System.out.println((Empleado) persona);
                        }
                    }
                }
                break;
        }
    }
    
    public boolean hayClientes(){
        for (Persona persona : personas) {
                    if (persona != null) {
                        if (persona instanceof Cliente) {
                            return true;
                        }
                    }
                }
        return false;
    }
    
    public boolean hayEmpleados(){
        for (Persona persona : personas) {
                    if (persona != null) {
                        if (persona instanceof Empleado) {
                            return true;
                        }
                    }
                }
        return false;
    }
}