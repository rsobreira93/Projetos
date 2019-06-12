package Main;

import ModeloConection.ConexaoBD;
import java.util.Optional;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class Main extends Application{
    ConexaoBD con = new ConexaoBD();
    private static Stage stage;
    @Override
    public void start(Stage StagePrincipal) throws Exception {
        Parent TesteFXML = FXMLLoader.load(getClass().getResource("/View/Login.fxml"));
        Scene teste = new Scene(TesteFXML);
        StagePrincipal.setScene(teste);
        StagePrincipal.setTitle("Anamary");
        //stage.setResizable(false);
        stage = StagePrincipal;
        StagePrincipal.show();
    }
    public static void trocarTela(Parent FXML) {
        Scene cena = new Scene(FXML);
        stage.setScene(cena);
    }
    public static void main(String[] args) {
        launch(args);
    }
    public static void fecharTela() {
        stage.close();
    }
    public static int telaAlerta(){
        Alert confirmacao = new Alert(Alert.AlertType.CONFIRMATION);
        confirmacao.setTitle("Aviso");
        confirmacao.setContentText("Deseja sair sem salvar?");
        Optional<ButtonType> result = confirmacao.showAndWait();
        if(result.get() == ButtonType.OK){
           return 1; 
        }
        return 0;
}  
}