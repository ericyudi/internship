/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DB.Singleton;
import Entidades.cliente;
import Entidades.estoque;
import Entidades.fiado;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eric-
 */
public class DALFiado {
                    public boolean gravar(fiado c)
    {
        String sql = "insert into fiado(valorpago,datapag,"
                + "observacao,dtfiado,vrfiado,cod_cliente) "
                + "values (#1,'#2','#3','#4',#5,#6)";
        sql = sql.replaceAll("#1", ""+c.getValorpago());
        sql = sql.replaceAll("#2", ""+c.getDatapag());
        sql = sql.replaceAll("#3", ""+c.getObservacao());
        sql = sql.replaceAll("#4", ""+c.getDtfiado());
        sql = sql.replaceAll("#5", ""+c.getVrfiado());
        sql = sql.replaceAll("#6", ""+c.getCli().getCod());
        Singleton con = Singleton.getConexao();
        boolean flag = con.manipular(sql);
        return flag;
    }
                    public boolean alteravrpago(fiado c)
    {
        String sql = "update fiado set valorpago=#1 where cod_fiado="+c.getCod_fiado();
        sql = sql.replaceAll("#1", ""+c.getValorpago());

        Singleton con = Singleton.getConexao();
        boolean flag = con.manipular(sql);
        return flag;
    }
                               public List<fiado> get(String filtro)
    {
        String sql="select * from fiado";
        if(!filtro.isEmpty())
            sql+=" where "+filtro+" order by cod_fiado";
        List <fiado> aux = new ArrayList();
        Singleton con = Singleton.getConexao();
        ResultSet rs = con.consultar(sql);   
        try 
        {
            while(rs.next())
            {
                aux.add(new fiado(rs.getInt("cod_fiado"),rs.getDouble("valorpago"),rs.getDate("datapag").toLocalDate(),rs.getString("observacao"),
                rs.getDate("dtfiado").toLocalDate(),rs.getDouble("vrfiado"),new cliente().get(rs.getInt("cod_cliente"))));
            }
        } 
        catch (SQLException ex) 
        {
            
        }
        
        return aux;
    }
    public fiado get(int cod)
    {
        String sql="select * from fiado where cod_fiado="+cod;

        fiado aux = null;
        Singleton con = Singleton.getConexao();
        ResultSet rs = con.consultar(sql);   
        try 
        {
            while(rs.next())
            {
                aux=new fiado(rs.getInt("cod_fiado"),rs.getDouble("valorpago"),rs.getDate("datapag").toLocalDate(),rs.getString("observacao"),
                rs.getDate("dtfiado").toLocalDate(),rs.getDouble("vrfiado"),new cliente().get(rs.getInt("cod_cliente")));
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
        ResultSet rs = con.consultar("select MAX(cod_fiado) from fiado");
        try {
            if (rs.next()) {
                aux = rs.getInt("max");
            }
        } catch (SQLException ex) {

        }
        return aux;
    }                
                    
}
