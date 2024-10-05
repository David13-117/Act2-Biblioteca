package actividad2sistemagestionbiblioteca;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;


public class Actividad2sistemagestionbiblioteca {

    private static Scanner leer = new Scanner(System.in);
    public static ArrayList<String[]> libros = new ArrayList<>();
    public static ArrayList<String[]> user = new ArrayList<>();
    public static Stack<String> prestamos = new Stack<>();
    public static Queue <String> listaespera = new LinkedList<>();

    public static void main(String[] args) {
        
        System.out.println("1024551830\nDavid Castillo");

        int opcion;

        String msgerror = ("\nIngrese una opción valida\n");

        do {
            menu();
            opcion = leer.nextInt();
            leer.nextLine();

            switch (opcion) {
                case 1:
                    menuregistro();
                    opcion = leer.nextInt();
                    leer.nextLine();

                    switch (opcion) {
                        case 1:
                            agregar_libros();
                            
                            break;

                        case 2:
                             agregar_usuario();
                            break;
                        
                        case 3:
                            break;

                        default:
                            System.out.println(msgerror);
                    }
                    break;

                case 2:
                    menuconsulta();
                    opcion = leer.nextInt();
                    leer.nextLine();
                    
                    switch (opcion) {
                        case 1:
                            System.out.println("Ingrese el id del libro");
                            String id = leer.nextLine();
                            buscarLibro(libros, id);
                            break;
                            
                        case 2:
                            System.out.println("Ingrese la identificación del usuario");
                            int cc = leer.nextInt();
                            buscarusuario(user, cc);
                            break;
                            
                        case 3:
                            mostrar_inv();
                            break;
                            
                        case 4 :
                            break;
                            
                        default:
                            System.out.println(msgerror);
                    }
                    
                    break;

                case 3:
                    System.out.println("Ingrese el Id del libro: ");
                    String lbp = leer.nextLine();
                    prestamo(lbp);
                    break;

                case 4:
                    System.out.println("Ingresa tú id de usuario: ");
                    int cc = leer.nextInt();
                    leer.nextLine();
                    devolucion(cc);
                    break;

                case 5:
                    System.out.println("Saliendo del programa...");
                    System.exit(0);
                    break;

                default:
                    System.out.println(msgerror);
            }
        } while (opcion != 5);

    }

    private static void menu() {
        System.out.println("--------------------------------");
        System.out.println("Sistema de Gestión de Biblioteca");
        System.out.println("--------------------------------");
        System.out.println("Menu:");
        System.out.println("1. Registro");
        System.out.println("2. Consultar");
        System.out.println("3. Prestamos");
        System.out.println("4. Devolución");
        System.out.println("5. Salir");
        System.out.println("Seleccione una opción");
    }

    private static void menuregistro() {
        System.out.println("Registro.\n----------------");
        System.out.println("1. Registrar libro");
        System.out.println("2. Registrar usuario");
        System.out.println("3. Atrás");
    }

    private static void menuconsulta() {
        System.out.println("\nConsulta. \n---------------");
        System.out.println("1. Buscar libro");
        System.out.println("2. Buscar usuario");
        System.out.println("3. Consultar inventario");
        System.out.println("4. Atrás");
    }

    private static void agregar_libros() {
        System.out.println("Registrar libros.\n-----------------");
        System.out.println("Ingrese el nombre del libro");
        String nombrelib = leer.nextLine();
        System.out.println("Ingresa el Autor del libro");
        String autorlib = leer.nextLine();
        int num = libros.size();
        String id = ("Lb"+num);
        boolean dispo = true;
        libros.add(new String[]{id,nombrelib,autorlib,String.valueOf(dispo)});
        System.out.println("Libro agregado con exito");
    }
    
    private static void agregar_usuario(){
        System.out.println("Registrar Usuario.\n-----------------");
        System.out.println("Ingresa un número de identificación");
        int iduser = leer.nextInt();
        leer.nextLine();
        System.out.println("Ingrese el nombre de usuario");
        String nomuser = leer.nextLine();
        System.out.println("Ingresa un número de telefono");
        int numcell = leer.nextInt();
        user.add(new String []{String.valueOf(iduser),nomuser, String.valueOf(numcell)});
        System.out.println("Usuario registrado con exito");
    }
    
