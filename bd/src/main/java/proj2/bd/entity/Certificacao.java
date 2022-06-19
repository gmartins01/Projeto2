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
@Table(name = "CERTIFICACAO")
@NamedQueries({
    @NamedQuery(name = "Certificacao.findAll", query = "SELECT c FROM Certificacao c"),
    @NamedQuery(name = "Certificacao.findByIdCertificacao", query = "SELECT c FROM Certificacao c WHERE c.idCertificacao = :idCertificacao"),
    @NamedQuery(name = "Certificacao.findByDataHora", query = "SELECT c FROM Certificacao c WHERE c.dataHora = :dataHora")})
public class Certificacao implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_CERTIFICACAO")
    private BigDecimal idCertificacao;
    @Column(name = "DATA_HORA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataHora;
    @JoinColumn(name = "ID_ENTIDADE", referencedColumnName = "ID_ENTIDADE")
    @ManyToOne(optional = false)
    private EntidadeCertificadora idEntidade;
    @JoinColumn(name = "ID_PRODUTOR", referencedColumnName = "ID_PRODUTOR")
    @ManyToOne(optional = false)
    private Produtor idProdutor;

    public Certificacao() {
    }

    public Certificacao(BigDecimal idCertificacao) {
        this.idCertificacao = idCertificacao;
    }

    public BigDecimal getIdCertificacao() {
        return idCertificacao;
    }

    public void setIdCertificacao(BigDecimal idCertificacao) {
        this.idCertificacao = idCertificacao;
    }

    public Date getDataHora() {
        return dataHora;
    }

    public void setDataHora(Date dataHora) {
        this.dataHora = dataHora;
    }

    public EntidadeCertificadora getIdEntidade() {
        return idEntidade;
    }

    public void setIdEntidade(EntidadeCertificadora idEntidade) {
        this.idEntidade = idEntidade;
    }

    public Produtor getIdProdutor() {
        return idProdutor;
    }

    public void setIdProdutor(Produtor idProdutor) {
        this.idProdutor = idProdutor;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCertificacao != null ? idCertificacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Certificacao)) {
            return false;
        }
        Certificacao other = (Certificacao) object;
        if ((this.idCertificacao == null && other.idCertificacao != null) || (this.idCertificacao != null && !this.idCertificacao.equals(other.idCertificacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "teste.Certificacao[ idCertificacao=" + idCertificacao + " ]";
    }
    
}
