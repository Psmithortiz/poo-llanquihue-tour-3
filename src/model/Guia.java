package model;

/**
 * Representa a un guía turístico de la agencia Llanquihue Tour.
 *
 * @author Pablo Smith
 * @version 1.0
 */
public class Guia {

    private String nombre;
    private int edad;
    private String idioma;

    /**
     * Crea un guía con su nombre, idioma y edad.
     *
     * @param nombre nombre del guía
     * @param idioma idioma o idiomas que domina
     * @param edad   edad del guía (entre 18 y 65)
     * @throws IllegalArgumentException si algún dato es inválido
     */
    public Guia(String nombre, String idioma, int edad) {
        setNombre(nombre);
        setEdad(edad);
        setIdioma(idioma);
    }

    /**
     * Obtiene el nombre del guía.
     *
     * @return nombre del guía
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del guía, validando que no sea vacío.
     *
     * @param nombre nombre del guía
     * @throws IllegalArgumentException si el nombre es nulo o vacío
     */
    public void setNombre(String nombre) {
        // El nombre no puede ir vacio
        if (nombre == null || nombre.equals("")) {
            throw new IllegalArgumentException("El nombre es obligatorio");
        }
        this.nombre = nombre;
    }

    /**
     * Obtiene la edad del guía.
     *
     * @return edad del guía
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Establece la edad del guía, validando que esté en edad laboral.
     *
     * @param edad edad del guía (entre 18 y 65)
     * @throws IllegalArgumentException si la edad está fuera de rango
     */
    public void setEdad(int edad) {
        // Solo se aceptan edades de un guia en edad laboral
        if (edad < 18 || edad > 65) {
            throw new IllegalArgumentException("Edad de guia invalida: " + getNombre());
        }
        this.edad = edad;
    }

    /**
     * Obtiene el idioma del guía.
     *
     * @return idioma o idiomas que domina
     */
    public String getIdioma() {
        return idioma;
    }

    /**
     * Establece el idioma del guía, validando que no sea vacío.
     *
     * @param idioma idioma o idiomas que domina
     * @throws IllegalArgumentException si el idioma es nulo o vacío
     */
    public void setIdioma(String idioma) {
        // El idioma no puede ir vacio
        if (idioma == null || idioma.equals("")) {
            throw new IllegalArgumentException("El idioma es obligatorio");
        }
        this.idioma = idioma;
    }

    /**
     * Retorna una representación legible del guía.
     *
     * @return cadena con nombre, idioma y edad
     */
    @Override
    public String toString() {
        return "- " + nombre + " (" + idioma + ") -> Edad: " + edad + " anos.";
    }
}
