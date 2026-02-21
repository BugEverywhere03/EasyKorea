package com.learnkorealanguage.app.view;

import com.learnkorealanguage.app.constant.ViewPath;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import lombok.Getter;

import java.net.URL;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

public class AuthController implements Initializable {

    @FXML
    private StackPane rightContainer;
    public VBox loginForm;
    public VBox registerForm;
    private LoginController loginController;
    private RegisterController registerController;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            FXMLLoader loginLoader = new FXMLLoader(getClass().getResource(ViewPath.LOGIN.getPath()));
            loginForm = loginLoader.load();
            loginController = loginLoader.getController();
            FXMLLoader registerLoader = new FXMLLoader(getClass().getResource(ViewPath.REGISTER.getPath()));
            registerForm = registerLoader.load();
            registerController = registerLoader.getController();
            loginController.setOnSwitchToRegister( () -> registerForm.toFront());
            registerController.setOnSwitchToLogin( () -> loginForm.toFront());
            rightContainer.getChildren().addAll(registerForm, loginForm);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
