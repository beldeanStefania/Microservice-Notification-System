package io.github.beldeanStefania.splunk;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class SplunkHecClient {
    private final String url;
    private final String token;
    private final HttpClient client = HttpClient.newHttpClient();

    public SplunkHecClient(String url, String token) {
        this.url = url;
        this.token = token;
    }

    public void send(String event) {
        try {
            String payload = "{\"event\":\"" + event + "\"}";
            HttpRequest req = HttpRequest.newBuilder(URI.create(url))
                    .header("Authorization", "Splunk " + token)
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(payload))
                    .build();
            client.send(req, HttpResponse.BodyHandlers.ofString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
