package Controller;

import Main.Main;
import Modelo.Produto;
import ModeloConection.ConnectionFactory;
import ModeloDao.ProdutoDao;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
/**
 * Calasse resposável por adicionar um produto no banco de dados
 * @author Romulo Sobreira
 */
public class AdicionarProdutoController implements Initializable{
    
    Produto mod = new Produto();
    ProdutoDao dao = new ProdutoDao();
    ConnectionFactory con = new ConnectionFactory();
    
    private Parent nova;
    @FXML
    private TextField dataTextField;
    
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
    
    @FXML    private ImageView imageFoto;
    private String caminhaFoto;
    
     @Override
    public void initialize(URL location, ResourceBundle resources) {
        imageFoto.setOnMouseClicked((MouseEvent e ) -> {
            selecionaFoto();
        });
    }
    @FXML
    void sairButtonAction(ActionEvent event){
        //int op= Main.telaAlerta();
       //if(op==1){
       if(nomeProdutoTextField.getText().isEmpty() &&
               pVendaTextField.getText().isEmpty() &&
               pCustoTextField.getText().isEmpty() &&
               referenciaTextField.getText().isEmpty() &&
               quantTextField.getText().isEmpty() &&
               obsProdutoTextField.getText().isEmpty() &&
               dataTextField.getText().isEmpty()
               ){
       try {
            nova= FXMLLoader.load(getClass().getResource("/View/Login.fxml"));
            Main.trocarTela(nova);
            } catch (IOException ex) {
                Logger.getLogger(AdicionarProdutoController.class.getName()).log(Level.SEVERE, null, ex);
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
    void inicioButtonAction(ActionEvent event){
        //int op= Main.telaAlerta();
        //if(op==1){
        if(nomeProdutoTextField.getText().isEmpty() &&
               pVendaTextField.getText().isEmpty() &&
               pCustoTextField.getText().isEmpty() &&
               referenciaTextField.getText().isEmpty() &&
               quantTextField.getText().isEmpty() &&
               obsProdutoTextField.getText().isEmpty() &&
               dataTextField.getText().isEmpty()
               ){
            try {
                 nova= FXMLLoader.load(getClass().getResource("/View/MenuPrincipal.fxml"));
            Main.trocarTela(nova);
            } catch (IOException ex) {
                Logger.getLogger(AdicionarProdutoController.class.getName()).log(Level.SEVERE, null, ex);
            }
       }else{
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
    void voltarButtonAction(ActionEvent event){
          //int op= Main.telaAlerta();
          //if(op==1){
          if(nomeProdutoTextField.getText().isEmpty() &&
               pVendaTextField.getText().isEmpty() &&
               pCustoTextField.getText().isEmpty() &&
               referenciaTextField.getText().isEmpty() &&
               quantTextField.getText().isEmpty() &&
               obsProdutoTextField.getText().isEmpty() &&
               dataTextField.getText().isEmpty()
               ){
            try {
            nova= FXMLLoader.load(getClass().getResource("/View/GerenciamentoProduto.fxml"));
            Main.trocarTela(nova);
            } catch (IOException ex) {
                Logger.getLogger(AdicionarProdutoController.class.getName()).log(Level.SEVERE, null, ex);
            }
          }else{
              Alert confirmacao = new Alert(Alert.AlertType.CONFIRMATION);
            confirmacao.setTitle("Aviso");
            confirmacao.setContentText("Deseja sair sem concluir o cadastro?");
            Optional<ButtonType> result = confirmacao.showAndWait();
            if(result.get() == ButtonType.OK){
               try {
                    nova= FXMLLoader.load(getClass().getResource("/View/GerenciamentoProduto.fxml"));
                     Main.trocarTela(nova);
                } catch (IOException ex) {
                    Logger.getLogger(GerenciamentoClienteController.class.getName()).log(Level.SEVERE, null, ex);
                }  
            }
          }
    }
    @FXML
    void inserirEstoqueButtonAction (ActionEvent event) throws IOException{
            if(nomeProdutoTextField.getText().isEmpty() ||
               pVendaTextField.getText().isEmpty() ||
               pCustoTextField.getText().isEmpty() ||
               referenciaTextField.getText().isEmpty() ||
               quantTextField.getText().isEmpty()
               ){
               JOptionPane.showMessageDialog(null, "Todos os campos obrigatórios devem ser preenchidos");
            }else{
                mod.setReferenciaProduto(Integer.parseInt(referenciaTextField.getText()));
                mod.setNomeProduto(nomeProdutoTextField.getText());
                mod.setPrecoVenda(Float.parseFloat(pVendaTextField.getText()));
                mod.setPrecoCusto(Float.parseFloat(pCustoTextField.getText()));
                mod.setQuantidadeProduto(Integer.parseInt(quantTextField.getText()));
                mod.setObservacao(obsProdutoTextField.getText());
                mod.setFoto(caminhaFoto);
                dao.add(mod);
                nova= FXMLLoader.load(getClass().getResource("/View/AdicionarProduto.fxml"));
                Main.trocarTela(nova);
            }
    }    
    public void selecionaFoto(){
        FileChooser f = new FileChooser();
        f.getExtensionFilters().add(new FileChooser.ExtensionFilter("Imagens","*.jpg","*.jpeg","*.png"));
        File file = f.showOpenDialog(new Stage());
        
        if(file != null){
            imageFoto.setImage(new Image("file:///"+file.getAbsolutePath()));
            caminhaFoto = file.getAbsolutePath();
        }
    }
}
