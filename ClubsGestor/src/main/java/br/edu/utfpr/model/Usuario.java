package br.edu.utfpr.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Usuario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idusuario;
    private String nome;
    private String login;
    private String password;
    private boolean flagadm;   
    private boolean flagativo;

    public Usuario() {
    }

    public Usuario(Long idusuario, String nome, String login, String password, boolean flagadm, boolean flagativo) {
        this.idusuario = idusuario;
        this.nome = nome;
        this.login = login;
        this.password = password;
        this.flagadm = flagadm;
        this.flagativo = flagativo;
    }
        
    

    public Long getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Long idusuario) {
        this.idusuario = idusuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isFlagadm() {
        return flagadm;
    }

    public void setFlagadm(boolean flagadm) {
        this.flagadm = flagadm;
    }

    public boolean isFlagativo() {
        return flagativo;
    }

    public void setFlagativo(boolean flagativo) {
        this.flagativo = flagativo;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idusuario=" + idusuario + ", nome=" + nome + ", login=" + login + ", password=" + password + ", flagadm=" + flagadm + ", flagativo=" + flagativo + '}';
    }
        
    
}
