package Controller;
import Main.Main;
import Modelo.Vendedor;
import ModeloConection.ConnectionFactory;
import ModeloDao.VendedorDAO;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;

public class NovoUserController{
   Vendedor vendedor = new Vendedor();
   Vendedor mod = new Vendedor();
   VendedorDAO dao = new VendedorDAO();
   ConnectionFactory con = new ConnectionFactory();
    
    private Parent nova;
    @FXML
    private TextField NovoLoginTextField1;
    @FXML
    private Button ButtonCadastrar;
    @FXML
    private PasswordField NovaSenhaPassawordField;
    @FXML
    private Button ButtonCancelar;
    @FXML
    private TextField EmailTextField;
    @FXML
    void ButtonCancelarAction(ActionEvent event){
        try {
                 nova= FXMLLoader.load(getClass().getResource("/View/Login.fxml"));
                 Main.trocarTela(nova);
            } catch (IOException ex) {
                Logger.getLogger(NovoUserController.class.getName()).log(Level.SEVERE, null, ex);
            } 
    } 
    @FXML
    void ButtonCadastrarAction(ActionEvent event){
        if(NovoLoginTextField1.getText().isEmpty() || EmailTextField.getText().isEmpty() || NovoLoginTextField1.getText().isEmpty()){
                JOptionPane.showMessageDialog(null, "Todos os campos são obrigatórios");
        }else{
              int x;
               List<Vendedor> administrador = dao.getList();
               for(x=0; x< administrador.size();x++){
                 if(NovoLoginTextField1.getText().equals(administrador.get(x).getLogin()) || EmailTextField.getText().equals(administrador.get(x).getEmail())){
                    x= administrador.size();
                     JOptionPane.showMessageDialog(null, "Login ou e-mail já percetem a algum usuário já cadastrado");
                  }else {
                   if(x == administrador.size()-1){
                       mod.setLogin(NovoLoginTextField1.getText());
                       mod.setEmail(EmailTextField.getText());
                       mod.setSenha(NovaSenhaPassawordField.getText());
                       dao.add(mod);
                   }
                 }
               }
               if(administrador == null){
                       mod.setLogin(NovoLoginTextField1.getText());
                       mod.setEmail(EmailTextField.getText());
                       mod.setSenha(NovaSenhaPassawordField.getText());
                       dao.add(mod);
                  }
    }
   }
}
               

        

