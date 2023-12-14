/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DB.Banco;
import DB.Singleton;
import Entidades.tipoconta;
import Entidades.tipoconta;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eric-
 */
public class DALtipoconta {
                public boolean gravar(tipoconta tp)
    {
        String sql = "insert into tipoconta(nome) "
                + "values ('#1')";
        sql = sql.replaceAll("#1", ""+tp.getNome());
        Singleton con = Singleton.getConexao();
        boolean flag = con.manipular(sql);
        return flag;
    }
                
                     public boolean alterar(tipoconta m)
    {
        String sql = "update tipoconta set nome='#1'"
                + " where cod="+m.getCod();
        sql = sql.replaceAll("#1", ""+m.getNome());
        Singleton con = Singleton.getConexao();
        boolean flag = con.manipular(sql);
        return flag;
    }
        
       public List<tipoconta> get(String filtro)
    {
        String sql="select * from tipoconta";
        if(!filtro.isEmpty())
            sql+=" where "+filtro;
        List <tipoconta> aux = new ArrayList();
        Singleton con = Singleton.getConexao();
        ResultSet rs = con.consultar(sql); 
        try 
        {
            while(rs.next())
            {
                aux.add(new tipoconta(rs.getInt("cod"),rs.getString("nome")));
            }
        } 
        catch (SQLException ex) 
        {
            
        }
        
        return aux;
    }
            public tipoconta get(int cod)
    {
        tipoconta aux = null;
        String sql = "select * from tipoconta where cod="+cod;
        Singleton con = Singleton.getConexao();
        ResultSet rs = con.consultar(sql); 
        try 
        {
            if(rs.next())
            {
                aux = new tipoconta(rs.getInt("cod"),rs.getString("nome"));
            }
        } 
        catch (SQLException ex) 
        {
            
        }
        return aux;
    }   
            public tipoconta gettp(String cod)
    {
        tipoconta aux = null;
        String sql = "select * from tipoconta where nome='"+cod+"'";
        Singleton con = Singleton.getConexao();
        ResultSet rs = con.consultar(sql); 
        try 
        {
            if(rs.next())
            {
                aux = new tipoconta(rs.getInt("cod"),rs.getString("nome"));
            }
        } 
        catch (SQLException ex) 
        {
            
        }
        return aux;
    }   
       
        public boolean apagar(tipoconta m)
    {
        String sql = "delete from tipoconta where cod="+m.getCod();
        Singleton con = Singleton.getConexao();
        boolean flag = con.manipular(sql);
        return flag;
    }
}
