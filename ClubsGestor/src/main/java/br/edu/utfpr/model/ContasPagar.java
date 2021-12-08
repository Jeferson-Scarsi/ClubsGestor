package br.edu.utfpr.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class ContasPagar implements Serializable {
    @ManyToOne
    private Empresa idempresa;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idplanilha;
    private Long idtitulo;
    private Long digitotitulo;
    @ManyToOne
    private Socios idsocio;
    @ManyToOne
    private Usuario idusuario;
    @ManyToOne
    private FormaPagRec idformapagrec;
    private Date dtlancamento;
    private Date dtvencimento;
    private Float valbruto;
    private Float valdesconto;
    private Float valacrescimo;
    private Float valtotliquido;
    private Date dtalteracao;

    public ContasPagar() {
    }

    public ContasPagar(Empresa idempresa, Long idplanilha, Long idtitulo, Long digitotitulo, Socios idsocio, Usuario idusuario, FormaPagRec idformapagrec, Date dtlancamento, Date dtvencimento, Float valbruto, Float valdesconto, Float valacrescimo, Float valtotliquido, Date dtalteracao) {
        this.idempresa = idempresa;
        this.idplanilha = idplanilha;
        this.idtitulo = idtitulo;
        this.digitotitulo = digitotitulo;
        this.idsocio = idsocio;
        this.idusuario = idusuario;
        this.idformapagrec = idformapagrec;
        this.dtlancamento = dtlancamento;
        this.dtvencimento = dtvencimento;
        this.valbruto = valbruto;
        this.valdesconto = valdesconto;
        this.valacrescimo = valacrescimo;
        this.valtotliquido = valtotliquido;
        this.dtalteracao = dtalteracao;
    }

    public Empresa getIdempresa() {
        return idempresa;
    }

    public void setIdempresa(Empresa idempresa) {
        this.idempresa = idempresa;
    }

    public Long getIdplanilha() {
        return idplanilha;
    }

    public void setIdplanilha(Long idplanilha) {
        this.idplanilha = idplanilha;
    }

    public Long getIdtitulo() {
        return idtitulo;
    }

    public void setIdtitulo(Long idtitulo) {
        this.idtitulo = idtitulo;
    }

    public Long getDigitotitulo() {
        return digitotitulo;
    }

    public void setDigitotitulo(Long digitotitulo) {
        this.digitotitulo = digitotitulo;
    }

    public Socios getIdsocio() {
        return idsocio;
    }

    public void setIdsocio(Socios idsocio) {
        this.idsocio = idsocio;
    }

    public Usuario getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(Usuario idusuario) {
        this.idusuario = idusuario;
    }

    public FormaPagRec getIdformapagrec() {
        return idformapagrec;
    }

    public void setIdformapagrec(FormaPagRec idformapagrec) {
        this.idformapagrec = idformapagrec;
    }

    public Date getDtlancamento() {
        return dtlancamento;
    }

    public void setDtlancamento(Date dtlancamento) {
        this.dtlancamento = dtlancamento;
    }

    public Date getDtvencimento() {
        return dtvencimento;
    }

    public void setDtvencimento(Date dtvencimento) {
        this.dtvencimento = dtvencimento;
    }

    public Float getValbruto() {
        return valbruto;
    }

    public void setValbruto(Float valbruto) {
        this.valbruto = valbruto;
    }

    public Float getValdesconto() {
        return valdesconto;
    }

    public void setValdesconto(Float valdesconto) {
        this.valdesconto = valdesconto;
    }

    public Float getValacrescimo() {
        return valacrescimo;
    }

    public void setValacrescimo(Float valacrescimo) {
        this.valacrescimo = valacrescimo;
    }

    public Float getValtotliquido() {
        return valtotliquido;
    }

    public void setValtotliquido(Float valtotliquido) {
        this.valtotliquido = valtotliquido;
    }

    public Date getDtalteracao() {
        return dtalteracao;
    }

    public void setDtalteracao(Date dtalteracao) {
        this.dtalteracao = dtalteracao;
    }

    @Override
    public String toString() {
        return "ContasPagar{" + "idempresa=" + idempresa + ", idplanilha=" + idplanilha + ", idtitulo=" + idtitulo + ", digitotitulo=" + digitotitulo + ", idsocio=" + idsocio + ", idusuario=" + idusuario + ", idformapagrec=" + idformapagrec + ", dtlancamento=" + dtlancamento + ", dtvencimento=" + dtvencimento + ", valbruto=" + valbruto + ", valdesconto=" + valdesconto + ", valacrescimo=" + valacrescimo + ", valtotliquido=" + valtotliquido + ", dtalteracao=" + dtalteracao + '}';
    }

        
    
}
