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
public class FXMLBloquearFiadoController implements Initializable {

    @FXML
    private SplitPane painel;
    @FXML
    private AnchorPane pnDados;
    @FXML
    private JFXTextField txCod;
    @FXML
    private JFXTextField txmotivo;
    @FXML
    private JFXComboBox<?> cbstatus;
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
    private TableColumn<?, ?> colCPF;
    @FXML
    private TableColumn<?, ?> coltelefone;
    @FXML
    private TableColumn<?, ?> colrg;
    @FXML
    private TableColumn<?, ?> colendereco;
    @FXML
    private TableColumn<?, ?> colnumero;
    @FXML
    private JFXDatePicker dtbloqueio;
    @FXML
    private JFXButton btbloquear;

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
    private void clkBtbloquear(ActionEvent event) {
    }
    
}
