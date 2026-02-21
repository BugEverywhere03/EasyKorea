package com.learnkorealanguage.app.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import lombok.Setter;

import java.net.URL;
import java.util.ResourceBundle;

public class LoginController implements Initializable {

    @FXML
    private TextField txtUsername;
    @FXML
    private TextField txtPassword;
    @FXML
    private Hyperlink registerHyperLink;

    @Setter
    private Runnable onSwitchToRegister;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        registerHyperLink.setOnAction( e -> {
                if (onSwitchToRegister != null) {
                    onSwitchToRegister.run();
                }
            }
        );
    }


}