package Controller;

import Main.Main;
import Modelo.ListarCliente;
import Modelo.ModeloUsuario;
import ModeloConection.ConnectionFactory;
import ModeloDao.UsuarioDao;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;


public class MeusClientesController implements Initializable{
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
    
    @FXML    private TableView<ModeloUsuario> tableView;
    @FXML    private TableColumn<ModeloUsuario, Long> idTb;
    @FXML    private TableColumn<ModeloUsuario, String> cpfTb;
    @FXML    private TableColumn<ModeloUsuario, String> telefoneTb;
    @FXML    private TableColumn<ModeloUsuario, String> nomeTb;
    @FXML    private TableColumn<ModeloUsuario, String> observaTb;
    @FXML    private TableColumn<ModeloUsuario, String> enderecoTb;
    private ModeloUsuario selecionada;
    
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initTable();
        
        atualizarButton.setOnMouseClicked((MouseEvent e ) -> {
            tableView.setItems(atualizaTabela());
        });
        
        excluirButton.setOnMouseClicked((MouseEvent e ) -> {
            deletar();
        });
        
        tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                selecionada = (ModeloUsuario) newValue;
            }
        });
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
    }
    @FXML
    void excluirButtonAction(ActionEvent event){
        deletar();
    }
    @FXML
    void atualizarButtonAction(ActionEvent event){
       //é aqui romulo
    }
    public void initTable(){
        idTb.setCellValueFactory(new PropertyValueFactory("cod"));
        nomeTb.setCellValueFactory(new PropertyValueFactory("nome"));
        cpfTb.setCellValueFactory(new PropertyValueFactory("cpf"));
        telefoneTb.setCellValueFactory(new PropertyValueFactory("telefone"));
        enderecoTb.setCellValueFactory(new PropertyValueFactory("endereco"));
        tableView.setItems(atualizaTabela());
    }
    public ObservableList<ModeloUsuario> atualizaTabela(){
       UsuarioDao dao = new UsuarioDao();
       return FXCollections.observableArrayList(dao.getList());
    }
        public void listaUsuario(){
        ListarCliente p = new ListarCliente();
        try{
            p.start(new Stage());
        }catch(Exception ex){
            Logger.getLogger(MeusClientesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        public void fecha(){
            ListarCliente.getStage().close();
        }
        public void deletar(){
            if(selecionada != null){
                UsuarioDao dao = new UsuarioDao();
                dao.delete(selecionada);
                Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                a.setHeaderText("Cliente deletado com sucesso");
                a.show();
                tableView.setItems(atualizaTabela());
            }else{
                Alert a = new Alert(Alert.AlertType.WARNING);
                a.setHeaderText("Selecione um cliente");
                a.show();
            }
        }
}
