package ClasesBase;

public class Empleado extends Persona {

    private int idEmpleado;
    private double sueldo;
    private int ventas;
    private float comisiones;
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

    public float getComisiones() {
        return comisiones;
    }

    public void aumentaComisiones(float comision) {
        this.comisiones += comision;
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
