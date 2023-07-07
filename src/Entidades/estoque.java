/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import DAL.DALCalcados;
import DAL.DALEstoque;
import java.util.List;

/**
 *
 * @author eric-
 */
public class estoque {
    private int cod;
    private int tam;
    private int qntd;
    private Calcados codcal;
    public Calcados getCodcal() {
        return codcal;
    }

    public void setCodcal(Calcados codcal) {
        this.codcal = codcal;
    }




    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public int getTam() {
        return tam;
    }

    public void setTam(int tam) {
        this.tam = tam;
    }

    public int getQntd() {
        return qntd;
    }

    public void setQntd(int qntd) {
        this.qntd = qntd;
    }


        public estoque() {

    }
            public estoque(int cod, Calcados codcal, int tam, int qntd) {
        this.cod = cod;
        this.codcal = codcal;
        this.tam = tam;
        this.qntd = qntd;
    }
        
        public boolean gravar() {
        DALEstoque dal = new DALEstoque();
        if (dal.gravar(this)) {
            return true;
        }
        return false;
    }

    public boolean alterar() {
        DALEstoque dal = new DALEstoque();
        if (dal.alterar(this)) {
            return true;
        }
        return false;
    }
            public List<estoque> get(String filtro) {
        DALEstoque dal = new DALEstoque();
        return dal.get(filtro);
    }
        public boolean apagar() {
        DALEstoque dal = new DALEstoque();
        return dal.apagar(this);
    }
            public boolean checkifexists(int codcal,int tam) {
        DALEstoque dal = new DALEstoque();
        if (dal.checkIfExists(codcal,tam)) {
            return true;
        }
        return false;
    }
        public boolean checkifexistsalterar(int codcal,int codest,int tam) {
        DALEstoque dal = new DALEstoque();
        if (dal.checkIfExistsAlterar(codcal,codest,tam)) {
            return true;
        }
        return false;
    }
}
