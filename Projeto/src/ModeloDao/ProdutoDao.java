/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDao;

import Modelo.Produto;
import ModeloConection.ConnectionFactory;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *Classe responsavel pelo CRUD do produto
 * @author Romulo Sobreira
 */
public class ProdutoDao {
        private Connection con;
    
    public ProdutoDao(){
        this.con = new ConnectionFactory().getConnection();
    }
    /**
     * Metodo responsavel por adicionar o produto no banco de dados
     * @param p - produdot que sera salvo no banco
     * @return true/false
     */
    public boolean add(Produto p){
        try {
            String sql = "INSERT INTO produto(referencia, precovenda, precocusto, nome, data, quantidade, foto) VALUES(?, ?, ?, ?, ?, ?, ?);";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setLong(1, p.getReferenciaProduto());
            stmt.setFloat(2, p.getPrecoVenda());
            stmt.setFloat(3, p.getPrecoCusto());
            stmt.setString(4, p.getNomeProduto());
            stmt.setDate(5, (Date) p.getDataCadastro());
            stmt.setLong(6, p.getQuantidadeProduto());
            stmt.setString(7, p.getFoto());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar Produto!\n"+ex.getMessage()); 
            return false;
        }
    }
    /**
     * Metodo responsavel por alterar os dados do  produto no banco de dados
     * @param p - produto que sera alterado no banco
     * @return true/false
     */
    public boolean update(Produto p){
        try {
            String sql = "UPDATE produto SET nome = ?, precovenda = ?, precocusto = ?, data = ?, quantidade = ?, foto = ? WHERE id = ?;";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setLong(1, p.getReferenciaProduto());
            stmt.setFloat(2, p.getPrecoVenda());
            stmt.setFloat(3, p.getPrecoCusto());
            stmt.setString(4, p.getNomeProduto());
            stmt.setDate(5, (Date) p.getDataCadastro());
            stmt.setLong(6, p.getQuantidadeProduto());
            stmt.setString(7, p.getFoto());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "produto atualizado com sucesso!");
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar produto!\n"+ex.getMessage()); 
            return false;
        }
    }
     /**
     * Metodo responsavel por deletar o produto no banco de dados
     * @param p - produto que sera alterado
     * @return true/false
     */
    public boolean delete(Produto p){
        try {
            String sql = "DELETE FROM produto WHERE id_prod = ?;";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setLong(1, p.getReferenciaProduto());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Produto excluido com sucesso!");
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir produto!\n"+ex.getMessage()); 
            return false;
        }
    }
    /**
     * Metodos responsavel por listar os produtos
     * @return List(Lista  de porduto)
     */
    public List<Produto> getList(){
        List<Produto> produtos = new ArrayList<>();
        int quantidade;
        String sql = "SELECT * FROM produto;";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Produto p  = new Produto();
                quantidade=rs.getInt("id");
                if(quantidade!=0){
                p.setReferenciaProduto(rs.getInt("id_prod"));
                p.setPrecoVenda(rs.getFloat("precovenda"));
                p.setPrecoCusto(rs.getFloat("precocusto"));
                p.setNomeProduto(rs.getString("nome"));
                p.setDataCadastro(rs.getDate("data"));
                p.setQuantidadeProduto(rs.getInt("quantidade"));
                p.setFoto(rs.getString("foto"));
                produtos.add(p);
            }}
            stmt.close();
            rs.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return produtos;
    }
}