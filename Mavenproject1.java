package com.mycompany.mavenproject1;

import java.util.*;     
public class Mavenproject1 {
    public static void main(String[] args) {
        Scanner scanner = Scanner (System.in);
        public static List<Comida> comidas = new ArrayList<>();
        
        while (true) {
            System.out.println("====================");
            System.out.println("Bienvenido al Restaurante Brasas");
            System.out.println("1.Consultar Platillos");
            System.out.println("2.Realizar Pedido");
            System.out.println("3.Cancelar Pedido");
            System.out.println("4.Salir");
            System.out.println("5.Administrador");
            System.out.println("Elige una opcion: ");
        
            int opcion = scanner.nextInt();
        
            switch (opcion) {
                case 1: 
                    ConsultarPedidos(scanner);
                    break;
                case 2:
                    RealizarPedido (scanner);
                    break;
                case 3:
                    CancelarPedido (scanner);
                    break;
                case 4:
                    System.out.println("Finalizando programa");
                    return; 
                case 5:
                    Administrador (scanner);
                    return; 
                default:
                    System.out.println("Opcion no valida");
                    break; 
            }
        }
    }
    
    public static void ConsultarPedidos (Scanner scanner) {
        while (true) {
            System.out.println("====================");
            System.out.println("1. Ver Menu Disponible");
            System.out.println("2. Atras");
            
            int opcion_consulta = scanner.nextInt();
            
            switch (opcion_consulta) {
                case 1:
                    listcomida();
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
    
    public static void RealizarPedido (Scanner scanner) {
        while (true) {
            System.out.println("====================");
            System.out.println("1. Realizar compra");
            System.out.println("2. Atras");
            
            int opcion_pedido = scanner.nextInt();
            
            switch (opcion_pedido) {
                case 1:
                    System.out.println("Escribe tu nombre completo: ");
                    String nombre = scanner.nextLine();
                    break;
            }
        }
    }
    
    public static void CancelarPedido (Scanner scanner) {
        while (true) {
            System.out.println("====================");
            System.out.println("1. Revisar pedido por nombre de usuario");
            System.out.println("2. Atras");
            
            int opcion_cancelar = scanner.nextInt();
            
            switch (opcion_cancelar) {
                case 1: 
                    System.out.println("Escribe el nombre de la persona que ordeno el pedido: ");
                    String nombre = scanner.nextLine();
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
    
    public static void Administrador (Scanner scanner) { // El usuario del Administrador es STEVE
        System.out.print("Ingrese el nombre del administrador: ");
        String nombre_administrador = scanner.nextLine();
        if (!nombreAdministrador.equalsIgnoreCase("STEVE")) {
            System.out.println("Cuenta no registrada como Administrador.");
            return;
        }
        System.out.print("Ingrese el nombre del platillo: ");
        String comida = scanner.nextLine();
        System.out.print("Ingrese el valor del platillo: ");
        double valor = scanner.nextDouble();
        
        Comida nuevaComida = new Comida(nombre, valor);
        Menu.agregarComida(nuevaComida);
        System.out.println("Platillo registrado exitosamente.");
    }
    
    
    public static void listcomida () {
        if (comida.isEmpty()) {
            System.out.println("No hay platillos disponible por el momento")
            return;
        }
        System.out.println("Lista de platillos:");
        for (Comida comida : comidas) {
            System.out.println(comida);
        }       
    }
}
