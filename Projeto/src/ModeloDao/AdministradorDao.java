/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDao;

import Modelo.Administrador;
import ModeloConection.ConexaoBD;
import ModeloConection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author João Victor Queiroz
 */
public class AdministradorDao {
    private Connection con;
    ConexaoBD conBd = new ConexaoBD();    
    public AdministradorDao(){
        this.con = new ConnectionFactory().getConnection();
    }
    public boolean add(Administrador u){
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
   public boolean update(Administrador u){
        try {
            String sql = "UPDATE usuarios SET login = ?, senha = ?, WHERE id = ?;";
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
   public boolean delete(Administrador u){
        try {
            String sql = "DELETE FROM usuarios WHERE id = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, u.getLogin());
            stmt.execute();
            JOptionPane.showMessageDialog(null, "Usuário excluido com sucesso!");
            return true;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir Usuário!\n"+ex.getMessage()); 
            return false;
        }
    }
   public List<Administrador> getList(){
        List<Administrador> usuarios = new ArrayList<>();
        String sql = "SELECT * FROM usuarios;";
        try {
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Administrador u  = new Administrador();
                u.setLogin(rs.getString("login"));//Essa string é de acordo com o nome da coluna no BD
                u.setEmail(rs.getString("email")); 
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
   public Administrador validar(String login){
       Administrador vendedor = new Administrador();
            try {
            conBd.conexao();
            conBd.executaSql("SELECT * from usuarios where login = '"+login+"';");
                conBd.rs.first();
            vendedor.setLogin(conBd.rs.getString("login"));
            vendedor.setEmail(conBd.rs.getString("email"));
            vendedor.setSenha(conBd.rs.getString("senha"));
            return vendedor;
        } catch (SQLException ex) {
            Logger.getLogger(AdministradorDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null ;
   }
}
