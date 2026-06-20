package model;

/**
 * Representa un tour ofrecido por la agencia Llanquihue Tour.
 * Mantiene una relación de composición con {@link Direccion}.
 *
 * @author Pablo Smith
 * @version 1.0
 */
public class Tour {

    private String nombre;
    private Direccion direccion;
    private int precioPorPersona;

    /**
     * Crea un tour con su nombre, dirección y precio por persona.
     *
     * @param nombre           nombre del tour
     * @param direccion        dirección donde se realiza el tour
     * @param precioPorPersona precio por persona, en pesos chilenos
     */
    public Tour(String nombre, Direccion direccion, int precioPorPersona) {
        setNombre(nombre);
        this.direccion = direccion;
        setPrecioPorPersona(precioPorPersona);
    }

    /**
     * Obtiene el nombre del tour.
     *
     * @return nombre del tour
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del tour, validando que no sea vacío.
     *
     * @param nombre nombre del tour
     * @throws IllegalArgumentException si el nombre es nulo o vacío
     */
    public void setNombre(String nombre) {
        // El nombre no puede ir vacio
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre del tour es obligatorio");
        }
        this.nombre = nombre;
    }

    /**
     * Obtiene la dirección del tour.
     *
     * @return dirección donde se realiza el tour
     */
    public Direccion getDireccion() {
        return this.direccion;
    }

    /**
     * Establece la dirección del tour.
     *
     * @param direccion dirección donde se realiza el tour
     */
    public void setDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

    /**
     * Obtiene el precio por persona del tour.
     *
     * @return precio por persona, en pesos chilenos
     */
    public int getPrecioPorPersona() {
        return precioPorPersona;
    }

    /**
     * Establece el precio por persona, validando que no sea negativo.
     *
     * @param precioPorPersona precio por persona, en pesos chilenos
     * @throws IllegalArgumentException si el precio es negativo
     */
    public void setPrecioPorPersona(int precioPorPersona) {
        // Un precio negativo no tiene sentido de negocio
        if (precioPorPersona < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo: " + precioPorPersona);
        }
        this.precioPorPersona = precioPorPersona;
    }

    /**
     * Retorna una representación legible del tour.
     *
     * @return cadena con nombre, dirección y precio por persona
     */
    @Override
    public String toString() {
        return "- " + nombre + " (" + direccion + ") -> Precio: $"
                + String.format("%,d", precioPorPersona) + " por persona.";
    }
}
