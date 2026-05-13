package com.juego.patrones.strategy;

import java.util.Random;

public class AtaqueRapido implements AtaqueStrategy {
    private Random rand = new Random();
    private boolean dobleGolpe = false;
    @Override
    public int calcularDano() {
        dobleGolpe = rand.nextBoolean();
        int dano = rand.nextInt(16) + 5;
        return dobleGolpe ? dano * 2 : dano;
    }
    @Override
    public String getDescripcion() {
        return dobleGolpe ? "⚡⚡ ataque rápido con doble golpe" : "⚡ ataque rápido";
    }
}
