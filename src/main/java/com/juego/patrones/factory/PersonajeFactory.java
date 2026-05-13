package com.juego.patrones.factory;

import com.juego.model.Personaje;
import com.juego.patrones.strategy.AtaqueNormal;
import com.juego.patrones.strategy.AtaqueFuerte;
import com.juego.patrones.strategy.AtaqueRapido;

public abstract class PersonajeFactory {
    public abstract Personaje crearPersonaje(String nombre);
}

class GuerreroFactory extends PersonajeFactory {
    @Override
    public Personaje crearPersonaje(String nombre) {
        Personaje p = new Personaje(nombre, 130);
        p.setEstrategiaAtaque(new AtaqueNormal());
        return p;
    }
}

class MagoFactory extends PersonajeFactory {
    @Override
    public Personaje crearPersonaje(String nombre) {
        Personaje p = new Personaje(nombre, 80);
        p.setEstrategiaAtaque(new AtaqueFuerte());
        return p;
    }
}

class ArqueroFactory extends PersonajeFactory {
    @Override
    public Personaje crearPersonaje(String nombre) {
        Personaje p = new Personaje(nombre, 100);
        p.setEstrategiaAtaque(new AtaqueRapido());
        return p;
    }
}
