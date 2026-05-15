package com.juego.patrones.decorator;

import com.juego.model.IPersonaje;

public class ArcoDecorator extends PersonajeDecorator {
    
    public ArcoDecorator(IPersonaje decorado) {
        super(decorado);
    }

    @Override
    public void atacar(IPersonaje oponente) {
        super.atacar(oponente);
        int danoExtra = 12;
        System.out.println("🏹 " + decorado.getNombre() + " dispara una flecha con su arco causando " + danoExtra + " de daño adicional!");
        oponente.recibirDano(danoExtra);
    }

    @Override
    public String getNombre() {
        return decorado.getNombre() + " [Arco]";
    }
}
