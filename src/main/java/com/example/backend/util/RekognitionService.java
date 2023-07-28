package com.example.backend.util;

import com.amazonaws.services.rekognition.AmazonRekognition;
import com.amazonaws.services.rekognition.AmazonRekognitionClientBuilder;
import com.amazonaws.services.rekognition.model.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RekognitionService {

    private final AmazonRekognition amazonRekognition = AmazonRekognitionClientBuilder.standard().withRegion("ap-northeast-2").build();

    public List<FaceDetail> sendImageToRekognition(String fileName) {

        DetectFacesRequest request = new DetectFacesRequest()
                .withImage(new Image()
                        .withS3Object(new S3Object()
                                .withName(fileName).withBucket("aws-reko-bucket")))
                .withAttributes(Attribute.ALL);

        List<FaceDetail> faces = null;

        try {
            DetectFacesResult result = amazonRekognition.detectFaces(request);
            faces = result.getFaceDetails();

            System.out.println("Detected faces for " + fileName);

        } catch (AmazonRekognitionException e) {
            e.printStackTrace();
        }

        return faces;
    }
}
