package com.learnkorealanguage.app.util;

import java.nio.file.*;


public class FactoryDirForLinux implements FactoryDirOS{

    @Override
    public void createDirOfOS() throws GlobalException {
        try {
            String DIR_XML_FILES_RESPONSE = "~/.local/languageapp/reponse";
            Path dirPath = Paths.get(DIR_XML_FILES_RESPONSE);
            Files.createDirectories(dirPath);
        } catch (Exception ioe){
            throw new GlobalException(ioe.getMessage());
        }
    }
}