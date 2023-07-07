/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appvmc;

import Entidades.funcionario;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author eric-
 */
public class FXMLAutenticacaoController implements Initializable {
    public static BorderPane spnprincipal=null;
    @FXML
    private BorderPane pnprincipal;
    @FXML
    private JFXTextField txLogin;
    @FXML
    private JFXPasswordField txSenha;
    @FXML
    private JFXButton btnLogar;
    @FXML
    private Label lblAut;
    @FXML
    private JFXButton btnCancelar;
    private static funcionario aux;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        spnprincipal = pnprincipal;
        lblAut.setVisible(false);
    }    
    public static funcionario getLogin() {
        return aux;
    }
    @FXML
    private void btnLogarSaiu(MouseEvent event) {
         btnLogar.setStyle("-fx-border-color: black; -fx-border-radius: 3;-fx-background-color: white");
    }

    @FXML
    private void btnLogarEntrou(MouseEvent event) {
        btnLogar.setStyle("-fx-background-color: lightblue");
        
    }

    @FXML
    private void clkLogar(ActionEvent event) throws IOException {
            funcionario func = new funcionario();
            List<funcionario> res = func.get("login = '"+txLogin.getText()+"' and senha = '"+txSenha.getText()+"'");
            if(res.size() == 1 && res.get(0).getAtivo() == 'S')//Esta ativada
            {
                aux = res.get(0);
                Stage stage = (Stage) pnprincipal.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                Scene scene = new Scene(root);

                stage.setTitle("Vania Magazine e Calçados");
                stage.setScene(scene);

                stage.show();  
                stage.setMaximized(true);
            }
            else
                lblAut.setVisible(true);
    }

    @FXML
    private void btnCancelarSaiu(MouseEvent event) {
        btnCancelar.setStyle("-fx-border-color: black; -fx-border-radius: 3;-fx-background-color: white");
    }

    @FXML
    private void btnCancelarEntrou(MouseEvent event) {
        btnCancelar.setStyle("-fx-background-color: lightblue");
    }

    @FXML
    private void clkCancelar(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    private void loginkeyenter(KeyEvent event) throws IOException {
        KeyCode ch = event.getCode();
        if(ch == event.getCode().ENTER)
        {
            clkLogar();
        }
    }
        private void clkLogar() throws IOException {
            funcionario func = new funcionario();
            List<funcionario> res = func.get("login = '"+txLogin.getText()+"' and senha = '"+txSenha.getText()+"'");
            if(res.size() == 1 && res.get(0).getAtivo() == 'S')//Esta ativada
            {
                aux = res.get(0);
                Stage stage = (Stage) pnprincipal.getScene().getWindow();
                Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));
                Scene scene = new Scene(root);

                stage.setTitle("Vania Magazine e Calçados");
                stage.setScene(scene);

                stage.show();  
                stage.setMaximized(true);
            }
            else
                lblAut.setVisible(true);
    }
    
}
