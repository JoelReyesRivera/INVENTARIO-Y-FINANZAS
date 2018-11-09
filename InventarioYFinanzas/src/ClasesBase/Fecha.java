package ClasesBase;

import java.util.Calendar;

public class Fecha {

    Calendar fecha = Calendar.getInstance();

    private int dia = 0;
    private int mes = 0;
    private int año = 0;

    //Constructor por defecto
    public Fecha() {
    }

    //Constructor con parámetros
    public Fecha(int dia, int mes, int año) {
        fecha.set(año, mes, dia);
    }

    public void setDia(int d) {
        fecha.set(Calendar.DAY_OF_MONTH, d);
    }

    public void setMes(int m) {
        fecha.set(Calendar.MONTH, m);
    }

    public void setAño(int a) {
        fecha.set(Calendar.YEAR, a);
    }

    public int getDia() {
        return fecha.get(Calendar.DAY_OF_MONTH);
    }

    public int getMes() {
        return fecha.get(Calendar.MONTH);
    }

    public int getAño() {
        return fecha.get(Calendar.YEAR);
    }

    public void finalizarDia() {
        fecha.add(Calendar.DAY_OF_MONTH, 1);
    }

    public String toString() {
        return String.format("Dia %s Mes %s Año %s ", getDia(), getMes(), getAño());
    }
}
