/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DB.Singleton;
import Entidades.Calcados;
import Entidades.despesa;
import Entidades.entrada;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eric-
 */
public class DALentrada {
                public boolean gravar(entrada c)
    {
        String sql = "insert into entrada(fornecedor,dt_compra,metodo_pag,"
                + "nr_nf,qntd_parc) "
                + "values ('#1','#3','#4','#5',#6)";
        sql = sql.replaceAll("#1", ""+c.getFornecedor());
        sql = sql.replaceAll("#3", ""+c.getData_compra());
        sql = sql.replaceAll("#4", ""+c.getMetodo_pag());
        sql = sql.replaceAll("#5", ""+c.getNr_nf());
        sql = sql.replaceAll("#6", ""+c.getQntd_parc());
        Singleton con = Singleton.getConexao();
        boolean flag = con.manipular(sql);
        return flag;
    }
                
    
            public entrada get(int cod)
    {
        entrada aux = null;
        Singleton con = Singleton.getConexao();
        ResultSet rs = con.consultar("select * from entrada where cod_entrada="+cod);
        try 
        {
            while(rs.next())
            {
                aux = new entrada(rs.getInt("cod_entrada"), rs.getString("fornecedor"),rs.getDate("dt_compra").toLocalDate(),
                        rs.getString("metodo_pag"), rs.getString("nr_nf"),
                    rs.getInt("qntd_parc"));
            }
        } 
        catch (SQLException ex) 
        {
            
        }
        
        return aux;
    }
                    public List<entrada> get(String filtro)
    {
        String sql="select * from entrada";
        if(!filtro.isEmpty())
            sql+=" where "+filtro;
        List <entrada> aux = new ArrayList();
        Singleton con = Singleton.getConexao();
        ResultSet rs = con.consultar(sql);    
        try 
        {
            while(rs.next())
            {   
                aux.add(new entrada(rs.getInt("cod_entrada"), rs.getString("fornecedor"),rs.getDate("dt_compra").toLocalDate(),
                        rs.getString("metodo_pag"), rs.getString("nr_nf"),
                    rs.getInt("qntd_parc")));
            }
        } 
        catch (SQLException ex) 
        {
            
        }
        
        return aux;
    }
                public boolean apagar(entrada c)
    {
        String sql = "delete from entrada where cod_entrada="+c.getCod_entrada();
        Singleton con = Singleton.getConexao();
        boolean flag = con.manipular(sql);
        return flag;
    }
                public int getultimocal() {
        int aux = 0;
        Singleton con = Singleton.getConexao();
        ResultSet rs = con.consultar("select MAX(cod_entrada) from entrada");
        try {
            if (rs.next()) {
                aux = rs.getInt("max");
            }
        } catch (SQLException ex) {

        }
        return aux;
    }
}
