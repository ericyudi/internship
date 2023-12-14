/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appvmc;

import Entidades.Calcados;
import Entidades.TudoTeste;
import Entidades.cliente;
import Entidades.venda;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author eric-
 */
public class FXMLItensVendaController implements Initializable {

    @FXML
    private SplitPane painel;
    @FXML
    private AnchorPane pnDados;
    @FXML
    private Label labelnome;
    @FXML
    private Label labelcod;
    @FXML
    private Label lbvalor;
    @FXML
    private Label lbdatavenda;
    @FXML
    private TableView<TudoTeste> tabela;
    @FXML
    private TableColumn<TudoTeste, String> colcod;
    @FXML
    private TableColumn<TudoTeste, String> colnome;
    @FXML
    private TableColumn<TudoTeste, Integer> coltam;
    @FXML
    private TableColumn<TudoTeste, Integer> colqntd;
    @FXML
    private TableColumn<TudoTeste, String> colgenero;
    @FXML
    private TableColumn<TudoTeste, Double> colpreco;
    public static venda vendar;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        vendar = FXMLTelaQuitarVendasController.getVenda();
        lbdatavenda.setText("Data da Venda: "+vendar.getDataVenda().format(DateTimeFormatter.ofPattern("dd MMM uuuu")));
        lbvalor.setText("Valor Total:R$"+vendar.getValortotal());
        colcod.setCellValueFactory(new PropertyValueFactory("codesp"));
        colnome.setCellValueFactory(new PropertyValueFactory("nome"));
        colgenero.setCellValueFactory(new PropertyValueFactory("genero"));
        colqntd.setCellValueFactory(new PropertyValueFactory("qntd"));
        colpreco.setCellValueFactory(new PropertyValueFactory("valorvenda"));
        coltam.setCellValueFactory(new PropertyValueFactory("tam"));
        carregaTabela(vendar.getCod_venda());
    }    
        private void carregaTabela(int filtro) {
        TudoTeste Pega = new TudoTeste();
        //estoque Pegae = new estoque();
        List<TudoTeste> res = Pega.getItensVenda(filtro);
        //List<estoque> rese = Pegae.get2();
        ObservableList<TudoTeste> modelo;
        //ObservableList<estoque> modeloe;
        modelo = FXCollections.observableArrayList(res);
        //modeloe = FXCollections.observableArrayList(rese);
        tabela.setItems(modelo);
        //tabela.setItems(modeloe);
    }
    @FXML
    private void clkTabela(MouseEvent event) {
    }
    
}
