package com.example.Quiz_Web_App.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor

public class Quiz {

    private List<QuestionReponse> questionList = new ArrayList<>();
    private Integer score = 0;
    private Integer currentIndexQuestion = 0;


    public Quiz(){
        questionList.add(new QuestionReponse("Quel est l'élément chimique dont le symbole est Au ?", new String[]{"Argon", "Or", "Uranium"}, 1));
        questionList.add(new QuestionReponse("Qui a écrit 'Les Misérables' ?", new String[]{"Victor Hugo", "Emile Zola", "Marcel Proust"}, 0));
        questionList.add(new QuestionReponse("Quelle est la racine carrée de 144 ?", new String[]{"10", "12", "14"}, 1));
        questionList.add(new QuestionReponse("Quel est le résultat de 25 ÷ 5 × 2 ?", new String[]{"5", "10", "15"}, 1));
        questionList.add(new QuestionReponse("En quelle année l'homme a-t-il marché sur la Lune pour la première fois ?", new String[]{"1965", "1969", "1972"}, 1));
        questionList.add(new QuestionReponse("Quel est le plus grand océan du monde ?", new String[]{"Océan Atlantique", "Océan Indien", "Océan Pacifique"}, 2));
    }

    //On récupère la question actuelle

    public QuestionReponse getCurrentQuestion(){
        return questionList.get(currentIndexQuestion);
    }

    //On vérifie s'il y a une prochaine question

    public boolean hasNextQuestion(){
        return currentIndexQuestion < questionList.size() - 1;
    }

    //On récupère la question suivante s'il y a encore une question

    public QuestionReponse getNextQuestion(){
        if (hasNextQuestion()){
            currentIndexQuestion++;
        }
        return questionList.get(currentIndexQuestion);
    }

    //On vérifie la réponse
    public void checkAnswer(Integer choice){
        if (questionList.get(currentIndexQuestion).getBonneReponse().equals(choice)){
            score++;
        }
    }

    //On reset les index et score pour recommencer le quiz
    public void resetQuestion(){
        currentIndexQuestion = 0;
        score = 0;
    }
}

