/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appvmc;

import Entidades.Calcados;
import Entidades.Marca;
import Entidades.TudoTeste;
import Entidades.cliente;
import Entidades.estoque;
import Entidades.fiado;
import Entidades.funcionario;
import Entidades.itens_venda;
import Entidades.pagamento_fiado;
import Entidades.pagamento_venda;
import Entidades.venda;
import Util.MaskFieldUtil;
import static appvmc.FXMLDocumentController.aux;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;
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
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author eric-
 */
public class FXMLMostraProdutosController implements Initializable {

    @FXML
    private SplitPane painel;
    @FXML
    private AnchorPane pnDados;
    @FXML
    private TableColumn<Calcados, Integer> colcod1;
    @FXML
    private TableColumn<TudoTeste, Integer> colnome1;
    @FXML
    private TableColumn<TudoTeste, Marca> colmarca1;
    @FXML
    private TableColumn<TudoTeste, String> colcor1;
    @FXML
    private TableColumn<TudoTeste, Integer> colnumero1;
    @FXML
    private JFXTextField txPesquisa;
    @FXML
    private JFXComboBox<String> cbfiltro;
    @FXML
    private TableView<TudoTeste> tabela;
    @FXML
    private TableColumn<TudoTeste, Integer> colcod;
    @FXML
    private TableColumn<TudoTeste, String> colnome;
    @FXML
    private TableColumn<TudoTeste, Marca> colmarca;
    @FXML
    private TableColumn<TudoTeste, String> colcor;
    @FXML
    private TableColumn<TudoTeste, Integer> colnumero;
    @FXML
    private JFXButton btAdd;
    @FXML
    private JFXButton btApagar;
    @FXML
    private JFXButton btCancelar;
    @FXML
    private AnchorPane pnDados1;
    @FXML
    private JFXTextField txCod;
    @FXML
    private JFXTextField txDesc;
    @FXML
    private JFXComboBox<cliente> cbCliente;
    @FXML
    private JFXComboBox<String> cbfiado;
    @FXML
    private JFXTextField txValor;
    @FXML
    private JFXTextField txparc;
    @FXML
    private JFXDatePicker dtdiainicio;
    private JFXDatePicker dtpagamento;
    @FXML
    private JFXButton btfinalizar;
    @FXML
    private JFXTextField txcoments;
    @FXML
    private TableView<TudoTeste> tabelacarrinho;
    @FXML
    private TableColumn<TudoTeste, Double> colvalor;
    @FXML
    private TableColumn<TudoTeste, String> colgenero;
    @FXML
    private TableColumn<TudoTeste, Integer> colqntd;
    private ObservableList<ObservableList> data;
    @FXML
    private JFXTextField txcpf;
    @FXML
    private TableColumn<TudoTeste, Double> colvalor1;
    @FXML
    private TableColumn<TudoTeste, String> colgenero1;
    private Double soma=0.0;
    @FXML
    private TableColumn<TudoTeste, String> colcodesp1;
    @FXML
    private TableColumn<TudoTeste, String> colcodesp;
    @FXML
    private TableColumn<TudoTeste, Integer> colqntd1;
    @FXML
    private TableColumn<TudoTeste, Integer> codestoque1;
    @FXML
    private TableColumn<TudoTeste, Integer> codestoque;
    private cliente cece;
    /**
     * 
     * Initializes the controller class.
     */
    private String erro="";
    private static funcionario aux;
    @FXML
    private Label lbsaldo;
    @FXML
    private Label lberrocpf;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        aux = FXMLAutenticacaoController.getLogin();
        dtdiainicio.setValue(LocalDate.now());
        fadeout();
        colcod.setCellValueFactory(new PropertyValueFactory("cod"));
        colnome.setCellValueFactory(new PropertyValueFactory("nome"));
        colmarca.setCellValueFactory(new PropertyValueFactory("MarcaCal"));
        colcor.setCellValueFactory(new PropertyValueFactory("cores"));
        colgenero.setCellValueFactory(new PropertyValueFactory("genero"));
        colvalor.setCellValueFactory(new PropertyValueFactory("valorvenda"));
        colnumero.setCellValueFactory(new PropertyValueFactory("tam"));
        colqntd.setCellValueFactory(new PropertyValueFactory("qntd"));
        colcodesp.setCellValueFactory(new PropertyValueFactory("codesp"));
        codestoque.setCellValueFactory(new PropertyValueFactory("cod_estoque"));
        
