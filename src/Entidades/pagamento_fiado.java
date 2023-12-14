/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import DAL.DALFiado;
import DAL.DALdespesa;
import DAL.DALpagfiado;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author eric-
 */
public class pagamento_fiado {

    public pagamento_fiado(int cod_pag, double valorpago, LocalDate datapag, fiado cod_fiado) {
        this.cod_pag = cod_pag;
        this.valorpago = valorpago;
        this.datapag = datapag;
        this.cod_fiado = cod_fiado;
    }

    public pagamento_fiado() {
    }

    public int getCod_pag() {
        return cod_pag;
    }

    public void setCod_pag(int cod_pag) {
        this.cod_pag = cod_pag;
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

    public fiado getCod_fiado() {
        return cod_fiado;
    }

    public void setCod_fiado(fiado cod_fiado) {
        this.cod_fiado = cod_fiado;
    }
    private int cod_pag;
    private double valorpago;
    private LocalDate datapag;
    private fiado cod_fiado;
    
            public int getultimocalfiado() {
        DALFiado dal = new DALFiado();
        return dal.getultimocal();
    }
                    public boolean gravar() {
        DALpagfiado dal = new DALpagfiado();
        if (dal.gravar(this)) {
            return true;
        }
        return false;
    }
        public List<pagamento_fiado> get(String filtro) {
        DALpagfiado dal = new DALpagfiado();
        return dal.get(filtro);
    }
                public boolean apagar() {
        DALpagfiado dal = new DALpagfiado();
        return dal.apagar(this);
    }
}
