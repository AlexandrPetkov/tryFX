package sample;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Main extends Application {
    private int windowWidth = 900;
    private int windowHeight = 60;


    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Simple Application");
        primaryStage.setScene(initScene());
        primaryStage.setMinWidth(640);
        primaryStage.show();
    }

    private Scene initScene(){

        GridPane block = new GridPane();
        block.setGridLinesVisible(false);
        block.setHgap(20);
        block.setMaxHeight(100);
        block.setMinWidth(640);
        block.setAlignment(Pos.CENTER);

        Text blockTitle = new Text("Date of birth");

        TextField nameField = new TextField();
        Label nameLabel = new Label("label");

        TextField descriptionField = new TextField();

        Label descriptionLabel = new Label("Help text");

        ChoiceBox<String> box = new ChoiceBox<>(FXCollections.observableArrayList("Mandatory", "Optional"));
        Button dragButton = new Button();
        Button closeButton = new Button();


        descriptionField.setPrefWidth(300);
        descriptionField.setPromptText("Please enter your date of birth");
        descriptionLabel.setLabelFor(descriptionField);
        descriptionLabel.setFont(Font.font(10));
        nameLabel.setFont(Font.font(10));
        nameField.setPrefWidth(150);
        nameField.setPromptText("DOB");
        nameLabel.setLabelFor(nameField);
        nameLabel.setFont(Font.font(10));

        Scene scene = new Scene(block, windowWidth, windowHeight);

        block.addRow(1, dragButton, blockTitle, box, nameField, descriptionField, closeButton);
        block.add(nameLabel, 3, 2);
        block.add(descriptionLabel, 4, 2);


        return scene;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
