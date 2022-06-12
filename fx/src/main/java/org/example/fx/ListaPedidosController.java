package org.example.fx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import proj2.bd.BLL.UtilizadorBLL;
import proj2.bd.entity.Utilizador;


import java.io.IOException;

public class ListaPedidosController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TableView<Utilizador> tabelaPedidoRegisto;

    @FXML
    private TableColumn<Utilizador,String> colunaNome;

    @FXML
    private TableColumn<Utilizador,String> colunaTelefone;

    @FXML
    private TableColumn<Utilizador,String> colunaEmail;

    @FXML
    private TableColumn<Utilizador,String> colunaNIF;

    @FXML
    private TableColumn<Utilizador,String> colunaCidade;

    @FXML
    private TableColumn<Utilizador,String> colunaFuncao;

    public ObservableList<Utilizador> getUsers(){
        ObservableList<Utilizador> user= FXCollections.observableArrayList();
        for(Utilizador u: UtilizadorBLL.readAll()){
            if(u.getVerificado().equals("NAO")){
                user.add(u);
            }
        }
        return  user;
    }


    public void switchToMenuAdmin(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Admin/MenuAdmin.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Menu de Administrador");
        stage.setScene(scene);
        stage.show();
    }

    public void initialize() {
        colunaNome.setCellValueFactory(new PropertyValueFactory<Utilizador, String>("username"));
        colunaFuncao.setCellValueFactory(new PropertyValueFactory<Utilizador, String>("tipo"));
        tabelaPedidoRegisto.setItems(getUsers());
    }

}
