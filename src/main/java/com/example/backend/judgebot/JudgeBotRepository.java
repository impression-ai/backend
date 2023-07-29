package com.example.backend.judgebot;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JudgeBotRepository extends JpaRepository<JudgeBot, Long> {
        Optional<JudgeBot> findAllById(Long id);
}
