package com.juego.model;

import com.juego.patrones.observer.Observer;
import com.juego.patrones.observer.Subject;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PersonajeBase implements IPersonaje, Subject {
    private String nombre;
    private int puntosDeVida;
    private int puntosDeVidaMaximos;
    private List<Observer> observadores = new ArrayList<>();
    private Random rand = new Random();

    public PersonajeBase(String nombre, int puntosDeVida) {
        this.nombre = nombre;
        this.puntosDeVida = puntosDeVida;
        this.puntosDeVidaMaximos = puntosDeVida;
    }

    public PersonajeBase(String nombre) {
        this(nombre, 100);
    }

    @Override
    public void atacar(IPersonaje oponente) {
        int dano = rand.nextInt(21) + 10; // 10-30
        System.out.println(this.nombre + " ataca causando " + dano + " de daño a " + oponente.getNombre());
        oponente.recibirDano(dano);
    }

    @Override
    public void recibirDano(int dano) {
        this.puntosDeVida -= dano;
        if (this.puntosDeVida < 0) {
            this.puntosDeVida = 0;
        }
        System.out.println(this.nombre + " ahora tiene " + this.puntosDeVida + " HP");
        
        if (this.puntosDeVida == 0) {
            notifyObservers("MURIO");
        } else {
            notifyObservers("RECIBIO_DANO");
        }
    }

    @Override
    public boolean estaVivo() {
        return this.puntosDeVida > 0;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    @Override
    public int getPuntosDeVida() {
        return this.puntosDeVida;
    }

    public int getPuntosDeVidaMaximos() {
        return puntosDeVidaMaximos;
    }

    // Métodos de Subject
    @Override
    public void addObserver(Observer o) {
        observadores.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observadores.remove(o);
    }

    @Override
    public void notifyObservers(String evento) {
        for (Observer o : observadores) {
            o.update(evento, this);
        }
    }
}
