import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse.BodyHandlers;

class ServerTest {
    @Test
    void start() throws IOException, InterruptedException {
        Server.start();
        var client = HttpClient.newHttpClient();
        var request = HttpRequest.newBuilder(URI.create("http://localhost:8888")).build();
        var response = client.send(request, BodyHandlers.ofString());
        Assertions.assertEquals(200, response.statusCode());
        Assertions.assertEquals("Hello from HAI MP23", response.body());
    }
}