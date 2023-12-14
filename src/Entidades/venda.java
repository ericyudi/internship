/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import DAL.DALCalcados;
import DAL.DALClientes;
import DAL.DALVenda;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author eric-
 */
public class venda {

    public int getCod_venda() {
        return cod_venda;
    }

    public void setCod_venda(int cod_venda) {
        this.cod_venda = cod_venda;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValortotal() {
        return valortotal;
    }

    public void setValortotal(Double valortotal) {
        this.valortotal = valortotal;
    }

    public char getFiado() {
        return fiado;
    }

    public void setFiado(char fiado) {
        this.fiado = fiado;
    }

    public LocalDate getDataVenda() {
        return DataVenda;
    }

    public void setDataVenda(LocalDate DataVenda) {
        this.DataVenda = DataVenda;
    }

    public String getComentarios() {
        return comentarios;
    }

    public void setComentarios(String comentarios) {
        this.comentarios = comentarios;
    }

    public cliente getClientes() {
        return clientes;
    }

    public void setClientes(cliente clientes) {
        this.clientes = clientes;
    }

    private int cod_venda;
    private String descricao;
    private Double valortotal;
    private char fiado;
    private LocalDate DataVenda;
    private String comentarios;
    private cliente clientes;

    public char getQuitada() {
        return quitada;
    }

    public void setQuitada(char quitada) {
        this.quitada = quitada;
    }

    public LocalDate getDtquitacao() {
        return dtquitacao;
    }

    public void setDtquitacao(LocalDate dtquitacao) {
        this.dtquitacao = dtquitacao;
    }

    public venda() {
    }

    public venda(int cod_venda, String descricao, Double valortotal, char fiado, LocalDate DataVenda, String comentarios, cliente clientes, char quitada, LocalDate dtquitacao) {
        this.cod_venda = cod_venda;
        this.descricao = descricao;
        this.valortotal = valortotal;
        this.fiado = fiado;
        this.DataVenda = DataVenda;
        this.comentarios = comentarios;
        this.clientes = clientes;
        this.quitada = quitada;
        this.dtquitacao = dtquitacao;
    }
    private char quitada;
    private LocalDate dtquitacao;
    
            public List<venda> get(String filtro) {
        DALVenda dal = new DALVenda();
        return dal.get(filtro);
    }
                   public venda get(int cod) {
        DALVenda dal = new DALVenda();
        return dal.get(cod);
    }
    public boolean gravar() {
        DALVenda dal = new DALVenda();
        if (dal.gravar(this)) {
            return true;
        }
        return false;
    }
            public int getultimocal() {
        DALVenda dal = new DALVenda();
        return dal.getultimocal();
    }
            
    public boolean quitavenda() {
        DALVenda dal = new DALVenda();
        if (dal.quitavenda(this)) {
            return true;
        }
        return false;
    }
}
