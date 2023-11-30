package com.example.demo3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class Demo3ApplicationTests {

	@Autowired
	private QuestionRepository questionRepository;

	@Test
	void contextLoads() {
	}

	@Test
	void testJpa() {
        List<Question> all = this.questionRepository.findAll();
        assertEquals(2, all.size());
		// 데이터 사이즈가 2인지 확인하기 위해

        Question q = all.get(0);
        assertEquals("sbb가 무엇인가요?", q.getSubject());
	}

}
