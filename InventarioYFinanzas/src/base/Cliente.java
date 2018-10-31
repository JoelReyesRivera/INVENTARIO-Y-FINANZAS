package base;

/**
 * @author oliverrood
 */
public class Cliente extends Persona{
    
    private int idCliente;
    private int totalCompras;
    private static int contador;
    
    public Cliente(String nombre, String apellido, long telefono, String RFC, String email,int idCliente,int totalCompras ){
        super(nombre,apellido,telefono, RFC, email);
        this.idCliente=idCliente;
        this.totalCompras=totalCompras;   
        contador++;
    }
    
    // Sin RFC y Email
    public Cliente(int idCliente, String nombre, String apellido, long telefono,int totalCompras ){
        super(nombre,apellido,telefono );
        this.idCliente=idCliente;
        this.totalCompras=totalCompras;
    }
    
     // Sin RFC
    public Cliente(int idCliente, String nombre, String apellido, long telefono,String email,int totalCompras ){
        super(nombre,apellido,telefono,email );
        this.idCliente=idCliente;
        this.totalCompras=totalCompras;
    }
    
    public int getIdCliente(){
        return idCliente;
    }
    
    public void SetIdCliente(int idCliente){
        this.idCliente=idCliente;
    }
    
    public int getTotalCompras(){
        return totalCompras;
    }
    
    public void SetTotalCompras(int totalCompras){
        this.totalCompras=totalCompras;
    }
    
    @Override
    public String toString() {
        super.toString();
        return "\nID Cliente: "+idCliente+"\nTotal de compras: "+totalCompras;
    }
}
