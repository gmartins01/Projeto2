package org.example.fx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import proj2.bd.entity.InfoUtilizador;

import java.io.IOException;

public class AdmInfoUserController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    private InfoUtilizador userSelecionado;

    @FXML private Label nomeLabel;
    @FXML private Label telefoneLabel;
    @FXML private Label emailLabel;
    @FXML private Label ruaLabel;
    @FXML private Label numPortaLabel;
    @FXML private Label nifLabel;
    @FXML private Label codPostalLabel;
    @FXML private Label localidadeLabel;




    //método que aceita infoUser para inicializar
    public void initData(InfoUtilizador user){
        userSelecionado = user;
        nomeLabel.setText(userSelecionado.getNome());
        telefoneLabel.setText(userSelecionado.getTelefone());
        emailLabel.setText(userSelecionado.getEmail());
        nifLabel.setText(String.valueOf(userSelecionado.getNif()));
        ruaLabel.setText(userSelecionado.getRua());
        numPortaLabel.setText(userSelecionado.getNumPorta());
        codPostalLabel.setText(userSelecionado.getCodPostal().getCodPostal());
        localidadeLabel.setText(userSelecionado.getCodPostal().getLocalidade());
    }

    public void voltar(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Admin/PedidosRegisto.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Pedidos de Registo");
        stage.setScene(scene);
        stage.show();
    }

}
