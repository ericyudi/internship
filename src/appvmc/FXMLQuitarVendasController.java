/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appvmc;

import Entidades.Calcados;
import Entidades.cliente;
import Entidades.estoque;
import Entidades.funcionario;
import Entidades.pagamento_venda;
import Entidades.venda;
import Util.MaskFieldUtil;
import static appvmc.FXMLCadCalcadosEstoqueController.aux;
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
public class FXMLQuitarVendasController implements Initializable {

    @FXML
    private SplitPane painel;
    @FXML
    private AnchorPane pnDados;
    @FXML
    private JFXTextField txCod;
    @FXML
    private JFXTextField txvalor;
    @FXML
    private JFXTextField txvalorres;
    @FXML
    private TableView<pagamento_venda> tabela;
    @FXML
    private TableColumn<pagamento_venda, Integer> colcod;
    @FXML
    private TableColumn<pagamento_venda, Double> colvalorpago;
    @FXML
    private TableColumn<pagamento_venda, LocalDate> coldtpag;
    @FXML
    private JFXButton btNovo;
    @FXML
    private JFXButton btApagar;
    @FXML
    private JFXButton btConfirmar;
    @FXML
    private JFXButton btCancelar;
    @FXML
    private JFXTextField txPesquisa;
    @FXML
    private JFXComboBox<String> cbfiltro;
    @FXML
    private TableColumn<pagamento_venda, funcionario> colfunc;
    public static venda aux;
    public static funcionario auxfunc;
    @FXML
    private JFXDatePicker dtpag;
    @FXML
    private JFXButton btquitar;
    private String erro="";
    private Double soma = 0.0;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        aux = FXMLTelaQuitarVendasController.getVenda();
        auxfunc = FXMLAutenticacaoController.getLogin();
        colcod.setCellValueFactory(new PropertyValueFactory("cod_pag"));
        colvalorpago.setCellValueFactory(new PropertyValueFactory("valorpago"));
        coldtpag.setCellValueFactory(new PropertyValueFactory("datapag"));
        colfunc.setCellValueFactory(new PropertyValueFactory("cod_func"));
        estadoOriginal();
        MaskFieldUtil.monetaryField(txvalor);
        dtpag.setValue(LocalDate.now());
        if(aux.getQuitada() == 'S' || aux.getFiado() == 'S')
        {
            btNovo.setDisable(true);
            btquitar.setDisable(true);
            btApagar.setDisable(true);
        }
    }    
    private void vequit()
    {
        if(Double.parseDouble(txvalorres.getText())<0.1){
        if(aux.getQuitada() == 'S' || aux.getFiado() == 'S')
        {
            btNovo.setDisable(true);
            btquitar.setDisable(true);
            btApagar.setDisable(true);
        }
        }
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
        carregaTabela("cod_venda ="+aux.getCod_venda());
        carregacbfiltro();
        tabela.refresh();
        venda veve = new venda().get(aux.getCod_venda());
            for (int i = 0; i < tabela.getItems().size(); i++) {
                pagamento_venda pepe = tabela.getItems().get(i);
                soma+=pepe.getValorpago();
            }
        Double val = veve.getValortotal()-soma;
        txvalorres.setText(val.toString());
        aux = veve;
                    vequit();
    }    
    private void carregaTabela(String filtro) {
        pagamento_venda Pega = new pagamento_venda();
        List<pagamento_venda> res = Pega.get(filtro);
        ObservableList<pagamento_venda> modelo;
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
    private void clkTabela(MouseEvent event) {
                          if (tabela.getSelectionModel().getSelectedIndex() >= 0) {
            btApagar.setDisable(false);
            pagamento_venda e = (pagamento_venda) tabela.getSelectionModel().getSelectedItem();
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

            pagamento_venda e;
            e = (pagamento_venda) tabela.getSelectionModel().getSelectedItem();
            e.apagar();
            carregaTabela("cod_venda ="+aux.getCod_venda());
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
                Double.parseDouble(txvalorres.getText().replace(".","").replace(",", ".")) && dtpag.getValue().compareTo(aux.getDataVenda())>=0) {
            return true;
        }


            if(txvalor.getText().isEmpty())
                erro+="Informe o valor a ser pago! \n";   
            if(Double.parseDouble(txvalor.getText().replace(".","").replace(",", ".")) > 
                Double.parseDouble(txvalorres.getText().replace(".","").replace(",", ".")))
                erro+="Valor de pagamento maior que o valor restante da venda!\n";
            if(dtpag.getValue()==null)
                erro+="Informe a data de pagamento!\n";
            if(dtpag.getValue().compareTo(aux.getDataVenda())<0)
                erro+="Data de Pagamento antes da data da venda!\n";

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
            pagamento_venda pv = new pagamento_venda(cod, Double.parseDouble(txvalor.getText().replace(".","").replace(",", ".")), 
                    dtpag.getValue(), auxfunc, aux);
            if (cod == 0) {
                if (pv.gravar()) {  
                    soma+=Double.parseDouble(txvalor.getText().replace(".","").replace(",", "."));
                    if((aux.getValortotal()-soma)<0.1 || Double.parseDouble(txvalorres.getText().replace(".","").replace(",", "."))==0.0)
                    {
                        aux.setQuitada('S');
                        aux.setDtquitacao(dtpag.getValue());
                        aux.quitavenda();
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
    private void clkTxPesquisa(KeyEvent event) {
    }

    @FXML
    private void clkBtProcurar(ActionEvent event) {
              if(!txPesquisa.getText().isEmpty()){
                if (cbfiltro.getValue() == null) {
            carregaTabela("datapag = '" + txPesquisa.getText().toUpperCase() + "' AND cod_venda ="+aux.getCod_venda()+"");
        }if (cbfiltro.getValue().equals("Data")){
            carregaTabela("datapag = '" + txPesquisa.getText().toUpperCase() + "' AND cod_venda ="+aux.getCod_venda()+"");
        }
        }
         else
         carregaTabela("cod_venda ="+aux.getCod_venda());
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
        pagamento_venda pv = new pagamento_venda(0, aux.getValortotal()-soma,
                LocalDate.now(), auxfunc, aux);
        pv.gravar();
        aux.setQuitada('S');
        aux.setDtquitacao(dtpag.getValue());
        aux.quitavenda();
        estadoOriginal();
    }
    
}
