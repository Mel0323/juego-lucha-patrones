# Juego de Lucha con Patrones de Diseño

[![Java CI with Maven](https://github.com/Mel0323/juego-lucha-patrones/actions/workflows/ci.yml/badge.svg)](https://github.com/Mel0323/juego-lucha-patrones/actions/workflows/ci.yml)
## Patrones Implementados
- **Factory Method** (creacional)
- **Strategy** (comportamiento)
- **Facade** (estructural)

## Cómo ejecutar
```bash
mvn clean compile
mvn exec:java -Dexec.mainClass="com.juego.juego.JuegoFacade"
mvn test
mvn jacoco:report