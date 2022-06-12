package proj2.bd.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

@Entity
@Table(name = "CODPOSTAIS")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Codpostais.findAll", query = "SELECT c FROM Codpostais c"),
        @NamedQuery(name = "Codpostais.findAllByCodigo", query = "SELECT c FROM Codpostais c WHERE c.codpostal LIKE :codpostal"),
        @NamedQuery(name = "Codpostais.findByCidade", query = "SELECT c FROM Codpostais c WHERE c.cidade = :cidade")})
public class Codpostais {
    @Id
    @Column(name = "CODPOSTAL")
    private String codpostal;
    @Basic
    @Column(name = "CIDADE")
    private String cidade;
    @OneToMany(mappedBy = "codpostaisByCodpostal") //Adicionei
    private Collection<Cliente> clientesByCodpostal;
    @OneToMany(mappedBy = "codpostaisByCodpostal")
    private Collection<Entidadecertificadora> entidadecertificadorasByCodpostal;
    @OneToMany(mappedBy = "codpostaisByCodpostal")
    private Collection<Produtor> produtorsByCodpostal;
    @OneToMany(mappedBy = "codpostaisByCodpostal")
    private Collection<Veterinario> veterinariosByCodpostal;

    public String getCodpostal() {
        return codpostal;
    }

    public void setCodpostal(String codpostal) {
        this.codpostal = codpostal;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Codpostais that = (Codpostais) o;

        if (codpostal != null ? !codpostal.equals(that.codpostal) : that.codpostal != null) return false;
        if (cidade != null ? !cidade.equals(that.cidade) : that.cidade != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = codpostal != null ? codpostal.hashCode() : 0;
        result = 31 * result + (cidade != null ? cidade.hashCode() : 0);
        return result;
    }

    public Collection<Entidadecertificadora> getEntidadecertificadorasByCodpostal() {
        return entidadecertificadorasByCodpostal;
    }

    public void setEntidadecertificadorasByCodpostal(Collection<Entidadecertificadora> entidadecertificadorasByCodpostal) {
        this.entidadecertificadorasByCodpostal = entidadecertificadorasByCodpostal;
    }

    public Collection<Produtor> getProdutorsByCodpostal() {
        return produtorsByCodpostal;
    }

    public void setProdutorsByCodpostal(Collection<Produtor> produtorsByCodpostal) {
        this.produtorsByCodpostal = produtorsByCodpostal;
    }

    public Collection<Veterinario> getVeterinariosByCodpostal() {
        return veterinariosByCodpostal;
    }

    public void setVeterinariosByCodpostal(Collection<Veterinario> veterinariosByCodpostal) {
        this.veterinariosByCodpostal = veterinariosByCodpostal;
    }

    public Collection<Cliente> getClientesByCodpostal() {
        return clientesByCodpostal;
    }

    public void setClientesByCodpostal(Collection<Cliente> clientesByCodpostal) {
        this.clientesByCodpostal = clientesByCodpostal;
    }

    @Override
    public String toString() {
        return "javaapplication119.DAL.Codpostais[ CodPostal = " + codpostal + " Cidade = " + cidade + "]";
    }
}
