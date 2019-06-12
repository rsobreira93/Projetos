package Controller;

import Main.Main;
import Modelo.ModeloUsuario;
import ModeloConection.ConexaoBD;
import ModeloConection.ConnectionFactory;
import ModeloDao.DaoUsuario;
import ModeloDao.UsuarioDao;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;


public class MeusClientesController{
    ModeloUsuario mod = new ModeloUsuario();
    UsuarioDao dao = new UsuarioDao();
    ConnectionFactory con = new ConnectionFactory();
    
    private Parent nova;
    @FXML
    private TextField buscarTextField;
    
    @FXML
    private Button excluirButton;

    @FXML
    private Button inicioButton;

    @FXML
    private ListView<?> meusClientesList;

    @FXML
    private Button atualizarButton;

    @FXML
    private Button enfButton;

    @FXML
    private Button sairButton;

    @FXML
    private Button voltarButton;

    @FXML
    private Button buscarButton;
    @FXML
                   
            
    void inicioButtonAction(ActionEvent event){
        try {
                 nova= FXMLLoader.load(getClass().getResource("/View/MenuPrincipal.fxml"));
            Main.trocarTela(nova);
            } catch (IOException ex) {
                Logger.getLogger(MeusClientesController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    @FXML
    void voltarButtonAction(ActionEvent event){
        try {
                 nova= FXMLLoader.load(getClass().getResource("/View/GerenciamentoCliente.fxml"));
            Main.trocarTela(nova);
            } catch (IOException ex) {
                Logger.getLogger(MeusClientesController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    @FXML
    void sairButtonAction(ActionEvent event){
       try {
                 nova= FXMLLoader.load(getClass().getResource("/Viw/Login.fxml"));
            Main.trocarTela(nova);
            } catch (IOException ex) {
                Logger.getLogger(MeusClientesController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    @FXML
    void buscarButtonAction(ActionEvent event){
        //é aqui romulo
    }
    @FXML
    void excluirButtonAction(ActionEvent event){
       
    }
}
