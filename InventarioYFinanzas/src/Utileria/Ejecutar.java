package Utileria;

import ClasesBase.Cliente;
import ClasesBase.Empleado;
import ClasesBase.Tarro;
import ClasesBase.Taza;
import ClasesBase.Textil;
import Manejadoras.ManejaPersonas;
import Manejadoras.ManejaInventario;
import Manejadoras.ManejaVentas;
import Manejadoras.ManejaFinanzas;
import ClasesBase.Fecha;

/**
 * ITNM - Campus Culiacan Programacion Orientada a Objetos Unidad 3
 */
public class Ejecutar {

    public static int contCA = 1, contEA = 1;

    public static void main(String[] args) {

        Ejecutar main = new Ejecutar();
        ManejaPersonas manejaPersona = new ManejaPersonas();
        ManejaFinanzas manejaFinanza = new ManejaFinanzas();
        ManejaVentas manejaVentas = new ManejaVentas();
        ManejaInventario manejaInventario = new ManejaInventario();
        Fecha f = new Fecha();
        System.out.println("\033[34m------------ BIENVENIDO ------------\n\033[34m");

        int key;
        do {
            System.out.println(manejaVentas.f);
            System.out.println("\033[33m------------------------------------\nINGRESE LA OPCION QUE DESEA REALIZAR\n");
            System.out.println("1.- VENDER\n2.- FINANZAS\n3.- ADMINISTRAR PRODUCTOS\n4.- ADMINISTRAR EMPLEADOS\n5.- ADMINISTRAR CLIENTES\n6.- FINALIZAR DÍA\n0.- Salir\033[34m");
            key = Keyboard.readInt();
            switch (key) {
                case 1:
                    main.vender(manejaPersona, manejaInventario, manejaVentas, f);
                    break;
                case 2:
                    main.menuFinanzas(manejaFinanza, manejaVentas);
                    break;
                case 3:
                    main.menuProductos(manejaInventario);
                    break;
                case 4:
                    main.menuEmpleados(manejaPersona);
                    break;
                case 5:
                    main.menuClientes(manejaPersona);
                    break;
                case 6:
                    manejaVentas.f.finalizarDia();
                    break;
                case 0:
                    break;
                default:
                    System.out.println("\033[31mOPCION INVALIDA\n\033[34m");
            }
        } while (key != 0);
    }

