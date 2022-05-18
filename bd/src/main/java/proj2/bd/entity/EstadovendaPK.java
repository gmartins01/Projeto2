package proj2.bd.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class EstadovendaPK implements Serializable {
    @Column(name = "IDVENDA")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short idvenda;
    @Column(name = "IDESTADO")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short idestado;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        EstadovendaPK that = (EstadovendaPK) o;

        if (idvenda != that.idvenda) return false;
        if (idestado != that.idestado) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) idvenda;
        result = 31 * result + (int) idestado;
        return result;
    }
}
