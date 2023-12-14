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
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.Label;
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
public class FXMLLiberarFiadoController implements Initializable {

    @FXML
    private SplitPane painel;
    @FXML
    private AnchorPane pnDados;
    @FXML
    private JFXTextField txCod;
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
    private TableColumn<cliente, String> colrg;
    @FXML
    private JFXButton btliberar;
    @FXML
    private JFXTextField txlimite;
    @FXML
    private TableColumn<cliente, String> colfiado;
    @FXML
    private TableColumn<cliente, Double> collimitefiado;
    @FXML
    private TableColumn<cliente, Double> colsaldofiado;
    @FXML
    private TableColumn<cliente, LocalDate> coldtbloqueio;
    @FXML
    private JFXButton btlimiyr;
    @FXML
    private JFXButton btConfirmar;
    @FXML
    private JFXButton btCancelar;
    private int flag=0;
    private String erro="";
    private double limiteant;
    @FXML
    private Label asterisco;
    @FXML
    private TableColumn<cliente, String> colmotivo;
    @FXML
    private JFXButton btsaldo;
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
    }    
    private void fadeout() {
        FadeTransition ft = new FadeTransition(Duration.millis(1000), painel);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.play();
        MaskFieldUtil.monetaryField(txlimite);
        
    }
        
        private void estadoOriginal() {
        txCod.setDisable(true);
        btConfirmar.setDisable(true);
        btCancelar.setDisable(false);
        cbstatus.setVisible(true);
        asterisco.setVisible(true);
        pnDados.setDisable(true);
        btliberar.setDisable(true);
        btlimiyr.setDisable(true);
        btsaldo.setDisable(true);
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
        txlimite.setDisable(false);
        cbstatus.setDisable(false);

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
            if(c.getFiado() == 'N'){
            btliberar.setDisable(false);
                            btlimiyr.setDisable(true);
                btsaldo.setDisable(true);
            }
            else
            {
                btliberar.setDisable(true);
                btlimiyr.setDisable(false);
                btsaldo.setDisable(false);
            }
        }
    }

    @FXML
    private void btnNovoSaiu(MouseEvent event) {
        btliberar.setStyle("-fx-background-color: ");
    }

    @FXML
    private void btnNovoEntrou(MouseEvent event) {
        btliberar.setStyle("-fx-background-color: #c2b29c");
    }
 private boolean verifica() {
     Double saldoatual=0.0;
        if(!txlimite.getText().isEmpty())
        saldoatual = Double.parseDouble(txlimite.getText().replace(".","").replace(",", "."));
        if (flag == 0 && !txlimite.getText().isEmpty() && cbstatus.getSelectionModel().getSelectedIndex() != -1 && cbstatus.getSelectionModel().getSelectedIndex() != 1) {
            return true;
        }
        if(flag == 1 && !txlimite.getText().isEmpty() && saldoatual>limiteant){
            return true;
        }
        if(flag == 2 && !txlimite.getText().isEmpty() && saldoatual<=limiteant){
            return true;
        }
        erro="";

         if(flag == 0 && cbstatus.getSelectionModel().getSelectedIndex() == 1){
             erro+="Status não alterado!\n";
         }
         if(flag == 0 && txlimite.getText().isEmpty()){
             erro+="Limite Vazio!\n";
         }
         if(flag == 1 && saldoatual<limiteant){
             erro+="Limite menor que saldo atual!\n";
         }
         if(flag == 1 && txlimite.getText().isEmpty()){
             erro+="Limite Vazio!\n";
         }
         if(flag == 2 && txlimite.getText().isEmpty()){
             erro+="Saldo Vazio!\n";
         }
         if(flag == 2 && saldoatual>limiteant){
             erro+="Saldo maior que o limite!\n";
         }
        return false;
    }
    @FXML
    private void clkBtLiberar(ActionEvent event) {
            if (tabela.getSelectionModel().getSelectedItem() != null) {
            cliente c = (cliente) tabela.getSelectionModel().getSelectedItem();
            cbstatus.setVisible(true);
            asterisco.setVisible(true);
            cbstatus.getSelectionModel().select(1);
             txCod.setText("" + c.getCod());
             flag = 0;
             txlimite.setPromptText("Limite");
        }
                        estadoEdicao();
    }

    @FXML
    private void btnLimiteSaiu(MouseEvent event) {
        btlimiyr.setStyle("-fx-background-color: ");
    }

    @FXML
    private void btnLimiteEntrou(MouseEvent event) {
        btlimiyr.setStyle("-fx-background-color: #c2b29c");
    }

    @FXML
    private void clkBtLimite(ActionEvent event) {
            if (tabela.getSelectionModel().getSelectedItem() != null) {
            cliente c = (cliente) tabela.getSelectionModel().getSelectedItem();
            cbstatus.setVisible(false);
            asterisco.setVisible(false);
             txCod.setText("" + c.getCod());
             flag = 1;
             limiteant = c.getSaldofiado();
             txlimite.setPromptText("Limite");
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
            if(flag == 0)
            {
                c.setFiado('S');
                c.setLim_fiado(Double.parseDouble(txlimite.getText().replace(".","").replace(",", ".")));
            }
            if(flag == 1)
            {
                c.setLim_fiado(Double.parseDouble(txlimite.getText().replace(".","").replace(",", ".")));
            }
            if(flag == 2)
            {
                c.setSaldofiado(Double.parseDouble(txlimite.getText().replace(".","").replace(",", ".")));
            }
            
            if(flag == 0){
            if(c.alterarLibFiado())
                {
                    a.setContentText("Alterado com Sucesso");
                }
                else{
                    a.setContentText("Problemas ao alterar");
                }
            }
            else
            {
                if(c.alterarLibFiado())
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

    @FXML
    private void clkBsaldo(ActionEvent event) {
                    if (tabela.getSelectionModel().getSelectedItem() != null) {
            cliente c = (cliente) tabela.getSelectionModel().getSelectedItem();
            cbstatus.setVisible(false);
            asterisco.setVisible(false);
             txCod.setText("" + c.getCod());
             flag = 2;
             limiteant = c.getLim_fiado();
             txlimite.setPromptText("Saldo");
        }
                        estadoEdicao();
    }

    @FXML
    private void btnSaldoSaiu(MouseEvent event) {
        btsaldo.setStyle("-fx-background-color: ");
    }

    @FXML
    private void btnSaldoEntrou(MouseEvent event) {
        btsaldo.setStyle("-fx-background-color: #c2b29c");
    }
    
}
