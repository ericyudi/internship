/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appvmc;

import DAL.DALClientes;
import DAL.DALfunc;
import Entidades.cliente;
import Entidades.funcionario;
import Util.MaskFieldUtil;
import appvmc.FXMLDocumentController;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXCheckBox;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
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
public class FXMLCadFuncionarioController implements Initializable {

    @FXML
    private SplitPane painel;
    @FXML
    private AnchorPane pnDados;
    @FXML
    private JFXTextField txCod;
    @FXML
    private JFXTextField txNome;
    @FXML
    private JFXTextField txcpf;
    @FXML
    private JFXComboBox<String> cbuf;
    @FXML
    private JFXTextField txCidade;
    @FXML
    private JFXTextField txbairro;
    @FXML
    private JFXTextField txrg;
    @FXML
    private JFXComboBox<String> cbestadocivil;
    @FXML
    private JFXTextField txnumero;
    @FXML
    private JFXTextField txend;
    @FXML
    private JFXTextField txtelefone;
    @FXML
    private JFXTextField txPesquisa;
    @FXML
    private JFXComboBox<String> cbfiltro;
    @FXML
    private TableView<funcionario> tabela;
    @FXML
    private TableColumn<funcionario, Integer> colcod;
    @FXML
    private TableColumn<funcionario, String> colnome;
    @FXML
    private TableColumn<funcionario, String> colestcivil;
    @FXML
    private TableColumn<funcionario, String> colcpf;
    @FXML
    private TableColumn<funcionario, String> colrg;
    @FXML
    private TableColumn<funcionario, String> coluf;
    @FXML
    private TableColumn<funcionario, String> colcidade;
    @FXML
    private TableColumn<funcionario, String> colbairro;
    @FXML
    private TableColumn<funcionario, String> colend;
    @FXML
    private TableColumn<funcionario, Integer> colnumero;
    @FXML
    private TableColumn<funcionario, String> coltele;
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
    private TableColumn<funcionario, String> colpermissao;
    @FXML
    private JFXComboBox<String> cbativo;
    @FXML
    private JFXPasswordField txsenha;
    @FXML
    private TableColumn<funcionario, String> colativo;
    private String erro;
    @FXML
    private JFXTextField txlogin;
    @FXML
    private JFXTextField txemail;
    @FXML
    private JFXTextField txcep;
    @FXML
    private TableColumn<funcionario, String> colcep;
    @FXML
    private TableColumn<funcionario, LocalDate> coldtdesat;
    @FXML
    private TableColumn<funcionario, String> colemail;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                fadeout();
        colcod.setCellValueFactory(new PropertyValueFactory("cod_func"));
        colnome.setCellValueFactory(new PropertyValueFactory("nome"));
        colestcivil.setCellValueFactory(new PropertyValueFactory("estadocivil"));
        colcpf.setCellValueFactory(new PropertyValueFactory("cpf"));
        colrg.setCellValueFactory(new PropertyValueFactory("rg"));        
        coluf.setCellValueFactory(new PropertyValueFactory("uf"));        
        colcidade.setCellValueFactory(new PropertyValueFactory("cidade"));
        colbairro.setCellValueFactory(new PropertyValueFactory("bairro"));       
        colend.setCellValueFactory(new PropertyValueFactory("endereco"));   
        colnumero.setCellValueFactory(new PropertyValueFactory("numero"));
        coltele.setCellValueFactory(new PropertyValueFactory("telefone"));
        colpermissao.setCellValueFactory(new PropertyValueFactory("permissao"));   
        colativo.setCellValueFactory(new PropertyValueFactory("ativo"));   
        colcep.setCellValueFactory(new PropertyValueFactory("cep"));   
        coldtdesat.setCellValueFactory(new PropertyValueFactory("data_desat"));   
        colemail.setCellValueFactory(new PropertyValueFactory("email"));   
        estadoOriginal();
    }    
    private void fadeout() {
        FadeTransition ft = new FadeTransition(Duration.millis(1000), painel);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.play();
        MaskFieldUtil.maxField(txNome, 60);
        MaskFieldUtil.letterField(txNome); 
      
        MaskFieldUtil.cpfField(txcpf);
        
        MaskFieldUtil.maxField(txrg, 16);
        
        MaskFieldUtil.letterField(txCidade);
        MaskFieldUtil.maxField(txCidade, 40);  
        
        MaskFieldUtil.letterField(txend);        
        MaskFieldUtil.maxField(txend, 50);    
        
        MaskFieldUtil.letterField(txbairro);
        MaskFieldUtil.maxField(txbairro, 50); 
   
      
        MaskFieldUtil.numericField(txnumero);
        MaskFieldUtil.maxField(txnumero, 5); 
        
        MaskFieldUtil.foneField(txtelefone);
        
        MaskFieldUtil.maxField(txsenha, 30);     

        MaskFieldUtil.cepField(txcep);
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
        funcionario dal = new funcionario();
        List<funcionario> res = dal.get(filtro);
        ObservableList<funcionario> modelo;
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
        ObservableList<String> est
                = FXCollections.observableArrayList(
                  "Solteiro",
                    "Casado",
                    "Separado",
                    "Divorciado",
                    "Viuvo"
                );
        ObservableList<String> ativo
                = FXCollections.observableArrayList(
                  "Sim","Nao"
                );
        cbestadocivil.setItems(est);
        cbuf.setItems(options);
        cbativo.setItems(ativo);
        
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
                          funcionario c = (funcionario) tabela.getSelectionModel().getSelectedItem();
            if(!c.getPermissao().equals("Total")){
            btAlterar.setDisable(false);
            btApagar.setDisable(false);
            }
            else
            {
            btAlterar.setDisable(true);
            btApagar.setDisable(true);
                    }
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
        txrg.setDisable(false);
        txcpf.setDisable(false);
        txtelefone.setDisable(false);
        cbestadocivil.setDisable(false);
        cbuf.setDisable(false);
        txbairro.setDisable(false);
        txend.setDisable(false);
        txnumero.setDisable(false);
        txtelefone.setDisable(false);
        txCidade.setDisable(false);
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
            funcionario c = (funcionario) tabela.getSelectionModel().getSelectedItem();
            txCod.setText("" + c.getCod_func());
            txNome.setText("" + c.getNome());
            txcpf.setText("" + c.getCpf());
            txtelefone.setText(""+c.getTelefone());
            txrg.setText("" + c.getRg());
            txCidade.setText(""+c.getCidade());
            txbairro.setText(""+c.getBairro());
            txend.setText(""+c.getEndereco());
            txnumero.setText(""+c.getNumero());
            cbuf.getSelectionModel().select(0);
            cbuf.getSelectionModel().select(c.getUf());
            cbestadocivil.getSelectionModel().select(0);
            cbestadocivil.getSelectionModel().select(c.getEstadocivil());
            if(c.getAtivo() == 'S')
            {
                cbativo.getSelectionModel().select(0);
            }
            else
            {
                cbativo.getSelectionModel().select(1);
            }
            String senhapes = c.buscasenha();
            String loginpes = c.buscalogin();
            txsenha.setText(senhapes);
            txlogin.setText(loginpes);
            txemail.setText(""+c.getEmail());
            txcep.setText(""+c.getCep());     
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

            funcionario e;
            e = (funcionario) tabela.getSelectionModel().getSelectedItem();
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
                String str = txcpf.getText().replaceAll("[^a-zA-Z0-9]", "");
        if (!txend.getText().isEmpty() && !txcpf.getText().isEmpty() && isCPF(str) && !txNome.getText().isEmpty() && !txrg.getText().isEmpty() && !txbairro.getText().isEmpty()
                 && !txCidade.getText().isEmpty()  && !txnumero.getText().isEmpty() && !txtelefone.getText().isEmpty() && 
                cbestadocivil.getSelectionModel().getSelectedIndex() != -1 && cbuf.getSelectionModel().getSelectedIndex() != -1 && cbativo.getSelectionModel().getSelectedIndex() != -1
                && !txsenha.getText().isEmpty() && !txcep.getText().isEmpty()  && !txemail.getText().isEmpty() && !txlogin.getText().isEmpty()) {
            return true;
        }
        erro="";
            if(txNome.getText().isEmpty())
                erro+="Nome! \n";
            if(cbestadocivil.getSelectionModel().getSelectedIndex() == -1)
                erro+="Seleção de Estado Civil! \n";
            if(txcpf.getText().isEmpty())
                erro+="CPF!\n";
            if(!isCPF(str))
                erro+="CPF INVALIDO!\n";
            if(txrg.getText().isEmpty())
                erro+="RG!\n";
            if(cbativo.getSelectionModel().getSelectedIndex() == -1)
                erro+="Seleção de Conta ativa ou não!\n";
            if(cbuf.getSelectionModel().getSelectedIndex() == -1)
                erro+="Seleção de Estado(UF)!\n";
            if(txCidade.getText().isEmpty())
                erro+="Cidade!\n";
            if(txbairro.getText().isEmpty())
                erro+="Bairro!\n";
            if(txend.getText().isEmpty())
                erro+="Endereço!\n";
            if(txnumero.getText().isEmpty())
                erro+="Numero da casa!\n";
            if(txtelefone.getText().isEmpty())
                erro+="Telefone!\n";
            if(txsenha.getText().isEmpty())
                erro+="Senha!\n";
            if(txcep.getText().isEmpty())
                erro+="CEP!\n";
            if(txemail.getText().isEmpty())
                erro+="Email!\n";
            if(txlogin.getText().isEmpty())
                erro+="Login!\n";
            
            
            
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
            
            funcionario c = new funcionario(cod, txNome.getText(),cbestadocivil.getValue(),
                    txcpf.getText(),txrg.getText(),cbuf.getValue(),txCidade.getText(), 
                    txbairro.getText(),txend.getText(), Integer.parseInt(txnumero.getText()),txtelefone.getText(),
                    "Parcial", cbativo.getValue().toUpperCase().charAt(0),txsenha.getText(),txlogin.getText(),
                    null,txcep.getText(),txemail.getText());
            if(cbativo.getValue().toUpperCase().charAt(0) == 'N')
            {
                LocalDate lc = LocalDate.now();
                c.setData_desat(lc);
            }

            if(c.getCod_func() == 0)
            {
                if(c.gravar()){
                    a.setContentText("Gravado com Sucesso");
                }
                else{

                    a.setContentText("Problemas ao Gravar");
                }
            }
            else{
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
    private void digitasenha(KeyEvent event) {
    }

    
}
