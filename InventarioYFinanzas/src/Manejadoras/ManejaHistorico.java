/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manejadoras;

import ClasesBase.Empleado;
import ClasesBase.Venta;
import java.util.ArrayList;

/**
 *
 * @author jasiel
 */
public class ManejaHistorico {
    public ArrayList <Venta> Historico;
    
    public void hacerCorte(ManejaVentas ventas,ManejaPersonas manejaPersona) {
         double VAD = 0;
        for (int i = 0; i < ventas.Ventas.size(); i++) {
            Historico.add(ventas.Ventas.get(i));
             VAD += ventas.Ventas.get(i).monto();
        }
        System.out.println("LA VENTA TOTAL DEL CORTE ES :$"+VAD);
        ventas.Ventas.removeAll(ventas.Ventas);
        for (int i = 0; i < manejaPersona.personas.size(); i++) {
           ((Empleado) manejaPersona.personas.get(manejaPersona.buscarEmpleado(i))).setVentas(0);
           ((Empleado) manejaPersona.personas.get(manejaPersona.buscarEmpleado(i))).setComisiones(0);
        }
    }

     
}
