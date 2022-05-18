package proj2.bd.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "ENTIDADECERTIFICADORA")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Entidadecertificadora.findAll", query = "SELECT e FROM Entidadecertificadora e"),
        @NamedQuery(name = "Entidadecertificadora.findAllById", query = "SELECT e FROM Entidadecertificadora e WHERE e.identidadecertificadora = :identidadecertificadora"),
        @NamedQuery(name = "Entidadecertificadora.findByNome", query = "SELECT e FROM Entidadecertificadora e WHERE e.nome = :nome") })
public class Entidadecertificadora {
    @Id
    @Basic(optional = false)
    @Column(name = "IDENTIDADECERTIFICADORA")
    @SequenceGenerator(name = "ENTIDADECERTIFICADORA_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ENTIDADECERTIFICADORA_SEQ")
    private short identidadecertificadora;
    @Basic
    @Column(name = "NOME")
    private String nome;
    @Basic
    @Column(name = "RUA")
    private String rua;
    @Basic
    @Column(name = "NPORTA")
    private String nporta;
    @Basic
    @Column(name = "CODPOSTAL", insertable = false, updatable = false)
    private String codpostal;
    @Basic
    @Column(name = "NIF")
    private int nif;
    @Basic
    @Column(name = "TELEFONE")
    private String telefone;
    @Basic
    @Column(name = "EMAIL")
    private String email;
    @Basic
    @Column(name = "IDUTILIZADOR", insertable = false, updatable = false)
    private short idutilizador;
    @ManyToOne
    @JoinColumn(name = "CODPOSTAL", referencedColumnName = "CODPOSTAL", nullable = false)
    private Codpostais codpostaisByCodpostal;
    @ManyToOne
    @JoinColumn(name = "IDUTILIZADOR", referencedColumnName = "IDUTILIZADOR", nullable = false)
    private Utilizador utilizadorByIdutilizador;

    public short getIdentidadecertificadora() {
        return identidadecertificadora;
    }

    public void setIdentidadecertificadora(short identidadecertificadora) {
        this.identidadecertificadora = identidadecertificadora;
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

    public String getNporta() {
        return nporta;
    }

    public void setNporta(String nporta) {
        this.nporta = nporta;
    }

    public String getCodpostal() {
        return codpostal;
    }

    public void setCodpostal(String codpostal) {
        this.codpostal = codpostal;
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
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

    public short getIdutilizador() {
        return idutilizador;
    }

    public void setIdutilizador(short idutilizador) {
        this.idutilizador = idutilizador;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Entidadecertificadora that = (Entidadecertificadora) o;

        if (identidadecertificadora != that.identidadecertificadora)
            return false;
        if (nif != that.nif)
            return false;
        if (idutilizador != that.idutilizador)
            return false;
        if (nome != null ? !nome.equals(that.nome) : that.nome != null)
            return false;
        if (rua != null ? !rua.equals(that.rua) : that.rua != null)
            return false;
        if (nporta != null ? !nporta.equals(that.nporta) : that.nporta != null)
            return false;
        if (codpostal != null ? !codpostal.equals(that.codpostal) : that.codpostal != null)
            return false;
        if (telefone != null ? !telefone.equals(that.telefone) : that.telefone != null)
            return false;
        if (email != null ? !email.equals(that.email) : that.email != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) identidadecertificadora;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (rua != null ? rua.hashCode() : 0);
        result = 31 * result + (nporta != null ? nporta.hashCode() : 0);
        result = 31 * result + (codpostal != null ? codpostal.hashCode() : 0);
        result = 31 * result + nif;
        result = 31 * result + (telefone != null ? telefone.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (int) idutilizador;
        return result;
    }

    public Utilizador getUtilizadorByIdutilizador() {
        return utilizadorByIdutilizador;
    }

    public void setUtilizadorByIdutilizador(Utilizador utilizadorByIdutilizador) {
        this.utilizadorByIdutilizador = utilizadorByIdutilizador;
    }

    public Codpostais getCodpostaisByCodpostal() {
        return codpostaisByCodpostal;
    }

    public void setCodpostaisByCodpostal(Codpostais codpostaisByCodpostal) {
        this.codpostaisByCodpostal = codpostaisByCodpostal;
    }
}
