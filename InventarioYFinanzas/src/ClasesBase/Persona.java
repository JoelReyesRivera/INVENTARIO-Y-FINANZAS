package ClasesBase;

/**
 * @author oliverrood
 */
public class Persona {
    
    private String nombre;
    private String apellido;
    private long telefono;
    private String RFC;
    private String email;

    
    // Datos Completos
    public Persona(String nombre, String apellido, long telefono, String RFC, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.RFC = RFC;
        this.email = email;
    }

    // Sin RFC y Email
    public Persona(String nombre, String apellido, long telefono) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
    }

    // Sin RFC
    public Persona(String nombre, String apellido, long telefono, String email) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.email = email;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getRFC() {
        return RFC;
    }

    public void setRFC(String RFC) {
        this.RFC = RFC;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "\nNombre: "+nombre+"\nApellido: "+apellido+"\nTelefono: "+telefono + "\nRFC: "+RFC+"\nEmail: "+email;
    }
    

}
