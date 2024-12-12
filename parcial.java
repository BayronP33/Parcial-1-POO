import java.util.*;

public class Main {
    public static List<Comida> comidas = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("====================");
            System.out.println("Bienvenido al Restaurante Brasas");
            System.out.println("1. Consultar Platillos");
            System.out.println("2. Realizar Pedido");
            System.out.println("3. Cancelar Pedido");
            System.out.println("4. Salir");
            System.out.println("5. Administrador");
            System.out.println("Elige una opcion: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    ConsultarPedidos(scanner);
                    break;
                case 2:
                    RealizarPedido(scanner);
                    break;
                case 3:
                    CancelarPedido(scanner);
                    break;
                case 4:
                    System.out.println("Finalizando programa");
                    return;
                case 5:
                    Administrador(scanner);
                    break;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }
    }

    public static void ConsultarPedidos(Scanner scanner) {
        while (true) {
            System.out.println("====================");
            System.out.println("1. Ver Menu Disponible");
            System.out.println("2. Atras");

            int opcionConsulta = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcionConsulta) {
                case 1:
                    listarComidas();
                    break;
                case 2:
                    System.out.println("Regresando a menu principal");
                    return;
                default:
                    System.out.println("Opcion no valida");
                    break;
            }
        }
    }

    public static void RealizarPedido(Scanner scanner) {
        System.out.println("====================");
        System.out.println("Realizar compra");
        System.out.println("Escribe tu nombre completo: ");
        String nombre = scanner.nextLine();

        System.out.println("Escribe el nombre del platillo que deseas: ");
        String platillo = scanner.nextLine();

        boolean encontrado = false;
        for (Comida comida : comidas) {
            if (comida.getNombre().equalsIgnoreCase(platillo)) {
                encontrado = true;
                System.out.println("Pedido realizado por " + nombre + " de " + platillo);
                break;
            }
        }

        if (!encontrado) {
            System.out.println("Platillo no encontrado en el menu.");
        }
    }

    public static void CancelarPedido(Scanner scanner) {
        System.out.println("====================");
        System.out.println("Escribe el nombre de la persona que ordeno el pedido: ");
        String nombre = scanner.nextLine();

        System.out.println("Cancelando pedido para: " + nombre);
        // Aquí puedes implementar lógica adicional para gestionar los pedidos si lo deseas.
    }

    public static void Administrador(Scanner scanner) {
        System.out.println("====================");
        System.out.print("Ingrese el nombre del administrador: ");
        String nombreAdministrador = scanner.nextLine();

        if (!nombreAdministrador.equalsIgnoreCase("STEVE")) {
            System.out.println("Cuenta no registrada como Administrador.");
            return;
        }

        System.out.print("Ingrese el nombre del platillo: ");
        String nombrePlatillo = scanner.nextLine();

        System.out.print("Ingrese el valor del platillo: ");
        double valorPlatillo = scanner.nextDouble();
        scanner.nextLine(); // Consumir el salto de línea

        Comida nuevaComida = new Comida(nombrePlatillo, valorPlatillo);
        comidas.add(nuevaComida);
        System.out.println("Platillo registrado exitosamente.");
    }

    public static void listarComidas() {
        if (comidas.isEmpty()) {
            System.out.println("No hay platillos disponibles por el momento.");
            return;
        }

        System.out.println("Lista de platillos:");
        for (Comida comida : comidas) {
            System.out.println(comida);
        }
    }
}

class Comida {
    private String nombre;
    private double precio;

    public Comida(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    @Override
    public String toString() {
        return nombre + " - $" + precio;
    }
}
