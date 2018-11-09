package Manejadoras;

import ClasesBase.Empleado;
import ClasesBase.Persona;

public class ManejaFinanzas {

    //ImprimirVentasPorDia
    public void Ventadia(int d, int m, int a, ManejaVentas o) {
        double VAD = 0;
        for (int i = 0; i < o.Ventas.size(); i++) {
            if ((o.Ventas.get(i).getDia() == d) && (o.Ventas.get(i).getMes() == m) && (o.Ventas.get(i).getAño() == a)) {
                VAD += o.Ventas.get(i).monto();
            }
        }
        System.out.println("GANANCIAS DEL DIA  " + d + "/" + m + "/" + a);
        System.out.println("$ " + VAD+" MXN");
    }

    public void VentaMes(int m, int a, ManejaVentas o) {
        double VAM = 0;
        for (int i = 0; i < o.Ventas.size(); i++) {
            if (o.Ventas.get(i).getMes() == m && o.Ventas.get(i).getAño() == a) {
                VAM += o.Ventas.get(i).monto();
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
        for (Persona persona : manejaPersona.personas) {
            if (persona instanceof Empleado) {
                System.out.println("EMPLEADO: "+persona.getNombre()+" "+persona.getApellido());
                System.out.println("SUELDO: $"+((Empleado)persona).getSueldo()+" MXN");
                System.out.println("");
            }
        }
    }
}