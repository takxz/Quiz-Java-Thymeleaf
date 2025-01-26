package com.example.Quiz_Web_App;

import com.example.Quiz_Web_App.Model.QuestionReponse;
import com.example.Quiz_Web_App.Model.Quiz;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class QuizWebAppApplicationTests {

	@Test
	void laPremiereQuestionEstUneBonneReponse() {
		Quiz quiz = new Quiz();
		quiz.checkAnswer(1);
		assertEquals(1, quiz.getScore());
	}

	@Test
	void laPremiereQuestionEstUneMauvaiseReponse(){
		Quiz quiz = new Quiz();
		quiz.checkAnswer(0);
		assertEquals(0, quiz.getScore());
	}
}
