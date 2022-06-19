package proj2.bd.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class InfoUtilizador implements Serializable {

    private static final long serialVersionUID = 1L;

    private String nome;
    private String telefone;
    private String email;
    private String rua;
    private String numPorta;
    private Codpostais codPostal;
    private Long nif;
    private String funcao;
    private BigDecimal idUtilizador;



    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getNumPorta() {
        return numPorta;
    }

    public void setNumPorta(String numPorta) {
        this.numPorta = numPorta;
    }

    public Codpostais getCodPostal() {
        return codPostal;
    }

    public void setCodPostal(Codpostais codPostal) {
        this.codPostal = codPostal;
    }

    public Long getNif() {
        return nif;
    }

    public void setNif(Long nif) {
        this.nif = nif;
    }

    public String getFuncao() {
        return funcao;
    }

    public void setFuncao(String funcao) {
        this.funcao = funcao;
    }

    public BigDecimal getIdUtilizador() {
        return idUtilizador;
    }

    public void setIdUtilizador(BigDecimal idUtilizador) {
        this.idUtilizador = idUtilizador;
    }
}
