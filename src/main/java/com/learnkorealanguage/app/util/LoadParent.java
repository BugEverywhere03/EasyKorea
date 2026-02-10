package com.learnkorealanguage.app.ultil;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class LoadParent {
    public static Parent loadParent(String classPath) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LoadParent.class.getResource(classPath));
        return fxmlLoader.load();
    }
}
