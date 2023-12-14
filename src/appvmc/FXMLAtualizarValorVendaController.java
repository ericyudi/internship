/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appvmc;

import Entidades.Calcados;
import Entidades.Marca;
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
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author eric-
 */
public class FXMLAtualizarValorVendaController implements Initializable {

    @FXML
    private SplitPane painel;
    @FXML
    private AnchorPane pnDados;
    @FXML
    private JFXTextField txPesquisa;
    @FXML
    private JFXComboBox<String> cbfiltro;
    @FXML
    private JFXTextField txCod;
    @FXML
    private JFXTextField txvalor;
    @FXML
    private JFXComboBox<String> cbtipo;
    @FXML
    private TableView<Calcados> tabela;
    @FXML
    private TableColumn<Calcados, Integer> colcod;
    @FXML
    private TableColumn<Calcados, String> colnome;
    @FXML
    private TableColumn<Calcados, String> colmarca;
    @FXML
    private TableColumn<Calcados, Double> colvalorvenda;
    @FXML
    private TableColumn<Calcados, Double> colvalorcompra;
    @FXML
    private TableColumn<Calcados, String> colcor;
    @FXML
    private JFXButton btAlterar;
    @FXML
    private Label lbnovoval;
    @FXML
    private Label lbvalantigo;
    @FXML
    private JFXButton btCancelar;
    private double valor=0.0;
    private Calcados cal;
    @FXML
    private Label lbtxvalor;
    @FXML
    private HBox hboxpesquisa;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fadeout();
        colcod.setCellValueFactory(new PropertyValueFactory("codesp"));
        colnome.setCellValueFactory(new PropertyValueFactory("nome"));
        colcor.setCellValueFactory(new PropertyValueFactory("cores"));
        colmarca.setCellValueFactory(new PropertyValueFactory("MarcaCal"));
        colvalorvenda.setCellValueFactory(new PropertyValueFactory("valorvenda"));
        colvalorcompra.setCellValueFactory(new PropertyValueFactory("valorcompra"));
        estadoOriginal();
        cbtipo.getSelectionModel().select(0);
    }    
    private void fadeout() {
        FadeTransition ft = new FadeTransition(Duration.millis(1000), painel);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.play();
    }

    private void estadoOriginal() {
        txCod.setDisable(true);
        lbtxvalor.setVisible(false);
        pnDados.setDisable(true);
        btAlterar.setDisable(true);
        lbvalantigo.setVisible(false);
        lbnovoval.setVisible(false);
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
        cbtipo.getSelectionModel().select(0);
        hboxpesquisa.setDisable(false);
        txPesquisa.setDisable(false);
        cbfiltro.setDisable(false);
    }

    private void carregaTabela(String filtro) {
        Calcados Pega = new Calcados();
        List<Calcados> res = Pega.get(filtro);
        ObservableList<Calcados> modelo;
        modelo = FXCollections.observableArrayList(res);
        tabela.setItems(modelo);
    }

    void carregacbfiltro() {
        ObservableList<String> filtro
                = FXCollections.observableArrayList(
                        "Nome",
                        "Cores", "Código iden"
                );
        ObservableList<String> tipos
                = FXCollections.observableArrayList(
                        "Novo Valor", "%"
                );
        cbfiltro.setItems(filtro);
        cbtipo.setItems(tipos);
    }
            private void estadoEdicao() {     // carregar os componentes da tela (listbox, combobox, ...)
        // p.e. : carregaEstados();
        pnDados.setDisable(false);
        txCod.setDisable(true);
    }
    @FXML
    private void clkTxPesquisa(KeyEvent event) {

    }

    @FXML
    private void clkBtProcurar(ActionEvent event) {
                 if(!txPesquisa.getText().isEmpty()){
                if (cbfiltro.getValue() == null) {
            carregaTabela("upper(nome) like '%" + txPesquisa.getText().toUpperCase() + "%'");
        } else if (cbfiltro.getValue().equals("Nome")) {
            carregaTabela("upper(nome) like '%" + txPesquisa.getText().toUpperCase() + "%'");
        } else if (cbfiltro.getValue().equals("Cores")) {
            carregaTabela("upper(cores) like '%" + txPesquisa.getText().toUpperCase() + "%'");
        }else if (cbfiltro.getValue().equals("Código iden")) {
            carregaTabela("codespe like '%" + txPesquisa.getText() + "%'");
        }
        }
         else
         carregaTabela("");
    }

    @FXML
    private void clkTabela(MouseEvent event) {
                    if (tabela.getSelectionModel().getSelectedIndex() >= 0) {
            btAlterar.setDisable(false);
            Calcados c = (Calcados) tabela.getSelectionModel().getSelectedItem();
            cal = c;
            lbvalantigo.setVisible(true);
            lbvalantigo.setText("Valor Antigo: R$"+c.getValorvenda());
            txCod.setText("" + c.getCodesp());
            estadoEdicao();
        }
    }

    @FXML
    private void btnNovoSaiu(MouseEvent event) {
        btAlterar.setStyle("-fx-background-color: ");
        
    }

    @FXML
    private void btnNovoEntrou(MouseEvent event) {
        btAlterar.setStyle("-fx-background-color: #c2b29c");
    }
         private boolean verifica()
    {
        if(!txvalor.getText().isEmpty() &&
           cbtipo.getValue() != null && !lbnovoval.getText().isEmpty())
            return true;
        
        if(lbnovoval.getText().isEmpty()){
            lbtxvalor.setVisible(true);
            lbtxvalor.setText("Valor inválido!");
        }
        if(txvalor.getText().isEmpty()){
            lbtxvalor.setVisible(true);
            lbtxvalor.setText("Valor não digitado!");
        }
        return false;
    }
    @FXML
    private void clkBtAlterar(ActionEvent event) {
                Alert a = new Alert(Alert.AlertType.INFORMATION);
        Stage stage = new Stage();
        a.setTitle("Informação de Gravação/Alteração");
        a.setHeaderText("Informação de Gravação/Alteração");
        stage = (Stage) a.getDialogPane().getScene().getWindow();
        //a.setGraphic(icon);
        if (!verifica()) {
            a.setContentText("Verifique os erros(*)\n");
        } else {
            Calcados c = cal;
            if (cbtipo.getValue().equals("Novo Valor")) {
                c.setValorvenda(Double.parseDouble(txvalor.getText().replace(".", "").replace(",", ".")));
            } else {
                    c.setValorvenda(cal.getValorvenda()*(Double.parseDouble(txvalor.getText().replace(".", "").replace(",", ".")))/100);
            }
                if (c.atualizavalorvenda()) {  
                    a.setContentText("Gravado com Sucesso");
                } else {

                    a.setContentText("Problemas ao Gravar");
                    
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
    public static boolean
            onlyDigits(String str, int n) {
        // Traverse the string from
        // start to end
        for (int i = 0; i < n; i++) {

            // Check if character is
            // not a digit between 0-9
            // then return false
            if (str.charAt(i) < '0'
                    || str.charAt(i) > '9') {
                if(str.charAt(i) == ',')
            {
                return true;
            }else
                return false;
            }
        }
        // If we reach here, that means
        // all characters were digits.
        return true;
    }
    
    @FXML
    private void digitavalor(KeyEvent event) {

    }

    @FXML
    private void digitavalorreleased(KeyEvent event) {
        if(onlyDigits(txvalor.getText(),txvalor.getText().length()))
        {lbtxvalor.setVisible(false);
            lbnovoval.setVisible(true);

            if (cbtipo.getValue().equals("Novo Valor")){
                lbnovoval.setText("Novo Valor: R$"+txvalor.getText());
            }
            else
            {
                try{
                    lbnovoval.setText("Novo Valor: R$"+cal.getValorvenda()*(Double.parseDouble(txvalor.getText().replace(".","").replace(",", ".")))/100);
                }catch(ArithmeticException e){
                    lbnovoval.setText("");
                }
            }
        }
        else
        {
            lbnovoval.setVisible(true);
            lbnovoval.setText("");
        }
    }

    
}
