package com.juego.patrones.strategy;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class AtaqueStrategyTest {
    
    @Test
    @DisplayName("Ataque Normal: daño entre 10 y 30")
    void testAtaqueNormal() {
        AtaqueStrategy estrategia = new AtaqueNormal();
        for (int i = 0; i < 50; i++) {
            int dano = estrategia.calcularDano();
            assertTrue(dano >= 10 && dano <= 30, "Daño fuera de rango: " + dano);
        }
    }
    
    @Test
    @DisplayName("Ataque Fuerte: daño entre 25 y 45")
    void testAtaqueFuerte() {
        AtaqueStrategy estrategia = new AtaqueFuerte();
        for (int i = 0; i < 50; i++) {
            int dano = estrategia.calcularDano();
            assertTrue(dano >= 25 && dano <= 45, "Daño fuera de rango: " + dano);
        }
    }
    
    @Test
    @DisplayName("Ataque Rápido: daño entre 5 y 40")
    void testAtaqueRapido() {
        AtaqueStrategy estrategia = new AtaqueRapido();
        for (int i = 0; i < 50; i++) {
            int dano = estrategia.calcularDano();
            assertTrue(dano >= 5 && dano <= 40, "Daño fuera de rango: " + dano);
        }
    }
    
    @Test
    @DisplayName("Todas las estrategias tienen descripción")
    void testDescripciones() {
        assertNotNull(new AtaqueNormal().getDescripcion());
        assertNotNull(new AtaqueFuerte().getDescripcion());
        assertNotNull(new AtaqueRapido().getDescripcion());
    }
}
