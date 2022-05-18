package proj2.bd.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "CLIENTE")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
        @NamedQuery(name = "Cliente.findAllByNome", query = "SELECT c FROM Cliente c WHERE c.nome LIKE :nome"),
        @NamedQuery(name = "Cliente.findAllById", query = "SELECT c FROM Cliente c WHERE c.idcliente = :idcliente"),
        @NamedQuery(name = "Cliente.findAllByCodigo", query = "SELECT c FROM Cliente c WHERE c.codpostal LIKE :codpostal")})
public class Cliente {

    @Id
    @Basic(optional = false)
    @Column(name = "IDCLIENTE")
    @SequenceGenerator(name="CLIENTE_SEQ", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "CLIENTE_SEQ")
    private short idcliente;
    @Basic
    @Column(name = "NOME")
    private String nome;
    @Basic
    @Column(name = "DTNASCIMENTO")
    private Date dtnascimento;
    @Basic
    @Column(name = "RUA")
    private String rua;
    @Basic
    @Column(name = "NPORTA")
    private String nporta;
    @Basic
    @Column(name = "TELEFONE")
    private String telefone;
    @Basic
    @Column(name = "NIF")
    private int nif;
    @Basic
    @Column(name = "CODPOSTAL", insertable = false, updatable = false, nullable = false)
    private String codpostal;
    @ManyToOne
    @JoinColumn(name = "CODPOSTAL", referencedColumnName = "CODPOSTAL", nullable = false)
    private Codpostais codpostaisByCodpostal;
    @Basic
    @Column(name = "EMAIL")
    private String email;
    @Basic
    @Column(name = "IDUTILIZADOR", insertable = false, updatable = false)
    private short idutilizador;
    @ManyToOne
    @JoinColumn(name = "IDUTILIZADOR", referencedColumnName = "IDUTILIZADOR", nullable = false)
    private Utilizador utilizadorByIdutilizador;
    @OneToMany(mappedBy = "clientesByIdcliente")
    private Collection<Venda> vendasByIdcliente;

    public short getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(short idcliente) {
        this.idcliente = idcliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDtnascimento() {
        return dtnascimento;
    }

    public void setDtnascimento(Date dtnascimento) {
        this.dtnascimento = dtnascimento;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNporta() {
        return nporta;
    }

    public void setNporta(String nporta) {
        this.nporta = nporta;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public String getCodpostal() {
        return codpostal;
    }

    public void setCodpostal(String codpostal) {
        this.codpostal = codpostal;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public short getIdutilizador() {
        return idutilizador;
    }

    public void setIdutilizador(short idutilizador) {
        this.idutilizador = idutilizador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Cliente cliente = (Cliente) o;

        if (idcliente != cliente.idcliente) return false;
        if (nif != cliente.nif) return false;
        if (idutilizador != cliente.idutilizador) return false;
        if (nome != null ? !nome.equals(cliente.nome) : cliente.nome != null) return false;
        if (dtnascimento != null ? !dtnascimento.equals(cliente.dtnascimento) : cliente.dtnascimento != null)
            return false;
        if (rua != null ? !rua.equals(cliente.rua) : cliente.rua != null) return false;
        if (nporta != null ? !nporta.equals(cliente.nporta) : cliente.nporta != null) return false;
        if (telefone != null ? !telefone.equals(cliente.telefone) : cliente.telefone != null) return false;
        if (codpostal != null ? !codpostal.equals(cliente.codpostal) : cliente.codpostal != null) return false;
        if (email != null ? !email.equals(cliente.email) : cliente.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) idcliente;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (dtnascimento != null ? dtnascimento.hashCode() : 0);
        result = 31 * result + (rua != null ? rua.hashCode() : 0);
        result = 31 * result + (nporta != null ? nporta.hashCode() : 0);
        result = 31 * result + (telefone != null ? telefone.hashCode() : 0);
        result = 31 * result + nif;
        result = 31 * result + (codpostal != null ? codpostal.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (int) idutilizador;
        return result;
    }

    public Codpostais getCodpostaisByCodpostal() {
        return codpostaisByCodpostal;
    }

    public void setCodpostaisByCodpostal(Codpostais codpostaisByCodpostal) {
        this.codpostaisByCodpostal = codpostaisByCodpostal;
    }

    public Utilizador getUtilizadorByIdutilizador() {
        return utilizadorByIdutilizador;
    }

    public void setUtilizadorByIdutilizador(Utilizador utilizadorByIdutilizador) {
        this.utilizadorByIdutilizador = utilizadorByIdutilizador;
    }

    public Collection<Venda> getVendasByIdcliente() {
        return vendasByIdcliente;
    }

    public void setVendasByIdcliente(Collection<Venda> vendasByIdcliente) {
        this.vendasByIdcliente = vendasByIdcliente;
    }

    @Override
    public String toString() {
        return "javaapplication119.DAL.Cliente[ Cliente =" + nome + " codpostal=" + codpostal + "]";
    }

}
