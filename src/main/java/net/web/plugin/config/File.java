package net.web.plugin.config;

import net.web.plugin.http.website.Website;

import java.io.*;
import java.util.Properties;

import static net.web.plugin.config.FirstTime.fst;

public class File {
    public static int port = 8001;

    public static boolean homepage =  false;
    //public static String maplink = "replace this with your ip";

    public static void main() {
        try {

            try {
                java.io.File f = new java.io.File("config/web.config");
                if(f.exists() && f.isFile()) {
                    FileReader reader=new FileReader("config/web.config");

                    Properties prop=new Properties();
                    prop.load(reader);
                    Integer port = Integer.parseInt(prop.getProperty("port"));
                    boolean homepage = Boolean.parseBoolean(prop.getProperty("custom-homepage"));
                    //String maplink = prop.getProperty("maplink");
                    try {
                        Website.main(port, homepage);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }else{
                    fst();
                    try {
                        Website.main(port, homepage);
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }
            } catch (RuntimeException e) {
                throw new RuntimeException(e);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
