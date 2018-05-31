/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uifx;

;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import static javafx.scene.layout.BorderPane.setAlignment;
import static javafx.scene.layout.BorderPane.setMargin;
import javafx.scene.layout.HBox;

/**
 *
 * @author em.es
 */


public class NewFile extends javafx.scene.layout.BorderPane {

    {
        Button backButton = new Button("\uE0C4");
        backButton.setOnMouseClicked((event) -> {
            Main.loadSetFile();
        });
        setAlignment(backButton, Pos.TOP_LEFT);
        setMargin(backButton, new Insets(10));

        Label label = new Label("Enter file name:");

        TextField tf = new TextField();

        tf.setOnAction((event) -> {
            final String text = tf.getText();
            new list.CreateFile(text);
            Main.loadSetItem(text);
        });

        label.setPadding(new Insets(0, 10, 0, 5));

        HBox hBox = new HBox(label, tf);
        hBox.setAlignment(Pos.CENTER);

        setCenter(hBox);
        setTop(backButton);
    }
}
