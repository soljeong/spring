package com.example.demo3;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

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

	@Test
    void testJpa2() {
        Optional<Question> oq = this.questionRepository.findById(1);
        if(oq.isPresent()) {
            Question q = oq.get();
            assertEquals("sbb가 무엇인가요?", q.getSubject());
        }
    }

	@Test
    void testJpa3() {
        Question q = this.questionRepository.findBySubject("sbb가 무엇인가요?");
        assertEquals(1, q.getId());
    }

	@Test
    void testJpa4() {
        Question q = this.questionRepository.findBySubjectAndContent(
                "sbb가 무엇인가요?", "sbb에 대해서 알고 싶습니다.");
        assertEquals(1, q.getId());
    }

	@Test
    void testJpa5() {
        List<Question> qList = this.questionRepository.findBySubjectLike("sbb%");
        Question q = qList.get(0);
        assertEquals("sbb가 무엇인가요?", q.getSubject());
    }

    @Test
    void testJpa6() {
        Optional<Question> oq = this.questionRepository.findById(1);
        assertTrue(oq.isPresent());
        Question q = oq.get();
        q.setSubject("수정된 제목");
        this.questionRepository.save(q);
    }

	@Test
    void testJpa7() {
        assertEquals(2, this.questionRepository.count());
        Optional<Question> oq = this.questionRepository.findById(1);
        assertTrue(oq.isPresent());
        Question q = oq.get();
        this.questionRepository.delete(q);
        assertEquals(1, this.questionRepository.count());
    }
	

}
