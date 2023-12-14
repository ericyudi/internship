/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import DAL.DALCalcados;
import DAL.DALVenda;
import DAL.DALdespesa;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author eric-
 */
public class despesa {

    public int getCod_despesa() {
        return cod_despesa;
    }

    public void setCod_despesa(int cod_despesa) {
        this.cod_despesa = cod_despesa;
    }

    public funcionario getFunc() {
        return func;
    }

    public void setFunc(funcionario func) {
        this.func = func;
    }

    public tipoconta getTp_conta() {
        return tp_conta;
    }

    public void setTp_conta(tipoconta tp_conta) {
        this.tp_conta = tp_conta;
    }

    public entrada getEntr() {
        return entr;
    }

    public void setEntr(entrada entr) {
        this.entr = entr;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public char getStatus() {
        return status;
    }

    public void setStatus(char status) {
        this.status = status;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getDt_venc() {
        return dt_venc;
    }

    public void setDt_venc(LocalDate dt_venc) {
        this.dt_venc = dt_venc;
    }

    public LocalDate getDt_inicio() {
        return dt_inicio;
    }

    public void setDt_inicio(LocalDate dt_inicio) {
        this.dt_inicio = dt_inicio;
    }

    public despesa(int cod_despesa, funcionario func, tipoconta tp_conta, entrada entr, String nome, String descricao, char status, double valor, LocalDate dt_venc, LocalDate dt_inicio) {
        this.cod_despesa = cod_despesa;
        this.func = func;
        this.tp_conta = tp_conta;
        this.entr = entr;
        this.nome = nome;
        this.descricao = descricao;
        this.status = status;
        this.valor = valor;
        this.dt_venc = dt_venc;
        this.dt_inicio = dt_inicio;
    }
    public despesa() {

    }
    private int cod_despesa;
    private funcionario func;
    private tipoconta tp_conta;
    private entrada entr;
    private String nome;
    private String descricao;
    private char status;
    private double valor;
    private LocalDate dt_venc;
    private LocalDate dt_inicio;
    
            public List<despesa> get(String filtro) {
        DALdespesa dal = new DALdespesa();
        return dal.get(filtro);
    }
                               public despesa get(int cod) {
        DALdespesa dal = new DALdespesa();
        return dal.get(cod);
    }
        public boolean gravar() {
        DALdespesa dal = new DALdespesa();
        if (dal.gravar(this)) {
            return true;
        }
        return false;
    }
            public boolean alterageral() {
        DALdespesa dal = new DALdespesa();
        if (dal.alterageral(this)) {
            return true;
        }
        return false;
    }
            public boolean alterastatus() {
        DALdespesa dal = new DALdespesa();
        if (dal.alterastatus(this)) {
            return true;
        }
        return false;
    }
        public boolean apagar() {
        DALdespesa dal = new DALdespesa();
        return dal.apagar(this);
    }
}
