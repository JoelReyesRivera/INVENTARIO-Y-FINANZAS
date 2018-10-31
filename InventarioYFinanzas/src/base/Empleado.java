package base;

/**
 * @author oliverrood
 */
public class Empleado extends Persona {

    private int idEmpleado;
    private double sueldo;
    private static int aIdE;

    public Empleado(String nombre, String apellido, long telefono, String RFC, String email, int idEmpleado,double sueldo) {
        super(nombre, apellido, telefono, RFC, email);
        this.idEmpleado = idEmpleado;
        this.sueldo=sueldo;
    }

    // Sin RFC y Email
    public Empleado(String nombre, String apellido, long telefono, int idEmpleado, double sueldo) {
        super(nombre, apellido, telefono);
        this.idEmpleado = idEmpleado;
        this.sueldo=sueldo;
    }

    // Sin RFC
    public Empleado(String nombre, String apellido, long telefono, String email, int idEmpleado,double sueldo) {
        super(nombre, apellido, telefono, email);
        this.idEmpleado = idEmpleado;
        this.sueldo=sueldo;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }
    
    public double getSueldo(){
        return sueldo;
    }
    public void setIdSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    @Override
    public String toString() {
        super.toString();
        return "\nID Empleado: " + idEmpleado;
    }
}
