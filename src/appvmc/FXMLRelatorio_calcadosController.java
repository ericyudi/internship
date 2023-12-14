/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appvmc;

import DB.Singleton;
import Entidades.Calcados;
import Entidades.Marca;
import Entidades.cliente;
import Util.MaskFieldUtil;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
public class FXMLRelatorio_calcadosController implements Initializable {

    @FXML
    private JFXButton btCancelar;
    @FXML
    private JFXButton btfinalizar;
    @FXML
    private JFXComboBox<String> cbfiltro;
    @FXML
    private JFXComboBox<Marca> cbmarca;
    @FXML
    private JFXTextField txnome;
    @FXML
    private JFXTextField txqntd2;
    @FXML
    private JFXTextField txqntd1;
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
        carregacombo();
        carregaboxes();
        MaskFieldUtil.monetaryField(txvalor1);
        MaskFieldUtil.monetaryField(txvalor2);
    }    
    private void carregacombo()
    {
                ObservableList<String> filtro
                = FXCollections.observableArrayList(
                        "Quantidade Disponivel","Nome","Marca","Valor"//fazer filtro com data
                );
        cbfiltro.setItems(filtro);

    }
        private void carregaboxes()
    {
        cbmarca.setItems(FXCollections.observableArrayList(new Marca().get("")));
    }
    @FXML
    private void btnCancelarSaiu(MouseEvent event) {
        
    }

    @FXML
    private void btnCancelarEntrou(MouseEvent event) {
        
    }

    @FXML
    private void clkBtCancelar(ActionEvent event) {
        FXMLDocumentController.spnprincipal.setCenter(null);
    }
    private void qntd(int flag){
        if(flag == 0)
        {
            lbqntdvalor.setVisible(false);
            txqntd1.setVisible(false);
            txqntd2.setVisible(false);
        }
        else
        {
            lbqntdvalor.setVisible(true);
            txqntd1.setVisible(true);
            txqntd2.setVisible(true);
        }
        
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
    private void marca(int flag){
        if(flag == 0){
            cbmarca.setVisible(false);
        }
        else
        {
            cbmarca.setVisible(true);
        }
    }
    private void valor(int flag){
        if(flag == 0)
        {
            lbqntdvalor.setVisible(false);
            txvalor1.setVisible(false);
            txvalor2.setVisible(false);
        }
        else
        {
            lbqntdvalor.setVisible(true);
            txvalor1.setVisible(true);
            txvalor2.setVisible(true);
        }
        
    }
    @FXML
    private void btnFinalizaSaiu(MouseEvent event) {
    }

    @FXML
    private void btnFinalizaEntrou(MouseEvent event) {
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
            viewer.setTitle("Relatório de Calçados");//titulo do relatório
            viewer.setVisible(true);
        } catch (JRException erro) {
            System.out.println("erro:" + erro.getMessage());
        }
    }
    @FXML
    private void clkBtfinalizar(ActionEvent event) {
        if (cbfiltro.getSelectionModel().getSelectedItem() != null) {
            if (cbfiltro.getSelectionModel().getSelectedIndex() == 0)//qntd,nome,marca,valor
            {
                gerarRelatorio("select calcado.cod,calcado.nome,SUM(estoque.qntd),\n"
                        + "calcado.codespe,calcado.valorcompra,calcado.valorvenda,\n"
                        + "calcado.genero\n"
                        + "from calcado\n"
                        + "inner join estoque on estoque.cod_cal = calcado.cod\n"
                        + "group by calcado.cod\n"
                        + "having SUM(estoque.qntd) between " + txqntd1.getText() + " and " + txqntd2.getText() + "", "relatorios/MyReports/relatorio_calcados_quantidade.jasper");
            }
            if (cbfiltro.getSelectionModel().getSelectedIndex() == 1) {
                gerarRelatorio("select * from calcado where nome like '%" + txnome.getText() + "%'", "relatorios/MyReports/relatorio_calcados_nome.jasper");
            }
            if (cbfiltro.getSelectionModel().getSelectedIndex() == 2) {
                gerarRelatorio("select calcado.cod,calcado.nome,marca.nome,calcado.cores,\n"
                        + "calcado.valorcompra,calcado.valorvenda,calcado.genero,\n"
                        + "calcado.codespe from calcado\n"
                        + "inner join marca on marca.cod = calcado.cod_marca\n"
                        + "where marca.cod =  " + cbmarca.getValue().getCod() + " ", "relatorios/MyReports/relatorio_calcados_marca.jasper");
            }
            if (cbfiltro.getSelectionModel().getSelectedIndex() == 3) {
                gerarRelatorio("select calcado.cod,calcado.nome,\n"
                        + "calcado.codespe,calcado.valorcompra,calcado.valorvenda,\n"
                        + "calcado.genero\n"
                        + "from calcado\n"
                        + "where calcado.valorcompra between " + txvalor1.getText().replace(".", "").replace(",", ".") + " and " + txvalor2.getText().replace(".", "").replace(",", ".") + " \n"
                        + "order by calcado.valorcompra", "relatorios/MyReports/relatorio_calcados_valor.jasper");
            }
        }
    }

    @FXML
    private void actseleciona(ActionEvent event) {
        if(cbfiltro.getSelectionModel().getSelectedItem()!=null)
        {
            if(cbfiltro.getSelectionModel().getSelectedIndex()==0)//qntd,nome,marca,valor
            {
                nome(0);
                marca(0);
                valor(0);
                qntd(1);
            }
            if(cbfiltro.getSelectionModel().getSelectedIndex()==1)
            {
                nome(1);
                marca(0);
                valor(0);
                qntd(0);
            }
            if(cbfiltro.getSelectionModel().getSelectedIndex()==2)
            {
                nome(0);
                marca(1);
                valor(0);
                qntd(0);
            }
            if(cbfiltro.getSelectionModel().getSelectedIndex()==3)
            {
                nome(0);
                marca(0);
                qntd(0);                
                valor(1);
            }
        }
    }
    
}
