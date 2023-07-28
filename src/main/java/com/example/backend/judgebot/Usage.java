package com.example.backend.judgebot;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Usage {

    private int completion_tokens;
    private int prompt_tokens;
    private int total_tokens;
}
