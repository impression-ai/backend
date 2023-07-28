package com.example.backend.s3;

import com.example.backend.s3.dto.ImageRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class S3Controller {
    private final S3Service s3Service;

    @PostMapping("/images")
    public ResponseEntity<?> uploadImage(ImageRequestDto imageRequestDto) throws Exception {

        return new ResponseEntity<>(s3Service.upload(imageRequestDto.getImage(), "image") + " 업로드 성공", HttpStatus.OK);
    }
}
