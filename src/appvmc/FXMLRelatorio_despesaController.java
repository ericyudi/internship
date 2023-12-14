/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appvmc;

import DB.Singleton;
import Entidades.Calcados;
import Entidades.cliente;
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
public class FXMLRelatorio_despesaController implements Initializable {

    @FXML
    private JFXButton btCancelar;
    @FXML
    private JFXButton btfinalizar;
    @FXML
    private JFXComboBox<String> cbfiltro;
    @FXML
    private DatePicker dtinicio;
    @FXML
    private DatePicker dtfim;
    @FXML
    private Label labelperiodo;
    @FXML
    private JFXTextField txvalor2;
    @FXML
    private Label lbqntdvalor;
    @FXML
    private JFXTextField txvalor1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dtinicio.setValue(LocalDate.now());
        dtfim.setValue(LocalDate.now());
        carregacombo();
        MaskFieldUtil.monetaryField(txvalor1);
        MaskFieldUtil.monetaryField(txvalor2);
    }    
    private void carregacombo()
    {
                ObservableList<String> filtro
                = FXCollections.observableArrayList(
                        "Periodo","Valor"//fazer filtro com data
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
    private void clkBtfinalizar(ActionEvent event) {

        if (cbfiltro.getSelectionModel().getSelectedItem() != null) {
            if (cbfiltro.getSelectionModel().getSelectedIndex() == 0)//periodo,valor
            {
                gerarRelatorio("select * from despesa inner join \n"
                        + "funcionario on funcionario.cod_func = despesa.cod_func\n"
                        + "inner join tipoconta on tipoconta.cod = despesa.cod_tpconta\n"
                        + "where dt_inicio between '"+dtinicio.getValue()+"' and '"+dtfim.getValue()+"'"
                        + "order by dt_inicio", "relatorios/MyReports/relatorio_despesa.jasper");
            
            }
            if (cbfiltro.getSelectionModel().getSelectedIndex() == 1)//periodo,valor
            {
                gerarRelatorio("select * from despesa inner join \n"
                        + "funcionario on funcionario.cod_func = despesa.cod_func\n"
                        + "inner join tipoconta on tipoconta.cod = despesa.cod_tpconta\n"
                        + "where valor between '"+txvalor1.getText().replace(".", "").replace(",", ".")+"' and '"+txvalor2.getText().replace(".", "").replace(",", ".")+"'"
                        + "order by dt_inicio", "relatorios/MyReports/relatorio_despesa.jasper");
            }
        }

    }
    private void periodo(int flag) {
        if (flag == 0) {
            labelperiodo.setVisible(false);
            dtinicio.setVisible(false);
            dtfim.setVisible(false);
        } else {
            labelperiodo.setVisible(true);
            dtinicio.setVisible(true);
            dtfim.setVisible(true);
        }
    }

    private void valor(int flag) {
        if (flag == 0) {
            lbqntdvalor.setVisible(false);
            txvalor1.setVisible(false);
            txvalor2.setVisible(false);
        } else {
            lbqntdvalor.setVisible(true);
            txvalor1.setVisible(true);
            txvalor2.setVisible(true);
        }

    }
    @FXML
    private void actseleciona(ActionEvent event) {
                if(cbfiltro.getSelectionModel().getSelectedItem()!=null)
        {
            if(cbfiltro.getSelectionModel().getSelectedIndex()==0)//qntd,nome,marca,valor
            {
                periodo(1);
                valor(0);
            }
            if(cbfiltro.getSelectionModel().getSelectedIndex()==1)
            {
                periodo(0);
                valor(1);
            }
        }
    }
    
}
