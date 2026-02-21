package com.learnkorealanguage.app.controls;

import com.learnkorealanguage.app.constant.ComponentPath;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;


public class CustomInput extends VBox {
    private Label label;
    private TextField textField;

    public CustomInput() {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(ComponentPath.CustomInput.getPath()));
            fxmlLoader.setRoot(this);
            fxmlLoader.setController(this);
            fxmlLoader.load();
        } catch (Exception ioe){
            Alert alert = new Alert(Alert.AlertType.ERROR, "Component Error " + ioe.getMessage(), ButtonType.OK);
            alert.setTitle("Error");
            alert.setHeaderText("Error Notification");
            alert.show();
        }
    }

    public String getText(){
        return textField.getText();
    }
    public void setText(String label){
        this.label.setText(label);
    }
    public void setPromptText(String promptText){
        this.textField.setPromptText(promptText);
    }
}
