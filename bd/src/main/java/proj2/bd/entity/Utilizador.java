package proj2.bd.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Collection;

@Entity
@Table(name = "UTILIZADOR")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Utilizador.findAll", query = "SELECT g FROM Utilizador g"),
        @NamedQuery(name = "Utilizador.findAllById", query = "SELECT g FROM Utilizador g WHERE g.idutilizador = :idutilizador"),
        @NamedQuery(name = "Utilizador.findByTipo", query = "SELECT g FROM Utilizador g WHERE g.tipo = :tipo") })
public class Utilizador {
    @Id
    @Basic(optional = false)
    @Column(name = "IDUTILIZADOR")
    @SequenceGenerator(name="UTILIZADOR_SEQ", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "UTILIZADOR_SEQ")
    private short idutilizador;
    @Basic
    @Column(name = "USERNAME")
    private String username;
    @Basic
    @Column(name = "PASSWORD")
    private String password;
    @Basic
    @Column(name = "TIPO")
    private String tipo;
    @OneToMany(mappedBy = "utilizadorByIdutilizador")
    private Collection<Cliente> clientesByIdutilizador;
    @OneToMany(mappedBy = "utilizadorByIdutilizador")
    private Collection<Veterinario> veterinariosByIdutilizador;
    @OneToMany(mappedBy = "utilizadorByIdutilizador") //Adicionei
    private Collection<Produtor> produtorsByIdutilizador;
    @OneToMany(mappedBy = "utilizadorByIdutilizador") //Adicionei
    private Collection<Entidadecertificadora> entidadecertificadorasByIdutilizador;

    public short getIdutilizador() {
        return idutilizador;
    }

    public void setIdutilizador(short idutilizador) {
        this.idutilizador = idutilizador;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Utilizador that = (Utilizador) o;

        if (idutilizador != that.idutilizador) return false;
        if (username != null ? !username.equals(that.username) : that.username != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (tipo != null ? !tipo.equals(that.tipo) : that.tipo != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) idutilizador;
        result = 31 * result + (username != null ? username.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (tipo != null ? tipo.hashCode() : 0);
        return result;
    }

    public Collection<Veterinario> getVeterinariosByIdutilizador() {
        return veterinariosByIdutilizador;
    }

    public void setVeterinariosByIdutilizador(Collection<Veterinario> veterinariosByIdutilizador) {
        this.veterinariosByIdutilizador = veterinariosByIdutilizador;
    }

    public Collection<Cliente> getClientesByIdutilizador() {
        return clientesByIdutilizador;
    }

    public void setClientesByIdutilizador(Collection<Cliente> clientesByIdutilizador) {
        this.clientesByIdutilizador = clientesByIdutilizador;
    }

    public Collection<Produtor> getProdutorsByIdutilizador() {
        return produtorsByIdutilizador;
    }

    public void setProdutorsByIdutilizador(Collection<Produtor> produtorsByIdutilizador) {
        this.produtorsByIdutilizador = produtorsByIdutilizador;
    }

    public Collection<Entidadecertificadora> getEntidadecertificadorasByIdutilizador() {
        return entidadecertificadorasByIdutilizador;
    }

    public void setEntidadecertificadorasByIdutilizador(Collection<Entidadecertificadora> entidadecertificadorasByIdutilizador) {
        this.entidadecertificadorasByIdutilizador = entidadecertificadorasByIdutilizador;
    }
}
