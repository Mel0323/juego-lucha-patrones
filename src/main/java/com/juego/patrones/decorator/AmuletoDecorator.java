package com.juego.patrones.decorator;

import com.juego.model.IPersonaje;

public class AmuletoDecorator extends PersonajeDecorator {
    
    public AmuletoDecorator(IPersonaje decorado) {
        super(decorado);
    }

    @Override
    public void recibirDano(int dano) {
        int danoReducido = dano - 5;
        if (danoReducido < 0) danoReducido = 0;
        System.out.println("🔮 " + decorado.getNombre() + " su amuleto mágico reduce el daño de " + dano + " a " + danoReducido);
        super.recibirDano(danoReducido);
    }

    @Override
    public String getNombre() {
        return decorado.getNombre() + " [Amuleto]";
    }
}
