package proj2.bd.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.sql.Date;

@Entity
@Table(name = "RACAO")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Racao.findAll", query = "SELECT c FROM Racao c"),
        @NamedQuery(name = "Racao.findAllByNome", query = "SELECT c FROM Racao c WHERE c.nome LIKE :nome"),
        @NamedQuery(name = "Racao.findById", query = "SELECT c FROM Racao c WHERE c.idracao = :idracao"),
        @NamedQuery(name = "Racao.findAllByQtd", query = "SELECT c FROM Racao c WHERE c.quantidade = :quantidade"),
        @NamedQuery(name = "Racao.findAllByDataValidade", query = "SELECT c FROM Racao c WHERE c.dtvalidade = :dtvalidade") })
public class Racao {
    @Id
    @Basic(optional = false)
    @Column(name = "IDRACAO")
    @SequenceGenerator(name = "RACAO_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "RACAO_SEQ")
    private short idracao;
    @Basic
    @Column(name = "DTVALIDADE")
    private Date dtvalidade;
    @Basic
    @Column(name = "NOME")
    private String nome;
    @Basic
    @Column(name = "QUANTIDADE")
    private int quantidade;
    @Basic
    @Column(name = "DESCRICAO")
    private String descricao;
    @Basic
    @Column(name = "IDPRODUTOR", insertable = false, updatable = false)
    private short idprodutor;
    @ManyToOne // Adicionei
    @JoinColumn(name = "IDPRODUTOR", referencedColumnName = "IDPRODUTOR", nullable = false)
    private Produtor produtorByIdprodutor;

    public short getIdracao() {
        return idracao;
    }

    public void setIdracao(short idracao) {
        this.idracao = idracao;
    }

    public Date getDtvalidade() {
        return dtvalidade;
    }

    public void setDtvalidade(Date dtvalidade) {
        this.dtvalidade = dtvalidade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public short getIdprodutor() {
        return idprodutor;
    }

    public void setIdprodutor(short idprodutor) {
        this.idprodutor = idprodutor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Racao racao = (Racao) o;

        if (idracao != racao.idracao)
            return false;
        if (quantidade != racao.quantidade)
            return false;
        if (idprodutor != racao.idprodutor)
            return false;
        if (dtvalidade != null ? !dtvalidade.equals(racao.dtvalidade) : racao.dtvalidade != null)
            return false;
        if (nome != null ? !nome.equals(racao.nome) : racao.nome != null)
            return false;
        if (descricao != null ? !descricao.equals(racao.descricao) : racao.descricao != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) idracao;
        result = 31 * result + (dtvalidade != null ? dtvalidade.hashCode() : 0);
        result = 31 * result + (nome != null ? nome.hashCode() : 0);
        result = 31 * result + quantidade;
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        result = 31 * result + (int) idprodutor;
        return result;
    }

    public Produtor getProdutorByIdprodutor() {
        return produtorByIdprodutor;
    }

    public void setProdutorByIdprodutor(Produtor produtorByIdprodutor) {
        this.produtorByIdprodutor = produtorByIdprodutor;
    }
}
