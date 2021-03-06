/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDao;

import Modelo.Vendedor;
import ModeloConection.ConexaoBD;
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
 *
 * @author João Victor Queiroz
 */
public class VendedorDAO {
    private Connection con;
    ConexaoBD conBd = new ConexaoBD();    
    public VendedorDAO(){
        this.con = new ConnectionFactory().getConnection();
    }
    public boolean add(Vendedor u){
        try {
            String sql = "INSERT INTO usuarios(login, email, senha) VALUES(?, ?, ?);";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, u.getLogin());
            stmt.setString(2, u.getEmail());
            stmt.setString(3, u.getSenha());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar usuário!\n"+ex.getMessage()); 
            return false;
        }
    }
   public boolean update(Vendedor u){
        try {
            String sql = "UPDATE usuarios SET login = ?, senha = ?;";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, u.getLogin());
            stmt.setString(2, u.getSenha());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Usuário atualizado com sucesso!");
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar usuário!\n"+ex.getMessage()); 
            return false;
        }
    }
   public boolean delete(Vendedor u){
        try {
            String sql = "DELETE FROM usuarios WHERE login = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, u.getLogin());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Administrador excluido com sucesso!");
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir Administrador!\n"+ex.getMessage()); 
            return false;
        }
    }
   public List<Vendedor> getList(){
        List<Vendedor> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuarios;";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Vendedor u  = new Vendedor();
                u.setLogin(rs.getString("login"));//Essa string é de acordo com o nome da coluna no BD
                u.setEmail(rs.getString("email")); 
                u.setSenha(rs.getString("senha"));
                usuarios.add(u);
            }
            stmt.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Deu erro na lista");
            ex.printStackTrace();
            return null;
        }
        return usuarios;
    }
   public Vendedor validar(String login){
       Vendedor vendedor = new Vendedor();
            String sql = "SELECT * from usuarios where login = '"+login+"' or email ='"+login+"';";
            try {
                PreparedStatement stmt = con.prepareStatement(sql);
                ResultSet rs = stmt.executeQuery();
                while(rs.next()){
                    vendedor.setLogin(rs.getString("login"));
                    vendedor.setEmail(rs.getString("email"));
                    vendedor.setSenha(rs.getString("senha"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(VendedorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return vendedor;
   }
}
