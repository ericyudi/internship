/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appvmc;

import DB.Singleton;
import Util.MaskFieldUtil;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
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
public class FXMLRelatorio_clientesController implements Initializable {

    @FXML
    private JFXButton btCancelar;
    @FXML
    private JFXButton btfinalizar;
    @FXML
    private JFXComboBox<String> cbfiltro;
    @FXML
    private JFXTextField txnome;
    @FXML
    private JFXTextField txestado;
    @FXML
    private JFXTextField txcpf;
    @FXML
    private JFXTextField txtelefone;
    @FXML
    private JFXTextField txcidade;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        carregacombo();
        MaskFieldUtil.cpfField(txcpf);
    }    
    private void carregacombo()
    {
                ObservableList<String> filtro
                = FXCollections.observableArrayList(
                        "Nome","Estado","CPF","Telefone","Cidade"//fazer filtro com data
                );
        cbfiltro.setItems(filtro);

    }
    @FXML
    private void btnCancelarSaiu(MouseEvent event) {
    }

    @FXML
    private void btnCancelarEntrou(MouseEvent event) {
    }

    @FXML
    private void clkBtCancelar(ActionEvent event) {
            //Stage stage = (Stage) btCancelar.getScene().getWindow();
            //stage.close();
            FXMLDocumentController.spnprincipal.setCenter(null);
            //FXMLDocumentController.efeito(false); 
    }
    private void nome(int flag){
        if(flag == 0){
            txnome.setVisible(false);
        }
        else
        {
            txnome.setVisible(true);
        }
    }  
        private void estado(int flag)
    {
        if(flag==0)
        {
            txestado.setVisible(false);
        }
        else{
            txestado.setVisible(true);
        }
    }
        private void cpf(int flag)
    {
        if(flag==0)
        {
            txcpf.setVisible(false);
        }
        else{
            txcpf.setVisible(true);
        }
    }
        private void telefone(int flag)
    {
        if(flag==0)
        {
            txtelefone.setVisible(false);
        }
        else{
            txtelefone.setVisible(true);
        }
    }
        private void cidade(int flag)
    {
        if(flag==0)
        {
            txcidade.setVisible(false);
        }
        else{
            txcidade.setVisible(true);
        }
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
            viewer.setTitle("Relatório de Despesas");//titulo do relatório
            viewer.setVisible(true);
        } catch (JRException erro) {
            System.out.println("erro:"+erro.getMessage());
        }

    }
    @FXML
    private void btnFinalizaSaiu(MouseEvent event) {
    }

    @FXML
    private void btnFinalizaEntrou(MouseEvent event) {
    }

    @FXML
    private void clkBtfinalizar(ActionEvent event) {//"Nome","Estado","CPF","Telefone","Cidade"
                if (cbfiltro.getSelectionModel().getSelectedItem() != null) {
            if (cbfiltro.getSelectionModel().getSelectedIndex() == 0)//"Nome","Estado","CPF","Telefone","Cidade"
            {
                gerarRelatorio("select * from cliente where upper(nome) like '%"+txnome.getText().toUpperCase()+"%' order by nome", "relatorios/MyReports/relatorio_clientes.jasper");
            }
            if (cbfiltro.getSelectionModel().getSelectedIndex() == 1) {
                gerarRelatorio("select * from cliente where upper(uf) like '%"+txestado.getText().toUpperCase()+"%' order by nome", "relatorios/MyReports/relatorio_clientes.jasper");
            }
            if (cbfiltro.getSelectionModel().getSelectedIndex() == 2) {
                gerarRelatorio("select * from cliente where upper(cpf) like '%"+txcpf.getText().toUpperCase()+"%' order by nome", "relatorios/MyReports/relatorio_clientes.jasper");
            }
            if (cbfiltro.getSelectionModel().getSelectedIndex() == 3) {
                gerarRelatorio("select * from cliente where upper(telefone) like '%"+txtelefone.getText().toUpperCase()+"%' order by nome", "relatorios/MyReports/relatorio_clientes.jasper");
            }
            if (cbfiltro.getSelectionModel().getSelectedIndex() == 4) {
                gerarRelatorio("select * from cliente where upper(cidade) like '%"+txcidade.getText().toUpperCase()+"%' order by nome", "relatorios/MyReports/relatorio_clientes.jasper");
            }
        }
    }

    @FXML
    private void actseleciona(ActionEvent event) {//"Periodo","Nome","Estado","CPF","Telefone","Cidade"
                if(cbfiltro.getSelectionModel().getSelectedItem()!=null)
        {
            if(cbfiltro.getSelectionModel().getSelectedIndex()==0)//"Periodo","Nome","Estado","CPF","Telefone","Cidade"
            {
                nome(1);
                estado(0);
                cpf(0);
                telefone(0);
                cidade(0);
            }
            if(cbfiltro.getSelectionModel().getSelectedIndex()==1)//"Periodo","Nome","Estado","CPF","Telefone","Cidade"
            {
                nome(0);
                estado(1);
                cpf(0);
                telefone(0);
                cidade(0);
            }
            if(cbfiltro.getSelectionModel().getSelectedIndex()==2)//"Periodo","Nome","Estado","CPF","Telefone","Cidade"
            {
                nome(0);
                estado(0);
                cpf(1);
                telefone(0);
                cidade(0);
            }
            if(cbfiltro.getSelectionModel().getSelectedIndex()==3)//"Periodo","Nome","Estado","CPF","Telefone","Cidade"
            {
                nome(0);
                estado(0);
                cpf(0);
                telefone(1);
                cidade(0);
            }
            if(cbfiltro.getSelectionModel().getSelectedIndex()==4)//"Periodo","Nome","Estado","CPF","Telefone","Cidade"
            {
                nome(0);
                estado(0);
                cpf(0);
                telefone(0);
                cidade(1);
            }

        }
    }
    
}
