/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proj2.bd.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author gonca
 */
@Entity
@Table(name = "LINHA_VENDA")
@NamedQueries({
    @NamedQuery(name = "LinhaVenda.findAll", query = "SELECT l FROM LinhaVenda l"),
    @NamedQuery(name = "LinhaVenda.findByIdProduto", query = "SELECT l FROM LinhaVenda l WHERE l.idProduto = :idProduto"),
    @NamedQuery(name = "LinhaVenda.findByQuantidade", query = "SELECT l FROM LinhaVenda l WHERE l.quantidade = :quantidade"),
    @NamedQuery(name = "LinhaVenda.findByPreco", query = "SELECT l FROM LinhaVenda l WHERE l.preco = :preco")})
public class LinhaVenda implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_PRODUTO")
    private BigDecimal idProduto;
    @Basic(optional = false)
    @Column(name = "QUANTIDADE")
    private short quantidade;
    @Basic(optional = false)
    @Column(name = "PRECO")
    private double preco;
    @JoinColumn(name = "ID_PRODUTO", referencedColumnName = "ID_PRODUTO", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Produto produto;
    @JoinColumn(name = "ID_VENDA", referencedColumnName = "ID_VENDA")
    @ManyToOne(optional = false)
    private Venda idVenda;

    public LinhaVenda() {
    }

    public LinhaVenda(BigDecimal idProduto) {
        this.idProduto = idProduto;
    }

    public LinhaVenda(BigDecimal idProduto, short quantidade, double preco) {
        this.idProduto = idProduto;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public BigDecimal getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(BigDecimal idProduto) {
        this.idProduto = idProduto;
    }

    public short getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(short quantidade) {
        this.quantidade = quantidade;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public Venda getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(Venda idVenda) {
        this.idVenda = idVenda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProduto != null ? idProduto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LinhaVenda)) {
            return false;
        }
        LinhaVenda other = (LinhaVenda) object;
        if ((this.idProduto == null && other.idProduto != null) || (this.idProduto != null && !this.idProduto.equals(other.idProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "teste.LinhaVenda[ idProduto=" + idProduto + " ]";
    }
    
}
