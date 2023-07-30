package com.example.backend.judgebot.dto;

import com.example.backend.judgebot.JudgeBot;
import com.example.backend.judgebot.Message;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
@Getter
@NoArgsConstructor
public class JudgeBotResponseDto {
    private Long id;
    private String image;
    private String content;
    private boolean isShared;

    public JudgeBotResponseDto(JudgeBot judgeBot, boolean isShared){
        this.id = judgeBot.getId();
        this.image = judgeBot.getImage();
        this.content = judgeBot.getContent();
        this.isShared = isShared;
    }
}
