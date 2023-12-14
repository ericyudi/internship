/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DB.Banco;
import DB.Singleton;
import Entidades.Calcados;
import Entidades.Marca;
import Entidades.estoque;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eric-
 */
public class DALEstoque {
                public boolean gravar(estoque e)
    {
        String sql = "insert into estoque(cod_cal,tam,qntd) "
                + "values (#1,#2,#3)";
        sql = sql.replaceAll("#1", ""+e.getCodcal().getCod());
        sql = sql.replaceAll("#2", ""+e.getTam());
        sql = sql.replaceAll("#3", ""+e.getQntd());
        Singleton con = Singleton.getConexao();
        boolean flag = con.manipular(sql);
        return flag;
    }
             public boolean alterar(estoque e)
    {
        String sql = "update estoque set tam=#1,qntd=#2"
                + " where cod_estoque="+e.getCod()+"";
        sql = sql.replaceAll("#1", ""+e.getTam());
        sql = sql.replaceAll("#2", ""+e.getQntd());
        Singleton con = Singleton.getConexao();
        boolean flag = con.manipular(sql);
        return flag;
    }
             public boolean alteraqntd(estoque e)
    {
        String sql = "update estoque set qntd=#2"
                + " where cod_estoque="+e.getCod()+"";
        sql = sql.replaceAll("#2", ""+e.getQntd());
        Singleton con = Singleton.getConexao();
        boolean flag = con.manipular(sql);
        return flag;
    }
 /*   public estoque get(int cod) {
        Marca aux = null;
        ResultSet rs = Banco.getCon().consultar("select * from marca where cod=" + cod);
        try {
            if (rs.next()) {
                aux = new Marca(rs.getInt("cod"), rs.getString("nome"));
            }
        } catch (SQLException ex) {

        }
        return aux;
    }*/
           public List<estoque> get(String filtro)
    {
        String sql="select * from estoque";
        if(!filtro.isEmpty())
            sql+=" where "+filtro+" order by tam";
        List <estoque> aux = new ArrayList();
        Singleton con = Singleton.getConexao();
        ResultSet rs = con.consultar(sql);   
        try 
        {
            while(rs.next())
            {
                aux.add(new estoque(rs.getInt("cod_estoque"),new DALCalcados().get(rs.getInt("cod_cal")),rs.getInt("tam"),rs.getInt("qntd")));
            }
        } 
        catch (SQLException ex) 
        {
            
        }
        
        return aux;
    }
               public estoque getcomcod(int coder)
    {
        estoque aux=null;
        String sql="select * from estoque where cod_estoque="+coder;
        Singleton con = Singleton.getConexao();
        ResultSet rs = con.consultar(sql);   
        try 
        {
            if (rs.next()) {
                aux = new estoque(rs.getInt("cod_estoque"),new DALCalcados().get(rs.getInt("cod_cal")),rs.getInt("tam"),rs.getInt("qntd"));
            }
        } 
        catch (SQLException ex) 
        {
            
        }
        
        return aux;
    }
               public estoque getcomcodcal_vetamanho(int coder, int tamanho)
    {
        estoque aux=null;
        String sql="select * from estoque where cod_cal="+coder+" and tam="+tamanho;
        Singleton con = Singleton.getConexao();
        ResultSet rs = con.consultar(sql);   
        try 
        {
            if (rs.next()) {
                aux = new estoque(rs.getInt("cod_estoque"),new DALCalcados().get(rs.getInt("cod_cal")),rs.getInt("tam"),rs.getInt("qntd"));
            }
        } 
        catch (SQLException ex) 
        {
            
        }
        
        return aux;
    }
           public List<estoque> get2()
    {
        String sql="select * from estoque as e inner join calcado as c on c.cod = e.cod_cal";
        List <estoque> aux = new ArrayList();
        Singleton con = Singleton.getConexao();
        ResultSet rs = con.consultar(sql);   
        try 
        {
            while(rs.next())
            {
                aux.add(new estoque(rs.getInt("cod_estoque"),new DALCalcados().get(rs.getInt("cod_cal")),rs.getInt("tam"),rs.getInt("qntd")));
            }
        } 
        catch (SQLException ex) 
        {
            
        }
        
        return aux;
    }
    public boolean checkIfExists(int codcal, int tam)
    {
        String sql="select * from estoque where cod_cal="+codcal+" AND tam="+tam;
        Singleton con = Singleton.getConexao();
        ResultSet rs = con.consultar(sql);   
        try 
        {
            while(rs.next())
            {
                return false;
            }
        } 
        catch (SQLException ex) 
        {
            
        }
        
        return true;
    }
        public boolean checkIfExistsAlterar(int codcal,int codest, int tam)
    {
        String sql="select * from estoque where cod_estoque!="+codest+" AND tam="+tam+" AND cod_cal="+codcal;
        Singleton con = Singleton.getConexao();
        ResultSet rs = con.consultar(sql);   
        try 
        {
            while(rs.next())
            {
                return false;
            }
        } 
        catch (SQLException ex) 
        {
            
        }
        
        return true;
    }
           
    public boolean apagar(estoque c)
    {
        String sql = "delete from estoque where cod_estoque="+c.getCod();
        Singleton con = Singleton.getConexao();
        boolean flag = con.manipular(sql);
        return flag;
    }
        public int getultimoest() {
        int aux = 0;
        Singleton con = Singleton.getConexao();
        ResultSet rs = con.consultar("select MAX(cod_estoque) from estoque");
        try {
            if (rs.next()) {
                aux = rs.getInt("max");
            }
        } catch (SQLException ex) {

        }
        return aux;
    }
}
