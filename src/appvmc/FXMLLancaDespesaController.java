/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appvmc;

import Entidades.Calcados;
import Entidades.Marca;
import Entidades.despesa;
import Entidades.entrada;
import Entidades.funcionario;
import Entidades.tipoconta;
import Util.MaskFieldUtil;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
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
import javafx.scene.control.ButtonType;
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
public class FXMLLancaDespesaController implements Initializable {

    @FXML
    private SplitPane painel;
    @FXML
    private AnchorPane pnDados;
    @FXML
    private JFXTextField txCod;
    @FXML
    private JFXTextField txdespnome;
    @FXML
    private JFXTextField txDesc;
    @FXML
    private JFXComboBox<tipoconta> cbtipo;
    @FXML
    private JFXComboBox<String> cbstatus;
    @FXML
    private JFXTextField txValor;
    @FXML
    private JFXTextField txparc;
    @FXML
    private JFXDatePicker dtdiainicial;
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
    private JFXDatePicker dtvencimento;
    @FXML
    private Label lbstatus;
    @FXML
    private Label lbnome;
    @FXML
    private Label lbtpconta;
    @FXML
    private Label lbvrtotal;
    @FXML
    private Label lbparcelas;
    @FXML
    private TableColumn<despesa, LocalDate> coldtvenc;
    private static funcionario aux;
    @FXML
    private TableColumn<despesa, entrada> colentradacod;
    private String nomeold = "";
    @FXML
    private Label lbdtinicial;
    @FXML
    private Label lbdtvenc;
    @FXML
    private Label lbvencinicio;
    @FXML
    private Label lbinicioinicio;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        aux = FXMLAutenticacaoController.getLogin();
        fadeout();
        colcod.setCellValueFactory(new PropertyValueFactory("cod_despesa"));
        colnome.setCellValueFactory(new PropertyValueFactory("nome"));
        coldesc.setCellValueFactory(new PropertyValueFactory("descricao"));
        colvalor.setCellValueFactory(new PropertyValueFactory("valor"));
        coldtinicial.setCellValueFactory(new PropertyValueFactory("dt_inicio"));
        coldtvenc.setCellValueFactory(new PropertyValueFactory("dt_venc"));
        colstatus.setCellValueFactory(new PropertyValueFactory("status"));
        coltipo.setCellValueFactory(new PropertyValueFactory("tp_conta"));
        colpessoarel.setCellValueFactory(new PropertyValueFactory("func"));
        colentradacod.setCellValueFactory(new PropertyValueFactory("entr"));
        dtdiainicial.setValue(LocalDate.now());
        estadoOriginal();
    }    
    private void fadeout()
    {
        FadeTransition ft = new FadeTransition(Duration.millis(1000), painel);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.play();
        MaskFieldUtil.maxField(txDesc, 45);
        MaskFieldUtil.letterField(txDesc);
        MaskFieldUtil.maxField(txdespnome, 45);
        MaskFieldUtil.letterField(txdespnome);
        MaskFieldUtil.numericField(txparc);
        MaskFieldUtil.monetaryField(txValor);
    }
        private void estadoEdicao() {     // carregar os componentes da tela (listbox, combobox, ...)
        // p.e. : carregaEstados();
                   lbinicioinicio.setVisible(false);
           lbvencinicio.setVisible(false);
        pnDados.setDisable(false);
        txCod.setDisable(true);
        btConfirmar.setDisable(false);
        btNovo.setDisable(true);
        btApagar.setDisable(true);
        btAlterar.setDisable(true);
        txdespnome.requestFocus();
    }
     private void estadoOriginal()
    {
        botatudofalse();
        txCod.setDisable(true);
        pnDados.setDisable(true);
        btConfirmar.setDisable(true);
        btCancelar.setDisable(false);
        btNovo.setDisable(false);
        btApagar.setDisable(true);
        btAlterar.setDisable(true);
        cbtipo.getSelectionModel().select(-1);
        cbstatus.getSelectionModel().select(-1);
        ObservableList <Node> componentes=pnDados.getChildren(); //”limpa” os componentes
        for(Node n : componentes)
        {
            if (n instanceof TextInputControl)  // textfield, textarea e htmleditor
                ((TextInputControl)n).setText("");
        }
        carregaTabela("");
        //carregaTabela("status = 'S'");
        carregacbfiltro();
    }
             private void carregaTabela(String filtro) {
        despesa Pega = new despesa();
        cbtipo.setItems(FXCollections.observableArrayList(new tipoconta().get("")));
        List<despesa> res = Pega.get(filtro);
        ObservableList<despesa> modelo;
        modelo = FXCollections.observableArrayList(res);
        tabela.setItems(modelo);
    }
                     void carregacbfiltro() {
        ObservableList<String> filtro
                = FXCollections.observableArrayList(
                        "Nome","Status"//fazer filtro com data
                );
        ObservableList<String> status
                = FXCollections.observableArrayList(
                        "Pago","Nao Pago"
                );
        cbFiltro.setItems(filtro);
        cbstatus.setItems(status);
        cbstatus.getSelectionModel().select(1);
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
        } 
        }
        else{
         carregaTabela("");
         //carregaTabela("status = 'S'");
        }
        
    }

    @FXML
    private void clkTabela(MouseEvent event) {
                despesa c = (despesa)tabela.getSelectionModel().getSelectedItem();
        char status = c.getStatus();
        if(tabela.getSelectionModel().getSelectedIndex()>=0 && status != 'S')
        {
           btAlterar.setDisable(false);
           btApagar.setDisable(false);
        }
        else
        {
            btAlterar.setDisable(true);
           btApagar.setDisable(true);
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
                if(tabela.getSelectionModel().getSelectedItem()!=null)
        {
            despesa c = (despesa)tabela.getSelectionModel().getSelectedItem();
            nomeold=c.getNome();
            txCod.setText(""+c.getCod_despesa());
            txdespnome.setText(c.getNome());
            if(c.getDescricao().isEmpty())
                txDesc.setText("");
            else
                txDesc.setText(c.getDescricao());
            txValor.setText(String.format("%10.2f",c.getValor()));
            txparc.setText(String.valueOf(0));
            dtvencimento.setValue(c.getDt_venc());
            dtdiainicial.setValue(c.getDt_inicio());
            if(c.getStatus() == 'S')
            {
                cbstatus.getSelectionModel().select(0);
            }
            else
                cbstatus.getSelectionModel().select(1);
            cbtipo.getSelectionModel().select(0);
            cbtipo.getSelectionModel().select(c.getTp_conta());
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
        stage = (Stage)a.getDialogPane().getScene().getWindow();
        if (a.showAndWait().get() == ButtonType.OK) {
            despesa c;
            c = tabela.getSelectionModel().getSelectedItem();
            c.apagar();
            carregaTabela("");
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
     private boolean verifica()
    {
        if(!txdespnome.getText().isEmpty()&&cbstatus.getValue() != null &&
           cbtipo.getValue() != null && !txValor.getText().isEmpty() && !txparc.getText().isEmpty()
           && dtvencimento.getValue() != null && dtdiainicial.getValue() != null && dtdiainicial.getValue().compareTo(LocalDate.now())<=0 
                && dtvencimento.getValue().compareTo(LocalDate.now())>0)
            return true;
        
        if(txdespnome.getText().isEmpty())
            lbnome.setVisible(true);
        if(txValor.getText().isEmpty())
            lbvrtotal.setVisible(true);
        if(cbtipo.getSelectionModel().getSelectedIndex() == -1)
            lbtpconta.setVisible(true);
        if(txparc.getText().isEmpty())
            lbparcelas.setVisible(true);
        if(cbstatus.getSelectionModel().getSelectedIndex() == -1)
            lbstatus.setVisible(true);
        if(dtdiainicial.getValue().compareTo(LocalDate.now())>0)
            lbdtinicial.setVisible(true);
        if(dtvencimento.getValue() != null){
        if(dtvencimento.getValue().compareTo(LocalDate.now())<0)
            lbdtvenc.setText("Data de Vencimento menor do que hoje!");
            lbdtvenc.setVisible(true);
        }
        else{
            lbdtvenc.setText("Data de Vencimento não selecionada!");
            lbdtvenc.setVisible(true);
        }
        return false;
    }
     private void botatudofalse()
     {
         lbnome.setVisible(false);
         lbvrtotal.setVisible(false);
         lbtpconta.setVisible(false);
         lbparcelas.setVisible(false);
         lbstatus.setVisible(false);
         lbdtinicial.setVisible(false);
         lbdtvenc.setVisible(false);
         lbdtvenc.setText("Data de Vencimento menor do que hoje!");
     }
    @FXML
    private void clkBtConfirmar(ActionEvent event) {
                Alert a = new Alert(Alert.AlertType.INFORMATION);
        Stage stage = new Stage();
        a.setTitle("Informação de Gravação/Alteração");
        a.setHeaderText("Informação de Gravação/Alteração");
        stage = (Stage)a.getDialogPane().getScene().getWindow();
        if(!verifica()){
            a.setContentText("Preencha os campos que são obrigatórios(*)");
        }
        else{
            int cod;
            try {
                cod = Integer.parseInt(txCod.getText());
            } catch (Exception e) {
                cod = 0;
            }
            int cont = 0;
            char pepe;
            if(cbstatus.getValue().toUpperCase().charAt(0)=='P'){
                pepe = 'S';
            }
            else
                pepe = 'N';
            int numero = Integer.parseInt(txparc.getText());
            double valort = Double.parseDouble(txValor.getText().replace(".","").replace(",", "."))/Integer.parseInt(txparc.getText());
            despesa t = new despesa(cod,aux,cbtipo.getValue(), null,txdespnome.getText(),
                    txDesc.getText(),pepe, valort,dtvencimento.getValue(),dtdiainicial.getValue()
                                );
            int penco = 2;
            if(t.getCod_despesa() == 0)
            {
                if(t.gravar()){
                    while(numero-1>0)
                    {
                        cont++;
                        despesa f = new despesa(cod, aux, cbtipo.getValue(), null, txdespnome.getText(),
                                txDesc.getText(), pepe, valort, dtvencimento.getValue().plusMonths(cont), dtdiainicial.getValue()
                        );
                        f.gravar();
                        penco++;
                        numero--;
                    }
                    a.setContentText("Gravado com Sucesso");
                }
                else{
                    a.setContentText("Problemas ao Gravar");
                }
            }
            else
            {
                t.setValor(Double.parseDouble(txValor.getText().replace(".","").replace(",", ".")));
                if(t.alterageral()){
                    a.setContentText("Alterado com Sucesso");
                }
                else{
                    a.setContentText("Problemas ao Alterar");
                }
                
            }
            estadoOriginal();
        }
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
            //FXMLDocumentController.efeito(false);
        }
    }

    @FXML
    private void clkdtvencimento(ActionEvent event) {
    }
    
}
