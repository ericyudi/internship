/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DB.Singleton;
import Entidades.pagamento_despesa;
import Entidades.pagamento_despesa;
import Entidades.pagamento_despesa;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eric-
 */
public class DALpagdesp {
                        public boolean gravar(pagamento_despesa c)
    {
        String sql = "insert into pagamento_despesa(valorpago,datapag,"
                + "cod_func,cod_desp) "
                + "values (#1,'#2',#3,#4)";
        sql = sql.replaceAll("#1", ""+c.getValorpago());
        sql = sql.replaceAll("#2", ""+c.getDatapag());
        sql = sql.replaceAll("#3", ""+c.getCod_func().getCod_func());
        sql = sql.replaceAll("#4", ""+c.getCod_desp().getCod_despesa());
        Singleton con = Singleton.getConexao();
        boolean flag = con.manipular(sql);
        return flag;
    }
                        
                            public List<pagamento_despesa> get(String filtro)
    {
        String sql="select * from pagamento_despesa";
        if(!filtro.isEmpty())
            sql+=" where "+filtro+" order by cod_pag";
        List <pagamento_despesa> aux = new ArrayList();
        Singleton con = Singleton.getConexao();
        ResultSet rs = con.consultar(sql);   
        try 
        {
            while(rs.next())
            {
                aux.add(new pagamento_despesa(rs.getInt("cod_pag"),rs.getDouble("valorpago"),rs.getDate("datapag").toLocalDate()
                        ,new DALfunc().get(rs.getInt("cod_func")),new DALdespesa().get(rs.getInt("cod_desp"))));
            }
        } 
        catch (SQLException ex) 
        {
            
        }
        
        return aux;
    }
                                  public boolean apagar(pagamento_despesa c)
    {
        String sql = "delete from pagamento_despesa where cod_pag="+c.getCod_pag();
        Singleton con = Singleton.getConexao();
        boolean flag = con.manipular(sql);
        return flag;
    }
}
