/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proj2.bd.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
@Table(name = "PRODUTO")
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p"),
    @NamedQuery(name = "Produto.findByIdProduto", query = "SELECT p FROM Produto p WHERE p.idProduto = :idProduto"),
    @NamedQuery(name = "Produto.findByDescricao", query = "SELECT p FROM Produto p WHERE p.descricao = :descricao"),
    @NamedQuery(name = "Produto.findByPrecoVenda", query = "SELECT p FROM Produto p WHERE p.precoVenda = :precoVenda"),
    @NamedQuery(name = "Produto.findByQtdStock", query = "SELECT p FROM Produto p WHERE p.qtdStock = :qtdStock")})
public class Produto implements Serializable {

    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @Column(name = "ID_PRODUTO")
    private BigDecimal idProduto;
    @Column(name = "DESCRICAO")
    private String descricao;
    @Basic(optional = false)
    @Column(name = "PRECO_VENDA")
    private double precoVenda;
    @Basic(optional = false)
    @Column(name = "QTD_STOCK")
    private short qtdStock;
    @JoinColumn(name = "COD_GALINHA", referencedColumnName = "COD_GALINHA")
    @ManyToOne
    private Galinha codGalinha;
    @JoinColumn(name = "ID_LOTE", referencedColumnName = "ID_LOTE")
    @ManyToOne
    private LoteOvos idLote;
    @JoinColumn(name = "ID_PRODUTOR", referencedColumnName = "ID_PRODUTOR")
    @ManyToOne(optional = false)
    private Produtor idProdutor;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "produto")
    private LinhaVenda linhaVenda;

    public Produto() {
    }

    public Produto(BigDecimal idProduto) {
        this.idProduto = idProduto;
    }

    public Produto(BigDecimal idProduto, double precoVenda, short qtdStock) {
        this.idProduto = idProduto;
        this.precoVenda = precoVenda;
        this.qtdStock = qtdStock;
    }

    public BigDecimal getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(BigDecimal idProduto) {
        this.idProduto = idProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(double precoVenda) {
        this.precoVenda = precoVenda;
    }

    public short getQtdStock() {
        return qtdStock;
    }

    public void setQtdStock(short qtdStock) {
        this.qtdStock = qtdStock;
    }

    public Galinha getCodGalinha() {
        return codGalinha;
    }

    public void setCodGalinha(Galinha codGalinha) {
        this.codGalinha = codGalinha;
    }

    public LoteOvos getIdLote() {
        return idLote;
    }

    public void setIdLote(LoteOvos idLote) {
        this.idLote = idLote;
    }

    public Produtor getIdProdutor() {
        return idProdutor;
    }

    public void setIdProdutor(Produtor idProdutor) {
        this.idProdutor = idProdutor;
    }

    public LinhaVenda getLinhaVenda() {
        return linhaVenda;
    }

    public void setLinhaVenda(LinhaVenda linhaVenda) {
        this.linhaVenda = linhaVenda;
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
        if (!(object instanceof Produto)) {
            return false;
        }
        Produto other = (Produto) object;
        if ((this.idProduto == null && other.idProduto != null) || (this.idProduto != null && !this.idProduto.equals(other.idProduto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "teste.Produto[ idProduto=" + idProduto + " ]";
    }
    
}
