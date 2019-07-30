package Controller;

import Main.Main;
import Modelo.ModeloUsuario;
import ModeloConection.ConnectionFactory;
import ModeloDao.UsuarioDao;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javafx.application.Application.launch;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;


public class MeusClientesController{
    ModeloUsuario mod = new ModeloUsuario();
    UsuarioDao control = new UsuarioDao();
    ConnectionFactory conex = new ConnectionFactory();
    
    private Parent nova;
    @FXML
    private TextField buscarTextField;
    @FXML
    private Button excluirButton;
    @FXML
    private Button inicioButton;
<<<<<<< HEAD:Projetos-master/Projeto/src/Controller/MeusClientesController.java
   
  
    @FXML
    private ListView<ModeloUsuario> listeView;
    
=======
>>>>>>> feeae37dcc6f75b0720c1c261fa986c8ba917e98:Projeto/src/Controller/MeusClientesController.java
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
    
<<<<<<< HEAD:Projetos-master/Projeto/src/Controller/MeusClientesController.java
    
  public void initialize(URL url, ResourceBundle rb){
        initable();
   }
=======
>>>>>>> feeae37dcc6f75b0720c1c261fa986c8ba917e98:Projeto/src/Controller/MeusClientesController.java
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
      /* mod.setPesquisa(buscarTextField.getText());
       ModeloUsuario model = control.buscaCliente(mod);
       mod.setNome(model.getNome());
       mod.setTelefone(model.getTelefone());
       mod.setCpf(model.getCpf());
       mod.setEmail(model.getEmail());
       mod.setCidade(model.getCidade());
       mod.setBairro(model.getBairro());
       mod.setComplemento(model.getComplemento());
       mod.setEndereco(model.getEndereco());
       mod.setN(model.getN());*/
       listaUsuario();
    }
    @FXML
    void excluirButtonAction(ActionEvent event){
       //é aqui romulo
    }
    @FXML
    void atualizarButtonAction(ActionEvent event){
       //é aqui romulo
    }
    
    public void listaUsuario(){
        System.out.println("Listando Clientes");
        List<ModeloUsuario> clientes =  new UsuarioDao().getList();
        for(int x = 0; x < clientes.size(); x++){
            clientes.get(x).mostraUsuario();
        }
    }
}
