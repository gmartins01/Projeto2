package proj2.bd.entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@IdClass(VacinacaoPK.class)
public class Vacinacao {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IDVACINA", insertable = false, updatable = false)
    private short idvacina;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IDVETERINARIO", insertable = false, updatable = false)
    private short idveterinario;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "CODGALINHA", insertable = false, updatable = false)
    private short codgalinha;
    @Basic
    @Column(name = "DATAHORA")
    private Date datahora;
    @ManyToOne
    @JoinColumn(name = "IDVACINA", referencedColumnName = "IDVACINA", nullable = false, insertable = false, updatable = false)
    private Vacina vacinasByIdvacina;
    @ManyToOne
    @JoinColumn(name = "IDVETERINARIO", referencedColumnName = "IDVETERINARIO", nullable = false, insertable = false, updatable = false)
    private Veterinario veterinariosByIdveterinario;
    @ManyToOne
    @JoinColumn(name = "CODGALINHA", referencedColumnName = "CODGALINHA", nullable = false, insertable = false, updatable = false)
    private Galinha galinhasByCodgalinha;


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

        Vacinacao vacinacao = (Vacinacao) o;

        if (idvacina != vacinacao.idvacina) return false;
        if (idveterinario != vacinacao.idveterinario) return false;
        if (codgalinha != vacinacao.codgalinha) return false;
        if (datahora != null ? !datahora.equals(vacinacao.datahora) : vacinacao.datahora != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) idvacina;
        result = 31 * result + (int) idveterinario;
        result = 31 * result + (int) codgalinha;
        result = 31 * result + (datahora != null ? datahora.hashCode() : 0);
        return result;
    }

    public Veterinario getVeterinarioByIdveterinario() {
        return veterinariosByIdveterinario;
    }

    public void setVeterinarioByIdveterinario(Veterinario veterinarioByIdveterinario) {
        this.veterinariosByIdveterinario = veterinarioByIdveterinario;
    }

    public Vacina getVacinasByIdvacina() {
        return vacinasByIdvacina;
    }

    public void setVacinasByIdvacina(Vacina vacinasByIdvacina) {
        this.vacinasByIdvacina = vacinasByIdvacina;
    }

    public Veterinario getVeterinariosByIdveterinario() {
        return veterinariosByIdveterinario;
    }

    public void setVeterinariosByIdveterinario(Veterinario veterinariosByIdveterinario) {
        this.veterinariosByIdveterinario = veterinariosByIdveterinario;
    }

    public Galinha getGalinhasByCodgalinha() {
        return galinhasByCodgalinha;
    }

    public void setGalinhasByCodgalinha(Galinha galinhasByCodgalinha) {
        this.galinhasByCodgalinha = galinhasByCodgalinha;
    }
}
