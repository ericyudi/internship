/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appvmc;

import Entidades.despesa;
import Entidades.fiado;
import Entidades.funcionario;
import Entidades.pagamento_despesa;
import Entidades.pagamento_fiado;
import Util.MaskFieldUtil;
import static appvmc.FXMLQuitarDespesasController.aux;
import static appvmc.FXMLQuitarDespesasController.auxfunc;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
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

/**
 * FXML Controller class
 *
 * @author eric-
 */
public class FXMLQuitarFiadoController implements Initializable {

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
    private JFXTextField txvalorres;
    @FXML
    private JFXDatePicker dtpag;
    @FXML
    private TableView<pagamento_fiado> tabela;
    @FXML
    private TableColumn<pagamento_fiado, Integer> colcod;
    @FXML
    private TableColumn<pagamento_fiado, Double> colvalorpago;
    @FXML
    private TableColumn<pagamento_fiado, LocalDate> coldtpag;
    @FXML
    private JFXButton btNovo;
    @FXML
    private JFXButton btApagar;
    @FXML
    private JFXButton btConfirmar;
    @FXML
    private JFXButton btCancelar;
    @FXML
    private JFXButton btquitar;
        public static fiado aux;
    private String erro="";
    private Double soma = 0.0;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                aux = FXMLTelaQuitarFiadoController.getFiado();
        colcod.setCellValueFactory(new PropertyValueFactory("cod_pag"));
        colvalorpago.setCellValueFactory(new PropertyValueFactory("valorpago"));
        coldtpag.setCellValueFactory(new PropertyValueFactory("datapag"));
        estadoOriginal();
        MaskFieldUtil.monetaryField(txvalor);
        dtpag.setValue(LocalDate.now());
    }    
        private void estadoOriginal() {
            soma = 0.0;
        txCod.setDisable(true);
        pnDados.setDisable(true);
        btConfirmar.setDisable(true);
        btCancelar.setDisable(false);
        btNovo.setDisable(false);
        btApagar.setDisable(true);
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
        carregaTabela("cod_fiado ="+aux.getCod_fiado());
        carregacbfiltro();
        tabela.refresh();
        fiado veve = new fiado().get(aux.getCod_fiado());
            for (int i = 0; i < tabela.getItems().size(); i++) {
                pagamento_fiado pepe = tabela.getItems().get(i);
                soma+=pepe.getValorpago();
            }
        Double val = veve.getVrfiado()-soma;
        txvalorres.setText(val.toString());
        aux = veve;
    }  
        
               private void carregaTabela(String filtro) {
        pagamento_fiado Pega = new pagamento_fiado();
        List<pagamento_fiado> res = Pega.get(filtro);
        ObservableList<pagamento_fiado> modelo;
        modelo = FXCollections.observableArrayList(res);
        tabela.setItems(modelo);
    }
               void carregacbfiltro() {
        ObservableList<String> filtro
                = FXCollections.observableArrayList(
                        "Data"
                );

        cbfiltro.setItems(filtro);
    } 
                     private void estadoEdicao() {     // carregar os componentes da tela (listbox, combobox, ...)
        // p.e. : carregaEstados();
        pnDados.setDisable(false);
        txCod.setDisable(true);
        btConfirmar.setDisable(false);
        txvalor.requestFocus();
        dtpag.setDisable(false);
        txvalor.setDisable(false);
    }
    @FXML
    private void clkTxPesquisa(KeyEvent event) {
    }

    @FXML
    private void clkBtProcurar(ActionEvent event) {
                              if(!txPesquisa.getText().isEmpty()){
                if (cbfiltro.getValue() == null) {
            carregaTabela("datapag = '" + txPesquisa.getText().toUpperCase() + "' AND cod_fiado ="+aux.getCod_fiado()+"");
        }if (cbfiltro.getValue().equals("Data")){
            carregaTabela("datapag = '" + txPesquisa.getText().toUpperCase() + "' AND cod_fiado ="+aux.getCod_fiado()+"");
        }
        }
         else
         carregaTabela("cod_fiado ="+aux.getCod_fiado());
    }

    @FXML
    private void clkTabela(MouseEvent event) {
            if (tabela.getSelectionModel().getSelectedIndex() >= 0) {
            btApagar.setDisable(false);
            pagamento_fiado e = (pagamento_fiado) tabela.getSelectionModel().getSelectedItem();
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
        a.setTitle("Confirmação de Estorno");
        a.setHeaderText("Confirmação de Estorno!");
        a.setContentText("Confirma o estorno?");
        stage = (Stage) a.getDialogPane().getScene().getWindow();
        if (a.showAndWait().get() == ButtonType.OK) {

            pagamento_fiado e;
            e = (pagamento_fiado) tabela.getSelectionModel().getSelectedItem();
            e.apagar();
            carregaTabela("cod_fiado ="+aux.getCod_fiado());
            txCod.setText("");
        }
        stage.getIcons().clear();
        estadoOriginal();
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
        erro="";
        if (!txvalor.getText().isEmpty() && dtpag.getValue()!=null && Double.parseDouble(txvalor.getText().replace(".","").replace(",", ".")) <= 
                Double.parseDouble(txvalorres.getText().replace(".","").replace(",", ".")) && dtpag.getValue().compareTo(aux.getDtfiado())>=0) {
            return true;
        }

            if(txvalor.getText().isEmpty())
                erro+="Informe o valor a ser pago! \n";   
            if(Double.parseDouble(txvalor.getText().replace(".","").replace(",", ".")) > 
                Double.parseDouble(txvalorres.getText().replace(".","").replace(",", ".")))
                erro+="Valor de pagamento maior que o valor restante do fiado!\n";
            if(dtpag.getValue()==null)
                erro+="Informe a data de pagamento!\n";
            if(dtpag.getValue().compareTo(aux.getDtfiado())<0)
                erro+="Data de Pagamento antes da data do fiado!\n";

        return false;
    }
    @FXML
    private void clkBtConfirmar(ActionEvent event) {
                                        Alert a = new Alert(Alert.AlertType.INFORMATION);
        Stage stage = new Stage();
        a.setTitle("Informação de Gravação/Alteração");
        a.setHeaderText("Informação de Gravação/Alteração");
        stage = (Stage) a.getDialogPane().getScene().getWindow();
        //a.setGraphic(icon);
        if (!verifica()) {
            a.setContentText("Preencha os campos que são obrigatórios e/ou verifique os erros(*):\n"+erro);
        } else {
            int cod;
            try {
                cod = Integer.parseInt(txCod.getText());
            } catch (Exception e) {
                cod = 0;
            }
            pagamento_fiado pv = new pagamento_fiado(cod, Double.parseDouble(txvalor.getText().replace(".","").replace(",", ".")), 
                    dtpag.getValue(), aux);
            if (cod == 0) {
                if (pv.gravar()) {  
                    soma+=Double.parseDouble(txvalor.getText().replace(".","").replace(",", "."));
                    if((aux.getVrfiado()-soma)<0.1 || Double.parseDouble(txvalorres.getText().replace(".","").replace(",", "."))==0.0)
                    {
                        aux.setValorpago(aux.getVrfiado());
                        aux.alteravrpago();
                    }
                    else
                    {
                        aux.setValorpago(aux.getValorpago()+Double.parseDouble(txvalor.getText().replace(".","").replace(",", ".")));
                        aux.alteravrpago();
                    }
                    a.setContentText("Gravado com Sucesso");
                } else {

                    a.setContentText("Problemas ao Gravar");
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
            Stage stage = (Stage) btCancelar.getScene().getWindow();
            stage.close();
            //FXMLDocumentController.efeito(false);
        }
    }

    @FXML
    private void btnQuitarSaiu(MouseEvent event) {
        btquitar.setStyle("-fx-background-color: ");
    }

    @FXML
    private void btnQuitarEntrou(MouseEvent event) {
        btquitar.setStyle("-fx-background-color: #c2b29c");
    }

    @FXML
    private void clkquitaragr(ActionEvent event) {
                        pagamento_fiado pv = new pagamento_fiado(0, aux.getVrfiado()-soma,
                dtpag.getValue(), aux);
        pv.gravar();
        aux.setValorpago(aux.getVrfiado());
        aux.alteravrpago();
        estadoOriginal();
        
    }
    
}
