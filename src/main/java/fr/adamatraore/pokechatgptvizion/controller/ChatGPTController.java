package fr.adamatraore.pokechatgptvizion.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import fr.adamatraore.pokechatgptvizion.dto.MessageRequest;
import fr.adamatraore.pokechatgptvizion.dto.MessageResponse;

@RestController
@RequestMapping("/gpt")
public class ChatGPTController {
    
    @Value("${openai.model}")
    private String model;
    
    @Value("${openai.api.url}")
    private String apiUrl;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/chat")
    public String promptGPT(@RequestParam("prompt") String prompt) {
        MessageRequest messageRequest = new MessageRequest("gpt-3.5-turbo-0613", prompt);
        MessageResponse response = restTemplate.postForObject(apiUrl, messageRequest, MessageResponse.class);
        return response.getChoices().get(0).getMessage().getContent();
    }
}
