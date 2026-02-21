package com.learnkorealanguage.app.view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Hyperlink;
import lombok.Setter;

import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController implements Initializable {
    @FXML
    private Hyperlink loginHyperLink;
    @Setter
    private Runnable onSwitchToLogin;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loginHyperLink.setOnMouseClicked( e -> {
            if (onSwitchToLogin != null) {
                onSwitchToLogin.run();
            }
        });
    }


}
