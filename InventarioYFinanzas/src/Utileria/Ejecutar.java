package Utileria;
// Jasiel pendejo
import ClasesBase.Empleado;
import Manejadoras.ManejaPersonas;
import Manejadoras.ManejaVentas;
import Manejadoras.ManejaFinanzas;

/**
 *      ITNM - Campus Culiacan
 *      Programacion Orientada a Objetos
 *      Unidad 3
 */

public class Ejecutar {
    
    public static void main(String[] args) {
        
        Ejecutar main = new Ejecutar();
        ManejaPersonas manejaPersona = new ManejaPersonas();
        ManejaFinanzas manejaFinanza=new ManejaFinanzas();
                
        System.out.println("\033[34m------------ BIENVENIDO ------------\n\033[34m");
        
        int key;
        do {
            System.out.println("\033[33m------------------------------------\nINGRESE LA OPCION QUE DESEA REALIZAR\n");
            System.out.println("1.- VENDER\n2.- FINANZAS\n3.- ADMINISTRAR PRODUCTOS\n4.- ADMINISTRAR EMPLEADOS\n5.- ADMINISTRAR CLIENTES\n0.- Salir\033[34m");
            key = Keyboard.readInt();
            switch (key) {
                case 1:
                    main.vender(manejaPersona);
                    break;
                case 2:
                    main.menuFinanzas(manejaFinanza);
                    break;
                case 4:
                    main.menuEmpleados(manejaPersona);
                    break;
                case 5:
                    main.menuClientes(manejaPersona);
                case 0:
                    break;
                default: System.out.println("\033[31mOPCION INVALIDA\n\033[34m");
            }
        } while (key != 0);
    }
    
