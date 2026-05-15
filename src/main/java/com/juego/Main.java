package com.juego;

import com.juego.juego.JuegoLucha;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║     JUEGO DE LUCHA - DECORADORES AVANZADOS      ║");
        System.out.println("╚════════════════════════════════════════════════╝\n");
        
        // Jugador 1
        System.out.println("=== JUGADOR 1 ===");
        System.out.print("Nombre: ");
        String nombre1 = scanner.nextLine();
        System.out.print("Tipo (guerrero/mago/arquero/normal): ");
        String tipo1 = scanner.nextLine().toLowerCase();
        
        boolean espada1 = false, escudo1 = false;
        boolean arco1 = false, flechaVeneno1 = false;
        boolean baston1 = false, amuleto1 = false;
        
        switch (tipo1) {
            case "guerrero":
                System.out.print("¿Espada para " + nombre1 + "? (s/n): ");
                espada1 = scanner.nextLine().equalsIgnoreCase("s");
                System.out.print("¿Escudo para " + nombre1 + "? (s/n): ");
                escudo1 = scanner.nextLine().equalsIgnoreCase("s");
                break;
            case "arquero":
                System.out.print("¿Arco para " + nombre1 + "? (s/n): ");
                arco1 = scanner.nextLine().equalsIgnoreCase("s");
                System.out.print("¿Flechas envenenadas para " + nombre1 + "? (s/n): ");
                flechaVeneno1 = scanner.nextLine().equalsIgnoreCase("s");
                break;
            case "mago":
                System.out.print("¿Bastón mágico para " + nombre1 + "? (s/n): ");
                baston1 = scanner.nextLine().equalsIgnoreCase("s");
                System.out.print("¿Amuleto protector para " + nombre1 + "? (s/n): ");
                amuleto1 = scanner.nextLine().equalsIgnoreCase("s");
                break;
            default:
                System.out.print("¿Espada para " + nombre1 + "? (s/n): ");
                espada1 = scanner.nextLine().equalsIgnoreCase("s");
                System.out.print("¿Escudo para " + nombre1 + "? (s/n): ");
                escudo1 = scanner.nextLine().equalsIgnoreCase("s");
        }
        
        // Jugador 2
        System.out.println("\n=== JUGADOR 2 ===");
        System.out.print("Nombre: ");
        String nombre2 = scanner.nextLine();
        System.out.print("Tipo (guerrero/mago/arquero/normal): ");
        String tipo2 = scanner.nextLine().toLowerCase();
        
        boolean espada2 = false, escudo2 = false;
        boolean arco2 = false, flechaVeneno2 = false;
        boolean baston2 = false, amuleto2 = false;
        
        switch (tipo2) {
            case "guerrero":
                System.out.print("¿Espada para " + nombre2 + "? (s/n): ");
                espada2 = scanner.nextLine().equalsIgnoreCase("s");
                System.out.print("¿Escudo para " + nombre2 + "? (s/n): ");
                escudo2 = scanner.nextLine().equalsIgnoreCase("s");
                break;
            case "arquero":
                System.out.print("¿Arco para " + nombre2 + "? (s/n): ");
                arco2 = scanner.nextLine().equalsIgnoreCase("s");
                System.out.print("¿Flechas envenenadas para " + nombre2 + "? (s/n): ");
                flechaVeneno2 = scanner.nextLine().equalsIgnoreCase("s");
                break;
            case "mago":
                System.out.print("¿Bastón mágico para " + nombre2 + "? (s/n): ");
                baston2 = scanner.nextLine().equalsIgnoreCase("s");
                System.out.print("¿Amuleto protector para " + nombre2 + "? (s/n): ");
                amuleto2 = scanner.nextLine().equalsIgnoreCase("s");
                break;
            default:
                System.out.print("¿Espada para " + nombre2 + "? (s/n): ");
                espada2 = scanner.nextLine().equalsIgnoreCase("s");
                System.out.print("¿Escudo para " + nombre2 + "? (s/n): ");
                escudo2 = scanner.nextLine().equalsIgnoreCase("s");
        }
        
        // Crear juego con todos los decoradores
        JuegoLucha juego = new JuegoLucha(nombre1, nombre2, tipo1, tipo2, 
                                          espada1, espada2, escudo1, escudo2,
                                          arco1, arco2, flechaVeneno1, flechaVeneno2,
                                          baston1, baston2, amuleto1, amuleto2);
        juego.iniciarPelea();
        
        scanner.close();
    }
}
