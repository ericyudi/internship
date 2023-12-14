/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import DAL.DALClientes;
import DAL.DALfunc;
import java.time.LocalDate;
import java.util.List;

/**
 *
 * @author eric-
 */
public class funcionario {
    private int cod_func;

    @Override
    public String toString() {
        return nome;
    }
    private String nome;
    private String estadocivil;
    private String cpf;
    private String rg;
    private String uf;
    private String cidade;
    private String bairro;
    private String endereco;
    private int numero;
    private String telefone;
    private String permissao;
    private char ativo;
    private String senha;
    private String login;
    private LocalDate data_desat;
    private String cep;
    private String email;
    public funcionario(int cod_func, String nome, String estadocivil, String cpf, String rg, String uf, String cidade, String bairro, String endereco, int numero, 
            String telefone, String permissao,char ativo, String senha, String login, LocalDate data_desat, String cep, String email) {
        this.cod_func = cod_func;
        this.nome = nome;
        this.estadocivil = estadocivil;
        this.cpf = cpf;
        this.rg = rg;
        this.uf = uf;
        this.cidade = cidade;
        this.bairro = bairro;
        this.endereco = endereco;
        this.numero = numero;
        this.telefone = telefone;
        this.permissao = permissao;        
        this.ativo = ativo;
        this.senha = senha;
        this.login = login;
        this.data_desat = data_desat;
        this.cep = cep;
        this.email = email;

    }
    public int getCod_func() {
        return cod_func;
    }

    public void setCod_func(int cod_func) {
        this.cod_func = cod_func;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEstadocivil() {
        return estadocivil;
    }

    public void setEstadocivil(String estadocivil) {
        this.estadocivil = estadocivil;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getPermissao() {
        return permissao;
    }

    public void setPermissao(String permissao) {
        this.permissao = permissao;
    }
    
        public funcionario() {
            
    }


    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public LocalDate getData_desat() {
        return data_desat;
    }

    public void setData_desat(LocalDate data_desat) {
        this.data_desat = data_desat;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public char getAtivo() {
        return ativo;
    }

    public void setAtivo(char ativo) {
        this.ativo = ativo;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    
        public boolean gravar() {
        DALfunc dal = new DALfunc();
        if (dal.gravar(this)) {
            return true;
        }
        return false;
    }

    public boolean alterar() {
        DALfunc dal = new DALfunc();
        if (dal.alterar(this)) {
            return true;
        }
        return false;
    }
    
        public List<funcionario> get(String filtro) {
        DALfunc dal = new DALfunc();
        return dal.get(filtro);
    }
        public String buscasenha() {
        DALfunc dal = new DALfunc();
        return dal.buscasenha(cod_func);
    }
        public String buscalogin() {
        DALfunc dal = new DALfunc();
        return dal.buscalogin(cod_func);
    }
        public boolean apagar() {
        DALfunc dal = new DALfunc();
        return dal.apagar(this);
    }
}
