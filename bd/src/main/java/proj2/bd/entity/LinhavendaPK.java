package proj2.bd.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class LinhavendaPK implements Serializable {
    @Column(name = "IDVENDA")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short idvenda;
    @Column(name = "IDPRODUTO")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short idproduto;

    public short getIdvenda() {
        return idvenda;
    }

    public void setIdvenda(short idvenda) {
        this.idvenda = idvenda;
    }

    public short getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(short idproduto) {
        this.idproduto = idproduto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LinhavendaPK that = (LinhavendaPK) o;

        if (idvenda != that.idvenda) return false;
        if (idproduto != that.idproduto) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) idvenda;
        result = 31 * result + (int) idproduto;
        return result;
    }
}
