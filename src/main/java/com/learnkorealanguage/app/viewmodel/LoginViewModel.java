package com.learnkorealanguage.app.viewmodel;


import com.learnkorealanguage.app.constant.LoginResult;
import com.learnkorealanguage.app.model.Account;
import com.learnkorealanguage.app.service.AuthService;
import javafx.beans.binding.Bindings;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import lombok.Getter;

@Getter
public class LoginViewModel {

    private final StringProperty userName = new SimpleStringProperty("");
    private final StringProperty password = new SimpleStringProperty("");
    private final StringProperty errorMessage = new SimpleStringProperty("");
    private final ObjectProperty<LoginResult> errorStatus = new SimpleObjectProperty<>();

    public LoginViewModel(){
        errorMessage.bind(Bindings.createStringBinding(() -> {
            LoginResult status = errorStatus.get();
            if (status == null) {
                return "";
            }
            return switch(status) {
                case LOGIN_FAILED -> "Tên đăng nhập hoặc mật khẩu không đúng";
                case INVALID_PASSWORD -> "Mật khẩu không được để trống";
                case INVALID_USERNAME -> "Tên đăng nhập không được để trống";
                case SYSTEM_ERROR -> "Đăng nhập thất bại";
            };
        }, errorStatus));
    }

    public boolean loginHandler(){
        String userName = this.userName.getValue();
        String password = this.password.getValue();
        Account account = AuthService.validAccount(userName, password).orElse(null);
        if (account == null){
            errorStatus.set(LoginResult.LOGIN_FAILED);
            return false;
        }
        errorStatus.set(null);
        return true;
    }

}
