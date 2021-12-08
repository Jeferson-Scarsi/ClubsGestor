package br.edu.utfpr.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Categorias_Socios implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idcategoria;
    private String descrcategoria;
    private double valor;
    private boolean flagativo;

    public Categorias_Socios() {
    }

    public Categorias_Socios(Long idcategoria, String descrcategoria, double valor, boolean flagativo) {
        this.idcategoria = idcategoria;
        this.descrcategoria = descrcategoria;
        this.valor = valor;
        this.flagativo = flagativo;
    }

    public Long getIdcategoria() {
        return idcategoria;
    }

    public void setIdcategoria(Long idcategoria) {
        this.idcategoria = idcategoria;
    }

    public String getDescrcategoria() {
        return descrcategoria;
    }

    public void setDescrcategoria(String descrcategoria) {
        this.descrcategoria = descrcategoria;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isFlagativo() {
        return flagativo;
    }

    public void setFlagativo(boolean flagativo) {
        this.flagativo = flagativo;
    }

    @Override
    public String toString() {
        return descrcategoria;
    }

        
        
    
}
