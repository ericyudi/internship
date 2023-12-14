/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import DAL.DALfunc;
import DAL.DALtipoconta;
import java.util.List;

/**
 *
 * @author eric-
 */
public class tipoconta {

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public tipoconta(int cod, String nome) {
        this.cod = cod;
        this.nome = nome;
    }
        public tipoconta() {

    }
    private int cod;

    @Override
    public String toString() {
        return nome;
    }
    private String nome;
    
        public boolean gravar() {
        DALtipoconta dal = new DALtipoconta();
        if (dal.gravar(this)) {
            return true;
        }
        return false;
    }

    public boolean alterar() {
        DALtipoconta dal = new DALtipoconta();
        if (dal.alterar(this)) {
            return true;
        }
        return false;
    }
    
        public List<tipoconta> get(String filtro) {
        DALtipoconta dal = new DALtipoconta();
        return dal.get(filtro);
    }
        public tipoconta get() {
        DALtipoconta dal = new DALtipoconta();
        return dal.get(cod);
    }
        public tipoconta gettp(String nome) {
        DALtipoconta dal = new DALtipoconta();
        return dal.gettp(nome);
    }
        public boolean apagar() {
        DALtipoconta dal = new DALtipoconta();
        return dal.apagar(this);
    }
}
