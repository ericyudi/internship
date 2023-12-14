/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DB.Singleton;
import Entidades.TudoTeste;
import Entidades.itens_venda;
import Entidades.pagamento_venda;

/**
 *
 * @author eric-
 */
public class DALitens_venda {
                        public boolean gravar(itens_venda c)
    {
        String sql = "insert into itens_venda(cod_venda,cod_estoque,"
                + "qntd,vr_unit) "
                + "values (#1,'#2',#3,#4)";
        sql = sql.replaceAll("#1", ""+c.getCod_venda().getCod_venda());
        sql = sql.replaceAll("#2", ""+c.getCod_estoque().getCod());
        sql = sql.replaceAll("#3", ""+c.getQntd());
        sql = sql.replaceAll("#4", ""+c.getVr_unit());
        Singleton con = Singleton.getConexao();
        boolean flag = con.manipular(sql);
        return flag;
    }
}
