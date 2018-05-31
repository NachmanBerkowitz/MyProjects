/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uifx;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import list.Writer;

/**
 *
 * @author em.es
 */
public class SetItem extends javafx.scene.layout.BorderPane {

    String file;

    SetItem(String text) {
        this.file = text;
        setUp();
    }

    private void setUp() {

        Button backButton = new Button("\uE0C4");
        backButton.setOnMouseClicked((event) -> {
            Main.loadSetFile();
        });
        setAlignment(backButton, Pos.TOP_LEFT);
        setMargin(backButton, new Insets(10));

        Label label = new Label("Enter Item:");

        TextField tf = new TextField();
        tf.setOnAction((event) -> {
            new Writer(file, tf.getText());
            tf.clear();
        });

        label.setLabelFor(tf);

        label.setPadding(new Insets(0, 10, 0, 5));
        HBox hBox = new HBox(label, tf);
        hBox.setAlignment(Pos.CENTER);
        setCenter(hBox);
        setTop(backButton);
    }

}
