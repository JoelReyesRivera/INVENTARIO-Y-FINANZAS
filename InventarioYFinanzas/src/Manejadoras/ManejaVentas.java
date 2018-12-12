package Manejadoras;

import ClasesBase.Empleado;
import java.util.ArrayList;
import ClasesBase.Venta; 
import ClasesBase.Fecha;
import Utileria.Keyboard;


public class ManejaVentas {
    
    public ArrayList <Venta> Ventas;
    public Fecha f=new Fecha(9,11,2018);
    
    //CONSTRUCTOR
     public ManejaVentas(){
        Ventas=  new ArrayList<Venta> ();
     }
     
    //Agregar
     public void Agregar(String ClaveVta, int SKU, int Cantidad, double PrecioUni,int dia, int mes,int año, int cliente, int empleado) {
        Ventas.add(new Venta(ClaveVta,SKU,Cantidad,PrecioUni,f.getDia(),f.getMes(),f.getAño(), cliente,empleado));
    }
     public int buscarVenta(String clave) {
        int posicion = -1;
        for (Venta venta: Ventas) {
            if (venta != null) {
                    if (venta.getClaveVta().equals(clave)) {
                       //return Ventas.indexOf(clave);
                        posicion = Ventas.indexOf(venta);
                }
            }
        }
        return posicion;
    }
     
    //IMPRIMIR
   public void Imprimir() {
        for (int i = 0; i < Ventas.size(); i++) {
            System.out.println("VENTA NUMERO :" + (i + 1) + "\n" + Ventas.get(i));
            System.out.println("---");
        }
    }
   
    //BORRAR
    public void Borrar(String ClaveVta, ManejaInventario ManejaInventarios, ManejaPersonas manejaPersona) {
        for (int i = 0; i < Ventas.size(); i++) {
            double monto = (ManejaInventarios.inventario.get(Ventas.get(i).getCSKUArt()).getPrecioUni() * Ventas.get(i).getCantidad());
            if (Ventas.get(i).getClaveVta().equals(ClaveVta));
            {
                Ventas.remove(Ventas.get(i));
                int a = ((Empleado) manejaPersona.personas.get(manejaPersona.buscarEmpleado(Ventas.get(i).getIdEmpleado()))).getVentas();
                ((Empleado) manejaPersona.personas.get(manejaPersona.buscarEmpleado(Ventas.get(i).getIdEmpleado()))).setVentas(a - 1);
                double b=(monto * ((Empleado) manejaPersona.personas.get(manejaPersona.buscarEmpleado(Ventas.get(i).getIdEmpleado()))).getPorcentaje());
                ((Empleado) manejaPersona.personas.get(manejaPersona.buscarEmpleado(Ventas.get(i).getIdEmpleado()))).setComisiones(((Empleado) manejaPersona.personas.get(manejaPersona.buscarEmpleado(Ventas.get(i).getIdEmpleado()))).getComisiones()-b);
            }
        }
   }
}
   
   
   
 

   
   

