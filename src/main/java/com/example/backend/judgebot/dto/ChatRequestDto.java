package com.example.backend.judgebot.dto;

import com.amazonaws.services.rekognition.model.FaceDetail;
import com.example.backend.judgebot.Message;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
public class ChatRequestDto {

    private String model;
    private List<Message> messages;
    private int n;
    private double temperature;

    public ChatRequestDto(String model, String prompt) {

        this.model = model;
        this.messages = new ArrayList<>();
        this.messages.add(new Message("user", prompt));
        this.temperature = 1;
        this.n = 3;
    }
}
