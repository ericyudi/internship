/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appvmc;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

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
    private JFXComboBox<?> cbFiltro;
    @FXML
    private TableView<?> tabela;
    @FXML
    private TableColumn<?, ?> colcod;
    @FXML
    private TableColumn<?, ?> colnome;
    @FXML
    private TableColumn<?, ?> coldesc;
    @FXML
    private TableColumn<?, ?> colvalor;
    @FXML
    private TableColumn<?, ?> colparc;
    @FXML
    private TableColumn<?, ?> coldtinicial;
    @FXML
    private TableColumn<?, ?> colpagamento;
    @FXML
    private TableColumn<?, ?> coltipo;
    @FXML
    private TableColumn<?, ?> colstatus;
    @FXML
    private TableColumn<?, ?> colpessoarel;
    @FXML
    private JFXButton btpagar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clkTxPesquisa(KeyEvent event) {
    }

    @FXML
    private void clkBtProcurar(ActionEvent event) {
    }

    @FXML
    private void clkTabela(MouseEvent event) {
    }

    @FXML
    private void btnNovoSaiu(MouseEvent event) {
    }

    @FXML
    private void btnNovoEntrou(MouseEvent event) {
    }

    @FXML
    private void clkBtpagar(ActionEvent event) {
    }
    
}