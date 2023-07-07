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
public class FXMLRegistrarCalcadosController implements Initializable {

    @FXML
    private SplitPane painel;
    @FXML
    private AnchorPane pnDados;
    @FXML
    private JFXTextField txCod;
    @FXML
    private JFXTextField txNome;
    @FXML
    private JFXTextField txfornecedor;
    @FXML
    private JFXComboBox<?> cbmarca;
    @FXML
    private JFXTextField txquantidade;
    @FXML
    private JFXTextField txtamanho;
    @FXML
    private JFXTextField txvaloruni;
    @FXML
    private JFXTextField txvalorven;
    @FXML
    private JFXTextField txcor;
    @FXML
    private JFXDatePicker dtcompra;
    @FXML
    private JFXComboBox<?> cbmetodopag;
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
    private TableColumn<?, ?> coltam;
    @FXML
    private TableColumn<?, ?> colvalcomp;
    @FXML
    private TableColumn<?, ?> colvalvend;
    @FXML
    private TableColumn<?, ?> coldatacomp;
    @FXML
    private TableColumn<?, ?> colmetodopag;
    @FXML
    private JFXButton btNovo;
    @FXML
    private JFXButton btAlterar;
    @FXML
    private JFXButton btApagar;
    @FXML
    private JFXButton btConfirmar;
    @FXML
    private JFXButton btCancelar;
    @FXML
    private JFXButton btexiste;
    @FXML
    private JFXComboBox<?> cbgenero;

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
    private void clkBtNovo(ActionEvent event) {
    }

    @FXML
    private void btnAlterarSaiu(MouseEvent event) {
    }

    @FXML
    private void btnAlterarEntrou(MouseEvent event) {
    }

    @FXML
    private void clkBtAlterar(ActionEvent event) {
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
    private void btnConfirmarSaiu(MouseEvent event) {
    }

    @FXML
    private void btnConfirmarEntrou(MouseEvent event) {
    }

    @FXML
    private void clkBtConfirmar(ActionEvent event) {
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
    
}
