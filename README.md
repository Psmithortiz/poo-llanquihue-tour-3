# Semana 5 · Desarrollo Orientado a Objetos I

Sistema de gestión para la agencia de turismo **Llanquihue Tour**, basado en la lectura de datos desde archivos de texto, el manejo de colecciones y la organización modular en paquetes.

## Autor del proyecto

- **Nombre completo:** Pablo Smith Ortiz
- **Carrera:** Analista Programador
- **Sede:** Campus Online

## Descripción general del sistema

Este proyecto corresponde a la Experiencia 2 de la asignatura *Desarrollo Orientado a Objetos I*. Consiste en una aplicación de consola desarrollada en **Java** que lee catálogos de tours y guías desde archivos de texto, instancia cada línea como un objeto y los almacena en colecciones dinámicas para recorrerlos, filtrarlos y validarlos.

El diseño aplica los siguientes conceptos:

- **Lectura de archivos:** la clase `GestorDatos` lee `tours.txt` y `guias.txt` línea por línea usando `BufferedReader` con *try-with-resources*.
- **Parseo de datos:** cada línea se separa con `split(";")` y se convierte al tipo correspondiente para instanciar objetos `Tour` y `Guia`.
- **Colecciones:** los datos se almacenan en `ArrayList<Tour>` y `ArrayList<Guia>` que crecen dinámicamente.
- **Composición:** la clase `Tour` contiene un objeto `Direccion`, reflejando la relación entre ambas.
- **Validación con excepciones:** los datos se validan en los setters; si una línea trae datos inválidos, se ignora mediante `try-catch` por línea sin abortar la carga del resto.
- **Recorrido y filtrado:** la clase `Main` recorre las colecciones y filtra los tours por precio y los guías por idioma.
- **Encapsulamiento:** todos los atributos son `private` y se acceden mediante getters, setters y `toString()`.
- **Separación de responsabilidades:** el código se organiza en capas (`model`, `data`, `ui`).

## Estructura del proyecto

```
src/
├── model/   # Clases de dominio: Tour, Direccion, Guia
├── data/    # Carga de datos: GestorDatos (lee los .txt y arma las listas)
└── ui/      # Clase principal: Main (recorre y filtra las colecciones)
resources/
├── tours.txt   # Datos de tours (formato: nombre;calle;numeroCalle;comuna;region;precio)
└── guias.txt   # Datos de guias (formato: nombre;idioma;edad)
```

## Instrucciones para clonar y ejecutar

1. Clona el repositorio desde GitHub:

```
git clone https://github.com/Psmithortiz/poo-llanquihue-tour-3.git
```

2. Abre el proyecto en **IntelliJ IDEA**.
3. Asegúrate de que la carpeta `resources/` con `tours.txt` y `guias.txt` esté presente en la raíz del proyecto.
4. Ejecuta el archivo `Main.java` ubicado en el paquete `ui`.
5. Revisa la salida por consola: catálogo completo de tours, tours económicos, guías disponibles y guías filtrados por idioma.

---

**Repositorio GitHub:** https://github.com/Psmithortiz/poo-llanquihue-tour-3 · **Fecha de entrega:** 22/06/2026

© Duoc UC | Escuela de Informática y Telecomunicaciones