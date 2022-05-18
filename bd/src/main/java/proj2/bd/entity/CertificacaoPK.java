package proj2.bd.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class CertificacaoPK implements Serializable {
    @Column(name = "IDENTIDADECERTIFICADORA")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short identidadecertificadora;
    @Column(name = "IDPRODUTOR")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short idprodutor;

    public short getIdentidadecertificadora() {
        return identidadecertificadora;
    }

    public void setIdentidadecertificadora(short identidadecertificadora) {
        this.identidadecertificadora = identidadecertificadora;
    }

    public short getIdprodutor() {
        return idprodutor;
    }

    public void setIdprodutor(short idprodutor) {
        this.idprodutor = idprodutor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CertificacaoPK that = (CertificacaoPK) o;

        if (identidadecertificadora != that.identidadecertificadora) return false;
        if (idprodutor != that.idprodutor) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) identidadecertificadora;
        result = 31 * result + (int) idprodutor;
        return result;
    }
}
