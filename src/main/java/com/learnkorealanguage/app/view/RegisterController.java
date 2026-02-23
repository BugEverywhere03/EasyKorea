package com.learnkorealanguage.app.view;

import com.learnkorealanguage.app.constant.AuthResult;
import com.learnkorealanguage.app.viewmodel.RegisterViewModel;
import javafx.beans.binding.Bindings;
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

    private String className;
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
        lblMessage.textProperty().bind(Bindings.createStringBinding(() -> {
                    AuthResult responseStatus = registerViewModel.getResponseStatus().get();
                    if (responseStatus == null) {
                        return "";
                    }
                    String message = switch (responseStatus) {
                        case REGISTER_SUCCESS -> "Đăng ký thành công";
                        case INVALID_USERNAME -> "Tên đăng không được để trống";
                        case INVALID_PASSWORD -> "Mật khẩu không được để trống";
                        case INVALID_CONFIRM_PASSWORD -> "Xác nhận mật khẩu không được để trống";
                        case PASSWORD_ADD_CONFIRM_PASSWORD_NOT_MATCH -> "Mật khẩu và xác nhận mật khẩu không khớp";
                        case SYSTEM_ERROR -> {
                            Alert alert = new Alert(Alert.AlertType.ERROR);
                            alert.setTitle("Lỗi");
                            alert.setHeaderText("Thông báo lỗi");
                            alert.setContentText("Đăng kí thất bại do lỗi hệ thống");
                            yield "";
                        }
                        case USERNAME_EXISTS ->  "Tên đăng nhập đã tồn tại";
                    };
                    className = "message-box-error";
                    if (responseStatus == AuthResult.REGISTER_SUCCESS) {
                        className = "message-box-success";
                    }
                    return message;
                }
        ));
    }

    @FXML
    private void handlerRegisterAction(){
        registerViewModel.registerHandler();
        messageBox.getStyleClass().add(className);
        messageBox.setManaged(true);
    }
}

