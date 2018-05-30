/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uifx;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author em.es
 */
public class Main extends Application {

    static Scene scene = new Scene(new SetFile());
    

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("List It");
        
        primaryStage.setScene(scene);
        primaryStage.setMaxHeight(500);
        primaryStage.show();
    }

    public static void loadSetFile() {
        scene.setRoot(new SetFile());
    }

    public static void loadSetItem(String file) {
        scene.setRoot(new SetItem(file));
    }

    public static void loadNewFile() {
        scene.setRoot(new NewFile());
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
