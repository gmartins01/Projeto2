package org.example.fx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import proj2.bd.BLL.CodpostaisBLL;
import proj2.bd.BLL.ProdutorBLL;
import proj2.bd.BLL.UtilizadorBLL;
import proj2.bd.entity.Codpostais;
import proj2.bd.entity.Produtor;
import proj2.bd.entity.Utilizador;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class RegistoController {
    @FXML
    private TextField campoNome;

    @FXML
    private TextField campoTelefone;

    @FXML
    private TextField campoEmail;

    @FXML
    private TextField campoNIF;

    @FXML
    private TextField campoRua;

    @FXML
    private TextField campoNPorta;

    @FXML
    private TextField campoLocalidade;

    @FXML
    private TextField campoCodPostal1;

    @FXML
    private TextField campoCodPostal2;

    @FXML
    private ChoiceBox cargo = new ChoiceBox();

    @FXML
    private TextField campoUsername;

    @FXML
    private TextField campoPassword;

    public void solicitarRegisto(ActionEvent event) throws IOException {
        String nome = campoNome.getText();
        String telefone = campoTelefone.getText();
        String email = campoEmail.getText();
        int nif = Integer.parseInt(campoNIF.getText());
        String rua = campoRua.getText();
        String nPorta = campoNPorta.getText();
        String codPostal1 = campoCodPostal1.getText();
        String codPostal2 = campoCodPostal2.getText();
        String localidade = campoLocalidade.getText();
        String tipo = (String) cargo.getValue();
        String username = campoUsername.getText();
        String password = campoPassword.getText();
        String codPostal = codPostal1 + "-" + codPostal2;

        Utilizador user = new Utilizador();

        user.setUsername(username);
        user.setPassword(password);
        user.setTipo(tipo);
        user.setVerificado("NAO");


        if (tipo.equals("Produtor")){
            Produtor prod = new Produtor();
            List<Codpostais> codigos = new ArrayList<>();
            codigos = CodpostaisBLL.readAll();

            int searchCodigo = CodpostaisBLL.serachCodigo(codPostal);

            for (Codpostais cod: codigos){
                if(searchCodigo==0){
                //if (CodpostaisBLL.readById(codPostal).equals(codPostal)){
                    Codpostais codigo = new Codpostais();
                    prod.setNome(nome);
                    prod.setTelefone(telefone);
                    prod.setEmail(email);
                    prod.setNif(nif);
                    prod.setRua(rua);
                    prod.setNporta(nPorta);
                    prod.setCodpostal(codPostal);
                    codigo.setCodpostal(codPostal);
                    codigo.setCidade(localidade);
                    UtilizadorBLL.create(user);
                    CodpostaisBLL.create(cod);
                    prod.setCodpostaisByCodpostal(cod);
                    prod.setUtilizadorByIdutilizador(user);
                    ProdutorBLL.create(prod);
                    return;
                }
                else{
                    prod.setNome(nome);
                    prod.setTelefone(telefone);
                    prod.setEmail(email);
                    prod.setNif(nif);
                    prod.setRua(rua);
                    prod.setNporta(nPorta);
                    prod.setCodpostal(codPostal);
                    UtilizadorBLL.create(user);
                    prod.setCodpostaisByCodpostal(cod);
                    prod.setUtilizadorByIdutilizador(user);
                    ProdutorBLL.create(prod);
                    return;
                }
            }
        }
    }

    public void initialize() {
        cargo.setItems(FXCollections.observableArrayList("Produtor","Veterinaro","Entidade Certificadora"));
    }

}
