/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proj2.bd.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.*;

/**
 *
 * @author gonca
 */
@Entity
@Table(name = "UTILIZADOR")
@NamedQueries({
    @NamedQuery(name = "Utilizador.findAll", query = "SELECT u FROM Utilizador u"),
    @NamedQuery(name = "Utilizador.findByIdUtilizador", query = "SELECT u FROM Utilizador u WHERE u.idUtilizador = :idUtilizador"),
    @NamedQuery(name = "Utilizador.findByUsername", query = "SELECT u FROM Utilizador u WHERE u.username = :username"),
    @NamedQuery(name = "Utilizador.findByPassword", query = "SELECT u FROM Utilizador u WHERE u.password = :password"),
    @NamedQuery(name = "Utilizador.findByTipo", query = "SELECT u FROM Utilizador u WHERE u.tipo = :tipo"),
    @NamedQuery(name = "Utilizador.findByVerificado", query = "SELECT u FROM Utilizador u WHERE u.verificado = :verificado")})
public class Utilizador implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_UTILIZADOR")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private BigDecimal idUtilizador;
    @Basic(optional = false)
    @Column(name = "USERNAME")
    private String username;
    @Basic(optional = false)
    @Column(name = "PASSWORD")
    private String password;
    @Basic(optional = false)
    @Column(name = "TIPO")
    private String tipo;
    @Basic(optional = false)
    @Column(name = "VERIFICADO")
    private short verificado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUtilizador")
    private Collection<EntidadeCertificadora> entidadeCertificadoraCollection;
    @OneToMany(mappedBy = "idUtilizador")
    private Collection<Produtor> produtorCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUtilizador")
    private Collection<Cliente> clienteCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idUtilizador")
    private Collection<Veterinario> veterinarioCollection;

    public Utilizador() {
    }

    public Utilizador(BigDecimal idUtilizador) {
        this.idUtilizador = idUtilizador;
    }

    public Utilizador(BigDecimal idUtilizador, String username, String password, String tipo, short verificado) {
        this.idUtilizador = idUtilizador;
        this.username = username;
        this.password = password;
        this.tipo = tipo;
        this.verificado = verificado;
    }

    public BigDecimal getIdUtilizador() {
        return idUtilizador;
    }

    public void setIdUtilizador(BigDecimal idUtilizador) {
        this.idUtilizador = idUtilizador;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public short getVerificado() {
        return verificado;
    }

    public void setVerificado(short verificado) {
        this.verificado = verificado;
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
        hash += (idUtilizador != null ? idUtilizador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Utilizador)) {
            return false;
        }
        Utilizador other = (Utilizador) object;
        if ((this.idUtilizador == null && other.idUtilizador != null) || (this.idUtilizador != null && !this.idUtilizador.equals(other.idUtilizador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "teste.Utilizador[ idUtilizador=" + idUtilizador + " ]";
    }
    
}
