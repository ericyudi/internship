/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DB.Singleton;
import Entidades.despesa;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eric-
 */
public class DALdespesa {
        public boolean gravar(despesa c) {
        String sql = "insert into despesa(cod_func,cod_tpconta,cod_entrada,nome,descricao,status,valor,dt_venc,dt_inicio) values "
                + "(#a,#b,#c,'#d','#e','#f',#g,'#h','#i')";
        
        sql = sql.replaceAll("#a", "" + c.getFunc().getCod_func());
        sql = sql.replaceAll("#b", "" + c.getTp_conta().getCod());
        if(c.getEntr() == null)
            sql = sql.replaceAll("#c", "null");
        else
            sql = sql.replaceAll("#c", "" + c.getEntr().getCod_entrada());
        sql = sql.replaceAll("#d", "" + c.getNome());
        sql = sql.replaceAll("#e", "" + c.getDescricao());        
        sql = sql.replaceAll("#f", "" + c.getStatus());
        sql = sql.replaceAll("#g", "" + c.getValor());
        sql = sql.replaceAll("#h", "" + c.getDt_venc());
        sql = sql.replaceAll("#i", "" + c.getDt_inicio());

       Singleton con = Singleton.getConexao();
        boolean flag = con.manipular(sql);
        return flag;
    }
                 public boolean alterageral(despesa c)
    {
        String sql = "update despesa set nome='#1',cod_tpconta=#2,descricao='#3',valor=#4,status='#6',dt_venc='#7'"
                + " where cod_despesa="+c.getCod_despesa()+"";
        sql = sql.replaceAll("#1", ""+c.getNome());
        sql = sql.replaceAll("#2", ""+c.getTp_conta().getCod());
        sql = sql.replaceAll("#3", ""+c.getDescricao());
        sql = sql.replaceAll("#4", ""+c.getValor());
        sql = sql.replaceAll("#6", ""+c.getStatus());
        sql = sql.replaceAll("#7", ""+c.getDt_venc());
        Singleton con = Singleton.getConexao();
        boolean flag = con.manipular(sql);
        return flag;
    }
                 public boolean alterastatus(despesa c)
    {
        String sql = "update despesa set status='#6'"
                + " where cod_despesa="+c.getCod_despesa()+"";
        sql = sql.replaceAll("#6", ""+c.getStatus());
        Singleton con = Singleton.getConexao();
        boolean flag = con.manipular(sql);
        return flag;
    }
                 
    
        public List<despesa> get(String filtro)
    {
        String sql="select * from despesa";
        if(!filtro.isEmpty())
            sql+=" where "+filtro;
        List <despesa> aux = new ArrayList();
        Singleton con = Singleton.getConexao();
        ResultSet rs = con.consultar(sql);    
        try 
        {
            while(rs.next())
            {   
                aux.add(new despesa(rs.getInt("cod_despesa"),new DALfunc().get(rs.getInt("cod_func")),new DALtipoconta().get(rs.getInt("cod_tpconta")),
                        new DALentrada().get(rs.getInt("cod_entrada")),rs.getString("nome"), rs.getString("descricao"),
                    rs.getString("status").charAt(0),rs.getDouble("valor"),rs.getDate("dt_venc").toLocalDate(),rs.getDate("dt_inicio").toLocalDate()));
            }
        } 
        catch (SQLException ex) 
        {
            
        }
        
        return aux;
    }
        public despesa get(int cod)
    {
        despesa aux = null;
        String sql="select * from despesa where cod_despesa="+cod;
        Singleton con = Singleton.getConexao();
        ResultSet rs = con.consultar(sql);    
        try 
        {
            while(rs.next())
            {   
                aux = new despesa(rs.getInt("cod_despesa"),new DALfunc().get(rs.getInt("cod_func")),new DALtipoconta().get(rs.getInt("cod_tpconta")),
                        new DALentrada().get(rs.getInt("cod_entrada")),rs.getString("nome"), rs.getString("descricao"),
                    rs.getString("status").charAt(0),rs.getDouble("valor"),rs.getDate("dt_venc").toLocalDate(),rs.getDate("dt_inicio").toLocalDate());
            }
        } 
        catch (SQLException ex) 
        {
            
        }
        
        return aux;
    }
            public boolean apagar(despesa c)
    {
        String sql = "delete from despesa where cod_despesa="+c.getCod_despesa();
        Singleton con = Singleton.getConexao();
        boolean flag = con.manipular(sql);
        return flag;
    }
}
