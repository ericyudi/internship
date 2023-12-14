/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appvmc;

import Entidades.cliente;
import Entidades.despesa;
import Entidades.fiado;
import Entidades.venda;
import static appvmc.FXMLQuitarVendasController.aux;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author eric-
 */
public class FXMLTelaQuitarFiadoController implements Initializable {

    @FXML
    private SplitPane painel;
    @FXML
    private JFXTextField txPesquisa;
    @FXML
    private JFXComboBox<String> cbFiltro;
    @FXML
    private TableView<fiado> tabela;
    @FXML
    private TableColumn<fiado, Integer> colcod;
    @FXML
    private TableColumn<fiado, cliente> colcliente;
    @FXML
    private TableColumn<fiado, Double> colvalorT;
    @FXML
    private TableColumn<fiado, Double> colvalorP;
    @FXML
    private TableColumn<fiado, LocalDate> coldtinicial;
    @FXML
    private TableColumn<fiado, String> colobs;
    @FXML
    private JFXButton btCancelar;
        private static fiado aux;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       fadeout();
        colcod.setCellValueFactory(new PropertyValueFactory("cod_fiado"));
        colcliente.setCellValueFactory(new PropertyValueFactory("cli"));    
        colvalorT.setCellValueFactory(new PropertyValueFactory("vrfiado"));    
        colvalorP.setCellValueFactory(new PropertyValueFactory("valorpago"));    
        coldtinicial.setCellValueFactory(new PropertyValueFactory("dtfiado"));
        colobs.setCellValueFactory(new PropertyValueFactory("observacao"));

        carregaTabela("");
        carregacbfiltro();
    }    
    private void fadeout() {
        FadeTransition ft = new FadeTransition(Duration.millis(1000), painel);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.play();

    }
                    void carregacbfiltro() {
        ObservableList<String> filtro
                = FXCollections.observableArrayList(
                        "Data Inicial","Observacao"
                );
        cbFiltro.setItems(filtro);
    }
                            private void carregaTabela(String filtro) {
        fiado Pega = new fiado();
        List<fiado> res = Pega.get(filtro);
        ObservableList<fiado> modelo;
        modelo = FXCollections.observableArrayList(res);
        tabela.setItems(modelo);
    }
    @FXML
    private void clkTxPesquisa(KeyEvent event) {
    }

    @FXML
    private void clkBtProcurar(ActionEvent event) {
              if(!txPesquisa.getText().isEmpty()){
                if (cbFiltro.getValue() == null) {
            carregaTabela("datapag = '" + txPesquisa.getText().toUpperCase() + "'");
        }if (cbFiltro.getValue().equals("Data Inicial")){
            carregaTabela("datapag = '" + txPesquisa.getText().toUpperCase() + "'");
        }else if (cbFiltro.getValue().equals("Observacao")) {
            carregaTabela("upper(observacao) like '%" + txPesquisa.getText().toUpperCase() + "%'");
        } 
        }
         else
         carregaTabela("");
    }

    @FXML
    private void clkpagamento(ActionEvent event) throws IOException {
                                        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLQuitarFiado.fxml"));
                Parent root = loader.load();
                FXMLQuitarFiadoController cool =  loader.getController();
                Stage stage = new Stage();
                stage.setTitle("Pagamento do fiado");
               
                stage.setScene(new Scene(root));
                stage.show();  
    }


    @FXML
    private void clkTabela(MouseEvent event) {
                if (tabela.getSelectionModel().getSelectedIndex() >= 0) {
            fiado c = (fiado) tabela.getSelectionModel().getSelectedItem();
            aux = c;
        }
    }

    @FXML
    private void btnCancelarSaiu(MouseEvent event) {
        btCancelar.setStyle("-fx-background-color: ");
    }

    @FXML
    private void btnCancelarEntrou(MouseEvent event) {
        btCancelar.setStyle("-fx-background-color: #c2b29c");
    }

    @FXML
    private void clkBtCancelar(ActionEvent event) {
         FXMLDocumentController.spnprincipal.setCenter(null);
            //FXMLDocumentController.efeito(false);
    }
            public static fiado getFiado() {
        return aux;
    }
    
}
