/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Auxiliares.ListarVenda;
import Main.Main;
import Modelo.Produto;
import Modelo.Venda;
import ModeloConection.ConexaoBD;
import ModeloDao.ProdutoDao;
import ModeloDao.VendaDao;
import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * classe responsavel por gerenciar as vendas
 *
 * @author Romulo Sobreira
 */
public class GerenciamentoVendas2Controller implements Initializable{
    private Parent nova;
    @FXML
    private Button abrirVendaButton;
    @FXML
    private Button cancelarVendaButton;
    @FXML
    private TextField pagamentoTextField;
    @FXML
    private TextField  TotalTextField;

    @FXML
    private TextField nomeProdutoTextField;

    @FXML
    private Button addProdutoButton;

    @FXML
    private ImageView inicioImg1;

    @FXML
    private TextField dataVendaTextField;

    @FXML
    private TextField precoTextField;

    @FXML
    private Button enfButton;

    @FXML
    private Button voltarButton;

    @FXML
    private TextField descontoTextField;

    

    @FXML
    private TextField quantTextField;

    @FXML
    private Button pesquisarProdutoButton;

    @FXML
    private Button historicoButton;

    @FXML
    private Button inicioButton;

    @FXML
    private TextField nomeClienteTextField;

    @FXML
    private Button sairButton;

    @FXML
    private Button finalizarButton;
    private Produto selecionada;
    
    private int idPro;
    
    @FXML private TableView<Produto> produtoTableView;
    @FXML private TableColumn<Produto,Long> id;
    @FXML private TableColumn<Produto, String> nome;
    @FXML private TableColumn<Produto, Long> quantidade;
    
    
     @FXML private TableView<Venda> carrinho;
     @FXML private TableColumn<Venda, String> descrição;
     @FXML private TableColumn<Venda, Integer> quantidade2;
     @FXML private TableColumn<Venda, Float> valorTotal;
     
    private float valorT=0;
    ConexaoBD con = new ConexaoBD();
    Venda mod = new Venda();
    VendaDao vendaDao = new VendaDao();
    ObservableList<Produto> produtos = FXCollections.observableArrayList();
    ObservableList<Venda> vendas = FXCollections.observableArrayList();
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initTable();
        nomeProdutoTextField.setOnKeyReleased((KeyEvent e) ->{
            produtoTableView.setItems(busca());
        });
        
