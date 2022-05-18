package proj2.bd.entity;

import javax.persistence.*;

@Entity
@IdClass(LinhavendaPK.class)
public class Linhavenda {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IDVENDA")
    private short idvenda;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "IDPRODUTO")
    private short idproduto;
    @Basic
    @Column(name = "QUANTIDADE")
    private short quantidade;
    @Basic
    @Column(name = "PRECO")
    private short preco;
    @ManyToOne
    @JoinColumn(name = "IDVENDA", referencedColumnName = "IDVENDA", nullable = false, insertable = false, updatable = false)
    private Venda vendaByIdvenda;
    @ManyToOne
    @JoinColumn(name = "IDPRODUTO", referencedColumnName = "IDPRODUTO", nullable = false, insertable = false, updatable = false)
    private Produto produtosByIdproduto;

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

    public short getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(short quantidade) {
        this.quantidade = quantidade;
    }

    public short getPreco() {
        return preco;
    }

    public void setPreco(short preco) {
        this.preco = preco;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Linhavenda that = (Linhavenda) o;

        if (idvenda != that.idvenda) return false;
        if (idproduto != that.idproduto) return false;
        if (quantidade != that.quantidade) return false;
        if (preco != that.preco) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) idvenda;
        result = 31 * result + (int) idproduto;
        result = 31 * result + (int) quantidade;
        result = 31 * result + (int) preco;
        return result;
    }

    public Venda getVendaByIdvenda() {
        return vendaByIdvenda;
    }

    public void setVendaByIdvenda(Venda vendaByIdvenda) {
        this.vendaByIdvenda = vendaByIdvenda;
    }

    public Produto getProdutosByIdproduto() {
        return produtosByIdproduto;
    }

    public void setProdutosByIdproduto(Produto produtosByIdproduto) {
        this.produtosByIdproduto = produtosByIdproduto;
    }
}
