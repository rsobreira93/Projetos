/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Romulo Sobreira
 */
public class GerenciamentoVendas extends Application{
    private static Stage stage;
    
    public static void main(String[] args){
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("view/Financas.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Gerenciamento de  vendas");
        stage.setScene(scene);
        stage.show();
        setStage(stage);
    }

    public static Stage getStage() {
        return stage;
    }
    public static void setStage(Stage stage){
        GerenciamentoVendas.stage = stage;
    }
    
}
