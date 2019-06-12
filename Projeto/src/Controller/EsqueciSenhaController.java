package Controller;

import Main.Main;
import java.io.IOException;
import static java.sql.Types.NULL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class EsqueciSenhaController{
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
        if(EmailTextField.getText().equals("jvyctor12@gmail.com"))
            IncorretoLabel.setText("Sua nova senha foi enviada para seu e-mail");
        else if(EmailTextField.getText().equals(NULL))
            IncorretoLabel.setText("Digite seu e-mail");
        else
            IncorretoLabel.setText("Esse e-mail não pertence a nenhum usuário");
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

