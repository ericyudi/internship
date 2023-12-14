/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appvmc;

import DAL.DALClientes;
import Entidades.cliente;
import Util.MaskFieldUtil;
import appvmc.FXMLDocumentController;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.time.LocalDate;
import java.util.InputMismatchException;
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
public class FXMLCadClientesController implements Initializable {

    @FXML
    private SplitPane painel;
    @FXML
    private AnchorPane pnDados;
    @FXML
    private JFXTextField txCod;
    @FXML
    private JFXTextField txNome;
    @FXML
    private JFXTextField txCpf;
    @FXML
    private JFXComboBox<String> cbuf;
    @FXML
    private JFXTextField txcidade;
    @FXML
    private JFXTextField txcep;
    @FXML
    private JFXTextField txbairro;
    @FXML
    private JFXTextField txend;
    @FXML
    private JFXTextField txnumero;
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
    private TableColumn<cliente, String> colrg;
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
    private JFXTextField txtelefone;
    @FXML
    private JFXTextField txemail;
    @FXML
    private JFXTextField txrg;
    @FXML
    private TableColumn<cliente, String> coltelefone;
    @FXML
    private TableColumn<cliente, String> colendereco;
    @FXML
    private TableColumn<cliente, Integer> colnumero;
    @FXML
    private JFXTextField txfiado;
    @FXML
    private TableColumn<cliente, String> colfiado;
    @FXML
    private JFXComboBox<String> cbfiado;
    @FXML
    private TableColumn<cliente, Double> colvalfiado;
    @FXML
    private TableColumn<cliente, String> colemail;
    @FXML
    private TableColumn<cliente, String> coluf;
    @FXML
    private TableColumn<cliente, String> colbairro;
    @FXML
    private TableColumn<cliente, String> colcidade;
    @FXML
    private TableColumn<cliente, String> colcep;
        LocalDate horahj = LocalDate.now();
        private double valantigo =0;
        private double saldoantigo = 0;
        private String erro="";
    @FXML
    private TableColumn<cliente, Double> colsaldofiado;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fadeout();
        colcod.setCellValueFactory(new PropertyValueFactory("cod"));
        colnome.setCellValueFactory(new PropertyValueFactory("nome"));
        colCPF.setCellValueFactory(new PropertyValueFactory("cpf"));
        colrg.setCellValueFactory(new PropertyValueFactory("rg"));
        coltelefone.setCellValueFactory(new PropertyValueFactory("telefone"));
        colendereco.setCellValueFactory(new PropertyValueFactory("endereco"));
        colnumero.setCellValueFactory(new PropertyValueFactory("numero"));
        colfiado.setCellValueFactory(new PropertyValueFactory("fiado"));
        colvalfiado.setCellValueFactory(new PropertyValueFactory("lim_fiado"));
        colemail.setCellValueFactory(new PropertyValueFactory("email"));
        coluf.setCellValueFactory(new PropertyValueFactory("uf"));
        colbairro.setCellValueFactory(new PropertyValueFactory("bairro"));
        colcidade.setCellValueFactory(new PropertyValueFactory("cidade"));
        colcep.setCellValueFactory(new PropertyValueFactory("cep"));
        colsaldofiado.setCellValueFactory(new PropertyValueFactory("saldofiado"));

