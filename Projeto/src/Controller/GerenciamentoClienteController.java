package Controller;

import Modelo.ModeloUsuario;
import Main.Main;
import ModeloConection.ConnectionFactory;
import ModeloDao.UsuarioDao;
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

public class GerenciamentoClienteController {
    
   /* ModeloUsuario mod = new ModeloUsuario();
    UsuarioDao dao = new UsuarioDao();
    ConnectionFactory con = new ConnectionFactory();*/
    
    private Parent nova;
    @FXML
    private TextField cNascimentoTextField;

    @FXML
    private Button meusClientesButton;
        
    @FXML
    private TextField emailTextField;

    @FXML
    private TextField bairroTextField;

    @FXML
    private Button cadastrarButton;

    @FXML
    private TextArea obsTextField;

    @FXML
    private Button enfButton;

    @FXML
    private TextField cpfTextField;

    @FXML
    private Button voltarButton;

    @FXML
    private TextField complementoTextField;

    @FXML
    private TextField enderecoTextField;

    @FXML
    private TextField celularTextField;

    @FXML
    private TextField nomeTextField;

    @FXML
    private TextField nTextField;

    @FXML
    private Button sairButton;

    @FXML
    private TextField cidadeTextField;
    
    @FXML
    private Button inicioButton;
    @FXML
    void sairButtonAction(ActionEvent event){
        int op = Main.telaAlerta(); 
        if(op==1){
            try {
                nova= FXMLLoader.load(getClass().getResource("/View/Login.fxml"));
                 Main.trocarTela(nova);
            } catch (IOException ex) {
                Logger.getLogger(GerenciamentoClienteController.class.getName()).log(Level.SEVERE, null, ex);
            }  
        }        
    }   
    @FXML
    void voltarButtonAction(ActionEvent event){
        int op = Main.telaAlerta(); 
        if(op==1){
            try {
                 nova= FXMLLoader.load(getClass().getResource("/View/MenuPrincipal.fxml"));
            Main.trocarTela(nova);
            } catch (IOException ex) {
                Logger.getLogger(GerenciamentoClienteController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    @FXML
    void cadastrarButtonAction(ActionEvent event){
       /* mod.setNome(nomeTextField.getText());
        mod.setTelefone(celularTextField.getText());
        cNascimentoTextField.getText();
        mod.setEmail(emailTextField.getText());
        mod.setCpf(cpfTextField.getText());
        mod.setEndereco(enderecoTextField.getText());
        mod.setN(nTextField.getText());
        mod.setComplemento(complementoTextField.getText());
        mod.setBairro(bairroTextField.getText());
        mod.setCidade(cidadeTextField.getText());
        dao.add(mod);*/
    }
    @FXML
    void inicioButtonAction(ActionEvent event){
        int op = Main.telaAlerta(); 
        if(op==1){
            try {
                 nova= FXMLLoader.load(getClass().getResource("/View/MenuPrincipal.fxml"));
            Main.trocarTela(nova);
            } catch (IOException ex) {
                Logger.getLogger(GerenciamentoClienteController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    @FXML
    void meusClientesButtonAction(ActionEvent event){
        try {
                nova= FXMLLoader.load(getClass().getResource("/View/MeusClientes.fxml"));
                Main.trocarTela(nova);
            } catch (IOException ex) {
                Logger.getLogger(GerenciamentoClienteController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}