package com.juego.model;

import com.juego.patrones.strategy.AtaqueFuerte;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class PersonajeTest {
    
    private Personaje guerrero;
    private Personaje oponente;
    
    @BeforeEach
    void setUp() {
        guerrero = new Personaje("Thor", 100);
        oponente = new Personaje("Loki", 100);
    }
    
    @Test
    @DisplayName("Creación correcta del personaje")
    void testCreacionPersonaje() {
        assertEquals("Thor", guerrero.getNombre());
        assertEquals(100, guerrero.getPuntosDeVida());
        assertTrue(guerrero.estaVivo());
    }
    
    @Test
    @DisplayName("Reducción de HP al recibir daño")
    void testRecibirDano() {
        guerrero.recibirDano(30);
        assertEquals(70, guerrero.getPuntosDeVida());
    }
    
    @Test
    @DisplayName("HP no debe ser negativo")
    void testHpNoNegativo() {
        guerrero.recibirDano(150);
        assertEquals(0, guerrero.getPuntosDeVida());
        assertFalse(guerrero.estaVivo());
    }
    
    @Test
    @DisplayName("Cambio de estrategia de ataque")
    void testCambiarEstrategia() {
        assertDoesNotThrow(() -> guerrero.setEstrategiaAtaque(new AtaqueFuerte()));
        assertDoesNotThrow(() -> guerrero.atacar(oponente));
    }
    
    @Test
    @DisplayName("Curación de personaje")
    void testCurar() {
        guerrero.recibirDano(50);
        assertEquals(50, guerrero.getPuntosDeVida());
        guerrero.curar(30);
        assertEquals(80, guerrero.getPuntosDeVida());
    }
    
    @Test
    @DisplayName("No curar por encima del máximo")
    void testCurarNoExcedeMaximo() {
        guerrero.curar(50);
        assertEquals(100, guerrero.getPuntosDeVida());
    }
}
