package com.juego.patrones.factory;

public class PersonajeFactorySelector {
    public static PersonajeFactory getFactory(String tipo) {
        switch (tipo.toLowerCase()) {
            case "guerrero": return new GuerreroFactory();
            case "mago": return new MagoFactory();
            case "arquero": return new ArqueroFactory();
            default: return new NormalFactory();
        }
    }
}
