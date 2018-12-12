package Utileria;

/**
 * @author oliverrood
 */
public class StockNotAvaibleException extends Exception{
    
    public StockNotAvaibleException (String mensaje){
        super(mensaje);
    }
    
    public static void ValidaExistencia(int cantidad) throws StockNotAvaibleException, NumberFormatException
    {
        try{
            if(cantidad<0){
                throw new StockNotAvaibleException("CANTIDAD EN INVENTARIO INSUFICIENTE.");
            }
        }
        catch(NumberFormatException e){
            throw new StockNotAvaibleException("FORMATO INCORRECTO");
        }
    }
    
}
