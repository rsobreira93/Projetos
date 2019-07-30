package Controller;

import Modelo.Cliente;
import ModeloDao.ClienteDAO;
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
    private TableView<Cliente> tableView;
    @FXML
    private TableColumn<Cliente, Long> idTb;
     @FXML
    private TableColumn<Cliente, String> cpfTb;
    @FXML
    private TableColumn<Cliente, String> telefoneTb;
    @FXML
    private TableColumn<Cliente, String> nomeTb;
    @FXML
    private TableColumn<Cliente, String> observaTb;
    @FXML
    private TableColumn<Cliente, String> enderecoTb;
    
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
    public ObservableList<Cliente> atualizaLista(){
       ClienteDAO dao = new ClienteDAO();
       return FXCollections.observableArrayList(dao.getList());
    }
}
