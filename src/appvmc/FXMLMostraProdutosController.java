/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appvmc;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
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
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author eric-
 */
public class FXMLMostraProdutosController implements Initializable {

    @FXML
    private SplitPane painel;
    @FXML
    private AnchorPane pnDados;
    @FXML
    private TableView<?> tabela1;
    @FXML
    private TableColumn<?, ?> colcod1;
    @FXML
    private TableColumn<?, ?> colnome1;
    @FXML
    private TableColumn<?, ?> colmarca1;
    @FXML
    private TableColumn<?, ?> colcor1;
    @FXML
    private TableColumn<?, ?> colnumero1;
    @FXML
    private JFXTextField txPesquisa;
    @FXML
    private JFXComboBox<?> cbfiltro;
    @FXML
    private TableView<?> tabela;
    @FXML
    private TableColumn<?, ?> colcod;
    @FXML
    private TableColumn<?, ?> colnome;
    @FXML
    private TableColumn<?, ?> colmarca;
    @FXML
    private TableColumn<?, ?> colcor;
    @FXML
    private TableColumn<?, ?> colnumero;
    @FXML
    private JFXButton btAdd;
    @FXML
    private JFXButton btApagar;
    @FXML
    private JFXButton btCancelar;
    @FXML
    private AnchorPane pnDados1;
    @FXML
    private JFXTextField txCod;
    @FXML
    private JFXTextField txDesc;
    @FXML
    private JFXComboBox<?> cbCliente;
    @FXML
    private JFXComboBox<?> cbfiado;
    @FXML
    private JFXTextField txValor;
    @FXML
    private JFXTextField txparc;
    @FXML
    private JFXDatePicker dtdiainicio;
    @FXML
    private JFXDatePicker dtpagamento;
    @FXML
    private JFXComboBox<?> cbpago;
    @FXML
    private JFXButton btfinalizar;
    @FXML
    private JFXTextField txcoments;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clkTabela(MouseEvent event) {
    }

    @FXML
    private void clkTxPesquisa(KeyEvent event) {
    }

    @FXML
    private void clkBtProcurar(ActionEvent event) {
    }

    @FXML
    private void btnNovoSaiu(MouseEvent event) {
    }

    @FXML
    private void btnNovoEntrou(MouseEvent event) {
    }

    @FXML
    private void clkBtAdd(ActionEvent event) {
    }

    @FXML
    private void btnApagarSaiu(MouseEvent event) {
    }

    @FXML
    private void btnApagarEntrou(MouseEvent event) {
    }

    @FXML
    private void clkBtApagar(ActionEvent event) {
    }

    @FXML
    private void btnCancelarSaiu(MouseEvent event) {
    }

    @FXML
    private void btnCancelarEntrou(MouseEvent event) {
    }

    @FXML
    private void clkBtCancelar(ActionEvent event) {
    }

    @FXML
    private void clkdtpag(ActionEvent event) {
    }

    @FXML
    private void clkBtfinalizar(ActionEvent event) {
    }
    
}
