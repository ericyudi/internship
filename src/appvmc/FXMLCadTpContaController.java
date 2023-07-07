/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appvmc;

import DAL.DALMarca;
import DAL.DALtipoconta;
import Entidades.Marca;
import Entidades.tipoconta;
import Util.MaskFieldUtil;
import appvmc.FXMLDocumentController;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author eric-
 */
public class FXMLCadTpContaController implements Initializable {

    @FXML
    private SplitPane painel;
    @FXML
    private AnchorPane pnDados;
    @FXML
    private JFXTextField txCod;
    @FXML
    private JFXTextField txNome;
    @FXML
    private JFXTextField txPesquisa;
    @FXML
    private JFXComboBox<String> cbfiltro;
    @FXML
    private TableView<tipoconta> tabela;
    @FXML
    private TableColumn<tipoconta, Integer> colcod;
    @FXML
    private TableColumn<tipoconta, String> colnome;
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

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                fadeout();
        colcod.setCellValueFactory(new PropertyValueFactory("cod"));
        colnome.setCellValueFactory(new PropertyValueFactory("nome"));
        
        estadoOriginal();
    }    
 private void fadeout() {
        FadeTransition ft = new FadeTransition(Duration.millis(1000), painel);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.play();
        MaskFieldUtil.maxField(txNome, 30);
        MaskFieldUtil.letterField(txNome);
    }
    
        private void estadoOriginal() {
        txCod.setDisable(true);
        pnDados.setDisable(true);
        btConfirmar.setDisable(true);
        btCancelar.setDisable(false);
        btNovo.setDisable(false);
        btApagar.setDisable(true);
        btAlterar.setDisable(true);
        ObservableList<Node> componentes = pnDados.getChildren(); //”limpa” os componentes
        for (Node n : componentes) {
            if (n instanceof TextInputControl) // textfield, textarea e htmleditor
            {
                ((TextInputControl) n).setText("");
            }
            if (n instanceof ComboBox) {
                ((ComboBox) n).getItems().clear();
            }
        }
        carregaTabela("");
        carregacbfiltro();
    }    
        void carregacbfiltro() {
        ObservableList<String> filtro
                = FXCollections.observableArrayList(
                        "Nome"
                );
        cbfiltro.setItems(filtro);
    }
        private void carregaTabela(String filtro) {
        tipoconta dal = new tipoconta();
        List<tipoconta> res = dal.get(filtro);
        ObservableList<tipoconta> modelo;
        modelo = FXCollections.observableArrayList(res);
        tabela.setItems(modelo);
    }  
    @FXML
    private void clkTxPesquisa(KeyEvent event) {
    }

    @FXML
    private void clkBtProcurar(ActionEvent event) {
                        if (cbfiltro.getValue() == null) {
            carregaTabela("upper(nome) like '%" + txPesquisa.getText().toUpperCase() + "%'");
        } else if (cbfiltro.getValue().equals("Nome")) {
            carregaTabela("upper(nome) like '%" + txPesquisa.getText().toUpperCase() + "%'");
        }
    }

    @FXML
    private void clkTabela(MouseEvent event) {
          if (tabela.getSelectionModel().getSelectedIndex() >= 0) {
            btAlterar.setDisable(false);
            btApagar.setDisable(false);
        }
    }

  @FXML
    private void btnNovoSaiu(MouseEvent event) {
        btNovo.setStyle("-fx-background-color: ");
    }

    @FXML
    private void btnNovoEntrou(MouseEvent event) {
        btNovo.setStyle("-fx-background-color: #c2b29c");
    }

    @FXML
    private void clkBtNovo(ActionEvent event) {
        estadoEdicao();
    }
    private void estadoEdicao() {     // carregar os componentes da tela (listbox, combobox, ...)
        // p.e. : carregaEstados();
        pnDados.setDisable(false);
        txCod.setDisable(true);
        btConfirmar.setDisable(false);
        txNome.requestFocus();
        txNome.setDisable(false);
    }

     @FXML
    private void btnAlterarSaiu(MouseEvent event) {
        btAlterar.setStyle("-fx-background-color: ");
    }

    @FXML
    private void btnAlterarEntrou(MouseEvent event) {
        btAlterar.setStyle("-fx-background-color: #c2b29c");
    }

    @FXML
    private void clkBtAlterar(ActionEvent event) {
            if (tabela.getSelectionModel().getSelectedItem() != null) {
            tipoconta m = (tipoconta) tabela.getSelectionModel().getSelectedItem();
            txCod.setText("" + m.getCod());
            txNome.setText("" + m.getNome());
            
            estadoEdicao();
        }
    }

    @FXML
    private void btnApagarSaiu(MouseEvent event) {
        btApagar.setStyle("-fx-background-color: ");
    }

    @FXML
    private void btnApagarEntrou(MouseEvent event) {
        btApagar.setStyle("-fx-background-color: #c2b29c");
    }

    @FXML
    private void clkBtApagar(ActionEvent event) {
                                Stage stage = new Stage();
        Alert a = new Alert(Alert.AlertType.CONFIRMATION);
        a.setTitle("Confirmação de Exclusão");
        a.setHeaderText("Confirmação de Exclusão!");
        a.setContentText("Confirma a exclusão?");
        stage = (Stage) a.getDialogPane().getScene().getWindow();
        if (a.showAndWait().get() == ButtonType.OK) {

            tipoconta m;
            m = (tipoconta) tabela.getSelectionModel().getSelectedItem();
            m.apagar();
            carregaTabela("");
            txCod.setText("");
        }
        stage.getIcons().clear();
    }

    @FXML
    private void btnConfirmarSaiu(MouseEvent event) {
        btConfirmar.setStyle("-fx-background-color: ");
    }

    @FXML
    private void btnConfirmarEntrou(MouseEvent event) {
        btConfirmar.setStyle("-fx-background-color: #c2b29c");
    }
    
        private boolean verifica() {
        if (!txNome.getText().isEmpty()) {
            return true;
        }
        return false;
    }
    @FXML
    private void clkBtConfirmar(ActionEvent event) {
                       Alert a = new Alert(Alert.AlertType.INFORMATION);
        Stage stage = new Stage();
        a.setTitle("Informação de Gravação/Alteração");
        a.setHeaderText("Informação de Gravação/Alteração");
        stage = (Stage)a.getDialogPane().getScene().getWindow();
        //a.setGraphic(icon);
        if(!verifica()){
            a.setContentText("Preencha o campo que é obrigatório(*): Nome");
        }
        else{
            int cod;
            try {
                cod = Integer.parseInt(txCod.getText());
            } catch (Exception e) {
                cod = 0;
            }
            tipoconta m = new tipoconta(cod, txNome.getText());
            if(m.getCod() == 0)
            {
                if(m.gravar()){
                    a.setContentText("Gravado com Sucesso");
                }
                else{

                    a.setContentText("Problemas ao Gravar");
                }
            }
            else{
                if(m.alterar())
                {
                    a.setContentText("Alterado com Sucesso");
                }
                else{
                    a.setContentText("Problemas ao alterar");
                }
            
        }
    }
        estadoOriginal();
        a.showAndWait();
        stage.getIcons().clear();
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
                if (!pnDados.isDisabled()) // encontra em estado de edição
        {
            estadoOriginal();
        } else {
            //Stage stage = (Stage) btCancelar.getScene().getWindow();
            //stage.close();
            FXMLDocumentController.spnprincipal.setCenter(null);
            FXMLDocumentController.efeito(false);
        }
    }
    
}
