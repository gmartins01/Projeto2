/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proj2.bd.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.*;

/**
 *
 * @author gonca
 */
@Entity
@Table(name = "CLIENTE")
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByIdCliente", query = "SELECT c FROM Cliente c WHERE c.idCliente = :idCliente"),
    @NamedQuery(name = "Cliente.findByNome", query = "SELECT c FROM Cliente c WHERE c.nome = :nome"),
    @NamedQuery(name = "Cliente.findByDataNascimento", query = "SELECT c FROM Cliente c WHERE c.dataNascimento = :dataNascimento"),
    @NamedQuery(name = "Cliente.findByRua", query = "SELECT c FROM Cliente c WHERE c.rua = :rua"),
    @NamedQuery(name = "Cliente.findByNumPorta", query = "SELECT c FROM Cliente c WHERE c.numPorta = :numPorta"),
    @NamedQuery(name = "Cliente.findByTelefone", query = "SELECT c FROM Cliente c WHERE c.telefone = :telefone"),
    @NamedQuery(name = "Cliente.findByNif", query = "SELECT c FROM Cliente c WHERE c.nif = :nif"),
    @NamedQuery(name = "Cliente.findByEmail", query = "SELECT c FROM Cliente c WHERE c.email = :email")})
public class Cliente implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_CLIENTE")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private BigDecimal idCliente;
    @Basic(optional = false)
    @Column(name = "NOME")
    private String nome;
    @Basic(optional = false)
    @Column(name = "DATA_NASCIMENTO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataNascimento;
    @Column(name = "RUA")
    private String rua;
    @Column(name = "NUM_PORTA")
    private String numPorta;
    @Column(name = "TELEFONE")
    private String telefone;
    @Column(name = "NIF")
    private Long nif;
    @Basic(optional = false)
    @Column(name = "EMAIL")
    private String email;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCliente")
    private Collection<Venda> vendaCollection;
    @JoinColumn(name = "COD_POSTAL", referencedColumnName = "COD_POSTAL")
    @ManyToOne(optional = false)
    private Codpostais codPostal;
    @JoinColumn(name = "ID_UTILIZADOR", referencedColumnName = "ID_UTILIZADOR")
    @ManyToOne(optional = false)
    private Utilizador idUtilizador;

    public Cliente() {
    }

    public Cliente(BigDecimal idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente(BigDecimal idCliente, String nome, Date dataNascimento, String email) {
        this.idCliente = idCliente;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.email = email;
    }

    public BigDecimal getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(BigDecimal idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
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

    public Collection<Venda> getVendaCollection() {
        return vendaCollection;
    }

    public void setVendaCollection(Collection<Venda> vendaCollection) {
        this.vendaCollection = vendaCollection;
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
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "teste.Cliente[ idCliente=" + idCliente + " ]";
    }
    
}
