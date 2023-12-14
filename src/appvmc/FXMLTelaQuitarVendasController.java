/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appvmc;

import Entidades.Calcados;
import Entidades.Marca;
import Entidades.cliente;
import Entidades.venda;
import Util.MaskFieldUtil;
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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputControl;
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
public class FXMLTelaQuitarVendasController implements Initializable {

    @FXML
    private SplitPane painel;
    @FXML
    private JFXTextField txPesquisa;
    @FXML
    private JFXComboBox<String> cbFiltro;
    @FXML
    private TableView<venda> tabela;
    @FXML
    private TableColumn<venda, Integer> colcod;
    @FXML
    private TableColumn<venda, cliente> colcliente;
    @FXML
    private TableColumn<venda, String> coldesc;
    @FXML
    private TableColumn<venda, Double> colvalorT;
    @FXML
    private TableColumn<venda, LocalDate> coldtinicial;
    @FXML
    private TableColumn<venda, String> colfiado;
    @FXML
    private TableColumn<venda, String> colquit;
    @FXML
    private TableColumn<venda, LocalDate> coldtquit;
    @FXML
    private TableColumn<venda, String> colcoment;
    private static venda aux;
    @FXML
    private JFXButton btCancelar;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                fadeout();
        colcod.setCellValueFactory(new PropertyValueFactory("cod_venda"));
        colcliente.setCellValueFactory(new PropertyValueFactory("clientes"));
        colvalorT.setCellValueFactory(new PropertyValueFactory("valortotal"));
        coldesc.setCellValueFactory(new PropertyValueFactory("descricao"));
        coldtinicial.setCellValueFactory(new PropertyValueFactory("DataVenda"));
        colfiado.setCellValueFactory(new PropertyValueFactory("fiado"));
        colquit.setCellValueFactory(new PropertyValueFactory("quitada"));
        coldtquit.setCellValueFactory(new PropertyValueFactory("dtquitacao"));
        colcoment.setCellValueFactory(new PropertyValueFactory("comentarios"));
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
                        "Fiado",
                        "Quitada","Data inicial","Cliente"
                );
        cbFiltro.setItems(filtro);
    }
            private void carregaTabela(String filtro) {
        venda Pega = new venda();
        List<venda> res = Pega.get(filtro);
        ObservableList<venda> modelo;
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
            carregaTabela("upper(fiado) like '%" + txPesquisa.getText().toUpperCase() + "%'");
        } else if (cbFiltro.getValue().equals("Fiado")) {
            carregaTabela("upper(fiado) like '%" + txPesquisa.getText().toUpperCase() + "%'");
        } else if (cbFiltro.getValue().equals("Quitada")) {
            carregaTabela("upper(quitada) like '%" + txPesquisa.getText().toUpperCase() + "%'");
        } else if (cbFiltro.getValue().equals("Data inicial")) {
            carregaTabela("datavenda = '" + txPesquisa.getText().toUpperCase() + "'");
        }else if (cbFiltro.getValue().equals("Cliente")) {
            cliente dalc = new cliente().getcomnome(txPesquisa.getText().toUpperCase());
            if(dalc!=null)
            carregaTabela("cod_cliente = "+dalc.getCod()+"");
        }
        }
         else
         carregaTabela("");
    }

    @FXML
    private void clkTabela(MouseEvent event) {
                  if (tabela.getSelectionModel().getSelectedIndex() >= 0) {

            venda c = (venda) tabela.getSelectionModel().getSelectedItem();
            aux = c;
        }
    }

    @FXML
    private void clkpagamento(ActionEvent event) throws IOException {
                        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLQuitarVendas.fxml"));
                Parent root = loader.load();
                FXMLQuitarVendasController cool =  loader.getController();
                Stage stage = new Stage();
                stage.setTitle("Pagamento da Venda");
               
                stage.setScene(new Scene(root));
                stage.show();  
    }

    @FXML
    private void clkitensvenda(ActionEvent event) throws IOException {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLItensVenda.fxml"));
                Parent root = loader.load();
                FXMLItensVendaController cool =  loader.getController();
                Stage stage = new Stage();
                stage.setTitle("Itens da Venda");
               
                stage.setScene(new Scene(root));
                stage.show();  
    }

        public static venda getVenda() {
        return aux;
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
}
