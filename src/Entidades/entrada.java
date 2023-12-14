/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import DAL.DALdespesa;
import DAL.DALentrada;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author eric-
 */
public class entrada {

    public int getCod_entrada() {
        return cod_entrada;
    }

    public void setCod_entrada(int cod_entrada) {
        this.cod_entrada = cod_entrada;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public LocalDate getData_compra() {
        return data_compra;
    }

    public void setData_compra(LocalDate data_compra) {
        this.data_compra = data_compra;
    }

    public String getMetodo_pag() {
        return metodo_pag;
    }

    public void setMetodo_pag(String metodo_pag) {
        this.metodo_pag = metodo_pag;
    }

    public String getNr_nf() {
        return nr_nf;
    }

    public void setNr_nf(String nr_nf) {
        this.nr_nf = nr_nf;
    }

    public int getQntd_parc() {
        return qntd_parc;
    }

    public void setQntd_parc(int qntd_parc) {
        this.qntd_parc = qntd_parc;
    }

    public entrada(int cod_entrada, String fornecedor, LocalDate data_compra, String metodo_pag, String nr_nf, int qntd_parc) {
        this.cod_entrada = cod_entrada;
        this.fornecedor = fornecedor;
        this.data_compra = data_compra;
        this.metodo_pag = metodo_pag;
        this.nr_nf = nr_nf;
        this.qntd_parc = qntd_parc;
    }
        public entrada() {

    }
    public entrada(int cod_entrada) {
        this.cod_entrada = cod_entrada;
    }

    @Override
    public String toString() {
        return ""+cod_entrada+"";
    }
    private int cod_entrada;
    private String fornecedor;
    private LocalDate data_compra;
    private String metodo_pag;
    private String nr_nf;
    private int qntd_parc;
    
        public boolean gravar() {
        DALentrada dal = new DALentrada();
        if (dal.gravar(this)) {
            return true;
        }
        return false;
    }
        public int getultimocal() {
        DALentrada dal = new DALentrada();
        return dal.getultimocal();
    }
        public boolean apagar() {
        DALentrada dal = new DALentrada();
        return dal.apagar(this);
    }
        public entrada get(int cod) {
        DALentrada dal = new DALentrada();
        return dal.get(cod);
    }
                    public List<entrada> get(String filtro) {
        DALentrada dal = new DALentrada();
        return dal.get(filtro);
    }
}
