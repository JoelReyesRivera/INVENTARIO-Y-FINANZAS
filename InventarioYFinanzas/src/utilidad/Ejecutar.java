package utilidad;

/**
 *      ITNM - Campus Culiacan
 *      Programacion Orientada a Objetos
 *      Unidad 3
 */

public class Ejecutar {
    
    public static void main(String[] args) {
        
        Ejecutar main = new Ejecutar();
        
        System.out.println("\033[34m------------ BIENVENIDO ------------\n\033[34m");
        
        int key;
        do {
            System.out.println("\033[33m------------------------------------\nIngrese la opcion que desea realizar\n");
            System.out.println("1.- Vender\n2.- Finanzas\n3.- Administrar Productos\n4.- Administarr Personas\n0.- Salir\033[34m");
            key = Keyboard.readInt();
            switch (key) {
                case 1:
                    main.vender();
                    break;
                case 2:
                    System.out.println("2");
                    break;
            }
        } while (key != 0);
    }
    
    public void vender(){
        
        int cR;
        String nombreCliente, apellidoCliente, rfcCliente, emailCliente, SKU;
        long telefonoCliente;
        
        System.out.println("\n- Ingrese los datos de la venta -\n");
        do {
            System.out.println("El cliente esta registrado en el sistema (1.- Si/2.- No)");
            cR=Keyboard.readInt();
            System.out.println("");
            if (cR == 1) {
                int idCliente;
                do {
                    System.out.println("Ingrese el ID del cliente.");
                    idCliente=Keyboard.readInt();
                    if (idCliente<0) { // Cambiar esta condicion por buscarCliente(idCliente)!=-1
                        System.out.println("\033[31mEl ID ingresado no existe.\n\033[34m");
                    }
                } while (idCliente<0); // Cambiar esta condicion por buscarCliente(idCliente)!=-1
                /*
                nombreCliente=manejaPersonas.cliente[idCliente].getNombre();
                apellidoCliente=manejaPersonas.cliente[idCliente].getApellido();
                rfcCliente=manejaPersonas.cliente[idCliente].getRFC();
                telefonoCliente=manejaPersonas.cliente[idCliente].getTelefono();
                emailCliente=manejaPersonas.cliente[idCliente].getEmail();
                */
            } else {
                do { 
                    System.out.println("Ingrese el nombre del cliente.");
                    nombreCliente = Keyboard.readString();
                    if (nombreCliente.trim().isEmpty()) {
                        System.out.println("\033[31mEl nombre ingresado es invalido.\n\033[34m");
                    }
                } while (nombreCliente.trim().isEmpty());
                do {
                    System.out.println("Ingrese el apellido del cliente.");
                    apellidoCliente = Keyboard.readString();
                    if (apellidoCliente.trim().isEmpty()) {
                        System.out.println("\033[31mEl apellido ingresado es invalido.\n\033[34m");
                    }
                } while (apellidoCliente.trim().isEmpty());
                do {
                    System.out.println("Ingrese el RFC del cliente. (Indique 0 si no desea ingresar RFC)");
                    rfcCliente = Keyboard.readString();
                    if (rfcCliente.trim().isEmpty()) {
                        System.out.println("\033[31mEl RFC ingresado es invalido.\n\033[34m");
                    }
                } while (rfcCliente.trim().isEmpty());
                do {
                    System.out.println("Ingrese el telefono del cliente.");
                    telefonoCliente = Keyboard.readLong();
                    if (apellidoCliente.trim().isEmpty()) {
                        System.out.println("\033[31mEl Apellido ingresado es invalido.\n\033[34m");
                    }
                } while (telefonoCliente<1);
                do {
                    System.out.println("Ingrese el email del cliente. (Indique 0 si no desea ingresar email)");
                    rfcCliente = Keyboard.readString();
                    if (rfcCliente.trim().isEmpty()) {
                        System.out.println("\033[31mEl email ingresado es invalido.\n\033[34m");
                    }
                    if (rfcCliente.length()>1 || rfcCliente.length()<5) {
                        System.out.println("\033[31mEl email ingresado es invalido.\n\033[34m");
                        rfcCliente=null;
                    }
                } while (rfcCliente.trim().isEmpty());
            }
            // Agregar cliente al arreglo
        } while (cR<1||cR>2);

        do {
            System.out.println("Ingrese el SKU del producto a vender.");
            SKU=Keyboard.readString();
            if (SKU.trim().isEmpty()) {
                System.out.println("\033[31mEl SKU ingresado no existe.\n\033[34m");
            }
            /* Validacion SKU Inexistente
            if () {
                System.out.println("\033[31mEl SKU ingresado no existe.\n");
                SKU=null;
            }
            */
        } while (SKU.trim().isEmpty());
    }
    public void menuPersonas(){
        
    }
    public void menuFinanzas(){
        
    }
    public void administrarPersonas(){
        
    }
        
}