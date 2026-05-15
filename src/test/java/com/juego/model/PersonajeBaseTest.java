package com.juego.model;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class PersonajeBaseTest {
    
    private PersonajeBase personaje;
    
    @BeforeEach
    void setUp() {
        personaje = new PersonajeBase("Thor", 100);
    }
    
    @Test
    @DisplayName("Creación correcta del personaje")
    void testCreacion() {
        assertEquals("Thor", personaje.getNombre());
        assertEquals(100, personaje.getPuntosDeVida());
        assertTrue(personaje.estaVivo());
    }
    
    @Test
    @DisplayName("Recibir daño reduce HP correctamente")
    void testRecibirDano() {
        personaje.recibirDano(30);
        assertEquals(70, personaje.getPuntosDeVida());
    }
    
    @Test
    @DisplayName("HP no debe ser negativo")
    void testHpNoNegativo() {
        personaje.recibirDano(150);
        assertEquals(0, personaje.getPuntosDeVida());
        assertFalse(personaje.estaVivo());
    }
    
    @Test
    @DisplayName("Ataque causa daño entre 10 y 30")
    void testRangoAtaque() {
        IPersonaje oponente = new PersonajeBase("Loki", 100);
        int vidaInicial = oponente.getPuntosDeVida();
        
        personaje.atacar(oponente);
        int vidaFinal = oponente.getPuntosDeVida();
        int dano = vidaInicial - vidaFinal;
        
        assertTrue(dano >= 10 && dano <= 30, "Daño fuera de rango: " + dano);
    }
}
