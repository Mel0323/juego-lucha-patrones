package com.juego.patrones.decorator;

import com.juego.model.IPersonaje;

public class EscudoDecorator extends PersonajeDecorator {
    
    public EscudoDecorator(IPersonaje decorado) {
        super(decorado);
    }

    @Override
    public void recibirDano(int dano) {
        int danoReducido = dano / 2;
        System.out.println("🛡️ " + decorado.getNombre() + " bloquea con su escudo! Daño reducido de " + dano + " a " + danoReducido);
        super.recibirDano(danoReducido);
    }

    @Override
    public String getNombre() {
        return decorado.getNombre() + " [Escudo]";
    }
}
