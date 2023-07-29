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
    private String fileName;
    private String content;
    private boolean isShareLink;

    public JudgeBotResponseDto(JudgeBot judgeBot){
        this.id = judgeBot.getId();
        this.fileName = judgeBot.getFileName();
        this.content = judgeBot.getContent();
        this.isShareLink = judgeBot.isShareLink();
    }
}
