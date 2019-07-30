package Controller;



import Modelo.Cliente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class AlterarClientController{
    private Parent nova;
    @FXML
    private TextField cNascimentoTextField;

    @FXML
    private TextField complementoTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private Button atualizarButton;

    @FXML
    private TextArea obsTextField;

    @FXML
    private Button enfButton;

    @FXML
    private TextField cpfTextField;

    @FXML
    private TextField bairroTextField;

    @FXML
    private TextField enderecoTextField;

    @FXML
    private TextField celularTextField;

    @FXML
    private TextField nomeTextField;

    @FXML
    private TextField nTextField;

    @FXML
    private TextField cidadeTextField;
    
    private Stage dialogStage;
    private boolean buttonConfimar= false;
    private Cliente cliente;

    public Stage getDialogStage() {
        return this.dialogStage;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public boolean isButtonConfimar() {
        return this.buttonConfimar;
    }

    public void setButtonConfimar(boolean buttonConfimar) {
        this.buttonConfimar = buttonConfimar;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
        this.nomeTextField.setText(cliente.getNome());
        this.celularTextField.setText(cliente.getTelefone());
        this.emailTextField.setText(cliente.getEmail());
        this.cpfTextField.setText(cliente.getCpf());
        this.enderecoTextField.setText(cliente.getEndereco());
        this.nTextField.setText(cliente.getN());
        this.complementoTextField.setText(cliente.getComplemento());
        this.bairroTextField.setText(cliente.getBairro());
        this.cidadeTextField.setText(cliente.getCidade());
        this.obsTextField.setText(cliente.getObs());
        this.cNascimentoTextField.setText(cliente.getdNascimento());
    } 
    @FXML
    void atualizarButtonAction(ActionEvent event){
        if(nomeTextField.getText().isEmpty() ||
           celularTextField.getText().isEmpty() ||
           enderecoTextField.getText().isEmpty()){
            JOptionPane.showMessageDialog(null, "Todos os campos obrigatórios devem está preenchidos");
        }else {
        cliente.setNome(nomeTextField.getText());
        cliente.setTelefone(celularTextField.getText());
        cNascimentoTextField.getText();
        cliente.setEmail(emailTextField.getText());
        cliente.setCpf(cpfTextField.getText());
        cliente.setEndereco(enderecoTextField.getText());
        cliente.setN(nTextField.getText());
        cliente.setComplemento(complementoTextField.getText());
        cliente.setBairro(bairroTextField.getText());
        cliente.setCidade(cidadeTextField.getText());
        cliente.setdNascimento (cNascimentoTextField.getText());
        cliente.setObs(obsTextField.getText());
        buttonConfimar=true;
        dialogStage.close();
        }
    }
}
