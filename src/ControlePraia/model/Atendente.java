package ControlePraia.model;

import java.util.ArrayList;

/**
 * Entidade da tabela tblatendente.
 * @author PC
 */
public class Atendente {

    private Integer IdAte;
    private String NomeAte;
    private String endade;
    private String Telefone;
    private String Cpf;
    private String email;
    private String senha;
    private String login;
    private EPerfilAtendente perfil;
    private ArrayList<Campista> campistas = new ArrayList<Campista>();
    private ArrayList<Acampamento> acampars = new ArrayList<Acampamento>();

    public Integer getIdAte() {
        return IdAte;
    }

    public void setIdAte(Integer IdAte) {
        this.IdAte = IdAte;
    }

    public String getNomeAte() {
        return NomeAte;
    }

    public void setNomeAte(String NomeAte) {
        this.NomeAte = NomeAte;
    }

    public String getEndade() {
        return endade;
    }

    public void setEndade(String endade) {
        this.endade = endade;
    }

    public String getTelefone() {
        return Telefone;
    }

    public void setTelefone(String Telefone) {
        this.Telefone = Telefone;
    }

    public String getCpf() {
        return Cpf;
    }

    public void setCpf(String Cpf) {
        this.Cpf = Cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public EPerfilAtendente getPerfil() {
        return perfil;
    }

    public void setPerfil(EPerfilAtendente perfil) {
        this.perfil = perfil;
    }

    public ArrayList<Campista> getCampistas() {
        return campistas;
    }

    public void setCampistas(ArrayList<Campista> campistas) {
        this.campistas = campistas;
    }

    public ArrayList<Acampamento> getAcampars() {
        return acampars;
    }

    public void setAcampars(ArrayList<Acampamento> acampars) {
        this.acampars = acampars;
    }

}
