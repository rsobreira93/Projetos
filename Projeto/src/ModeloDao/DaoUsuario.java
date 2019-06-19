/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDao;

import ModeloConection.ConexaoBD;
import Modelo.ModeloUsuario;
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
public class DaoUsuario {
    ConexaoBD conex = new ConexaoBD();
    ModeloUsuario user = new ModeloUsuario();
    
    
    public void salva(ModeloUsuario user){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("insert into clientes(nome, telefon, cpf, email, cidade, bairro, complemento,endereco, n) values(?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pst.setString(1, user.getNome());
            pst.setString(2, user.getTelefone());
            pst.setString(3, user.getCpf());
            pst.setString(4, user.getEmail());
            pst.setString(5, user.getCidade());
            pst.setString(6, user.getBairro());
            pst.setString(7, user.getComplemento());
            pst.setString(8, user.getEndereco());
            pst.setString(9, user.getN());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Cliente Cadastrado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente!\n"+ex.getMessage());
        }
        conex.desconecta();
    }
    
    public ModeloUsuario buscaCliente(ModeloUsuario user){
            conex.conexao();
            conex.executaSql("SELECT * FROM clientes WHERE nome = '"+user.getPesquisa()+"'");

        try {
            while(conex.rs.next()){
                user.setCod(conex.rs.getLong("id"));
                user.setNome(conex.rs.getString("nome"));
                user.setTelefone(conex.rs.getString("telefon"));
                user.setCpf(conex.rs.getString("cpf"));
                user.setEmail(conex.rs.getString("email"));
                user.setCidade(conex.rs.getString("cidade"));
                user.setBairro(conex.rs.getString("bairro"));
                user.setComplemento(conex.rs.getString("complemento"));
                user.setEndereco(conex.rs.getString("endereco"));
                user.setN(conex.rs.getString("n"));
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na busca do cliente!\n"+ex.getMessage());
        }
        conex.desconecta();
        return user;
    }
    public List<ModeloUsuario> getList(){
        List<ModeloUsuario> clientes = new ArrayList<>();
        String sql = "SELECT * FROM clientes;";
            try {
                PreparedStatement stmt = conex.con.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();
                while(rs.next()){
                    ModeloUsuario usuario = new ModeloUsuario();
                    usuario.setCod(rs.getLong("id"));
                    usuario.setNome(rs.getString("nome"));
                    usuario.setCpf(rs.getString("cpf"));
                    usuario.setTelefone(rs.getString("telefon"));
                    usuario.setEmail(rs.getString("email"));
                    usuario.setEndereco(rs.getString("endereco"));
                    clientes.add(usuario);
                }
                stmt.close();
                rs.close();
                conex.con.close();  
            } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Erro na busca do cliente!\n"+ex.getMessage());
            }
            return clientes;
    }
}
