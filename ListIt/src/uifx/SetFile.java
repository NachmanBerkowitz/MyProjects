/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uifx;

import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 *
 * @author em.es
 */
public class SetFile extends javafx.scene.layout.GridPane{

    String[] names = list.FileList.getList();

    {
        setPadding(new Insets(20));
        setVgap(15);
    }

    public SetFile() {

        Label select = new Label("Please select list.");
        add(select, 1, 0);

        ScrollPane scrollPane = new ScrollPane();/**/
        
        VBox labelGroup = new VBox();
        
        int i = 0;
        for (String name : names) {
            NameLabel a = new NameLabel(name);
            labelGroup.getChildren().add(a);
            i++;
        }
        labelGroup.setBackground(Configure.BACKGROUND);
        labelGroup.setPadding(new Insets(0, 20, 0, 0));
        
        scrollPane.setContent(labelGroup);
        scrollPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        scrollPane.setMaxHeight(Configure.INNER_HEIGHT);
        scrollPane.setBackground(Configure.BACKGROUND);
        scrollPane.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(5), BorderWidths.DEFAULT)));
        add(scrollPane, 0, 1, 1, i);

        Button newFile = new Button("New List");
        newFile.setOnMouseClicked((MouseEvent event) -> {
            Main.loadNewFile();
        });
        
        add(newFile, 2, 1);

        setBackground(Configure.BACKGROUND);
    }

    class NameLabel extends javafx.scene.control.Label {

        public NameLabel(String text) {
            super(text);
            set();
        }

        public NameLabel() {
            set();
        }

        private void set() {
            double insets = 8;
            setPadding(new Insets(insets));

            setOnMouseEntered((MouseEvent event) -> {
                setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, new CornerRadii(2), BorderWidths.DEFAULT)));
                setPadding(new Insets(insets - 1));
            });

            setOnMouseExited((MouseEvent event) -> {
                setBorder(Border.EMPTY);
                setPadding(new Insets(insets));
            });

            setOnMousePressed((MouseEvent event) -> {
                Main.loadSetItem(getText());
            });
        }

    }
}
