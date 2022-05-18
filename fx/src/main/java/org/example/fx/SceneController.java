package org.example.fx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import proj2.bd.BLL.UtilizadorBLL;

import java.io.IOException;

public class SceneController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TextField CampoUsername;

    @FXML
    private PasswordField CampoPassword;

    public void login(ActionEvent event) throws IOException {

        String username = CampoUsername.getText();
        String password = CampoPassword.getText();

        String tipoUser = UtilizadorBLL.efetuarLogin(username, password);

        if (tipoUser.equals("Administrador")){
            Parent root = FXMLLoader.load(getClass().getResource("MenuAdmin.fxml"));
            stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        }


    }

    public void switchToMenuAdmin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("MenuAdmin.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToScene2(ActionEvent event)throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("LOGIN");
        stage.setScene(scene);
        stage.show();
    }


}
