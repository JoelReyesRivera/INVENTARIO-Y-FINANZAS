package Manejadoras;

import ClasesBase.Empleado;
import ClasesBase.Persona;

public class ManejaFinanzas {

    //ImprimirVentasPorDia
    public void Ventadia(int d, int m, int a, ManejaHistorico o) {
        double VAD = 0;
        for (int i = 0; i < o.Historico.size(); i++) {
            if ((o.Historico.get(i).getDia() == d) && (o.Historico.get(i).getMes() == m) && (o.Historico.get(i).getAño() == a)) {
                VAD += o.Historico.get(i).monto();
            }
        }
        System.out.println("GANANCIAS DEL DIA  " + d + "/" + m + "/" + a);
        System.out.println("$ " + VAD+" MXN");
    }

    public void VentaMes(int m, int a, ManejaHistorico o) {
        double VAM = 0;
        for (int i = 0; i < o.Historico.size(); i++) {
            if (o.Historico.get(i).getMes() == m && o.Historico.get(i).getAño() == a) {
                VAM += o.Historico.get(i).monto();
            }
        }
        System.out.println("GANANCIAS DEL MES  " + m + "/" + a);
        System.out.print("$ " + VAM+" MXN");
    }
    
    public double calcularNomina(ManejaPersonas manejaPersona){
        double sumNom=0;
        for (Persona persona : manejaPersona.personas) {
            if (persona instanceof Empleado) {
                sumNom+=((Empleado)persona).getSueldo();
            }
        }
        return sumNom;
    }
    
    public void imprimirNominaEmpleados(ManejaPersonas manejaPersona){
        double nomina =0;
        for (int i = 0; i < manejaPersona.personas.size(); i++) {
            if(manejaPersona.personas.get(i) instanceof Empleado){
            nomina += ((Empleado) manejaPersona.personas.get(i)).getComisiones() + ((Empleado) manejaPersona.personas.get(i)).getSueldo();
            }
        }
        System.out.println("LA NOMINA TOTAL ACTUAL ES: $" + nomina);
    }
}