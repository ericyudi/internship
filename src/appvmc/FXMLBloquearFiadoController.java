/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appvmc;

import Entidades.cliente;
import Util.MaskFieldUtil;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
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
    private JFXComboBox<String> cbstatus;
    @FXML
    private JFXTextField txPesquisa;
    @FXML
    private JFXComboBox<String> cbfiltro;
    @FXML
    private TableView<cliente> tabela;
    @FXML
    private TableColumn<cliente, Integer> colcod;
    @FXML
    private TableColumn<cliente, String> colnome;
    @FXML
    private TableColumn<cliente, String> colCPF;
    @FXML
    private TableColumn<cliente, String> coltelefone;
    @FXML
    private JFXDatePicker dtbloqueio;
    @FXML
    private JFXButton btbloquear;
    @FXML
    private TableColumn<cliente, String> colmotivo;
    @FXML
    private TableColumn<cliente, String> colfiado;
    @FXML
    private TableColumn<cliente, Double> collimitefiado;
    @FXML
    private TableColumn<cliente, Double> colsaldofiado;
    @FXML
    private TableColumn<cliente, LocalDate> coldtbloqueio;
    @FXML
    private JFXButton btConfirmar;
    @FXML
    private JFXButton btCancelar;
    private String erro="";
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                 fadeout();
        colcod.setCellValueFactory(new PropertyValueFactory("cod"));
        colnome.setCellValueFactory(new PropertyValueFactory("nome"));
        colCPF.setCellValueFactory(new PropertyValueFactory("cpf"));
        colmotivo.setCellValueFactory(new PropertyValueFactory("motivo"));
        coltelefone.setCellValueFactory(new PropertyValueFactory("telefone"));
        colfiado.setCellValueFactory(new PropertyValueFactory("fiado"));
        collimitefiado.setCellValueFactory(new PropertyValueFactory("lim_fiado"));
        colsaldofiado.setCellValueFactory(new PropertyValueFactory("saldofiado"));
        coldtbloqueio.setCellValueFactory(new PropertyValueFactory("databloqueio"));
        estadoOriginal();
        // TODO
    }    
        private void fadeout() {
        FadeTransition ft = new FadeTransition(Duration.millis(1000), painel);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.play();
        MaskFieldUtil.maxField(txmotivo,100);
    }
                private void estadoOriginal() {
        txCod.setDisable(true);
        btConfirmar.setDisable(true);
        btCancelar.setDisable(false);
        cbstatus.setVisible(true);
        pnDados.setDisable(true);
        btbloquear.setDisable(true);
        txmotivo.setDisable(true);
        dtbloqueio.setDisable(true);
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
    private void estadoEdicao() {     // carregar os componentes da tela (listbox, combobox, ...)
        // p.e. : carregaEstados();
        pnDados.setDisable(false);
        txCod.setDisable(true);
        btConfirmar.setDisable(false);
        txmotivo.setDisable(false);
        cbstatus.setDisable(false);
        dtbloqueio.setDisable(false);
    }
            private void carregaTabela(String filtro) {
        cliente dal = new cliente();
        List<cliente> res = dal.get(filtro);
        ObservableList<cliente> modelo;
        modelo = FXCollections.observableArrayList(res);
        tabela.setItems(modelo);
    }
                void carregacbfiltro() {
        ObservableList<String> filtro
                = FXCollections.observableArrayList(
                        "Nome",
                        "CPF"
                );
                ObservableList<String> fiado
                = FXCollections.observableArrayList(
                        "Liberado",
                        "Bloqueado"
                );
        cbstatus.setItems(fiado);
        cbfiltro.setItems(filtro);
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
        } else if (cbfiltro.getValue().equals("CPF")) {
            carregaTabela("cpf like '%" + txPesquisa.getText() + "%'");
        } 
    }

    @FXML
    private void clkTabela(MouseEvent event) {
                if (tabela.getSelectionModel().getSelectedIndex() >= 0) {
            cliente c = (cliente) tabela.getSelectionModel().getSelectedItem();
            if(c.getFiado() == 'S'){
            btbloquear.setDisable(false);
            }
            else
            {
                btbloquear.setDisable(true);
            }
        }
    }
     private boolean verifica() {
        if (cbstatus.getSelectionModel().getSelectedIndex() != -1 && cbstatus.getSelectionModel().getSelectedIndex() != 0 && dtbloqueio.getValue()!=null) {
            return true;
        }

        erro="";

         if(cbstatus.getSelectionModel().getSelectedIndex() == 0){
             erro+="Status não alterado!\n";
         }
         if(dtbloqueio.getValue()==null){
             erro+="Data de bloqueio não selecionada!\n";
         }
        return false;
    }
    @FXML
    private void btnNovoSaiu(MouseEvent event) {
        btbloquear.setStyle("-fx-background-color: ");
    }

    @FXML
    private void btnNovoEntrou(MouseEvent event) {
        btbloquear.setStyle("-fx-background-color: #c2b29c");
    }

    @FXML
    private void clkBtbloquear(ActionEvent event) {
        if (tabela.getSelectionModel().getSelectedItem() != null) {
            cliente c = (cliente) tabela.getSelectionModel().getSelectedItem();
            cbstatus.getSelectionModel().select(0);
             txCod.setText("" + c.getCod());
        }
                        estadoEdicao();
    }

    @FXML
    private void btnConfirmarSaiu(MouseEvent event) {
        btConfirmar.setStyle("-fx-background-color: ");
    }

    @FXML
    private void btnConfirmarEntrou(MouseEvent event) {
        btConfirmar.setStyle("-fx-background-color: #c2b29c");
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
            a.setContentText("ERRO: \n"+erro);
        }
        else{
            int cod;
            try {
                cod = Integer.parseInt(txCod.getText());
            } catch (Exception e) {
                cod = 0;
            }
            /*cliente c = new cliente(cod, txNome.getText(), 
                    txCpf.getText(),txtelefone.getText(),txemail.getText(),txrg.getText(),cbuf.getValue(),txcidade.getText(),txcep.getText(), 
                    txbairro.getText(),txend.getText(), Integer.parseInt(txnumero.getText()),
                    Double.parseDouble(txfiado.getText().replace(",", ".")),'f',Double.parseDouble(txfiado.getText().replace(",", ".")), horahj);*/
            cliente c = new cliente().get(cod);
            c.setFiado('N');
            c.setLim_fiado(0);
            c.setSaldofiado(0);
            LocalDate lc = dtbloqueio.getValue();
            c.setDatabloqueio(lc);
            if(txmotivo.getText().isEmpty())
            {
                c.setMotivo("");
            }
            else
            {
               c.setMotivo(txmotivo.getText()); 
            }
            if(c.alterarBloqFiado())
                {
                    a.setContentText("Alterado com Sucesso");
                }
                else{
                    a.setContentText("Problemas ao alterar");
                }  
        }

        estadoOriginal();
        a.showAndWait();
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
            //FXMLDocumentController.efeito(false);
        }
    }
    
}
