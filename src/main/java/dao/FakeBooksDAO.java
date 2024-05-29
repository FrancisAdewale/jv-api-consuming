package dao;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.BookData;
import model.Data;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

public class FakeBooksDAO {

    public static final String BASE_URL = "https://fakerapi.it/api/v1/books";
    public static final String QUERY_PARAM = "_quantity";
    public static final String QUANTITY = "10";
    public static Data data;

    public static Data getBooks() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(BASE_URL +"?" + QUERY_PARAM +"=" + QUANTITY))
                    .GET()
                    .build();
            mapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

          var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            data = mapper.readValue(response.body(), Data.class);

        } catch (URISyntaxException | IOException  | InterruptedException e) {
            e.getMessage();
        }

        return data;
    }


}
