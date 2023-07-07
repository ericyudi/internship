/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import DAL.DALMarca;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author eric-
 */
public class Marca {

    public Marca(int cod, String nome) {
        this.cod = cod;
        this.nome = nome;
    }

    public Marca() {
        this(0,"");
    }
    

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
    private int cod;

    @Override
    public String toString() {
        return nome;
    }
    public boolean gravar() {
        DALMarca dal = new DALMarca();
        if (dal.gravar(this)) {
            return true;
        }
        return false;
    }
    
        public boolean alterar() {
        DALMarca dal = new DALMarca();
        if (dal.alterar(this)) {
            return true;
        }
        return false;
    }
    public List<Marca> get(String filtro) {
        DALMarca dal = new DALMarca();
        return dal.get(filtro);
    }
        public boolean apagar() {
        DALMarca dal = new DALMarca();
        return dal.apagar(this);
    }
    private String nome;
}
