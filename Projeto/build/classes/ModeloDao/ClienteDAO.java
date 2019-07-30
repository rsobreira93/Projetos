/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDao;

import java.sql.Connection;
import ModeloConection.ConnectionFactory;
import Modelo.Cliente;
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
public class ClienteDAO {
    private Connection con;
    
    public ClienteDAO(){
        this.con = new ConnectionFactory().getConnection();
    }
    
    public boolean add(Cliente u){
        try {
            String sql = "INSERT INTO clientes(nome, telefon, cpf, email, cidade, bairro, complemento,endereco, n, datanascimento, obs) VALUES(?, ?, ?, ?, ?, ? ,?, ?, ?, ?,?);";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getTelefone());
            stmt.setString(3, u.getCpf());
            stmt.setString(4, u.getEmail());
            stmt.setString(5, u.getCidade());
            stmt.setString(6, u.getBairro());
            stmt.setString(7, u.getComplemento());
            stmt.setString(8, u.getEndereco());
            stmt.setString(9, u.getN());
            stmt.setString(10, u.getdNascimento());
            stmt.setString(11, u.getObs());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente!\n"+ex.getMessage()); 
            return false;
        }
    }
    public boolean update(Cliente u){
        try {
            String sql = "UPDATE clientes SET nome = ?, telefon = ?, cpf = ?, email = ?, cidade = ?, bairro = ?, complemento = ?, endereco = ?, n = ?, datanascimento = ? , obs = ? WHERE id = ?;";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, u.getNome());
            stmt.setString(2, u.getTelefone());
            stmt.setString(3, u.getCpf());
            stmt.setString(4, u.getEmail());
            stmt.setString(5, u.getCidade());
            stmt.setString(6, u.getBairro());
            stmt.setString(7, u.getComplemento());
            stmt.setString(8, u.getEndereco());
            stmt.setString(9, u.getN());
            stmt.setString(10, u.getdNascimento());
            stmt.setString(11, u.getObs());
            stmt.setLong(12, u.getCod());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Cliente atualizado com sucesso!");
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar cliente!\n"+ex.getMessage()); 
            return false;
        }
    }
     
    public boolean delete(Cliente u){
        try {
            String sql = "DELETE FROM clientes WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setLong(1, u.getCod());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Cliente excluido com sucesso!");
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir cliente!\n"+ex.getMessage()); 
            return false;
        }
    }
    
    public List<Cliente> getList(){
        List<Cliente> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM clientes;";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Cliente u  = new Cliente();
                u.setCod(rs.getLong("id"));//Essa string é de acordo com o nome da coluna no BD
                u.setNome(rs.getString("nome"));
                u.setTelefone(rs.getString("telefon"));
                u.setCpf(rs.getString("cpf"));
                u.setEmail(rs.getString("email"));
                u.setCidade(rs.getString("cidade"));
                u.setBairro(rs.getString("bairro"));
                u.setComplemento(rs.getString("complemento"));
                u.setEndereco(rs.getString("endereco"));
                u.setN(rs.getString("n"));
                //u.setN(rs.getString("datanascimento"));
                //u.setN(rs.getString("obs"));
                
                usuarios.add(u);
            }
            stmt.close();
            rs.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        }
        return usuarios;
    }
}
