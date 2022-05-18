package proj2.bd.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.Collection;

@Entity
@Table(name = "PRODUTOR")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Produtor.findAll", query = "SELECT p FROM Produtor p"),
        @NamedQuery(name = "Produtor.findById", query = "SELECT p FROM Produtor p WHERE p.idprodutor = :idprodutor"),
        @NamedQuery(name = "Produtor.findByNome", query = "SELECT p FROM Produtor p WHERE p.nome = :nome"),
        @NamedQuery(name = "Produtor.findByTelefone", query = "SELECT p FROM Produtor p WHERE p.telefone = :telefone"), })
public class Produtor {
    @Id
    @Basic(optional = false)
    @Column(name = "IDPRODUTOR")
    @SequenceGenerator(name = "PRODUTOR_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUTOR_SEQ")
    private short idprodutor;
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
    @Column(name = "TELEFONE")
    private String telefone;
    @Basic
    @Column(name = "NIF")
    private int nif;
    @Basic
    @Column(name = "CODPOSTAL", insertable = false, updatable = false)
    private String codpostal;
    @Basic
    @Column(name = "EMAIL")
    private String email;
    @Basic
    @Column(name = "IDUTILIZADOR", insertable = false, updatable = false)
    private short idutilizador;
    @ManyToOne
    @JoinColumn(name = "IDUTILIZADOR", referencedColumnName = "IDUTILIZADOR", nullable = false)
    private Utilizador utilizadorByIdutilizador;
    @ManyToOne
    @JoinColumn(name = "CODPOSTAL", referencedColumnName = "CODPOSTAL", nullable = false)
    private Codpostais codpostaisByCodpostal; // Adicionei
    @OneToMany(mappedBy = "produtorByIdprodutor")
    private Collection<Racao> racaosByIdprodutor;

    public short getIdprodutor() {
        return idprodutor;
    }

    public void setIdprodutor(short idprodutor) {
        this.idprodutor = idprodutor;
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
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Produtor produtor = (Produtor) o;

        if (idprodutor != produtor.idprodutor)
            return false;
        if (nif != produtor.nif)
            return false;
        if (idutilizador != produtor.idutilizador)
            return false;
        if (nome != null ? !nome.equals(produtor.nome) : produtor.nome != null)
            return false;
        if (rua != null ? !rua.equals(produtor.rua) : produtor.rua != null)
            return false;
        if (nporta != null ? !nporta.equals(produtor.nporta) : produtor.nporta != null)
            return false;
        if (telefone != null ? !telefone.equals(produtor.telefone) : produtor.telefone != null)
            return false;
        if (codpostal != null ? !codpostal.equals(produtor.codpostal) : produtor.codpostal != null)
            return false;
        if (email != null ? !email.equals(produtor.email) : produtor.email != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) idprodutor;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (rua != null ? rua.hashCode() : 0);
        result = 31 * result + (nporta != null ? nporta.hashCode() : 0);
        result = 31 * result + (telefone != null ? telefone.hashCode() : 0);
        result = 31 * result + nif;
        result = 31 * result + (codpostal != null ? codpostal.hashCode() : 0);
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

    public Collection<Racao> getRacaosByIdprodutor() {
        return racaosByIdprodutor;
    }

    public void setRacaosByIdprodutor(Collection<Racao> racaosByIdprodutor) {
        this.racaosByIdprodutor = racaosByIdprodutor;
    }

    public Codpostais getCodpostaisByCodpostal() {
        return codpostaisByCodpostal;
    }

    public void setCodpostaisByCodpostal(Codpostais codpostaisByCodpostal) {
        this.codpostaisByCodpostal = codpostaisByCodpostal;
    }
}
