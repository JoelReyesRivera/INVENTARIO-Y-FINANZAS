package ClasesBase;

/**
 * @author oliverrood
 */
public class Cliente extends Persona{
    
    private int idCliente;
    private int totalCompras;
    private static int contador=0;
    
    public Cliente(String nombre, String apellido, long telefono, String RFC,int totalCompras ){
        super(nombre,apellido,telefono, RFC);
        contador++;
        this.idCliente=contador;
        this.totalCompras=totalCompras;   
        
    }
    
    // Sin RFC
    public Cliente(String nombre, String apellido, long telefono,int totalCompras ){
        super(nombre,apellido,telefono );
        contador++;
        this.idCliente=contador;
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
        return super.toString()+"\nID Cliente: "+idCliente+"\nTotal de compras: "+totalCompras;
    }
}
