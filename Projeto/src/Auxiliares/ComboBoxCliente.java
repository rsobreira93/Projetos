/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Auxiliares;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *Classe responsável por abrir a tela de uma combobox de clientes
 * @author Romulo Sobreira
 */
public class ComboBoxCliente extends Application{
    private static Stage stage;
    
    public static void main(String[] args){
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("view/Financas.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("ComboBox cliente");
        stage.setScene(scene);
        stage.show();
        setStage(stage);
    }
    /**
     * Método para pegar a stage
     * @return  stage
     */
    public static Stage getStage() {
        return stage;
    }
    /**
     * Método estatico responsável por por pegar a stage que vai ser aberta.
     * @param stage - Stage que ira sobrepor  a stage Atual
     */
    public static void setStage(Stage stage){
        ComboBoxCliente.stage = stage;
    }
    
}
