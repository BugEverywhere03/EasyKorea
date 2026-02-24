package com.learnkorealanguage.app.view;

import com.learnkorealanguage.app.viewmodel.RegisterViewModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import lombok.Setter;

import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {
    @FXML
    private Hyperlink loginHyperLink;
    @FXML
    private HBox messageBox;
    @FXML
    private Label lblMessage;
    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private PasswordField txtConfirmPassword;

    @Setter
    private Runnable onSwitchToLogin;

    private final RegisterViewModel registerViewModel;

    public RegisterController(){
        registerViewModel = new RegisterViewModel();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loginHyperLink.setOnMouseClicked( e -> {
            if (onSwitchToLogin != null) {
                onSwitchToLogin.run();
            }
        });
        messageBox.setVisible(true);
        messageBox.setManaged(false);
        txtUsername.textProperty().bindBidirectional(registerViewModel.getUserName());
        txtPassword.textProperty().bindBidirectional(registerViewModel.getPassword());
        txtConfirmPassword.textProperty().bindBidirectional(registerViewModel.getConfirmPassword());
        lblMessage.textProperty().bindBidirectional(registerViewModel.getResponseMessage());
    }

    @FXML
    private void handlerRegisterAction(){
        boolean result = registerViewModel.registerHandler();
        String MESSAGE_SUCCESS = "message-label-success";
        String MESSAGE_ERROR = "message-label-error";
        String className = result ? MESSAGE_SUCCESS : MESSAGE_ERROR;
        messageBox.getStyleClass().add("message-box");
        messageBox.setManaged(true);
        lblMessage.getStyleClass().removeAll();
        lblMessage.getStyleClass().add(className);

    }
}

