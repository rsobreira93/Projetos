package Screens;

import javafx.application.Application;
import javafx.stage.Stage;

public class ContaUser extends Application{
    private static Stage stage;
    
    @Override
    public void start (Stage stage) throws Exception {
        //Parent root= FXMLLoader.load(getClass().getResource("/View/ContaUser.fxml"));
        //Scene scene= new Scene(root);
        //stage.setScene(scene);
        stage.setTitle("Anamary");
        stage.setResizable(false);
        stage.show();
        setStage(stage);
    } 
    public static Stage getStage(){
        return stage;
    }
    public void setStage(Stage stage) {
       ContaUser.stage = stage;
    } 
    
}
