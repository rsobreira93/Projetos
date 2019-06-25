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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class GerenciamentoProdutoController{
    private Parent nova;
    @FXML
    private Label vCustoLabel;
    @FXML
    private Label vVendaLabel;
    @FXML
    private TextField buscarTextField;
    @FXML
    private Button excluirButton;
    @FXML
    private Button addButton;
    @FXML
    private Button buscarButton;
    @FXML
    private Button inicioButton;
    @FXML
    private Button enfButton;
    @FXML
    private Button sairButton;
    @FXML
    private Button voltarButton;
    @FXML
    void sairButtonAction(ActionEvent event){
       try {
            nova= FXMLLoader.load(getClass().getResource("/View/Login.fxml"));
            Main.trocarTela(nova);
            } catch (IOException ex) {
                Logger.getLogger(GerenciamentoClienteController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    @FXML
    void inicioButtonAction(ActionEvent event){
            try {
                 nova= FXMLLoader.load(getClass().getResource("/View/MenuPrincipal.fxml"));
            Main.trocarTela(nova);
            } catch (IOException ex) {
                Logger.getLogger(GerenciamentoClienteController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    @FXML
    void voltarButtonAction(ActionEvent event){
            try {
            nova= FXMLLoader.load(getClass().getResource("/View/MenuPrincipal.fxml"));
            Main.trocarTela(nova);
            } catch (IOException ex) {
                Logger.getLogger(GerenciamentoClienteController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    @FXML
    void addButtonAction(ActionEvent envent){
        try {
                nova= FXMLLoader.load(getClass().getResource("/View/AdicionarProduto.fxml"));
                Main.trocarTela(nova);
            } catch (IOException ex) {
                Logger.getLogger(GerenciamentoClienteController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    @FXML
    void buscarButtonAction(ActionEvent event){
        //é aqui romulo
    }
    @FXML
    void excluirButtonAction(ActionEvent event){
       //é aqui romulo
    }
}
