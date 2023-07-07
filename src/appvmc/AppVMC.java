/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package appvmc;

import DB.Banco;
import DB.Singleton;
import com.sun.org.apache.xalan.internal.xsltc.dom.SingletonIterator;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author eric-
 */
public class AppVMC extends Application {
        private final String url = "jdbc:postgresql://localhost/vmcdb";
    private final String user = "postgres";
    private final String password = "postgres123";

    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     */
    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected to the PostgreSQL server successfully.");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return conn;
    }

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLAutenticacao.fxml"));
         AppVMC app = new AppVMC();
        app.connect();
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.show();
                   // stage.setMaximized(true);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
           /* if(Banco.conectar())
            launch(args);*/
           Singleton sg = Singleton.getConexao();
           if(sg!=null)
               launch(args);
    }
    
}
