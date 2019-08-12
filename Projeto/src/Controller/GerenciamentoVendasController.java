package Controller;

import Main.Main;
import Modelo.Cliente;
import Modelo.Produto;
import Modelo.Venda;
import ModeloConection.ConnectionFactory;
import ModeloDao.ProdutoDao;
import ModeloDao.ClienteDAO;
import ModeloDao.VendaDao;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
/**
 * Calsse responsavel por implementar parte do gerenciamento de vendas
 * a outra parte está em gerenciamento de vendas 2
 * @author Romulo Sobreira
 */
public class GerenciamentoVendasController implements Initializable{  
    Cliente mod = new Cliente();
    Venda v = new Venda();
    Produto p = new Produto();
    ConnectionFactory con = new ConnectionFactory();
    ClienteDAO dao = new ClienteDAO();
    ProdutoDao d = new ProdutoDao();
    private Parent nova;
    
    @FXML
    private Button carrinhoButton;         
    @FXML
    private TextField pagamentoTextField;
    @FXML
    private ComboBox<Cliente> idClienteComboBox1;

    @FXML
    private DatePicker dataVendaDatePicker;

    @FXML
    private Button enfButton;

    @FXML
    private Button voltarButton;

    @FXML
    private TextField descontoTextField;

    @FXML
    private ComboBox<Produto> referenciaProdutoComboBox;

    @FXML
    private Button registrarVendaButton;

    @FXML
    private Button historicoButton;

    @FXML
    private TextField precoVendaTextField;

    @FXML
    private Button inicioButton;

    @FXML
    private Button sairButton;
    
    private List<Cliente> clientes = new ArrayList<>();
    private ObservableList<Cliente> obsclientes;
    private List<Produto> produtos = new ArrayList<>();
    private ObservableList<Produto> obsproduto;
    
    Venda venda = new Venda();
    VendaDao vd = new VendaDao();
    
    @FXML
    void sairButtonAction(ActionEvent event) {
        int op = Main.telaAlerta(); 
        if(op==1){
            try {
                 nova= FXMLLoader.load(getClass().getResource("/View/Login.fxml"));
            Main.trocarTela(nova);
            } catch (IOException ex) {
                Logger.getLogger(GerenciamentoVendasController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    @FXML
    void voltarButtonAction(ActionEvent event) {
       int op = Main.telaAlerta(); 
        if(op==1){
            try {
                 nova= FXMLLoader.load(getClass().getResource("/View/MenuPrincipal.fxml"));
            Main.trocarTela(nova);
            } catch (IOException ex) {
                Logger.getLogger(GerenciamentoVendasController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    @FXML
    void inicioButtonAction(ActionEvent event) {
        int op = Main.telaAlerta(); 
        if(op==1){
            try {
                 nova= FXMLLoader.load(getClass().getResource("/View/MenuPrincipal.fxml"));
            Main.trocarTela(nova);
            } catch (IOException ex) {
                Logger.getLogger(GerenciamentoVendasController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
     @FXML
    void registrarVendaButtonAction(ActionEvent event) {
        Cliente client = idClienteComboBox1.getSelectionModel().getSelectedItem();
        Produto prod = referenciaProdutoComboBox.getSelectionModel().getSelectedItem();
        
        //venda.setPrecoVenda(Float.parseFloat(precoVendaTextField.getText()));
       // venda.setFormaPagamento(Boolean.parseBoolean(pagamentoTextField.getText()));
       // //venda.setCodVenda(Integer.parseInt(descontoTextField.getText()));
       // venda.setProdutoVendido(prod);
       // venda.setCliente(client);
       // vd.add(venda);
    }
    @FXML
    void historicoButtonAction(ActionEvent event) {
        try {
                 nova= FXMLLoader.load(getClass().getResource("/View/HistoricoVenda.fxml"));
            Main.trocarTela(nova);
            } catch (IOException ex) {
                Logger.getLogger(GerenciamentoVendasController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        comboBoxCliente();
        comboBoxProduto();
    }
    
    public void comboBoxCliente(){
        clientes = dao.getList();
        obsclientes = FXCollections.observableArrayList(clientes);
        
        idClienteComboBox1.setItems(obsclientes);
    }
    public void comboBoxProduto(){
        produtos = d.getList();
        obsproduto = FXCollections.observableArrayList(produtos);
        
        referenciaProdutoComboBox.setItems(obsproduto);
    }

}
