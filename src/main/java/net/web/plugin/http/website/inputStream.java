package net.web.plugin.http.website;

import net.web.plugin.main;

import java.io.*;

public class inputStream {

    public static byte[] mainHtmlFile;
    public static byte[] aboutHtmlFile;
    public static byte[] mapHtmlFile;

    public static void main() {

        InputStream is = inputStream.class.getClassLoader().getResourceAsStream("html/main.html");
        try {
            mainHtmlFile = is.readAllBytes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        try {
            new File("config/html").mkdirs();
            File file = new File("config/html/about_us.html");
            if (!file.exists()) {
                file.createNewFile();
            }
            InputStream is2 = new FileInputStream(file);
            aboutHtmlFile = is2.readAllBytes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        File file = new File("config/html/map.html");
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            FileWriter myWriter = null;
            try {
                myWriter = new FileWriter("config/html/map.html");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                myWriter.write("<html><meta http-equiv=\"refresh\" content=\"1; URL=REPLACE-WITH-MAP-WEBSITE\" /><html>");
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            try {
                myWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        InputStream is3 = null;
        try {
            is3 = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        try {
            mapHtmlFile = is3.readAllBytes();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
