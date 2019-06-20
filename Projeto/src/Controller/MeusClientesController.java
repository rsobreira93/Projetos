package Controller;

import Main.Main;
import Modelo.ModeloUsuario;
import ModeloConection.ConnectionFactory;
import ModeloDao.UsuarioDao;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;


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
    @FXML    private TableView<ModeloUsuario> meusClientestableView;
    @FXML    private TableColumn<ModeloUsuario, Long> codClientestableView;
    @FXML    private TableColumn<ModeloUsuario, String> nomeClientestableView;
    @FXML    private TableColumn<ModeloUsuario, String> tefefoneClientestableView;
    @FXML    private TableColumn<ModeloUsuario, String> emailClientestableView;
    @FXML    private TableColumn<ModeloUsuario, String> cpfClientestableView;
    @FXML    private TableColumn<ModeloUsuario, String> enderecoClientestableView;
    @FXML    private TableColumn<ModeloUsuario, String> obsClientestableView;
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
   public void initialize(URL url, ResourceBundle rb){
        initable();
   }
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
       /*mod.setPesquisa(buscarTextField.getText());
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
    }
    @FXML
    void excluirButtonAction(ActionEvent event){
       //é aqui romulo
    }
    @FXML
    void atualizarButtonAction(ActionEvent event){
       //é aqui romulo
    }
    public void initable(){
        codClientestableView.setCellValueFactory(new PropertyValueFactory("id"));
        nomeClientestableView.setCellValueFactory(new PropertyValueFactory("nome"));
        tefefoneClientestableView.setCellValueFactory(new PropertyValueFactory("telefon"));
        cpfClientestableView.setCellValueFactory(new PropertyValueFactory("cpf"));
        emailClientestableView.setCellValueFactory(new PropertyValueFactory("email"));  
        enderecoClientestableView.setCellValueFactory(new PropertyValueFactory("endereco"));
        obsClientestableView.setCellFactory(new PropertyValueFactory("observa"));
        meusClientestableView.setItems(atualizaTabela());
    }
    public ObservableList<ModeloUsuario> atualizaTabela(){
       UsuarioDao dao = new UsuarioDao();
       return FXCollections.observableArrayList(dao.getList());
    }
}
