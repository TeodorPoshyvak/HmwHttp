package org.example.http.Task2;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpUtil {
    final static HttpClient CLIENT = HttpClient.newHttpClient();

    public Object getPosts(int id) throws IOException, InterruptedException {
        URL url = new URL(String.format("https://jsonplaceholder.typicode.com/users/%s/posts", id));
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(String.valueOf(url)))
                .GET()
                .build();

        HttpResponse httpResponse = CLIENT.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        return httpResponse.body();
    }

    public Object getComment(int idComments) throws IOException, InterruptedException {
        URL url = new URL(String.format("https://jsonplaceholder.typicode.com/posts/%s/comments", idComments));
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(String.valueOf(url)))
                .GET()
                .build();

        HttpResponse httpResponse = CLIENT.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        return httpResponse.body();

    }
}
