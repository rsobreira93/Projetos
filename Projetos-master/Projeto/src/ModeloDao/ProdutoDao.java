/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDao;

import Modelo.ModeloUsuario;
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
 *
 * @author Romulo Sobreira
 */
public class ProdutoDao {
        private Connection con;
    
    public ProdutoDao(){
        this.con = new ConnectionFactory().getConnection();
    }
    
    public boolean add(Produto p){
        try {
            String sql = "INSERT INTO produtos(nome, quantidade, precoV, precoC, data) VALUES(?, ?, ?, ?, ?);";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, p.getNomeProduto());
            stmt.setInt(2, p.getQuantidadeProduto());
            stmt.setFloat(3, p.getPrecoVenda());
            stmt.setFloat(4, p.getPrecoCusto());
            stmt.setDate(5, (Date) p.getDataCadastro());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar Produto!\n"+ex.getMessage()); 
            return false;
        }
    }
    public boolean update(Produto p){
        try {
            String sql = "UPDATE produtos SET nome = ?, quantidade = ?, precoV = ?, precoC = ?, data = ? WHRE id = ?;";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, p.getNomeProduto());
            stmt.setInt(2, p.getQuantidadeProduto());
            stmt.setFloat(3, p.getPrecoVenda());
            stmt.setFloat(4, p.getPrecoCusto());
            stmt.setDate(5, (Date) p.getDataCadastro());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "produto atualizado com sucesso!");
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar produto!\n"+ex.getMessage()); 
            return false;
        }
    }
     
    public boolean delete(Produto p){
        try {
            String sql = "DELETE FROM produtos WHRE id = ?;";
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
    
    public List<Produto> getList(){
        List<Produto> produtos = new ArrayList<>();
        String sql = "SELECT * FROM produtos;";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Produto p  = new Produto();
                p.setReferenciaProduto(rs.getInt("id"));
                p.setNomeProduto(rs.getString("nome"));
                p.setPrecoVenda(rs.getFloat("precoV"));
                p.setPrecoCusto(rs.getFloat("precoC"));
                p.setQuantidadeProduto(rs.getInt("quantidade"));
                p.setDataCadastro(rs.getDate("data"));
                produtos.add(p);
            }
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