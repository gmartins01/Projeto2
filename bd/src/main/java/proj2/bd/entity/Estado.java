package proj2.bd.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.Collection;

@Entity
@Table(name = "ESTADO")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Estado.findAll", query = "SELECT e FROM Estado e"),
        @NamedQuery(name = "Estado.findAllById", query = "SELECT e FROM Estado e WHERE e.idestado = :idestado"),
        @NamedQuery(name = "Estado.findByNome", query = "SELECT e FROM Estado e WHERE e.descricao = :descricao") })
public class Estado {
    @Id
    @Basic(optional = false)
    @Column(name = "IDESTADO")
    @SequenceGenerator(name = "ESTADO_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ESTADO_SEQ")
    private short idestado;
    @Basic
    @Column(name = "DESCRICAO")
    private String descricao;
    @OneToMany(mappedBy = "estadosByIdestado") // Adicionei
    private Collection<Estadovenda> estadovendasByEstado;

    public short getIdestado() {
        return idestado;
    }

    public void setIdestado(short idestado) {
        this.idestado = idestado;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Estado estado = (Estado) o;

        if (idestado != estado.idestado)
            return false;
        if (descricao != null ? !descricao.equals(estado.descricao) : estado.descricao != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) idestado;
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        return result;
    }

    public Collection<Estadovenda> getEstadovendasByEstado() {
        return estadovendasByEstado;
    }

    public void setEstadovendasByEstado(Collection<Estadovenda> estadovendasByEstado) {
        this.estadovendasByEstado = estadovendasByEstado;
    }
}
