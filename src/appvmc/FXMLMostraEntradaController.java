/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appvmc;

import Entidades.despesa;
import Entidades.entrada;
import Entidades.pagamento_venda;
import static appvmc.FXMLCadCalcadosEstoqueController.aux;
import static appvmc.FXMLQuitarVendasController.aux;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author eric-
 */
public class FXMLMostraEntradaController implements Initializable {

    @FXML
    private SplitPane painel;
    @FXML
    private TableView<entrada> tabela;
    @FXML
    private TableColumn<entrada, Integer> colcod;
    @FXML
    private TableColumn<entrada, String> colforn;
    @FXML
    private TableColumn<entrada, LocalDate> coldtcompra;
    @FXML
    private TableColumn<entrada, String> colmtpaga;
    @FXML
    private TableColumn<entrada, String> colnotafr;
    @FXML
    private TableColumn<entrada, Integer> colqntdparc;
    public static despesa aux;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        aux = FXMLTelaQuitarDespesasController.getDespesa();
        colcod.setCellValueFactory(new PropertyValueFactory("cod_entrada"));
        colforn.setCellValueFactory(new PropertyValueFactory("fornecedor"));
        coldtcompra.setCellValueFactory(new PropertyValueFactory("data_compra"));
        colmtpaga.setCellValueFactory(new PropertyValueFactory("metodo_pag"));
        colnotafr.setCellValueFactory(new PropertyValueFactory("nr_nf"));
        colqntdparc.setCellValueFactory(new PropertyValueFactory("qntd_parc"));
        carregaTabela("cod_entrada ="+aux.getEntr().getCod_entrada());
    }    
    private void carregaTabela(String filtro) {
        entrada Pega = new entrada();
        List<entrada> res = Pega.get(filtro);
        ObservableList<entrada> modelo;
        modelo = FXCollections.observableArrayList(res);
        tabela.setItems(modelo);
    }

    @FXML
    private void clkTabela(MouseEvent event) {
    }
    
}
