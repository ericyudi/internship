/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author eric-
 */
public class Banco {
        
    static private Conexao con = null;
    
    static public Conexao getCon()
    {
        return con;
    }

    private Banco() {} // construtor privado, ou seja, nao pode dar um new em banco, da uma segurança maior no projeto
    
    static public boolean conectar()
    {
        con = new Conexao(); 
        System.out.println("conectando");
        return con.conectar("jdbc:postgresql://localhost/vmcdb","postgres","postgres123");
    }
    
    public static boolean criarBD(String BD)
    { try{
        //Class.forName("org.postgresql.Driver");
        String url = "jdbc:postgresql://localhost/";
        Connection con = DriverManager.getConnection(url,"postgres","postgres123");

        Statement statement = con.createStatement();
        statement.execute("CREATE DATABASE "+BD+" WITH OWNER = postgres ENCODING = 'UTF8'  "
                                + "TABLESPACE = pg_default LC_COLLATE = 'Portuguese_Brazil.1252'  "
                                + "LC_CTYPE = 'Portuguese_Brazil.1252'  CONNECTION LIMIT = -1;");
        statement.close();
        con.close();
      }catch(Exception e)
      {  System.out.println(e.getMessage()); return false;}
         return true;                
    }
}
