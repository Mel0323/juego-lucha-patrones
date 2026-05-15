package com.juego.patrones.decorator;

import com.juego.model.IPersonaje;

public class EspadaDecorator extends PersonajeDecorator {
    
    public EspadaDecorator(IPersonaje decorado) {
        super(decorado);
    }

    @Override
    public void atacar(IPersonaje oponente) {
        super.atacar(oponente);
        int danoExtra = 10;
        System.out.println("✨ " + decorado.getNombre() + " usa su espada y causa " + danoExtra + " de daño adicional!");
        oponente.recibirDano(danoExtra);
    }

    @Override
    public String getNombre() {
        return decorado.getNombre() + " [Espada]";
    }
}
