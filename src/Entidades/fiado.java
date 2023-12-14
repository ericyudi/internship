/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import DAL.DALClientes;
import DAL.DALEstoque;
import DAL.DALFiado;
import DAL.DALdespesa;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author eric-
 */
public class fiado {

    public int getCod_fiado() {
        return cod_fiado;
    }

    public void setCod_fiado(int cod_fiado) {
        this.cod_fiado = cod_fiado;
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

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public LocalDate getDtfiado() {
        return dtfiado;
    }

    public void setDtfiado(LocalDate dtfiado) {
        this.dtfiado = dtfiado;
    }

    public double getVrfiado() {
        return vrfiado;
    }

    public void setVrfiado(double vrfiado) {
        this.vrfiado = vrfiado;
    }

    public cliente getCli() {
        return cli;
    }

    public void setCli(cliente cli) {
        this.cli = cli;
    }

    public fiado(int cod_fiado, double valorpago, LocalDate datapag, String observacao, LocalDate dtfiado, double vrfiado, cliente cli) {
        this.cod_fiado = cod_fiado;
        this.valorpago = valorpago;
        this.datapag = datapag;
        this.observacao = observacao;
        this.dtfiado = dtfiado;
        this.vrfiado = vrfiado;
        this.cli = cli;
    }

    public fiado() {
    }
    private int cod_fiado;
    private double valorpago;
    private LocalDate datapag;
    private String observacao;
    private LocalDate dtfiado;
    private double vrfiado;
    private cliente cli;
    
        public boolean gravar() {
        DALFiado dal = new DALFiado();
        if (dal.gravar(this)) {
            return true;
        }
        return false;
    }
                    public List<fiado> get(String filtro) {
        DALFiado dal = new DALFiado();
        return dal.get(filtro);
    }
        public fiado get(int cod) {
        DALFiado dal = new DALFiado();
        return dal.get(cod);
    }
                    public boolean alteravrpago() {
        DALFiado dal = new DALFiado();
        if (dal.alteravrpago(this)) {
            return true;
        }
        return false;
    }
}
