package com.learnkorealanguage.app.viewmodel;


import com.learnkorealanguage.app.model.Account;
import com.learnkorealanguage.app.service.AuthService;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import lombok.Getter;

@Getter
public class LoginViewModel {

    private final StringProperty userName = new SimpleStringProperty("");
    private final StringProperty password = new SimpleStringProperty("");
    private final StringProperty errorMessage = new SimpleStringProperty("");

    public boolean loginHandler(){
        String userName = this.userName.getValue();
        String password = this.password.getValue();
        Account account = AuthService.validAccount(userName, password).orElse(null);
        if (account == null){
            errorMessage.setValue("Tên đăng nhập hoặc mật khẩu không đúng");
            return false;
        }
        return true;
    }

}
