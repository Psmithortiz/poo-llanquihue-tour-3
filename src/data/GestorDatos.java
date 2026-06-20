package data;

import model.Direccion;
import model.Guia;
import model.Tour;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Gestiona la carga de tours y guías desde archivos de texto.
 * Lee cada archivo de datos, transforma cada línea en un objeto
 * ({@link Tour} o {@link Guia}) y los reúne en colecciones.
 *
 * @author Pablo Smith
 * @version 1.0
 */
public class GestorDatos {

    /**
     * Lee el archivo de tours línea por línea, separa los campos
     * y construye los objetos {@link Tour} en una lista.
     * Si el archivo no se puede leer, aborta la carga. Si una línea
     * trae datos inválidos, la ignora y continúa con las demás.
     *
     * @return lista con los tours cargados desde el archivo;
     *         vacía si ocurre un error durante la lectura
     */
    public ArrayList<Tour> leerTours() {
        ArrayList<Tour> listaTours = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("resources/tours.txt"))) {
            String linea;
            // Recorre el archivo linea por linea
            while ((linea = br.readLine()) != null) {
                try {
                    // Cada linea trae los campos separados por ';'
                    String[] partes = linea.split(";");
                    String nombre = partes[0];
                    String calle = partes[1];
                    int numeroCalle = Integer.parseInt(partes[2].trim());
                    String comuna = partes[3];
                    String region = partes[4];
                    int precioPorPersona = Integer.parseInt(partes[5].trim());

                    Direccion direccion = new Direccion(calle, numeroCalle, comuna, region);
                    Tour nuevoTour = new Tour(nombre, direccion, precioPorPersona);
                    listaTours.add(nuevoTour);
                } catch (IllegalArgumentException e) {
                    // Una linea con datos invalidos se ignora, el resto sigue cargando
                    System.out.println("Linea ignorada: " + linea + " -> " + e.getMessage());
                }
            }
        } catch (IOException e) {
            // Si el archivo no se puede leer, no hay nada que cargar
            System.out.println("Error al intentar leer el archivo de datos: " + e.getMessage());
        }

        return listaTours;
    }

    /**
     * Lee el archivo de guías línea por línea, separa los campos
     * y construye los objetos {@link Guia} en una lista.
     * Si el archivo no se puede leer, aborta la carga. Si una línea
     * trae datos inválidos, la ignora y continúa con las demás.
     *
     * @return lista con los guías cargados desde el archivo;
     *         vacía si ocurre un error durante la lectura
     */
    public ArrayList<Guia> leerGuias() {
        ArrayList<Guia> listaGuias = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader("resources/guias.txt"))) {
            String linea;
            // Recorre el archivo linea por linea
            while ((linea = br.readLine()) != null) {
                try {
                    // Cada linea trae los campos separados por ';'
                    String[] partes = linea.split(";");
                    String nombre = partes[0];
                    String idioma = partes[1];
                    int edad = Integer.parseInt(partes[2].trim());

                    Guia nuevoGuia = new Guia(nombre, idioma, edad);
                    listaGuias.add(nuevoGuia);
                } catch (IllegalArgumentException e) {
                    // Una linea con datos invalidos se ignora, el resto sigue cargando
                    System.out.println("Linea ignorada: " + linea + " -> " + e.getMessage());
                }
            }
        } catch (IOException e) {
            // Si el archivo no se puede leer, no hay nada que cargar
            System.out.println("Error al intentar leer el archivo de datos: " + e.getMessage());
        }

        return listaGuias;
    }
}
