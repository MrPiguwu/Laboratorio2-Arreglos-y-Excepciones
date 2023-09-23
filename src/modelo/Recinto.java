package modelo;
public class Recinto {



    //variables
    private int idRecinto;
    private int IdPais;
    private String ubicacion;
    private int capacidad;

    public Recinto(int IdPais, String ubicacion, int idRecinto, int capacidad) {
        this.IdPais = IdPais;
        this.idRecinto = idRecinto;
        this.ubicacion = ubicacion;
        this.capacidad = capacidad;
    }


    //getters setters.
    public int getIdRecinto() {
        return idRecinto;
    }

    public void setIdRecinto(int idRecinto) {
        this.idRecinto = idRecinto;
    }

    public int getIdPais() {
        return IdPais;
    }

    public void setIdPais(int IdPais) {
        this.IdPais = IdPais;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }


}
