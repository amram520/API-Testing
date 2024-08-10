package org.utils;

import lombok.SneakyThrows;
import lombok.val;

import java.io.*;
import java.util.Scanner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ResourceUtils {

    private static class Empty {

    }

    private String resourceToString2(final String resourceName) throws IOException {
        try (Scanner s = new Scanner(getClass().getClassLoader().getResourceAsStream(resourceName))){
            s.useDelimiter("\\A");
            return s.hasNext() ? s.next() : "";
        }
    }

    @SneakyThrows
    public static String resourceToString(final String resourceName) {
        val classLoader = new Empty().getClass().getClassLoader();
        assertThat(classLoader).isNotNull();
        val resourceStream = classLoader.getResourceAsStream(resourceName);
        assertThat(resourceStream).isNotNull();
        try (Scanner s = new Scanner(resourceStream)){
            s.useDelimiter("\\A");
            return s.hasNext() ? s.next() : "";
        }
    }

    public static void main(String[] args) throws Exception{
        String body = new ResourceUtils().resourceToString2("Payload/userRequest.json");
        System.out.println(body);
    }

    private static boolean resourceToBinaryFile(String resourceName, String targetDirectory, Object resource)
            throws Exception {
        boolean found = false;
        if (null == resourceName) {
            return found;
        }
        try (InputStream is = resource.getClass().getResourceAsStream(resourceName);
             BufferedReader br = new BufferedReader(new InputStreamReader(is));
             FileOutputStream fos = new FileOutputStream(targetDirectory + File.separator
                     + resourceName.substring(resourceName.lastIndexOf('/'), resourceName.length()))) {
            byte[] buffer = new byte[1024];
            int bytesRead;

            while ((bytesRead = is.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            fos.flush();
            found = true;
        }
        return found;
    }
}