        estadoOriginal();
        cbfiado.getSelectionModel().select(0);
        //cbuf.getSelectionModel().select(24);
        mudafiadoinicio();
    }
        private boolean isCPF(String CPF) {
        // considera-se erro CPF's formados por uma sequencia de numeros iguais
        if (CPF.equals("00000000000") ||
            CPF.equals("11111111111") ||
            CPF.equals("22222222222") || CPF.equals("33333333333") ||
            CPF.equals("44444444444") || CPF.equals("55555555555") ||
            CPF.equals("66666666666") || CPF.equals("77777777777") ||
            CPF.equals("88888888888") || CPF.equals("99999999999") ||
            (CPF.length() != 11))
            return(false);

        char dig10, dig11;
        int sm, i, r, num, peso;

        // "try" - protege o codigo para eventuais erros de conversao de tipo (int)
        try {
        // Calculo do 1o. Digito Verificador
            sm = 0;
            peso = 10;
            for (i=0; i<9; i++) {
        // converte o i-esimo caractere do CPF em um numero:
        // por exemplo, transforma o caractere '0' no inteiro 0
        // (48 eh a posicao de '0' na tabela ASCII)
            num = (int)(CPF.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                dig10 = '0';
            else dig10 = (char)(r + 48); // converte no respectivo caractere numerico

        // Calculo do 2o. Digito Verificador
            sm = 0;
            peso = 11;
            for(i=0; i<10; i++) {
            num = (int)(CPF.charAt(i) - 48);
            sm = sm + (num * peso);
            peso = peso - 1;
            }

            r = 11 - (sm % 11);
            if ((r == 10) || (r == 11))
                 dig11 = '0';
            else dig11 = (char)(r + 48);

        // Verifica se os digitos calculados conferem com os digitos informados.
            if ((dig10 == CPF.charAt(9)) && (dig11 == CPF.charAt(10)))
                 return(true);
            else return(false);
                } catch (InputMismatchException erro) {
                return(false);
            }
        }
    private void fadeout() {
        FadeTransition ft = new FadeTransition(Duration.millis(1000), painel);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.play();
        MaskFieldUtil.maxField(txNome, 60);
        MaskFieldUtil.letterField(txNome);    
        
        MaskFieldUtil.cpfField(txCpf);
        
        MaskFieldUtil.maxField(txrg, 16);
        
        MaskFieldUtil.letterField(txcidade);
        MaskFieldUtil.maxField(txcidade, 40);  
        
        MaskFieldUtil.letterField(txend);        
        MaskFieldUtil.maxField(txend, 50);    
        
        MaskFieldUtil.cepField(txcep); 
        MaskFieldUtil.maxField(txcep, 9);
        
        MaskFieldUtil.letterField(txbairro);
        MaskFieldUtil.maxField(txbairro, 50); 
   
      
        MaskFieldUtil.numericField(txnumero);
        MaskFieldUtil.maxField(txnumero, 5); 
        
        MaskFieldUtil.foneField(txtelefone);
         
        MaskFieldUtil.monetaryField(txfiado);
        
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
        carregaEstados();
    }    
        void carregacbfiltro() {
        ObservableList<String> filtro
                = FXCollections.observableArrayList(
                        "Nome",
                        "CPF",
                        "RG"
                );
        cbfiltro.setItems(filtro);
    }
        private void carregaTabela(String filtro) {
        cliente dal = new cliente();
        List<cliente> res = dal.get(filtro);
        ObservableList<cliente> modelo;
        modelo = FXCollections.observableArrayList(res);
        tabela.setItems(modelo);
    }

    void carregaEstados() {
        ObservableList<String> options
                = FXCollections.observableArrayList(
                        "AC",
                        "AL",
                        "AP",
                        "AM",
                        "BA",
                        "CE",
                        "DF",
                        "ES",
                        "GO",
                        "MA",
                        "MT",
                        "MS",
                        "MG",
                        "PA",
                        "PB",
                        "PR",
                        "PE",
                        "PI",
                        "RJ",
                        "RN",
                        "RS",
                        "RO",
                        "RR",
                        "SC",
                        "SP",
                        "SE",
                        "TO"
                );
        ObservableList<String> fiado
                = FXCollections.observableArrayList(
                        "Liberado",
                        "Bloqueado"
                );
        cbfiado.setItems(fiado);
        cbuf.setItems(options);
        
        
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
        } else if (cbfiltro.getValue().equals("RG")) {
            carregaTabela("rg like '%" + txPesquisa.getText() + "%'");
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
            cliente c = (cliente) tabela.getSelectionModel().getSelectedItem();
            valantigo = c.getLim_fiado();
            txCod.setText("" + c.getCod());
            txNome.setText("" + c.getNome());
            txCpf.setText("" + c.getCpf());
            txtelefone.setText(""+c.getTelefone());
            txemail.setText(""+c.getEmail());
            txrg.setText("" + c.getRg());
            txcidade.setText(""+c.getCidade());
            txcep.setText(""+c.getCep());
            txbairro.setText(""+c.getBairro());
            txend.setText(""+c.getEndereco());
            txnumero.setText(""+c.getNumero());
            txfiado.setText(""+c.getLim_fiado());
            cbuf.getSelectionModel().select(0);
            cbuf.getSelectionModel().select(c.getUf());
            cbfiado.getSelectionModel().select(0);
            cbfiado.getSelectionModel().select(c.getFiado());
            if(c.getFiado() == 'S')
            {
                cbfiado.getSelectionModel().select(0);
            }
            else
            {
                cbfiado.getSelectionModel().select(1);
            }
            saldoantigo = c.buscasaldo();
            estadoEdicao();
            mudafiadoinicio();
            cbfiado.setDisable(true);
            txfiado.setDisable(true);
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

            cliente e;
            e = (cliente) tabela.getSelectionModel().getSelectedItem();
            e.apagar();
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
        String str = txCpf.getText().replaceAll("[^a-zA-Z0-9]", "");
        if (!txCpf.getText().isEmpty() && isCPF(str) && !txNome.getText().isEmpty()
                && !txcidade.getText().isEmpty() && 
                !txfiado.getText().isEmpty() && 
                cbfiado.getSelectionModel().getSelectedIndex() != -1 ) {
            return true;
        }
                erro="";
            if(txNome.getText().isEmpty())
                erro+="Nome! \n";            
            if(txCpf.getText().isEmpty())
                erro+="CPF!\n";
            if(!isCPF(str))
                erro+="CPF INVALIDO!\n";
            if(txcidade.getText().isEmpty())
                erro+="Cidade!\n";
            if(txfiado.getText().isEmpty())
                erro+="Limite de fiado!\n";
            if(cbfiado.getSelectionModel().getSelectedIndex() == -1)
                erro+="Seleção de fiado liberado ou bloqueado!\n";
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
            a.setContentText("Preencha os campos que são obrigatórios(*):\n"+erro);
        }
        else{
            int cod;
            try {
                cod = Integer.parseInt(txCod.getText());
            } catch (Exception e) {
                cod = 0;
            }
            cliente c = new cliente(cod, txNome.getText(), 
                    txCpf.getText(),txtelefone.getText(),txemail.getText(),txrg.getText(),"",txcidade.getText(),txcep.getText(), 
                    txbairro.getText(),txend.getText(), 0,
                    Double.parseDouble(txfiado.getText().replace(".","").replace(",", ".")),'f',Double.parseDouble(txfiado.getText().replace(".","").replace(",", ".")), horahj,"");
            if(!txnumero.getText().isEmpty())
                c.setNumero(Integer.parseInt(txnumero.getText()));
            if(cbuf.getSelectionModel().getSelectedIndex() != -1)
                c.setUf(cbuf.getValue());
            if(cbfiado.getValue().toUpperCase().charAt(0) == 'L'){
                c.setFiado('S');
                c.setDatabloqueio(null);
            }
            else{
                c.setFiado('N');
            }
            if(c.getCod() == 0)
            {
                if(c.gravar()){
                    a.setContentText("Gravado com Sucesso");
                }
                else{

                    a.setContentText("Problemas ao Gravar");
                }
            }
            else{
                if(valantigo != saldoantigo)
                {
                    double val = valantigo-saldoantigo;
                    val = Double.parseDouble(txfiado.getText().replace(",", ".")) - val;
                    c.setSaldofiado(val);
                }
                if(c.alterar())
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
        private void estadoEdicao() {     // carregar os componentes da tela (listbox, combobox, ...)
        // p.e. : carregaEstados();
        pnDados.setDisable(false);
        txCod.setDisable(true);
        btConfirmar.setDisable(false);
        txNome.requestFocus();
        txrg.setDisable(false);
        txcep.setDisable(false);
        txCpf.setDisable(false);
        txtelefone.setDisable(false);
        txemail.setDisable(false);
        cbfiado.setDisable(false);
        cbuf.setDisable(false);
        txcidade.setDisable(false);
        txbairro.setDisable(false);
        txend.setDisable(false);
        txnumero.setDisable(false);
        txfiado.setDisable(false);
    }

    @FXML
    private void mudafiado(ActionEvent event) {
        if(cbfiado.getSelectionModel().getSelectedIndex() == 1)
        {  txfiado.setText("0");
        txfiado.setDisable(true);
        }
        else
            txfiado.setDisable(false);
    }
        private void mudafiadoinicio() {
        if(cbfiado.getSelectionModel().getSelectedIndex() == 1)
        {  txfiado.setText("0");
        txfiado.setDisable(true);
        }
        else
            txfiado.setDisable(false);
    }
    
}
