package ControlePraia.model;

import java.util.ArrayList;
import java.util.Date;

/**
 * Entidade para tabela de tbacampar.
 * @author PC
 */
public class Acampamento {

    private int OrA;
    private Date DataAcamp;
    private String Situacao;
    private String AreaAcamp;
    private double valor;
    private String DiasAcamp;
    private String ObsAcamp;
    private ArrayList<Campista> campistas = new ArrayList<Campista>();

    public int getOrA() {
        return OrA;
    }

    public void setOrA(int OrA) {
        this.OrA = OrA;
    }

    public Date getDataAcamp() {
        return DataAcamp;
    }

    public void setDataAcamp(Date DataAcamp) {
        this.DataAcamp = DataAcamp;
    }

    public String getSituacao() {
        return Situacao;
    }

    public void setSituacao(String Situacao) {
        this.Situacao = Situacao;
    }

    public String getAreaAcamp() {
        return AreaAcamp;
    }

    public void setAreaAcamp(String AreaAcamp) {
        this.AreaAcamp = AreaAcamp;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getDiasAcamp() {
        return DiasAcamp;
    }

    public void setDiasAcamp(String DiasAcamp) {
        this.DiasAcamp = DiasAcamp;
    }

    public String getObsAcamp() {
        return ObsAcamp;
    }

    public void setObsAcamp(String ObsAcamp) {
        this.ObsAcamp = ObsAcamp;
    }

    public ArrayList<Campista> getCampistas() {
        return campistas;
    }

    public void setCampistas(ArrayList<Campista> campistas) {
        this.campistas = campistas;
    }

}
