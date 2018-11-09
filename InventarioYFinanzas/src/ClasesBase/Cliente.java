package ClasesBase;

public class Cliente extends Persona {

    private int idCliente;
    private int totalCompras;
    private static int contador = 0;

    public Cliente(String nombre, String apellido, long telefono, String RFC) {
        super(nombre, apellido, telefono, RFC);
        contador++;
        this.idCliente = contador;

    }

    // Sin RFC
    public Cliente(String nombre, String apellido, long telefono) {
        super(nombre, apellido, telefono);
        this.idCliente = contador;
        contador++;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void SetIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getTotalCompras() {
        return totalCompras;
    }

    public void SetTotalCompras(int totalCompras) {
        this.totalCompras = totalCompras;
    }

    public void aumentarCompras() {
        totalCompras++;
    }

    @Override
    public String toString() {
        return (super.toString() + "\nID Cliente: " + idCliente + "\nTotal de compras: " + totalCompras).toUpperCase();
    }
}
