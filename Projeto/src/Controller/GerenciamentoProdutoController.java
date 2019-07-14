package Controller;

import Main.Main;
import Modelo.ListarProduto;
import Modelo.ModeloUsuario;
import Modelo.Produto;
import ModeloDao.ProdutoDao;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class GerenciamentoProdutoController implements Initializable{

    
    private Parent nova;
    @FXML
    private Label vCustoLabel;
    @FXML
    private Label vVendaLabel;
    @FXML
    private TextField buscarTextField;
    @FXML
    private Button excluirButton;
    @FXML
    private Button addButton;
    @FXML
    private Button buscarButton;
    @FXML
    private Button inicioButton;
    @FXML
    private Button enfButton;
    @FXML
    private Button sairButton;
    @FXML
    private Button voltarButton;
    

    @FXML    private TableView<Produto> tableView;
    @FXML    private TableColumn<Produto, Long> refTb;
    @FXML    private TableColumn<Produto, String> nomeTb;
    @FXML    private TableColumn<Produto, Long> qtdTb;
    @FXML    private TableColumn<Produto, Float> pvTb;
    @FXML    private TableColumn<Produto, Float> pcTb;
    @FXML    private ImageView imgFoto;
    private Produto selecionada;
   // private String caminhaFoto;
    
    ObservableList<Produto> produtos = FXCollections.observableArrayList();
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initTable();
        
        excluirButton.setOnMouseClicked((MouseEvent e ) -> {
            deletar();
        });
        buscarTextField.setOnKeyReleased((KeyEvent e) ->{
            tableView.setItems(busca());
        });
        tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                selecionada = (Produto) newValue;
                mostraDetalhes();
            }
        });
    }
    @FXML
    void sairButtonAction(ActionEvent event){
       try {
            nova= FXMLLoader.load(getClass().getResource("/View/Login.fxml"));
            Main.trocarTela(nova);
            } catch (IOException ex) {
                Logger.getLogger(GerenciamentoClienteController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    @FXML
    void inicioButtonAction(ActionEvent event){
            try {
                 nova= FXMLLoader.load(getClass().getResource("/View/MenuPrincipal.fxml"));
            Main.trocarTela(nova);
            } catch (IOException ex) {
                Logger.getLogger(GerenciamentoClienteController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    @FXML
    void voltarButtonAction(ActionEvent event){
            try {
            nova= FXMLLoader.load(getClass().getResource("/View/MenuPrincipal.fxml"));
            Main.trocarTela(nova);
            } catch (IOException ex) {
                Logger.getLogger(GerenciamentoClienteController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    @FXML
    void addButtonAction(ActionEvent envent){
        try {
                nova= FXMLLoader.load(getClass().getResource("/View/AdicionarProduto.fxml"));
                Main.trocarTela(nova);
            } catch (IOException ex) {
                Logger.getLogger(GerenciamentoClienteController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    @FXML
    void buscarButtonAction(ActionEvent event){
        tableView.setItems(busca());
    }
    @FXML
    void excluirButtonAction(ActionEvent event){
       deletar();
    }
    public void initTable(){
        refTb.setCellValueFactory(new PropertyValueFactory("referenciaProduto"));
        nomeTb.setCellValueFactory(new PropertyValueFactory("nomeProduto"));
        qtdTb.setCellValueFactory(new PropertyValueFactory("quantidadeProduto"));
        pvTb.setCellValueFactory(new PropertyValueFactory("precoVenda"));
        pcTb.setCellValueFactory(new PropertyValueFactory("precoCusto"));
        tableView.setItems(atualizaTabela());
    }
    public ObservableList<Produto> atualizaTabela(){
       ProdutoDao dao = new ProdutoDao();
       produtos = FXCollections.observableArrayList(dao.getList()); 
       return produtos;
    }
    public void listaProduto(){
            ListarProduto p = new ListarProduto();
        try{
            p.start(new Stage());
        }catch(Exception ex){
            Logger.getLogger(MeusClientesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void fecha(){
       ListarProduto.getStage().close();
    }
    public void deletar(){
        if(selecionada != null){
            ProdutoDao dao = new ProdutoDao();
            dao.delete(selecionada);
            Alert a = new Alert(Alert.AlertType.CONFIRMATION);
            a.setHeaderText("Produto deletado com sucesso");
            a.show();
            tableView.setItems(atualizaTabela());
        }else{
            Alert a = new Alert(Alert.AlertType.WARNING);
            a.setHeaderText("Selecione um Produto");
            a.show();
        }
    }
    
    public void mostraDetalhes(){
        if(selecionada != null){
            imgFoto.setImage(new Image("file:///"+selecionada.getFoto()));
        }else{
            imgFoto.setImage(new Image("/Imagens/img.png"));
        }
    }
    private ObservableList<Produto> busca(){
            ObservableList<Produto> produtoPesquisa = FXCollections.observableArrayList();
            for(int x = 0; x < produtos.size(); x++){
                if(produtos.get(x).getNomeProduto().toLowerCase().contains(buscarTextField.getText().toLowerCase())){
                    produtoPesquisa.add(produtos.get(x));
                }
            }
            return produtoPesquisa;
    }
    public void somaCusto(){

    }
}
