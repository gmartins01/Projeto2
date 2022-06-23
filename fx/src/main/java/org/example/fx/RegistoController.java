package org.example.fx;

import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import proj2.bd.BLL.*;
import proj2.bd.entity.*;

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

    @FXML private TextField campoPassword;

    @FXML private Label confirmaLabel;
    @FXML private Label erroCodPostal;
    @FXML private Label erroNome;
    @FXML private Label erroTelefone;
    @FXML private Label erroNIF;
    @FXML private Label erroUsername;
    @FXML private Label erroPassword;
    @FXML private Label erroTipo;
    @FXML private Label erroRua;
    @FXML private Label erroNumPorta;
    @FXML private Label erroLocalidade;


    public void sair(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Iniciar Sessão");
        stage.setScene(scene);
        stage.show();
    }

    public void limpaLabels(){
        confirmaLabel.setText("");
        erroCodPostal.setText("");
        erroNome.setText("");
        erroTelefone.setText("");
        erroNIF.setText("");
        erroUsername.setText("");
        erroPassword.setText("");
        erroTipo.setText("");
        erroRua.setText("");
        erroNumPorta.setText("");
        erroLocalidade.setText("");
    }


    public void solicitarRegisto(ActionEvent event) throws IOException {
        limpaLabels();

        String nome = "";
        String telefone = "";
        String email = "";
        String nif = "";
        String rua = "";
        String nPorta = "";
        String codPostal1 = "";
        String codPostal2 = "";
        String localidade = "";
        String tipo = "";
        String username = "";
        String password = "";
        String codPostal = "";


        Utilizador user = new Utilizador();


        int aux=0;

        nome = campoNome.getText();
        if(nome.length()==0){
            erroNome.setText("Nome é de preenchimento obrigatório");

            aux=1;
        }


        telefone = campoTelefone.getText();
        if(telefone.length()==0){
            erroTelefone.setText("Telefone é de preenchimento obrigatório");

            aux=1;
        }

        email = campoEmail.getText();


        nif = campoNIF.getText();
        if (nif.length()!=9){
            erroNIF.setText("NIF é composto por 9 números");

            aux=1;
        }
        if (!nif.matches("[0-9]+")){
            erroNIF.setText("NIF é composto apenas por números");

            aux=1;
        }


        rua = campoRua.getText();
        if(rua.length()==0){
            erroRua.setText("Rua é de preenchimento obrigatório");
            aux=1;
        }


        nPorta = campoNPorta.getText();
        if(nPorta.length()==0){
            erroNumPorta.setText("Nº da porta é de preenchimento obrigatório");
            aux=1;
        }

        codPostal1 = campoCodPostal1.getText();
        codPostal2 = campoCodPostal2.getText();
        if(!codPostal1.matches("[0-9]+") || !codPostal2.matches("[0-9]+")){
            erroCodPostal.setText("Código Postal apenas pode conter números!");
            aux=1;
        }


        localidade = campoLocalidade.getText();
        if(localidade.length()==0){
            erroLocalidade.setText("Localidade é de preenchimento obrigatório");
            aux=1;
        }


        username = campoUsername.getText();
        if (username.length()<2){
            erroUsername.setText("Utilize um nome de utilizador com mais de 2 caracteres");

            aux=1;
        }
        if (username.length()>30){
            erroUsername.setText("Utilize um nome de utilizador com 30 caracteres ou menos");

            aux=1;
        }

        password = campoPassword.getText();
        if (password.length()<6){
            erroPassword.setText("Utilize uma palavra-passe com mais de 6 caracteres");

            aux=1;
        }
        if (password.length()>30){
            erroPassword.setText("Utilize uma palavra-passe com 30 caracteres ou menos");

            aux=1;
        }


        tipo = (String) cargo.getValue();
        if (tipo == null){
            erroTipo.setText("Selecione um tipo de utilizador");
            aux=1;
        }

        //Se existir erros sai da função
        if (aux==1){
            return;
        }

        user.setUsername(username);
        user.setPassword(password);
        codPostal = codPostal1 + "-" + codPostal2;

        user.setTipo(tipo);
        user.setVerificado((short) 0);



        if (UtilizadorBLL.verificaUsername(username)){
            confirmaLabel.setStyle("-fx-text-fill:RED;");
            confirmaLabel.setText("Nome de utilizador já existe!");
            return;
        }

        if (UtilizadorBLL.verificaNif(nif)){
            confirmaLabel.setStyle("-fx-text-fill:RED;");
            confirmaLabel.setText("NIF já existe!");
            return;
        }

        else {
            Codpostais codigo = new Codpostais();
            codigo.setCodPostal(codPostal);
            codigo.setLocalidade(localidade);

            List<Codpostais> codigos = CodpostaisBLL.readAll();

            if (!codigos.contains(codigo)){
                CodpostaisBLL.create(codigo);
                //return;
            }


            if (tipo.equals("Produtor")){
                Produtor prod = new Produtor();
                try{

                    prod.setNome(nome);
                    prod.setTelefone(telefone);
                    prod.setEmail(email);
                    prod.setNif((long) Integer.parseInt(nif));
                    prod.setRua(rua);
                    prod.setNumPorta(nPorta);
                    prod.setCodPostal(codigo);
                    UtilizadorBLL.create(user);
                    prod.setIdUtilizador(user);
                    ProdutorBLL.create(prod);
                    confirmaLabel.setStyle("-fx-text-fill:GREEN;");
                    confirmaLabel.setText("Pedido efetuado com sucesso!");
                }catch (Exception e){
                    Alert erroPopUp = new Alert(Alert.AlertType.ERROR);
                    erroPopUp.setTitle("ERRO!");
                    erroPopUp.setHeaderText("Erro a criar produtor!");
                    erroPopUp.showAndWait();
                    UtilizadorBLL.delete(user);
                }


            }

            if (tipo.equals("Veterinario")){
                Veterinario vet = new Veterinario();
                try{
                vet.setNome(nome);
                vet.setTelefone(telefone);
                vet.setEmail(email);
                vet.setNif((long) Integer.parseInt(nif));
                vet.setRua(rua);
                vet.setNumPorta(nPorta);
                vet.setCodPostal(codigo);
                UtilizadorBLL.create(user);
                vet.setIdUtilizador(user);
                VeterinarioBLL.create(vet);
                confirmaLabel.setStyle("-fx-text-fill:GREEN;");
                confirmaLabel.setText("Pedido efetuado com sucesso!");
            }catch (Exception e){
                Alert erroPopUp = new Alert(Alert.AlertType.ERROR);
                erroPopUp.setTitle("ERRO!");
                erroPopUp.setHeaderText("Erro realizar pedido!");
                erroPopUp.showAndWait();
                UtilizadorBLL.delete(user);
            }
            }


            if (tipo.equals("Entidade Certificadora")){
                EntidadeCertificadora ent = new EntidadeCertificadora();
                try{
                ent.setNome(nome);
                ent.setTelefone(telefone);
                ent.setEmail(email);
                ent.setNif((long) Integer.parseInt(nif));
                ent.setRua(rua);
                ent.setNumPorta(nPorta);
                ent.setCodPostal(codigo);
                UtilizadorBLL.create(user);
                ent.setIdUtilizador(user);
                EntidadecertificadoraBLL.create(ent);
                confirmaLabel.setStyle("-fx-text-fill:GREEN;");
                confirmaLabel.setText("Pedido efetuado com sucesso!");
            }catch (Exception e){
            Alert erroPopUp = new Alert(Alert.AlertType.ERROR);
            erroPopUp.setTitle("ERRO!");
            erroPopUp.setHeaderText("Erro realizar pedido!");
            erroPopUp.showAndWait();
            UtilizadorBLL.delete(user);
        }
            }
        }


    }

    public void initialize() {
        cargo.setItems(FXCollections.observableArrayList("Produtor","Veterinario","Entidade Certificadora"));
    }

}
