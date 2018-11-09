package Manejadoras;
import Manejadoras.ManejaVentas;
/**
 *
 * @author ADM-PC
 */
public class ManejaFinanzas {

    //ImprimirVentasPorDia
    public void Ventadia(int d,int m,int a, ManejaVentas o){
        double VAD = 0;
        for (int i = 0; i < o.Ventas.size(); i++) {
                if ((o.Ventas.get(i).getDia() == d) && (o.Ventas.get(i).getMes() == m) && (o.Ventas.get(i).getAño() == a ))
                {
                      VAD += o.Ventas.get(i).getPrecioUni();
                }
        }
        System.out.println(VAD);
    }
   
    public void VentaMes(int m, int a, ManejaVentas o) {
        double VAM = 0;
        for (int i = 0; i < o.Ventas.size(); i++) {
                if(o.Ventas.get(i).getMes()==m && o.Ventas.get(i).getAño()==a)
                 {
                     VAM += o.Ventas.get(i).getPrecioUni();
            }
        }
        System.out.print(VAM); 
    }
}