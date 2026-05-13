package com.juego.patrones.factory;

import com.juego.model.Personaje;
import com.juego.patrones.strategy.AtaqueNormal;
import com.juego.patrones.strategy.AtaqueFuerte;
import com.juego.patrones.strategy.AtaqueRapido;

public class PersonajeFactorySelector {
    public static PersonajeFactory getFactory(String tipo) {
        switch (tipo.toLowerCase()) {
            case "guerrero": return new GuerreroFactory();
            case "mago": return new MagoFactory();
            case "arquero": return new ArqueroFactory();
            default: return new GuerreroFactory();
        }
    }
}
