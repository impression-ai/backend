package com.example.backend.judgebot;

import com.amazonaws.services.rekognition.model.Face;
import com.amazonaws.services.rekognition.model.FaceDetail;
import com.example.backend.util.OpenAiService;
import com.example.backend.util.RekognitionService;
import com.example.backend.util.S3Service;
import com.example.backend.judgebot.dto.ImageRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class JudgeBotController {
    private final S3Service s3Service;
    private final RekognitionService rekognitionService;
    private final OpenAiService openAiService;

    @PostMapping("/images")
    public ResponseEntity<?> uploadImage(ImageRequestDto imageRequestDto) throws Exception {

        String fileName = s3Service.upload(imageRequestDto.getImage(), "image");

        List<FaceDetail> faceDetails = rekognitionService.sendImageToRekognition(fileName);
        System.out.println(faceDetails.toString() + "\n 이 데이터를 가지고 첫인상에 대한 글을 한글로 작성해줘 ");

        return new ResponseEntity<>(openAiService.sendToOpenAi(faceDetails.toString()) + "\n 이 데이터를 가지고 첫인상에 대한 글을 한글로 작성해줘 ", HttpStatus.OK);
    }
}
