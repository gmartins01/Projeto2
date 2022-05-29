package org.example.fx;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class EntCertificadoraController {


    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToListaProdutores(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("EntidadeCertificadora/ListaProdutores.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Pedidos de Registo");
        stage.setScene(scene);
        stage.show();
    }

    public void Logout(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Login.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Iniciar Sessão");
        stage.setScene(scene);
        stage.show();
    }
}
