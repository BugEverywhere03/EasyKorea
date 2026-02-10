package com.learnkorealanguage.app;

import com.learnkorealanguage.app.constant.ViewPath;
import com.learnkorealanguage.app.ultil.LoadParent;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Objects;


public class KoreaEasy extends Application{
    // Startup window of JavaFX
    @Override
    public void start(Stage stage){
        try {
            Parent root = LoadParent.loadParent(ViewPath.LOGIN.getPath());
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.sizeToScene();
            String iconPath = "/com/learnkorealanguage/app/images/icon_app.png";
            Image iconImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream(iconPath)));
            stage.getIcons().add(iconImage);
            stage.initStyle(StageStyle.UNDECORATED);
            stage.show();
        } catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Error Notification");
            alert.setContentText("Can't load Login Screen Because Error " + e.getCause());
            alert.show();
        }
    }
}
