
package Controller;

import Main.Main;
import ModeloDao.VendasDao;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
public class MenuPrincipalController {
    private Parent nova;
    @FXML
    private Button aClientesButton;
    @FXML
    private Button gProdutosButton;
    @FXML
    private Button financasButton;
    @FXML
    private Button enfButton;
    @FXML
    private Button sairButton;
    @FXML
    private Button contaButton;
    @FXML
    private Button gClientesButton;
    @FXML
    private Button gVendasButton;
    @FXML
    void sairButtonAction(ActionEvent event){
        try {
            nova= FXMLLoader.load(getClass().getResource("/View/Login.fxml"));
            Main.trocarTela(nova);
            } catch (IOException ex) {
                Logger.getLogger(MenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    @FXML
    void gClientesButtonAction(ActionEvent event) {
          try {
                 nova= FXMLLoader.load(getClass().getResource("/View/GerenciamentoCliente.fxml"));
                 Main.trocarTela(nova);
            } catch (IOException ex) {
                Logger.getLogger(MenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    @FXML
    void gProdutosButtonAction(ActionEvent event){
        try {
                 nova= FXMLLoader.load(getClass().getResource("/View/GerenciamentoProduto.fxml"));
                 Main.trocarTela(nova);
            } catch (IOException ex) {
                Logger.getLogger(MenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    @FXML
    void contaButtonAction(ActionEvent envent){
        try {
                 nova= FXMLLoader.load(getClass().getResource("/View/ContaUser.fxml"));
                 Main.trocarTela(nova);
            } catch (IOException ex) {
                Logger.getLogger(MenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    @FXML
    void gVendasButtonAction(ActionEvent event) {
          try {
                 nova= FXMLLoader.load(getClass().getResource("/View/GerenciamentoVendas.fxml"));
                 Main.trocarTela(nova);
            } catch (IOException ex) {
                Logger.getLogger(MenuPrincipalController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    @FXML
    void financasButtonAction(ActionEvent event){
        VendasDao relatorio = new VendasDao();
        relatorio.gerarRelatorio();
    }
}