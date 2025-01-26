package com.example.Quiz_Web_App.Quiz;


import com.example.Quiz_Web_App.Model.Quiz;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class QuizController {

    private final Quiz quiz = new Quiz();

    @GetMapping("/quiz")
    public String index (Model model){
        model.addAttribute("question", quiz.getCurrentQuestion());
        model.addAttribute("score", quiz.getScore());
        return "quiz";
    }

    @PostMapping("/submit")
    public String reponse(@RequestParam("choice") Integer choice, Model model){
        quiz.checkAnswer(choice);
        if (quiz.hasNextQuestion()){
            model.addAttribute("question", quiz.getNextQuestion());
            model.addAttribute("score", quiz.getScore());
            return "quiz";
        } else {
            model.addAttribute("message", "Bravo, votre score est : " + quiz.getScore());
            quiz.resetQuestion();
            return "result";
        }
    }
}
