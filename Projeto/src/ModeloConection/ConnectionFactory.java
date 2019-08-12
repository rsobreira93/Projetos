/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloConection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *Classe responsavel por cirar a conexão com o banco de dados
 * @author Romulo Sobreira
 */
public class ConnectionFactory {
    /**
     * Metodos responsavel por abrir a conexão com o Banco de dados
     * @return Connection
     */
    public Connection getConnection(){
        try{
            String nomeUsuario = "postgres";
            String senhaUsuario = "Romulo14";
            String enderecoServidor = "localhost:5432";
            String nomeBanco = "Anamary";
        
            return DriverManager.getConnection("jdbc:postgresql://"+enderecoServidor+
                    "/"+nomeBanco, nomeUsuario, senhaUsuario);
        }catch(SQLException ex){
            throw new RuntimeException(ex);
        }
    }
}
