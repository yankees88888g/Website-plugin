package net.web.plugin.http.website;

import com.sun.net.httpserver.HttpContext;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;

import static net.web.plugin.http.website.inputStream.*;

public class website {

    public static void main(int port) throws IOException {
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        HttpContext context = server.createContext("/");
        context.setHandler(website::handleRequest);

        HttpContext context_about = server.createContext("/about_us");
        context_about.setHandler(website::handleAbout);

        HttpContext context_map = server.createContext("/map");
        context_map.setHandler(website::handleMap);
        //to be able to configurable with dynamp and other map mods to redirect to here.

        server.start();
    }

    private static void handleRequest(HttpExchange exchange) throws IOException {

        exchange.sendResponseHeaders(200, mainHtmlFile.length);
        OutputStream os = exchange.getResponseBody();
        os.write(mainHtmlFile);
        os.close();
    }

    private static void handleAbout(HttpExchange exchange) throws IOException {
        exchange.sendResponseHeaders(200, aboutHtmlFile.length);
        OutputStream os = exchange.getResponseBody();
        os.write(aboutHtmlFile);
        os.close();
    }

    private static void handleMap(HttpExchange exchange) throws IOException {
        exchange.sendResponseHeaders(200, mapHtmlFile.length);
        OutputStream os = exchange.getResponseBody();
        os.write(mapHtmlFile);
        os.close();
    }
}