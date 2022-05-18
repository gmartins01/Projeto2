package proj2.bd.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@IdClass(EstadovendaPK.class)
public class Estadovenda {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IDVENDA", insertable = false, updatable = false)
    private short idvenda;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IDESTADO", insertable = false, updatable = false)
    private short idestado;
    @Basic
    @Column(name = "DATA")
    private Date data;
    @ManyToOne
    @JoinColumn(name = "IDVENDA", referencedColumnName = "IDVENDA", nullable = false, insertable = false, updatable = false)
    private Venda vendaByIdvenda;
    @ManyToOne
    @JoinColumn(name = "IDESTADO", referencedColumnName = "IDESTADO", nullable = false, insertable = false, updatable = false)
    private Estado estadosByIdestado;

    public short getIdvenda() {
        return idvenda;
    }

    public void setIdvenda(short idvenda) {
        this.idvenda = idvenda;
    }

    public short getIdestado() {
        return idestado;
    }

    public void setIdestado(short idestado) {
        this.idestado = idestado;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Estadovenda that = (Estadovenda) o;

        if (idvenda != that.idvenda) return false;
        if (idestado != that.idestado) return false;
        if (data != null ? !data.equals(that.data) : that.data != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) idvenda;
        result = 31 * result + (int) idestado;
        result = 31 * result + (data != null ? data.hashCode() : 0);
        return result;
    }

    public Venda getVendaByIdvenda() {
        return vendaByIdvenda;
    }

    public void setVendaByIdvenda(Venda vendaByIdvenda) {
        this.vendaByIdvenda = vendaByIdvenda;
    }

    public Estado getEstadoByIdestado() {
        return estadosByIdestado;
    }

    public void setEstadoByIdestado(Estado estadoByIdestado) {
        this.estadosByIdestado = estadoByIdestado;
    }

    public Estado getEstadosByIdestado() {
        return estadosByIdestado;
    }

    public void setEstadosByIdestado(Estado estadosByIdestado) {
        this.estadosByIdestado = estadosByIdestado;
    }
}
