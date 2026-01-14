package com.learnkorealanguage.app;

import com.learnkorealanguage.app.ultil.LoadParent;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class KoreaEasy extends Application{

    @Override
    public void start(Stage stage){
        try {
            Parent root = LoadParent.loadParent("/com/learnkorealanguage/app/fxml/home.fxml");
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.sizeToScene();
            stage.show();
        } catch (IOException e){
            System.out.println(e.getMessage());
            stage.close();
        }
    }
}