    public void vender(ManejaPersonas manejaPersona, ManejaInventario ManejaInventarios, ManejaVentas Manejaventas, Fecha f) {

        int cR, SKU;
        String nombreCliente = "", apellidoCliente = "", rfcCliente = "";
        long telefonoCliente = 0;
        int idCliente = 0;
        int opcion = 0;
        int p = 0;
        do {
            System.out.println();
            System.out.println("*************** MENU VENDER****************");
            System.out.println("1.-VENDER ARTICULO");
            System.out.println("2.-MOSTRAR LAS VENTAS");
            System.out.println("3.-MODIFICAR LA CANTIDAD");
            System.out.println("0.-SALIR");

            opcion = Keyboard.readInt();
            switch (opcion) {
                case 1:
                    if (ManejaInventarios.inventario.isEmpty()) {
                        System.out.println("\n\033[31mNO HAY PRODUCTOS REGISTRADOS, NO ES POSIBLE VENDER.\033[34m");
                    } else {
                        System.out.println("\n- INGRESE LOS DATOS DE LA VENTA -\n");
                        do {
                            System.out.println("EL CLIENTE ESTA REGISTRADO (1.- SI/2.- NO)");
                            cR = Keyboard.readInt();
                            System.out.println("");
                            if (cR == 1) {
                                do {
                                    System.out.println("INGRESE EL ID DEL CLIENTE.");
                                    idCliente = Keyboard.readInt();
                                    if (manejaPersona.buscarCliente(idCliente) == -1) {
                                        System.out.println("\033[31mEL ID INGRESADO NO EXISTE.\n\033[34m");
                                    }
                                } while (manejaPersona.buscarCliente(cR) == -1);
                                System.out.println((Cliente) manejaPersona.personas.get(manejaPersona.buscarCliente(idCliente)));
                            } else {
                                do {
                                    System.out.println("INGRESE EL NOMBRE DEL CLIENTE");
                                    nombreCliente = Keyboard.readString();
                                    if (nombreCliente.trim().isEmpty()) {
                                        System.out.println("\033[31mEl nombre ingresado es invalido.\n\033[34m");
                                    }
                                } while (nombreCliente.trim().isEmpty());
                                do {
                                    System.out.println("INGRESE EL APELLIDO DEL CLIENTE.");
                                    apellidoCliente = Keyboard.readString();
                                    if (apellidoCliente.trim().isEmpty()) {
                                        System.out.println("\033[31mEl apellido ingresado es invalido.\n\033[34m");
                                    }
                                } while (apellidoCliente.trim().isEmpty());
                                do {
                                    System.out.println("INGRESE EL RFC (Indique 0 si no desea ingresar RFC)");
                                    rfcCliente = Keyboard.readString();
                                    if (rfcCliente.trim().isEmpty()) {
                                        System.out.println("\033[31mEl RFC ingresado es invalido.\n\033[34m");
                                    }
                                } while (rfcCliente.trim().isEmpty());
                                do {
                                    System.out.println("INGRESE EL TELEFONO DEL CLIENTE.");
                                    telefonoCliente = Keyboard.readLong();
                                    if (apellidoCliente.trim().isEmpty()) {
                                        System.out.println("\033[31mEl Apellido ingresado es invalido.\n\033[34m");
                                    }
                                } while (telefonoCliente < 1);
                            }
                            manejaPersona.agregar(nombreCliente, apellidoCliente, telefonoCliente, rfcCliente);
                        } while (cR < 1 || cR > 2);

                        System.out.println("INGRESE EL SKU A VENDER.");
                        SKU = Keyboard.readInt();
                        if (ManejaInventarios.buscarProducto(SKU) == -1) {
                            do {
                                System.out.println("\033[31mEL SKU INGRESADO NO EXISTE, INGRESE EL SKU DE NUEVO\n");
                                SKU = Keyboard.readInt();
                            } while (ManejaInventarios.buscarProducto(SKU) == -1);

                        }
                        String CV = "";
                        if (ManejaInventarios.inventario.get(0) == null) {
                            System.out.println("*NO HAY ARTICULOS PARA VENDER*");
                            break;
                        }
                        System.out.println("INGRESE LA CLAVE DE LA VENTA");
                        CV = Keyboard.readString();
                        if (Manejaventas.buscarVenta(CV) != -1) {
                            do {
                                System.out.println("CLAVE DE VENTA EXISTENTE, INGRESE UNA UNICA");
                                CV = Keyboard.readString();
                            } while (Manejaventas.buscarVenta(CV) != -1);
                        }
                        do {
                            System.out.println("¿CUANTOS PRODUCTOS DESEA COMPRAR?");
                            p = Keyboard.readInt();
                        } while (p < 1);
                        for (int i = 0; i < ManejaInventarios.inventario.size(); i++) {
                            if (p > ManejaInventarios.inventario.get(i).getExistencia()) {
                                System.out.println("EXISTENCIA INSUFICIENTE, EXISTENCIA ACTUAL : " + ManejaInventarios.inventario.get(i).getExistencia());
                                return;
                            }
                            ManejaInventarios.inventario.get(i).setExistencia(ManejaInventarios.inventario.get(i).getExistencia() - p);

                            Manejaventas.Agregar(CV, SKU, p, ManejaInventarios.inventario.get(i).getPrecioUni(), f.getDia(), f.getMes(), f.getAño(), idCliente);
                            ((Cliente) manejaPersona.personas.get(idCliente)).aumentarCompras();
                        }
                    }
                    break;
                case 2:
                    Manejaventas.Imprimir();
                    break;
                case 3:
                    String CVm;
                    if (Manejaventas.Ventas.get(0) == null) {
                        System.out.println("*NO HAY VENTAS REGISTRADAS*");
                        break;
                    }
                    System.out.println("ESCRIBE LA CLAVE DE LA VENTA QUE DESEA MODIFICAR");
                    CVm = Keyboard.readString();
                    Manejaventas.ModificarCantidad(CVm, ManejaInventarios);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("*INTRODUCE UNA OPCIÓN VALIDA*");
            }
        } while (opcion != 0);
    }

