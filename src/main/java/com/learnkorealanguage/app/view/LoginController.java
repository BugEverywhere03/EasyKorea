package com.learnkorealanguage.app.view;

import com.learnkorealanguage.app.constant.ViewPath;
import com.learnkorealanguage.app.util.SceneManager;
import com.learnkorealanguage.app.viewmodel.LoginViewModel;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import lombok.Setter;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Hyperlink registerHyperLink;
    @FXML
    private HBox errorBox;
    @FXML
    private Label lblErrorMessage;

    @Setter
    private Runnable onSwitchToRegister;


    private final LoginViewModel loginViewModel;

    public LoginController(){
        loginViewModel = new LoginViewModel();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        registerHyperLink.setOnAction( e -> {
                if (onSwitchToRegister != null) {
                    onSwitchToRegister.run();
                }
            }
        );

        // Binding properties
        txtPassword.textProperty().bindBidirectional(loginViewModel.getPassword());
        txtUsername.textProperty().bindBidirectional(loginViewModel.getUserName());
        lblErrorMessage.textProperty().bindBidirectional(loginViewModel.getErrorMessage());
        errorBox.setVisible(true);
        errorBox.setManaged(false);
    }

    @FXML
    private void handlerLoginAction(){
        boolean result = loginViewModel.loginHandler();
        if (!result){
            errorBox.setManaged(true);
            errorBox.getStyleClass().add("message-box");
            lblErrorMessage.getStyleClass().add("message-label-error");
            return;
        }
        Platform.runLater(this::loadHomeScene);
    }

    private void loadHomeScene(){
        try {
            Scene scene = txtUsername.getScene();
            Stage stage = (Stage) scene.getWindow();
            SceneManager.changeScene(scene, ViewPath.HOME.getPath());
            stage.sizeToScene();
            stage.setMaximized(true);
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }



}