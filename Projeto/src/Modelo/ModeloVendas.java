package Modelo;
/**
 * Classe responsavel por cirar uma venda
 * @author Romulo Sobreira
 */
public class ModeloVendas {
    private int id;
    private int referenciaProduto;
    private double valorVenda;
    private double valordesconto;
    private String dataVenda;
    private String cliente;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getReferenciaProduto() {
        return referenciaProduto;
    }

    public void setReferenciaProduto(int referenciaProduto) {
        this.referenciaProduto = referenciaProduto;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(double valorVenda) {
        this.valorVenda = valorVenda;
    }

    public double getValordesconto() {
        return valordesconto;
    }

    public void setValordesconto(double valordesconto) {
        this.valordesconto = valordesconto;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }
    

    
}
