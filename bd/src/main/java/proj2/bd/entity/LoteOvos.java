/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proj2.bd.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author gonca
 */
@Entity
@Table(name = "LOTE_OVOS")
@NamedQueries({
    @NamedQuery(name = "LoteOvos.findAll", query = "SELECT l FROM LoteOvos l"),
    @NamedQuery(name = "LoteOvos.findByIdLote", query = "SELECT l FROM LoteOvos l WHERE l.idLote = :idLote"),
    @NamedQuery(name = "LoteOvos.findByClasse", query = "SELECT l FROM LoteOvos l WHERE l.classe = :classe"),
    @NamedQuery(name = "LoteOvos.findByDataCriacao", query = "SELECT l FROM LoteOvos l WHERE l.dataCriacao = :dataCriacao"),
    @NamedQuery(name = "LoteOvos.findByDataValidade", query = "SELECT l FROM LoteOvos l WHERE l.dataValidade = :dataValidade")})
public class LoteOvos implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_LOTE")
    private BigDecimal idLote;
    @Basic(optional = false)
    @Column(name = "CLASSE")
    private String classe;
    @Basic(optional = false)
    @Column(name = "DATA_CRIACAO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataCriacao;
    @Column(name = "DATA_VALIDADE")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataValidade;
    @OneToMany(mappedBy = "idLote")
    private Collection<Produto> produtoCollection;

    public LoteOvos() {
    }

    public LoteOvos(BigDecimal idLote) {
        this.idLote = idLote;
    }

    public LoteOvos(BigDecimal idLote, String classe, Date dataCriacao) {
        this.idLote = idLote;
        this.classe = classe;
        this.dataCriacao = dataCriacao;
    }

    public BigDecimal getIdLote() {
        return idLote;
    }

    public void setIdLote(BigDecimal idLote) {
        this.idLote = idLote;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public Date getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }

    public Collection<Produto> getProdutoCollection() {
        return produtoCollection;
    }

    public void setProdutoCollection(Collection<Produto> produtoCollection) {
        this.produtoCollection = produtoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idLote != null ? idLote.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LoteOvos)) {
            return false;
        }
        LoteOvos other = (LoteOvos) object;
        if ((this.idLote == null && other.idLote != null) || (this.idLote != null && !this.idLote.equals(other.idLote))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "teste.LoteOvos[ idLote=" + idLote + " ]";
    }
    
}
