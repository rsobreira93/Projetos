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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class GerenciamentoVendasController{   
    private Parent nova;
    @FXML
    private TextField pagamentoTextField;

    @FXML
    private ImageView inicioImg1;

    @FXML
    private ComboBox<?> idClienteComboBox1;

    @FXML
    private DatePicker dataVendaDatePicker;

    @FXML
    private Button enfButton;

    @FXML
    private Button voltarButton;

    @FXML
    private TextField descontoTextField;

    @FXML
    private ComboBox<?> referenciaProdutoComboBox;

    @FXML
    private Button registrarVendaButton;

    @FXML
    private Button historicoButton;

    @FXML
    private TextField precoVendaTextField;

    @FXML
    private Button inicioButton;

    @FXML
    private Button sairButton;
    @FXML
    void sairButtonAction(ActionEvent event) {
        int op = Main.telaAlerta(); 
        if(op==1){
            try {
                 nova= FXMLLoader.load(getClass().getResource("/View/Login.fxml"));
            Main.trocarTela(nova);
            } catch (IOException ex) {
                Logger.getLogger(GerenciamentoVendasController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    @FXML
    void voltarButtonAction(ActionEvent event) {
       int op = Main.telaAlerta(); 
        if(op==1){
            try {
                 nova= FXMLLoader.load(getClass().getResource("/View/MenuPrincipal.fxml"));
            Main.trocarTela(nova);
            } catch (IOException ex) {
                Logger.getLogger(GerenciamentoVendasController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    @FXML
    void inicioButtonAction(ActionEvent event) {
        int op = Main.telaAlerta(); 
        if(op==1){
            try {
                 nova= FXMLLoader.load(getClass().getResource("/View/MenuPrincipal.fxml"));
            Main.trocarTela(nova);
            } catch (IOException ex) {
                Logger.getLogger(GerenciamentoVendasController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
     @FXML
    void registrarVendaButtonAction(ActionEvent event) {
        //aqui romulo
    }
    @FXML
    void historicoButtonAction(ActionEvent event) {
        try {
                 nova= FXMLLoader.load(getClass().getResource("/View/HistoricoVenda.fxml"));
            Main.trocarTela(nova);
            } catch (IOException ex) {
                Logger.getLogger(GerenciamentoVendasController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
