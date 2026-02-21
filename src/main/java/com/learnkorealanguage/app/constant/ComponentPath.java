package com.learnkorealanguage.app.constant;

import lombok.Getter;

@Getter
public enum ComponentPath {
    CustomInput("/com/learnkorealanguage/app/views/components/CustomInput.fxml");
    private final String path;
    ComponentPath(String  path){
        this.path = path;
    }
}
