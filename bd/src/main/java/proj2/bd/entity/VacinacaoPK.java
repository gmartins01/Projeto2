package proj2.bd.entity;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

public class VacinacaoPK implements Serializable {
    @Column(name = "IDVACINA")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short idvacina;
    @Column(name = "IDVETERINARIO")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short idveterinario;
    @Column(name = "CODGALINHA")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short codgalinha;

    public short getIdvacina() {
        return idvacina;
    }

    public void setIdvacina(short idvacina) {
        this.idvacina = idvacina;
    }

    public short getIdveterinario() {
        return idveterinario;
    }

    public void setIdveterinario(short idveterinario) {
        this.idveterinario = idveterinario;
    }

    public short getCodgalinha() {
        return codgalinha;
    }

    public void setCodgalinha(short codgalinha) {
        this.codgalinha = codgalinha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VacinacaoPK that = (VacinacaoPK) o;

        if (idvacina != that.idvacina) return false;
        if (idveterinario != that.idveterinario) return false;
        if (codgalinha != that.codgalinha) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) idvacina;
        result = 31 * result + (int) idveterinario;
        result = 31 * result + (int) codgalinha;
        return result;
    }
}
