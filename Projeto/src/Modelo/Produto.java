/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *Classe responsavel por criar um produto
 * @author Romulo Sobreira
 */
public class Produto {

   
    private int cod;
    private long referenciaProduto;
    private long quantidadeProduto;
    private float precoVenda;
    private float precoCusto;
    private String nomeProduto;
    private Date dataCadastro;
    private String observacao;
    private String foto;

    public Produto(int referencia, int qtd, float precoV, float precoC, String n,Date data, String ft){
       this.referenciaProduto = referencia;
       this.quantidadeProduto = qtd;
       this.precoVenda = precoV;
       this.precoCusto = precoC;
       this.nomeProduto = n;
       this.dataCadastro = data;
       this.foto = ft;
    }
    public Produto(){
        this(0, 0, 0.0f, 0.0f, "", null,"");
    }
    
    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }
    public long getReferenciaProduto() {
        return referenciaProduto;
    }

    public void setReferenciaProduto(long referenciaProduto) {
        this.referenciaProduto = referenciaProduto;
    }

    public long getQuantidadeProduto() {
        return quantidadeProduto;
    }

    public void setQuantidadeProduto(long quantidadeProduto) {
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
    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    @Override
    public String toString() {
        return getNomeProduto();
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
  
    
    
}
