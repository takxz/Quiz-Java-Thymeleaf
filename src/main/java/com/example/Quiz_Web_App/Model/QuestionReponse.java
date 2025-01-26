package com.example.Quiz_Web_App.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class QuestionReponse {

    private String question;
    private String[] reponses;
    private Integer bonneReponse;

}


