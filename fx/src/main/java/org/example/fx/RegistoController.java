package org.example.fx;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import proj2.bd.BLL.CodpostaisBLL;
import proj2.bd.BLL.ProdutorBLL;
import proj2.bd.BLL.UtilizadorBLL;
import proj2.bd.entity.Codpostais;
import proj2.bd.entity.Produtor;
import proj2.bd.entity.Utilizador;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class RegistoController {
    private Stage stage;
    private Scene scene;
    private Parent root;

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

    public void sair(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Iniciar Sessão");
        stage.setScene(scene);
        stage.show();
    }

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
        user.setVerificado((short) 0);

        Codpostais codigo = new Codpostais();
        codigo.setCodPostal(codPostal);
        codigo.setLocalidade(localidade);

        List<Codpostais> codigos = CodpostaisBLL.readAll();

        for(Codpostais cod: codigos){
            if (cod.getCodPostal().equals(codPostal)){
                return;
            }
            else{
                CodpostaisBLL.create(codigo);
                return;
            }

        }


        if (tipo.equals("Produtor")){
            Produtor prod = new Produtor();

                    prod.setNome(nome);
                    prod.setTelefone(telefone);
                    prod.setEmail(email);
                    prod.setNif((long) nif);
                    prod.setRua(rua);
                    prod.setNumPorta(nPorta);
                    prod.setCodPostal(codigo);
                    UtilizadorBLL.create(user);
                    List<Utilizador> users = UtilizadorBLL.readAll();
                    Utilizador aux = new Utilizador();
                    for (Utilizador u: users){
                        if (u.getUsername().equals(username)){
                            aux = u;
                            return;
                        }
                    }
                    prod.setIdUtilizador(aux);
                    ProdutorBLL.create(prod);

        }
    }

    public void initialize() {
        cargo.setItems(FXCollections.observableArrayList("Produtor","Veterinaro","Entidade Certificadora"));
    }

}
