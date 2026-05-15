package com.juego.patrones.factory;

import com.juego.model.IPersonaje;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class FactoryTest {
    
    @Test
    @DisplayName("GuerreroFactory crea personaje con 130 HP")
    void testGuerreroFactory() {
        PersonajeFactory factory = new GuerreroFactory();
        IPersonaje guerrero = factory.crearPersonaje("Thor");
        
        assertEquals("Thor", guerrero.getNombre());
        assertEquals(130, guerrero.getPuntosDeVida());
    }
    
    @Test
    @DisplayName("MagoFactory crea personaje con 80 HP")
    void testMagoFactory() {
        PersonajeFactory factory = new MagoFactory();
        IPersonaje mago = factory.crearPersonaje("Merlin");
        
        assertEquals("Merlin", mago.getNombre());
        assertEquals(80, mago.getPuntosDeVida());
    }
    
    @Test
    @DisplayName("ArqueroFactory crea personaje con 100 HP")
    void testArqueroFactory() {
        PersonajeFactory factory = new ArqueroFactory();
        IPersonaje arquero = factory.crearPersonaje("Legolas");
        
        assertEquals("Legolas", arquero.getNombre());
        assertEquals(100, arquero.getPuntosDeVida());
    }
    
    @Test
    @DisplayName("Selector retorna la fábrica correcta")
    void testFactorySelector() {
        assertTrue(PersonajeFactorySelector.getFactory("guerrero") instanceof GuerreroFactory);
        assertTrue(PersonajeFactorySelector.getFactory("mago") instanceof MagoFactory);
        assertTrue(PersonajeFactorySelector.getFactory("arquero") instanceof ArqueroFactory);
        assertTrue(PersonajeFactorySelector.getFactory("normal") instanceof NormalFactory);
    }
}
