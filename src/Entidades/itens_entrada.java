/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import DAL.DALEstoque;
import DAL.DALitens_entrada;

/**
 *
 * @author eric-
 */
public class itens_entrada {

    public entrada getEntre() {
        return entre;
    }

    public void setEntre(entrada entre) {
        this.entre = entre;
    }

    public estoque getEstoq() {
        return estoq;
    }

    public void setEstoq(estoque estoq) {
        this.estoq = estoq;
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

    public itens_entrada(entrada entre, estoque estoq, int qntd, double vr_unit) {
        this.entre = entre;
        this.estoq = estoq;
        this.qntd = qntd;
        this.vr_unit = vr_unit;
    }

    public itens_entrada() {
    }
    private entrada entre;
    private estoque estoq;
    private int qntd;
    private double vr_unit;
    
            public boolean gravar() {
        DALitens_entrada dal = new DALitens_entrada();
        if (dal.gravar(this)) {
            return true;
        }
        return false;
    }
}
