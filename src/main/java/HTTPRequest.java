import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

//3. Вывести только заголовки запроса в виде списка значений через
//   запятую (запрос выполняется по адресу “https://httpbin.org/headers”).

public class HTTPRequest {
    public static void headerRequest(){
        HttpClient client = HttpClient.newHttpClient();
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://httpbin.org/headers"))
                    .build();
            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());

            JsonNode tree = new ObjectMapper().readTree(response.body());
            List<String> resultList = new ArrayList<>();
            for (Iterator<Map.Entry<String, JsonNode>> it = tree.get("headers").fields(); it.hasNext(); ) {
                var c = it.next();
                resultList.add(c.getValue().toString());

            }
            System.out.print(String.join(", ", resultList));
        } catch (RuntimeException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
