package Manejadoras;
import ClasesBase.Cliente;
import ClasesBase.Empleado;
import ClasesBase.Persona;
import java.util.ArrayList;

/**
 *
 * @author ADM-PC
 */
public class ManejaPersonas {
    
   public ArrayList <Persona> personas;
   
   //CONSTRUCTOR
   public ManejaPersonas(){
        personas=  new ArrayList<Persona> ();
   }
   //AGREGAR EMPLEADO CON TODOS SUS ATRIBUTOS
   public void agregar(String nombre, String apellido, long telefono, String RFC, String email, int idEmpleado,double sueldo){
       personas.add(new Empleado(nombre,  apellido,  telefono,  RFC,  email,  idEmpleado, sueldo));
   }
   //AGREGAR EMPLEADO SIN RFC Y EMAIL
   public void agregar(String nombre, String apellido, long telefono, int idEmpleado, double sueldo){
       personas.add(new Empleado( nombre,  apellido,  telefono,  idEmpleado,  sueldo));
   }
   //AGREGAR EMPLEADO SIN RFC
   public void agregar(String nombre, String apellido, long telefono, String email, int idEmpleado,double sueldo){
       personas.add(new Empleado(nombre,apellido,telefono, email, idEmpleado,sueldo));
   }
   //AGREGAR CLIENTE CON TODOS SUS ATRIBUTOS
   public void agregar(String nombre, String apellido, long telefono, String RFC, String email,int totalCompras ){
       personas.add(new Cliente ( nombre,apellido,telefono,RFC,email,totalCompras ));
   }
   //AGREGAR CLIENTE SIN RFC Y EMAIL
   public void agregar(String nombre, String apellido, long telefono,int totalCompras ){
       personas.add(new Cliente (nombre, apellido,telefono, totalCompras));
   }
   //AGREGAR CLIENTE SIN RFC
   public void agregar(String nombre, String apellido, long telefono,String email,int totalCompras  ){
       personas.add(new Cliente (nombre,apellido, telefono,email,totalCompras ));
   }
   //BUSCAR CLIENTE
   public int buscarCliente(int clave){
       int posicion=-1;
       for (Persona persona: personas) {
           if (persona!=null) {
               if (persona instanceof Cliente) {
                   if (((Cliente) persona).getIdCliente()==clave) {
                       posicion=personas.indexOf(persona);
                   }
               }
           }
                   
       }
       return posicion;
   }
   //BUSCAR EMPLEADO
   public int buscarEmpleado(int clave){
       int posicion=-1;
       for (Persona persona: personas) {
           if (persona!=null) {
               if (persona instanceof Empleado) {
                   if (((Empleado) persona).getIdEmpleado()==clave) {
                       posicion=personas.indexOf(persona);
                   }
               }
           }
                   
       }
       return posicion;
   }
   //IMPRIMIR
   public void imprimir(int caso){
      switch(caso){
          case 1 :
              for (Persona persona : personas) {
                  if(persona!=null)
                  System.out.println(persona);
              }
              break;
          case 2 :
              for (Persona persona : personas) {
                  if(persona!=null){
                      if (persona instanceof Cliente) {
                          System.out.println((Cliente)persona);
                      }
                  }
              }
              break;
          case 3:
               for (Persona persona : personas) {
                  if(persona!=null){
                      if (persona instanceof Empleado) {
                          System.out.println((Empleado)persona);
                      }
                  }
              }
              break;
      }
   }
}
