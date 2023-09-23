package modelo;

public class Evento {

    public Evento(int idEvento, int idPais, String artista, int horario, String fecha, int duracion, int cantidadAsistentes) {
        this.idEvento = idEvento;
        this.idPais = idPais;
        this.artista = artista;
        this.horario = horario;
        this.fecha = fecha;
        this.duracion = duracion;
        this.cantidadAsistentes = cantidadAsistentes;
    }



    private int idEvento;
    private int idPais;
    private String artista;
    private int horario;
    private String fecha;
    private int duracion;
    private int cantidadAsistentes;
    private Recinto recintoAsignado;

    public int getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(int idEvento) {
        this.idEvento = idEvento;
    }

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public int getHorario() {
        return horario;
    }

    public void setHorario(int horario) {
        this.horario = horario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getCantidadAsistentes() {
        return cantidadAsistentes;
    }

    public Recinto getRecintoAsignado() {
        return recintoAsignado;
    }

    public void setRecintoAsignado(Recinto recintoAsignado) {
        this.recintoAsignado = recintoAsignado;
    }

    public void setCantidadAsistentes(int cantidadAsistentes) {
        this.cantidadAsistentes = cantidadAsistentes;
    }

}


