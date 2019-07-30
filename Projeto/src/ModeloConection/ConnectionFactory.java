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
 *
 * @author Romulo Sobreira
 */
public class ConnectionFactory {
    
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
