/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Romulo Sobreira
 */
public class ListarCliente extends Application{
    private static Stage stage;
    
    public static void main(String[] args){
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("view/MeusClientes.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Listar cliente");
        stage.setScene(scene);
        stage.show();
        setStage(stage);
    }

    public static Stage getStage() {
        return stage;
    }
    public static void setStage(Stage stage){
        ListarCliente.stage = stage;
    }
    
}
