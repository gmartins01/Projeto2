package proj2.bd.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@IdClass(CertificacaoPK.class)
public class Certificacao {
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IDENTIDADECERTIFICADORA", insertable = false, updatable = false)
    private short identidadecertificadora;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IDPRODUTOR")
    private short idprodutor;
    @Basic
    @Column(name = "DATAHORA")
    private Date datahora;
    @ManyToOne
    @JoinColumn(name = "IDENTIDADECERTIFICADORA", referencedColumnName = "IDENTIDADECERTIFICADORA", nullable = false,insertable = false,updatable = false)
    private Entidadecertificadora entidadecertificadoraByIdentidadecertificadora;
    @ManyToOne
    @JoinColumn(name = "IDPRODUTOR", referencedColumnName = "IDPRODUTOR", nullable = false,insertable = false,updatable = false)
    private Produtor produtorByIdprodutor;

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

    public Date getDatahora() {
        return datahora;
    }

    public void setDatahora(Date datahora) {
        this.datahora = datahora;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Certificacao that = (Certificacao) o;

        if (identidadecertificadora != that.identidadecertificadora) return false;
        if (idprodutor != that.idprodutor) return false;
        if (datahora != null ? !datahora.equals(that.datahora) : that.datahora != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) identidadecertificadora;
        result = 31 * result + (int) idprodutor;
        result = 31 * result + (datahora != null ? datahora.hashCode() : 0);
        return result;
    }

    public Entidadecertificadora getEntidadecertificadoraByIdentidadecertificadora() {
        return entidadecertificadoraByIdentidadecertificadora;
    }

    public void setEntidadecertificadoraByIdentidadecertificadora(Entidadecertificadora entidadecertificadoraByIdentidadecertificadora) {
        this.entidadecertificadoraByIdentidadecertificadora = entidadecertificadoraByIdentidadecertificadora;
    }

    public Produtor getProdutorByIdprodutor() {
        return produtorByIdprodutor;
    }

    public void setProdutorByIdprodutor(Produtor produtorByIdprodutor) {
        this.produtorByIdprodutor = produtorByIdprodutor;
    }


}
