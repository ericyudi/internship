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
import Entidades.cliente;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eric-
 */
public class DALCalcados {
            public boolean gravar(Calcados c)
    {
        String sql = "insert into calcado(nome,valorcompra,valorvenda,"
                + "codespe,cores,genero,cod_marca) "
                + "values ('#1',#3,#4,'#5','#6','#7',#9)";
        sql = sql.replaceAll("#1", ""+c.getNome());
        sql = sql.replaceAll("#3", ""+c.getValorcompra());
        sql = sql.replaceAll("#4", ""+c.getValorvenda());
        sql = sql.replaceAll("#5", ""+c.getCodesp());
        sql = sql.replaceAll("#6", ""+c.getCores());
        sql = sql.replaceAll("#7", ""+c.getGenero());
        sql = sql.replaceAll("#9", ""+c.getMarcaCal().getCod());
        Singleton con = Singleton.getConexao();
        boolean flag = con.manipular(sql);
        return flag;
    }
            
         public boolean alterar(Calcados c)
    {
        String sql = "update calcado set nome='#1',valorcompra=#3,valorvenda=#4,codespe='#5',cores='#6',genero='#7',"
                + "cod_marca='#9'"
                + " where cod="+c.getCod()+"";
        sql = sql.replaceAll("#1", ""+c.getNome());
        sql = sql.replaceAll("#3", ""+c.getValorcompra());
        sql = sql.replaceAll("#4", ""+c.getValorvenda());
        sql = sql.replaceAll("#5", ""+c.getCodesp());
        sql = sql.replaceAll("#6", ""+c.getCores());
        sql = sql.replaceAll("#7", ""+c.getGenero());
        sql = sql.replaceAll("#9", ""+c.getMarcaCal().getCod());
        Singleton con = Singleton.getConexao();
        boolean flag = con.manipular(sql);
        return flag;
    }

            
    public List<Calcados> get(String filtro)
    {
        String sql="select * from calcado";
        if(!filtro.isEmpty())
            sql+=" where "+filtro;
        List <Calcados> aux = new ArrayList();
        Singleton con = Singleton.getConexao();
        ResultSet rs = con.consultar(sql);    
        try 
        {
            while(rs.next())
            {
                aux.add(new Calcados(rs.getInt("cod"), rs.getDouble("valorcompra"),rs.getDouble("valorvenda"),
                        rs.getString("nome"), rs.getString("codespe"),
                    rs.getString("cores"),rs.getString("genero"),new DALMarca().get(rs.getInt("cod_marca"))));
            }
        } 
        catch (SQLException ex) 
        {
            
        }
        
        return aux;
    }
        public Calcados get(int cod)
    {
        Calcados aux = null;
        Singleton con = Singleton.getConexao();
        ResultSet rs = con.consultar("select * from calcado where cod="+cod);
        try 
        {
            while(rs.next())
            {
                aux = new Calcados(rs.getInt("cod"), rs.getDouble("valorcompra"),rs.getDouble("valorvenda"),
                        rs.getString("nome"), rs.getString("codespe"),
                    rs.getString("cores"),rs.getString("genero"),new DALMarca().get(rs.getInt("cod_marca")));
            }
        } 
        catch (SQLException ex) 
        {
            
        }
        
        return aux;
    }
    
    public boolean apagar(Calcados c)
    {
        String sql = "delete from calcado where cod="+c.getCod();
        Singleton con = Singleton.getConexao();
        boolean flag = con.manipular(sql);
        return flag;
    }
    public boolean apagaestoque(Calcados c)
    {
        String sql = "delete from estoque where cod_cal="+c.getCod();
        Singleton con = Singleton.getConexao();
        boolean flag = con.manipular(sql);
        return flag;
    }
    public int getultimocal() {
        int aux = 0;
        Singleton con = Singleton.getConexao();
        ResultSet rs = con.consultar("select MAX(cod) from calcado");
        try {
            if (rs.next()) {
                aux = rs.getInt("max");
            }
        } catch (SQLException ex) {

        }
        return aux;
    }
}
