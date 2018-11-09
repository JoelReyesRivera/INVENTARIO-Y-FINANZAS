package Manejadoras;


import ClasesBase.Empleado;
import java.util.ArrayList;
import ClasesBase.Venta; 
import ClasesBase.Fecha;
import Utileria.Keyboard;


public class ManejaVentas {
    public ArrayList <Venta> Ventas;
     public Fecha f=new Fecha(8,11,2018);
    
    //CONSTRUCTOR
     public ManejaVentas(){
        Ventas=  new ArrayList<Venta> ();
     }
     
    //Agregar
     public void Agregar(String ClaveVta, int SKU, int Cantidad, double PrecioUni,int dia, int mes,int año, int cliente) {
        Ventas.add(new Venta(ClaveVta,SKU,Cantidad,PrecioUni,f.getDia(),f.getMes(),f.getAño(), cliente));
    }
     public int buscarVenta(String clave) {
        int posicion = -1;
        for (Venta venta: Ventas) {
            if (venta != null) {
                    if (venta.getClaveVta().equals(clave)) {
                       return Ventas.indexOf(clave);
                }
            }

        }
        return posicion;
    }
    //IMPRIMIR
   public void Imprimir(){ 
       for(int i=0;i<Ventas.size();i++){
           System.out.println("VENTA NUMERO :"+(i + 1) + ":" + "\n" + Ventas.get(i));
       }
   }
       
       //MODIFICAR
      public void ModificarCantidad(String CV, ManejaInventario a) {
        int Can;
        boolean enc = false;
        for (int i = 0; i < Ventas.size(); i++) {
            if (CV.equalsIgnoreCase(Ventas.get(i).getClaveVta())) {
                do {
                    System.out.println("INTRODUCE LA NUEVA CANTIDAD DEL PRODUCTO");
                    Can = Keyboard.readInt();
                } while (Can <= 0);
                a.inventario.get(i).setExistencia(a.inventario.get(i).getExistencia() + Ventas.get(i).getCantidad());
                if (Can > a.inventario.get(i).getExistencia()) {
                    System.out.println("*NO PUEDES CAMBIAR ESA CANTIDAD, SOLO HAY " + a.inventario.get(i).getExistencia() + "*");
                    a.inventario.get(i).setExistencia(a.inventario.get(i).getExistencia() - Ventas.get(i).getCantidad());
                    return;
                }
                Ventas.get(i).setCantidad(Can);
                a.inventario.get(i).setExistencia(a.inventario.get(i).getExistencia() - Ventas.get(i).getCantidad());
                Ventas.get(i).setPrecioUni((int) (a.inventario.get(i).getPrecioUni() * Can));
                System.out.println("*VENTA MODIFICADA*");
                System.out.println(Ventas.get(i));
                enc = true;
                break;
            }
        }
        if (!enc) {
            System.out.println("*NO SE ENCONTRARON VENTAS CON LA CLAVE : " + CV + "*");
        }
    }
   }
   
   
   
 

   
   

