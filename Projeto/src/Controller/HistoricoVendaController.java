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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;

public class HistoricoVendaController{
    private Parent nova;
    @FXML
    private TableColumn<?, ?> descontoColuna;
    @FXML
    private ImageView inicioImg1;
    @FXML
    private TableColumn<?, ?> DataVendaCoulna;
    @FXML
    private Button excluirButton;
    @FXML
    private Button enfButton;
    @FXML
    private Button voltarButton;
    @FXML
    private TableColumn<?, ?> idColuna;
    @FXML
    private TableColumn<?, ?> clienteColuna;
    @FXML
    private TableColumn<?, ?> produtoColuna;
    @FXML
    private TableColumn<?, ?> precoVendaColuna;
    @FXML
    private Button inicioButton;
    @FXML
    private TableView<?> historicoTableView;
    @FXML
    private Button sairButton;
    @FXML
    private TableColumn<?, ?> pagamentoColuna;
    @FXML
    void sairButtonAction(ActionEvent event){
       
            try {
                nova= FXMLLoader.load(getClass().getResource("/View/Login.fxml"));
                 Main.trocarTela(nova);
            } catch (IOException ex) {
                Logger.getLogger(HistoricoVendaController.class.getName()).log(Level.SEVERE, null, ex);
            }        
    }   
    @FXML
    void voltarButtonAction(ActionEvent event){
            try {
                 nova= FXMLLoader.load(getClass().getResource("/View/GerenciamentoVendas.fxml"));
            Main.trocarTela(nova);
            } catch (IOException ex) {
                Logger.getLogger(HistoricoVendaController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    @FXML
    void inicioButtonAction(ActionEvent event){
            try {
                 nova= FXMLLoader.load(getClass().getResource("/View/MenuPrincipal.fxml"));
            Main.trocarTela(nova);
            } catch (IOException ex) {
                Logger.getLogger(HistoricoVendaController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    @FXML
    void excluirButtonAction(ActionEvent event){
        // aqui romulo
    }
}
