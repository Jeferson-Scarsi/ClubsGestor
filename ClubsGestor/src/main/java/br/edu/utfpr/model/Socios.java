package br.edu.utfpr.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Socios implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idsocio;
    private String nome;
    private String cpf;
    @ManyToOne
    private Categorias_Socios categoria;    
    private String cep;
    private String cidade;
    private String endereco;
    private String numero;
    private String complemento;
    private String uf;
    private String bairro;
    private String fonecomercial;
    private String email;
    private String fonecelular;

    public Socios() {
    }

    public Socios(Long idsocio, String nome, String cpf, Categorias_Socios categoria, String cep, String cidade, String endereco, String numero, String complemento, String uf, String bairro, String fonecomercial, String email, String fonecelular) {
        this.idsocio = idsocio;
        this.nome = nome;
        this.cpf = cpf;
        this.categoria = categoria;
        this.cep = cep;
        this.cidade = cidade;
        this.endereco = endereco;
        this.numero = numero;
        this.complemento = complemento;
        this.uf = uf;
        this.bairro = bairro;
        this.fonecomercial = fonecomercial;
        this.email = email;
        this.fonecelular = fonecelular;
    }

    public Long getIdsocio() {
        return idsocio;
    }

    public void setIdsocio(Long idsocio) {
        this.idsocio = idsocio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public Categorias_Socios getCategoria() {
        return categoria;
    }

    public void setCategoria(Categorias_Socios categoria) {
        this.categoria = categoria;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getFonecomercial() {
        return fonecomercial;
    }

    public void setFonecomercial(String fonecomercial) {
        this.fonecomercial = fonecomercial;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFonecelular() {
        return fonecelular;
    }

    public void setFonecelular(String fonecelular) {
        this.fonecelular = fonecelular;
    }

    @Override
    public String toString() {
        return "Socios{" + "idsocio=" + idsocio + ", nome=" + nome + ", cpf=" + cpf + ", categoria=" + categoria + ", cep=" + cep + ", cidade=" + cidade + ", endereco=" + endereco + ", numero=" + numero + ", complemento=" + complemento + ", uf=" + uf + ", bairro=" + bairro + ", fonecomercial=" + fonecomercial + ", email=" + email + ", fonecelular=" + fonecelular + '}';
    }

    

    
}
