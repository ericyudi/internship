/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import DAL.DALCalcados;
import DAL.DALEstoque;
import DAL.DALVenda;
import DAL.DALpagvenda;
import DB.Singleton;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author eric-
 */
public class pagamento_venda {

    public int getCod_pag() {
        return cod_pag;
    }

    public void setCod_pag(int cod_pag) {
        this.cod_pag = cod_pag;
    }

    public double getValorpago() {
        return valorpago;
    }

    public void setValorpago(double valorpago) {
        this.valorpago = valorpago;
    }

    public LocalDate getDatapag() {
        return datapag;
    }

    public void setDatapag(LocalDate datapag) {
        this.datapag = datapag;
    }

    public funcionario getCod_func() {
        return cod_func;
    }

    public void setCod_func(funcionario cod_func) {
        this.cod_func = cod_func;
    }

    public venda getCod_venda() {
        return cod_venda;
    }

    public void setCod_venda(venda cod_venda) {
        this.cod_venda = cod_venda;
    }

    public pagamento_venda(int cod_pag, double valorpago, LocalDate datapag, funcionario cod_func, venda cod_venda) {
        this.cod_pag = cod_pag;
        this.valorpago = valorpago;
        this.datapag = datapag;
        this.cod_func = cod_func;
        this.cod_venda = cod_venda;
    }

    public pagamento_venda() {
    }
    private int cod_pag;
    private double valorpago;
    private LocalDate datapag;
    private funcionario cod_func;
    private venda cod_venda;
    
        public boolean gravar() {
        DALpagvenda dal = new DALpagvenda();
        if (dal.gravar(this)) {
            return true;
        }
        return false;
    }
                    public List<pagamento_venda> get(String filtro) {
        DALpagvenda dal = new DALpagvenda();
        return dal.get(filtro);
    }
                            public boolean apagar() {
        DALpagvenda dal = new DALpagvenda();
        return dal.apagar(this);
    }
                              
}
