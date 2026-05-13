package com.juego.juego;

import com.juego.model.Personaje;
import com.juego.patrones.factory.PersonajeFactory;
import com.juego.patrones.factory.PersonajeFactorySelector;

public class JuegoLucha {
    private Personaje jugador1;
    private Personaje jugador2;

    // Constructor original (compatibilidad)
    public JuegoLucha(String nombre1, String nombre2) {
        this(nombre1, nombre2, "normal", "normal");
    }
    
    // Constructor con tipos de personaje
    public JuegoLucha(String nombre1, String nombre2, String tipo1, String tipo2) {
        PersonajeFactory factory1 = PersonajeFactorySelector.getFactory(tipo1);
        PersonajeFactory factory2 = PersonajeFactorySelector.getFactory(tipo2);
        
        this.jugador1 = factory1.crearPersonaje(nombre1);
        this.jugador2 = factory2.crearPersonaje(nombre2);
        
        System.out.println("\n⚔️ PERSONAJES CREADOS ⚔️");
        System.out.println(jugador1.getNombre() + " [" + tipo1.toUpperCase() + "] - " + jugador1.getPuntosDeVida() + " HP");
        System.out.println(jugador2.getNombre() + " [" + tipo2.toUpperCase() + "] - " + jugador2.getPuntosDeVida() + " HP\n");
    }

    public void iniciarPelea() {
        System.out.println("🏆 ¡LA PELEA COMIENZA! 🏆\n");

        int turno = 1;
        while (jugador1.estaVivo() && jugador2.estaVivo()) {
            System.out.println("--- TURNO " + turno + " ---");
            turno(jugador1, jugador2);
            if (jugador2.estaVivo()) {
                turno(jugador2, jugador1);
            }
            turno++;
            System.out.println();
        }

        System.out.println("🎉 ¡FIN DE LA PELEA! 🎉");
        if (jugador1.estaVivo()) {
            System.out.println("👑 " + jugador1.getNombre() + " es el CAMPEÓN con " + jugador1.getPuntosDeVida() + " HP restantes.");
        } else {
            System.out.println("👑 " + jugador2.getNombre() + " es el CAMPEÓN con " + jugador2.getPuntosDeVida() + " HP restantes.");
        }
    }

    private void turno(Personaje atacante, Personaje defensor) {
        System.out.println("Turno de " + atacante.getNombre() + " [HP: " + atacante.getPuntosDeVida() + "]");
        atacante.atacar(defensor);
        System.out.println(defensor.getNombre() + " ahora tiene " + defensor.getPuntosDeVida() + " HP");
    }
    
    // Getters para pruebas
    public Personaje getJugador1() { return jugador1; }
    public Personaje getJugador2() { return jugador2; }
}