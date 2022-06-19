/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proj2.bd.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author gonca
 */
@Entity
@Table(name = "VACINACAO")
@NamedQueries({
    @NamedQuery(name = "Vacinacao.findAll", query = "SELECT v FROM Vacinacao v"),
    @NamedQuery(name = "Vacinacao.findByIdVacinacao", query = "SELECT v FROM Vacinacao v WHERE v.idVacinacao = :idVacinacao"),
    @NamedQuery(name = "Vacinacao.findByDataHora", query = "SELECT v FROM Vacinacao v WHERE v.dataHora = :dataHora")})
public class Vacinacao implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_VACINACAO")
    private BigDecimal idVacinacao;
    @Basic(optional = false)
    @Column(name = "DATA_HORA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHora;
    @JoinColumn(name = "COD_GALINHA", referencedColumnName = "COD_GALINHA")
    @ManyToOne(optional = false)
    private Galinha codGalinha;
    @JoinColumn(name = "ID_VACINA", referencedColumnName = "ID_VACINA")
    @ManyToOne(optional = false)
    private Vacina idVacina;
    @JoinColumn(name = "ID_VETERINARIO", referencedColumnName = "ID_VETERINARIO")
    @ManyToOne(optional = false)
    private Veterinario idVeterinario;

    public Vacinacao() {
    }

    public Vacinacao(BigDecimal idVacinacao) {
        this.idVacinacao = idVacinacao;
    }

    public Vacinacao(BigDecimal idVacinacao, Date dataHora) {
        this.idVacinacao = idVacinacao;
        this.dataHora = dataHora;
    }

    public BigDecimal getIdVacinacao() {
        return idVacinacao;
    }

    public void setIdVacinacao(BigDecimal idVacinacao) {
        this.idVacinacao = idVacinacao;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public Galinha getCodGalinha() {
        return codGalinha;
    }

    public void setCodGalinha(Galinha codGalinha) {
        this.codGalinha = codGalinha;
    }

    public Vacina getIdVacina() {
        return idVacina;
    }

    public void setIdVacina(Vacina idVacina) {
        this.idVacina = idVacina;
    }

    public Veterinario getIdVeterinario() {
        return idVeterinario;
    }

    public void setIdVeterinario(Veterinario idVeterinario) {
        this.idVeterinario = idVeterinario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVacinacao != null ? idVacinacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vacinacao)) {
            return false;
        }
        Vacinacao other = (Vacinacao) object;
        if ((this.idVacinacao == null && other.idVacinacao != null) || (this.idVacinacao != null && !this.idVacinacao.equals(other.idVacinacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "teste.Vacinacao[ idVacinacao=" + idVacinacao + " ]";
    }
    
}
