/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDao;



import Modelo.Produto;
import Modelo.Venda;
import ModeloConection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *Calsse responsavel por registar as vendas no banco de dados
 * @author Romulo Sobreira
 */
public class VendaDao {
    private int cod;
    private int codCli;
     private Connection con;
     private ProdutoDao produto = new ProdutoDao();
    
    public VendaDao(){
        this.con = new ConnectionFactory().getConnection();
    }
     /**
     * metodo responsavel por verificar se a quantidade da venda do produto é valida
     * @throws SQLException - execeções que podem ocrrer caso a quantidade seja maior do que as disponiveis 
     */
    public int quantVerifica(Produto selecionada, int quant) throws SQLException{
        int codP, novaQuant;
       String sql = ("select  *from produto where id_prod="+selecionada.getReferenciaProduto()+";");
       PreparedStatement stmt = con.prepareStatement(sql);
       ResultSet rs = stmt.executeQuery();
       while (rs.next()) {
        codP = rs.getInt("quantidade");
        if(quant > codP){
           return 1;
       }
       else{
           novaQuant= codP-quant;
           sql = ("update produto set quantidade="+novaQuant+" where id_prod="+selecionada.getReferenciaProduto()+";");
           stmt = con.prepareStatement(sql);
           if(novaQuant==0){
               produto.delete(selecionada);
           }
           stmt.execute();
           return 0;
       }
       }
       System.out.println(quant);
       System.out.println(cod);
        return 0;
 
    }
    /**
     * metodo responsavel por buscar o id da venda atual
     * @throws SQLException - execeções que podem ocrrer caso a quantidade seja maior do que as disponiveis 
     */
    public void codVenda() throws SQLException{
       String sql = ("select  *from venda where id_venda = (SELECT MAX(id_venda) FROM venda);");
       PreparedStatement stmt = con.prepareStatement(sql);
       ResultSet rs = stmt.executeQuery();
       
       while (rs.next()) {
           this.cod = rs.getInt("id_venda");
       }
      
    }
    public boolean add(Venda u){
        try {
            String sql = "insert into itens_venda(id_venda, id_produto, itens_quantidade) values(?,?,?);";
            PreparedStatement stmt = con.prepareStatement(sql);
            codVenda();
           //    teste();
            stmt.setInt(1, this.cod);
            stmt.setInt(2, u.getCodProduto());
            stmt.setInt(3, u.getQtdItem());
            stmt.execute();
           // JOptionPane.showMessageDialog(null, "Venda cadastrada com sucesso!");
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar venda!\n"+ex.getMessage()); 
            return false;
        }
    }
    public boolean delete(Venda u){
        try {
            String sql = "DELETE FROM venda WHERE id_venda = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setLong(1, u.getIdVenda());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Venda excluida com sucesso!");
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir venda!\n"+ex.getMessage()); 
            return false;
        }
    }
    public void encontraCodCliente(String nome) throws SQLException{
       String sql = ("select  *from clientes where nome_cliente='"+nome+"';");
       PreparedStatement stmt = con.prepareStatement(sql);
       ResultSet rs = stmt.executeQuery();
       
       while (rs.next()) {
           this.codCli = rs.getInt("id");
       }
    
    }
    public void FinalizaVenda(Venda v) throws SQLException{
        encontraCodCliente(v.getNomeCliente());
        codVenda();
        String sql = "update venda set data_venda=?, valor_venda=?, id_cliente=? where id_venda="+this.cod+";";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, v.getData());
        stmt.setFloat(2, v.getValorVenda());
        stmt.setInt(3, this.codCli);
        stmt.execute();
        JOptionPane.showMessageDialog(null, "Venda cadastrada com sucesso!");
    }
    /**
     * metodo responsavel cancelar a venda e torna o produto
     * @throws SQLException - execeções que podem ocrrer caso a quantidade seja maior do que as disponiveis 
     */
    public void cancelaVenda() throws SQLException{
        String sql;
        PreparedStatement stmt;
        ResultSet rs;
        String sql2 = "select * from venda inner join itens_venda on venda.id_venda = itens_venda.id_venda inner join produto on itens_venda.id_produto=produto.id_prod where valor_venda=0;";
        PreparedStatement stmt2 = con.prepareStatement(sql2);
        ResultSet rs2 = stmt2.executeQuery();
        while(rs2.next()){
         int quantProd= rs2.getInt("quantidade");
         int quantItemVenda= rs2.getInt("itens_quantidade");
         int soma= quantProd + quantItemVenda;
         sql="update produto set quantidade=? where id_prod=?";
         stmt=con.prepareStatement(sql);
         stmt.setInt(1,soma);
         stmt.setInt(2, rs2.getInt("id_produto"));
         stmt.execute();
         sql="delete from itens_venda where id_venda=?";
         stmt=con.prepareStatement(sql);
         stmt.setInt(1, rs2.getInt("id_venda"));
         stmt.execute();
        }
        try {
             sql = "delete from venda where valor_Venda=?;";
            stmt= con.prepareStatement(sql);
            stmt.setFloat(1,0);
            stmt.execute();
        } catch (SQLException ex) {
            Logger.getLogger(VendaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
   public List<Venda> getList() throws SQLException{
        List<Venda> vendas = new ArrayList<>();
        codVenda();
        //String sql = "SELECT * FROM itens_venda where id_venda="+this.cod+";";
        String sql = "SELECT * FROM produto inner join itens_venda on produto.id_prod = itens_venda.id_produto inner join venda on venda.id_venda = itens_venda.id_venda where venda.id_venda="+this.cod+";";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Venda  u  = new Venda();  
                u.setNomeProduto(rs.getString("nome"));
                u.setQtdItem(rs.getInt("itens_quantidade"));
                u.setValorVenda(rs.getFloat("precovenda")*rs.getInt("itens_quantidade"));   
                vendas.add(u);
            }
            stmt.close();
            rs.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return vendas;
    }
   /**
     * metodo responsavel por alimentar a tabela carrinho
     * @throws SQLException - execeções que podem ocrrer caso a quantidade seja maior do que as disponiveis 
     * @return 
     */
   public List<Venda> getList2() throws SQLException{
        List<Venda> vendas = new ArrayList<>();
        String sql = "SELECT * FROM produto inner join itens_venda on produto.id_prod = itens_venda.id_produto inner join venda on venda.id_venda = itens_venda.id_venda inner join clientes on clientes.id = venda.id_cliente;";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Venda  u  = new Venda();  
                u.setNomeProduto(rs.getString("nome"));
                u.setNomeCliente(rs.getString("nome_cliente"));
                u.setQtdItem(rs.getInt("itens_quantidade"));
                u.setValorVenda(rs.getFloat("valor_venda")); 
                u.setData(rs.getString("data_venda"));  
                u.setPrecoCusto(rs.getFloat("precocusto"));
                vendas.add(u);
            }
            stmt.close();
            rs.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return vendas;
    }
}

