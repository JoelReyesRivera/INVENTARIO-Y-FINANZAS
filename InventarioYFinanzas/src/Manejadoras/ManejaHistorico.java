package Manejadoras;

import ClasesBase.Empleado;
import ClasesBase.Venta;
import java.util.ArrayList;

/**
 *
 * @author jasiel
 */
public class ManejaHistorico {

    public ArrayList<Venta> Historico = new ArrayList();

    // Agregar Archivo
    public void Agregar(String ClaveVta, int SKU, int Cantidad, double PrecioUni,int dia, int mes,int año, int cliente, int empleado) {
        Historico.add(new Venta(ClaveVta,SKU,Cantidad,PrecioUni,dia, mes, año, cliente,empleado));
    }
    
    public void hacerCorte(ManejaVentas ventas, ManejaPersonas manejaPersona) {
        double VAD = 0, nomina = 0;
        for (int i = 0; i < ventas.Ventas.size(); i++) {
            Historico.add(ventas.Ventas.get(i));
            VAD += ventas.Ventas.get(i).monto();
        }
        ventas.Ventas.removeAll(ventas.Ventas);
        for (int i = 0; i < manejaPersona.personas.size(); i++) {
            if (manejaPersona.personas.get(i) instanceof Empleado) {
                nomina += ((Empleado) manejaPersona.personas.get(i)).getComisiones() + ((Empleado) manejaPersona.personas.get(i)).getSueldo();
                ((Empleado) manejaPersona.personas.get(i)).setVentas(0);
                ((Empleado) manejaPersona.personas.get(i)).setComisiones(0);
            }
        }
        System.out.println("LA VENTA TOTAL DEL CORTE ES : $" + VAD);
        System.out.println("LA NOMINA TOTAL DEL CORTE ES : $" + nomina);
    }

    public void Imprimir() {
        for (int i = 0; i < Historico.size(); i++) {
            System.out.println("VENTA NUMERO :" + (i + 1) + "\n" + Historico.get(i));
            System.out.println("---");
        }
    }

}
