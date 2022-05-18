package proj2.bd.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.sql.Date;

@Entity
@Table(name = "LOTEOVOS")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Loteovos.findAll", query = "SELECT l FROM Loteovos l"),
        @NamedQuery(name = "Loteovos.findAllById", query = "SELECT l FROM Loteovos l WHERE l.idloteovos = :idloteovos"),
        @NamedQuery(name = "Loteovos.findByClasse", query = "SELECT l FROM Loteovos l WHERE l.classe = :classe"),
        @NamedQuery(name = "Loteovos.findByDataCriacao", query = "SELECT l FROM Loteovos l WHERE l.datacriacaolote = :datacriacaolote"),
        @NamedQuery(name = "Loteovos.findByDataValidade", query = "SELECT l FROM Loteovos l WHERE l.datavalidadelote = :datavalidadelote"),
})
public class Loteovos {
    @Id
    @Basic(optional = false)
    @Column(name = "IDLOTEOVOS")
    @SequenceGenerator(name = "LOTEOVOS_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "LOTEOVOS_SEQ")
    private short idloteovos;
    @Basic
    @Column(name = "CLASSE")
    private String classe;
    @Basic
    @Column(name = "DATACRIACAOLOTE")
    private Date datacriacaolote;
    @Basic
    @Column(name = "DATAVALIDADELOTE")
    private Date datavalidadelote;

    public short getIdloteovos() {
        return idloteovos;
    }

    public void setIdloteovos(short idloteovos) {
        this.idloteovos = idloteovos;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }

    public Date getDatacriacaolote() {
        return datacriacaolote;
    }

    public void setDatacriacaolote(Date datacriacaolote) {
        this.datacriacaolote = datacriacaolote;
    }

    public Date getDatavalidadelote() {
        return datavalidadelote;
    }

    public void setDatavalidadelote(Date datavalidadelote) {
        this.datavalidadelote = datavalidadelote;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Loteovos loteovos = (Loteovos) o;

        if (idloteovos != loteovos.idloteovos)
            return false;
        if (classe != null ? !classe.equals(loteovos.classe) : loteovos.classe != null)
            return false;
        if (datacriacaolote != null ? !datacriacaolote.equals(loteovos.datacriacaolote)
                : loteovos.datacriacaolote != null)
            return false;
        if (datavalidadelote != null ? !datavalidadelote.equals(loteovos.datavalidadelote)
                : loteovos.datavalidadelote != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) idloteovos;
        result = 31 * result + (classe != null ? classe.hashCode() : 0);
        result = 31 * result + (datacriacaolote != null ? datacriacaolote.hashCode() : 0);
        result = 31 * result + (datavalidadelote != null ? datavalidadelote.hashCode() : 0);
        return result;
    }

}
