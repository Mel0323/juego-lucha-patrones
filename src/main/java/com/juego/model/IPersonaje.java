package com.juego.model;

public interface IPersonaje {
    void atacar(IPersonaje oponente);
    void recibirDano(int dano);
    int getPuntosDeVida();
    String getNombre();
    boolean estaVivo();
}
