package proj2.bd.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

@Entity
@Table(name = "VACINA")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Vacina.findAll", query = "SELECT g FROM Vacina g"),
        @NamedQuery(name = "Vacina.findById", query = "SELECT g FROM Vacina g WHERE g.idvacina = :idvacina"),
        @NamedQuery(name = "Vacina.findByNome", query = "SELECT g FROM Vacina g WHERE g.nome = :nome") })
public class Vacina {
    @Id
    @Basic(optional = false)
    @Column(name = "IDVACINA")
    @SequenceGenerator(name="VACINA_SEQ", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "VACINA_SEQ")
    private short idvacina;
    @Basic
    @Column(name = "NOME")
    private String nome;
    @OneToMany(mappedBy = "vacinasByIdvacina")
    private Collection<Vacinacao> vacinacaosByIdvacina;

    public short getIdvacina() {
        return idvacina;
    }

    public void setIdvacina(short idvacina) {
        this.idvacina = idvacina;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Vacina vacina = (Vacina) o;

        if (idvacina != vacina.idvacina) return false;
        if (nome != null ? !nome.equals(vacina.nome) : vacina.nome != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) idvacina;
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        return result;
    }

    public Collection<Vacinacao> getVacinacaosByIdvacina() {
        return vacinacaosByIdvacina;
    }

    public void setVacinacaosByIdvacina(Collection<Vacinacao> vacinacaosByIdvacina) {
        this.vacinacaosByIdvacina = vacinacaosByIdvacina;
    }


}
