package modelo;

import java.util.ArrayList;
import java.util.List;

class Pais {
    private int idPais;
    private List<Recinto> recintos;

    public Pais(int idPais) {
        this.idPais = idPais;
        this.recintos = new ArrayList<>();
    }

    public int getIdPais() {
        return idPais;
    }

    public void setIdPais(int idPais) {
        this.idPais = idPais;
    }

    public List<Recinto> getRecintos() {
        return recintos;
    }

    public void setRecintos(List<Recinto> recintos) {
        this.recintos = recintos;
    }
}