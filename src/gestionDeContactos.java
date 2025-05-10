import java.util.ArrayList;
import java.util.Scanner;

 public class gestionDeContactos{

    private static ArrayList<Contacto> listaContactos = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("=== BIENVENIDO AL SISTEMA DE GESTIONAR CONTACTOS ===");
        int opcion;
//para que se repita hata que precionen el numero 5 que es salir

        do {
            mostrarMenu();
            System.out.print("Seleccione una opcion: ");
            opcion = scanner.nextInt();
            scanner.nextLine();
            switch (opcion) {
                case 1:
                    agregarContacto();
                    break;
                case 2:
                    buscarContacto();
                    break;
                case 3:
                    eliminarContacto();
                    break;
                case 4:
                    mostrarContactos();
                    break;
                case 5:
                    System.out.println("Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
        }while(opcion != 5);



    }
    //000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000
    //esta seccion es para dar regla a los valores ingresado, de tal manera que sean validos
    private static String obtenerCorreoValido() {
        String correo;
        String regex;
        do {
            System.out.print("Ingrese su correo electrónico: ");
            correo = scanner.nextLine().trim(); // Eliminamos espacios innecesarios

            // Expresión regular para validar un correo electrónico estándar
            regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

            // Validamos si el correo cumple con el formato esperado
            if (!correo.matches(regex)) {
                System.out.println("Error: Ingrese un correo válido (ejemplo: usuario@email.com). Intente nuevamente.");
            }
        } while (!correo.matches(regex)); // Repetimos hasta que el usuario ingrese un correo correcto

        return correo;
    }
    private static String obtenerTelefonoValido() {
        String telefono;
        do {
            System.out.print("Ingrese su número de teléfono (9 dígitos, debe comenzar con 9): ");
            telefono = scanner.nextLine().trim(); // Eliminamos espacios innecesarios

            // Validamos que tenga 9 caracteres, solo números y que empiece con '9'
            if (telefono.length() != 9 || !telefono.matches("\\d+") || telefono.charAt(0) != '9') {
                System.out.println("Error: El número debe tener 9 dígitos y comenzar con 9. Intente nuevamente.");
            }
        } while (telefono.length() != 9 || !telefono.matches("\\d+") || telefono.charAt(0) != '9');

        return telefono;
    }
    private static String obtenerNombreValido(){
        String nombre;
        do {
            System.out.print("Ingrese el nombre: ");
            nombre = scanner.nextLine().trim(); // Eliminamos espacios innecesarios
            if (nombre.isEmpty()) {
                System.out.println("Error: El nombre no puede estar vacío. Intente nuevamente.");
            }
        } while (nombre.isEmpty()); // Repetimos hasta que el usuario ingrese un nombre válido
        return nombre;
    }
    //000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000
    // Metodo para mostrar el menú
    private static void mostrarMenu() {
        System.out.println("\nMenú Principal:");
        System.out.println("1. Agregar contacto");
        System.out.println("2. Buscar contacto");
        System.out.println("3. Eliminar contacto");
        System.out.println("4. Mostrar todos los contactos");
        System.out.println("5. Salir");
    }

    // Metodo para agregar un nuevo contacto
    private static void agregarContacto() {

        //se llama al metodo donde se ingresa el valor y se verifica
        // que sea valido, asi con cada uno de estos valores
        String nombre = obtenerNombreValido();
        String telefono = obtenerTelefonoValido();
        String correo = obtenerCorreoValido();

        Contacto nuevoContacto = new Contacto(nombre, telefono, correo);
        listaContactos.add(nuevoContacto);
        System.out.println("Contacto agregado exitosamente.");
    }

    // Metodo para buscar un contacto por nombre
    private static void buscarContacto() {
        System.out.print("Ingrese el nombre del contacto a buscar: ");
        String nombreBuscado = scanner.nextLine();

        for (Contacto contacto : listaContactos) {
            if (contacto.getNombre().equalsIgnoreCase(nombreBuscado)) {
                System.out.println("Resultado encontrado: " + contacto);
                return;
            }
        }
        System.out.println("Contacto no encontrado.");
    }

    // Metodo para eliminar un contacto por nombre
    private static void eliminarContacto() {
        System.out.print("Ingrese el nombre del contacto a eliminar: ");
        String nombreEliminar = scanner.nextLine();

        for (int i = 0; i < listaContactos.size(); i++) {
            if (listaContactos.get(i).getNombre().equalsIgnoreCase(nombreEliminar)) {
                listaContactos.remove(i);
                System.out.println("Contacto eliminado exitosamente.");
                return;
            }
        }
        System.out.println("Contacto no encontrado.");
    }

    // Metodo para mostrar todos los contactos almacenados
    private static void mostrarContactos() {
        if (listaContactos.isEmpty()) {
            System.out.println("No hay contactos registrados.");
            return;
        }
        System.out.println("Lista de contactos:");
        for (Contacto contacto : listaContactos) {
            System.out.println(contacto);
        }

    }



}
