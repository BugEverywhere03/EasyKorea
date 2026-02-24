package com.learnkorealanguage.app.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import java.io.IOException;

public class SceneManager {
    public static void changeScene(Scene scene, String classPath) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(SceneManager.class.getResource(classPath));
        scene.setRoot(fxmlLoader.load());
    }
    public static Scene initScene(String classPath) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(SceneManager.class.getResource(classPath));
        return new Scene(fxmlLoader.load());
    }
}
