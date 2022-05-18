package proj2.bd.entity;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.sql.Date;

@Entity
@Table(name = "VENDA")
@XmlRootElement
@NamedQueries({
        @NamedQuery(name = "Venda.findAll", query = "SELECT g FROM Venda g"),
        @NamedQuery(name = "Venda.findAllById", query = "SELECT g FROM Venda g WHERE g.idvenda = :idvenda"),
        @NamedQuery(name = "Venda.findByData", query = "SELECT g FROM Venda g WHERE g.data = :data"),
        @NamedQuery(name = "Venda.findByIdCliente", query = "SELECT g FROM Venda g WHERE g.idcliente = :idcliente")})
public class Venda {
    @Id
    @Basic(optional = false)
    @Column(name = "IDVENDA")
    @SequenceGenerator(name="VENDA_SEQ", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "VENDA_SEQ")
    private short idvenda;
    @Basic
    @Column(name = "DATA")
    private Date data;
    @Basic
    @Column(name = "VALORTOTAL")
    private int valortotal;
    @Basic
    @Column(name = "IDCLIENTE",insertable = false,updatable = false)
    private short idcliente;
    @ManyToOne  //Adicionei
    @JoinColumn(name = "IDCLIENTE", referencedColumnName = "IDCLIENTE", nullable = false)
    private Cliente clientesByIdcliente;

    public short getIdvenda() {
        return idvenda;
    }

    public void setIdvenda(short idvenda) {
        this.idvenda = idvenda;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getValortotal() {
        return valortotal;
    }

    public void setValortotal(int valortotal) {
        this.valortotal = valortotal;
    }

    public short getIdcliente() {
        return idcliente;
    }

    public void setIdcliente(short idcliente) {
        this.idcliente = idcliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Venda venda = (Venda) o;

        if (idvenda != venda.idvenda) return false;
        if (valortotal != venda.valortotal) return false;
        if (idcliente != venda.idcliente) return false;
        if (data != null ? !data.equals(venda.data) : venda.data != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (int) idvenda;
        result = 31 * result + (data != null ? data.hashCode() : 0);
        result = 31 * result + valortotal;
        result = 31 * result + (int) idcliente;
        return result;
    }

    public Cliente getClientesByIdcliente() {
        return clientesByIdcliente;
    }

    public void setClientesByIdcliente(Cliente clientesByIdcliente) {
        this.clientesByIdcliente = clientesByIdcliente;
    }
}
