package com.example.spring_boilerplate_stater.utils;


import java.util.Locale;

public class ProjectConstants {
   
    public static final String DEFAULT_ENCODING = "UTF-8";

    public static final Locale INDONESIA_LOCALE = new Locale.Builder().setLanguage("id").setRegion("ID").build();

    private ProjectConstants() {
        throw new UnsupportedOperationException();
    }
}
