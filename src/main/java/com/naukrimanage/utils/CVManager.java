package com.naukrimanage.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class CVManager {

    private String outputFile = System.getProperty("user.dir")+File.separator+"CV"+File.separator+"resume";   //"D:\\downloads\\resume.docx";

    public String downloadCV() {

        String extension = ".bin";
        String fileUrl = Configurations.properties.getProperty("ResumeDownloadUrl");
        System.out.println("The url form which CV is going to be downlaoded is: "+fileUrl);

        try {
            
            URL url = new URL(fileUrl);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.connect();
            
            if (conn.getResponseCode() != 200) {
                throw new RuntimeException("HTTP error: " + conn.getResponseCode());
            }
            String contentType = conn.getContentType();
            if (contentType != null) {
                contentType = contentType.split(";")[0].trim();
            }

            if (contentType.equals("application/pdf")) {
                extension = ".pdf";
            } else if (contentType.equals("application/vnd.openxmlformats-officedocument.wordprocessingml.document")) {
                extension = ".docx";
            }

            outputFile = outputFile+extension;
            File CVFile = new File(outputFile);

            File parentDir = CVFile.getParentFile();
            if (parentDir != null && !parentDir.exists()) {
                parentDir.mkdirs(); // creates all missing dirs
            }

            try (InputStream in = conn.getInputStream();
                 FileOutputStream out = new FileOutputStream(outputFile)) {

                byte[] buffer = new byte[8192];
                int bytesRead;

                while ((bytesRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesRead);
                }
            }

            System.out.println("Download completed");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return outputFile;
    }
}
