package Controller;

import Main.Main;
import Modelo.Administrador;
import ModeloDao.AdministradorDao;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.util.Random;
import javax.swing.JOptionPane;
public class EsqueciSenhaController{
    Administrador vendedor = new Administrador();
    AdministradorDao vendedorDao= new AdministradorDao();
    private Parent nova;
    @FXML
    private Label IncorretoLabel;
    @FXML
    private Button ButtonRecuperar;
    @FXML
    private TextField EmailTextField;
    @FXML
    private Button ButtonCancelar;
    @FXML
    void ButtonRecuperarAction(ActionEvent event){
        if(EmailTextField.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "O campo de e-mail é obrigatório");
        }else{
                 vendedor = vendedorDao.validar(EmailTextField.getText());
                 System.out.println(vendedor.getLogin());
                 System.out.println(vendedor.getSenha());
                 if(EmailTextField.getText().equals(vendedor.getEmail())){
                     Random novaSenha = new Random();
                     vendedor.setSenha("a"+novaSenha.nextInt());
                     vendedorDao.update(vendedor);
                     Main.emailEsqueciSenha(vendedor.getEmail(), vendedor.getSenha());
                    JOptionPane.showMessageDialog(null, "Sua nova senha foi enviada para seu e-mail");
                  }else {
                       JOptionPane.showMessageDialog(null, "Esse e-mail não pertence a nenhum usuário");
                 }
        }
    }
    @FXML
    void ButtonCancelarAction(ActionEvent event){
        try {
            nova= FXMLLoader.load(getClass().getResource("/View/Login.fxml"));
            Main.trocarTela(nova);
            } catch (IOException ex) {
                Logger.getLogger(EsqueciSenhaController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
 
    }

