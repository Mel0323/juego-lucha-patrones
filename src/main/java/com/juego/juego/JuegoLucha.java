package com.juego.juego;

import com.juego.model.IPersonaje;
import com.juego.patrones.decorator.*;
import com.juego.patrones.factory.PersonajeFactory;
import com.juego.patrones.factory.PersonajeFactorySelector;
import com.juego.patrones.observer.Observer;
import com.juego.patrones.observer.Subject;

public class JuegoLucha implements Observer {
    private IPersonaje jugador1;
    private IPersonaje jugador2;
    private boolean juegoTerminado = false;

    // Constructor con todos los decoradores posibles
    public JuegoLucha(String nombre1, String nombre2, String tipo1, String tipo2,
                      boolean espada1, boolean espada2, boolean escudo1, boolean escudo2,
                      boolean arco1, boolean arco2, boolean flechaVeneno1, boolean flechaVeneno2,
                      boolean baston1, boolean baston2, boolean amuleto1, boolean amuleto2) {
        
        PersonajeFactory factory1 = PersonajeFactorySelector.getFactory(tipo1);
        PersonajeFactory factory2 = PersonajeFactorySelector.getFactory(tipo2);
        
        IPersonaje p1 = factory1.crearPersonaje(nombre1);
        IPersonaje p2 = factory2.crearPersonaje(nombre2);
        
        // Aplicar decoradores a Jugador 1 según su tipo
        if (tipo1.equals("guerrero")) {
            if (espada1) p1 = new EspadaDecorator(p1);
            if (escudo1) p1 = new EscudoDecorator(p1);
        } else if (tipo1.equals("arquero")) {
            if (arco1) p1 = new ArcoDecorator(p1);
            if (flechaVeneno1) p1 = new FlechaVenenoDecorator(p1);
        } else if (tipo1.equals("mago")) {
            if (baston1) p1 = new BastonMagicoDecorator(p1);
            if (amuleto1) p1 = new AmuletoDecorator(p1);
        } else {
            if (espada1) p1 = new EspadaDecorator(p1);
            if (escudo1) p1 = new EscudoDecorator(p1);
        }
        
        // Aplicar decoradores a Jugador 2 según su tipo
        if (tipo2.equals("guerrero")) {
            if (espada2) p2 = new EspadaDecorator(p2);
            if (escudo2) p2 = new EscudoDecorator(p2);
        } else if (tipo2.equals("arquero")) {
            if (arco2) p2 = new ArcoDecorator(p2);
            if (flechaVeneno2) p2 = new FlechaVenenoDecorator(p2);
        } else if (tipo2.equals("mago")) {
            if (baston2) p2 = new BastonMagicoDecorator(p2);
            if (amuleto2) p2 = new AmuletoDecorator(p2);
        } else {
            if (espada2) p2 = new EspadaDecorator(p2);
            if (escudo2) p2 = new EscudoDecorator(p2);
        }
        
        this.jugador1 = p1;
        this.jugador2 = p2;
        
        // Registrar observadores
        if (this.jugador1 instanceof Subject) {
            ((Subject) this.jugador1).addObserver(this);
        }
        if (this.jugador2 instanceof Subject) {
            ((Subject) this.jugador2).addObserver(this);
        }
        
        System.out.println("\n⚔️ PERSONAJES CREADOS ⚔️");
        System.out.println(p1.getNombre() + " [" + tipo1.toUpperCase() + "] - " + p1.getPuntosDeVida() + " HP");
        System.out.println(p2.getNombre() + " [" + tipo2.toUpperCase() + "] - " + p2.getPuntosDeVida() + " HP\n");
    }

    public void iniciarPelea() {
        System.out.println("🏆 ¡LA PELEA COMIENZA! 🏆\n");

        int turno = 1;
        while (!juegoTerminado && jugador1.estaVivo() && jugador2.estaVivo()) {
            System.out.println("--- TURNO " + turno + " ---");
            realizarTurno(jugador1, jugador2);
            if (!juegoTerminado && jugador2.estaVivo()) {
                realizarTurno(jugador2, jugador1);
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

    private void realizarTurno(IPersonaje atacante, IPersonaje defensor) {
        System.out.println("Turno de " + atacante.getNombre() + " [HP: " + atacante.getPuntosDeVida() + "]");
        atacante.atacar(defensor);
    }

    @Override
    public void update(String evento, IPersonaje personaje) {
        if (evento.equals("MURIO")) {
            System.out.println("💀 ¡" + personaje.getNombre() + " ha sido derrotado! 💀");
            juegoTerminado = true;
        }
    }
}
