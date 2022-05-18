package proj2.bd.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.sql.Date;
import java.util.Collection;

@Entity
@Table(name = "GALINHA")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Galinha.findAll", query = "SELECT g FROM Galinha g"),
        @NamedQuery(name = "Galinha.findAllByCod", query = "SELECT g FROM Galinha g WHERE g.codgalinha = :codgalinha"),
        @NamedQuery(name = "Galinha.findByEspecie", query = "SELECT g FROM Galinha g WHERE g.especie = :especie") })
public class Galinha {
    @Id
    @Basic(optional = false)
    @Column(name = "CODGALINHA")
    @SequenceGenerator(name = "GALINHA_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "GALINHA_SEQ")
    private short codgalinha;
    @Basic
    @Column(name = "ESPECIE")
    private String especie;
    @Basic
    @Column(name = "PESO")
    private short peso;
    @Basic
    @Column(name = "DTNASCIMENTO")
    private Date dtnascimento;
    @OneToMany(mappedBy = "galinhasByCodgalinha")
    private Collection<Vacinacao> vacinacaoByCodgalinha;

    public short getCodgalinha() {
        return codgalinha;
    }

    public void setCodgalinha(short codgalinha) {
        this.codgalinha = codgalinha;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public short getPeso() {
        return peso;
    }

    public void setPeso(short peso) {
        this.peso = peso;
    }

    public Date getDtnascimento() {
        return dtnascimento;
    }

    public void setDtnascimento(Date dtnascimento) {
        this.dtnascimento = dtnascimento;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Galinha galinha = (Galinha) o;

        if (codgalinha != galinha.codgalinha)
            return false;
        if (peso != galinha.peso)
            return false;
        if (especie != null ? !especie.equals(galinha.especie) : galinha.especie != null)
            return false;
        if (dtnascimento != null ? !dtnascimento.equals(galinha.dtnascimento) : galinha.dtnascimento != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) codgalinha;
        result = 31 * result + (especie != null ? especie.hashCode() : 0);
        result = 31 * result + (int) peso;
        result = 31 * result + (dtnascimento != null ? dtnascimento.hashCode() : 0);
        return result;
    }

    public Collection<Vacinacao> getVacinacaosByCodgalinha() {
        return vacinacaoByCodgalinha;
    }

    public void setVacinacaosByCodgalinha(Collection<Vacinacao> vacinacaosByCodgalinha) {
        this.vacinacaoByCodgalinha = vacinacaosByCodgalinha;
    }

    public Collection<Vacinacao> getVacinacaoByCodgalinha() {
        return vacinacaoByCodgalinha;
    }

    public void setVacinacaoByCodgalinha(Collection<Vacinacao> vacinacaoByCodgalinha) {
        this.vacinacaoByCodgalinha = vacinacaoByCodgalinha;
    }
}
