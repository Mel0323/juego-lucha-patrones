package com.juego.juego;

import com.juego.model.IPersonaje;
import com.juego.model.PersonajeBase;
import com.juego.patrones.observer.Observer;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class JuegoLuchaMockitoTest {

    @Mock
    private IPersonaje personajeMock;

    @Mock
    private Observer observerMock;

    private PersonajeBase personajeReal;

    @BeforeEach
    void setUp() {
        personajeReal = new PersonajeBase("Thor", 100);
    }

    @Test
    @DisplayName("Mockito: Verificar que se llama al método atacar")
    void testMockAtacar() {
        // Configurar el mock
        when(personajeMock.getNombre()).thenReturn("MockHero");
        when(personajeMock.estaVivo()).thenReturn(true);

        // Verificar
        assertEquals("MockHero", personajeMock.getNombre());
        assertTrue(personajeMock.estaVivo());

        // Verificar que los métodos fueron llamados
        verify(personajeMock, atLeast(1)).getNombre();
        verify(personajeMock, times(1)).estaVivo();
    }

    @Test
    @DisplayName("Mockito: Verificar que Observer recibe notificación")
    void testObserverConMockito() {
        // Agregar mock observer
        personajeReal.addObserver(observerMock);

        // Ejecutar acción que debe notificar
        personajeReal.recibirDano(30);

        // Verificar que el observer recibió la notificación
        verify(observerMock, times(1)).update(eq("RECIBIO_DANO"), any(IPersonaje.class));
    }

    @Test
    @DisplayName("Mockito: Verificar notificación de muerte")
    void testNotificacionMuerteConMockito() {
        personajeReal.addObserver(observerMock);

        // Daño letal
        personajeReal.recibirDano(100);

        // Verificar que se notificó MURIO
        verify(observerMock, times(1)).update(eq("MURIO"), any(IPersonaje.class));
    }

    @Test
    @DisplayName("Mockito: Verificar interacción con personaje mockeado")
    void testInteraccionConMock() {
        // Crear un mock de IPersonaje (sin stubbings innecesarios)
        IPersonaje oponenteMock = mock(IPersonaje.class);
        
        // Solo configuramos lo que vamos a usar
        when(oponenteMock.getNombre()).thenReturn("VillanoMock");

        // Ejecutar acción
        personajeReal.atacar(oponenteMock);

        // Verificar que se llamó a recibirDano en el mock
        verify(oponenteMock, atLeast(1)).recibirDano(anyInt());
        // También verificamos que se llamó a getNombre al menos una vez
        verify(oponenteMock, atLeast(1)).getNombre();
    }
}
