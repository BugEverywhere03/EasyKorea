package com.learnkorealanguage.app.view;

import com.learnkorealanguage.app.viewmodel.LoginViewModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import lombok.Setter;

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


}