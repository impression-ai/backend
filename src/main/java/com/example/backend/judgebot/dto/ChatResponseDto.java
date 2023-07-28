package com.example.backend.judgebot.dto;

import com.example.backend.judgebot.Message;
import com.example.backend.judgebot.Usage;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ChatResponseDto {

    private List<Choice> choices;
    private int created;
    private String id;
    private String model;
    private String object;
    private Usage usage;

    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Choice {

        private int index;
        private Message message;
    }
}
