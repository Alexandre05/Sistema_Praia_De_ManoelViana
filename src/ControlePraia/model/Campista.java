package ControlePraia.model;

import java.util.ArrayList;

/**
 * Entidade para tabela de tbcampista.
 * @author PC
 */
public class Campista {

    private Integer IdCamp;
    private String NomeCamp;
    private String endcamp;
    private String CpfCamp;
    private String TelefoneCamp;
    private String PlacaCamp;
    private String observacoes;
    private String Embarca;
    private String tipo;
    private String perfil;
    private ArrayList<Acampamento> acampars = new ArrayList<Acampamento>();

    public Integer getIdCamp() {
        return IdCamp;
    }

    public void setIdCamp(Integer IdCamp) {
        this.IdCamp = IdCamp;
    }

    public String getNomeCamp() {
        return NomeCamp;
    }

    public void setNomeCamp(String NomeCamp) {
        this.NomeCamp = NomeCamp;
    }

    public String getEndcamp() {
        return endcamp;
    }

    public void setEndcamp(String endcamp) {
        this.endcamp = endcamp;
    }

    public String getCpfCamp() {
        return CpfCamp;
    }

    public void setCpfCamp(String CpfCamp) {
        this.CpfCamp = CpfCamp;
    }

    public String getTelefoneCamp() {
        return TelefoneCamp;
    }

    public void setTelefoneCamp(String TelefoneCamp) {
        this.TelefoneCamp = TelefoneCamp;
    }

    public String getPlacaCamp() {
        return PlacaCamp;
    }

    public void setPlacaCamp(String PlacaCamp) {
        this.PlacaCamp = PlacaCamp;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getEmbarca() {
        return Embarca;
    }

    public void setEmbarca(String Embarca) {
        this.Embarca = Embarca;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public ArrayList<Acampamento> getAcampars() {
        return acampars;
    }

    public void setAcampars(ArrayList<Acampamento> acampars) {
        this.acampars = acampars;
    }

}
