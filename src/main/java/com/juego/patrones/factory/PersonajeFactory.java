package com.juego.patrones.factory;

import com.juego.model.IPersonaje;
import com.juego.model.PersonajeBase;

public abstract class PersonajeFactory {
    public abstract IPersonaje crearPersonaje(String nombre);
}

class GuerreroFactory extends PersonajeFactory {
    @Override
    public IPersonaje crearPersonaje(String nombre) {
        return new PersonajeBase(nombre, 130);
    }
}

class MagoFactory extends PersonajeFactory {
    @Override
    public IPersonaje crearPersonaje(String nombre) {
        return new PersonajeBase(nombre, 80);
    }
}

class ArqueroFactory extends PersonajeFactory {
    @Override
    public IPersonaje crearPersonaje(String nombre) {
        return new PersonajeBase(nombre, 100);
    }
}

class NormalFactory extends PersonajeFactory {
    @Override
    public IPersonaje crearPersonaje(String nombre) {
        return new PersonajeBase(nombre, 100);
    }
}
