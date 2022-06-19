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
import proj2.bd.BLL.CertificacaoBLL;
import proj2.bd.BLL.ProdutorBLL;
import proj2.bd.BLL.UtilizadorBLL;
import proj2.bd.entity.Certificacao;
import proj2.bd.entity.EntidadeCertificadora;
import proj2.bd.entity.Produtor;
import proj2.bd.entity.Utilizador;

import java.io.IOException;
import java.util.List;

public class EntListaProdutoresController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    @FXML
    private TableView<Produtor> tabelaProdutores;

    @FXML
    private TableColumn<Produtor,String> colunaNome;

    List<Certificacao> certificacoes = CertificacaoBLL.readAll();

    public ObservableList<Produtor> getUsers(){
        ObservableList<Produtor> user= FXCollections.observableArrayList();;
        for(Produtor u: ProdutorBLL.readAll()){
            //for(Certificacao c: CertificacaoBLL.readAll()){
                if (!certificacoes.contains(u.getIdProdutor())){
                    user.add(u);
                //}
            }
        }
        return  user;
    }


    public void InserirCertificacao(){
        List<Utilizador> usersLogados = UtilizadorBLL.getuserLogado();




        Produtor prod = tabelaProdutores.getSelectionModel().getSelectedItem();
        EntidadeCertificadora ent = new EntidadeCertificadora();
        //ent.setIdentidadecertificadora((short) 1);

        Certificacao cert = new Certificacao();
        //cert.setEntidadecertificadoraByIdentidadecertificadora(ent);
        //cert.setProdutorByIdprodutor(prod);
        //cert.setIdprodutor((short) 1);
        //cert.setIdentidadecertificadora((short) 2);
        for (Utilizador u: usersLogados){
            System.out.println(u.getUsername());
        }

        /*LocalDateTime now = LocalDateTime.now();
        SimpleDateFormat DataFormat = new SimpleDateFormat("yyyy/mm/dd");
        try {
            Date data = DataFormat.parse(String.valueOf(now));
            cert.setDatahora((java.sql.Date) data);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }*/

        CertificacaoBLL.create(cert);
    }

    public void switchToMenuEntidade(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("EntidadeCertificadora/MenuEntCertificadora.fxml"));
        stage = (Stage) ((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setTitle("Menu de Entidade Certificadora");
        stage.setScene(scene);
        stage.show();
    }

    public void initialize() {
        colunaNome.setCellValueFactory(new PropertyValueFactory<Produtor, String>("nome"));
        tabelaProdutores.setItems(getUsers());
    }
}
