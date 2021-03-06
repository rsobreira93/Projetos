package ModeloConection;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 * Classe responsavel por auxiliar na conexão com o banco de dados.
 * @author Romulo Sobreira
 */
public class ConexaoBD {
    public Statement stm;
    public ResultSet rs;
    private String driver = "org.postgresql.Driver";
    private String caminho = "jdbc:postgresql://localhost:5432/Anamary";
    private String usuario = "postgres";
    private String senha = "Romulo14";
    public Connection con;
    /**
     * Metodo que abre a conexãp com o banco de dados
     */
    public void conexao(){
        System.setProperty("jdbc.Drivers", driver);
        try {
            con = DriverManager.getConnection(caminho, usuario, senha);
            //JOptionPane.showMessageDialog(null, "Conectado com sucesso ao BD");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o BD\n"+ex.getMessage());
        }
    }
    /**
     * Metodo responsavel por fazer a consulta no banco de dados
     * @param  sql - String que passa o paramentros da consulta
     */
    public void executaSql(String sql){
        try {
            stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
            rs= stm.executeQuery(sql);
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Erro executor SQL:\n"+ex.getMessage());
        }
    }
    /**
     * Metodos que encerra a conexão com o banco de dados
     */
    public void desconecta(){
        try{
            con.close();
            JOptionPane.showMessageDialog(null, "Desconectado com sucesso do BD");
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Erro ao desconectar do BD"+ex.getMessage());
        }
    }
}
