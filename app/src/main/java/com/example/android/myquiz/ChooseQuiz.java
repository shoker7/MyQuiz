package com.example.android.myquiz;

import java.util.ArrayList;

class ChooseQuiz {

     private ArrayList<String> list = new ArrayList<>();

     ChooseQuiz(String question,
                String answerOne, String answerOneTF,
                String answerTwo, String answerTwoTF,
                String answerThree, String answerThreeTF,
                String answerFour, String answerFourTF,
                String answerFive, String answerFiveTF
               ){
         list.add(question);
         list.add(answerOne);
         list.add(answerOneTF);
         list.add(answerTwo);
         list.add(answerTwoTF);
         list.add(answerThree);
         list.add(answerThreeTF);
         list.add(answerFour);
         list.add(answerFourTF);
         list.add(answerFive);
         list.add(answerFiveTF);

     }

     ArrayList<String> getCheckQuiz(){
         return list;
     }
}
