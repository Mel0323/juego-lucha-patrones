package com.juego.patrones.decorator;

import com.juego.model.IPersonaje;

public class BastonMagicoDecorator extends PersonajeDecorator {
    
    public BastonMagicoDecorator(IPersonaje decorado) {
        super(decorado);
    }

    @Override
    public void atacar(IPersonaje oponente) {
        super.atacar(oponente);
        int danoExtra = 15;
        System.out.println("🔮 " + decorado.getNombre() + " lanza un hechizo con su bastón mágico causando " + danoExtra + " de daño adicional!");
        oponente.recibirDano(danoExtra);
    }

    @Override
    public String getNombre() {
        return decorado.getNombre() + " [Bastón Mágico]";
    }
}
