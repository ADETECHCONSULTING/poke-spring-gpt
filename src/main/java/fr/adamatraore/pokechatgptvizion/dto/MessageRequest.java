package fr.adamatraore.pokechatgptvizion.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class MessageRequest {
    private String model;
    private List<Message> messages;

    public MessageRequest(String model, String prompt) {
        this.model = model;
        this.messages = new ArrayList<>();
        this.messages.add(new Message("user", prompt));
    }
}
