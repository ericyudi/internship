/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author eric-
 */
public class Singleton {
        private Connection connect;
    private String driver = "org.postgresql.Driver";
    private String local = "jdbc:postgresql://localhost/";
    private String banco = "vmcdb";
    private String usuario = "postgres";
    private String senha = "postgres123";
    private String erro="";
    private static Singleton conexao;

    public Connection getConnect() {
        return connect;
    }
    private Singleton(){
        try {
            Class.forName(this.driver); //"org.postgresql.Driver");
            String url = this.local+this.banco; //"jdbc:postgresql://localhost/"+banco;
            connect = DriverManager.getConnection( url, this.usuario,this.senha);
            System.out.println("chega aqui?");
        }
        catch (ClassNotFoundException cnfex )
        { erro="Falha ao ler o driver JDBC: " + cnfex.toString();
        System.out.println(erro);
        }
        catch (SQLException sqlex )
        { erro="Impossivel conectar com a base de dados: " + sqlex.toString(); }
        catch ( Exception ex )
        { erro="Outro erro: " + ex.toString(); }
        System.out.println(erro);
    }

    public static Singleton getConexao(){
        if(conexao == null){
            conexao = new Singleton();
        }
        return conexao;
    }
    public String getMensagemErro() {
        return erro;
    }
    public boolean getEstadoConexao() {
        if(connect==null)  return false;
        else return true;
    }
    public boolean manipular(String sql) // inserir, alterar,excluir
	{
        try {
            Statement statement = connect.createStatement();
            int result = statement.executeUpdate( sql );
            statement.close();
            if(result>=1)
                return true;
        }
        catch ( SQLException sqlex )
        {  erro="Erro: "+sqlex.toString();
           return false;
        }
        return false;
    }
    public ResultSet consultar(String sql)
    {   ResultSet rs=null;
    System.out.println(sql);
        try {
           Statement statement = connect.createStatement();
             //ResultSet.TYPE_SCROLL_INSENSITIVE,
             //ResultSet.CONCUR_READ_ONLY);
           rs = statement.executeQuery( sql );
           //statement.close();
        }
        catch (SQLException sqlex )
        { erro="Erro: "+sqlex.toString();
          return null;
        }
        return rs;
    }
    public int getMaxPK(String tabela,String chave) 
    {
        String sql="select max("+chave+") from "+tabela;
        int max=0;
        ResultSet rs= consultar(sql);
        try 
        {
            if(rs.next())
                max=rs.getInt(1);
        }
        catch (SQLException sqlex)
        { 
             erro="Erro: " + sqlex.toString();
             return -1;
        }
        return max;
    }
    public boolean fecharConexao()
    {
        boolean flag=true;
        try
        {
        //connect.commit();
        connect.close();
        }
        catch(Exception e)
        {
            flag=false;
        }
        return flag;
    }
}
