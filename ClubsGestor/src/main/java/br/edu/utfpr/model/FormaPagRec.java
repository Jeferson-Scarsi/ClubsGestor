package br.edu.utfpr.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class FormaPagRec {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idformapagrec;
    private String descrforma;

    public FormaPagRec() {
    }

    public FormaPagRec(Long idformapagrec, String descrforma) {
        this.idformapagrec = idformapagrec;
        this.descrforma = descrforma;
    }

    public Long getIdformapagrec() {
        return idformapagrec;
    }

    public void setIdformapagrec(Long idformapagrec) {
        this.idformapagrec = idformapagrec;
    }

    public String getDescrforma() {
        return descrforma;
    }

    public void setDescrforma(String descrforma) {
        this.descrforma = descrforma;
    }

    @Override
    public String toString() {
        return "FormaPagRec{" + "idformapagrec=" + idformapagrec + ", descrforma=" + descrforma + '}';
    }
    
    
    
}
