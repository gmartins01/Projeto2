/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proj2.bd.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author gonca
 */
@Entity
@Table(name = "VACINA")
@NamedQueries({
    @NamedQuery(name = "Vacina.findAll", query = "SELECT v FROM Vacina v"),
    @NamedQuery(name = "Vacina.findByIdVacina", query = "SELECT v FROM Vacina v WHERE v.idVacina = :idVacina"),
    @NamedQuery(name = "Vacina.findByNome", query = "SELECT v FROM Vacina v WHERE v.nome = :nome")})
public class Vacina implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_VACINA")
    private BigDecimal idVacina;
    @Basic(optional = false)
    @Column(name = "NOME")
    private String nome;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVacina")
    private Collection<Vacinacao> vacinacaoCollection;

    public Vacina() {
    }

    public Vacina(BigDecimal idVacina) {
        this.idVacina = idVacina;
    }

    public Vacina(BigDecimal idVacina, String nome) {
        this.idVacina = idVacina;
        this.nome = nome;
    }

    public BigDecimal getIdVacina() {
        return idVacina;
    }

    public void setIdVacina(BigDecimal idVacina) {
        this.idVacina = idVacina;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
        hash += (idVacina != null ? idVacina.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vacina)) {
            return false;
        }
        Vacina other = (Vacina) object;
        if ((this.idVacina == null && other.idVacina != null) || (this.idVacina != null && !this.idVacina.equals(other.idVacina))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "teste.Vacina[ idVacina=" + idVacina + " ]";
    }
    
}
