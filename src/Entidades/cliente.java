/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import DAL.DALClientes;
import DAL.DALEstoque;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author eric-
 */
public class cliente {

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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getLim_fiado() {
        return lim_fiado;
    }

    public void setLim_fiado(double lim_fiado) {
        this.lim_fiado = lim_fiado;
    }

    public char getFiado() {
        return fiado;
    }

    public void setFiado(char fiado) {
        this.fiado = fiado;
    }

    public cliente(int cod, String nome, String cpf, String telefone, String email, String rg,
            String uf, String cidade, String cep, String bairro, String endereco, int numero, double lim_fiado, char fiado,double saldofiado ,LocalDate databloqueio) {
        this.cod = cod;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.rg = rg;
        this.uf = uf;
        this.cidade = cidade;
        this.cep = cep;
        this.bairro = bairro;
        this.endereco = endereco;
        this.numero = numero;
        this.lim_fiado = lim_fiado;
        this.fiado = fiado;
        this.saldofiado = saldofiado;
        this.databloqueio = databloqueio;
    }
        public cliente() {

    }
    public int cod;
    public String nome;
    public String cpf;
    public String telefone;
    public String email;
    public String rg;
    public String uf;
    public String cidade;
    public String cep;
    public String bairro;
    public String endereco;
    public int numero;
    public double lim_fiado;
    public char fiado;

    public double getSaldofiado() {
        return saldofiado;
    }

    public void setSaldofiado(double saldofiado) {
        this.saldofiado = saldofiado;
    }

    private double saldofiado;

    public LocalDate getDatabloqueio() {
        return databloqueio;
    }

    public void setDatabloqueio(LocalDate databloqueio) {
        this.databloqueio = databloqueio;
    }
    private LocalDate databloqueio;
    
            public boolean gravar() {
        DALClientes dal = new DALClientes();
        if (dal.gravar(this)) {
            return true;
        }
        return false;
    }

    public boolean alterar() {
        DALClientes dal = new DALClientes();
        if (dal.alterar(this)) {
            return true;
        }
        return false;
    }
        public List<cliente> get(String filtro) {
        DALClientes dal = new DALClientes();
        return dal.get(filtro);
    }
        public double buscasaldo() {
        DALClientes dal = new DALClientes();
        return dal.buscasaldo(cod);
    }
        public boolean apagar() {
        DALClientes dal = new DALClientes();
        return dal.apagar(this);
    }
}