    public void menuFinanzas(ManejaFinanzas ManejaFinanza, ManejaVentas manejaVentas) {
        int opcion = 0;
        do {
            System.out.println();
            System.out.println("************* MENU FINANZAS **************");
            System.out.println("1.-BUSCAR GANANCIAS DE UN DIA");
            System.out.println("2.-BUSCAR GANANCIAS DEL MES");
            System.out.println("0.-SALIR");
            System.out.print("INTRODUCE UNA OPCION: ");
            opcion = Keyboard.readInt();
            switch (opcion) {
                case 1:
                    int d,
                     m,
                     a;
                    System.out.println("ESCRIBE EL DIA");
                    d = Keyboard.readInt();
                    System.out.println("ESCRIBE EL MES");
                    m = Keyboard.readInt();
                    System.out.println("ESCRIBE EL AÑO");
                    a = Keyboard.readInt();
                    ManejaFinanza.Ventadia(d, m, a, manejaVentas);
                    break;
                case 2:
                    System.out.println("ESCRIBE EL MES");
                    m = Keyboard.readInt();
                    System.out.println("ESCRIBE EL AÑO");
                    a = Keyboard.readInt();
                    ManejaFinanza.VentaMes(m, a, manejaVentas);
                    break;
                case 0:
                    break;
                default:
                    System.out.println("*INTRODUCE UNA OPCIÓN VALIDA*");
            }
        } while (opcion != 0);
    }

