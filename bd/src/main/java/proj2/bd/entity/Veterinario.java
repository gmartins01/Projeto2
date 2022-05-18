package proj2.bd.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "VETERINARIO")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Veterinario.findAll", query = "SELECT g FROM Veterinario g"),
        @NamedQuery(name = "Veterinario.findAllById", query = "SELECT g FROM Veterinario g WHERE g.idveterinario = :idveterinario"),
        @NamedQuery(name = "Veterinario.findByNome", query = "SELECT g FROM Veterinario g WHERE g.nome = :nome") })
public class Veterinario {
    @Id
    @Basic(optional = false)
    @Column(name = "IDVETERINARIO")
    @SequenceGenerator(name="VETERINARIO_SEQ", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "VETERINARIO_SEQ")
    private short idveterinario;
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
    @Column(name = "DTNASCIMENTO")
    private Date dtnascimento;
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
    private Codpostais codpostaisByCodpostal; //Adicionei
    @ManyToOne //Adicionei
    @JoinColumn(name = "IDUTILIZADOR", referencedColumnName = "IDUTILIZADOR", nullable = false)
    private Utilizador utilizadorByIdutilizador;
    @OneToMany(mappedBy = "veterinariosByIdveterinario") //Adicionei
    private Collection<Vacinacao> vacinacaoByIdveterinario;

    public short getIdveterinario() {
        return idveterinario;
    }

    public void setIdveterinario(short idveterinario) {
        this.idveterinario = idveterinario;
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

    public Date getDtnascimento() {
        return dtnascimento;
    }

    public void setDtnascimento(Date dtnascimento) {
        this.dtnascimento = dtnascimento;
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
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Veterinario that = (Veterinario) o;

        if (idveterinario != that.idveterinario) return false;
        if (nif != that.nif) return false;
        if (idutilizador != that.idutilizador) return false;
        if (nome != null ? !nome.equals(that.nome) : that.nome != null) return false;
        if (rua != null ? !rua.equals(that.rua) : that.rua != null) return false;
        if (nporta != null ? !nporta.equals(that.nporta) : that.nporta != null) return false;
        if (codpostal != null ? !codpostal.equals(that.codpostal) : that.codpostal != null) return false;
        if (dtnascimento != null ? !dtnascimento.equals(that.dtnascimento) : that.dtnascimento != null) return false;
        if (telefone != null ? !telefone.equals(that.telefone) : that.telefone != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) idveterinario;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + (rua != null ? rua.hashCode() : 0);
        result = 31 * result + (nporta != null ? nporta.hashCode() : 0);
        result = 31 * result + (codpostal != null ? codpostal.hashCode() : 0);
        result = 31 * result + (dtnascimento != null ? dtnascimento.hashCode() : 0);
        result = 31 * result + nif;
        result = 31 * result + (telefone != null ? telefone.hashCode() : 0);
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

    public Collection<Vacinacao> getVacinacaoByIdveterinario() {
        return vacinacaoByIdveterinario;
    }

    public void setVacinacaoByIdveterinario(Collection<Vacinacao> vacinacaoByIdveterinario) {
        this.vacinacaoByIdveterinario = vacinacaoByIdveterinario;
    }
}
