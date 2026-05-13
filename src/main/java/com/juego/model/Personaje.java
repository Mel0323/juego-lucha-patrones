package com.juego.model;

import com.juego.patrones.strategy.AtaqueStrategy;
import com.juego.patrones.strategy.AtaqueNormal;

public class Personaje {
    private String nombre;
    private int puntosDeVida;
    private int puntosDeVidaMaximos;
    private AtaqueStrategy estrategiaAtaque;

    // Constructor original (compatibilidad)
    public Personaje(String nombre) {
        this(nombre, 100);
    }
    
    // Constructor con vida personalizada
    public Personaje(String nombre, int puntosDeVida) {
        this.nombre = nombre;
        this.puntosDeVida = puntosDeVida;
        this.puntosDeVidaMaximos = puntosDeVida;
        this.estrategiaAtaque = new AtaqueNormal(); // estrategia por defecto
    }

    public void setEstrategiaAtaque(AtaqueStrategy estrategia) {
        this.estrategiaAtaque = estrategia;
    }

    public void atacar(Personaje oponente) {
        int dano = this.estrategiaAtaque.calcularDano();
        oponente.recibirDano(dano);
        System.out.println(this.nombre + " realiza " + this.estrategiaAtaque.getDescripcion() +
                           " causando " + dano + " de daño a " + oponente.getNombre());
    }

    public void recibirDano(int dano) {
        this.puntosDeVida -= dano;
        if (this.puntosDeVida < 0) this.puntosDeVida = 0;
    }

    public boolean estaVivo() {
        return this.puntosDeVida > 0;
    }

    public void curar(int cantidad) {
        this.puntosDeVida += cantidad;
        if (this.puntosDeVida > puntosDeVidaMaximos) this.puntosDeVida = puntosDeVidaMaximos;
    }

    // Getters
    public String getNombre() { return nombre; }
    public int getPuntosDeVida() { return puntosDeVida; }
    public int getPuntosDeVidaMaximos() { return puntosDeVidaMaximos; }
}