        colcod1.setCellValueFactory(new PropertyValueFactory("cod"));
        colnome1.setCellValueFactory(new PropertyValueFactory("nome"));
        colmarca1.setCellValueFactory(new PropertyValueFactory("MarcaCal"));
        colcor1.setCellValueFactory(new PropertyValueFactory("cores"));
        colnumero1.setCellValueFactory(new PropertyValueFactory("tam"));
        colvalor1.setCellValueFactory(new PropertyValueFactory("valorvenda"));
        colgenero1.setCellValueFactory(new PropertyValueFactory("genero"));
        colcodesp1.setCellValueFactory(new PropertyValueFactory("codesp"));
        colqntd1.setCellValueFactory(new PropertyValueFactory("qntd"));
        codestoque1.setCellValueFactory(new PropertyValueFactory("cod_estoque"));
        //txValor.setDisable(true);
                estadoOriginal();
                estadoEdicao();
                cbfiado.getSelectionModel().select(1);
    }    


        private void fadeout() {
        FadeTransition ft = new FadeTransition(Duration.millis(1000), painel);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.play();
        MaskFieldUtil.cpfField(txcpf);
        MaskFieldUtil.monetaryField(txparc);
        //MaskFieldUtil.monetaryField(txValor);
        
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
        btCancelar.setDisable(false);
        btAdd.setDisable(true);
        btApagar.setDisable(true);
        btfinalizar.setDisable(true);
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
        tabelacarrinho.getItems().clear();
        carregacbfiltro();
        soma=0.0;
    }    
        void carregacbfiltro() {
        ObservableList<String> filtro
                = FXCollections.observableArrayList(
                        "Nome",
                        "Genero","Cores","Código iden","Tamanho"
                );
        ObservableList<String> fiado
                = FXCollections.observableArrayList(
                        "Sim", "Nao"
                );
        cbfiado.setItems(fiado);
        cbfiltro.setItems(filtro);
    }
        private void carregaTabela(String filtro) {
        TudoTeste Pega = new TudoTeste();
        //estoque Pegae = new estoque();
        cbCliente.setItems(FXCollections.observableArrayList(new cliente().get("")));
        List<TudoTeste> res = Pega.get2(filtro);
        //List<estoque> rese = Pegae.get2();
        ObservableList<TudoTeste> modelo;
        //ObservableList<estoque> modeloe;
        modelo = FXCollections.observableArrayList(res);
        //modeloe = FXCollections.observableArrayList(rese);
        tabela.setItems(modelo);
        //tabela.setItems(modeloe);
    }
    @FXML
    private void clkTabela(MouseEvent event) {
            if (tabela.getSelectionModel().getSelectedIndex() >= 0) {
            btAdd.setDisable(false);
            TudoTeste c = (TudoTeste) tabela.getSelectionModel().getSelectedItem();
        }
    }
        private void estadoEdicao() {     // carregar os componentes da tela (listbox, combobox, ...)
        // p.e. : carregaEstados();
        pnDados.setDisable(false);
        txCod.setDisable(true);
        txcpf.setDisable(false);
        txDesc.setDisable(false);
        txcoments.setDisable(false);
        cbfiado.setDisable(false);
        dtdiainicio.setDisable(false);

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
        } else if (cbfiltro.getValue().equals("Genero")) {
            carregaTabela("upper(genero) like '%" + txPesquisa.getText().toUpperCase() + "%'");
        } else if (cbfiltro.getValue().equals("Cores")) {
            carregaTabela("upper(cores) like '%" + txPesquisa.getText().toUpperCase() + "%'");
        }else if (cbfiltro.getValue().equals("Código iden")) {
            carregaTabela("codespe like '%" + txPesquisa.getText() + "%'");
        }
        else if (cbfiltro.getValue().equals("Tamanho")) {
            carregaTabela("tam ="+txPesquisa.getText()+"");
        }
        }
         else
         carregaTabela("");
    }

    @FXML
    private void btnNovoSaiu(MouseEvent event) {
        btAdd.setStyle("-fx-background-color: ");
    }

    @FXML
    private void btnNovoEntrou(MouseEvent event) {
        btAdd.setStyle("-fx-background-color: #c2b29c");
    }

    @FXML
    private void clkBtAdd(ActionEvent event) {
        if (tabela.getSelectionModel().getSelectedItem() != null) {
            TudoTeste c = (TudoTeste) tabela.getSelectionModel().getSelectedItem();
            int i = c.getQntd();
            if (i > 0) {                
                soma+=c.getValorvenda();
                Optional<TudoTeste> d = tabelacarrinho.getItems().stream().filter(item -> item.getCod()==c.getCod() && item.getTam()==c.getTam()).findAny();
                TudoTeste t = new TudoTeste(c.getCod(),c.getValorcompra(),c.getValorvenda(),c.getNome(),
                c.getCodesp(),c.getCores(),c.getGenero(),c.getMarcaCal(),c.getCod_estoque(),
                c.getCodcal(),c.getTam(),1);
                if(d.isPresent())
                {
                    TudoTeste e = d.get();
                    e.setQntd(e.getQntd()+1);
                }
                else
                {              
                   t.setQntd(1);
                   tabelacarrinho.getItems().addAll(t);
                   
                }
                c.setQntd(i - 1);   
                //tabelacarrinho.getItems().add(c);
                tabela.refresh();
                tabelacarrinho.refresh();
                txValor.setText(new DecimalFormat("##.##").format(soma).toString());
            } else {
                    Alert a = new Alert(Alert.AlertType.INFORMATION);
                    Stage stage = new Stage();
                    a.setTitle("Informação de Inserção");
                    a.setHeaderText("Informação de Inserção");
                    stage = (Stage) a.getDialogPane().getScene().getWindow();
                    a.setContentText("Quantidade indisponivel deste tamanho(*)\n");
                    a.showAndWait();
            }

        }
        if(tabelacarrinho.getItems().size()>0)
            btfinalizar.setDisable(false);
                       else
                   btfinalizar.setDisable(true);
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
        if (tabelacarrinho.getSelectionModel().getSelectedItem() != null) {
            TudoTeste c = (TudoTeste) tabelacarrinho.getSelectionModel().getSelectedItem();            
            soma-=c.getValorvenda();            
            Optional<TudoTeste> d = tabela.getItems().stream().filter(item -> item.getCod()==c.getCod() && item.getTam() == c.getTam()).findAny();
            TudoTeste e = d.get();
            e.setQntd(e.getQntd()+1);
            if(c.getQntd()-1>0)
                c.setQntd(c.getQntd()-1);
            else
            {
                tabelacarrinho.getItems().remove(c);
            }
            tabela.refresh();
            tabelacarrinho.refresh();
            txValor.setText(new DecimalFormat("##.##").format(soma).toString());
        }
            if(tabelacarrinho.getItems().size()>0)
            btfinalizar.setDisable(false);
               else
            btfinalizar.setDisable(true);
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
        if (!pnDados.isDisabled() && tabelacarrinho.getItems().size()>0) // encontra em estado de edição
        {int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "Deseja realmente cancelar está venda?", "Cancelar", dialogButton);
            if (dialogResult == 0) {
                
                estadoOriginal();
                estadoEdicao();
                //System.out.println("Yes option");
            } else {
                //System.out.println("No Option");
            }
            
        } else {
            //Stage stage = (Stage) btCancelar.getScene().getWindow();
            //stage.close();
            FXMLDocumentController.spnprincipal.setCenter(null);
            //FXMLDocumentController.efeito(false);
        }
    }

    @FXML
    private void clkdtpag(ActionEvent event) {
    }
    
            private boolean verifica() {
                
        if (!txcpf.getText().isEmpty() && dtdiainicio.getValue()!=null && cbfiado.getSelectionModel().getSelectedIndex() != -1 && 
                cbCliente.getSelectionModel().getSelectedIndex() != -1 && !txparc.getText().isEmpty() && 
                Double.parseDouble(txparc.getText().replace(".","").replace(",", ".")) <= Double.parseDouble(txValor.getText().replace(".","").replace(",", "."))
                ) {
            if(cbfiado.getValue().charAt(0)=='S')
            {
               if(Double.parseDouble(txparc.getText().replace(".","").replace(",", ".")) <= cece.getSaldofiado())
                   return true;
            }
             return true;
        }
        erro="";
        if(cbfiado.getValue().charAt(0)=='S')
        {
            if(Double.parseDouble(txparc.getText().replace(",", ".")) > cece.getSaldofiado())
            {
                            erro+="Valor de pagamento maior que valor de crédito de fiado disponivel!\n";
            }
        }
        if(Double.parseDouble(txparc.getText().replace(".","").replace(",", ".")) > Double.parseDouble(txValor.getText().replace(".","").replace(",", ".")))
            erro+="Valor de pagamento maior que valor total!\n";
        if(dtdiainicio.getValue().compareTo(LocalDate.now())>0)
            erro+="Data inicial da venda no futuro:?!\n";
        return false;
    }
    @FXML
    private void clkBtfinalizar(ActionEvent event) {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        Stage stage = new Stage();
        a.setTitle("Informação de Gravação/Alteração");
        a.setHeaderText("Informação de Gravação/Alteração");
        stage = (Stage) a.getDialogPane().getScene().getWindow();
        //a.setGraphic(icon);
        if (!verifica()) {
            a.setContentText("Preencha os campos que são obrigatórios e verifique os dados inseridos!(*):\n"+erro);
        } else {
            int cod;
            try {
                cod = Integer.parseInt(txCod.getText());
            } catch (Exception e) {
                cod = 0;
            }
            int flag = 0;
            venda v = new venda(cod, txDesc.getText(), Double.parseDouble(txValor.getText().replace(".","").replace(",", ".")), 'N', dtdiainicio.getValue(), txcoments.getText(), cbCliente.getValue(),'N',null);
            if(Double.parseDouble(txparc.getText().replace(".","").replace(",", ".")) == Double.parseDouble(txValor.getText().replace(".","").replace(",", ".")))
            {
                v.setQuitada('S');
                v.setDtquitacao(LocalDate.now());
            }
            pagamento_venda pv = new pagamento_venda(cod, Double.parseDouble(txparc.getText().replace(".","").replace(",", ".")), LocalDate.now(), aux, v);
            if (cbCliente.getValue().getFiado() == 'S') {
                if (cbfiado.getValue().toUpperCase().charAt(0) == 'S') {
                    v.setFiado('S');
                    if(soma <= cbCliente.getValue().getSaldofiado() && Double.parseDouble(txparc.getText().replace(".","").replace(",", ".")) < Double.parseDouble(txValor.getText().replace(".","").replace(",", "."))){
                        cbCliente.getValue().setSaldofiado(cbCliente.getValue().getSaldofiado()-soma);
                        cbCliente.getValue().alterafiado();
                        fiado f = new fiado(cod, Double.parseDouble(txparc.getText().replace(".","").replace(",", ".")), LocalDate.now(), 
                                txDesc.getText(), dtdiainicio.getValue(), soma, cbCliente.getValue());
                        f.gravar();
                        pagamento_fiado pf = new pagamento_fiado();
                        int ult = pf.getultimocalfiado();
                        f.setCod_fiado(ult);
                        pagamento_fiado novopf = new pagamento_fiado(cod, Double.parseDouble(txparc.getText().replace(".","").replace(",", ".")),
                                dtdiainicio.getValue(), f);
                        novopf.gravar();
                    //cria novo fiado aqui
                    }
                    else{
                        System.out.println("entra saldo insuficiente ou valor inválido para fiado");
                        flag = 1;
                        a.setContentText("Saldo Insuficiente ou valor inválido para fiado!\n");}
                } else {
                    v.setFiado('N');
                }
            }
            if (flag==0 && v.gravar()) {
                int codvenda = v.getultimocal();
                v.setCod_venda(codvenda);
                pv.setCod_venda(v);
                if(v.getFiado()=='N')
                pv.gravar();
                for (int i = 0; i <tabelacarrinho.getItems().size(); i++) {
                    TudoTeste ers = tabelacarrinho.getItems().get(i);
                    estoque eee = new estoque().getcomcod(ers.getCod_estoque());
                    itens_venda iv = new itens_venda(v, eee, ers.getQntd(), ers.getValorvenda());
                    iv.gravar();
                    eee.setQntd(eee.getQntd()-ers.getQntd());
                    eee.alteraqntd();
                }
                a.setContentText("Gravado com Sucesso");
            } else {

                a.setContentText("Problemas ao Gravar: Saldo Insuficiente de fiado ou erro lógico!");
            }
        }
        estadoOriginal();
        estadoEdicao();
        a.showAndWait();
        stage.getIcons().clear();
    }

    @FXML
    private void onkeypresscpf(KeyEvent event) {
        KeyCode ch = event.getCode();
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        Stage stage = new Stage();
        a.setTitle("Informação de Busca");
        a.setHeaderText("Informação de Busca");
        stage = (Stage) a.getDialogPane().getScene().getWindow();
        if (ch == event.getCode().ENTER) {
            String str = txcpf.getText().replaceAll("[^a-zA-Z0-9]", "");
            if (isCPF(str)) {
                lberrocpf.setVisible(false);
                cliente c = new cliente().getcomcpf(txcpf.getText());
                if (c != null) {
                    cbCliente.getSelectionModel().select(0);
                    cbCliente.getSelectionModel().select(c);
                    cece = c;
                } else {
                    a.setContentText("CPF inexistente no sistema(*)\n");
                    a.showAndWait();
                }
            }
            if (!isCPF(str) && str.length() > 10) {
                a.setContentText("CPF Inválido(*)\n");
                a.showAndWait();
 
            }
        }
    }

    @FXML
    private void cbseleciona(ActionEvent event) {
        if(cbCliente.getSelectionModel().getSelectedIndex() != -1){
        txcpf.setText(cbCliente.getValue().getCpf());
        cece=cbCliente.getValue();
        if(cbCliente.getValue().getFiado() == 'N')
            cbfiado.setDisable(true);
        else
            cbfiado.setDisable(false);
        lbsaldo.setText("R$"+cbCliente.getValue().getSaldofiado());
        }
    }

    @FXML
    private void btnFinalizaSaiu(MouseEvent event) {
        btfinalizar.setStyle("-fx-background-color: ");
    }

    @FXML
    private void btnFinalizaEntrou(MouseEvent event) {
        btfinalizar.setStyle("-fx-background-color: #c2b29c");
    }

    @FXML
    private void clkTabela1(MouseEvent event) {
            if (tabelacarrinho.getSelectionModel().getSelectedIndex() >= 0) {
            btApagar.setDisable(false);
            TudoTeste c = (TudoTeste) tabelacarrinho.getSelectionModel().getSelectedItem();
              //  System.out.println(tabelacarrinho.getItems().size());
        }
    }
    
}
