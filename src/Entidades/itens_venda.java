/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import DAL.DALitens_venda;

/**
 *
 * @author eric-
 */
public class itens_venda {

    public venda getCod_venda() {
        return cod_venda;
    }

    public void setCod_venda(venda cod_venda) {
        this.cod_venda = cod_venda;
    }

    public estoque getCod_estoque() {
        return cod_estoque;
    }

    public void setCod_estoque(estoque cod_estoque) {
        this.cod_estoque = cod_estoque;
    }

    public int getQntd() {
        return qntd;
    }

    public void setQntd(int qntd) {
        this.qntd = qntd;
    }

    public double getVr_unit() {
        return vr_unit;
    }

    public void setVr_unit(double vr_unit) {
        this.vr_unit = vr_unit;
    }

    public itens_venda(venda cod_venda, estoque cod_estoque, int qntd, double vr_unit) {
        this.cod_venda = cod_venda;
        this.cod_estoque = cod_estoque;
        this.qntd = qntd;
        this.vr_unit = vr_unit;
    }
    private venda cod_venda;
    private estoque cod_estoque;
    private int qntd;
    private double vr_unit;
        public boolean gravar() {
        DALitens_venda dal = new DALitens_venda();
        if (dal.gravar(this)) {
            return true;
        }
        return false;
    }
}
