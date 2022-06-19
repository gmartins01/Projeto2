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
import javax.persistence.CascadeType;
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
@Table(name = "GALINHA")
@NamedQueries({
    @NamedQuery(name = "Galinha.findAll", query = "SELECT g FROM Galinha g"),
    @NamedQuery(name = "Galinha.findByCodGalinha", query = "SELECT g FROM Galinha g WHERE g.codGalinha = :codGalinha"),
    @NamedQuery(name = "Galinha.findByEspecie", query = "SELECT g FROM Galinha g WHERE g.especie = :especie"),
    @NamedQuery(name = "Galinha.findByPeso", query = "SELECT g FROM Galinha g WHERE g.peso = :peso"),
    @NamedQuery(name = "Galinha.findByDataNascimento", query = "SELECT g FROM Galinha g WHERE g.dataNascimento = :dataNascimento")})
public class Galinha implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "COD_GALINHA")
    private BigDecimal codGalinha;
    @Basic(optional = false)
    @Column(name = "ESPECIE")
    private String especie;
    @Column(name = "PESO")
    private Double peso;
    @Column(name = "DATA_NASCIMENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataNascimento;
    @OneToMany(mappedBy = "codGalinha")
    private Collection<Produto> produtoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codGalinha")
    private Collection<Vacinacao> vacinacaoCollection;

    public Galinha() {
    }

    public Galinha(BigDecimal codGalinha) {
        this.codGalinha = codGalinha;
    }

    public Galinha(BigDecimal codGalinha, String especie) {
        this.codGalinha = codGalinha;
        this.especie = especie;
    }

    public BigDecimal getCodGalinha() {
        return codGalinha;
    }

    public void setCodGalinha(BigDecimal codGalinha) {
        this.codGalinha = codGalinha;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public Collection<Produto> getProdutoCollection() {
        return produtoCollection;
    }

    public void setProdutoCollection(Collection<Produto> produtoCollection) {
        this.produtoCollection = produtoCollection;
    }

    public Collection<Vacinacao> getVacinacaoCollection() {
        return vacinacaoCollection;
    }

    public void setVacinacaoCollection(Collection<Vacinacao> vacinacaoCollection) {
        this.vacinacaoCollection = vacinacaoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codGalinha != null ? codGalinha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Galinha)) {
            return false;
        }
        Galinha other = (Galinha) object;
        if ((this.codGalinha == null && other.codGalinha != null) || (this.codGalinha != null && !this.codGalinha.equals(other.codGalinha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "teste.Galinha[ codGalinha=" + codGalinha + " ]";
    }
    
}
