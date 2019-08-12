package Controller;

import Auxiliares.TextFieldFormatter;
import Modelo.Cliente;
import Main.Main;
import ModeloConection.ConnectionFactory;
import ModeloDao.ClienteDAO;
import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
/**
 * classe responsavel por gerenciar os clientes
 * @author Romulo Sobreira
 */
public class GerenciamentoClienteController {
   Cliente mod = new Cliente();
   ClienteDAO dao = new ClienteDAO();
   ConnectionFactory con = new ConnectionFactory();
    @FXML
    private TextField cNascimento;
    private Parent nova;
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
        
       // int op = Main.telaAlerta(); 
        //if(op==1){
        if(nomeTextField.getText().isEmpty() &&
           celularTextField.getText().isEmpty()&&
           cNascimento.getText().isEmpty()&&
           emailTextField.getText().isEmpty()&&
           cpfTextField.getText().isEmpty() &&
           enderecoTextField.getText().isEmpty()&&
           nTextField.getText().isEmpty()&&
           complementoTextField.getText().isEmpty()&&
           bairroTextField.getText().isEmpty()&&
           cidadeTextField.getText().isEmpty()&&
           obsTextField.getText().isEmpty()){
            try {
                nova= FXMLLoader.load(getClass().getResource("/View/Login.fxml"));
                 Main.trocarTela(nova);
            } catch (IOException ex) {
                Logger.getLogger(GerenciamentoClienteController.class.getName()).log(Level.SEVERE, null, ex);
            }  
        }else{
            Alert confirmacao = new Alert(Alert.AlertType.CONFIRMATION);
        confirmacao.setTitle("Aviso");
        confirmacao.setContentText("Deseja sair sem concluir o cadastro?");
        Optional<ButtonType> result = confirmacao.showAndWait();
        if(result.get() == ButtonType.OK){
           try {
                nova= FXMLLoader.load(getClass().getResource("/View/Login.fxml"));
                 Main.trocarTela(nova);
            } catch (IOException ex) {
                Logger.getLogger(GerenciamentoClienteController.class.getName()).log(Level.SEVERE, null, ex);
            }  
        }
        }
    }           
    @FXML
    void voltarButtonAction(ActionEvent event){
        //int op = Main.telaAlerta();   
        //if(op==1){
        if(nomeTextField.getText().isEmpty() &&
           celularTextField.getText().isEmpty()&&
           cNascimento.getText().isEmpty()&&
           emailTextField.getText().isEmpty()&&
           cpfTextField.getText().isEmpty() &&
           enderecoTextField.getText().isEmpty()&&
           nTextField.getText().isEmpty() &&
           complementoTextField.getText().isEmpty()&&
           bairroTextField.getText().isEmpty()&&
           cidadeTextField.getText().isEmpty()&&
           obsTextField.getText().isEmpty()){
            try {
                 nova= FXMLLoader.load(getClass().getResource("/View/MenuPrincipal.fxml"));
            Main.trocarTela(nova);
            } catch (IOException ex) {
                Logger.getLogger(GerenciamentoClienteController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            Alert confirmacao = new Alert(Alert.AlertType.CONFIRMATION);
            confirmacao.setTitle("Aviso");
            confirmacao.setContentText("Deseja sair sem concluir o cadastro?");
            Optional<ButtonType> result = confirmacao.showAndWait();
            if(result.get() == ButtonType.OK){
               try {
                    nova= FXMLLoader.load(getClass().getResource("/View/MenuPrincipal.fxml"));
                     Main.trocarTela(nova);
                } catch (IOException ex) {
                    Logger.getLogger(GerenciamentoClienteController.class.getName()).log(Level.SEVERE, null, ex);
                }  
            }
        }
    }
    @FXML
    void cadastrarButtonAction(ActionEvent event) throws IOException{
        
        if(nomeTextField.getText().isEmpty() ||
           celularTextField.getText().isEmpty() ||
           enderecoTextField.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Todos os campos obrigatórios devem ser preenchidos");
        }else{
            mod.setNome(nomeTextField.getText());
            mod.setTelefone(celularTextField.getText());
            mod.setdNascimento(cNascimento.getText());
            mod.setEmail(emailTextField.getText());
            mod.setCpf(cpfTextField.getText());
            mod.setEndereco(enderecoTextField.getText());
            mod.setN(nTextField.getText());
            mod.setComplemento(complementoTextField.getText());
            mod.setBairro(bairroTextField.getText());
            mod.setCidade(cidadeTextField.getText());
            mod.setObs(obsTextField.getText());
            dao.add(mod);
            nova= FXMLLoader.load(getClass().getResource("/View/GerenciamentoCliente.fxml"));
            Main.trocarTela(nova);
        }
    }
    @FXML
    void inicioButtonAction(ActionEvent event){
        //int op = Main.telaAlerta(); 
        //if(op==1){
        if(nomeTextField.getText().isEmpty() &&
           celularTextField.getText().isEmpty()&&
           cNascimento.getText().isEmpty()&&
           emailTextField.getText().isEmpty()&&
           cpfTextField.getText().isEmpty() &&
           enderecoTextField.getText().isEmpty()&&
           nTextField.getText().isEmpty()&&
           complementoTextField.getText().isEmpty()&&
           bairroTextField.getText().isEmpty()&&
           cidadeTextField.getText().isEmpty()&&
           obsTextField.getText().isEmpty()){
            try {
                 nova= FXMLLoader.load(getClass().getResource("/View/MenuPrincipal.fxml"));
            Main.trocarTela(nova);
            } catch (IOException ex) {
                Logger.getLogger(GerenciamentoClienteController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    else{
            Alert confirmacao = new Alert(Alert.AlertType.CONFIRMATION);
            confirmacao.setTitle("Aviso");
            confirmacao.setContentText("Deseja sair sem concluir o cadastro?");
            Optional<ButtonType> result = confirmacao.showAndWait();
            if(result.get() == ButtonType.OK){
               try {
                    nova= FXMLLoader.load(getClass().getResource("/View/MenuPrincipal.fxml"));
                     Main.trocarTela(nova);
                } catch (IOException ex) {
                    Logger.getLogger(GerenciamentoClienteController.class.getName()).log(Level.SEVERE, null, ex);
                }  
            }
        }
    }
    @FXML
    void meusClientesButtonAction(ActionEvent event){
        if(nomeTextField.getText().isEmpty() &&
           celularTextField.getText().isEmpty()&&
           cNascimento.getText().isEmpty()&&
           emailTextField.getText().isEmpty()&&
           cpfTextField.getText().isEmpty() &&
           enderecoTextField.getText().isEmpty()&&
           nTextField.getText().isEmpty()&&
           complementoTextField.getText().isEmpty()&&
           bairroTextField.getText().isEmpty()&&
           cidadeTextField.getText().isEmpty()&&
           obsTextField.getText().isEmpty()){
        try {
                nova= FXMLLoader.load(getClass().getResource("/View/MeusClientes.fxml"));
                Main.trocarTela(nova);
            } catch (IOException ex) {
                Logger.getLogger(GerenciamentoClienteController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }else{
                    Alert confirmacao = new Alert(Alert.AlertType.CONFIRMATION);
            confirmacao.setTitle("Aviso");
            confirmacao.setContentText("Deseja sair sem concluir o cadastro?");
            Optional<ButtonType> result = confirmacao.showAndWait();
            if(result.get() == ButtonType.OK){
               try {
                    nova= FXMLLoader.load(getClass().getResource("/View/MeusClientes.fxml"));
                     Main.trocarTela(nova);
                } catch (IOException ex) {
                    Logger.getLogger(GerenciamentoClienteController.class.getName()).log(Level.SEVERE, null, ex);
                }  
            }
    }
    }
    /**
     * Metodo responsavel por adicionar uma mascara  no campo celular
     */
     @FXML
    void celularOnKeyReleased() {
            TextFieldFormatter tff = new TextFieldFormatter();
            tff.formatter(celularTextField, "0123456789", "(##)#####-####");
    }
    /**
     * Metodo responsavel por adicionar uma mascara no campo cpf
     */
    @FXML
     void cpfOnKeyReleased() {
        TextFieldFormatter tff = new TextFieldFormatter();
        tff.formatter(cpfTextField, "0123456789", "###.###.###-##");
    }
}