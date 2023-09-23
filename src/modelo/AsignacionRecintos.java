package modelo;

import java.util.ArrayList;
import java.util.List;

public class AsignacionRecintos {
    private List<Pais> paises;
    private List<Recinto> recintos;
    private List<Evento> eventos;
    private List<Evento> eventosSinRecinto;
    private int cantidadRecintosAsignados;

    public AsignacionRecintos() {
        paises = new ArrayList<>();
        recintos = new ArrayList<>();
        eventos = new ArrayList<>();
        eventosSinRecinto = new ArrayList<>();
        cantidadRecintosAsignados = 0;
    }

    public List<Recinto> cargarRecintosDesdeCSV(String archivoRecintos) {
        List<String[]> filas = CSVController.readCSVFile(archivoRecintos);
        List<Recinto> recintos = new ArrayList<>();
        for (int i = 1; i < filas.size(); i++) {
            String[] valores = filas.get(i);
            if (valores.length == 4) {
                int idPais = Integer.parseInt(valores[0].toString());
                String ubicacion = valores[1].toString();
                int idRecinto = Integer.parseInt(valores[2].toString());
                int capacidad = Integer.parseInt(valores[3].toString());

                Recinto recinto = new Recinto(idPais, ubicacion, idRecinto, capacidad);
                recintos.add(recinto);
            } else {
                System.out.println("Error en una línea del archivo de recintos.");
            }
        }
        return recintos;
    }

    public List<Evento> cargarEventosDesdeCSV(String archivoEventos) {
        List<String[]> filas = CSVController.readCSVFile(archivoEventos);
        List<Evento> eventos = new ArrayList<>();

        for (int i = 1; i < filas.size(); i++) {
            String[] valores = filas.get(i);
            if (valores.length == 7) {
                int idEvento = Integer.parseInt(valores[0].toString());
                int idPais = Integer.parseInt(valores[1].toString());
                String artista = valores[2].toString();
                int horario = Integer.parseInt(valores[3].toString());
                String fecha = valores[4].toString();
                int duracion = Integer.parseInt(valores[5].toString());
                int cantidadAsistentes = Integer.parseInt(valores[6].toString());
                Evento evento = new Evento(idEvento, idPais, artista, horario, fecha, duracion, cantidadAsistentes);
                eventos.add(evento);
            } else {
                System.out.println("Error en una línea del archivo de eventos.");
            }
        }

        return eventos;
    }


    public int getCantidadRecintosAsignados() {
        return cantidadRecintosAsignados;
    }

    public void asignarRecintosAEventos() {
        for (Evento evento : eventos) {
            if (evento.getRecintoAsignado() == null) {
                // Encuentra un recinto disponible para el evento
                Recinto recintoDisponible = encontrarRecintoDisponible(evento);

                if (recintoDisponible != null) {
                    evento.setRecintoAsignado(recintoDisponible);
                    cantidadRecintosAsignados++; // Incrementa el contador de recintos asignados
                } else {
                    eventosSinRecinto.add(evento);
                }
            }
        }
    }





    private Recinto encontrarRecintoDisponible(Evento evento) {
        for (Recinto recinto : recintos) {
            // Verifica si el recinto cumple con los requisitos
            if (recinto.getIdPais() == evento.getIdPais() &&
                    recinto.getCapacidad() >= evento.getCantidadAsistentes()) {
                if (!hayConflictosDeHorario(evento, recinto)) {
                    return recinto;
                }
            }
        }
        return null;
    }



    private boolean hayConflictosDeHorario(Evento evento, Recinto recinto) {
        for (Evento eventoExistente : eventos) {
            if (eventoExistente.getRecintoAsignado() == recinto) {
                // Verifica si el evento existente tiene un horario que se superpone con el evento actual
                if (eventoExistente.getFecha().equals(evento.getFecha()) &&
                        eventoExistente.getHorario() <= evento.getHorario() + evento.getDuracion() &&
                        eventoExistente.getHorario() + eventoExistente.getDuracion() >= evento.getHorario()) {
                    return true;
                }
            }
        }
        return false;
    }

    public List<Evento> obtenerEventosConRecintoAsignado() {
        List<Evento> eventosConRecintoAsignado = new ArrayList<>();
        for (Evento evento : eventos) {
            if (evento.getRecintoAsignado() != null) {
                eventosConRecintoAsignado.add(evento);
            }
        }
        return eventosConRecintoAsignado;
    }

    public List<Evento> obtenerEventosSinRecintoAsignado() {
        return eventosSinRecinto;
    }

    public void generarInforme() {
        // Implementa la lógica para mostrar el informe
    }

    public void exportarResultados(String archivoSalida) {
        // Implementa la lógica para exportar los resultados a un archivo
    }

    public int obtenerCantidadEventosAsignados() {
        int cantidadEventosAsignados = 0;
        for (Evento evento : eventos) {
            if (evento.getRecintoAsignado() != null) {
                cantidadEventosAsignados++;
            }
        }
        return cantidadEventosAsignados;
    }

}
