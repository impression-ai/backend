package com.example.backend.judgebot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class IsShareRequestDto {
    private Long id;
    private boolean isShareLink;
}