    private static void buscarLibro(ArrayList<String[]> libros, String id){
        boolean encontrado = false;

        for (String[] libro : libros) {
            if (libro[0].equals(id)) {
                System.out.println("\nLibro encontrado:");
                System.out.println("ID: " + libro[0]);
                System.out.println("Nombre: " + libro[1]);
                System.out.println("Autor: " + libro[2]);
                System.out.println("Disponible: " + (libro[3].equals("true") ? "Sí" : "No"));
                encontrado = true;
                
            }else
                System.out.println("No se encontró ningún libro con ID: " + id);
        }

    }
    
    private static void buscarusuario(ArrayList<String[]> user, int cc){
       boolean encontrado = false;

        for (String[] usuario : user) {
            int cc0 = Integer.parseInt(usuario[0]);
            if (cc0 == cc) {
                System.out.println("\nUsuario encontrado:");
                System.out.println("CC: " + usuario[0]);
                System.out.println("Nombre: " + usuario[1]);
                System.out.println("Telefono: " + usuario[2]);
                encontrado = true;
                
            }else
                System.out.println("No se encontró ningún usuario con identificación: " + cc);
        } 
    }
    
    private static void mostrar_inv() {
        System.out.println("\nInventario de libros:");
        for (String[] libro : libros) {
            System.out.println("ID: " + libro[0]);
            System.out.println("Nombre: " + libro[1]);
            System.out.println("Autor: " + libro[2]);
            System.out.println("Disponible: " + (libro[3].equals("true") ? "Sí" : "No"));
        }
    }

    private static void prestamo(String lbp) {

        for (String[] libro : libros) {
            if (libro[0].equals(lbp)) {
                System.out.println("\nLibro encontrado:");
                System.out.println("ID: " + libro[0]);
                System.out.println("Nombre: " + libro[1]);
                System.out.println("Autor: " + libro[2]);
                System.out.println("Disponible: " + (libro[3].equals("true") ? "Sí" : "No"));
                System.out.println("1. Reservar");
                System.out.println("2. Atrás");
                int op = leer.nextInt();

                switch (op) {
                    case 1:
                        System.out.println("Ingresa tú id de usuario");
                        int cc = leer.nextInt();

                        for (String[] usuario : user) {
                            int cc0 = Integer.parseInt(usuario[0]);
                            if (cc0 == cc) {
                                if (libro[3].equals("true")) {
                                    libro[3] = "false";
                                    System.out.println("Libro reseervado con exito");
                                    prestamos.push(lbp);

                                } else {
                                    System.out.println("Libro no disponible");
                                    System.out.println("Desea ingresar a la lista de espera?");
                                    System.out.println("1. Si");
                                    System.out.println("2. No");
                                    op = leer.nextInt();

                                    switch (op) {
                                        case 1:
                                            listaespera.offer(String.valueOf(cc));
                                            System.out.println("Agregado a la lista de espera.");
                                            break;

                                        case 2:
                                            break;

                                        default:
                                            System.out.println("\nIngrese una opción valida\n");
                                    }
                                }
                            } else {
                                System.out.println("No se encontró ningún usuario con identificación: " + cc);
                            }
                        }

                        break;

                    case 2:
                        break;

                    default:
                        System.out.println("\nIngrese una opción valida\n");
                }
                break;
            } else {
                System.out.println("No se encontró ningún libro con ID: " + lbp);
            }

        }

    }
    
    private static void devolucion(int cc) {

        for (String[] usuario : user) {
            
            int cc0 = Integer.parseInt(usuario[0]);
            if (cc0 == cc) {
                System.out.println("Ingresa el id del libro a devolver: ");
                String lbd = leer.nextLine();
                for (String[] libro : libros) {
                    if (libro[0].equals(lbd)) {
                        if (libro[3].equals("false") && listaespera.isEmpty()) {
                            libro[3] = "true";
                            System.out.println("Libro devuelto con exito, muchas gracias");

                        } else if (libro[3].equals("false") && !listaespera.isEmpty()) {
                            listaespera.remove();
                            System.out.println("libro devuelto! Reasignado....");

                        } else {
                            System.out.println("Por favor valide el id del libro");
                        }break;
                    }else {
                        System.out.println("No se encontró ningún libro con ID: " + lbd);
                    }
                }break;
            } else {
                System.out.println("No se encontró ningún usuario con identificación: " + cc);
            }
        }
    }
    
}
