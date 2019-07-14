/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 * Essa classe tem como finalidade ter as caracteristicas de uma venda dentro
 * do contexto do nosso sistema onde serão passado um cliente um produto e info-
 * mações adicionais como preço e desconto caso haja.
 * @author Romulo Sobreira
 */
public class Venda {

    
    private int codVenda;
    private float precoVenda;
    private float descontoVenda;
    private String dataVenda;
    private boolean formaPagamento;
    private Produto produtoVendido;
    private ModeloUsuario cliente;
    
    /**
     * @return the codVenda
     */
    public int getCodVenda() {
        return codVenda;
    }

    /**
     * @param codVenda the codVenda to set
     */
    public void setCodVenda(int codVenda) {
        this.codVenda = codVenda;
    }

    /**
     * @return the precoVenda
     */
    public float getPrecoVenda() {
        return precoVenda;
    }

    /**
     * @param precoVenda the precoVenda to set
     */
    public void setPrecoVenda(float precoVenda) {
        this.precoVenda = precoVenda;
    }

    /**
     * @return the descontoVenda
     */
    public float getDescontoVenda() {
        return descontoVenda;
    }

    /**
     * @param descontoVenda the descontoVenda to set
     */
    public void setDescontoVenda(float descontoVenda) {
        this.descontoVenda = descontoVenda;
    }

    /**
     * @return the dataVenda
     */
    public String getDataVenda() {
        return dataVenda;
    }

    /**
     * @param dataVenda the dataVenda to set
     */
    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    /**
     * @return the formaPagamento
     */
    public boolean getFormaPagamento() {
        return formaPagamento;
    }

    /**
     * @param formaPagamento the formaPagamento to set
     */
    public void setFormaPagamento(boolean formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    /**
     * @return the produtoVendido
     */
    public Produto getProdutoVendido() {
        return produtoVendido;
    }

    /**
     * @param produtoVendido the produtoVendido to set
     */
    public void setProdutoVendido(Produto produtoVendido) {
        this.produtoVendido = produtoVendido;
    }

    /**
     * @return the cliente
     */
    public ModeloUsuario getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(ModeloUsuario cliente) {
        this.cliente = cliente;
    }
    
    
    
}
