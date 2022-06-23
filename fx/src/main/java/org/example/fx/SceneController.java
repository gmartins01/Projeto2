package org.example.fx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import proj2.bd.BLL.UtilizadorBLL;
import proj2.bd.entity.Utilizador;

import java.io.IOException;

public class SceneController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField CampoUsername;

    @FXML
    private PasswordField CampoPassword;

    @FXML
    private Label labelLogin;

    public void login(ActionEvent event) throws IOException {

        String username = CampoUsername.getText();
        String password = CampoPassword.getText();

        String tipoUser = "";
        Utilizador user = UtilizadorBLL.efetuarLogin(username, password);



        if(user!=null && (user.getVerificado() == 0 || user.getVerificado() == 1))
            tipoUser = user.getTipo();
        else
            tipoUser = "NULL";

        if(tipoUser.equals("NULL"))
            labelLogin.setText("Dados Inválidos!");

        else if(user.getVerificado()==0){
            labelLogin.setText("Utilizador não está verificado");
        }

        else{
            if (tipoUser.equals("Administrador")){
                Parent root = FXMLLoader.load(getClass().getResource("Admin/MenuAdmin.fxml"));
                stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setTitle("Menu de Administrador");
                stage.setScene(scene);
                stage.show();
            }

            if(tipoUser.equals("Veterinario")){
                Parent root = FXMLLoader.load(getClass().getResource("Veterinario/MenuVeterinario.fxml"));
                stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setTitle("Menu de Veterinário");
                stage.setScene(scene);
                stage.show();
            }

            if(tipoUser.equals("Entidade Certificadora")){
                UtilizadorBLL.getuserLogado().add(user);
                Parent root = FXMLLoader.load(getClass().getResource("EntidadeCertificadora/MenuEntCertificadora.fxml"));
                stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setTitle("Menu de Entidade Certificadora");
                stage.setScene(scene);
                stage.show();
            }
        }




    }

    public void registo(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Registo.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Efetuar pedido de registo");
        stage.setScene(scene);
        stage.show();
    }


}
