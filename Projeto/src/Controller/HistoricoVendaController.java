package Controller;

import Main.Main;
import Modelo.ModeloUsuario;
import Modelo.Produto;
import Modelo.Venda;
import ModeloConection.ConnectionFactory;
import ModeloDao.VendaDao;
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
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class HistoricoVendaController implements Initializable{
    Venda mod = new Venda();
    VendaDao dao = new VendaDao();
    ConnectionFactory con = new ConnectionFactory();
    private Parent nova;
    @FXML    private TableColumn<Venda, Float> descontoColuna;
    @FXML    private TableColumn<Venda, String> DataVendaCoulna;
    @FXML
    private Button excluirButton;
    @FXML
    private Button enfButton;
    @FXML
    private Button voltarButton;
    @FXML    private TableColumn<Venda, Long> idColuna;
    @FXML    private TableColumn<Venda, ModeloUsuario> clienteColuna;
    @FXML    private TableColumn<Venda, Produto> produtoColuna;
    @FXML    private TableColumn<Venda, Float> precoVendaColuna;
    @FXML
    private Button inicioButton;
    @FXML    private TableView<Venda> historicoTableView;
    @FXML
    private Button sairButton;
    @FXML    private TableColumn<Venda, Float> pagamentoColuna;
    private Venda selecionada; 
    ObservableList<Venda> vendas = FXCollections.observableArrayList();
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
        deletar();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initTable();
    }
       public ObservableList<Venda> atualizaTabela(){
           vendas = FXCollections.observableArrayList(dao.getList());
           return vendas;
        }
    public void initTable(){
        idColuna.setCellValueFactory(new PropertyValueFactory("id"));
        precoVendaColuna.setCellValueFactory(new PropertyValueFactory("precovenda"));
        descontoColuna.setCellValueFactory(new PropertyValueFactory("descontovenda"));
        pagamentoColuna.setCellValueFactory(new PropertyValueFactory("formapagamento"));
        DataVendaCoulna.setCellValueFactory(new PropertyValueFactory("datavenda"));
        produtoColuna.setCellValueFactory(new PropertyValueFactory("id_prod"));
        clienteColuna.setCellValueFactory(new PropertyValueFactory("id_cli"));
        historicoTableView.setItems(atualizaTabela());
    }
     public void deletar(){
            if(selecionada != null){
                VendaDao dao = new VendaDao();
                dao.delete(selecionada);
                Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                a.setHeaderText("Cliente deletado com sucesso");
                a.show();
                historicoTableView.setItems(atualizaTabela());
            }else{
                Alert a = new Alert(Alert.AlertType.WARNING);
                a.setHeaderText("Selecione um cliente");
                a.show();
            }
        }
}
