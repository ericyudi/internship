/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import DAL.DALCalcados;
import DAL.DALMarca;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author eric-
 */
public class Calcados {

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }
    public double getValorcompra() {
        return valorcompra;
    }

    public void setValorcompra(double valorcompra) {
        this.valorcompra = valorcompra;
    }

    public double getValorvenda() {
        return valorvenda;
    }

    public void setValorvenda(double valorvenda) {
        this.valorvenda = valorvenda;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodesp() {
        return codesp;
    }

    public void setCodesp(String codesp) {
        this.codesp = codesp;
    }

    public String getCores() {
        return cores;
    }

    public void setCores(String cores) {
        this.cores = cores;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }


    public Marca getMarcaCal() {
        return MarcaCal;
    }

    public void setMarcaCal(Marca MarcaCal) {
        this.MarcaCal = MarcaCal;
    }

    public Calcados(int cod, double valorcompra, double valorvenda, String nome, String codesp, String cores, String genero, Marca MarcaCal) {
        this.cod = cod;
        this.valorcompra = valorcompra;
        this.valorvenda = valorvenda;
        this.nome = nome;
        this.codesp = codesp;
        this.cores = cores;
        this.genero = genero;
        this.MarcaCal = MarcaCal;
    }
       public Calcados() {

    }
    private int cod;    
    private double valorcompra;
    private double valorvenda;

    @Override
    public String toString() {
        return nome;
    }
    private String nome;
    private String codesp;
    private String cores;
    private String genero;
    private Marca MarcaCal;

    public boolean gravar() {
        DALCalcados dal = new DALCalcados();
        if (dal.gravar(this)) {
            return true;
        }
        return false;
    }

    public boolean alterar() {
        DALCalcados dal = new DALCalcados();
        if (dal.alterar(this)) {
            return true;
        }
        return false;
    }
        public List<Calcados> get(String filtro) {
        DALCalcados dal = new DALCalcados();
        return dal.get(filtro);
    }
        public boolean apagar() {
        DALCalcados dal = new DALCalcados();
        return dal.apagar(this);
    }
        public boolean apagaestoque() {
        DALCalcados dal = new DALCalcados();
        return dal.apagaestoque(this);
    }
        public int getultimocal() {
        DALCalcados dal = new DALCalcados();
        return dal.getultimocal();
    }
}
