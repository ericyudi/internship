/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DB.Banco;
import DB.Singleton;
import Entidades.Calcados;
import Entidades.cliente;
import Entidades.funcionario;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eric-
 */
public class DALfunc {
            public boolean gravar(funcionario c)
    {
        String sql;
        if(c.getData_desat()!=null){
        sql = "insert into funcionario(nome,estadocivil,cpf,rg,uf,cidade,bairro,endereco,numero,telefone,permissao,ativo,senha,login,data_desat,cep,email) "
                + "values ('#1','#2','#3','#4','#5','#6','#7','#8',#9,'#a','#b','#c','#d','#e','#f','#g','#h')";
        sql = sql.replaceAll("#1", ""+c.getNome());
        sql = sql.replaceAll("#2", ""+c.getEstadocivil());
        sql = sql.replaceAll("#3", ""+c.getCpf());
        sql = sql.replaceAll("#4", ""+c.getRg());
        sql = sql.replaceAll("#5", ""+c.getUf());
        sql = sql.replaceAll("#6", ""+c.getCidade());
        sql = sql.replaceAll("#7", ""+c.getBairro());
        sql = sql.replaceAll("#8", ""+c.getEndereco());
        sql = sql.replaceAll("#9", ""+c.getNumero());
        sql = sql.replaceAll("#a", ""+c.getTelefone());
        sql = sql.replaceAll("#b", ""+c.getPermissao());
        sql = sql.replaceAll("#c", ""+c.getAtivo());
        sql = sql.replaceAll("#d", ""+c.getSenha());
        sql = sql.replaceAll("#e", ""+c.getLogin());
        sql = sql.replaceAll("#f", ""+c.getData_desat());
        sql = sql.replaceAll("#g", ""+c.getCep());
        sql = sql.replaceAll("#h", ""+c.getEmail());
        }
        else{
        sql = "insert into funcionario(nome,estadocivil,cpf,rg,uf,cidade,bairro,endereco,numero,telefone,permissao,ativo,senha,login,data_desat,cep,email) "
                + "values ('#1','#2','#3','#4','#5','#6','#7','#8',#9,'#a','#b','#c','#d','#e',NULL,'#g','#h')";
        sql = sql.replaceAll("#1", ""+c.getNome());
        sql = sql.replaceAll("#2", ""+c.getEstadocivil());
        sql = sql.replaceAll("#3", ""+c.getCpf());
        sql = sql.replaceAll("#4", ""+c.getRg());
        sql = sql.replaceAll("#5", ""+c.getUf());
        sql = sql.replaceAll("#6", ""+c.getCidade());
        sql = sql.replaceAll("#7", ""+c.getBairro());
        sql = sql.replaceAll("#8", ""+c.getEndereco());
        sql = sql.replaceAll("#9", ""+c.getNumero());
        sql = sql.replaceAll("#a", ""+c.getTelefone());
        sql = sql.replaceAll("#b", ""+c.getPermissao());
        sql = sql.replaceAll("#c", ""+c.getAtivo());
        sql = sql.replaceAll("#d", ""+c.getSenha());
        sql = sql.replaceAll("#e", ""+c.getLogin());
        sql = sql.replaceAll("#g", ""+c.getCep());
        sql = sql.replaceAll("#h", ""+c.getEmail());
        }
        Singleton con = Singleton.getConexao();
        boolean flag = con.manipular(sql);
        return flag;
    }
            
                 public boolean alterar(funcionario c)
    {
         String sql;
        if(c.getData_desat()!=null){
        sql = "update funcionario set nome='#1',estadocivil='#2',cpf='#3',rg='#4',uf='#5',cidade='#6',"
                + "bairro='#7',endereco='#8',numero=#9,telefone='#a',ativo='#b',senha='#c',login='#d',data_desat='#e',cep='#f',email='#g'"
                + " where cod_func="+c.getCod_func();
        sql = sql.replaceAll("#1", ""+c.getNome());
        sql = sql.replaceAll("#2", ""+c.getEstadocivil());
        sql = sql.replaceAll("#3", ""+c.getCpf());
        sql = sql.replaceAll("#4", ""+c.getRg());
        sql = sql.replaceAll("#5", ""+c.getUf());
        sql = sql.replaceAll("#6", ""+c.getCidade());
        sql = sql.replaceAll("#7", ""+c.getBairro());
        sql = sql.replaceAll("#8", ""+c.getEndereco());
        sql = sql.replaceAll("#9", ""+c.getNumero());
        sql = sql.replaceAll("#a", ""+c.getTelefone());
        sql = sql.replaceAll("#b", ""+c.getAtivo());
        sql = sql.replaceAll("#c", ""+c.getSenha());
        sql = sql.replaceAll("#d", ""+c.getLogin());
        sql = sql.replaceAll("#e", ""+c.getData_desat());
        sql = sql.replaceAll("#f", ""+c.getCep());
        sql = sql.replaceAll("#g", ""+c.getEmail());
        }
        else{
                    sql = "update funcionario set nome='#1',estadocivil='#2',cpf='#3',rg='#4',uf='#5',cidade='#6',"
                + "bairro='#7',endereco='#8',numero=#9,telefone='#a',ativo='#b',senha='#c',login='#d',data_desat=NULL,cep='#f',email='#g'"
                + " where cod_func="+c.getCod_func();
        sql = sql.replaceAll("#1", ""+c.getNome());
        sql = sql.replaceAll("#2", ""+c.getEstadocivil());
        sql = sql.replaceAll("#3", ""+c.getCpf());
        sql = sql.replaceAll("#4", ""+c.getRg());
        sql = sql.replaceAll("#5", ""+c.getUf());
        sql = sql.replaceAll("#6", ""+c.getCidade());
        sql = sql.replaceAll("#7", ""+c.getBairro());
        sql = sql.replaceAll("#8", ""+c.getEndereco());
        sql = sql.replaceAll("#9", ""+c.getNumero());
        sql = sql.replaceAll("#a", ""+c.getTelefone());
        sql = sql.replaceAll("#b", ""+c.getAtivo());
        sql = sql.replaceAll("#c", ""+c.getSenha());
        sql = sql.replaceAll("#d", ""+c.getLogin());
        sql = sql.replaceAll("#f", ""+c.getCep());
        sql = sql.replaceAll("#g", ""+c.getEmail());
        }
        Singleton con = Singleton.getConexao();
        boolean flag = con.manipular(sql);
        return flag;
    }
                 
