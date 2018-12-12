package ClasesBase;

import java.io.Serializable;

public class Empleado extends Persona implements Serializable{
    
    private static final long serialVersionUID = 666L;

    private int idEmpleado;
    private double sueldo;
    private int ventas;
    private double comisiones;
    private double porcentaje;
    private static int contIdE = 1;

    public Empleado(String nombre, String apellido, long telefono, String RFC, double sueldo, double porcentaje) {
        super(nombre, apellido, telefono, RFC);
        this.idEmpleado = contIdE;
        this.sueldo = sueldo;
        this.ventas=0;
        this.comisiones=0;
        this.porcentaje=porcentaje;
        contIdE++;
    }

    // Constructor archivos
    
    public Empleado(int idEmpleado, double sueldo, int ventas, double comisiones, double porcentaje, String nombre, String apellido, long telefono, String RFC) {
        super(nombre, apellido, telefono, RFC);
        this.idEmpleado = idEmpleado;
        this.sueldo = sueldo;
        this.ventas = ventas;
        this.comisiones = comisiones;
        this.porcentaje = porcentaje;
    }

    // Sin RFC
    public Empleado(String nombre, String apellido, long telefono, double sueldo) {
        super(nombre, apellido, telefono);
        this.idEmpleado = contIdE;
        this.sueldo = sueldo;
        contIdE++;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public int getVentas() {
        return ventas;
    }

    public void aumentaVentas() {
        this.ventas++;
    }
    
    public void disminuyeVentas() {
        this.ventas++;
    }

    public double getComisiones() {
        return comisiones;
    }
    
    public void setComisiones(double comisiones){
        this.comisiones=comisiones;
    }

    public void aumentaComisiones(float comision) {
        this.comisiones += comision;
    }
    
    public void setVentas(int Ventas){
        this.ventas=Ventas;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    @Override
    public String toString() {
        return (super.toString() + "\nID Empleado: " + idEmpleado + "\nSueldo: " + sueldo+"\nVENTAS REALIZADAS: "+ventas+"\nCOMISIONES TOTALES: "+comisiones+"\nPORCENTAJE POR VENTA: "+(porcentaje*100)+"%").toUpperCase();
    }
}
