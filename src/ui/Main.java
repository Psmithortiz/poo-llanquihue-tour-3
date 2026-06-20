package ui;

import data.GestorDatos;
import model.Guia;
import model.Tour;

import java.util.ArrayList;

/**
 * Punto de entrada de la aplicación.
 * Carga los tours y los guías desde sus archivos, muestra los
 * catálogos completos y los listados filtrados por precio e idioma,
 * todo por consola.
 *
 * @author Pablo Smith
 * @version 1.0
 */
public class Main {
    /**
     * Precio máximo, en pesos, para considerar económico a un tour.
     */
    private static final int UMBRAL_PRECIO_ECONOMICO = 20000;
    /**
     * Idioma objetivo del filtro de búsqueda de guías.
     */
    private static final String IDIOMA_A_BUSCAR = "INGLES";
    /**
     * Línea separadora para dar formato a la salida por consola.
     */
    private static final String SEPARADOR_LINEA = "=".repeat(50);

    /**
     * Ejecuta la carga de datos y muestra los catálogos completos
     * junto con los listados filtrados de tours y guías.
     *
     * @param args argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {
        GestorDatos gestor = new GestorDatos();

        ArrayList<Tour> todosLosTours = gestor.leerTours();
        if (todosLosTours.isEmpty()) {
            System.out.println("No se encontraron tours para mostrar o hubo un error en la carga.");
            return;
        }

        ArrayList<Guia> todosLosGuias = gestor.leerGuias();
        if (todosLosGuias.isEmpty()) {
            System.out.println("No se encontraron guias para mostrar o hubo un error en la carga.");
            return;
        }

        mostrarCatalogoCompleto(todosLosTours);
        mostrarToursFiltrado(todosLosTours, UMBRAL_PRECIO_ECONOMICO);
        mostrarGuias(todosLosGuias);
        mostrarGuiasFiltrado(todosLosGuias, IDIOMA_A_BUSCAR);
    }

    /**
     * Muestra por consola el catálogo completo de tours.
     *
     * @param tours lista de tours a mostrar
     */
    static void mostrarCatalogoCompleto(ArrayList<Tour> tours) {
        System.out.println(SEPARADOR_LINEA);
        System.out.println("               CATALOGO COMPLETO                  ");
        System.out.println(SEPARADOR_LINEA);
        for (Tour tour : tours) {
            System.out.println(tour);
        }
        System.out.println();
    }

    /**
     * Muestra por consola los tours cuyo precio es menor al umbral indicado.
     *
     * @param tours  lista de tours a filtrar
     * @param umbral precio máximo, en pesos, para incluir un tour
     */
    static void mostrarToursFiltrado(ArrayList<Tour> tours, int umbral) {
        System.out.println(SEPARADOR_LINEA);
        System.out.println("      TOURS ECONOMICOS (Bajo $" + String.format("%,d", umbral) + ")       ");
        System.out.println(SEPARADOR_LINEA);

        int contadorFiltrados = 0;
        for (Tour tour : tours) {
            if (tour.getPrecioPorPersona() < umbral) {
                System.out.println(tour);
                contadorFiltrados++;
            }
        }

        if (contadorFiltrados == 0) {
            System.out.println("No hay tours disponibles bajo el presupuesto de $" + umbral);
        }
        System.out.println(SEPARADOR_LINEA);
    }

    /**
     * Muestra por consola la lista completa de guías disponibles.
     *
     * @param guias lista de guías a mostrar
     */
    static void mostrarGuias(ArrayList<Guia> guias) {
        System.out.println(SEPARADOR_LINEA);
        System.out.println("               GUIAS DISPONIBLES                  ");
        System.out.println(SEPARADOR_LINEA);
        for (Guia guia : guias) {
            System.out.println(guia);
        }
        System.out.println();
    }

    /**
     * Muestra por consola los guías que dominan el idioma buscado.
     *
     * @param guias         lista de guías a filtrar
     * @param idiomaBuscado idioma por el cual filtrar
     */
    static void mostrarGuiasFiltrado(ArrayList<Guia> guias, String idiomaBuscado) {
        System.out.println(SEPARADOR_LINEA);
        System.out.println("      GUIAS FILTRADOS (Especializados en " + idiomaBuscado + ")       ");
        System.out.println(SEPARADOR_LINEA);

        int contadorFiltrados = 0;
        for (Guia guia : guias) {
            if (guia.getIdioma().equalsIgnoreCase(idiomaBuscado)) {
                System.out.println(guia);
                contadorFiltrados++;
            }
        }

        if (contadorFiltrados == 0) {
            System.out.println("No hay guias disponibles especializados en " + idiomaBuscado);
        }
        System.out.println(SEPARADOR_LINEA);
    }
}