        produtoTableView.getSelectionModel().selectedItemProperty().addListener(
        (observable, oldValue, newValue) -> mostrarDados((newValue)));
        produtoTableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                selecionada = (Produto) newValue;
               
            }
        });
    }
    
    public void initTable(){
        id.setCellValueFactory(new PropertyValueFactory("referenciaProduto"));
        nome.setCellValueFactory(new PropertyValueFactory("nomeProduto"));
        quantidade.setCellValueFactory(new PropertyValueFactory("quantidadeProduto"));
        produtoTableView.setItems(atualizaTabela());
        
    }
    public void initTableCarrinho() throws SQLException{
        descrição.setCellValueFactory(new PropertyValueFactory("nomeProduto"));
        quantidade2.setCellValueFactory(new PropertyValueFactory("qtdItem"));
        valorTotal.setCellValueFactory(new PropertyValueFactory("valorVenda"));
        carrinho.setItems(atualizaTabelaCarrinho());
    }
    public ObservableList<Produto> atualizaTabela(){
       ProdutoDao dao = new ProdutoDao();
       produtos = FXCollections.observableArrayList(dao.getList()); 
       return produtos;
    }
    public ObservableList<Venda> atualizaTabelaCarrinho() throws SQLException{
       VendaDao dao = new VendaDao();
       vendas = FXCollections.observableArrayList(dao.getList()); 
       return vendas;
    }
    private ObservableList<Produto> busca(){
            ObservableList<Produto> produtoPesquisa = FXCollections.observableArrayList();
            for(int x = 0; x < produtos.size(); x++){
                if(produtos.get(x).getNomeProduto().toLowerCase().contains(nomeProdutoTextField.getText().toLowerCase())){
                    produtoPesquisa.add(produtos.get(x));
                }
            }
            return produtoPesquisa;
    }
    
    @FXML
    void addProdutoButtonAction(ActionEvent event) throws SQLException {
         addVenda(); 
         valorT+= Float.parseFloat(precoTextField.getText())*Integer.parseInt(quantTextField.getText());
         TotalTextField.setText(String.valueOf(valorT));
         initTableCarrinho();
    }
    @FXML
    void pesquisarProdutoButtonAction(ActionEvent event) {
           if(nomeProdutoTextField.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Informe um produto");
        }else{
        produtoTableView.setItems(busca());
        }
    }
    /**
     * metodo responsavel por mostrar detalhes da venda como nome do produto
     * @param p - mostrar os dados do produto passado como parametro
     */
    public void mostrarDados(Produto p){
            quantTextField.setText("1");
            precoTextField.setText(String.valueOf(p.getPrecoVenda()));
            nomeProdutoTextField.setText(p.getNomeProduto());
            SimpleDateFormat dataAtual= new SimpleDateFormat("dd/MM/yyy");
            Date hoje = new Date();
            dataVendaTextField.setText(dataAtual.format(hoje));
        }
    /**
     * metodo responsavel por adicionar uma venda no carrinho
     * @throws SQLException - execeções que podem ocrrer caso a quantidade seja maior do que as disponiveis 
     */
    public void  addVenda() throws SQLException{
         mod.setNomeCliente(nomeProdutoTextField.getText());
         mod.setQtdItem(Integer.parseInt(quantTextField.getText()));
         mod.setCodProduto((int) selecionada.getReferenciaProduto());
      int veri =   vendaDao.quantVerifica(selecionada, Integer.parseInt(quantTextField.getText()));
         if(veri==0){
         vendaDao.add(mod);
         initTable();
         }
         else
             JOptionPane.showMessageDialog(null, "Quantidade insuficiente");
         
    }
    /**
     * metodo responsavel por finalizar a venda
     * @throws SQLException - execeções que podem ocrrer caso a quantidade seja maior do que as disponiveis 
     */
    @FXML
    void finalizarButtonButtonAction(ActionEvent event) throws SQLException, Exception {
        mod.setNomeCliente(nomeClienteTextField.getText());
        mod.setNomeProduto(nomeProdutoTextField.getText());
        mod.setData(dataVendaTextField.getText());
        mod.setValorVenda(Float.parseFloat(TotalTextField.getText()));
        vendaDao.FinalizaVenda(mod);
        try {
                 nova= FXMLLoader.load(getClass().getResource("/View/MenuPrincipal.fxml"));
            Main.trocarTela(nova);
                    } catch (IOException ex) {
                Logger.getLogger(GerenciamentoVendasController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    /**
     * metodo responsavel por cancelar a venda
     * @throws SQLException - execeções que podem ocrrer caso a quantidade seja maior do que as disponiveis 
     */
    @FXML
    void cancelarVendaButton(ActionEvent event) throws SQLException, IOException {
            vendaDao.cancelaVenda();
            JOptionPane.showMessageDialog(null, "Venda cancelada com sucesso");
            nova= FXMLLoader.load(getClass().getResource("/View/MenuPrincipal.fxml"));
            Main.trocarTela(nova);
    }
    /**
     * metodo responsavel por abrir uma venda no banco de dados
     * @throws SQLException - execeções que podem ocrrer caso a quantidade seja maior do que as disponiveis 
     */
    @FXML
    void abrirVendaButtonButtonAction(ActionEvent event) throws SQLException {
                 con.conexao();
                 PreparedStatement pst = con.con.prepareStatement("INSERT INTO venda(valor_venda) VALUES(?);");
                 pst.setFloat(1, 0);
                 pst.execute();  
                 JOptionPane.showMessageDialog(null, "Seu carrinho está protno para uso");
    }
    
    @FXML
    void historicoButtonButtonAction(ActionEvent event) {
        try {
                 nova= FXMLLoader.load(getClass().getResource("/View/HistoricoVenda.fxml"));
            Main.trocarTela(nova);
            } catch (IOException ex) {
                Logger.getLogger(GerenciamentoVendasController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    @FXML
    void sairButtonAction(ActionEvent event) {
        //int op = Main.telaAlerta(); 
       // if(op==1){
            try {
                 nova= FXMLLoader.load(getClass().getResource("/View/Login.fxml"));
            Main.trocarTela(nova);
            } catch (IOException ex) {
                Logger.getLogger(GerenciamentoVendasController.class.getName()).log(Level.SEVERE, null, ex);
            }
       // }
    }
    @FXML
    void voltarButtonAction(ActionEvent event) {
       //int op = Main.telaAlerta(); 
       // if(op==1){
            try {
                 nova= FXMLLoader.load(getClass().getResource("/View/MenuPrincipal.fxml"));
            Main.trocarTela(nova);
            } catch (IOException ex) {
                Logger.getLogger(GerenciamentoVendasController.class.getName()).log(Level.SEVERE, null, ex);
            }
       // }
    }
    @FXML
    void inicioButtonAction(ActionEvent event) {
      //  int op = Main.telaAlerta(); 
     //   if(op==1){
            try {
                 nova= FXMLLoader.load(getClass().getResource("/View/MenuPrincipal.fxml"));
            Main.trocarTela(nova);
            } catch (IOException ex) {
                Logger.getLogger(GerenciamentoVendasController.class.getName()).log(Level.SEVERE, null, ex);
            }
        //}
    }
    /**
     * Metodo responsavel por listar as vendas e mostrar no tableview
     */
   public void listaVenda(){
            ListarVenda p = new ListarVenda();
        try{
            p.start(new Stage());
        }catch(Exception ex){
            Logger.getLogger(GerenciamentoVendas2Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
