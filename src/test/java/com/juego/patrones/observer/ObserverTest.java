package com.juego.patrones.observer;

import com.juego.model.IPersonaje;
import com.juego.model.PersonajeBase;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class ObserverTest {
    
    private PersonajeBase personaje;
    private TestObserver testObserver;
    
    static class TestObserver implements Observer {
        private String ultimoEvento;
        private IPersonaje ultimoPersonaje;
        
        @Override
        public void update(String evento, IPersonaje personaje) {
            this.ultimoEvento = evento;
            this.ultimoPersonaje = personaje;
        }
        
        public String getUltimoEvento() { return ultimoEvento; }
        public IPersonaje getUltimoPersonaje() { return ultimoPersonaje; }
    }
    
    @BeforeEach
    void setUp() {
        personaje = new PersonajeBase("Thor", 100);
        testObserver = new TestObserver();
        personaje.addObserver(testObserver);
    }
    
    @Test
    @DisplayName("Observer debe recibir notificación al recibir daño")
    void testNotificacionRecibirDano() {
        personaje.recibirDano(30);
        
        assertNotNull(testObserver.getUltimoEvento());
        assertEquals("RECIBIO_DANO", testObserver.getUltimoEvento());
        assertEquals(70, testObserver.getUltimoPersonaje().getPuntosDeVida());
    }
    
    @Test
    @DisplayName("Observer debe recibir notificación de muerte")
    void testNotificacionMuerte() {
        personaje.recibirDano(100);
        
        assertEquals("MURIO", testObserver.getUltimoEvento());
        assertFalse(testObserver.getUltimoPersonaje().estaVivo());
    }
    
    @Test
    @DisplayName("Se pueden agregar múltiples observadores")
    void testMultiplesObservadores() {
        TestObserver observer2 = new TestObserver();
        personaje.addObserver(observer2);
        personaje.recibirDano(50);
        
        assertEquals("RECIBIO_DANO", testObserver.getUltimoEvento());
        assertEquals("RECIBIO_DANO", observer2.getUltimoEvento());
    }
    
    @Test
    @DisplayName("Se puede remover un observador")
    void testRemoverObserver() {
        personaje.removeObserver(testObserver);
        personaje.recibirDano(50);
        
        assertNull(testObserver.getUltimoEvento());
    }
}
