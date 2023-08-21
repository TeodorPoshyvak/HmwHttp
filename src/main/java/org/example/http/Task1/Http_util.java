package org.example.http.Task1;
import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Http_util {
    final static HttpClient CLIENT = HttpClient.newHttpClient();
    final static Gson GSON = new Gson();

    public Object getAllRequest() throws IOException, InterruptedException {
        URL url = new URL("https://jsonplaceholder.typicode.com/users");
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(String.valueOf(url)))
                .GET()
                .build();

        HttpResponse httpResponse = CLIENT.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        return httpResponse.body();
    }

    public Object getIdRequest(int id) throws IOException, InterruptedException {
        URL url = new URL(String.format("https://jsonplaceholder.typicode.com/users/%s", id));
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(String.valueOf(url)))
                .GET()
                .build();

        HttpResponse httpResponse = CLIENT.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        return httpResponse.body();
    }

    public Object getNameRequest(String name) throws IOException, InterruptedException {
        URL url = new URL(String.format("https://jsonplaceholder.typicode.com/users?username=%s", name));
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(String.valueOf(url)))
                .GET()
                .build();

        HttpResponse httpResponse = CLIENT.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        return httpResponse.body();
    }

    public Object postRequest(User user) throws IOException, InterruptedException {
        String json = GSON.toJson(user);
        URL url = new URL("https://jsonplaceholder.typicode.com/users");
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(String.valueOf(url)))
                .header("Content-Type", "application/json")
                .POST(HttpRequest.BodyPublishers.ofString(json))
                .build();

        HttpResponse<String> httpResponse = CLIENT.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        return GSON.fromJson(httpResponse.body(), User.class);
    }


    public Object putRequest(User user) throws IOException, InterruptedException {
        String json = GSON.toJson(user);
        URL url = new URL("https://jsonplaceholder.typicode.com/users/" + user.getId());
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(String.valueOf(url)))
                .header("Content-Type", "application/json")
                .PUT(HttpRequest.BodyPublishers.ofString(json))
                .build();

        HttpResponse<String> httpResponse = CLIENT.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        return GSON.fromJson(httpResponse.body(), User.class);
    }

    public Object deleteRequest(int id) throws IOException, InterruptedException {
        URL url = new URL(String.format("https://jsonplaceholder.typicode.com/users/%s", id));
        HttpRequest httpRequest = HttpRequest.newBuilder()
                .uri(URI.create(String.valueOf(url)))
                .DELETE()
                .build();

        HttpResponse httpResponse = CLIENT.send(httpRequest, HttpResponse.BodyHandlers.ofString());
        return httpResponse.body();
    }
}
