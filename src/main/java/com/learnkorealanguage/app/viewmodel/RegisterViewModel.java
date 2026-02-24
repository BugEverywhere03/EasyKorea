package com.learnkorealanguage.app.viewmodel;


import com.learnkorealanguage.app.constant.RegisterResult;
import com.learnkorealanguage.app.model.Account;
import com.learnkorealanguage.app.service.AuthService;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.scene.control.Alert;
import lombok.Getter;

@Getter
public class RegisterViewModel {
    private final StringProperty userName = new SimpleStringProperty();
    private final StringProperty password = new SimpleStringProperty();
    private final StringProperty confirmPassword = new SimpleStringProperty();
    private final ObjectProperty<RegisterResult> responseStatus = new SimpleObjectProperty<>();
    private final StringProperty responseMessage = new SimpleStringProperty();

    public RegisterViewModel() {
        responseMessage.bind(Bindings.createStringBinding(() -> {
            RegisterResult responseStatus = this.responseStatus.get();
            if (responseStatus == null) {
                return "";
            }
            return switch (responseStatus) {
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
        }, this.responseStatus));

    }

    public boolean registerHandler(){
        String userName = this.userName.getValue();
        String password = this.password.getValue();
        String confirmPassword = this.confirmPassword.getValue();

        // TODO validate input
        // Handler Register
        Account isExistsAccount = AuthService.getAccountByUserName(userName).orElse(null);
        if (isExistsAccount == null){
            Account newAccount = new Account();
            newAccount.setUserName(userName);
            newAccount.setPassword(password);
            AuthService.createAccount(newAccount);
            this.responseStatus.set(RegisterResult.REGISTER_SUCCESS);
            clearFields();
            return true;
        }
        this.responseStatus.set(RegisterResult.USERNAME_EXISTS);
        return false;
    }
    private void clearFields(){
        this.userName.setValue("");
        this.password.setValue("");
        this.confirmPassword.setValue("");
    }
}