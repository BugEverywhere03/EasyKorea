package com.learnkorealanguage.app.view;

import com.learnkorealanguage.app.constant.ViewPath;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class AuthController implements Initializable {

    @FXML
    private StackPane rightContainer;
    public VBox loginForm;
    public VBox registerForm;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            // Load Login Component
            FXMLLoader loginLoader = new FXMLLoader(getClass().getResource(ViewPath.LOGIN.getPath()));
            loginForm = loginLoader.load();
            LoginController loginController = loginLoader.getController();
            // Load Register Component
            FXMLLoader registerLoader = new FXMLLoader(getClass().getResource(ViewPath.REGISTER.getPath()));
            registerForm = registerLoader.load();
            RegisterController registerController = registerLoader.getController();
            // Set method
            loginController.setOnSwitchToRegister( () -> registerForm.toFront());
            registerController.setOnSwitchToLogin( () -> loginForm.toFront());
            rightContainer.getChildren().addAll(registerForm, loginForm);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
