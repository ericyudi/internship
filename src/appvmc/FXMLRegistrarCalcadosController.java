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
import Entidades.despesa;
import Entidades.entrada;
import Entidades.estoque;
import Entidades.funcionario;
import Entidades.itens_entrada;
import Entidades.tipoconta;
import Util.MaskFieldUtil;
import static appvmc.FXMLDocumentController.aux;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.animation.FadeTransition;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author eric-
 */
public class FXMLRegistrarCalcadosController implements Initializable {

    @FXML
    private SplitPane painel;
    @FXML
    private AnchorPane pnDados;
    @FXML
    private JFXTextField txCod;
    @FXML
    private JFXTextField txNome;
    @FXML
    private JFXTextField txfornecedor;
    @FXML
    private JFXComboBox<Marca> cbmarca;
    @FXML
    private JFXDatePicker dtcompra;
    @FXML
    private JFXTextField txPesquisa;
    @FXML
    private JFXComboBox<String> cbfiltro;
    @FXML
    private TableView<TudoTeste> tabela;
    @FXML
    private TableColumn<TudoTeste, String> colnome;
    @FXML
    private TableColumn<TudoTeste, Marca> colmarca;
    @FXML
    private JFXButton btCancelar;
    @FXML
    private JFXComboBox<String> cbgenero;
    @FXML
    private AnchorPane pnDados1;
    @FXML
    private JFXTextField txmetodopag;
    @FXML
    private JFXTextField txnrnf;
    @FXML
    private JFXTextField txparc;
    @FXML
    private JFXButton btaddEntrada;
    @FXML
    private JFXTextField txCod1;
    @FXML
    private JFXTextField txcodesp;
    @FXML
    private JFXTextField txvalvenda;
    @FXML
    private JFXTextField txvalcompra;
    @FXML
    private JFXTextField txcores;
    @FXML
    private Pane pnqntdtam;
    @FXML
    private JFXTextField txtam1;
    @FXML
    private JFXTextField txqntd1;
    @FXML
    private Button btadd;
    @FXML
    private Button btremove;
    @FXML
    private TableColumn<TudoTeste, String> colcodesp;
    @FXML
    private TableColumn<TudoTeste, Double> colvalorvenda;
    @FXML
    private TableColumn<TudoTeste, Double> colvalorCompra;
    @FXML
    private TableColumn<TudoTeste, String> colgenero;
    @FXML
    private TableColumn<TudoTeste, String> colcor;
    @FXML
    private TableColumn<TudoTeste, Integer> colqntd;
    @FXML
    private TableColumn<TudoTeste, Integer> colnumero;
    @FXML
    private JFXButton btfinalizar;
    @FXML
    private JFXButton btaddCal;
    private int cod_entrada;
    private entrada aux_entre;
    @FXML
    private Label lbfornecedor;
    @FXML
    private Label lbmetodopag;
    @FXML
    private Label lbnf;
    @FXML
    private Label lbdtcompra;
    @FXML
    private Label lbparcelas;
    @FXML
    private JFXButton btApagar;
    @FXML
    private Label lbnome;
    @FXML
    private Label lbcodesp;
    @FXML
    private Label lbvalcompra;
    @FXML
    private Label lbmarca;
    @FXML
    private Label lbgenero;
    @FXML
    private Label lbcores;
        private int limiter = 1;
        private double soma = 0.0;
        private static funcionario aux;
    @FXML
    private JFXDatePicker dtvenc;
    @FXML
    private JFXComboBox<String> cbpaga;
    private LocalDate dtvencnew;
    private char paga;
    @FXML
    private Label lbdatavenc;
    @FXML
    private Label lbdtv;
    @FXML
    private Label lbdtv1;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        aux = FXMLAutenticacaoController.getLogin();
        dtcompra.setValue(LocalDate.now());
        dtvenc.setValue(LocalDate.now());
        fadeout();
        colnome.setCellValueFactory(new PropertyValueFactory("nome"));
        colmarca.setCellValueFactory(new PropertyValueFactory("MarcaCal"));
        colcor.setCellValueFactory(new PropertyValueFactory("cores"));
        colgenero.setCellValueFactory(new PropertyValueFactory("genero"));
        colvalorvenda.setCellValueFactory(new PropertyValueFactory("valorvenda"));
        colvalorCompra.setCellValueFactory(new PropertyValueFactory("valorcompra"));
        colnumero.setCellValueFactory(new PropertyValueFactory("tam"));
        colqntd.setCellValueFactory(new PropertyValueFactory("qntd"));
        colcodesp.setCellValueFactory(new PropertyValueFactory("codesp"));
        estadoOriginal();
        estadoEdicao();
        
