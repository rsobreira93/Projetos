
package Controller;

import Main.Main;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class NovoUserController{
    private Parent nova;
    @FXML
    private TextField NovoLoginTextField1;
    @FXML
    private Button ButtonCadastrar;
    @FXML
    private PasswordField NovaSenhaPassawordField;
    @FXML
    private Button ButtonCancelar;
    @FXML
    private TextField EmailTextField;
    @FXML
    void ButtonCancelarAction(ActionEvent event){
        try {
                 nova= FXMLLoader.load(getClass().getResource("/View/Login.fxml"));
                 Main.trocarTela(nova);
            } catch (IOException ex) {
                Logger.getLogger(NovoUserController.class.getName()).log(Level.SEVERE, null, ex);
            } 
    } 
    @FXML
    void ButtonCadastrarAction(ActionEvent event){
        // é aqui romulo 
    }
}
