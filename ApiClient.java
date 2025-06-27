  import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiClient {

    private static final String BASE_URL = "https://gutendex.com/books/";

    private HttpClient client;

    public ApiClient() {
        this.client = HttpClient.newHttpClient(); 

    public String buscarLivros(String query) throws IOException, InterruptedException {
        
        String url = BASE_URL + "?search=" + query;

       
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(url))       
                .header("Accept", "application/json") 
                .GET()                      
                .build();

      
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        
        System.out.println("Status Code: " + response.statusCode());
        System.out.println("Cabeçalhos: " + response.headers());

        
        return response.body();
    }
}