        /*txfornecedor.setText("forn");
        txparc.setText("2");
        txnrnf.setText("4342");
        txmetodopag.setText("metodo pag");
        cbpaga.getSelectionModel().select(0);*/
    }    
        private void fadeout() {
        FadeTransition ft = new FadeTransition(Duration.millis(1000), painel);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.play();
        MaskFieldUtil.maxField(txNome, 45);
        MaskFieldUtil.monetaryField(txvalcompra);
        MaskFieldUtil.monetaryField(txvalvenda);
        MaskFieldUtil.numericField(txtam1);
        MaskFieldUtil.numericField(txparc);
        MaskFieldUtil.numericField(txqntd1);
        MaskFieldUtil.maxField(txtam1, 2);
        MaskFieldUtil.maxField(txparc, 2);
        MaskFieldUtil.maxField(txqntd1, 3);
        
    }
                private void estadoEdicao() {     // carregar os componentes da tela (listbox, combobox, ...)
        // p.e. : carregaEstados();
        pnDados1.setDisable(false);
        txCod.setDisable(true);
        txCod1.setDisable(true);
        txfornecedor.setDisable(false);
        txparc.setDisable(false);
        txnrnf.setDisable(false);
        dtcompra.setDisable(false);
        txmetodopag.setDisable(false);

    }
                        private void estadoOriginal() {
        soma = 0.0;
        botatudofalsecal();
        botatudofalseentrada();
        txCod.setDisable(true);
        txCod1.setDisable(true);
        pnDados1.setDisable(true);
        pnDados.setDisable(false);
        btCancelar.setDisable(false);
        btfinalizar.setDisable(true);
        btaddCal.setDisable(true);
        btfinalizar.setDisable(true);
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
        ObservableList<Node> componentes1 = pnDados1.getChildren();
                for (Node n : componentes1) {
            if (n instanceof TextInputControl) // textfield, textarea e htmleditor
            {
                ((TextInputControl) n).setText("");
            }
            if (n instanceof ComboBox) {
                ((ComboBox) n).getItems().clear();
            }
        }
        tabela.getItems().clear();
        carregacbfiltro();
        
        cbmarca.setItems(FXCollections.observableArrayList(new Marca().get("")));
    }   
                                void carregacbfiltro() {
        ObservableList<String> filtro
                = FXCollections.observableArrayList(
                        "Nome",
                        "Genero","Cores","Código iden"
                );
        ObservableList<String> genero
                = FXCollections.observableArrayList(
                       "Masculino","Feminino","Unissex"
                );
                ObservableList<String> status
                = FXCollections.observableArrayList(
                        "Pago","Nao Pago"
                );
        cbpaga.setItems(status);
        cbgenero.setItems(genero);
        cbfiltro.setItems(filtro);
    }
    @FXML
    private void clkTxPesquisa(KeyEvent event) {
    }

    @FXML
    private void clkBtProcurar(ActionEvent event) {
    }

    @FXML
    private void clkTabela(MouseEvent event) {
            if (tabela.getSelectionModel().getSelectedIndex() >= 0) {
            btApagar.setDisable(false);
            TudoTeste c = (TudoTeste) tabela.getSelectionModel().getSelectedItem();
        }
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
                if (pnDados1.isDisabled() /*&& tabela.getItems().size()>0*/) // encontra em estado de edição
        {int dialogButton = JOptionPane.YES_NO_OPTION;
            int dialogResult = JOptionPane.showConfirmDialog(null, "Deseja realmente cancelar está entrada?", "Cancelar", dialogButton);
            if (dialogResult == 0) {
                
                estadoOriginal();
                estadoEdicao();
                entrada e = new entrada(cod_entrada);
                e.apagar();
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

         private boolean verificaentrada()
    {
        if(!txfornecedor.getText().isEmpty()&&dtcompra.getValue() != null &&
            !txmetodopag.getText().isEmpty() && !txparc.getText().isEmpty()
           && !txnrnf.getText().isEmpty()
                && dtcompra.getValue().compareTo(LocalDate.now())<=0 && dtvenc.getValue().compareTo(LocalDate.now())>0)
            return true;
        lbdtv.setVisible(false);
        lbdatavenc.setText("Data de Vencimento menor do que hoje!");
        if(txfornecedor.getText().isEmpty())
            lbfornecedor.setVisible(true);
        if(txnrnf.getText().isEmpty())
            lbnf.setVisible(true);
        if(dtcompra.getValue().compareTo(LocalDate.now())>0)
            lbdtcompra.setVisible(true);
            lbdtcompra.setText("Data da entrada no futuro!");
        if(txparc.getText().isEmpty())
            lbparcelas.setVisible(true);
        if(txmetodopag.getText().isEmpty())
            lbmetodopag.setVisible(true);
                if(dtvenc.getValue().compareTo(LocalDate.now())<0){
            lbdatavenc.setVisible(true);            
            lbdatavenc.setText("Data de Vencimento menor do que hoje!");
        }
        else{

            lbdatavenc.setVisible(true);            
            lbdatavenc.setText("Data de Vencimento não selecionada!");
        }
        return false;
    }
              private void botatudofalseentrada()
     {
         lbfornecedor.setVisible(false);
         lbdtcompra.setVisible(false);
         lbmetodopag.setVisible(false);
         lbparcelas.setVisible(false);
         lbnf.setVisible(false);
         lbdatavenc.setVisible(false);
     }
    @FXML
    private void clkBtAddEntrada(ActionEvent event) {
        dtvenc.setVisible(true);
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        Stage stage = new Stage();
        a.setTitle("Informação de Gravação/Alteração");
        a.setHeaderText("Informação de Gravação/Alteração");
        stage = (Stage) a.getDialogPane().getScene().getWindow();
        //a.setGraphic(icon);
        botatudofalseentrada();
        if (!verificaentrada()) {
            a.setContentText("Preencha os campos que são obrigatórios e verifique os erros(*):\n");
        } else {
            int cod;
            try {
                cod = Integer.parseInt(txCod.getText());
            } catch (Exception e) {
                cod = 0;
            }
            if(cbpaga.getValue().charAt(0)=='P')
                paga = 'S';
            else
                paga = 'N';
            dtvencnew = dtvenc.getValue();
            entrada c = new entrada(cod, txfornecedor.getText(), dtcompra.getValue(), txmetodopag.getText(), txnrnf.getText(), Integer.parseInt(txparc.getText()));
            int lastcal = 0;
            if (c.getCod_entrada() == 0) {
                if (c.gravar()) {  
                    aux_entre = c;
                    cod_entrada = c.getultimocal();
                    aux_entre.setCod_entrada(cod_entrada);
                    a.setContentText("Gravado com Sucesso");
                } else {

                    a.setContentText("Problemas ao Gravar");
                    
                }
            }  
            estadoOriginal();
            btaddCal.setDisable(false);
        }       

        a.showAndWait();
        stage.getIcons().clear();
        
    }

    @FXML
    private void btnadd(ActionEvent event) {
                if(limiter<7){
        limiter++;
        //cria
        JFXTextField txtam = new JFXTextField();
        txtam.setPromptText("Tamanho");
        JFXTextField txqntd = new JFXTextField();
        txqntd.setPromptText("Quantidade"); 
        //seta id
        txqntd.setId("txqntd"+limiter);
        txtam.setId("txtam"+limiter);
        //seta tamanho
        txqntd.setPrefWidth(66);
        txqntd.setPrefHeight(29);
        txtam.setPrefWidth(66);
        txtam.setPrefHeight(29);
        //busca quantos elementos tem
        //int last = buscault();
        Node txtamult = buscault("txtam",limiter-1);
        Node txqntdult = buscault("txqntd",limiter-1);
        //pega os txtam e txqntd
        //Node txtamult = pnqntdtam.getChildren().get(last-2);
        //Node txqntdult = pnqntdtam.getChildren().get(last-1);
        String tam = txtamult.getId();
        String qntd = txqntdult.getId();
        //JTextField txtamresult = getComponentById(, "txtam");
        txqntd.setLayoutX(txqntdult.getLayoutX()+80);
        txqntd.setLayoutY(txqntdult.getLayoutY());
        txtam.setLayoutX(txtamult.getLayoutX()+80);
        txtam.setLayoutY(txtamult.getLayoutY());
       
        pnqntdtam.getChildren().add(txqntd);
        pnqntdtam.getChildren().add(txtam);
        
        btadd.setLayoutX(btadd.getLayoutX()+80);
        btadd.setLayoutY(btadd.getLayoutY());
        btremove.setLayoutX(btremove.getLayoutX()+80);
        btremove.setLayoutY(btremove.getLayoutY());
        }
        else
        {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        Stage stage = new Stage();
        a.setTitle("Limite de Calçados!");
        a.setContentText("Limite de tamanho de calçados a serem inseridos alcançado!");
        a.showAndWait();
        stage.getIcons().clear();
        }
    }

    @FXML
    private void btnremove(ActionEvent event) {
        if(limiter>1){
        limiter--;
        Node txtamult = buscault("txtam",limiter+1);
        Node txqntdult = buscault("txqntd",limiter+1);
        pnqntdtam.getChildren().removeAll(txqntdult,txtamult);
        btadd.setLayoutX(btadd.getLayoutX()-80);
        btadd.setLayoutY(btadd.getLayoutY());
        btremove.setLayoutX(btremove.getLayoutX()-80);
        btremove.setLayoutY(btremove.getLayoutY());
        }
        else
        {
        Alert a = new Alert(Alert.AlertType.INFORMATION);
        Stage stage = new Stage();
        a.setTitle("Limite de Remoção!");
        a.setContentText("Limite de tamanho de calçados a serem removidos alcançado!");
        a.showAndWait();
        stage.getIcons().clear();
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
    private void clkBtfinalizar(ActionEvent event) {
        for (int i = 0; i < tabela.getItems().size(); i++) {
            TudoTeste ers = tabela.getItems().get(i);
            Calcados calcado = new Calcados().getcomcodesp(ers.getCodesp());
            if (calcado == null) {
                Calcados novocal_inser = new Calcados(0, ers.getValorcompra(), ers.getValorvenda(),
                        ers.getNome(), ers.getCodesp(), ers.getCores(), ers.getGenero(), ers.getMarcaCal());
                novocal_inser.gravar();
                int c = novocal_inser.getultimocal();
                novocal_inser.setCod(c);
                estoque novoestoq_inser = new estoque(0, novocal_inser, ers.getTam(), ers.getQntd());
                novoestoq_inser.gravar();
                int novocod = novoestoq_inser.getultimoest();
                novoestoq_inser.setCod(novocod);
                itens_entrada ie = new itens_entrada(aux_entre,novoestoq_inser,ers.getQntd(),ers.getValorcompra());
                ie.gravar();
                soma+=ers.getValorcompra()*ers.getQntd();
            } else {
                estoque s_estoq = new estoque().getcomcodcal_vetamanho(calcado.getCod(), ers.getTam());
                if (s_estoq == null) {
                    estoque novo_estoq = new estoque(0, calcado, ers.getTam(), ers.getQntd());
                    novo_estoq.gravar();
                    int novocod = novo_estoq.getultimoest();
                    novo_estoq.setCod(novocod);
                    itens_entrada ie = new itens_entrada(aux_entre,novo_estoq,ers.getQntd(),ers.getValorcompra());
                    ie.gravar();
                    soma+=calcado.getValorcompra()*ers.getQntd();
                } else {
                    s_estoq.setQntd(s_estoq.getQntd() + ers.getQntd());
                    s_estoq.alteraqntd();
                    itens_entrada ie = new itens_entrada(aux_entre,s_estoq,ers.getQntd(),ers.getValorcompra());
                    ie.gravar();
                    soma+=calcado.getValorcompra()*ers.getQntd();
                }
            }
        }
        int cont = 0;
        int numero = aux_entre.getQntd_parc();
        double valort = soma / numero;
        tipoconta tp = new tipoconta().gettp("Entrada");
        despesa t = new despesa(0, aux, tp, aux_entre, "Entrada do " + aux_entre.getFornecedor(),
                "", paga, valort, dtvencnew, aux_entre.getData_compra()
        );
        int penco = 2;
        if (t.gravar()) {
            while (numero - 1 > 0) {
                cont++;
                despesa f = new despesa(0, aux, tp, aux_entre, "Entrada do " + aux_entre.getFornecedor(),
                        "", paga, valort, dtvencnew, aux_entre.getData_compra()
                );
                f.gravar();
                penco++;
                numero--;
            }
        }
        estadoOriginal();
        estadoEdicao();
    }
    private boolean verificacal()
    {
        if(!txNome.getText().isEmpty() && !txcores.getText().isEmpty() &&  !txcodesp.getText().isEmpty() &&
                !txvalcompra.getText().isEmpty() && cbgenero.getSelectionModel().getSelectedIndex() != -1 && cbmarca.getSelectionModel().getSelectedIndex() != -1)
            return true;
        if(txNome.getText().isEmpty())
            lbnome.setVisible(true);
        if(txcodesp.getText().isEmpty())
            lbcodesp.setVisible(true);
        if(txcores.getText().isEmpty())
            lbcores.setVisible(true);
        if(cbmarca.getSelectionModel().getSelectedIndex() == -1)
            lbmarca.setVisible(true);
        if(txvalcompra.getText().isEmpty())
            lbvalcompra.setVisible(true);
        if(cbgenero.getSelectionModel().getSelectedIndex() == -1)
            lbgenero.setVisible(true);
        return false;
    }
              private void botatudofalsecal()
     {
         lbnome.setVisible(false);
         lbcodesp.setVisible(false);
         lbcores.setVisible(false);
         lbmarca.setVisible(false);
         lbvalcompra.setVisible(false);
         lbgenero.setVisible(false);

     }
    private void limpaPraInserirdnV()
    {
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
        txCod1.setDisable(true);
        cbmarca.setItems(FXCollections.observableArrayList(new Marca().get("")));
        carregacbfiltro();
    }
    @FXML
    private void clkBtAddCalcado(ActionEvent event) {
        if (!verificacal()) {

        } else {
            botatudofalsecal();
            int cod;
            try {
                cod = Integer.parseInt(txCod.getText());
            } catch (Exception e) {
                cod = 0;
            }
            Double teste;
            if (txvalvenda.getText().isEmpty()) {
                teste = 0.0;
            }
            else{
                teste = Double.parseDouble(txvalvenda.getText().replace(".","").replace(",", "."));
            }
            int cd = 1;
            while (limiter + 1 > cd) {
                String txtamult = buscaultvalores("txtam", cd);
                String txqntdult = buscaultvalores("txqntd", cd);
                Calcados cc = new Calcados();
                TudoTeste t = new TudoTeste(cod, Double.parseDouble(txvalcompra.getText().replace(".","").replace(",", ".")), teste,
                        txNome.getText(), txcodesp.getText(), txcores.getText(),
                        cbgenero.getValue(), cbmarca.getValue(), 0, cc, Integer.parseInt(txtamult), Integer.parseInt(txqntdult));
                //estoque e = new estoque(0,cal,Integer.parseInt(txtamult),Integer.parseInt(txqntdult));

                //estoque dal = new estoque();
                tabela.getItems().addAll(t);
                cd++;
            }
            tabela.refresh();
            limpar();
            limpaPraInserirdnV();
        }
        if(tabela.getItems().size()>0)
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
        if (tabela.getSelectionModel().getSelectedItem() != null) {
            TudoTeste c = (TudoTeste) tabela.getSelectionModel().getSelectedItem();
            tabela.getItems().remove(c);
        }
        tabela.refresh();
        if (tabela.getItems().size() > 0) {
            btfinalizar.setDisable(false);
        } else {
            btfinalizar.setDisable(true);
        }
    }
    
        private Node buscault(String valo, int val)
    {
      /* for (Node node : pnqntdtam.getChildren()) {
    System.out.println("Id: " + node.getId());
    if (node instanceof JTextField) {
        // clear
        ((JTextField)node).setText("");
    }
    }
       return ;*/
        int ult = 0;
        Node ret = null;
        Set<Node> nodes = pnqntdtam.lookupAll(".text-field");
        for (Node node : nodes) {
            ult++;
            if(node.getId().endsWith(String.valueOf(val)) && node.getId().contains(valo))
                return node;
        }
        return ret;
    }
    private String buscaultvalores(String valo, int val) {
        /* for (Node node : pnqntdtam.getChildren()) {
    System.out.println("Id: " + node.getId());
    if (node instanceof JTextField) {
        // clear
        ((JTextField)node).setText("");
    }
    }
       return ;*/
        for (Node node : pnqntdtam.getChildren()) {
                //System.out.println("Id: " + node.getId());
                if (node.getId().endsWith(String.valueOf(val)) && node.getId().contains(valo)) {
                    return ((JFXTextField) node).getText();
                }

            
        }
        return null;
    }
    private void limpaprimeiro(String valo, int val)
    {
      for (Node node : pnqntdtam.getChildren()) {
                if (node.getId().endsWith(String.valueOf(val)) && node.getId().contains(valo)) {
                    ((JFXTextField) node).setText("");
   
    }
      
    }
    }
        private void limpar()
    {
        while(limiter>1){
        
        Node txtamult = buscault("txtam",limiter);
        Node txqntdult = buscault("txqntd",limiter);
        pnqntdtam.getChildren().removeAll(txqntdult,txtamult);
        btadd.setLayoutX(btadd.getLayoutX()-80);
        btadd.setLayoutY(btadd.getLayoutY());
        btremove.setLayoutX(btremove.getLayoutX()-80);
        btremove.setLayoutY(btremove.getLayoutY());
        limiter--;
        }
        limpaprimeiro("txtam",1);
        limpaprimeiro("txqntd",1);
    }

    @FXML
    private void verificacodespe(KeyEvent event) {
        KeyCode ch = event.getCode();
        if(ch == event.getCode().ENTER)
        {       String str = txcodesp.getText();
                Calcados c = new Calcados().getcomcodesp(str);
                txNome.setText(c.getNome());
                txvalcompra.setText(""+c.getValorcompra());
                txvalvenda.setText(""+c.getValorvenda());
                txcores.setText(c.getCores());
                cbgenero.getSelectionModel().select(0);
                cbgenero.getSelectionModel().select(c.getGenero());
                cbmarca.getSelectionModel().select(0);
                cbmarca.getSelectionModel().select(c.getMarcaCal());
        }
    }
}
