package host_Server_Spring;


import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ChatService {

    private final String apiKey = "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"; // Замените на свой ключ API

    public String chatWithGPT(String userMessage) {
        String url = "https://api.openai.com/v1/engines/davinci/completions";

        RestTemplate restTemplate = new RestTemplate();
        String request = "{\"prompt\":\"" + userMessage + "\",\"max_tokens\":50}";

        String response = restTemplate.postForObject(url, request, String.class);

        return response;
    }
}