package ClasesBase;

public class Venta {

    private String ClaveVta;
    private int SKUArt;
    private int Cantidad;
    private double PrecioUni;
    private int dia;
    private int mes;
    private int año;
    private int idCliente;

    public Venta(String ClaveVta, int SKUArt, int Cantidad, double PrecioUni, int dia, int mes, int año, int idCliente) {
        this.ClaveVta = ClaveVta;
        this.SKUArt = SKUArt;
        this.Cantidad = Cantidad;
        this.PrecioUni = PrecioUni;
        this.dia = dia;
        this.mes = mes;
        this.año = año;
        this.idCliente = idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public void setDia(int d) {
        dia = d;
    }

    public void setMes(int m) {
        mes = m;
    }

    public void setAño(int a) {
        año = a;
    }

    public int getDia() {
        return dia;
    }

    public int getMes() {
        return mes;
    }

    public int getAño() {
        return año;
    }

    public String getClaveVta() {
        return ClaveVta;
    }

    public int getCSKUArt() {
        return SKUArt;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public double getPrecioUni() {
        return PrecioUni;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setClaveVta(String ClaveVta) {
        this.ClaveVta = ClaveVta;
    }

    public void setSKUArt(int SKUArt) {
        this.SKUArt = SKUArt;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public void setPrecioUni(int precio) {
        PrecioUni = precio;
    }

    public double monto() {
        return PrecioUni * Cantidad;
    }

    public String toString() {
        return ("Clave de la venta :" + ClaveVta + ("\n") + "Cliente :" + idCliente + ("\n") + "SKU Articulo :" + SKUArt + ("\n") + "Cantidad de vendidos:" + Cantidad + ("\n") + "Precio Articulo: $" + PrecioUni +" MXN\nMonto: $"+monto()+" MXN"+ String.format("\nfecha: Dia %s Mes %s Año %s ", getDia(), getMes(), getAño())).toUpperCase();
    }
}