package com.learnkorealanguage.app.constant;

import lombok.Getter;

@Getter
public enum ViewPath {
    AUTH("/com/learnkorealanguage/app/views/layout/auth/Auth.fxml"),
    LOGIN("/com/learnkorealanguage/app/views/layout/auth/Login.fxml"),
    REGISTER("/com/learnkorealanguage/app/views/layout/auth/Register.fxml"),
    HOME("/com/learnkorealanguage/app/views/layout/home/Home.fxml"),
    VOCABULARY("/com/learnkorealanguage/app/views/layout/vocabulary/Vocabulary.fxml");
    private final String path;
    ViewPath(String path) {
        this.path = path;
    }
}
