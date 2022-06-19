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
@Table(name = "PRODUTOR")
@NamedQueries({
    @NamedQuery(name = "Produtor.findAll", query = "SELECT p FROM Produtor p"),
    @NamedQuery(name = "Produtor.findByIdProdutor", query = "SELECT p FROM Produtor p WHERE p.idProdutor = :idProdutor"),
    @NamedQuery(name = "Produtor.findByNome", query = "SELECT p FROM Produtor p WHERE p.nome = :nome"),
    @NamedQuery(name = "Produtor.findByRua", query = "SELECT p FROM Produtor p WHERE p.rua = :rua"),
    @NamedQuery(name = "Produtor.findByNumPorta", query = "SELECT p FROM Produtor p WHERE p.numPorta = :numPorta"),
    @NamedQuery(name = "Produtor.findByTelefone", query = "SELECT p FROM Produtor p WHERE p.telefone = :telefone"),
    @NamedQuery(name = "Produtor.findByNif", query = "SELECT p FROM Produtor p WHERE p.nif = :nif"),
    @NamedQuery(name = "Produtor.findByEmail", query = "SELECT p FROM Produtor p WHERE p.email = :email")})
public class Produtor implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_PRODUTOR")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private BigDecimal idProdutor;
    @Basic(optional = false)
    @Column(name = "NOME")
    private String nome;
    @Column(name = "RUA")
    private String rua;
    @Column(name = "NUM_PORTA")
    private String numPorta;
    @Basic(optional = false)
    @Column(name = "TELEFONE")
    private String telefone;
    @Column(name = "NIF")
    private Long nif;
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "ID_UTILIZADOR",insertable = false, updatable = false)
    private BigDecimal idUser;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProdutor")
    private Collection<Produto> produtoCollection;
    @JoinColumn(name = "COD_POSTAL", referencedColumnName = "COD_POSTAL")
    @ManyToOne(optional = false)
    private Codpostais codPostal;
    @JoinColumn(name = "ID_UTILIZADOR", referencedColumnName = "ID_UTILIZADOR")
    @ManyToOne
    private Utilizador idUtilizador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProdutor")
    private Collection<Certificacao> certificacaoCollection;

    public Produtor() {
    }

    public Produtor(BigDecimal idProdutor) {
        this.idProdutor = idProdutor;
    }

    public Produtor(BigDecimal idProdutor, String nome, String telefone) {
        this.idProdutor = idProdutor;
        this.nome = nome;
        this.telefone = telefone;
    }

    public BigDecimal getIdProdutor() {
        return idProdutor;
    }

    public void setIdProdutor(BigDecimal idProdutor) {
        this.idProdutor = idProdutor;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public Long getNif() {
        return nif;
    }

    public void setNif(Long nif) {
        this.nif = nif;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigDecimal getIdUser() {
        return idUser;
    }

    public void setIdUser(BigDecimal idUser) {
        this.idUser = idUser;
    }

    public Collection<Produto> getProdutoCollection() {
        return produtoCollection;
    }

    public void setProdutoCollection(Collection<Produto> produtoCollection) {
        this.produtoCollection = produtoCollection;
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
        hash += (idProdutor != null ? idProdutor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Produtor)) {
            return false;
        }
        Produtor other = (Produtor) object;
        if ((this.idProdutor == null && other.idProdutor != null) || (this.idProdutor != null && !this.idProdutor.equals(other.idProdutor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "teste.Produtor[ idProdutor=" + idProdutor + " ]";
    }
    
}
