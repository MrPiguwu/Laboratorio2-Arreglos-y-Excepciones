import modelo.AsignacionRecintos;

public class Main {

    public static void main(String[] args) {
        AsignacionRecintos asignacionRecintos = new AsignacionRecintos();

        // Cargar los recintos desde el archivo CSV
        asignacionRecintos.cargarRecintosDesdeCSV("src/data/recintos.csv");

        // Cargar los eventos desde el archivo CSV
        asignacionRecintos.cargarEventosDesdeCSV("src/data/eventos.csv");

        // Asignar recintos a eventos
        asignacionRecintos.asignarRecintosAEventos();

        // Obtener la cantidad de recintos asignados
        int cantidadRecintosAsignados = asignacionRecintos.getCantidadRecintosAsignados();

        System.out.println("Cantidad de recintos asignados: " + cantidadRecintosAsignados);
    }
}
