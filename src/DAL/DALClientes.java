/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DB.Banco;
import DB.Singleton;
import Entidades.cliente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eric-
 */
public class DALClientes {
        public boolean gravar(cliente c)
    {
        String sql;
        if(c.getDatabloqueio() != null){
        sql = "insert into cliente(nome,cpf,telefone,email,rg,uf,cidade,cep,bairro,endereco,numero,limitefiado,fiado,saldofiado,databloqueio) "
                + "values ('#1','#2','#3','#4','#5','#6','#7','#8','#9','#a',#b,#c,'#d',#e,'#f')";
        sql = sql.replaceAll("#1", ""+c.getNome());
        sql = sql.replaceAll("#2", ""+c.getCpf());
        sql = sql.replaceAll("#3", ""+c.getTelefone());
        sql = sql.replaceAll("#4", ""+c.getEmail());
        sql = sql.replaceAll("#5", ""+c.getRg());
        sql = sql.replaceAll("#6", ""+c.getUf());
        sql = sql.replaceAll("#7", ""+c.getCidade());
        sql = sql.replaceAll("#8", ""+c.getCep());
        sql = sql.replaceAll("#9", ""+c.getBairro());
        sql = sql.replaceAll("#a", ""+c.getEndereco());
        sql = sql.replaceAll("#b", ""+c.getNumero());
        sql = sql.replaceAll("#c", ""+c.getLim_fiado());
        sql = sql.replaceAll("#d", ""+c.getFiado());
        sql = sql.replaceAll("#e", ""+c.getSaldofiado());
        sql = sql.replaceAll("#f", ""+c.getDatabloqueio());
        }
        else
        {
        sql = "insert into cliente(nome,cpf,telefone,email,rg,uf,cidade,cep,bairro,endereco,numero,limitefiado,fiado,saldofiado,databloqueio) "
                + "values ('#1','#2','#3','#4','#5','#6','#7','#8','#9','#a',#b,#c,'#d',#e,NULL)";
        sql = sql.replaceAll("#1", ""+c.getNome());
        sql = sql.replaceAll("#2", ""+c.getCpf());
        sql = sql.replaceAll("#3", ""+c.getTelefone());
        sql = sql.replaceAll("#4", ""+c.getEmail());
        sql = sql.replaceAll("#5", ""+c.getRg());
        sql = sql.replaceAll("#6", ""+c.getUf());
        sql = sql.replaceAll("#7", ""+c.getCidade());
        sql = sql.replaceAll("#8", ""+c.getCep());
        sql = sql.replaceAll("#9", ""+c.getBairro());
        sql = sql.replaceAll("#a", ""+c.getEndereco());
        sql = sql.replaceAll("#b", ""+c.getNumero());
        sql = sql.replaceAll("#c", ""+c.getLim_fiado());
        sql = sql.replaceAll("#d", ""+c.getFiado());
        sql = sql.replaceAll("#e", ""+c.getSaldofiado());

        }
        Singleton con = Singleton.getConexao();
        boolean flag = con.manipular(sql);
        return flag;
    }
        
     public boolean alterar(cliente c)
    {
        String sql;
        if(c.getDatabloqueio() != null){
        sql= "update cliente set nome='#1',cpf='#2',telefone='#3',email='#4',rg='#5',uf='#6',cidade='#7',cep='#8',"
                + "bairro='#9',endereco='#a',numero=#b"
                + " where cod_cliente="+c.getCod();
        sql = sql.replaceAll("#1", ""+c.getNome());
        sql = sql.replaceAll("#2", ""+c.getCpf());
        sql = sql.replaceAll("#3", ""+c.getTelefone());
        sql = sql.replaceAll("#4", ""+c.getEmail());
        sql = sql.replaceAll("#5", ""+c.getRg());
        sql = sql.replaceAll("#6", ""+c.getUf());
        sql = sql.replaceAll("#7", ""+c.getCidade());
        sql = sql.replaceAll("#8", ""+c.getCep());
        sql = sql.replaceAll("#9", ""+c.getBairro());
        sql = sql.replaceAll("#a", ""+c.getEndereco());
        sql = sql.replaceAll("#b", ""+c.getNumero());
        }
        else{
                    sql= "update cliente set nome='#1',cpf='#2',telefone='#3',email='#4',rg='#5',uf='#6',cidade='#7',cep='#8',"
                + "bairro='#9',endereco='#a',numero=#b"
                + " where cod_cliente="+c.getCod();
        sql = sql.replaceAll("#1", ""+c.getNome());
        sql = sql.replaceAll("#2", ""+c.getCpf());
        sql = sql.replaceAll("#3", ""+c.getTelefone());
        sql = sql.replaceAll("#4", ""+c.getEmail());
        sql = sql.replaceAll("#5", ""+c.getRg());
        sql = sql.replaceAll("#6", ""+c.getUf());
        sql = sql.replaceAll("#7", ""+c.getCidade());
        sql = sql.replaceAll("#8", ""+c.getCep());
        sql = sql.replaceAll("#9", ""+c.getBairro());
        sql = sql.replaceAll("#a", ""+c.getEndereco());
        sql = sql.replaceAll("#b", ""+c.getNumero());
        }
        Singleton con = Singleton.getConexao();
        boolean flag = con.manipular(sql);
        return flag;
    }
        
    public List<cliente> get(String filtro)
    {
        String sql="select * from cliente";
        if(!filtro.isEmpty())
            sql+=" where "+filtro;
        List <cliente> aux = new ArrayList();
        Singleton con = Singleton.getConexao();
        ResultSet rs = con.consultar(sql);  
        try 
        {
            while(rs.next())
            {
                if (rs.getDate("databloqueio") != null){
                aux.add(new cliente(rs.getInt("cod_cliente"),rs.getString("nome"), rs.getString("cpf"), rs.getString("telefone"),
                    rs.getString("email"),rs.getString("rg"),rs.getString("uf"),rs.getString("cidade"),rs.getString("cep"),rs.getString("bairro"),
                rs.getString("endereco"),rs.getInt("numero"),rs.getDouble("limitefiado"),rs.getString("fiado").charAt(0),rs.getDouble("saldofiado"),rs.getDate("databloqueio").toLocalDate()));
                }
                else
                {
                    aux.add(new cliente(rs.getInt("cod_cliente"),rs.getString("nome"), rs.getString("cpf"), rs.getString("telefone"),
                    rs.getString("email"),rs.getString("rg"),rs.getString("uf"),rs.getString("cidade"),rs.getString("cep"),rs.getString("bairro"),
                rs.getString("endereco"),rs.getInt("numero"),rs.getDouble("limitefiado"),rs.getString("fiado").charAt(0),rs.getDouble("saldofiado"),null));
                }
            }
        } 
        catch (SQLException ex) 
        {
            
        }
        
        return aux;
    }
        public double buscasaldo(int cod) {
        double aux=0;
        String sql = "select saldofiado from cliente where cod_cliente="+cod;
        Singleton con = Singleton.getConexao();
        ResultSet rs = con.consultar(sql);  
        try {
            if (rs.next()) {
                aux = rs.getDouble("saldofiado");
            }
        } catch (SQLException ex) {

        }
        return aux;
    }
        public boolean apagar(cliente c)
    {
        String sql = "delete from cliente where cod_cliente="+c.getCod();
        Singleton con = Singleton.getConexao();
        boolean flag = con.manipular(sql);
        return flag;
    }
}
