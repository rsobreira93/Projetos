package Controller;

import Auxiliares.ListaAdministrador;
import Main.Main;
import Modelo.Administrador;
import Modelo.ModeloUsuario;
import ModeloDao.AdministradorDao;
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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class ContaUserController implements Initializable{
    private Parent nova;
    @FXML
    private TextField buscarTextField;
    @FXML
    private Button excluirButton;
    @FXML    private TableView<Administrador> tableView;
    @FXML    private TableColumn<Administrador, String> emailTableColumn;
    @FXML    private TableColumn<Administrador, String> loginTableColumn;
    @FXML
    private PasswordField novaSenhaPasswordField;
    @FXML
    private Button atualizarButton;
    @FXML
    private Button enfButton;
    @FXML
    private Button voltarButton;
    @FXML
    private Button inicioButton;
    @FXML
    private TextField novoLoginTextField;
    @FXML
    private Button sairButton;
    @FXML
    private Button buscarButton;
    private boolean confirmacao=false;
    
    private Administrador selecionada; 
    ObservableList<Administrador> admins = FXCollections.observableArrayList();
        
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initTable();
        
        atualizarButton.setOnMouseClicked((MouseEvent e ) -> {
            tableView.setItems(atualizaTabela());
        });
        
        excluirButton.setOnMouseClicked((MouseEvent e ) -> {
            deletar();
        });
       
        tableView.getSelectionModel().selectedItemProperty().addListener(
        (observable, oldValue, newValue) -> mostrarDados((newValue))); 
        tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                selecionada = (Administrador) newValue;
            }
        });
    }
    @FXML
    void sairButtonAction(ActionEvent event){
       try {
            nova= FXMLLoader.load(getClass().getResource("/View/Login.fxml"));
            Main.trocarTela(nova);
            } catch (IOException ex) {
                Logger.getLogger(ContaUserController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    @FXML
    void inicioButtonAction(ActionEvent event){
            try {
                 nova= FXMLLoader.load(getClass().getResource("/View/MenuPrincipal.fxml"));
            Main.trocarTela(nova);
            } catch (IOException ex) {
                Logger.getLogger(ContaUserController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public void listaUsuario(){
        ListaAdministrador p = new ListaAdministrador();
        try{
            p.start(new Stage());
        }catch(Exception ex){
            Logger.getLogger(ContaUserController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @FXML
    void voltarButtonAction(ActionEvent event){
            try {
            nova= FXMLLoader.load(getClass().getResource("/View/MenuPrincipal.fxml"));
            Main.trocarTela(nova);
            } catch (IOException ex) {
                Logger.getLogger(ContaUserController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    @FXML
    void excluirButtonAction(ActionEvent event){
        deletar();
    }
    @FXML
    void atualizarButtonAction(ActionEvent event){
        if(selecionada != null){
                AdministradorDao dao = new AdministradorDao();
                //novoLoginTextField.setText(selecionada.getLogin());
                //novaSenhaPasswordField.setText(selecionada.getSenha());
                selecionada.setLogin(novoLoginTextField.getText());
                selecionada.setSenha(novaSenhaPasswordField.getText());
                dao.update(selecionada);
                tableView.setItems(atualizaTabela());
            }else{
                Alert a = new Alert(Alert.AlertType.WARNING);
                a.setHeaderText("Selecione um Administrador");
                a.show();
            }
    }
    @FXML
    void buscarButtonAction(ActionEvent event){
        if(buscarTextField.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Informe um usuário");
        }else{
        tableView.setItems(busca());
        }
    }
    public void initTable(){
        loginTableColumn.setCellValueFactory(new PropertyValueFactory("login"));
        emailTableColumn.setCellValueFactory(new PropertyValueFactory("email"));
        tableView.setItems(atualizaTabela());
    }
    public ObservableList<Administrador> atualizaTabela(){
       AdministradorDao dao = new AdministradorDao();
       admins = FXCollections.observableArrayList(dao.getList());
       return  admins;
    }
    public void deletar(){
            if(selecionada != null){
                AdministradorDao dao = new AdministradorDao();
                dao.delete(selecionada);
                Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                a.setHeaderText("Administrador deletado com sucesso");
                a.show();
                tableView.setItems(atualizaTabela());
            }else{
                Alert a = new Alert(Alert.AlertType.WARNING);
                a.setHeaderText("Selecione um Administrador");
                a.show();
            }
        }
        private ObservableList<Administrador> busca(){
            ObservableList<Administrador> pesquisa = FXCollections.observableArrayList();
            for(int x = 0; x < admins.size(); x++){
                if(admins.get(x).getLogin().toLowerCase().contains(buscarTextField.getText().toLowerCase())){
                    pesquisa.add(admins.get(x));
                }
            }
            return pesquisa;
        }
        public void mostrarDados(Administrador adm){
            novoLoginTextField.setText(adm.getLogin());
            novaSenhaPasswordField.setText(adm.getSenha());
        }
    
}
