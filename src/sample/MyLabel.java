package sample;

import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Point2D;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;

import java.util.Random;

/**
 * Created by objectstyle on 4/13/17.
 */
public class MyLabel extends Label implements EventHandler<MouseEvent>{
    private Random r = new Random();
    private boolean isSelected = false;
    private Point2D diff;

    public MyLabel(String text) {
        super(text);
        setPrefWidth(100);
        setPrefHeight(50);
        setAlignment(Pos.CENTER);
        setLayoutY(r.nextDouble() * 500);
        setLayoutX(r.nextDouble() * 500);
        setRotate(r.nextDouble() * 180);
        setStyle("-fx-background-color: orange;");
    }

    @Override
    public void handle(MouseEvent event) {
        if (event.getEventType() == MouseEvent.MOUSE_CLICKED){
            setLayoutX(event.getSceneX() + 10);
            setLayoutY(event.getSceneY() + 10);
            if (!isSelected) {
                select(true);
            }
        } else if (event.getEventType() == MouseEvent.MOUSE_PRESSED){
            if (isSelected){
                diff = new Point2D(-event.getSceneX() + getLayoutX(), -event.getSceneY() + getLayoutY());
            }
        } else if (event.getEventType() == MouseEvent.MOUSE_RELEASED){
                diff = null;
                select(false);
        } else if (event.getEventType() == MouseEvent.MOUSE_DRAGGED && diff != null){
            setLayoutX(event.getSceneX() + diff.getX());
            setLayoutY(event.getSceneY() + diff.getY());
        }
    }

    public void select(boolean f1){
        isSelected = f1;
        if (f1){
            toFront();
        }
    }
}
