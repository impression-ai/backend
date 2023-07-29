package com.example.backend.util;

import com.example.backend.judgebot.JudgeBot;
import com.example.backend.judgebot.JudgeBotRepository;
import com.example.backend.judgebot.dto.JudgeBotResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class JudgeBotService {
    final JudgeBotRepository judgeBotRepository;

    @Transactional
    public ResponseEntity<?> insertJudgeBot(String content, String fileName) {
        JudgeBot judgeBot = JudgeBot.builder()
                .content(content)
                .fileName("https://aws-reko-bucket.s3.ap-northeast-2.amazonaws.com/" + fileName)
                .build();

        judgeBotRepository.save(judgeBot);

        return new ResponseEntity<>("분석이 완료되었습니다.", HttpStatus.OK);
    }

    @Transactional(readOnly = true)
    public ResponseEntity<?> getJudgeBot(Long id) {

        JudgeBot judgeBot = judgeBotRepository.findById(id).orElseThrow(() ->
                new NullPointerException("해당 데이터를 찾을 수 없습니다."));

        JudgeBotResponseDto judgeBotResponseDto = new JudgeBotResponseDto(judgeBot);
        return new ResponseEntity<>(judgeBotResponseDto, HttpStatus.OK);
    }
}
