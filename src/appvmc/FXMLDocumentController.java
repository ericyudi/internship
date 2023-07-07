/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appvmc;

import Entidades.funcionario;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

/**
 *
 * @author eric-
 */
public class FXMLDocumentController implements Initializable {
    public static BorderPane spnprincipal=null;
    @FXML
    private BorderPane pnprincipal;
    @FXML
    private MenuBar menu;
    @FXML
    private MenuItem mGerencia;
    @FXML
    private Label lblWelcome;
    @FXML
    private Text txnome;
    public static funcionario aux;
    @FXML
    private MenuItem menu_funcionario;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       spnprincipal = pnprincipal;
       aux = FXMLAutenticacaoController.getLogin();
       String[] parts = aux.getNome().split(" ");
       txnome.setText("Bem-Vinda(o), "+parts[0]+"!");
       ValidaAcesso();
    }    

    public static void efeito(boolean on) {
        if (on) {
            spnprincipal.setStyle("-fx-background-position: center center;");
        } else {
            spnprincipal.setStyle("-fx-background-position: center center;");
        }
    }
    @FXML
    private void clkCadCliente(ActionEvent event) {
            try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLCadClientes.fxml"));
            //efeito(true);
            pnprincipal.setCenter(root);

        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
    private void ValidaAcesso()
    {
        if(aux.getPermissao().charAt(0) == 'T')
        {
            menu_funcionario.setDisable(false);
        }
        else
            menu_funcionario.setDisable(true);
    }
    
    @FXML
    private void clkCadCalcados(ActionEvent event) {
                            try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLCadCalcados.fxml"));
            //efeito(true);
            pnprincipal.setCenter(root);

        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    private void clkCadVenda(ActionEvent event) {
                    try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLLancaVenda.fxml"));
            //efeito(true);
            pnprincipal.setCenter(root);

        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void clkCadConta(ActionEvent event) {
    }

    @FXML
    private void clkCadTPConta(ActionEvent event) {
                            try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLCadTpConta.fxml"));
            //efeito(true);
            pnprincipal.setCenter(root);

        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void clkConfEmpresa(ActionEvent event) {
    }

    @FXML
    private void clkGerenciaConta(ActionEvent event) {
    }

    @FXML
    private void clkContSair(ActionEvent event) {
    }

    @FXML
    private void clkDespesa(ActionEvent event) {
                    try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLLancaDespesa.fxml"));
            //efeito(true);
            pnprincipal.setCenter(root);

        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void clkMarcas(ActionEvent event) {
                            try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLCadMarca.fxml"));
            //efeito(true);
            pnprincipal.setCenter(root);

        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void clkCadFuncionario(ActionEvent event) {
                                    try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLCadFuncionario.fxml"));
            //efeito(true);
            pnprincipal.setCenter(root);

        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
}
