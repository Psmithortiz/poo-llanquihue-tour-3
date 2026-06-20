package model;

/**
 * Representa la dirección física de un tour.
 *
 * @author Pablo Smith
 * @version 1.5
 */
public class Direccion {

    private String calle;
    private int numeroCalle;
    private String comuna;
    private String region;

    /**
     * Crea una dirección con valores por defecto.
     */
    public Direccion() {
        this("Sin asignar", 0, "Sin asignar", "Sin asignar");
    }

    /**
     * Crea una dirección con los datos entregados.
     *
     * @param calle       nombre de la calle
     * @param numeroCalle numero de calle
     * @param comuna      nombre de la comuna
     * @param region      nombre de la region
     */
    public Direccion(String calle, int numeroCalle, String comuna, String region) {
        // Se limpian los espacios en los extremos de cada texto
        this.calle = calle.trim();
        this.numeroCalle = numeroCalle;
        this.comuna = comuna.trim();
        this.region = region.trim();
    }

    /**
     * Obtiene el nombre de la calle.
     *
     * @return nombre de la calle
     */
    public String getCalle() {
        return calle;
    }

    /**
     * Establece el nombre de la calle.
     *
     * @param calle nombre de la calle
     */
    public void setCalle(String calle) {
        this.calle = calle;
    }

    /**
     * Obtiene el número de la calle.
     *
     * @return número de la calle
     */
    public int getNumeroCalle() {
        return numeroCalle;
    }

    /**
     * Establece el número de la calle.
     *
     * @param numeroCalle número de la calle
     */
    public void setNumeroCalle(int numeroCalle) {
        this.numeroCalle = numeroCalle;
    }

    /**
     * Obtiene el nombre de la comuna.
     *
     * @return nombre de la comuna
     */
    public String getComuna() {
        return comuna;
    }

    /**
     * Establece el nombre de la comuna.
     *
     * @param comuna nombre de la comuna
     */
    public void setComuna(String comuna) {
        this.comuna = comuna;
    }

    /**
     * Obtiene el nombre de la región.
     *
     * @return nombre de la región
     */
    public String getRegion() {
        return region;
    }

    /**
     * Establece el nombre de la región.
     *
     * @param region nombre de la región
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * Retorna una representación legible de la dirección.
     *
     * @return cadena con calle, número, comuna y región
     */
    @Override
    public String toString() {
        return "Calle " + calle + " " + numeroCalle + ", " + comuna + ", " + region;
    }
}
