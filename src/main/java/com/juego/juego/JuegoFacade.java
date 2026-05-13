package com.juego.juego;

import java.util.Scanner;

public class JuegoFacade {
    private JuegoLucha juego;

    public JuegoFacade(String nombre1, String nombre2) {
        this.juego = new JuegoLucha(nombre1, nombre2);
    }
    
    public JuegoFacade(String nombre1, String nombre2, String tipo1, String tipo2) {
        this.juego = new JuegoLucha(nombre1, nombre2, tipo1, tipo2);
    }

    public void jugar() {
        System.out.println("🎮 Iniciando el juego...");
        juego.iniciarPelea();
        System.out.println("\n🏁 Juego finalizado.");
    }
    
    // Método main con interfaz de usuario
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("╔════════════════════════════╗");
        System.out.println("║     JUEGO DE LUCHA 2026     ║");
        System.out.println("╚════════════════════════════╝\n");
        
        System.out.print("Nombre del JUGADOR 1: ");
        String nombre1 = scanner.nextLine();
        System.out.print("Tipo (guerrero/mago/arquero): ");
        String tipo1 = scanner.nextLine();
        
        System.out.print("\nNombre del JUGADOR 2: ");
        String nombre2 = scanner.nextLine();
        System.out.print("Tipo (guerrero/mago/arquero): ");
        String tipo2 = scanner.nextLine();
        
        JuegoFacade juego = new JuegoFacade(nombre1, nombre2, tipo1, tipo2);
        juego.jugar();
        
        scanner.close();
    }
}