    public List<funcionario> get(String filtro)
    {
        String sql="select * from funcionario";
        if(!filtro.isEmpty())
            sql+=" where "+filtro;
        List <funcionario> aux = new ArrayList();
        Singleton con = Singleton.getConexao();
        ResultSet rs = con.consultar(sql);  
        try 
        {
            while(rs.next())
            {
                 if (rs.getDate("data_desat") != null){
                aux.add(new funcionario(rs.getInt("cod_func"),rs.getString("nome"), rs.getString("estadocivil"),rs.getString("cpf"),
                    rs.getString("rg"),rs.getString("uf"),rs.getString("cidade"),rs.getString("bairro"),
                rs.getString("endereco"),rs.getInt("numero"),rs.getString("telefone"), rs.getString("permissao"),rs.getString("ativo").charAt(0),rs.getString("senha")
                ,rs.getString("login"),rs.getDate("data_desat").toLocalDate(),rs.getString("cep"),rs.getString("email")));
                 }
                 else
                 {
                                     aux.add(new funcionario(rs.getInt("cod_func"),rs.getString("nome"), rs.getString("estadocivil"),rs.getString("cpf"),
                    rs.getString("rg"),rs.getString("uf"),rs.getString("cidade"),rs.getString("bairro"),
                rs.getString("endereco"),rs.getInt("numero"),rs.getString("telefone"), rs.getString("permissao"),rs.getString("ativo").charAt(0),rs.getString("senha")
                ,rs.getString("login"),null,rs.getString("cep"),rs.getString("email")));
                 }
            }
        } 
        catch (SQLException ex) 
        {
            
        }
        
        return aux;
    }
            public funcionario get(int cod)
    {
        funcionario aux = null;
        Singleton con = Singleton.getConexao();
        ResultSet rs = con.consultar("select * from funcionario where cod_func="+cod);
        try 
        {
            while(rs.next())
            {
                 if (rs.getDate("data_desat") != null){
                aux = new funcionario(rs.getInt("cod_func"),rs.getString("nome"), rs.getString("estadocivil"),rs.getString("cpf"),
                    rs.getString("rg"),rs.getString("uf"),rs.getString("cidade"),rs.getString("bairro"),
                rs.getString("endereco"),rs.getInt("numero"),rs.getString("telefone"), rs.getString("permissao"),rs.getString("ativo").charAt(0),rs.getString("senha")
                ,rs.getString("login"),rs.getDate("data_desat").toLocalDate(),rs.getString("cep"),rs.getString("email"));
                 }
                 else
                 {
                                     aux = new funcionario(rs.getInt("cod_func"),rs.getString("nome"), rs.getString("estadocivil"),rs.getString("cpf"),
                    rs.getString("rg"),rs.getString("uf"),rs.getString("cidade"),rs.getString("bairro"),
                rs.getString("endereco"),rs.getInt("numero"),rs.getString("telefone"), rs.getString("permissao"),rs.getString("ativo").charAt(0),rs.getString("senha")
                ,rs.getString("login"),null,rs.getString("cep"),rs.getString("email"));
                 }
            }
        } 
        catch (SQLException ex) 
        {
            
        }
        
        return aux;
    }
    public String buscasenha(int cod) {
        String aux="";
        String sql = "select senha from funcionario where cod_func="+cod;
        Singleton con = Singleton.getConexao();
        ResultSet rs = con.consultar(sql); 
        try {
            if (rs.next()) {
                aux = rs.getString("senha");
            }
        } catch (SQLException ex) {

        }
        return aux;
    }
        public String buscalogin(int cod) {
        String aux="";
        String sql = "select login from funcionario where cod_func="+cod;
        Singleton con = Singleton.getConexao();
        ResultSet rs = con.consultar(sql); 
        try {
            if (rs.next()) {
                aux = rs.getString("login");
            }
        } catch (SQLException ex) {

        }
        return aux;
    }
            public boolean apagar(funcionario c)
    {
        String sql = "delete from funcionario where cod_func="+c.getCod_func();
        Singleton con = Singleton.getConexao();
        boolean flag = con.manipular(sql);
        return flag;
    }
}
