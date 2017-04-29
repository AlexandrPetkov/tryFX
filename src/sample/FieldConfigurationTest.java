package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import sample.component.FieldConfigurationModel;
import sample.component.FieldEditor;


/**
 * Created by alex on 4/14/17.
 */
public class FieldConfigurationTest extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        VBox box = new VBox();
        box.setSpacing(20);


        FieldEditor dateOfBirth = new FieldEditor(new FieldConfigurationModel("Date of birth", "DOB", "Please enter your date of birth"));
        FieldEditor suburb = new FieldEditor(new FieldConfigurationModel("Suburb", "Suburb", "We only accept students from Sydney", false));
        FieldEditor test = new FieldEditor(new FieldConfigurationModel("test", "test"));


        //pane for checking close/restore ability of Action
        //when you click on closeBtn of "dateOfBirth" pane, it disappears and "pane" appears
        //when you click on "undo" button of "pane" it disappears and "dateOfBirth" pane restores
        GridPane pane = new GridPane();
        Button undo = new Button("Undo");
        pane.getChildren().add(undo);
        undo.addEventHandler(ActionEvent.ACTION, event -> {
            box.getChildren().remove(pane);
            box.getChildren().add(0, dateOfBirth);
        });

        // adding handler on "onCloseBtn". when clicked "dateOfBirth" pane disappears and "pane" appears
        dateOfBirth.addEventHandlerOnCloseBtn(ActionEvent.ACTION, event -> {
            box.getChildren().remove(dateOfBirth);
            box.getChildren().add(0, pane);
        });

        // adding handler on "onCloseBtn" of "suburb" pane
        suburb.addEventHandlerOnCloseBtn(ActionEvent.ANY, event -> System.out.println("x"));

        box.getChildren().add(dateOfBirth);
        box.getChildren().add(suburb);
        box.getChildren().add(test);

        primaryStage.setScene(new Scene(box, 920, 250));
        primaryStage.show();
    }

}
