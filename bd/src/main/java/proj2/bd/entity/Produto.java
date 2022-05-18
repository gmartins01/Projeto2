package proj2.bd.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;

import java.util.Collection;

@Entity
@Table(name = "PRODUTO")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p"),
        @NamedQuery(name = "Produto.findAllById", query = "SELECT p FROM Produto p WHERE p.idproduto = :idproduto") })
public class Produto {
    @Id
    @Basic(optional = false)
    @Column(name = "IDPRODUTO")
    @SequenceGenerator(name = "PRODUTO_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PRODUTO_SEQ")
    private short idproduto;
    @Basic
    @Column(name = "DESCRICAO")
    private String descricao;
    @Basic
    @Column(name = "PRECOATVENDA")
    private short precoatvenda;
    @Basic
    @Column(name = "QTDSTOCK")
    private byte qtdstock;
    @Basic
    @Column(name = "IDPRODUTOR", insertable = false, updatable = false)
    private short idprodutor;
    @Basic
    @Column(name = "IDLOTEOVOS", insertable = false, updatable = false)
    private Short idloteovos;
    @Basic
    @Column(name = "CODGALINHA", insertable = false, updatable = false)
    private Short codgalinha;
    @OneToMany(mappedBy = "produtosByIdproduto")
    private Collection<Linhavenda> linhavendasByIdproduto;
    @ManyToOne
    @JoinColumn(name = "IDPRODUTOR", referencedColumnName = "IDPRODUTOR", nullable = false)
    private Produtor produtorByIdprodutor;
    @ManyToOne
    @JoinColumn(name = "IDLOTEOVOS", referencedColumnName = "IDLOTEOVOS")
    private Loteovos loteovosByIdloteovos;
    @ManyToOne
    @JoinColumn(name = "CODGALINHA", referencedColumnName = "CODGALINHA")
    private Galinha galinhaByCodgalinha;

    public short getIdproduto() {
        return idproduto;
    }

    public void setIdproduto(short idproduto) {
        this.idproduto = idproduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public short getPrecoatvenda() {
        return precoatvenda;
    }

    public void setPrecoatvenda(short precoatvenda) {
        this.precoatvenda = precoatvenda;
    }

    public byte getQtdstock() {
        return qtdstock;
    }

    public void setQtdstock(byte qtdstock) {
        this.qtdstock = qtdstock;
    }

    public short getIdprodutor() {
        return idprodutor;
    }

    public void setIdprodutor(short idprodutor) {
        this.idprodutor = idprodutor;
    }

    public Short getIdloteovos() {
        return idloteovos;
    }

    public void setIdloteovos(Short idloteovos) {
        this.idloteovos = idloteovos;
    }

    public Short getCodgalinha() {
        return codgalinha;
    }

    public void setCodgalinha(Short codgalinha) {
        this.codgalinha = codgalinha;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;

        Produto produto = (Produto) o;

        if (idproduto != produto.idproduto)
            return false;
        if (precoatvenda != produto.precoatvenda)
            return false;
        if (qtdstock != produto.qtdstock)
            return false;
        if (idprodutor != produto.idprodutor)
            return false;
        if (descricao != null ? !descricao.equals(produto.descricao) : produto.descricao != null)
            return false;
        if (idloteovos != null ? !idloteovos.equals(produto.idloteovos) : produto.idloteovos != null)
            return false;
        if (codgalinha != null ? !codgalinha.equals(produto.codgalinha) : produto.codgalinha != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) idproduto;
        result = 31 * result + (descricao != null ? descricao.hashCode() : 0);
        result = 31 * result + (int) precoatvenda;
        result = 31 * result + (int) qtdstock;
        result = 31 * result + (int) idprodutor;
        result = 31 * result + (idloteovos != null ? idloteovos.hashCode() : 0);
        result = 31 * result + (codgalinha != null ? codgalinha.hashCode() : 0);
        return result;
    }

    public Collection<Linhavenda> getLinhavendasByIdproduto() {
        return linhavendasByIdproduto;
    }

    public void setLinhavendasByIdproduto(Collection<Linhavenda> linhavendasByIdproduto) {
        this.linhavendasByIdproduto = linhavendasByIdproduto;
    }

    public Produtor getProdutorByIdprodutor() {
        return produtorByIdprodutor;
    }

    public void setProdutorByIdprodutor(Produtor produtorByIdprodutor) {
        this.produtorByIdprodutor = produtorByIdprodutor;
    }

    public Loteovos getLoteovosByIdloteovos() {
        return loteovosByIdloteovos;
    }

    public void setLoteovosByIdloteovos(Loteovos loteovosByIdloteovos) {
        this.loteovosByIdloteovos = loteovosByIdloteovos;
    }

    public Galinha getGalinhaByCodgalinha() {
        return galinhaByCodgalinha;
    }

    public void setGalinhaByCodgalinha(Galinha galinhaByCodgalinha) {
        this.galinhaByCodgalinha = galinhaByCodgalinha;
    }

}
