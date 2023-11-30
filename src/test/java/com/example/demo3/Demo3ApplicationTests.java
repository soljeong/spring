package com.example.demo3;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo3.question.QuestionService;

@SpringBootTest
class Demo3ApplicationTests {

	@Autowired
    private QuestionService questionService;

	@Test
    void testJpa11() {
        for (int i = 1; i <= 300; i++) {
            String subject = String.format("테스트 데이터입니다:[%03d]", i);
            String content = "내용무";
            this.questionService.create(subject, content);
        }
	}

}
