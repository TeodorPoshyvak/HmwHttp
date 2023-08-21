package org.example.http.Task3;

import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpUtil {
    final static HttpClient CLIENT = HttpClient.newHttpClient();

    public Object getTaskTrue(int id) throws IOException, InterruptedException {
        URL url = new URL(String.format("https://jsonplaceholder.typicode.com/users/%s/todos", id));
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(String.valueOf(url)))
                .GET()
                .build();

        HttpResponse httpResponse = CLIENT.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        return httpResponse.body();
    }

}