    public void menuProductos(ManejaInventario manejaInventario) {

        int keyME;
        do {
            System.out.println("\n\033[33m------------- PRODUCTOS -------------\nINGRESE LA OPCION QUE DESEA REALIZAR\n");
            System.out.println("1.- AGREGAR\n2.- BUSCAR\n3.- MODIFICAR\n4.- IMPRIMIR\n\033[33m0.- SALIR\033[34m");
            keyME = Keyboard.readInt();
            switch (keyME) {
                case 1:
                    String tela,
                     corte,
                     material,
                     color,
                     tipo;
                    int keyTT,
                     SKU,
                     existencia,
                     talla,
                     tamano;
                    double precio;
                    System.out.println("\nINGRESA LOS DATOS DEL PRODUCTO POR AGREGAR\n");
                    do {
                        System.out.println("SELECCIONA EL TIPO DE PRODUCTO QUE DESEAS AGREGAR.");
                        System.out.println("\n1.- TEXTIL | 2.- TAZA | 3.- TARRO");
                        keyTT = Keyboard.readInt();
                    } while (keyTT < 1 || keyTT > 3);
                    do {
                        System.out.println("SKU");
                        SKU = Keyboard.readInt();
                        if (SKU < 0) {
                            System.out.println("\033[31mSKU INVALIDO\n\033[34m");
                        } else if (manejaInventario.buscarProducto(SKU) != -1) {
                            System.out.println("\033[31mSKU YA EXISTENTE\n\033[34m");
                            SKU = -1;
                        }
                    } while (SKU < 0);
                    do {
                        System.out.println("PRECIO");
                        precio = Keyboard.readDouble();
                        if (Double.isNaN(precio) || precio < 0.1) {
                            System.out.println("\033[31mPRECIO INVALIDO\n\033[34m");
                        }
                    } while (Double.isNaN(precio) || precio < 0.1);
                    do {
                        System.out.println("EXISTENCIA");
                        existencia = Keyboard.readInt();
                        if (existencia < 0) {
                            System.out.println("\033[31mEXISTENCIA INVALIDA\n\033[34m");
                        }
                    } while (existencia < 0);
                    switch (keyTT) {
                        //TEXTIL
                        case 1:
                            do {
                                System.out.println("TELA");
                                tela = Keyboard.readString();
                                if (tela.trim().isEmpty()) {
                                    System.out.println("\033[31mTELA INVALIDA\n\033[34m");
                                }
                            } while (tela.trim().isEmpty());
                            do {
                                System.out.println("CORTE");
                                corte = Keyboard.readString();
                                if (corte.trim().isEmpty()) {
                                    System.out.println("\033[31mCORTE INVALIDO\n\033[34m");
                                }
                            } while (corte.trim().isEmpty());
                            do {
                                System.out.println("TALLA");
                                talla = Keyboard.readInt();
                                if (talla < 0) {
                                    System.out.println("\033[31mTALLA INVALIDA\n\033[34m");
                                }
                            } while (talla < 0);
                            manejaInventario.agregar(SKU, precio, existencia, tela, corte, talla);
                            break;
                        // TAZA
                        case 2:
                            do {
                                System.out.println("MATERIAL");
                                material = Keyboard.readString();
                                if (material.trim().isEmpty()) {
                                    System.out.println("\033[31mMATERIAL INVALIDO\n\033[34m");
                                }
                            } while (material.trim().isEmpty());
                            do {
                                System.out.println("COLOR");
                                color = Keyboard.readString();
                                if (color.trim().isEmpty()) {
                                    System.out.println("\033[31mCOLOR INVALIDO\n\033[34m");
                                }
                            } while (color.trim().isEmpty());
                            do {
                                System.out.println("TAMAÑO");
                                tamano = Keyboard.readInt();
                                if (tamano < 0) {
                                    System.out.println("\033[31mTAMAÑO INVALIDA\n\033[34m");
                                }
                            } while (tamano < 0);
                            manejaInventario.agregar(SKU, precio, existencia, material, tamano, color);
                            break;
                        // TARRO
                        case 3:
                            do {
                                System.out.println("TIPO");
                                tipo = Keyboard.readString();
                                if (tipo.trim().isEmpty()) {
                                    System.out.println("\033[31mTIPO INVALIDO\n\033[34m");
                                }
                            } while (tipo.trim().isEmpty());
                            do {
                                System.out.println("TAMAÑO");
                                tamano = Keyboard.readInt();
                                if (tamano < 0) {
                                    System.out.println("\033[31mTAMAÑO INVALIDA\n\033[34m");
                                }
                            } while (tamano < 0);
                            manejaInventario.agregar(SKU, precio, existencia, tipo, tamano);
                            break;
                        default:
                    }
                    System.out.println("\n\033[32mPRODUCTO AGREGADO CORRECTAMENTE\033[34m");
                    int posAP = manejaInventario.buscarProducto(SKU);
                    System.out.println(manejaInventario.inventario.get(posAP));
                    break;
                case 2:
                    System.out.println("\nINGRESA EL SKU DEL PRODUCTO A BUSCAR");
                    int idBP = Keyboard.readInt();
                    if (manejaInventario.buscarProducto(idBP) != -1) {
                        System.out.println(manejaInventario.inventario.get(manejaInventario.buscarProducto(idBP)));
                    } else {
                        System.out.println("\033[31mPRODUCTO INEXISTENTE\n\033[34m");
                    }
                    break;
                case 3:
                    System.out.println("INTRODUZCA EL SKU DEL PRODUCTO POR MODIFICAR");
                    int modP = Keyboard.readInt();
                    if (manejaInventario.buscarProducto(modP) != -1) {
                        int pos = manejaInventario.buscarProducto(modP);
                        int keyModE;
                        do {
                            System.out.println("\n\033[33m-----\nEL PRODUCTO A MODIFICAR ES...");
                            System.out.println(manejaInventario.inventario.get(pos));
                            System.out.println("\n1.- SKU\n2.- PRECIO\n3.- EXISTENCIA");
                            if (manejaInventario.inventario.get(pos) instanceof Textil) {
                                System.out.println("4.- TELA\n5.- CORTE\n6.- TALLA");
                            }
                            if (manejaInventario.inventario.get(pos) instanceof Taza) {
                                System.out.println("4.- MATERIAL\n5.- TAMAÑO\n6.- COLOR");
                            }
                            if (manejaInventario.inventario.get(pos) instanceof Tarro) {
                                System.out.println("4.- TIPO\n5.- TAMAÑO");
                            }
                            System.out.println("\033[33m0.- SALIR\033[34m");
                            keyModE = Keyboard.readInt();
                            switch (keyModE) {
                                case 1:
                                    int newSKU;
                                    do {
                                        System.out.println("\nINGRESA EL NUEVO SKU");
                                        newSKU = Keyboard.readInt();
                                        if (newSKU < 0) {
                                            System.out.println("\033[31mSKU INVALIDO\n\033[34m");
                                        } else if (manejaInventario.buscarProducto(newSKU) != -1) {
                                            System.out.println("\033[31mSKU YA EXISTENTE\n\033[34m");
                                            SKU = -1;
                                        }
                                    } while (newSKU < 0);
                                    manejaInventario.inventario.get(pos).SetSKU(newSKU);
                                    break;
                                case 2:
                                    double newPrecio;
                                    do {
                                        System.out.println("\nINGRESE EL NUEVO PRECIO");
                                        newPrecio = Keyboard.readDouble();
                                        if (Double.isNaN(newPrecio) || newPrecio < 0) {
                                            System.out.println("\033[31mPRECIO INVALIDO\n\033[34m");
                                        }
                                    } while (Double.isNaN(newPrecio) || newPrecio < 0);
                                    manejaInventario.inventario.get(pos).setPrecioUni(newPrecio);
                                    break;
                                case 3:
                                    int newExistencia;
                                    do {
                                        System.out.println("\nINGRESE LA NUEVA EXISTENCIA");
                                        newExistencia = Keyboard.readInt();
                                        if (newExistencia < 0) {
                                            System.out.println("\033[31mEXISTENCIA INVALIDA\n\033[34m");
                                        }
                                    } while (newExistencia < 0);
                                    manejaInventario.inventario.get(pos).setExistencia(newExistencia);
                                    break;
                                case 4:
                                    if (manejaInventario.inventario.get(pos) instanceof Textil) {
                                        String newTela;
                                        do {
                                            System.out.println("\nINGRESE LA NUEVA TELA");
                                            newTela = Keyboard.readString();
                                            if (newTela.trim().isEmpty()) {
                                                System.out.println("\033[31mTELA INVALIDA\n\033[34m");
                                            }
                                        } while (newTela.trim().isEmpty());
                                        ((Textil) manejaInventario.inventario.get(pos)).SetTela(newTela);
                                    } else if (manejaInventario.inventario.get(pos) instanceof Taza) {
                                        String newMaterial;
                                        do {
                                            System.out.println("\nINGRESE EL NUEVO MATERIAL");
                                            newMaterial = Keyboard.readString();
                                            if (newMaterial.trim().isEmpty()) {
                                                System.out.println("\033[31mMATERIAL INVALIDO\n\033[34m");
                                            }
                                        } while (newMaterial.trim().isEmpty());
                                        ((Taza) manejaInventario.inventario.get(pos)).SetMaterial(newMaterial);
                                    } else if (manejaInventario.inventario.get(pos) instanceof Tarro) {
                                        String newTipo;
                                        do {
                                            System.out.println("\nINGRESE EL NUEVO TIPO");
                                            newTipo = Keyboard.readString();
                                            if (newTipo.trim().isEmpty()) {
                                                System.out.println("\033[31mTIPO INVALIDO\n\033[34m");
                                            }
                                        } while (newTipo.trim().isEmpty());
                                        ((Tarro) manejaInventario.inventario.get(pos)).SetTipo(newTipo);
                                    }
                                    break;
                                case 5:
                                    if (manejaInventario.inventario.get(pos) instanceof Textil) {
                                        String newCorte;
                                        do {
                                            System.out.println("\nINGRESE EL NUEVO CORTE");
                                            newCorte = Keyboard.readString();
                                            if (newCorte.trim().isEmpty()) {
                                                System.out.println("\033[31mCORTE INVALIDO\n\033[34m");
                                            }
                                        } while (newCorte.trim().isEmpty());
                                        ((Textil) manejaInventario.inventario.get(pos)).SetCorte(newCorte);
                                    } else if (manejaInventario.inventario.get(pos) instanceof Taza) {
                                        int newTamano;
                                        do {
                                            System.out.println("TAMAÑO");
                                            newTamano = Keyboard.readInt();
                                            if (newTamano < 0) {
                                                System.out.println("\033[31mTAMAÑO INVALIDO\n\033[34m");
                                            }
                                        } while (newTamano < 0);
                                        ((Taza) manejaInventario.inventario.get(pos)).SetTamano(newTamano);
                                    } else if (manejaInventario.inventario.get(pos) instanceof Tarro) {
                                        int newTamano;
                                        do {
                                            System.out.println("TAMAÑO");
                                            newTamano = Keyboard.readInt();
                                            if (newTamano < 0) {
                                                System.out.println("\033[31mTAMAÑO INVALIDO\n\033[34m");
                                            }
                                        } while (newTamano < 0);
                                        ((Tarro) manejaInventario.inventario.get(pos)).SetTamano(newTamano);
                                    }
                                    break;
                                case 6:
                                    if (manejaInventario.inventario.get(pos) instanceof Tarro) {
                                        System.out.println("\033[31mOPCION INVALIDA\033[34m");
                                    } else {
                                        if (manejaInventario.inventario.get(pos) instanceof Textil) {
                                            int newTalla;
                                            do {
                                                System.out.println("\nINGRESE LA NUEVA TALLA");
                                                newTalla = Keyboard.readInt();
                                                if (newTalla < 0) {
                                                    System.out.println("\033[31mTALLA INVALIDA\033[34m");
                                                }
                                            } while (newTalla < 0);
                                            ((Textil) manejaInventario.inventario.get(pos)).SetTalla(newTalla);
                                        }
                                        if (manejaInventario.inventario.get(pos) instanceof Taza) {
                                            String newColor;
                                            do {
                                                System.out.println("COLOR");
                                                newColor = Keyboard.readString();
                                                if (newColor.trim().isEmpty()) {
                                                    System.out.println("\033[31mCOLOR INVALIDO\n\033[34m");
                                                }
                                            } while (newColor.trim().isEmpty());
                                            ((Taza) manejaInventario.inventario.get(pos)).SetColor(newColor);
                                        }
                                    }
                                    break;
                                case 0:
                                    break;
                                default:
                                    System.out.println("\033[31mOPCION INVALIDA\033[34m");
                            }
                        } while (keyModE != 0);
                    } else {
                        System.out.println("\033[32mPRODUCTO INEXISTENTE\n\033[34m");
                    }
                    break;
                case 4:
                    if (!manejaInventario.inventario.isEmpty()) {
                        System.out.println("\nPRODUCTOS REGISTRADOS");
                        manejaInventario.imprimir(1);
                    } else {
                        System.out.println("\033[31mNO HAY PRODUCTOS REGISTRADOS\033[34m");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("\033[31mOPCION INVALIDA\n\033[34m");
            }
        } while (keyME != 0);
    }

    public void menuEmpleados(ManejaPersonas manejaPersona) {

        int keyME;
        do {
            System.out.println("\n\033[33m------------- EMPLEADOS -------------\nINGRESE LA OPCION QUE DESEA REALIZAR\n");
            System.out.println("1.- AGREGAR\n2.- BUSCAR\n3.- MODIFICAR\n4.- IMPRIMIR\n\033[33m0.- SALIR\033[34m");
            keyME = Keyboard.readInt();
            switch (keyME) {
                case 1:
                    String nombre,
                     apellido,
                     RFC;
                    long telefono;
                    double sueldo;
                    System.out.println("\nINGRESA LOS DATOS DEL EMPLEADO POR AGREGAR\n");
                    do {
                        System.out.println("NOMBRE");
                        nombre = Keyboard.readString();
                        if (nombre.trim().isEmpty()) {
                            System.out.println("\033[31mNOMBRE INVALIDO\n\033[34m");
                        }
                    } while (nombre.trim().isEmpty());
                    do {
                        System.out.println("APELLIDO");
                        apellido = Keyboard.readString();
                        if (apellido.trim().isEmpty()) {
                            System.out.println("\033[31mAPELLIDO INVALIDO\n\033[34m");
                        }
                    } while (apellido.trim().isEmpty());
                    do {
                        System.out.println("TELEFONO");
                        telefono = Keyboard.readLong();
                        if (telefono < 0) {
                            System.out.println("\033[31mTELEFONO INVALIDO\n\033[34m");
                        }
                    } while (telefono < 0);
                    do {
                        System.out.println("RFC");
                        RFC = Keyboard.readString();
                        if (RFC.trim().isEmpty()) {
                            System.out.println("\033[31mRFC INVALIDO\n\033[34m");
                        }
                    } while (RFC.trim().isEmpty());
                    do {
                        System.out.println("SUELDO");
                        sueldo = Keyboard.readDouble();
                        if (Double.isNaN(sueldo) || sueldo < 0) {
                            System.out.println("\033[31mSUELDO INVALIDO\033[34m");
                        }
                    } while (Double.isNaN(sueldo) || sueldo < 0);
                    manejaPersona.agregar(nombre, apellido, telefono, RFC, sueldo);
                    System.out.println("\n\033[32mEMPLEADO AGREGADO CORRECTAMENTE\033[34m");
                    int posEA = manejaPersona.buscarEmpleado(contEA);
                    System.out.println(manejaPersona.personas.get(posEA));
                    contEA++;
                    break;
                case 2:
                    System.out.println("\nINGRESA EL ID DEL EMPLEADO A BUSCAR");
                    int idBE = Keyboard.readInt();
                    if (manejaPersona.buscarEmpleado(idBE) != -1) {
                        System.out.println(manejaPersona.personas.get(manejaPersona.buscarEmpleado(idBE)));
                    } else {
                        System.out.println("\033[31mEMPLEADO INEXISTENTE\n\033[34m");
                    }
                    break;
                case 3:
                    System.out.println("INTRODUZCA EL ID DEL EMPLEADO POR MODIFICAR");
                    int modE = Keyboard.readInt();
                    if (manejaPersona.buscarEmpleado(modE) != -1) {
                        int pos = manejaPersona.buscarEmpleado(modE);
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
                                        if (Double.isNaN(newSueldo) || newSueldo < 0) {
                                            System.out.println("\033[31mSUELDO INVALIDO\033[34m");
                                        }
                                    } while (Double.isNaN(newSueldo) || newSueldo < 0);
                                    ((Empleado) manejaPersona.personas.get(pos)).setSueldo(newSueldo);
                                    break;
                                case 0:
                                    break;
                                default:
                                    System.out.println("\033[31mOPCION INVALIDA\n\033[34m");
                            }
                        } while (keyModE != 0);
                    } else {
                        System.out.println("\033[32mEMPLEADO INEXISTENTE\n\033[34m");
                    }
                    break;
                case 4:
                    if (!manejaPersona.personas.isEmpty()) {
                        System.out.println("\nEMPLEADOS REGISTRADOS");
                        manejaPersona.imprimir(3);
                    } else {
                        System.out.println("\033[31mNO HAY EMPLEADOS REGISTRADOS\033[34m");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("\033[31mOPCION INVALIDA\n\033[34m");
            }
        } while (keyME != 0);
    }

    public void menuClientes(ManejaPersonas manejaPersona) {

        int keyMC;
        do {
            System.out.println("\n\033[33m-------------- CLIENTES --------------\nINGRESE LA OPCION QUE DESEA REALIZAR\n");
            System.out.println("1.- AGREGAR\n2.- BUSCAR\n3.- MODIFICAR\n4.- IMPRIMIR\n\033[33m0.- SALIR\033[34m");
            keyMC = Keyboard.readInt();
            switch (keyMC) {
                case 1:
                    String nombre,
                     apellido,
                     RFC;
                    long telefono;
                    System.out.println("\nINGRESA LOS DATOS DEL CLIENTE POR AGREGAR\n");
                    do {
                        System.out.println("NOMBRE");
                        nombre = Keyboard.readString();
                        if (nombre.trim().isEmpty()) {
                            System.out.println("\033[31mNOMBRE INVALIDO\n\033[34m");
                        }
                    } while (nombre.trim().isEmpty());
                    do {
                        System.out.println("APELLIDO");
                        apellido = Keyboard.readString();
                        if (apellido.trim().isEmpty()) {
                            System.out.println("\033[31mAPELLIDO INVALIDO\n\033[34m");
                        }
                    } while (apellido.trim().isEmpty());
                    do {
                        System.out.println("TELEFONO");
                        telefono = Keyboard.readLong();
                        if (telefono < 0) {
                            System.out.println("\033[31mTELEFONO INVALIDO\n\033[34m");
                        }
                    } while (telefono < 0);
                    do {
                        System.out.println("RFC");
                        RFC = Keyboard.readString();
                        if (RFC.trim().isEmpty()) {
                            System.out.println("\033[31mRFC INVALIDO\n\033[34m");
                        }
                    } while (RFC.trim().isEmpty());
                    manejaPersona.agregar(nombre, apellido, telefono, RFC, 0);
                    System.out.println("\n\033[32mCLIENTE AGREGADO CORRECTAMENTE\033[34m");
                    int posCA = manejaPersona.buscarCliente(contCA);
                    System.out.println(manejaPersona.personas.get(posCA));
                    contCA++;
                    break;
                case 2:
                    System.out.println("\nINGRESA EL ID DEL CLIENTE A BUSCAR");
                    int idBC = Keyboard.readInt();
                    if (manejaPersona.buscarCliente(idBC) != -1) {
                        System.out.println(manejaPersona.personas.get(manejaPersona.buscarCliente(idBC)));
                    } else {
                        System.out.println("\n\033[31mCLIENTE INEXISTENTE\033[34m");
                    }
                    break;
                case 3:
                    System.out.println("INTRODUZCA EL ID DEL CLIENTE POR MODIFICAR");
                    int modC = Keyboard.readInt();
                    if (manejaPersona.buscarCliente(modC) != -1) {
                        int pos = manejaPersona.buscarCliente(modC);
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
                                default:
                                    System.out.println("\033[31mOPCION INVALIDA\n\033[34m");
                            }
                        } while (keyModC != 0);
                    } else {
                        System.out.println("\033[32mCLIENTE INEXISTENTE\n\033[34m");
                    }
                    break;
                case 4:
                    if (!manejaPersona.personas.isEmpty()) {
                        System.out.println("\nCLIENTES REGISTRADOS");
                        manejaPersona.imprimir(2);
                    } else {
                        System.out.println("\033[31mNO HAY CLIENTES REGISTRADOS\033[34m");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("\033[31mOPCION INVALIDA\n\033[34m");
            }
        } while (keyMC != 0);
    }
}