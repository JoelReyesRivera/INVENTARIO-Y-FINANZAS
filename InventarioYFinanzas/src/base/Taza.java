package base;

/**
 *
 * @author jasiel
 */
public class Taza extends Producto{
   private String material;
    private String color;
    private String tamaño;
    
    public Taza(int SKU,double PrecioUni, int Existencia,String material,String color,String tamaño){
        super(SKU,PrecioUni,Existencia);
        this.material=material;
        this.color=color;
        this.tamaño=tamaño;
    }
    
    public String getMaterial(){
        return material;
    }
    
    public void SetMaterial(String material){
        this.material=material;
    }
    
    public String getColor(){
        return color;
    }
    
    public void SetColor(String color){
        this.color=color;
    }
    
    public String getTamaño(){
        return tamaño;
    }
    
    public void SetTamaño(String tamaño){
        this.tamaño=tamaño;
    }
    
     @Override
    public String toString() {
        super.toString();
        return "\nMaterial: "+material+"\nColor: "+color+"\nTamaño: "+tamaño;
    }
} 

