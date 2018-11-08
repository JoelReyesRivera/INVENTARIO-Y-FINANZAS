/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manejadoras;

/**
 *
 * @author ADM-PC
 */
public class ManejaFinanzas {
    ManejaVentas ManejaVenta=new ManejaVentas();
    
    //ImprimirVentasPorDia
    public void Ventadia(int d, int m, int a) {
        double VAD = 0;
        for (int i = 0; i <= ManejaVenta.Ventas.size(); i++) {
            //           if (b.arrVentas[i].getfecha().getDia() == d && b.arrVentas[i].getfecha().getMes() == m && b.arrVentas[i].getfecha().getAño() == a) {
            VAD += ManejaVenta.Ventas.get(i).getPrecioUni();
            System.out.println("Ventas del dia :" + VAD);
            //}
        }
    }
    
    //ImprimirVentasPorMes
    public void VentaMes(int m) {
        double VAM = 0;
        for (int i = 0; i <= ManejaVenta.Ventas.size(); i++) {
            //     if (b.arrVentas[i].getfecha().getMes() == m) {
            VAM += ManejaVenta.Ventas.get(i).getPrecioUni();
            System.out.println("Las ganancias del mes son :" + VAM);
            //}
        }

    }
}
