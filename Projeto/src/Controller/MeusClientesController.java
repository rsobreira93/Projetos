/**
 * 
 */

package Controller;

import Main.Main;
import Modelo.Cliente;
import ModeloConection.ConnectionFactory;
import ModeloDao.ClienteDAO;
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
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javax.swing.JOptionPane;
/**
 * Classe responsavel por implementar as funcionalidade do fxml MeusClientesController
 * @author Romulo Sobreira
 */

public class MeusClientesController implements Initializable{
    Cliente mod = new Cliente();
    ClienteDAO control = new ClienteDAO();
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
    
    @FXML    private TableView<Cliente> tableView;
    @FXML    private TableColumn<Cliente, Long> idTb;
    @FXML    private TableColumn<Cliente, String> cpfTb;
    @FXML    private TableColumn<Cliente, String> telefoneTb;
    @FXML    private TableColumn<Cliente, String> nomeTb;
    @FXML    private TableColumn<Cliente, String> observaTb;
    @FXML    private TableColumn<Cliente, String> enderecoTb;
    private Cliente selecionada; 
     ObservableList<Cliente> clientes = FXCollections.observableArrayList();
     /**
      * Metodo responsável por mostrar elementos e executar ações referentes a tableview
      * @param location - Url do inicializable
      * @param resources  - recurso necessarops para a inicialização da table view
      */
    @Override
    public void initialize(URL location, ResourceBundle resources){
        initTable();
        
        atualizarButton.setOnMouseClicked((MouseEvent e ) -> {
            tableView.setItems(atualizaTabela());
        });
        excluirButton.setOnMouseClicked((MouseEvent e ) -> {
            deletar();
        });
        buscarTextField.setOnKeyReleased((KeyEvent e) ->{
            tableView.setItems(busca());
        });
        tableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                selecionada = (Cliente) newValue;
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
                 nova= FXMLLoader.load(getClass().getResource("/View/Login.fxml"));
            Main.trocarTela(nova);
            } catch (IOException ex) {
                Logger.getLogger(MeusClientesController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    @FXML
    void buscarButtonAction(ActionEvent event){
        if(buscarTextField.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Informe um produto");
        }else{
        tableView.setItems(busca());
        }
    }
    @FXML
    void excluirButtonAction(ActionEvent event){
        deletar();
    }
    @FXML
    void atualizarButtonAction(ActionEvent event) throws Exception{
       alterar();
    }
    /**
     * 
     * Função responsável por inicializar o tabelview.
     */
    public void initTable(){
        idTb.setCellValueFactory(new PropertyValueFactory("cod"));
        nomeTb.setCellValueFactory(new PropertyValueFactory("nome"));
        cpfTb.setCellValueFactory(new PropertyValueFactory("cpf"));
        telefoneTb.setCellValueFactory(new PropertyValueFactory("telefone"));
        enderecoTb.setCellValueFactory(new PropertyValueFactory("endereco"));
        observaTb.setCellValueFactory(new PropertyValueFactory("obs"));
        tableView.setItems(atualizaTabela());
    }
    public ObservableList<Cliente> atualizaTabela(){
       ClienteDAO dao = new ClienteDAO();
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
                ClienteDAO dao = new ClienteDAO();
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
        /**
         * Metodo responsavel por alterar um cliente
         * @throws Exception  - caso o cliente seja null, ou seja, ele não tenha selecionado nenhum
         * ele emite um aletar pedidindo para selecionar
         */
        public void alterar() throws Exception{
            Cliente cliente = tableView.getSelectionModel().getSelectedItem();
            if(cliente != null){  
            try{
              boolean buttonConfirmarClicked = telaAlterarCliente(cliente);
            if (buttonConfirmarClicked){
                control.update(cliente);
                initTable();
            }
            }catch (IOException ex){
                Logger.getLogger(MeusClientesController.class.getName()).log(Level.SEVERE, null, ex);
            }
            }else{
                Alert a = new Alert(Alert.AlertType.WARNING);
                a.setHeaderText("Selecione um cliente");
                a.show();
            }
        }
        public boolean telaAlterarCliente(Cliente cliente) throws IOException{
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(AlterarClientController.class.getResource("/View/AlterarClient.fxml"));
        AnchorPane page = (AnchorPane) loader.load();

        // Criando um Estágio de Diálogo (Stage Dialog)
        Stage dialogStage = new Stage();
        dialogStage.setTitle("Anamary");
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);

        // Setando o cliente no Controller.
        AlterarClientController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setCliente(cliente);

        // Mostra o Dialog e espera até que o usuário o feche
        dialogStage.showAndWait();

        return controller.isButtonConfimar();
        }
        private ObservableList<Cliente> busca(){
            ObservableList<Cliente> clientePesquisa = FXCollections.observableArrayList();
            for(int x = 0; x < clientes.size(); x++){
                if(clientes.get(x).getNome().toLowerCase().contains(buscarTextField.getText().toLowerCase())){
                    clientePesquisa.add(clientes.get(x));
                }
            }
            return clientePesquisa;
        }
}
