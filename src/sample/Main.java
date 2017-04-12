package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.LabelBuilder;
import javafx.stage.Stage;

import java.util.Random;

public class Main extends Application {
    private int windowWidth = 600;
    private int windowHeight = 600;
    private Random random = new Random();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }

    private Scene createScene(){
        Group root = new Group();
        Scene scene = new Scene(root, windowWidth, windowHeight);

        return scene;
    }

    private Label createLabel(){
        Label label = LabelBuilder.create()
                .text("Some text")
                .prefWidth(100)
                .prefHeight(50)
                .alignment(Pos.CENTER)
                .layoutX(random.nextInt(windowWidth-100))
                .layoutY(random.nextInt(windowHeight-50))
                .style("-fx-background-color: orange;")
                .build();

        return label;
    }
}
