/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DB.Singleton;
import Entidades.itens_entrada;

/**
 *
 * @author eric-
 */
public class DALitens_entrada {
                    public boolean gravar(itens_entrada e)
    {
        String sql = "insert into itens_entrada(cod_entrada,cod_estoque,qntd,vr_unit) "
                + "values (#1,#2,#3,#4)";
        sql = sql.replaceAll("#1", ""+e.getEntre().getCod_entrada());
        sql = sql.replaceAll("#2", ""+e.getEstoq().getCod());
        sql = sql.replaceAll("#3", ""+e.getQntd());
        sql = sql.replaceAll("#4", ""+e.getVr_unit());
        Singleton con = Singleton.getConexao();
        boolean flag = con.manipular(sql);
        return flag;
    }
}
