cat > README.md << 'EOF'
# Juego de Lucha con Patrones de Diseño

[![Java CI with Maven](https://github.com/Mel0323/juego-lucha-patrones/actions/workflows/ci.yml/badge.svg)](https://github.com/Mel0323/juego-lucha-patrones/actions/workflows/ci.yml)

## Descripción

Juego de lucha por turnos desarrollado en Java que implementa tres patrones de diseño:

- **Factory Method** (creacional) → Creación de diferentes tipos de personajes
- **Decorator** (estructural) → Agregar armas y habilidades dinámicamente
- **Observer** (comportamiento) → Notificación de eventos (daño, muerte)

##  Patrones Implementados

| Patrón | Categoría | Ubicación | Descripción |
|--------|-----------|-----------|-------------|
| **Factory Method** | Creacional | `com.juego.patrones.factory` | Crea personajes: Guerrero (130 HP), Mago (80 HP), Arquero (100 HP) |
| **Decorator** | Estructural | `com.juego.patrones.decorator` | Agrega armas/habilidades: Espada, Escudo, Arco, Flecha Veneno, Bastón Mágico, Amuleto |
| **Observer** | Comportamiento | `com.juego.patrones.observer` | Notifica eventos: recibir daño, muerte |

##  Tipos de Personaje y Decoradores

| Personaje | HP | Decoradores disponibles |
|-----------|-----|------------------------|
|  Guerrero | 130 | Espada (+10 daño), Escudo (reduce daño 50%) |
| Arquero | 100 | Arco (+12 daño), Flecha Veneno (+5 daño por veneno) |
| Mago | 80 | Bastón Mágico (+15 daño), Amuleto (protección -5 daño) |
| Normal | 100 | Espada, Escudo |

##  Cómo Ejecutar

### Compilar el proyecto
```bash
mvn clean compile