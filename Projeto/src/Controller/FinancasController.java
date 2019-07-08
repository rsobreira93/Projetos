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
import javafx.scene.control.DatePicker;
import javafx.scene.image.ImageView;
public class FinancasController{
    private Parent nova;
@FXML
    private ImageView inicioImg1;

    @FXML
    private DatePicker InicioPeriodo;

    @FXML
    private Button GerarButton;

    @FXML
    private Button inicioButton;

    @FXML
    private Button enfButton;

    @FXML
    private Button sairButton;

    @FXML
    private Button voltarButton;

    @FXML
    private DatePicker FimPeriodo;

    @FXML
    void sairButtonAction(ActionEvent event) {
        try {
            nova= FXMLLoader.load(getClass().getResource("/View/Login.fxml"));
            Main.trocarTela(nova);
            } catch (IOException ex) {
                Logger.getLogger(FinancasController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    @FXML
    void voltarButtonAction(ActionEvent event){
        try {
            nova= FXMLLoader.load(getClass().getResource("/View/MenuPrincipal.fxml"));
            Main.trocarTela(nova);
            } catch (IOException ex) {
                Logger.getLogger(FinancasController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    @FXML
    void inicioButtonAction(ActionEvent event){
        try {
            nova= FXMLLoader.load(getClass().getResource("/View/MenuPrincipal.fxml"));
            Main.trocarTela(nova);
            } catch (IOException ex) {
                Logger.getLogger(FinancasController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    @FXML
    void GerarButtonAction(ActionEvent event) {

    }

     
    
}
