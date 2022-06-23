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
@Table(name = "VETERINARIO")
@NamedQueries({
    @NamedQuery(name = "Veterinario.findAll", query = "SELECT v FROM Veterinario v"),
    @NamedQuery(name = "Veterinario.findByIdVeterinario", query = "SELECT v FROM Veterinario v WHERE v.idVeterinario = :idVeterinario"),
    @NamedQuery(name = "Veterinario.findByNome", query = "SELECT v FROM Veterinario v WHERE v.nome = :nome"),
    @NamedQuery(name = "Veterinario.findByNumPorta", query = "SELECT v FROM Veterinario v WHERE v.numPorta = :numPorta"),
    @NamedQuery(name = "Veterinario.findByRua", query = "SELECT v FROM Veterinario v WHERE v.rua = :rua"),
    @NamedQuery(name = "Veterinario.findByNif", query = "SELECT v FROM Veterinario v WHERE v.nif = :nif"),
    @NamedQuery(name = "Veterinario.findByTelefone", query = "SELECT v FROM Veterinario v WHERE v.telefone = :telefone"),
    @NamedQuery(name = "Veterinario.findByEmail", query = "SELECT v FROM Veterinario v WHERE v.email = :email")})
public class Veterinario implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_VETERINARIO")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private BigDecimal idVeterinario;
    @Basic(optional = false)
    @Column(name = "NOME")
    private String nome;
    @Column(name = "NUM_PORTA")
    private String numPorta;
    @Column(name = "RUA")
    private String rua;
    @Basic(optional = false)
    @Column(name = "NIF")
    private long nif;
    @Basic(optional = false)
    @Column(name = "TELEFONE")
    private String telefone;
    @Basic(optional = false)
    @Column(name = "EMAIL")
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVeterinario")
    private Collection<Vacinacao> vacinacaoCollection;
    @JoinColumn(name = "COD_POSTAL", referencedColumnName = "COD_POSTAL")
    @ManyToOne(optional = false)
    private Codpostais codPostal;
    @JoinColumn(name = "ID_UTILIZADOR", referencedColumnName = "ID_UTILIZADOR")
    @ManyToOne(optional = false)
    private Utilizador idUtilizador;

    public Veterinario() {
    }

    public Veterinario(BigDecimal idVeterinario) {
        this.idVeterinario = idVeterinario;
    }

    public Veterinario(BigDecimal idVeterinario, String nome, long nif, String telefone, String email) {
        this.idVeterinario = idVeterinario;
        this.nome = nome;
        this.nif = nif;
        this.telefone = telefone;
        this.email = email;
    }

    public BigDecimal getIdVeterinario() {
        return idVeterinario;
    }

    public void setIdVeterinario(BigDecimal idVeterinario) {
        this.idVeterinario = idVeterinario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNumPorta() {
        return numPorta;
    }

    public void setNumPorta(String numPorta) {
        this.numPorta = numPorta;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public long getNif() {
        return nif;
    }

    public void setNif(long nif) {
        this.nif = nif;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<Vacinacao> getVacinacaoCollection() {
        return vacinacaoCollection;
    }

    public void setVacinacaoCollection(Collection<Vacinacao> vacinacaoCollection) {
        this.vacinacaoCollection = vacinacaoCollection;
    }

    public Codpostais getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(Codpostais codPostal) {
        this.codPostal = codPostal;
    }

    public Utilizador getIdUtilizador() {
        return idUtilizador;
    }

    public void setIdUtilizador(Utilizador idUtilizador) {
        this.idUtilizador = idUtilizador;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVeterinario != null ? idVeterinario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Veterinario)) {
            return false;
        }
        Veterinario other = (Veterinario) object;
        if ((this.idVeterinario == null && other.idVeterinario != null) || (this.idVeterinario != null && !this.idVeterinario.equals(other.idVeterinario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "teste.Veterinario[ idVeterinario=" + idVeterinario + " ]";
    }
    
}