    public void vender(ManejaPersonas manejaPersona){
        
        int cR;
        String nombreCliente, apellidoCliente, rfcCliente, emailCliente, SKU;
        long telefonoCliente;
        
        System.out.println("\n- INGRESE LOS DATOS DE LA VENTA -\n");
        do {
            System.out.println("EL CLIENTE ESTA REGISTRADO (1.- SI/2.- NO)");
            cR=Keyboard.readInt();
            System.out.println("");
            if (cR == 1) {
                int idCliente;
                do {
                    System.out.println("INGRESE EL ID DEL CLIENTE.");
                    idCliente=Keyboard.readInt();
                    if (manejaPersona.buscarCliente(cR)!=-1) {
                        System.out.println("\033[31mEL ID INGRESADO NO EXISTE.\n\033[34m");
                    }
                } while (manejaPersona.buscarCliente(cR)!=-1);
                /*
                int pos=manejaPersona.buscarCliente(cR);
                nombreCliente=manejaPersona.personas.get(pos).getNombre();
                apellidoCliente=manejaPersona.personas.get(pos).getApellido();
                rfcCliente=manejaPersona.personas.get(pos).getRFC();
                telefonoCliente=manejaPersona.personas.get(pos).getTelefono();
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
    
    public void menuFinanzas( ManejaFinanzas ManejaFinanza){
    int opcion = 0;
        do {
            System.out.println();
            System.out.println("***************¿Que desea hacer?****************");
            System.out.println("OPCIÓN 1-----------Buscar ganancias del dia");
            System.out.println("OPCIÓN 2-----------Buscar ganancias de un mes");
            System.out.println("OPCIÓN 0-----------Salir");
            System.out.print("Introduce la opción: ");
            opcion = Keyboard.readInt();
            switch (opcion) {
                case 1:
                    int d,m,a;
                    System.out.println("Escribe el dia");
                    d=Keyboard.readInt();
                    System.out.println("Escribe el mes");
                    m=Keyboard.readInt();
                    System.out.println("Escribe el año");
                    a=Keyboard.readInt();
                    ManejaFinanza.Ventadia(d, m, a);
                 break;
                case 2:
                    System.out.println("Escribe el mes");
                    m=Keyboard.readInt();
                  ManejaFinanza.VentaMes(m);
                     break;
                case 0:
                    break;
                default:
                    System.out.println("*Introduce una opción válida*");
            }
        } while (opcion != 0);
    }    

    
    public void menuProductos(){
        
    }
    
    public void menuEmpleados(ManejaPersonas manejaPersona){
        
        int keyME;
        do {
            System.out.println("\n\033[33m------------- EMPLEADOS -------------\nINGRESE LA OPCION QUE DESEA REALIZAR\n");
            System.out.println("1.- AGREGAR\n2.- BUSCAR\n3.- MODIFICAR\n4.- IMPRIMIR\n0.- Salir\033[34m");
            keyME = Keyboard.readInt();
            switch (keyME) {
                case 1:
                    String nombre, apellido, RFC;
                    long telefono;
                    double sueldo;
                    System.out.println("\nINGRESA LOS DATOS DEL EMPLEADO POR AGREGAR\n");
                    do {
                        System.out.println("NOMBRE");
                        nombre=Keyboard.readString();
                        if (nombre.trim().isEmpty()) {
                            System.out.println("\033[31mNOMBRE INVALIDO\n\033[34m");
                        }
                    } while (nombre.trim().isEmpty());
                    do {
                        System.out.println("APELLIDO");
                        apellido=Keyboard.readString();
                        if (apellido.trim().isEmpty()) {
                            System.out.println("\033[31mAPELLIDO INVALIDO\n\033[34m");
                        }
                    } while (apellido.trim().isEmpty());
                    do {
                        System.out.println("TELEFONO");
                        telefono=Keyboard.readLong();
                        if (telefono<0) {
                            System.out.println("\033[31mTELEFONO INVALIDO\n\033[34m");
                        }
                    } while (telefono<0);
                    do {
                        System.out.println("RFC");
                        RFC=Keyboard.readString();
                        if (RFC.trim().isEmpty()) {
                            System.out.println("\033[31mRFC INVALIDO\n\033[34m");
                        }
                    } while (RFC.trim().isEmpty());
                    do {
                        System.out.println("SUELDO");
                        sueldo=Keyboard.readDouble();
                        if (sueldo<0) {
                            System.out.println("\033[31mSUELDO INVALIDO\033[34m");
                        }
                    } while (sueldo<0);
                    manejaPersona.agregar(nombre, apellido, telefono, RFC, sueldo);
                    System.out.println("\n\033[32mEMPLEADO AGREGADO CORRECTAMENTE\033[34m");
                    break;
                case 2:
                    System.out.println("\nINGRESA EL ID DEL EMPLEADO A BUSCAR");
                    int idBE=Keyboard.readInt();
                    if (manejaPersona.buscarEmpleado(idBE)!=-1) {
                        System.out.println(manejaPersona.personas.get(manejaPersona.buscarEmpleado(idBE)));
                    } else{
                        System.out.println("\033[31mEMPLEADO INEXISTENTE\n\033[34m");
                    }
                    break;
                case 3:
                    System.out.println("\033[32mMODIFICAME \033[33mESTA\033[34m, \033[35mSAILLE\n");
                    System.out.println("INTRODUZCA EL ID DEL EMPLEADO POR MODIFICAR");
                    int modE=Keyboard.readInt();
                    if (manejaPersona.buscarEmpleado(modE)!=-1) {
                        int pos=manejaPersona.buscarEmpleado(modE);
                        int keyModE;
                        do {
                            System.out.println("\n\033[33m-----\nEL EMPLEADO A MOFICAR ES...");
                            System.out.println(manejaPersona.personas.get(pos));
                            System.out.println("\n1.- NOMBRE\n2.- APELLIDO\n3.- TELEFONO\n4.- RFC\n5.- SUELDO\n\033[33m0.- Salir\033[34m");
                            keyModE = Keyboard.readInt();
                            switch (keyModE) {
                                case 1:
                                    String newNombre;
                                    do {
                                        System.out.println("\nINGRESE EL NUEVO NOMBRE");
                                        newNombre = Keyboard.readString();
                                        if (newNombre.trim().isEmpty()) {
                                            System.out.println("\033[31mNOMBRE INVALIDO\n\033[34m");
                                        }
                                    } while (newNombre.trim().isEmpty());
                                    manejaPersona.personas.get(pos).setNombre(newNombre);
                                    break;
                                case 2:
                                    String newApellido;
                                    do {
                                        System.out.println("\nINGRESE EL NUEVO APELLIDO");
                                        newApellido = Keyboard.readString();
                                        if (newApellido.trim().isEmpty()) {
                                            System.out.println("\033[31mAPELLIDO INVALIDO\n\033[34m");
                                        }
                                    } while (newApellido.trim().isEmpty());
                                    manejaPersona.personas.get(pos).setApellido(newApellido);
                                    break;
                                case 3:
                                    long newTelefono;
                                    do {
                                        System.out.println("\nINGRESE EL NUEVO TELEFONO");
                                        newTelefono = Keyboard.readLong();
                                        if (newTelefono < 0) {
                                            System.out.println("\033[31mTELEFONO INVALIDO\n\033[34m");
                                        }
                                    } while (newTelefono < 0);
                                    manejaPersona.personas.get(pos).setTelefono(newTelefono);
                                    break;
                                case 4:
                                    String newRFC;
                                    do {
                                        System.out.println("\nINGRESE EL NUEVO RFC");
                                        newRFC = Keyboard.readString();
                                        if (newRFC.trim().isEmpty()) {
                                            System.out.println("\033[31mRFC INVALIDO\n\033[34m");
                                        }
                                    } while (newRFC.trim().isEmpty());
                                    manejaPersona.personas.get(pos).setRFC(newRFC);
                                    break;
                                case 5:
                                    double newSueldo;
                                    do {
                                        System.out.println("\nINGRESE EL NUEVO SUELDO");
                                        newSueldo = Keyboard.readDouble();
                                        if (newSueldo < 0) {
                                            System.out.println("\033[31mSUELDO INVALIDO\033[34m");
                                        }
                                    } while (newSueldo < 0);
                                    ((Empleado)manejaPersona.personas.get(pos)).setSueldo(newSueldo);
                                    break;
                                case 0:
                                    break;
                                default: System.out.println("\033[31mOPCION INVALIDA\n\033[34m");
                            }
                        } while (keyModE!=0);
                    }else{
                        System.out.println("\033[32mEMPLEADO INEXISTENTE\n\033[34m");
                    }
                    break;
                case 4:
                    if (!manejaPersona.personas.isEmpty()) {
                        System.out.println("\nEMPLEADOS REGISTRADOS");
                        manejaPersona.imprimir(3);
                    } else{
                        System.out.println("\033[31mNO HAY EMPLEADOS REGISTRADOS\033[34m");
                    }
                    break;
                case 0:
                    break;
                default: System.out.println("\033[31mOPCION INVALIDA\n\033[34m");
            }
        } while (keyME != 0);
    }
    
    public void menuClientes(ManejaPersonas manejaPersona){
        
        int keyMC;
        do {
            System.out.println("\n\033[33m-------------- CLIENTES --------------\nINGRESE LA OPCION QUE DESEA REALIZAR\n");
            System.out.println("1.- AGREGAR\n2.- BUSCAR\n3.- MODIFICAR\n4.- IMPRIMIR\n0.- Salir\033[34m");
            keyMC = Keyboard.readInt();
            switch (keyMC) {
                case 1:
                    String nombre, apellido, RFC;
                    long telefono;
                    System.out.println("\nINGRESA LOS DATOS DEL CLIENTE POR AGREGAR\n");
                    do {
                        System.out.println("NOMBRE");
                        nombre=Keyboard.readString();
                        if (nombre.trim().isEmpty()) {
                            System.out.println("\033[31mNOMBRE INVALIDO\n\033[34m");
                        }
                    } while (nombre.trim().isEmpty());
                    do {
                        System.out.println("APELLIDO");
                        apellido=Keyboard.readString();
                        if (apellido.trim().isEmpty()) {
                            System.out.println("\033[31mAPELLIDO INVALIDO\n\033[34m");
                        }
                    } while (apellido.trim().isEmpty());
                    do {
                        System.out.println("TELEFONO");
                        telefono=Keyboard.readLong();
                        if (telefono<0) {
                            System.out.println("\033[31mTELEFONO INVALIDO\n\033[34m");
                        }
                    } while (telefono<0);
                    do {
                        System.out.println("RFC");
                        RFC=Keyboard.readString();
                        if (RFC.trim().isEmpty()) {
                            System.out.println("\033[31mRFC INVALIDO\n\033[34m");
                        }
                    } while (RFC.trim().isEmpty());
                    manejaPersona.agregar(nombre, apellido, telefono, RFC,0);
                    System.out.println("\n\033[32mCLIENTE AGREGADO CORRECTAMENTE\033[34m");
                    break;
                case 2:
                    System.out.println("\nINGRESA EL ID DEL CLIENTE A BUSCAR");
                    int idBC=Keyboard.readInt();
                    if (manejaPersona.buscarCliente(idBC)!=-1) {
                        System.out.println(manejaPersona.personas.get(manejaPersona.buscarCliente(idBC)));
                    } else{
                        System.out.println("\n\033[31mCLIENTE INEXISTENTE\033[34m");
                    }
                    break;
                case 3:
                    System.out.println("\033[32mMODIFICAME \033[33mESTA\033[34m, \033[35mSAILLE\n");
                    System.out.println("INTRODUZCA EL ID DEL CLIENTE POR MODIFICAR");
                    int modC=Keyboard.readInt();
                    if (manejaPersona.buscarCliente(modC)!=-1) {
                        int pos=manejaPersona.buscarCliente(modC);
                        int keyModC;
                        do {
                            System.out.println("\n\033[33m-----\nEL CLIENTE POR MOFICAR ES...");
                            System.out.println(manejaPersona.personas.get(pos));
                            System.out.println("\n1.- NOMBRE\n2.- APELLIDO\n3.- TELEFONO\n4.- RFC\n\033[33m0.- Salir\033[34m");
                            keyModC = Keyboard.readInt();
                            switch (keyModC) {
                                case 1:
                                    String newNombre;
                                    do {
                                        System.out.println("\nINGRESE EL NUEVO NOMBRE");
                                        newNombre = Keyboard.readString();
                                        if (newNombre.trim().isEmpty()) {
                                            System.out.println("\033[31mNOMBRE INVALIDO\n\033[34m");
                                        }
                                    } while (newNombre.trim().isEmpty());
                                    manejaPersona.personas.get(pos).setNombre(newNombre);
                                    break;
                                case 2:
                                    String newApellido;
                                    do {
                                        System.out.println("\nINGRESE EL NUEVO APELLIDO");
                                        newApellido = Keyboard.readString();
                                        if (newApellido.trim().isEmpty()) {
                                            System.out.println("\033[31mAPELLIDO INVALIDO\n\033[34m");
                                        }
                                    } while (newApellido.trim().isEmpty());
                                    manejaPersona.personas.get(pos).setApellido(newApellido);
                                    break;
                                case 3:
                                    long newTelefono;
                                    do {
                                        System.out.println("\nINGRESE EL NUEVO TELEFONO");
                                        newTelefono = Keyboard.readLong();
                                        if (newTelefono < 0) {
                                            System.out.println("\033[31mTELEFONO INVALIDO\n\033[34m");
                                        }
                                    } while (newTelefono < 0);
                                    manejaPersona.personas.get(pos).setTelefono(newTelefono);
                                    break;
                                case 4:
                                    String newRFC;
                                    do {
                                        System.out.println("\nINGRESE EL NUEVO RFC");
                                        newRFC = Keyboard.readString();
                                        if (newRFC.trim().isEmpty()) {
                                            System.out.println("\033[31mRFC INVALIDO\n\033[34m");
                                        }
                                    } while (newRFC.trim().isEmpty());
                                    manejaPersona.personas.get(pos).setRFC(newRFC);
                                    break;
                                case 0:
                                    break;
                                default: System.out.println("\033[31mOPCION INVALIDA\n\033[34m");
                            }
                        } while (keyModC!=0);
                    }else{
                        System.out.println("\033[32mCLIENTE INEXISTENTE\n\033[34m");
                    }
                    break;
                case 4:
                    if (!manejaPersona.personas.isEmpty()) {
                        System.out.println("\nCLIENTES REGISTRADOS");
                        manejaPersona.imprimir(2);
                    } else{
                        System.out.println("\033[31mNO HAY CLIENTES REGISTRADOS\033[34m");
                    }
                    break;
                case 0:
                    break;
                default: System.out.println("\033[31mOPCION INVALIDA\n\033[34m");
            }
        } while (keyMC != 0);
    }
}