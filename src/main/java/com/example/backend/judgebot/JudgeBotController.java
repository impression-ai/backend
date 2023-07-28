package com.example.backend.judgebot;

import com.example.backend.util.RekognitionService;
import com.example.backend.util.S3Service;
import com.example.backend.judgebot.dto.ImageRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class JudgeBotController {
    private final S3Service s3Service;
    private final RekognitionService rekognitionService;

    @PostMapping("/images")
    public ResponseEntity<?> uploadImage(ImageRequestDto imageRequestDto) throws Exception {

        String fileName = s3Service.upload(imageRequestDto.getImage(), "image");

        return rekognitionService.sendImageToRekognition(fileName);
    }
}
