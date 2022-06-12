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
import proj2.bd.BLL.ProdutorBLL;
import proj2.bd.entity.Produtor;

import java.io.IOException;

public class VetListaProdutoresController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TableView<Produtor> tabelaProdutores;

    @FXML
    private TableColumn<Produtor,String> colunaNome;

    public ObservableList<Produtor> getUsers(){
        ObservableList<Produtor> user= FXCollections.observableArrayList();;
        for(Produtor u: ProdutorBLL.readAll()){
            user.add(u);
        }
        return  user;
    }

    public void switchToMenuVeterinario(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Veterinario/MenuVeterinario.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Menu de Veterinário");
        stage.setScene(scene);
        stage.show();
    }

    public void initialize() {
        colunaNome.setCellValueFactory(new PropertyValueFactory<Produtor, String>("nome"));
        tabelaProdutores.setItems(getUsers());
    }
}
