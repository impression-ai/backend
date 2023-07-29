package com.example.backend.judgebot;
import javax.persistence.*;

import com.example.backend.judgebot.dto.ChatResponseDto;
import com.example.backend.judgebot.dto.IsShareRequestDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class JudgeBot {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 500)
    private String fileName;

    @Column(length = 50000)
    private String content;

    @Column
    private boolean isShareLink;

    public void updateShare(IsShareRequestDto isShareRequestDto){this.isShareLink= isShareRequestDto.isShareLink();}


}
