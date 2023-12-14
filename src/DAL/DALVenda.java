/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DB.Singleton;
import Entidades.funcionario;
import Entidades.venda;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eric-
 */
public class DALVenda {
                public boolean gravar(venda c)
    {
        String sql = "insert into venda(descricao,valortotal,"
                + "fiado,datavenda,comentarios,cod_cliente,quitada,dtquitacao) "
                + "values ('#1',#2,'#3','#4','#5',#6,'#7','#8')";
        sql = sql.replaceAll("#1", ""+c.getDescricao());
        sql = sql.replaceAll("#2", ""+c.getValortotal());
        sql = sql.replaceAll("#3", ""+c.getFiado());
        sql = sql.replaceAll("#4", ""+c.getDataVenda());
        sql = sql.replaceAll("#5", ""+c.getComentarios());
        sql = sql.replaceAll("#6", ""+c.getClientes().getCod());
        sql = sql.replaceAll("#7", ""+c.getQuitada());
                if (c.getDtquitacao() != null) {
            sql = sql.replaceAll("#8", "" + c.getDtquitacao());
        } else {
            sql = sql.replaceAll("'#8'", "null");
        }
        //sql = sql.replaceAll("#8", ""+c.getDtquitacao());
        Singleton con = Singleton.getConexao();
        boolean flag = con.manipular(sql);
        return flag;
    }
                         public boolean quitavenda(venda c)
    {
        String sql = "update venda set quitada='#4',dtquitacao='#3'"
                + " where cod_venda="+c.getCod_venda()+"";
        sql = sql.replaceAll("#4", ""+c.getQuitada());
        sql = sql.replaceAll("#3", ""+c.getDtquitacao());
        Singleton con = Singleton.getConexao();
        boolean flag = con.manipular(sql);
        return flag;
    }
      public List<venda> get(String filtro)
    {
        String sql="select * from venda";
        if(!filtro.isEmpty())
            sql+=" where "+filtro;
        List <venda> aux = new ArrayList();
        Singleton con = Singleton.getConexao();
        ResultSet rs = con.consultar(sql);  
        try 
        {
            while(rs.next())
            {
                if(rs.getDate("dtquitacao")!=null){
                    aux.add(new venda(rs.getInt("cod_venda"),rs.getString("descricao"), rs.getDouble("valortotal"), rs.getString("fiado").charAt(0),
                    rs.getDate("datavenda").toLocalDate(),rs.getString("comentarios"),new DALClientes().get(rs.getInt("cod_cliente")),rs.getString("quitada").charAt(0),rs.getDate("dtquitacao").toLocalDate()));
                }
                else
                {
                    aux.add(new venda(rs.getInt("cod_venda"),rs.getString("descricao"), rs.getDouble("valortotal"), rs.getString("fiado").charAt(0),
                    rs.getDate("datavenda").toLocalDate(),rs.getString("comentarios"),new DALClientes().get(rs.getInt("cod_cliente")),rs.getString("quitada").charAt(0),null));
                }
                
            }
        } 
        catch (SQLException ex) 
        {
            
        }
        
        return aux;
    }
                  public venda get(int cod)
    {
        venda aux = null;
        Singleton con = Singleton.getConexao();
        ResultSet rs = con.consultar("select * from venda where cod_venda="+cod);
        try 
        {
            while(rs.next())
            {
                if(rs.getDate("dtquitacao")!=null){
                    aux = new venda(rs.getInt("cod_venda"),rs.getString("descricao"), rs.getDouble("valortotal"), rs.getString("fiado").charAt(0),
                    rs.getDate("datavenda").toLocalDate(),rs.getString("comentarios"),new DALClientes().get(rs.getInt("cod_cliente")),rs.getString("quitada").charAt(0),rs.getDate("dtquitacao").toLocalDate());
                }
                else
                {
                    aux = new venda(rs.getInt("cod_venda"),rs.getString("descricao"), rs.getDouble("valortotal"), rs.getString("fiado").charAt(0),
                    rs.getDate("datavenda").toLocalDate(),rs.getString("comentarios"),new DALClientes().get(rs.getInt("cod_cliente")),rs.getString("quitada").charAt(0),null);
                }
            }
        } 
        catch (SQLException ex) 
        {
            
        }
        
        return aux;
    }
          public int getultimocal() {
        int aux = 0;
        Singleton con = Singleton.getConexao();
        ResultSet rs = con.consultar("select MAX(cod_venda) from venda");
        try {
            if (rs.next()) {
                aux = rs.getInt("max");
            }
        } catch (SQLException ex) {

        }
        return aux;
    }
}
