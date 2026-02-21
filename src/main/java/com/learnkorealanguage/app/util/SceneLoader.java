package com.learnkorealanguage.app.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class SceneLoader {
    public static Parent loadScene(String classPath) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(com.learnkorealanguage.app.util.SceneLoader.class.getResource(classPath));
        return fxmlLoader.load();
    }
}
