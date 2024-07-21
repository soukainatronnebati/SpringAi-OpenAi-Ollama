package net.tronnebati.springairag;

import jakarta.activation.MimeType;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.messages.Media;
import org.springframework.ai.chat.messages.UserMessage;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.ai.openai.api.OpenAiImageApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.util.MimeTypeUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;
import reactor.core.publisher.Flux;

import java.awt.*;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Map;

@RestController
public class ChatRestController {

    private ChatClient chatClient;

    @Value("classpath:/prompts/system-message.st")
    private Resource systemMessageResource;

    @Value("classpath:/depences.png")
    private Resource image;

    public ChatRestController(ChatClient.Builder builder) {
        this.chatClient = builder.build();
    }
    @GetMapping(value = "/chat",produces = MediaType.TEXT_PLAIN_VALUE)
    public String chat(String question) {
        String content = chatClient.prompt()
                .system("")
                .user(question)
                .call()
                .content();
        return content;
    }
    @GetMapping(value = "/chat2",produces = MediaType.TEXT_PLAIN_VALUE)
    public Flux<String> chat2(String question) {
        Flux<String> content = chatClient.prompt()
                .system("")
                .user(question)
                .stream().content();

        return content;
    }

    @GetMapping(value = "/sentiment")
    public Sentiment sentiment(String review) {
        return  chatClient.prompt()
                .system(systemMessageResource)
                .user(review)
                .call().entity(Sentiment.class);
    }

    @GetMapping("/describe")
    public String depenses() throws IOException {

        byte[] data = new ClassPathResource("depences.png").getContentAsByteArray();
        String userMessageText = """
                Ton role est de faire la reconnaissance optique du texte
                qui se trouve dans l'image fournie
                
                    
                    
                """;
        UserMessage userMessage = new UserMessage(userMessageText, List.of(
           new Media(MimeTypeUtils.IMAGE_JPEG,data)
        ));
        Prompt prompt = new Prompt(userMessage);
        return chatClient.prompt(prompt).call().content();
    }
    /*@GetMapping(path="/generatrImageSD",produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] generateImageSD()  {
        RestClient restClient = RestClient.create();
        Map<String, Object> result = restClient.post()
                .uri("http://127.0.0.1:7868/sdapi/v1/txt2img")
                .body(Map.of("prompt","un chat avec un costume dans une fete avec un café dans sa main droite"))
                .retrieve()
                .body(Map.class);

        String image = ((List<String>) result.get("images")).get(0);
        byte[] decode = Base64.getDecoder().decode(image);
        return decode;

    }*/



    @GetMapping(path="/generatrImageDALL",produces = MediaType.IMAGE_PNG_VALUE)
    public byte[] generateImageDALLE() throws IOException {
        OpenAiImageApi openAiApi = new OpenAiImageApi("");
        OpenAiImageModel openAiImageModel = new OpenAiImageModel(openAiApi);
        ImageResponse response = openAiImageModel.call(
                new ImagePrompt("une bébé fille avec une robe de mariage a coté de grand piscine  avec un bouquet de fleur  dans sa main droite",
                OpenAiImageOptions.builder()
                        .withModel("dall-e-3")
                        .withQuality("hd")
                        .withN(1)
                        .withResponseFormat("b64_json")
                        .withHeight(1024)
                        .withWidth(1024).build())
        );
        String image = response.getResult().getOutput().getB64Json();
        byte[] decode = Base64.getDecoder().decode(image);
        return decode;
    }
}
