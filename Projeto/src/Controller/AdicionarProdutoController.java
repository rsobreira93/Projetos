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

public class AdicionarProdutoController{
    private Parent nova;
    @FXML
    private ImageView inicioImg;

    @FXML
    private TextField quantTextField;

    @FXML
    private TextField nomeProdutoTextField;

    @FXML
    private TextField pVendaTextField;

    @FXML
    private TextField pCustoTextField;

    @FXML
    private Button inicioButton;

    @FXML
    private Button inserirEstoqueButton;

    @FXML
    private Button enfButton;

    @FXML
    private Button voltarButton;

    @FXML
    private Button sairButton;

    @FXML
    private TextArea obsProdutoTextField;

    @FXML
    private TextField referenciaTextField;
    
    @FXML
    void sairButtonAction(ActionEvent event){
        int op= Main.telaAlerta();
       if(op==1){
       try {
            nova= FXMLLoader.load(getClass().getResource("/View/Login.fxml"));
            Main.trocarTela(nova);
            } catch (IOException ex) {
                Logger.getLogger(AdicionarProdutoController.class.getName()).log(Level.SEVERE, null, ex);
            }
       }
    }
    @FXML
    void inicioButtonAction(ActionEvent event){
        int op= Main.telaAlerta();
        if(op==1){
            try {
                 nova= FXMLLoader.load(getClass().getResource("/View/MenuPrincipal.fxml"));
            Main.trocarTela(nova);
            } catch (IOException ex) {
                Logger.getLogger(AdicionarProdutoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    @FXML
    void voltarButtonAction(ActionEvent event){
          int op= Main.telaAlerta();
          if(op==1){
            try {
            nova= FXMLLoader.load(getClass().getResource("/View/GerenciamentoProduto.fxml"));
            Main.trocarTela(nova);
            } catch (IOException ex) {
                Logger.getLogger(AdicionarProdutoController.class.getName()).log(Level.SEVERE, null, ex);
            }
          }
    }
    @FXML
    void inserirEstoqueButtonAction (ActionEvent event){
            // é aqui romulo
    }
}
