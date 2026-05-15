package com.juego.patrones.decorator;

import com.juego.model.IPersonaje;

public abstract class PersonajeDecorator implements IPersonaje {
    protected IPersonaje decorado;

    public PersonajeDecorator(IPersonaje decorado) {
        this.decorado = decorado;
    }

    @Override
    public void atacar(IPersonaje oponente) {
        decorado.atacar(oponente);
    }

    @Override
    public void recibirDano(int dano) {
        decorado.recibirDano(dano);
    }

    @Override
    public int getPuntosDeVida() {
        return decorado.getPuntosDeVida();
    }

    @Override
    public String getNombre() {
        return decorado.getNombre();
    }

    @Override
    public boolean estaVivo() {
        return decorado.estaVivo();
    }
}
