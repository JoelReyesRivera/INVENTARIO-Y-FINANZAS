package Manejadoras;


import ClasesBase.Empleado;
import java.util.ArrayList;
import ClasesBase.Venta; 


public class ManejaVentas {
    public ArrayList <Venta> Ventas;
    
    //CONSTRUCTOR
     public ManejaVentas(){
        Ventas=  new ArrayList<Venta> ();
     }
     
    //Agregar
     public void agregar(String ClaveVta, int ClaveArt, int Cantidad, double PrecioUni) {
        Ventas.add(new Venta(ClaveVta,ClaveArt,Cantidad,PrecioUni));
    }
     
    //IMPRIMIR
   public void imprimir(){ 
       for(int i=0;i<Ventas.size();i++){
           System.out.println("Venta numero :"+(i + 1) + ":" + "\n" + Ventas.get(i));
       }
   }
   
   
   
 
}
   
   

