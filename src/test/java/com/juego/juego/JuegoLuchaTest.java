package com.juego.juego;

import com.juego.model.Personaje;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class JuegoLuchaTest {
    
    @Mock
    private Personaje personajeMock;
    
    private JuegoLucha juegoLucha;
    
    @BeforeEach
    void setUp() {
        juegoLucha = new JuegoLucha("Héroe", "Villano");
    }
    
    @Test
    @DisplayName("Creación correcta del juego")
    void testCreacionJuego() {
        assertNotNull(juegoLucha.getJugador1());
        assertNotNull(juegoLucha.getJugador2());
        assertEquals("Héroe", juegoLucha.getJugador1().getNombre());
        assertEquals("Villano", juegoLucha.getJugador2().getNombre());
    }
    
    @Test
    @DisplayName("Juego termina cuando un personaje muere")
    void testPeleaTermina() {
        juegoLucha.getJugador2().recibirDano(150);
        assertFalse(juegoLucha.getJugador2().estaVivo());
        assertDoesNotThrow(() -> juegoLucha.iniciarPelea());
    }
    
    @Test
    @DisplayName("Uso de Mockito - verificar interacciones")
    void testMockInteractions() {
        when(personajeMock.getNombre()).thenReturn("MockHero");
        when(personajeMock.estaVivo()).thenReturn(true, false);
        
        assertEquals("MockHero", personajeMock.getNombre());
        assertTrue(personajeMock.estaVivo());
        assertFalse(personajeMock.estaVivo());
        
        verify(personajeMock, atLeast(1)).getNombre();
        verify(personajeMock, times(2)).estaVivo();
    }
}
