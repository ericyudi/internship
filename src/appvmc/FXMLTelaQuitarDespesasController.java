/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appvmc;

import Entidades.cliente;
import Entidades.despesa;
import Entidades.entrada;
import Entidades.funcionario;
import Entidades.tipoconta;
import Entidades.venda;
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
import javafx.scene.control.MenuItem;
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
public class FXMLTelaQuitarDespesasController implements Initializable {

    @FXML
    private SplitPane painel;
    @FXML
    private JFXTextField txPesquisa;
    @FXML
    private JFXComboBox<String> cbFiltro;
    @FXML
    private TableView<despesa> tabela;
    @FXML
    private TableColumn<despesa, Integer> colcod;
    @FXML
    private TableColumn<despesa, String> colnome;
    @FXML
    private TableColumn<despesa, String> coldesc;
    @FXML
    private TableColumn<despesa, Double> colvalor;
    @FXML
    private TableColumn<despesa, LocalDate> coldtinicial;
    @FXML
    private TableColumn<despesa, tipoconta> coltipo;
    @FXML
    private TableColumn<despesa, String> colstatus;
    @FXML
    private TableColumn<despesa, funcionario> colpessoarel;
    @FXML
    private TableColumn<despesa, LocalDate> coldtvenc;
    @FXML
    private TableColumn<despesa, entrada> colentrada;
        private static despesa aux;
    @FXML
    private MenuItem entradamenu;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fadeout();
        colcod.setCellValueFactory(new PropertyValueFactory("cod_despesa"));
        colnome.setCellValueFactory(new PropertyValueFactory("nome"));
        coldesc.setCellValueFactory(new PropertyValueFactory("descricao"));
        colvalor.setCellValueFactory(new PropertyValueFactory("valor"));
        coldtinicial.setCellValueFactory(new PropertyValueFactory("dt_inicio"));
        coldtvenc.setCellValueFactory(new PropertyValueFactory("dt_venc"));
        coltipo.setCellValueFactory(new PropertyValueFactory("tp_conta"));
        colstatus.setCellValueFactory(new PropertyValueFactory("status"));
        colentrada.setCellValueFactory(new PropertyValueFactory("entr"));
        colpessoarel.setCellValueFactory(new PropertyValueFactory("func"));
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
                        "Nome",
                        "Status","Data Inicial","Data Vencimento","Valor"
                );
        cbFiltro.setItems(filtro);
    }
                            private void carregaTabela(String filtro) {
        despesa Pega = new despesa();
        List<despesa> res = Pega.get(filtro);
        ObservableList<despesa> modelo;
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
            carregaTabela("upper(nome) like '%" + txPesquisa.getText().toUpperCase() + "%'");
        } else if (cbFiltro.getValue().equals("Nome")) {
            carregaTabela("upper(nome) like '%" + txPesquisa.getText().toUpperCase() + "%'");
        } else if (cbFiltro.getValue().equals("Status")) {
            carregaTabela("upper(status) like '%" + txPesquisa.getText().toUpperCase() + "%'");
        } else if (cbFiltro.getValue().equals("Data inicial")) {
            carregaTabela("dt_inicio = '" + txPesquisa.getText().toUpperCase() + "'");
        }else if (cbFiltro.getValue().equals("Data Vencimento")) {
            carregaTabela("dt_venc = '" + txPesquisa.getText().toUpperCase() + "'");
        }
        else if (cbFiltro.getValue().equals("Valor")) {
            carregaTabela("valor = '" + txPesquisa.getText().toUpperCase() + "'");
        }
        }
         else
         carregaTabela("");
    }

    @FXML
    private void clkTabela(MouseEvent event) {
        if (tabela.getSelectionModel().getSelectedIndex() >= 0) {
            despesa c = (despesa) tabela.getSelectionModel().getSelectedItem();
            aux = c;
            if(c.getEntr() == null)
            {
                entradamenu.setDisable(true);
            }
            else
            {
               entradamenu.setDisable(false); 
            }
        }
    }

    @FXML
    private void clkpagamento(ActionEvent event) throws IOException {
                                FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLQuitarDespesas.fxml"));
                Parent root = loader.load();
                FXMLQuitarDespesasController cool =  loader.getController();
                Stage stage = new Stage();
                stage.setTitle("Pagamento da despesa");
               
                stage.setScene(new Scene(root));
                stage.show();  
    }


    @FXML
    private void clkentrada(ActionEvent event) throws IOException {
               FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLMostraEntrada.fxml"));
                Parent root = loader.load();
                FXMLMostraEntradaController cool =  loader.getController();
                Stage stage = new Stage();
                stage.setTitle("Entrada");
               
                stage.setScene(new Scene(root));
                stage.show(); 
        
    }
    public static despesa getDespesa() {
        return aux;
    }
    
    
}
