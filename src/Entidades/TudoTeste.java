/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import DAL.DALCalcados;
import java.util.List;

/**
 *
 * @author eric-
 */
public class TudoTeste {
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

    public TudoTeste(int cod, double valorcompra, double valorvenda, String nome, 
            String codesp, String cores, String genero, Marca MarcaCal,
             int cod_estoque, Calcados codcal, int tam, int qntd) {
        this.cod = cod;
        this.valorcompra = valorcompra;
        this.valorvenda = valorvenda;
        this.nome = nome;
        this.codesp = codesp;
        this.cores = cores;
        this.genero = genero;
        this.MarcaCal = MarcaCal;
        this.cod_estoque = cod_estoque;
        this.codcal = codcal;
        this.tam = tam;
        this.qntd = qntd;
    }
        public TudoTeste(double valorvenda, String nome, 
            String codesp,String genero,
              int tam, int qntd) {
        this.valorvenda = valorvenda;
        this.nome = nome;
        this.codesp = codesp;
        this.genero = genero;
        this.tam = tam;
        this.qntd = qntd;
    }
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

       public TudoTeste() {

    }  
    private double valorcompra;
    private double valorvenda;

    @Override
    public String toString() {
        return nome;
    }    
    
    private String codesp;
    private int cod_estoque;

    public int getCod_estoque() {
        return cod_estoque;
    }

    public void setCod_estoque(int cod_estoque) {
        this.cod_estoque = cod_estoque;
    }
    private String nome;
    private String cores;
    private String genero;
    private Marca MarcaCal;
    
            public List<TudoTeste> get2(String filtro) {
        DALCalcados dal = new DALCalcados();
        return dal.get2(filtro);
    }
                        public List<TudoTeste> getItensVenda(int filtro) {
        DALCalcados dal = new DALCalcados();
        return dal.getItensVenda(filtro);
    }
}
