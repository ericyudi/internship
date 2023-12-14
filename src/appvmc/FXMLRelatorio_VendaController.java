/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appvmc;

import DB.Singleton;
import Entidades.Calcados;
import Entidades.cliente;
import Entidades.tipoconta;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import java.net.URL;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.view.JasperViewer;

/**
 * FXML Controller class
 *
 * @author eric-
 */
public class FXMLRelatorio_VendaController implements Initializable {

    @FXML
    private JFXButton btCancelar;
    @FXML
    private JFXButton btfinalizar;
    @FXML
    private JFXComboBox<String> cbfiltro;
    @FXML
    private JFXComboBox<cliente> cbcliente;
    @FXML
    private DatePicker dtinicio;
    @FXML
    private DatePicker dtfim;
    @FXML
    private Label labelperiodo;
    @FXML
    private JFXComboBox<Calcados> cbproduto;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        dtinicio.setValue(LocalDate.now());
        dtfim.setValue(LocalDate.now());
        carregacombo();
        carregaboxes();
    }    
    private void carregacombo()
    {
                ObservableList<String> filtro
                = FXCollections.observableArrayList(
                        "Periodo","Cliente","Calcado"//fazer filtro com data
                );
        cbfiltro.setItems(filtro);
    }
    private void carregaboxes()
    {
        cbcliente.setItems(FXCollections.observableArrayList(new cliente().get("")));
        cbproduto.setItems(FXCollections.observableArrayList(new Calcados().get("")));
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

            //Stage stage = (Stage) btCancelar.getScene().getWindow();
            //stage.close();
            FXMLDocumentController.spnprincipal.setCenter(null);
            //FXMLDocumentController.efeito(false);
        
    }

    @FXML
    private void btnFinalizaSaiu(MouseEvent event) {
        btfinalizar.setStyle("-fx-background-color: ");
    }

    @FXML
    private void btnFinalizaEntrou(MouseEvent event) {
        btfinalizar.setStyle("-fx-background-color: #c2b29c");
    }
    private void gerarRelatorio(String sql, String relat) {
        try { //sql para obter os dados para o relatorio
            Singleton con = Singleton.getConexao();
            ResultSet rs = con.consultar(sql);
            //ResultSet rs = Banco.getCon().consultar(sql);
            //implementação da interface JRDataSource para DataSource ResultSet
            JRResultSetDataSource jrRS = new JRResultSetDataSource(rs);
            //chamando o relatório
            String jasperPrint
                    = JasperFillManager.fillReportToFile(relat, null, jrRS);
            JasperViewer viewer = new JasperViewer(jasperPrint, false, false);
            viewer.setExtendedState(JasperViewer.MAXIMIZED_BOTH);//maximizado
            viewer.setTitle("Relatório de Vendas");//titulo do relatório
            viewer.setVisible(true);
        } catch (JRException erro) {
            System.out.println("erro:"+erro.getMessage());
        }

    }
    @FXML
    private void clkBtfinalizar(ActionEvent event) {
        if(cbfiltro.getValue() != null)
        {
            if (cbfiltro.getValue().equals("Periodo")) {
                gerarRelatorio("SELECT venda.cod_venda,\n"
                        + "	venda.descricao,\n"
                        + "	venda.valortotal,\n"
                        + "	venda.fiado,\n"
                        + "	venda.datavenda,\n"
                        + "	venda.comentarios,\n"
                        + "	venda.quitada,\n"
                        + "	venda.dtquitacao,\n"
                        + "	cliente.nome,\n"
                        + "	cliente.cpf\n"
                        + "FROM venda\n"
                        + "	inner join cliente ON \n"
                        + "	 venda.cod_cliente = cliente.cod_cliente\n"
                        + "	 where venda.datavenda between '" + dtinicio.getValue() + "' and '" + dtfim.getValue() + "' ", "relatorios/MyReports/relatorio_venda_periodo.jasper");
            }
            if (cbfiltro.getValue().equals("Cliente")) {
                gerarRelatorio("SELECT venda.cod_venda,venda.descricao,\n"
                        + "venda.valortotal, venda.fiado, venda.datavenda,\n"
                        + "venda.comentarios, venda.quitada, venda.dtquitacao, \n"
                        + "cliente.nome, cliente.cpf\n"
                        + "FROM venda \n"
                        + "inner join cliente on venda.cod_cliente = cliente.cod_cliente\n"
                        + "where cliente.cod_cliente = " + cbcliente.getValue().getCod() + "", "relatorios/MyReports/relatorio_venda_cliente.jasper");
            }
            if (cbfiltro.getValue().equals("Calcado")) {
                gerarRelatorio("SELECT venda.cod_venda,venda.descricao,\n"
                        + "venda.valortotal, venda.fiado, venda.datavenda,\n"
                        + "venda.comentarios, venda.quitada, venda.dtquitacao, \n"
                        + "cliente.nome, cliente.cpf\n"
                        + "FROM venda \n"
                        + "inner join cliente on venda.cod_cliente = cliente.cod_cliente\n"
                        + "inner join itens_venda on venda.cod_venda = itens_venda.cod_venda\n"
                        + "inner join estoque on estoque.cod_estoque = itens_venda.cod_estoque\n"
                        + "inner join calcado on estoque.cod_cal = calcado.cod\n"
                        + "where calcado.cod = " + cbproduto.getValue().getCod() + " ", "relatorios/MyReports/relatorio_venda_calcado.jasper");
            }

        }
    }
    private void periodo(int flag)
    {
        if(flag==0)
        {
            labelperiodo.setVisible(false);
            dtinicio.setVisible(false);
            dtfim.setVisible(false);
        }
        else{
            labelperiodo.setVisible(true);
            dtinicio.setVisible(true);
            dtfim.setVisible(true);
        }
    }
        private void cliente(int flag)
    {
        if(flag==0)
        {
            cbcliente.setVisible(false);
        }
        else{
            cbcliente.setVisible(true);
        }
    }
        private void calcado(int flag)
    {
        if(flag==0)
        {
            cbproduto.setVisible(false);
        }
        else{
            cbproduto.setVisible(true);
        }
    }
    @FXML
    private void actseleciona(ActionEvent event) {
        if(cbfiltro.getSelectionModel().getSelectedItem()!=null)
        {
            if(cbfiltro.getValue().equals("Periodo"))
            {
                periodo(1);
                cliente(0);
                calcado(0);
            }
            if(cbfiltro.getValue().equals("Cliente"))
            {
                periodo(0);
                cliente(1);
                calcado(0);
            }
            if(cbfiltro.getValue().equals("Calcado"))
            {
                periodo(0);
                cliente(0);
                calcado(1);
            }
        }
    }
    
}
