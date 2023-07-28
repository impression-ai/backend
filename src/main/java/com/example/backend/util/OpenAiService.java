package com.example.backend.util;

import com.amazonaws.services.rekognition.model.FaceDetail;
import com.example.backend.judgebot.dto.ChatRequestDto;
import com.example.backend.judgebot.dto.ChatResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OpenAiService {

    private final RestTemplate restTemplate;

    @Value("${openai.model}")
    private String model;

    @Value("${openai.api.url}")
    private String apiUrl;

    public Object sendToOpenAi(String prompt) {

        ChatRequestDto requestDto = new ChatRequestDto(model, prompt);

        ChatResponseDto responseDto = restTemplate.postForObject(apiUrl, requestDto, ChatResponseDto.class);

        if (responseDto == null || responseDto.getChoices() == null || responseDto.getChoices().isEmpty()) {
            return "No response";
        }

        System.out.println(responseDto.getUsage().getTotal_tokens());

        return responseDto.getChoices().get(0).getMessage().getContent();
    }
}
