/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import DAL.DALpagdesp;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author eric-
 */
public class pagamento_despesa {

    public pagamento_despesa(int cod_pag, double valorpago, LocalDate datapag, funcionario cod_func, despesa cod_desp) {
        this.cod_pag = cod_pag;
        this.valorpago = valorpago;
        this.datapag = datapag;
        this.cod_func = cod_func;
        this.cod_desp = cod_desp;
    }

    public pagamento_despesa() {
    }

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

    public despesa getCod_desp() {
        return cod_desp;
    }

    public void setCod_desp(despesa cod_desp) {
        this.cod_desp = cod_desp;
    }
    private int cod_pag;
    private double valorpago;
    private LocalDate datapag;
    private funcionario cod_func;
    private despesa cod_desp;
    
            public boolean gravar() {
        DALpagdesp dal = new DALpagdesp();
        if (dal.gravar(this)) {
            return true;
        }
        return false;
    }
                    public List<pagamento_despesa> get(String filtro) {
        DALpagdesp dal = new DALpagdesp();
        return dal.get(filtro);
    }
                            public boolean apagar() {
        DALpagdesp dal = new DALpagdesp();
        return dal.apagar(this);
    }
}
