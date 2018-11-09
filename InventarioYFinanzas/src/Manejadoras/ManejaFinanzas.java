package Manejadoras;

public class ManejaFinanzas {

    //ImprimirVentasPorDia
    public void Ventadia(int d, int m, int a, ManejaVentas o) {
        double VAD = 0;
        for (int i = 0; i < o.Ventas.size(); i++) {
            if ((o.Ventas.get(i).getDia() == d) && (o.Ventas.get(i).getMes() == m) && (o.Ventas.get(i).getAño() == a)) {
                VAD += o.Ventas.get(i).monto();
            }
        }
        System.out.println("GANANCIAS DEL DIA" + d + "/" + m + "/" + a);
        System.out.println("$" + VAD);
    }

    public void VentaMes(int m, int a, ManejaVentas o) {
        double VAM = 0;
        for (int i = 0; i < o.Ventas.size(); i++) {
            if (o.Ventas.get(i).getMes() == m && o.Ventas.get(i).getAño() == a) {
                VAM += o.Ventas.get(i).monto();
            }
        }
        System.out.print("GANANCIAS DEL MES" + m + "/" + a);
        System.out.print("$" + VAM);
    }
}