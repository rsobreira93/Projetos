package Controller;

import Modelo.ModeloUsuario;
import ModeloDao.UsuarioDao;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 *
 * @author Romulo Sobreira
 */
public class ListarClientes implements Initializable {
    @FXML
    private TableView<ModeloUsuario> tableView;
    @FXML
    private TableColumn<ModeloUsuario, Long> idTb;
     @FXML
    private TableColumn<ModeloUsuario, String> cpfTb;
    @FXML
    private TableColumn<ModeloUsuario, String> telefoneTb;
    @FXML
    private TableColumn<ModeloUsuario, String> nomeTb;
    @FXML
    private TableColumn<ModeloUsuario, String> observaTb;
    @FXML
    private TableColumn<ModeloUsuario, String> enderecoTb;
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       initable();
    }
    
    public void initable(){
        idTb.setCellValueFactory(new PropertyValueFactory("cod"));
        nomeTb.setCellValueFactory(new PropertyValueFactory("nome"));
        telefoneTb.setCellValueFactory(new PropertyValueFactory("telefone"));
        cpfTb.setCellValueFactory(new PropertyValueFactory("cpf"));
        enderecoTb.setCellFactory(new PropertyValueFactory("endereco"));
        observaTb.setCellFactory(new PropertyValueFactory("observacao"));
        tableView.setItems(atualizaLista());
    }
    public ObservableList<ModeloUsuario> atualizaLista(){
       UsuarioDao dao = new UsuarioDao();
       return FXCollections.observableArrayList(dao.getList());
    }
}
