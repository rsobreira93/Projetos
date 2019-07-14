package Controller;
import Main.Main;
import Modelo.Administrador;
import ModeloConection.ConnectionFactory;
import ModeloDao.AdministradorDao;
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
    
   Administrador mod = new Administrador();
   AdministradorDao dao = new AdministradorDao();
   ConnectionFactory con = new ConnectionFactory();
    
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
       mod.setLogin(NovoLoginTextField1.getText());
       mod.setEmail(EmailTextField.getText());
       mod.setSenha(NovaSenhaPassawordField.getText());
       dao.add(mod);
    }
}
