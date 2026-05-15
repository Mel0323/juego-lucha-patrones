package com.juego.patrones.decorator;

import com.juego.model.IPersonaje;
import com.juego.model.PersonajeBase;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class DecoratorTest {
    
    private IPersonaje personaje;
    
    @BeforeEach
    void setUp() {
        personaje = new PersonajeBase("Thor", 100);
    }
    
    @Test
    @DisplayName("EspadaDecorator debe aumentar el daño")
    void testEspadaDecorator() {
        IPersonaje conEspada = new EspadaDecorator(personaje);
        IPersonaje oponente = new PersonajeBase("Loki", 50);
        
        int vidaInicial = oponente.getPuntosDeVida();
        conEspada.atacar(oponente);
        int vidaFinal = oponente.getPuntosDeVida();
        int danoTotal = vidaInicial - vidaFinal;
        
        assertTrue(danoTotal >= 20, "El daño con espada debería ser al menos 20, fue: " + danoTotal);
    }
    
    @Test
    @DisplayName("EscudoDecorator debe reducir el daño recibido")
    void testEscudoDecorator() {
        IPersonaje conEscudo = new EscudoDecorator(personaje);
        int vidaInicial = conEscudo.getPuntosDeVida();
        
        conEscudo.recibirDano(50);
        int vidaFinal = conEscudo.getPuntosDeVida();
        int danoRecibido = vidaInicial - vidaFinal;
        
        assertEquals(25, danoRecibido, "El escudo debería reducir el daño a la mitad");
        assertEquals(75, vidaFinal, "Thor debería quedar con 75 HP");
    }
    
    @Test
    @DisplayName("Múltiples decoradores (Espada y Escudo)")
    void testMultiplesDecoradores() {
        IPersonaje conEspadaYEscudo = new EscudoDecorator(new EspadaDecorator(personaje));
        IPersonaje oponente = new PersonajeBase("Loki", 100);
        
        assertTrue(conEspadaYEscudo.getNombre().contains("Espada"));
        assertTrue(conEspadaYEscudo.getNombre().contains("Escudo"));
        assertDoesNotThrow(() -> conEspadaYEscudo.atacar(oponente));
        
        int vidaInicial = conEspadaYEscudo.getPuntosDeVida();
        conEspadaYEscudo.recibirDano(40);
        assertEquals(vidaInicial - 20, conEspadaYEscudo.getPuntosDeVida());
    }
}
