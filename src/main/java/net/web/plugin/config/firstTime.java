package net.web.plugin.config;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public class firstTime {
    public static void fst() {
        Properties prop = new Properties();
        prop.setProperty("port", "8001");
        prop.setProperty("map", "false");
        prop.setProperty("maplink", "replace this with your ip");
        try {
            prop.store(new FileOutputStream("web.config"), null);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
