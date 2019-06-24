/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author Romulo Sobreira
 */
public class Produto {
   
    private int referenciaProduto;
    private int quantidadeProduto;
    private float precoVenda;
    private float precoCusto;
    private String nomeProduto;
    private Date dataCadastro;

    public Produto(int referencia, int qtd, float precoV, float precoC, String n,Date data){
       this.referenciaProduto = referencia;
       this.quantidadeProduto = qtd;
       this.precoVenda = precoV;
       this.precoCusto = precoC;
       this.nomeProduto = n;
       this.dataCadastro = data;
    }
    public Produto(){
        this(0, 0, 0.0f, 0.0f, "", null);
    }
    
    public int getReferenciaProduto() {
        return referenciaProduto;
    }

    public void setReferenciaProduto(int referenciaProduto) {
        this.referenciaProduto = referenciaProduto;
    }

    public int getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(int quantidadeProduto) {
        this.quantidadeProduto = quantidadeProduto;
    }

    public float getPrecoVenda() {
        return precoVenda;
    }

    public void setPrecoVenda(float precoVenda) {
        this.precoVenda = precoVenda;
    }

    public float getPrecoCusto() {
        return precoCusto;
    }

    public void setPrecoCusto(float precoCusto) {
        this.precoCusto = precoCusto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public Date getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(Date dataCadastro) {
        this.dataCadastro = dataCadastro;
    }
    
    
}
