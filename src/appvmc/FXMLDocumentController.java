/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appvmc;

import DB.Singleton;
import Entidades.funcionario;
import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
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
    public static funcionario aux;
    @FXML
    private MenuItem menu_funcionario;
    @FXML
    private Label textarea;
    @FXML
    private Button bthelp;
    private String funcao="Manual_do_usuário.pdf";
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       spnprincipal = pnprincipal;
       //spnprincipal.setStyle("-fx-background-image: url('img/backgroundimg.png');-fx-background-position: center center;");
       pnprincipal.setStyle("-fx-background-image: url('bg.png');-fx-background-position: center center;-fx-background-repeat: no-repeat;");
       aux = FXMLAutenticacaoController.getLogin();
       String[] parts = aux.getNome().split(" ");
       textarea.setText("Usuário: "+parts[0]+"");
       //textarea.setDisable(true);
       ValidaAcesso();
    }    

    public static void efeito(boolean on) {
        if (on) {
            spnprincipal.setStyle("-fx-background-image: url('img/backgroundimg.png');-fx-background-position: center center;");
        } else {
            spnprincipal.setStyle("-fx-background-image: url('img/backgroundimg.png');-fx-background-position: center center;");
        }
    }
    @FXML
    private void clkCadCliente(ActionEvent event) {
            try {
            funcao="Funções_Básicas.pdf";
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
            funcao="Funções_Básicas.pdf";
            Parent root = FXMLLoader.load(getClass().getResource("FXMLCadCalcados.fxml"));
            //efeito(true);
            pnprincipal.setCenter(root);

        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void clkCadVenda(ActionEvent event) {
                    try {
            funcao="Cadastro_de_Venda.pdf";
            Parent root = FXMLLoader.load(getClass().getResource("FXMLMostraProdutos.fxml"));
            //efeito(true);
            pnprincipal.setCenter(root);

        } catch (IOException ex) {
            System.out.println(ex);
        }
    }


    @FXML
    private void clkCadTPConta(ActionEvent event) {
                            try {
            funcao="Funções_Básicas.pdf";
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
            funcao="Cadastro_de_Despesa.pdf";
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
            funcao="Funções_Básicas.pdf";
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
            funcao="Funções_Básicas.pdf";
            Parent root = FXMLLoader.load(getClass().getResource("FXMLCadFuncionario.fxml"));
            //efeito(true);
            pnprincipal.setCenter(root);

        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void clkLibFiado(ActionEvent event) {
        try {
            funcao="Liberar_Fiado.pdf";
            Parent root = FXMLLoader.load(getClass().getResource("FXMLLiberarFiado.fxml"));
            //efeito(true);
            pnprincipal.setCenter(root);

        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void clkBloqFiado(ActionEvent event) {
        try {
            funcao="Bloquear_Fiado.pdf";
            Parent root = FXMLLoader.load(getClass().getResource("FXMLBloquearFiado.fxml"));
            //efeito(true);
            pnprincipal.setCenter(root);

        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void clkCadEntradaProd(ActionEvent event) {
        try {
            funcao="Entrada_de_Produtos.pdf";
            Parent root = FXMLLoader.load(getClass().getResource("FXMLRegistrarCalcados.fxml"));
            //efeito(true);
            pnprincipal.setCenter(root);

        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void clkatualizavalorvenda(ActionEvent event) {
        try {
            funcao="Atualizar_valor_de_venda.pdf";
            Parent root = FXMLLoader.load(getClass().getResource("FXMLAtualizarValorVenda.fxml"));
            //efeito(true);
            pnprincipal.setCenter(root);

        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void clikpagvendas(ActionEvent event) {
        try {
            funcao="Pagamento_de_Vendas.pdf";
            Parent root = FXMLLoader.load(getClass().getResource("FXMLTelaQuitarVendas.fxml"));
            //efeito(true);
            pnprincipal.setCenter(root);

        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void clikpagdespesa(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLTelaQuitarDespesas.fxml"));
            //efeito(true);
            pnprincipal.setCenter(root);

        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void clikpagfiado(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLTelaQuitarFiado.fxml"));
            //efeito(true);
            pnprincipal.setCenter(root);

        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void relatoriovenda(ActionEvent event) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLRelatorio_Venda.fxml"));
            //efeito(true);
            pnprincipal.setCenter(root);

        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void relatoriocalcado(ActionEvent event) {
                try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLRelatorio_calcados.fxml"));
            //efeito(true);
            pnprincipal.setCenter(root);

        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void relatoriodespesa(ActionEvent event) {
                        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLRelatorio_despesa.fxml"));
            //efeito(true);
            pnprincipal.setCenter(root);

        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void relatoriocliente(ActionEvent event) {
                                try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLRelatorio_clientes.fxml"));
            //efeito(true);
            pnprincipal.setCenter(root);

        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void relatoriofiado(ActionEvent event) {
                                        try {
            Parent root = FXMLLoader.load(getClass().getResource("FXMLRelatorio_fiado.fxml"));
            //efeito(true);
            pnprincipal.setCenter(root);

        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    @FXML
    private void bthelpaction(ActionEvent event) {
        {
            try {
//constructor of file class having file as argument
                if(!funcao.equals("")){
                File file = new File(".\\manual\\"+funcao);
                if (!Desktop.isDesktopSupported())//check if Desktop is supported by Platform or not
                {
                    System.out.println("not supported");
                    return;
                }
                Desktop desktop = Desktop.getDesktop();
                if (file.exists()) //checks file exists or not
                {
                    desktop.open(file);
                }
                }
                //opens the specified file
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @FXML
    private void backup(ActionEvent event) {
        Singleton.realizaBackupRestauracao("bd\\backup.bat");
    }

    @FXML
    private void restore(ActionEvent event) {
        Singleton.realizaBackupRestauracao("bd\\restore.bat");
    }

}
