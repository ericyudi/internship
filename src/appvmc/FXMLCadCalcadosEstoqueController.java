/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appvmc;

import DAL.DALCalcados;
import DAL.DALEstoque;
import DAL.DALMarca;
import Entidades.Calcados;
import Entidades.estoque;
import Util.MaskFieldUtil;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
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

/**
 * FXML Controller class
 *
 * @author eric-
 */
public class FXMLCadCalcadosEstoqueController implements Initializable {

    @FXML
    private SplitPane painel;
    @FXML
    private AnchorPane pnDados;
    @FXML
    private JFXTextField txCod;
    @FXML
    private JFXTextField txtamanho;
    @FXML
    private JFXTextField txqntd;
    @FXML
    private JFXTextField txPesquisa;
    @FXML
    private JFXComboBox<String> cbfiltro;
    @FXML
    private TableView<estoque> tabela;
    @FXML
    private TableColumn<estoque, Integer> colcod;
    @FXML
    private TableColumn<estoque, Integer> coltam;
    @FXML
    private TableColumn<estoque, Integer> colqntd;
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
    public static Calcados aux;
    private int tamaltera = 0;
    private int codcalalt= 0;
    private String erro="";
    @FXML
    private Label labelnome;
    @FXML
    private Label labelcod;
    @FXML
    private TableColumn<estoque, Calcados> colnome;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        aux = FXMLCadCalcadosController.getCal();
        colcod.setCellValueFactory(new PropertyValueFactory("cod"));
        colnome.setCellValueFactory(new PropertyValueFactory("codcal"));
        coltam.setCellValueFactory(new PropertyValueFactory("tam"));
        colqntd.setCellValueFactory(new PropertyValueFactory("qntd"));
        estadoOriginal();
        MaskFieldUtil.numericField(txtamanho);
        MaskFieldUtil.numericField(txqntd);
        MaskFieldUtil.maxField(txtamanho, 2);
        MaskFieldUtil.maxField(txqntd, 3);
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
        carregaTabela("cod_cal ="+aux.getCod());
        carregacbfiltro();
    }    
       void carregacbfiltro() {
        ObservableList<String> filtro
                = FXCollections.observableArrayList(
                        "Tamanho"
                );

        cbfiltro.setItems(filtro);
    } 
        private void carregaTabela(String filtro) {
        estoque Pega = new estoque();
        List<estoque> res = Pega.get(filtro);
        ObservableList<estoque> modelo;
        modelo = FXCollections.observableArrayList(res);
        tabela.setItems(modelo);
    }
    @FXML
    private void clkTxPesquisa(KeyEvent event) {
    }

    @FXML
    private void clkBtProcurar(ActionEvent event) {
        if (!txPesquisa.getText().isEmpty()) {
            if (cbfiltro.getValue() == null) {
                carregaTabela("tam ="+Integer.parseInt(txPesquisa.getText())+" AND cod_cal ="+aux.getCod()+"");
            } else if (cbfiltro.getValue().equals("Tamanho")) {
                carregaTabela("tam ="+Integer.parseInt(txPesquisa.getText())+" AND cod_cal ="+aux.getCod()+"");
            }
        }
        else
            carregaTabela("cod_cal ="+aux.getCod());
    }

    @FXML
    private void clkTabela(MouseEvent event) {
                  if (tabela.getSelectionModel().getSelectedIndex() >= 0) {
            btAlterar.setDisable(false);
            btApagar.setDisable(false);
            estoque e = (estoque) tabela.getSelectionModel().getSelectedItem();
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
        txtamanho.requestFocus();
        txqntd.setDisable(false);
        txtamanho.setDisable(false);
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
            estoque c = (estoque) tabela.getSelectionModel().getSelectedItem();
            txCod.setText("" + c.getCod());
            txtamanho.setText("" + c.getTam());
            txqntd.setText("" + c.getQntd());
            codcalalt = c.getCodcal().getCod();
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

            estoque e;
            e = (estoque) tabela.getSelectionModel().getSelectedItem();
            e.apagar();
            carregaTabela("cod_cal ="+aux.getCod());
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
    private boolean verificatam() {
        estoque dale = new estoque();
        boolean pepo = true;
        int cod;
        try {
            cod = Integer.parseInt(txCod.getText());
        } catch (Exception e) {
            cod = 0;
        }
        if(cod==0 && !dale.checkifexists(aux.getCod(), Integer.parseInt(txtamanho.getText())))
        {
            erro+="Este tamanho já está inserido no sistema!\n";
            pepo = false;
        }
        if(cod!=0 && !dale.checkifexistsalterar(aux.getCod(), cod, Integer.parseInt(txtamanho.getText())))
        {
           erro+="Este tamanho já está inserido no sistema!\n"; 
           pepo = false;
        }
        return pepo;
    }
    
    private boolean verifica() {
        erro="";
        if (!txtamanho.getText().isEmpty() && !txqntd.getText().isEmpty() && Integer.parseInt(txtamanho.getText())>0 && Integer.parseInt(txqntd.getText())>0 && verificatam()) {
            return true;
        }

            if(txtamanho.getText().isEmpty())
                erro+="Informe o Tamanho! \n";   
            else
            {
                if(Integer.parseInt(txtamanho.getText())<=0)
                erro+="Tamanho inválido!\n";
            }
            if(txqntd.getText().isEmpty())
                erro+="Informe a Quantidade!\n";
            else
            {
                if(Integer.parseInt(txqntd.getText())<=0)
                erro+="Quantidade Inválida!\n";
            }

            

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
            estoque ealtera = new estoque(cod, aux/*codcalalt*/, Integer.parseInt(txtamanho.getText()),Integer.parseInt(txqntd.getText()));
            estoque enovo = new estoque(cod, aux, Integer.parseInt(txtamanho.getText()),Integer.parseInt(txqntd.getText()));
            if (cod == 0) {
                if (enovo.gravar()) {  
                    a.setContentText("Gravado com Sucesso");
                } else {

                    a.setContentText("Problemas ao Gravar");
                }
            } else {
                if (ealtera.alterar()) {
                    a.setContentText("Alterado com Sucesso");
                } else {
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
    private void clkBtCancelar(ActionEvent event) throws IOException {
               if (!pnDados.isDisabled()) // encontra em estado de edição
        {
            estadoOriginal();
        } else {
            Stage stage = (Stage) btCancelar.getScene().getWindow();
            stage.close();
            //FXMLDocumentController.efeito(false);
        }
    }
    
}
