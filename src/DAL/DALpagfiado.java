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
import Entidades.pagamento_fiado;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eric-
 */
public class DALpagfiado {
                        public boolean gravar(pagamento_fiado c)
    {
        String sql = "insert into pagamento_fiado(valorpago,datapag,"
                + "cod_fiado) "
                + "values (#1,'#2',#3)";
        sql = sql.replaceAll("#1", ""+c.getValorpago());
        sql = sql.replaceAll("#2", ""+c.getDatapag());
        sql = sql.replaceAll("#3", ""+c.getCod_fiado().getCod_fiado());
        Singleton con = Singleton.getConexao();
        boolean flag = con.manipular(sql);
        return flag;
    }
     
    public List<pagamento_fiado> get(String filtro)
    {
        String sql="select * from pagamento_fiado";
        if(!filtro.isEmpty())
            sql+=" where "+filtro+" order by cod_pag";
        List <pagamento_fiado> aux = new ArrayList();
        Singleton con = Singleton.getConexao();
        ResultSet rs = con.consultar(sql);   
        try 
        {
            while(rs.next())
            {
                aux.add(new pagamento_fiado(rs.getInt("cod_pag"),rs.getDouble("valorpago"),rs.getDate("datapag").toLocalDate(),new fiado().get(rs.getInt("cod_fiado"))));
            }
        } 
        catch (SQLException ex) 
        {
            
        }
        
        return aux;
    }
    public boolean apagar(pagamento_fiado c)
    {
        String sql = "delete from pagamento_fiado where cod_pag="+c.getCod_pag();
        Singleton con = Singleton.getConexao();
        boolean flag = con.manipular(sql);
        return flag;
    }
}
