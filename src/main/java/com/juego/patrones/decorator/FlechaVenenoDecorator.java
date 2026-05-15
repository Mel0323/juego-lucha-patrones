package com.juego.patrones.decorator;

import com.juego.model.IPersonaje;

public class FlechaVenenoDecorator extends PersonajeDecorator {
    
    public FlechaVenenoDecorator(IPersonaje decorado) {
        super(decorado);
    }

    @Override
    public void atacar(IPersonaje oponente) {
        super.atacar(oponente);
        int danoVeneno = 5;
        System.out.println("☠️ " + decorado.getNombre() + " usa una flecha envenenada causando " + danoVeneno + " de daño por veneno!");
        oponente.recibirDano(danoVeneno);
    }

    @Override
    public String getNombre() {
        return decorado.getNombre() + " [Flecha Veneno]";
    }
}
