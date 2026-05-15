package com.juego.patrones.observer;

import com.juego.model.IPersonaje;

public interface Observer {
    void update(String evento, IPersonaje personaje);
}
