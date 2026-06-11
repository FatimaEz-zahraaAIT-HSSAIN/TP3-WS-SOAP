package org.example;

import ws.BanqueService;
import javax.xml.ws.Endpoint;

public class ServeurJWS {
    public static void main(String[] args) {
        String url = "http://0.0.0.0:9191/";
        Endpoint.publish(url, new BanqueService());
        System.out.println("Web service déployé et en écoute sur : " + url);
    }
}