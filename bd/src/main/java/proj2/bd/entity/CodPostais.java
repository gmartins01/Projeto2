/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proj2.bd.entity;


import java.io.Serializable;
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
@Table(name = "CODPOSTAIS")
@NamedQueries({
    @NamedQuery(name = "Codpostais.findAll", query = "SELECT c FROM Codpostais c"),
    @NamedQuery(name = "Codpostais.findByCodPostal", query = "SELECT c FROM Codpostais c WHERE c.codPostal = :codPostal"),
    @NamedQuery(name = "Codpostais.findByLocalidade", query = "SELECT c FROM Codpostais c WHERE c.localidade = :localidade")})
public class Codpostais implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "COD_POSTAL")
    private String codPostal;
    @Column(name = "LOCALIDADE")
    private String localidade;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codPostal")
    private Collection<EntidadeCertificadora> entidadeCertificadoraCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codPostal")
    private Collection<Produtor> produtorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codPostal")
    private Collection<Cliente> clienteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codPostal")
    private Collection<Veterinario> veterinarioCollection;

    public Codpostais() {
    }

    public Codpostais(String codPostal) {
        this.codPostal = codPostal;
    }

    public String getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(String codPostal) {
        this.codPostal = codPostal;
    }

    public String getLocalidade() {
        return localidade;
    }

    public void setLocalidade(String localidade) {
        this.localidade = localidade;
    }

    public Collection<EntidadeCertificadora> getEntidadeCertificadoraCollection() {
        return entidadeCertificadoraCollection;
    }

    public void setEntidadeCertificadoraCollection(Collection<EntidadeCertificadora> entidadeCertificadoraCollection) {
        this.entidadeCertificadoraCollection = entidadeCertificadoraCollection;
    }

    public Collection<Produtor> getProdutorCollection() {
        return produtorCollection;
    }

    public void setProdutorCollection(Collection<Produtor> produtorCollection) {
        this.produtorCollection = produtorCollection;
    }

    public Collection<Cliente> getClienteCollection() {
        return clienteCollection;
    }

    public void setClienteCollection(Collection<Cliente> clienteCollection) {
        this.clienteCollection = clienteCollection;
    }

    public Collection<Veterinario> getVeterinarioCollection() {
        return veterinarioCollection;
    }

    public void setVeterinarioCollection(Collection<Veterinario> veterinarioCollection) {
        this.veterinarioCollection = veterinarioCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codPostal != null ? codPostal.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Codpostais)) {
            return false;
        }
        Codpostais other = (Codpostais) object;
        if ((this.codPostal == null && other.codPostal != null) || (this.codPostal != null && !this.codPostal.equals(other.codPostal))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "teste.Codpostais[ codPostal=" + codPostal + " ]";
    }
    
}
