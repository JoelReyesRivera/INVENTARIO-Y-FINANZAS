package ClasesBase;

/**
 * @author oliverrood
 */
public class Empleado extends Persona {

    private int idEmpleado;
    private double sueldo;
    private static int contIdE=1;

    public Empleado(String nombre, String apellido, long telefono, String RFC,double sueldo) {
        super(nombre, apellido, telefono, RFC);
        this.idEmpleado = contIdE;
        this.sueldo=sueldo;
        contIdE++;
    }

    // Sin RFC
    public Empleado(String nombre, String apellido, long telefono, double sueldo) {
        super(nombre, apellido, telefono);
        this.idEmpleado = contIdE;
        this.sueldo=sueldo;
        contIdE++;
    }
    
    public int getIdEmpleado() {
        return idEmpleado;
    }
    
    public double getSueldo(){
        return sueldo;
    }
    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    @Override
    public String toString() {
        return super.toString()+"\nID Empleado: " + idEmpleado+"\nSueldo: "+sueldo;
    }
}
