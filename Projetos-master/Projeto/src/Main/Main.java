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
import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.SimpleEmail;

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
    public static void emailEsqueciSenha(String emailUser, int novaSenha){
        String email= "sistemanamay@gmail.com";
        String senha="anamary12";
        SimpleEmail meuEmail= new SimpleEmail();
        //conexao com servidor gmail
        meuEmail.setHostName("smtp.gmail.com");
        meuEmail.setSmtpPort(465);
        // estabelecendo conexão
        meuEmail.setAuthenticator(new DefaultAuthenticator(email,senha));
        meuEmail.setSSLOnConnect(true);
        //criando email e enviando
        try{
            meuEmail.setFrom(email);//remetente
            meuEmail.setSubject("AnaMary: nova senha");//assunto
<<<<<<< HEAD:Projetos-master/Projeto/src/Main/Main.java
<<<<<<< HEAD:Projetos-master/Projeto/src/Main/Main.java
            meuEmail.setMsg("Sua nova senha é "+novaSenha);//mensagem
=======
            meuEmail.setMsg("Sua nova senha é"+novaSenha);//mensagem
>>>>>>> 80b6c0a567a143d0c15866c31f65cffb8145bfe9:Projeto/src/Main/Main.java
=======
            meuEmail.setMsg("Sua nova senha é "+novaSenha);//mensagem
>>>>>>> feeae37dcc6f75b0720c1c261fa986c8ba917e98:Projeto/src/Main/Main.java
            meuEmail.addTo(emailUser);//destinatario
            meuEmail.send();
            System.out.println("Email Enviado com sucesso");
        }catch(Exception e){
            e.printStackTrace();
        }
        
        
        
        
        
    } 
}
