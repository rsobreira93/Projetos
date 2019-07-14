package Controller;

import Main.Main;
import Modelo.Administrador;
import ModeloConection.ConexaoBD;
import ModeloConection.ConnectionFactory;
import ModeloDao.AdministradorDao;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import static sun.security.jgss.GSSUtil.login;

public class LoginController {
    Administrador vendedor = new Administrador();
    AdministradorDao vendedorDao= new AdministradorDao();
    private Parent nova;
    @FXML
    private Button ButtonNovoUser;
     @FXML
    private Button ButtonEsqueci;
    @FXML
    private Label IncorretoLabel;
    @FXML
    private TextField LoginTextField;
    @FXML
    private Button Button;
    @FXML
    private PasswordField SenhaPassawordField;
    @FXML
    void buttonAction(ActionEvent event){
                vendedor= vendedorDao.validar(LoginTextField.getText());
                if(vendedor.getSenha().equals(SenhaPassawordField.getText())){
                    mudarTela();
                }
                else{
                    JOptionPane.showMessageDialog(null, "Login ou senha incorretos");
                    //IncorretoLabel.setText("Login ou senha incorretos");
                }
    }
    @FXML
    void ButtonNovoUserAction(ActionEvent event){
        try {
                 nova= FXMLLoader.load(getClass().getResource("/View/NovoUser.fxml"));
            Main.trocarTela(nova);
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    @FXML
    void ButtonEsqueciAction(ActionEvent event){
        try {
                 nova= FXMLLoader.load(getClass().getResource("/View/EsqueciSenha.fxml"));
            Main.trocarTela(nova);
            } catch (IOException ex) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public void mudarTela(){
        try {
            nova= FXMLLoader.load(getClass().getResource("/View/MenuPrincipal.fxml"));
            Main.trocarTela(nova);
        } catch (IOException ex) {
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}