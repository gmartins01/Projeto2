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
@Table(name = "ENTIDADE_CERTIFICADORA")
@NamedQueries({
    @NamedQuery(name = "EntidadeCertificadora.findAll", query = "SELECT e FROM EntidadeCertificadora e"),
    @NamedQuery(name = "EntidadeCertificadora.findByIdEntidade", query = "SELECT e FROM EntidadeCertificadora e WHERE e.idEntidade = :idEntidade"),
    @NamedQuery(name = "EntidadeCertificadora.findByNome", query = "SELECT e FROM EntidadeCertificadora e WHERE e.nome = :nome"),
    @NamedQuery(name = "EntidadeCertificadora.findByRua", query = "SELECT e FROM EntidadeCertificadora e WHERE e.rua = :rua"),
    @NamedQuery(name = "EntidadeCertificadora.findByNumPorta", query = "SELECT e FROM EntidadeCertificadora e WHERE e.numPorta = :numPorta"),
    @NamedQuery(name = "EntidadeCertificadora.findByNif", query = "SELECT e FROM EntidadeCertificadora e WHERE e.nif = :nif"),
    @NamedQuery(name = "EntidadeCertificadora.findByTelefone", query = "SELECT e FROM EntidadeCertificadora e WHERE e.telefone = :telefone"),
    @NamedQuery(name = "EntidadeCertificadora.findByEmail", query = "SELECT e FROM EntidadeCertificadora e WHERE e.email = :email")})
public class EntidadeCertificadora implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_ENTIDADE")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private BigDecimal idEntidade;
    @Basic(optional = false)
    @Column(name = "NOME")
    private String nome;
    @Column(name = "RUA")
    private String rua;
    @Column(name = "NUM_PORTA")
    private String numPorta;
    @Column(name = "NIF")
    private Long nif;
    @Basic(optional = false)
    @Column(name = "TELEFONE")
    private String telefone;
    @Basic(optional = false)
    @Column(name = "EMAIL")
    private String email;
    @JoinColumn(name = "COD_POSTAL", referencedColumnName = "COD_POSTAL")
    @ManyToOne(optional = false)
    private Codpostais codPostal;
    @JoinColumn(name = "ID_UTILIZADOR", referencedColumnName = "ID_UTILIZADOR")
    @ManyToOne(optional = false)
    private Utilizador idUtilizador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idEntidade")
    private Collection<Certificacao> certificacaoCollection;

    public EntidadeCertificadora() {
    }

    public EntidadeCertificadora(BigDecimal idEntidade) {
        this.idEntidade = idEntidade;
    }

    public EntidadeCertificadora(BigDecimal idEntidade, String nome, String telefone, String email) {
        this.idEntidade = idEntidade;
        this.nome = nome;
        this.telefone = telefone;
        this.email = email;
    }

    public BigDecimal getIdEntidade() {
        return idEntidade;
    }

    public void setIdEntidade(BigDecimal idEntidade) {
        this.idEntidade = idEntidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumPorta() {
        return numPorta;
    }

    public void setNumPorta(String numPorta) {
        this.numPorta = numPorta;
    }

    public Long getNif() {
        return nif;
    }

    public void setNif(Long nif) {
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

    public Collection<Certificacao> getCertificacaoCollection() {
        return certificacaoCollection;
    }

    public void setCertificacaoCollection(Collection<Certificacao> certificacaoCollection) {
        this.certificacaoCollection = certificacaoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEntidade != null ? idEntidade.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntidadeCertificadora)) {
            return false;
        }
        EntidadeCertificadora other = (EntidadeCertificadora) object;
        if ((this.idEntidade == null && other.idEntidade != null) || (this.idEntidade != null && !this.idEntidade.equals(other.idEntidade))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "teste.EntidadeCertificadora[ idEntidade=" + idEntidade + " ]";
    }
    
}
