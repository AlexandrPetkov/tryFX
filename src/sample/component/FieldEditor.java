package sample.component;

import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

import java.io.IOException;


/**
 * Created by alex on 4/14/17.
 */
public class FieldEditor extends GridPane{

    @FXML
    private ChoiceBox state;

    @FXML
    private Text header;

    @FXML
    private TextField nameField;

    @FXML
    private Label nameLabel;

    @FXML
    private TextField descriptionField;

    @FXML
    private Label descriptionLabel;

    @FXML
    private Button dragButton;

    @FXML
    private Button closeButton;

    private FieldEditorModel dataModel;


    public FieldEditor() {
    }

    public FieldEditor(FieldEditorModel model) {
        initController();
        this.dataModel = model;
        initValuesFromModel();
        initListeners();
    }

    private void initController(){
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ish/oncourse/javafx/fieldconfiguration/component/FieldEditor.fxml"));
            fxmlLoader.setRoot(this);
            fxmlLoader.setController(this);
            fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    private void initValuesFromModel(){
        if (dataModel != null) {
            header.setText(dataModel.getHeader());
            nameField.setText(dataModel.getName());
            descriptionField.setText(dataModel.getDescription());
            if (!dataModel.isManadatory()){
                state.getSelectionModel().selectNext();
            }
        }
    }

    private void initListeners(){
        if (dataModel != null) {

            nameField.textProperty().addListener((observable, oldValue, newValue) -> {
                dataModel.setName(newValue);
            });

            descriptionField.textProperty().addListener((observable, oldValue, newValue) -> {
                dataModel.setDescription(newValue);
            });

            state.valueProperty().addListener((observable, oldValue, newValue) -> {
                if (newValue.equals("Mandatory"))
                    dataModel.setManadatory(true);
                else
                    dataModel.setManadatory(false);
            });
        }
    }

    public void addEventHandlerOnCloseBtn(EventType action, EventHandler o) {
        closeButton.addEventHandler(action, o);
    }

    public void addEventHandlerOnDragBtn(EventType action, EventHandler o){
        dragButton.addEventHandler(action, o);
    }
}