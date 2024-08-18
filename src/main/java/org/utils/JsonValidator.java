package org.utils;

import java.io.InputStream;

public class JsonValidator {

    // create inputStreamFromClasspath() method to load the JSON data from the class path
    public static InputStream inputStreamFromClasspath(String path) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(path);
        return inputStream;
    }
}
