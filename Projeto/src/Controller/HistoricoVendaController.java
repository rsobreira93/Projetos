package Controller;

import Main.Main;
import Modelo.Venda;
import ModeloConection.ConnectionFactory;
import ModeloDao.VendaDao;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
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
import javafx.scene.image.ImageView;
/**
 * Classe responsavel por implementar uma tableview do historico de compras 
 * @author Romulo Sobreira
 */
public class HistoricoVendaController implements Initializable{
    Venda mod = new Venda();
    VendaDao dao = new VendaDao();
    ConnectionFactory con = new ConnectionFactory();
    private Parent nova;
     @FXML
    private ImageView inicioImg1;
    @FXML
    private Button excluirButton;

    @FXML
    private Button inicioButton;

    @FXML
    private Button enfButton;

    @FXML
    private Button voltarButton;

    @FXML
    private Button sairButton;

    @FXML private TableView<Venda> historicoTableView;
    @FXML private TableColumn<Venda, String> clienteColuna;
    @FXML private TableColumn<Venda, String> produtoColuna;
    @FXML private TableColumn<Venda, String> dataVendaCoulna;
    @FXML private TableColumn<Venda, Float> precoVendaCoulna;
    @FXML private TableColumn<Venda, Integer> quantidadeColuna;
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
                 nova= FXMLLoader.load(getClass().getResource("/View/GerenciamentoVendas2.fxml"));
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
    void excluirButtonAction(ActionEvent event) throws SQLException{
        deletar();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        try {
            initTable();
        } catch (SQLException ex) {
            Logger.getLogger(HistoricoVendaController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
       public ObservableList<Venda> atualizaTabela() throws SQLException{
         vendas = FXCollections.observableArrayList(dao.getList2());
         return vendas;
        }
    public void initTable() throws SQLException{
        
        produtoColuna.setCellValueFactory(new PropertyValueFactory("nomeProduto"));
        clienteColuna.setCellValueFactory(new PropertyValueFactory("nomeCliente"));
        precoVendaCoulna.setCellValueFactory(new PropertyValueFactory("valorVenda"));
        dataVendaCoulna.setCellValueFactory(new PropertyValueFactory("data"));
        quantidadeColuna.setCellValueFactory(new PropertyValueFactory("qtdItem"));
        historicoTableView.setItems(atualizaTabela());
    }
    /**
     * Metodos responsavel por deleta um compra da tableview
     * @throws SQLException  - caso a venda selecionada seja null não podera ser excluido
     * por falta de selecionamento do mesmo na tableview
     */
     public void deletar() throws SQLException{
            if(selecionada != null){
                VendaDao dao = new VendaDao();
              //  dao.delete(selecionada);
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
