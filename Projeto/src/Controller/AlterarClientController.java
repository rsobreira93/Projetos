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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class AlterarClientController {
    private Parent nova;
    @FXML
    private TextField cNascimentoTextField;

    @FXML
    private TextField complementoTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private Button atualizarButton;

    @FXML
    private TextArea obsTextField;

    @FXML
    private Button enfButton;

    @FXML
    private TextField cpfTextField;

    @FXML
    private TextField bairroTextField;

    @FXML
    private Button voltarButton;

    @FXML
    private TextField enderecoTextField;

    @FXML
    private ImageView inicioImg;

    @FXML
    private TextField celularTextField;

    @FXML
    private TextField nomeTextField;

    @FXML
    private Button inicioButton;

    @FXML
    private TextField nTextField;

    @FXML
    private TextField cidadeTextField;

    @FXML
    private Button sairButton;
    @FXML
    void sairButtonAction(ActionEvent event){
        int op = Main.telaAlerta(); 
        if(op==1){
            try {
                nova= FXMLLoader.load(getClass().getResource("/View/Login.fxml"));
                 Main.trocarTela(nova);
            } catch (IOException ex) {
                Logger.getLogger(AlterarClientController.class.getName()).log(Level.SEVERE, null, ex);
            }  
        }        
    }   
    @FXML
    void voltarButtonAction(ActionEvent event){
        int op = Main.telaAlerta(); 
        if(op==1){
            try {
                 nova= FXMLLoader.load(getClass().getResource("/View/MeusClientes.fxml"));
            Main.trocarTela(nova);
            } catch (IOException ex) {
                Logger.getLogger(AlterarClientController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    @FXML
    void inicioButtonAction(ActionEvent event){
        int op = Main.telaAlerta(); 
        if(op==1){
            try {
                 nova= FXMLLoader.load(getClass().getResource("/View/MenuPrincipal.fxml"));
            Main.trocarTela(nova);
            } catch (IOException ex) {
                Logger.getLogger(AlterarClientController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    @FXML
    void atualizarButtonAction(ActionEvent event){
    // aqui romulo
    }
   
}
