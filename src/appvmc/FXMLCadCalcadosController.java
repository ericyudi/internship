/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appvmc;

import DAL.DALCalcados;
import DAL.DALClientes;
import DAL.DALEstoque;
import DAL.DALMarca;
import Entidades.Calcados;
import Entidades.Marca;
import Entidades.cliente;
import Entidades.estoque;
import Util.MaskFieldUtil;
import appvmc.FXMLDocumentController;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.io.IOException;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javax.swing.JTextField;

/**
 * FXML Controller class
 *
 * @author eric-
 */
public class FXMLCadCalcadosController implements Initializable {

    @FXML
    private SplitPane painel;
    @FXML
    private AnchorPane pnDados;
    @FXML
    private JFXTextField txCod;
    @FXML
    private JFXTextField txNome;
    @FXML
    private JFXTextField txcodesp;
    @FXML
    private JFXComboBox<Marca> cbmarca;
    @FXML
    private JFXTextField txvalcompra;
    @FXML
    private JFXTextField txvalvenda;
    @FXML
    private JFXComboBox<String> cbgenero;
    private JFXDatePicker dtcompra;
    @FXML
    private JFXTextField txcores;
    @FXML
    private JFXTextField txPesquisa;
    @FXML
    private JFXComboBox<String> cbfiltro;
    @FXML
    private TableView<Calcados> tabela;
    @FXML
    private TableColumn<Calcados, Integer> colcod;
    @FXML
    private TableColumn<Calcados, String> colnome;
    @FXML
    private TableColumn<Calcados, String> colcodesp;
    private TableColumn<Calcados, Integer> coltamanho;
    @FXML
    private TableColumn<Calcados, Double> colvalcompra;
    @FXML
    private TableColumn<Calcados, Double> colvalvenda;
    @FXML
    private TableColumn<Calcados, String> colgenero;
    private TableColumn<Calcados, LocalDate> coldtcompra;
    @FXML
    private TableColumn<Calcados, String> colcores;
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
    private TableColumn<Calcados, Marca> colmarca;
    private String codespant;
    @FXML
    private JFXTextField txtam1;
    @FXML
    private JFXTextField txqntd1;
    @FXML
    private Pane pnqntdtam;
    @FXML
    private Button btadd;
    private int limiter = 1;
    @FXML
    private Button btremove;
    private String erro="";
    @FXML
    private MenuItem menuTamanho;
    private static Calcados aux;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
                fadeout();
        colcod.setCellValueFactory(new PropertyValueFactory("cod"));
        colnome.setCellValueFactory(new PropertyValueFactory("nome"));
        colcodesp.setCellValueFactory(new PropertyValueFactory("codesp"));
        colcores.setCellValueFactory(new PropertyValueFactory("cores"));
        colgenero.setCellValueFactory(new PropertyValueFactory("genero"));
        colmarca.setCellValueFactory(new PropertyValueFactory("MarcaCal"));
        colvalvenda.setCellValueFactory(new PropertyValueFactory("valorvenda"));
        colvalcompra.setCellValueFactory(new PropertyValueFactory("valorcompra"));
        estadoOriginal();
    }    
    private void fadeout() {
        FadeTransition ft = new FadeTransition(Duration.millis(1000), painel);
        ft.setFromValue(0);
        ft.setToValue(1);
        ft.play();
        MaskFieldUtil.maxField(txNome, 50);
        MaskFieldUtil.monetaryField(txvalcompra);
        MaskFieldUtil.monetaryField(txvalvenda);
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
    }    
        void carregacbfiltro() {
        ObservableList<String> filtro
                = FXCollections.observableArrayList(
                        "Nome",
                        "Genero","Cores","Código iden"
                );
        ObservableList<String> Genero
                = FXCollections.observableArrayList(
                        "Masculino","Feminino","Unissex"
                );
        cbfiltro.setItems(filtro);
        cbgenero.setItems(Genero);
    }
        private void carregaTabela(String filtro) {
        Calcados Pega = new Calcados();
        cbmarca.setItems(FXCollections.observableArrayList(new Marca().get("")));
        List<Calcados> res = Pega.get(filtro);
        ObservableList<Calcados> modelo;
        modelo = FXCollections.observableArrayList(res);
        tabela.setItems(modelo);
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
        }
         else
         carregaTabela("");
    }

    @FXML
    private void clkTabela(MouseEvent event) {
          if (tabela.getSelectionModel().getSelectedIndex() >= 0) {
            btAlterar.setDisable(false);
            btApagar.setDisable(false);
            Calcados c = (Calcados) tabela.getSelectionModel().getSelectedItem();
            aux = c;
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
        txcodesp.setDisable(false);
        txcores.setDisable(false);
        txvalcompra.setDisable(false);
        txvalvenda.setDisable(false);
        cbgenero.setDisable(false);
        cbmarca.setDisable(false);
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
            Calcados c = (Calcados) tabela.getSelectionModel().getSelectedItem();
            txCod.setText("" + c.getCod());
            txNome.setText("" + c.getNome());
            txcodesp.setText("" + c.getCodesp());
            txcores.setText("" + c.getCores());
            txvalcompra.setText("" + c.getValorcompra());
            txvalvenda.setText("" + c.getValorvenda());
            cbgenero.getSelectionModel().select(0);
            cbgenero.getSelectionModel().select(c.getGenero());
            cbmarca.getSelectionModel().select(0);
            cbmarca.getSelectionModel().select(c.getMarcaCal());
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

            Calcados c;
            c = (Calcados) tabela.getSelectionModel().getSelectedItem();
            c.apagaestoque();
            c.apagar();
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
        if (!txNome.getText().isEmpty() && !txcores.getText().isEmpty() &&  !txcodesp.getText().isEmpty() &&
                !txvalcompra.getText().isEmpty() && !txvalvenda.getText().isEmpty() && cbgenero.getSelectionModel().getSelectedIndex() != -1 && cbmarca.getSelectionModel().getSelectedIndex() != -1) {
            return true;
        }
           erro="";
            if(txNome.getText().isEmpty())
                erro+="Nome! \n";            
            if(txcodesp.getText().isEmpty())
                erro+="Código Especifico!\n";
            if(txcores.getText().isEmpty())
                erro+="Cores!\n";            
            if(cbmarca.getSelectionModel().getSelectedIndex() == -1)
                erro+="Seleção de Marca!\n";
            if(txvalcompra.getText().isEmpty())
                erro+="Valor de Compra!\n";
            if(txvalvenda.getText().isEmpty())
                erro+="Valor de Venda!\n";            
            if(cbgenero.getSelectionModel().getSelectedIndex() == -1)
                erro+="Seleção de Genero!\n";

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
            a.setContentText("Preencha os campos que são obrigatórios(*):\n"+erro);
        } else {
            int cod;
            try {
                cod = Integer.parseInt(txCod.getText());
            } catch (Exception e) {
                cod = 0;
            }
            Calcados c = new Calcados(cod, Double.parseDouble(txvalcompra.getText().replace(",", ".")),
                     Double.parseDouble(txvalvenda.getText().replace(",", ".")), txNome.getText(), txcodesp.getText(),
                    txcores.getText(), cbgenero.getValue(), cbmarca.getValue());
            aux = c;
            int lastcal = 0;
            if (c.getCod() == 0) {
                if (c.gravar()) {  
                    lastcal = c.getultimocal();
                    insere_qtdtam(lastcal,c);
                    a.setContentText("Gravado com Sucesso");
                } else {

                    a.setContentText("Problemas ao Gravar");
                }
            } else {
                if (c.alterar()) {
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
    
    
   /* private static JTextField getComponentById(Container container, String componentId){

        if(container.getComponents().length > 0)
        {
            for(Component c : container.getComponents())
            {
                if(componentId.equals(c.getName()))
                {
                    return (JTextField) c;
                }
                if(c instanceof Container)
                {
                    return getComponentById((Container) c, componentId);
                }
            }
        }

        return null;

    }*/
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
    private void insere_qtdtam(int cod, Calcados cal)
    {
        int cd = 1;
        cal.setCod(cod);
        while(limiter+1>cd)
        {
        String txtamult = buscaultvalores("txtam",cd);
        String txqntdult = buscaultvalores("txqntd",cd);
        
        estoque e = new estoque(0,cal,Integer.parseInt(txtamult),Integer.parseInt(txqntdult));

        //estoque dal = new estoque();
        e.gravar();
        cd++;
        }
       limpar();
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
       /* private static void iterateOverJTextFields(Container container) {

        for (Component component : container.getComponents()) {
            if (component instanceof JTextField) {
                System.out.println(((JTextField) component).getText());
            }
        }
        }*/

    @FXML
    private void MenuTamQntd(ActionEvent event) throws IOException {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLCadCalcadosEstoque.fxml"));
                Parent root = loader.load();
                FXMLCadCalcadosEstoqueController cool =  loader.getController();
                Stage stage = new Stage();
                stage.setTitle("Estoque");
               
                stage.setScene(new Scene(root));
                stage.show();  
    }
        
    public static Calcados getCal() {
        return aux;
    }

    
}
