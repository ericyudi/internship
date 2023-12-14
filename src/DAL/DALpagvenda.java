/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DB.Singleton;
import Entidades.pagamento_venda;
import Entidades.venda;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DALpagvenda {
                    public boolean gravar(pagamento_venda c)
    {
        String sql = "insert into pagamento_venda(valorpago,datapag,"
                + "cod_func,cod_venda) "
                + "values (#1,'#2',#3,#4)";
        sql = sql.replaceAll("#1", ""+c.getValorpago());
        sql = sql.replaceAll("#2", ""+c.getDatapag());
        sql = sql.replaceAll("#3", ""+c.getCod_func().getCod_func());
        sql = sql.replaceAll("#4", ""+c.getCod_venda().getCod_venda());
        Singleton con = Singleton.getConexao();
        boolean flag = con.manipular(sql);
        return flag;
    }
                    
    public List<pagamento_venda> get(String filtro)
    {
        String sql="select * from pagamento_venda";
        if(!filtro.isEmpty())
            sql+=" where "+filtro+" order by cod_pag";
        List <pagamento_venda> aux = new ArrayList();
        Singleton con = Singleton.getConexao();
        ResultSet rs = con.consultar(sql);   
        try 
        {
            while(rs.next())
            {
                aux.add(new pagamento_venda(rs.getInt("cod_pag"),rs.getDouble("valorpago"),rs.getDate("datapag").toLocalDate()
                        ,new DALfunc().get(rs.getInt("cod_func")),new DALVenda().get(rs.getInt("cod_venda"))));
            }
        } 
        catch (SQLException ex) 
        {
            
        }
        
        return aux;
    }
      public boolean apagar(pagamento_venda c)
    {
        String sql = "delete from pagamento_venda where cod_pag="+c.getCod_pag();
        Singleton con = Singleton.getConexao();
        boolean flag = con.manipular(sql);
        return flag;
    }
}
