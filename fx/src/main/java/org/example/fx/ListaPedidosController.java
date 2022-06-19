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
import proj2.bd.BLL.*;
import proj2.bd.entity.*;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ListaPedidosController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TableView<InfoUtilizador> tabelaPedidoRegisto;

    @FXML
    private TableColumn<InfoUtilizador,String> colunaNome;

    @FXML
    private TableColumn<InfoUtilizador,String> colunaTelefone;

    @FXML
    private TableColumn<InfoUtilizador,String> colunaNIF;

    @FXML
    private TableColumn<InfoUtilizador,String> colunaFuncao;

    private final List<InfoUtilizador> info = new ArrayList<>();

    public ObservableList<InfoUtilizador> getUsers(){

        for(Utilizador u: UtilizadorBLL.readAll()) {
            if (u.getVerificado() == 0) {
                for (Veterinario v : VeterinarioBLL.readAll()) {
                    if (v.getIdUtilizador().equals(u)) {
                        InfoUtilizador iu = new InfoUtilizador();
                        iu.setNome(v.getNome());
                        iu.setEmail(v.getEmail());
                        iu.setRua(v.getRua());
                        iu.setNumPorta(v.getNumPorta());
                        iu.setCodPostal(v.getCodPostal());
                        iu.setNif(v.getNif());
                        iu.setTelefone(v.getTelefone());
                        iu.setFuncao(u.getTipo());
                        iu.setIdUtilizador(u.getIdUtilizador());
                        info.add(iu);
                    }
                }

            for (Produtor p : ProdutorBLL.readAll()) {
                if (p.getIdUtilizador().equals(u)) {
                    InfoUtilizador iu = new InfoUtilizador();
                    iu.setNome(p.getNome());
                    iu.setEmail(p.getEmail());
                    iu.setRua(p.getRua());
                    iu.setNumPorta(p.getNumPorta());
                    iu.setCodPostal(p.getCodPostal());
                    iu.setNif(p.getNif());
                    iu.setTelefone(p.getTelefone());
                    iu.setFuncao(u.getTipo());
                    iu.setIdUtilizador(u.getIdUtilizador());
                    info.add(iu);
                }

            }

            for (EntidadeCertificadora e : EntidadecertificadoraBLL.readAll()) {
                if (e.getIdUtilizador().equals(u)) {
                    InfoUtilizador iu = new InfoUtilizador();
                    iu.setNome(e.getNome());
                    iu.setEmail(e.getEmail());
                    iu.setRua(e.getRua());
                    iu.setNumPorta(e.getNumPorta());
                    iu.setCodPostal(e.getCodPostal());
                    iu.setNif(e.getNif());
                    iu.setTelefone(e.getTelefone());
                    iu.setFuncao(u.getTipo());
                    iu.setIdUtilizador(u.getIdUtilizador());
                    info.add(iu);
                }
            }
        }
        }


        ObservableList<InfoUtilizador> user= FXCollections.observableArrayList();
        for(InfoUtilizador u: info){
            user.add(u);
        }
        return  user;
    }

    public void aceitaPedido(){
        InfoUtilizador infoU = tabelaPedidoRegisto.getSelectionModel().getSelectedItem();

        for (Utilizador u: UtilizadorBLL.readAll()){
            if (u.getIdUtilizador().equals(infoU.getIdUtilizador())){
                u.setVerificado((short) 1);
                tabelaPedidoRegisto.getItems().removeAll(tabelaPedidoRegisto.getSelectionModel().getSelectedItem());
                return;
            }
        }

    }

    public void rejeitaPedido(){
        InfoUtilizador infoU = tabelaPedidoRegisto.getSelectionModel().getSelectedItem();

        if(infoU.getFuncao().equals("Produtor")){
           for (Utilizador user: UtilizadorBLL.readAll()){
               for (Produtor prod: ProdutorBLL.readAll()){
                   if (infoU.getIdUtilizador().equals(user.getIdUtilizador()) && user.getIdUtilizador().equals(prod.getIdUtilizador())){
                     ProdutorBLL.delete(prod);
                       UtilizadorBLL.delete(user);
                       tabelaPedidoRegisto.getItems().removeAll(tabelaPedidoRegisto.getSelectionModel().getSelectedItem());
                       return;
                   }
               }
           }
        }

        if(infoU.getFuncao().equals("Veterinario")){
            for (Utilizador user: UtilizadorBLL.readAll()){
                for (Veterinario vet: VeterinarioBLL.readAll()){
                    if (infoU.getIdUtilizador().equals(user.getIdUtilizador()) && user.getIdUtilizador().equals(vet.getIdUtilizador())){
                        VeterinarioBLL.delete(vet);
                        UtilizadorBLL.delete(user);
                        tabelaPedidoRegisto.getItems().removeAll(tabelaPedidoRegisto.getSelectionModel().getSelectedItem());
                        return;
                    }
                }
            }
        }

        if(infoU.getFuncao().equals("Entidade Certificadora")){
            for (Utilizador user: UtilizadorBLL.readAll()){
                for (EntidadeCertificadora ent: EntidadecertificadoraBLL.readAll()){
                    if (infoU.getIdUtilizador().equals(user.getIdUtilizador()) && user.getIdUtilizador().equals(ent.getIdUtilizador())){
                        EntidadecertificadoraBLL.delete(ent);
                        UtilizadorBLL.delete(user);
                        tabelaPedidoRegisto.getItems().removeAll(tabelaPedidoRegisto.getSelectionModel().getSelectedItem());
                        return;
                    }
                }
            }
        }

    }

    public void verDetalhes(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Admin/InfoUser.fxml"));
        Parent root = loader.load();
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        AdmInfoUserController infoController = loader.getController();
        infoController.initData(tabelaPedidoRegisto.getSelectionModel().getSelectedItem());
        stage.setTitle("Informações de utilizador");
        stage.setScene(scene);
        stage.show();
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
        colunaNome.setCellValueFactory(new PropertyValueFactory<InfoUtilizador, String>("nome"));
        colunaTelefone.setCellValueFactory(new PropertyValueFactory<InfoUtilizador, String>("telefone"));
        colunaNIF.setCellValueFactory(new PropertyValueFactory<InfoUtilizador, String>("nif"));
        colunaFuncao.setCellValueFactory(new PropertyValueFactory<InfoUtilizador, String>("funcao"));
        tabelaPedidoRegisto.setItems(getUsers());
    }

}
