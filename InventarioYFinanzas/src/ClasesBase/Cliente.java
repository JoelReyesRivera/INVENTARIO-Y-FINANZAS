package ClasesBase;

/**
 * @author oliverrood
 */
public class Cliente extends Persona{
    
    private int idCliente;
    private int totalCompras;
    private static int contador=1;
    
    public Cliente(String nombre, String apellido, long telefono, String RFC,int totalCompras ){
        super(nombre,apellido,telefono, RFC);
        this.idCliente=contador;
        this.totalCompras=totalCompras;   
        contador++;
        
    }
    
    // Sin RFC
    public Cliente(String nombre, String apellido, long telefono,int totalCompras ){
        super(nombre,apellido,telefono );
        this.idCliente=contador;
        this.totalCompras=totalCompras;
        contador++;
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
        return (super.toString()+"\nID Cliente: "+idCliente+"\nTotal de compras: "+totalCompras).toUpperCase();
    }
}
