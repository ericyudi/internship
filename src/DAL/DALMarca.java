
package DAL;

import DB.Banco;
import DB.Singleton;
import Entidades.Marca;
import Entidades.cliente;
import Entidades.tipoconta;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eric-
 */
public class DALMarca {
            public boolean gravar(Marca m)
    {
        String sql = "insert into marca(nome) "
                + "values ('#1')";
        sql = sql.replaceAll("#1", ""+m.getNome());
        Singleton con = Singleton.getConexao();
        boolean flag = con.manipular(sql);
        return flag;
    }
        
     public boolean alterar(Marca m)
    {
        String sql = "update marca set nome='#1'"
                + " where cod="+m.getCod();
        sql = sql.replaceAll("#1", ""+m.getNome());
        Singleton con = Singleton.getConexao();
        boolean flag = con.manipular(sql);
        return flag;
    }
        
       public List<Marca> get(String filtro)
    {
        String sql="select * from marca";
        if(!filtro.isEmpty())
            sql+=" where "+filtro;
        List <Marca> aux = new ArrayList();
        Singleton con = Singleton.getConexao();
        ResultSet rs = con.consultar(sql);
        
        try 
        {
            while(rs.next())
            {
                aux.add(new Marca(rs.getInt("cod"),rs.getString("nome")));
            }
        } 
        catch (SQLException ex) 
        {
            
        }
        
        return aux;
    }
       
     public Marca get(int cod)
    {
        Marca aux = null;
        Singleton con = Singleton.getConexao();
        ResultSet rs = con.consultar("select * from marca where cod="+cod);
        try 
        {
            if(rs.next())
            {
                aux = new Marca(rs.getInt("cod"),rs.getString("nome"));
            }
        } 
        catch (SQLException ex) 
        {
            
        }
        return aux;
    }   
        public boolean apagar(Marca m)
    {
        String sql = "delete from marca where cod="+m.getCod();
        Singleton con = Singleton.getConexao();
        boolean flag = con.manipular(sql);
        return flag;
    }
}
