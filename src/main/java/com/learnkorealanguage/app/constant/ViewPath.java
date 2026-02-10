package com.learnkorealanguage.app.constant;

import lombok.Getter;

@Getter
public enum ViewPath {
    LOGIN("/com/learnkorealanguage/app/views/layout/auth/login.fxml"),
    HOME("/com/learnkorealanguage/app/views/layout/home/home.fxml"),
    VOCABULARY("/com/learnkorealanguage/app/views/layout/vocabulary/vocabulary.fxml");
    private final String path;
    ViewPath(String path) {
        this.path = path;
    }
}
